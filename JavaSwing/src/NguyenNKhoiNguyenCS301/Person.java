package NguyenNKhoiNguyenCS301;

import java.util.Date;

public abstract class Person implements IPerson {

    String id, name;
    Date DOBirth;

    public Person(String id, String name, Date DOBirth) {
        this.id = id;
        this.name = name;
        this.DOBirth = DOBirth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDOBirth() {
        return DOBirth;
    }

    public void setDOBirth(Date DOBirth) {
        this.DOBirth = DOBirth;
    }

    @Override
    public void displayDetails() {
        System.out.println("ID: " + this.id);
        System.out.println("Name: " + this.name);
        System.out.println("Date of Birth: " + this.DOBirth);
    }
   
    @Override
    public abstract void addPerson();

    @Override
    public abstract boolean updatePerson();

    @Override
    public abstract double calculateIncome();

}
