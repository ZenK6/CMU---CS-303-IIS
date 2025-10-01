package doan1;

import java.io.*;
import java.util.*;

public class CustomerService {

    private final List<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer c) {
        customers.add(c);
    }

    public void deleteCustomer(int index) {
        if (index >= 0 && index < customers.size()) {
            customers.remove(index);
        }
    }

    public void updateCustomer(int index, Customer c) {
        if (index >= 0 && index < customers.size()) {
            customers.set(index, c);
        }
    }

    public List<Customer> searchByName(String keyword) {
        return customers.stream()
                .filter(c -> c.getName().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
    }

    public List<Customer> getAll() {
        return customers;
    }

    public void saveToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Customer c : customers) {
                writer.write(c.getId() + "," + c.getName() + "," + c.getEmail() + "," + c.getCccd());
                writer.newLine();
            }
        }
    }

    public void loadFromFile(String filename) throws IOException {
        customers.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0]);
                    customers.add(new Customer(id, parts[1], parts[2], parts[3]));
                }
            }
        }
    }

    public void sortByName() {
        customers.sort(Comparator.comparing(Customer::getName));
    }

    public void sortById() {
        customers.sort(Comparator.comparingInt(Customer::getId));
    }

    public void sortByCccd() {
        customers.sort(Comparator.comparing(Customer::getCccd));
    }

    void sortByPic() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
