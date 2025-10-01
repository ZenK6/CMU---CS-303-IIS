package NguyenNKhoiNguyenCS301;

import java.util.Date;

public class Student extends Person {

    private double gpa;
    private double tuitionFee;

    public Student(double gpa, double tuitionFee, String id, String name, Date DOBirth) {
        super(id, name, DOBirth);
        this.gpa = gpa;
        this.tuitionFee = tuitionFee;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public double getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(double tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    @Override
    public double calculateIncome() {
        if (this.gpa > 3.5) {
            return this.tuitionFee * 0.50;
        }
        return 0.0;
    }

    @Override
    public void addPerson() {
        System.out.println("Adding student with ID: " + getId());
    }

    @Override
    public boolean updatePerson() {
        System.out.println("Updating details for student with ID: " + getId());
        return true;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("GPA: " + this.gpa);
        System.out.println("Tuition Fee: " + this.tuitionFee);
    }

}
