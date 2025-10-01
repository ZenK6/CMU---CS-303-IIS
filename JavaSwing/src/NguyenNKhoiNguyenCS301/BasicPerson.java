package NguyenNKhoiNguyenCS301;

import java.util.Date;

public class BasicPerson extends Person {

    public BasicPerson(String id, String name, Date doBirth) {
        super(id, name, doBirth);
    }

    
    @Override
    public double calculateIncome() {
        
        return 0.0; 
    }

    
    @Override
    public void displayDetails() {
        System.out.println("ID: " + getId() + ", Name: " + getName() + 
                           ", Type: Basic, DOB: " + getDOBirth());
    }

    
    
    @Override
    public void addPerson() {
        
        
        System.out.println("Basic Person: Add operation not implemented here.");
    }

    
    
    @Override
    public boolean updatePerson() {
        
        System.out.println("Basic Person: Update operation not implemented here.");
        return false;
    }
}