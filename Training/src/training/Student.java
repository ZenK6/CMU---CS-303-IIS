package training;

import java.util.Date;

public class Student extends Person {

    private double gpa;
    private double tuitionFee;

    public Student(String id, String name, Date dateOfBirth, double gpa, double tuitionFee) {
        super(id, name, dateOfBirth);
        this.gpa = gpa;
        this.tuitionFee = tuitionFee;
    }

    // Getters
    public double getGpa() {
        return gpa;
    }

    public double getTuitionFee() {
        return tuitionFee;
    }

    // Setters (Đã bổ sung để cho phép cập nhật dữ liệu từ lớp Processor)
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void setTuitionFee(double tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    @Override
    public double calculateIncome() {
        if (this.gpa > 3.5) {
            return 0.5 * this.tuitionFee;
        }
        return 0.0;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Type: Student");
        System.out.println("GPA: " + gpa);
        System.out.println("Tuition Fee: " + tuitionFee);
        System.out.println("Income (Scholarship): " + calculateIncome());
    }

    @Override
    public void addPerson() {
    }

    @Override
    public boolean updatePerson() {
        return true;
    }
}