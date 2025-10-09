package training;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PersonList {

    private ArrayList<Person> personList;

    public PersonList() {
        this.personList = new ArrayList<>();
    }

    public void addPerson(Person person) {
        this.personList.add(person);
    }

    public boolean updatePersonById(String id, Person updatedPerson) {
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getId().equals(id)) {
                personList.set(i, updatedPerson);
                return true;
            }
        }
        return false;
    }

    public boolean deletePersonById(String id) {
        return personList.removeIf(p -> p.getId().equals(id));
    }

    public Person findPersonById(String id) {
        for (Person p : personList) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public void displayAllPersons() {
        if (personList.isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        System.out.println("\n--- All Persons in the List ---");
        for (Person p : personList) {
            p.displayDetails();
            System.out.println("-----------------------------");
        }
    }

    public ArrayList<Student> findTop3Students() {
        List<Student> students = personList.stream()
                .filter(p -> p instanceof Student)
                .map(p -> (Student) p) 
                .sorted(Comparator.comparing(Student::getGpa).reversed()) 
                .limit(3) 
                .collect(Collectors.toList());

        return new ArrayList<>(students);
    }

    public Person findPersonWithHighestIncome() {
        return personList.stream()
                .max(Comparator.comparing(Person::calculateIncome))
                .orElse(null);
    }

    public ArrayList<Student> findStudentsWithScholarships() {
        List<Student> scholarshipStudents = personList.stream()
                .filter(p -> p instanceof Student)
                .map(p -> (Student) p)
                .filter(s -> s.getGpa() > 3.5) 
                .collect(Collectors.toList());

        return new ArrayList<>(scholarshipStudents);
    }

    public long countStudents() {
        return personList.stream().filter(p -> p instanceof Student).count();
    }

    public long countTeachers() {
        return personList.stream().filter(p -> p instanceof Teacher).count();
    }
}