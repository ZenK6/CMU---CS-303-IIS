package training;

import java.util.Date;

public class Teacher extends Person {

    private int numberOfClasses;
    private double baseSalary;

    public Teacher(String id, String name, Date dateOfBirth, int numberOfClasses, double baseSalary) {
        super(id, name, dateOfBirth);
        this.numberOfClasses = numberOfClasses;
        this.baseSalary = baseSalary;
    }

    // Getters
    public int getNumberOfClasses() {
        return numberOfClasses;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    // Setters (Đã bổ sung để cho phép cập nhật dữ liệu từ lớp Processor)
    public void setNumberOfClasses(int numberOfClasses) {
        this.numberOfClasses = numberOfClasses;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public double calculateIncome() {
        return numberOfClasses * baseSalary;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Type: Teacher");
        System.out.println("Number of Classes: " + numberOfClasses);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Total Income: " + calculateIncome());
    }

    @Override
    public void addPerson() {
    }

    @Override
    public boolean updatePerson() {
        return true;
    }
}