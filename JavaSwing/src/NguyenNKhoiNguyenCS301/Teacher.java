package NguyenNKhoiNguyenCS301;

import java.util.Date;

public class Teacher extends Person {

    private int NOClasses;
    private double baseSalary;

    public Teacher(int NOClasses, double baseSalary, String id, String name, Date DOBirth) {
        super(id, name, DOBirth);
        this.NOClasses = NOClasses;
        this.baseSalary = baseSalary;
    }

    public int getNOClasses() {
        return NOClasses;
    }

    public void setNOClasses(int NOClasses) {
        this.NOClasses = NOClasses;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public double calculateIncome() {
        return NOClasses * baseSalary;
    }

    @Override
    public void addPerson() {
        System.out.println("Adding a teacher with ID: " + getId());
    }

    @Override
    public boolean updatePerson() {
        System.out.println("Updating details for a teacher with ID: " + getId());
        return true;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Classes: " + this.NOClasses);
        System.out.println("Base Salary: " + this.baseSalary);
    }

}
