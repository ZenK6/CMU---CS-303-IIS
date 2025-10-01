package NguyenNKhoiNguyenCS301;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PersonDAO {

    private final ArrayList<Person> personList;

    public PersonDAO() {
        this.personList = new ArrayList<>();
        loadAllPersonsFromDB();
    }

    public boolean addPerson(Person person) {
        if (findPersonById(person.getId()) != null) {
            return false;
        }

        String sql = "";

        if (person instanceof Student s) {
            sql = "INSERT INTO Persons (id, name, DOBirth, PersonType, GPA, tuitionFee, nOClasses, baseSalary) VALUES (?, ?, ?, 'Student', ?, ?, NULL, NULL)";
        } else if (person instanceof Teacher t) {
            sql = "INSERT INTO Persons (id, name, DOBirth, PersonType, GPA, tuitionFee, nOClasses, baseSalary) VALUES (?, ?, ?, 'Teacher', NULL, NULL, ?, ?)";
        } else {
            return false;
        }

        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, person.getId());
            ps.setString(2, person.getName());
            ps.setDate(3, new java.sql.Date(person.getDOBirth().getTime()));

            if (person instanceof Student s) {
                ps.setDouble(4, s.getGpa());
                ps.setDouble(5, s.getTuitionFee());
            } else if (person instanceof Teacher t) {
                ps.setInt(4, t.getNOClasses());
                ps.setDouble(5, t.getBaseSalary());
            }

            if (ps.executeUpdate() > 0) {
                this.personList.add(person);
                return true;
            }
            return false;

        } catch (SQLException e) {
            System.err.println("Error adding person to DB: " + e.getMessage());
            return false;
        }
    }

    public List<Person> getPersonList() {
        return this.personList;
    }

    public Person findPersonById(String id) {
        for (Person p : personList) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }

    private void loadAllPersonsFromDB() {
        this.personList.clear();
        String sql = "SELECT id, name, DOBirth, PersonType, gpa, tuitionFee, nOClasses, baseSalary FROM Persons";

        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                Date dob = rs.getDate("DOBirth");
                String type = rs.getString("PersonType");

                Person person;

                if ("Student".equalsIgnoreCase(type)) {
                    double gpa = rs.getDouble("GPA");
                    double tuitionFee = rs.getDouble("TuitionFee");
                    person = new Student(gpa, tuitionFee, id, name, dob);
                } else if ("Teacher".equalsIgnoreCase(type)) {
                    int nOClasses = rs.getInt("NOClasses");
                    double baseSalary = rs.getDouble("BaseSalary");
                    person = new Teacher(nOClasses, baseSalary, id, name, dob);
                } else {
                    person = new BasicPerson(id, name, dob) {
                    };
                }

                this.personList.add(person);
            }
        } catch (SQLException e) {
            System.err.println("Error loading data from DB: " + e.getMessage());
        }
    }

    public boolean updatePersonById(String oldId, Person newPerson) {
        Person existingPerson = findPersonById(oldId);
        if (existingPerson == null) {
            return false;
        }

        String sql = "";

        if (newPerson instanceof Student s) {
            sql = "UPDATE Persons SET id=?, name=?, DOBirth=?, GPA=?, tuitionFee=?, nOClasses=NULL, baseSalary=NULL WHERE id=?";
        } else if (newPerson instanceof Teacher t) {
            sql = "UPDATE Persons SET id=?, name=?, DOBirth=?, GPA=NULL, tuitionFee=NULL, nOClasses=?, baseSalary=? WHERE id=?";
        } else {
            return false;
        }

        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, newPerson.getId());
            ps.setString(2, newPerson.getName());
            ps.setDate(3, new java.sql.Date(newPerson.getDOBirth().getTime()));

            int lastIndex = 4;

            if (newPerson instanceof Student s) {
                ps.setDouble(4, s.getGpa());
                ps.setDouble(5, s.getTuitionFee());
                lastIndex = 6;
            } else if (newPerson instanceof Teacher t) {
                ps.setInt(4, t.getNOClasses());
                ps.setDouble(5, t.getBaseSalary());
                lastIndex = 6;
            }

            ps.setString(lastIndex, oldId);

            if (ps.executeUpdate() > 0) {
                personList.remove(existingPerson);
                personList.add(newPerson);
                return true;
            }
            return false;

        } catch (SQLException e) {
            System.err.println("Error updating person in DB: " + e.getMessage());
            return false;
        }
    }

    public boolean deletePersonById(String id) {
        Person personToDelete = findPersonById(id);
        if (personToDelete == null) {
            return false;
        }

        String sql = "DELETE FROM Persons WHERE id = ?";

        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);

            if (ps.executeUpdate() > 0) {
                this.personList.remove(personToDelete);
                return true;
            }
            return false;

        } catch (SQLException e) {
            System.err.println("Error deleting person from DB: " + e.getMessage());
            return false;
        }
    }

    public void displayAllPersons() {
        if (personList.isEmpty()) {
            System.out.println("Empty list.");
            return;
        }
        System.out.println("--- PERSONAL LIST ---");
        for (Person p : personList) {
            p.displayDetails();
        }
    }

    public List<Student> findTop3Students() {
        return this.personList.stream()
                .filter(p -> p instanceof Student)
                .map(p -> (Student) p)
                .sorted(Comparator.comparingDouble(Student::getGpa).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    public List<Student> findStudentsWithScholarships() {
        final double MIN_GPA_FOR_SCHOLARSHIP = 3.5;

        return this.personList.stream()
                .filter(p -> p instanceof Student)
                .map(p -> (Student) p)
                .filter(s -> s.getGpa() > MIN_GPA_FOR_SCHOLARSHIP)
                .collect(Collectors.toList());
    }

    public Teacher findTeacherWithHighestIncome() {
        Teacher highestIncomeTeacher = null;
        double maxIncome = 0;

        for (Person p : personList) {
            if (p instanceof Teacher t) {
                double currentIncome = t.calculateIncome();
                if (currentIncome > maxIncome) {
                    maxIncome = currentIncome;
                    highestIncomeTeacher = t;
                }
            }
        }
        return highestIncomeTeacher;
    }
}
