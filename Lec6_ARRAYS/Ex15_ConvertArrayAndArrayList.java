package Lec6_ARRAYS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ex15_ConvertArrayAndArrayList {

    public static ArrayList<String> arrayToArrayList(String[] array) {
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(array));
        return arrayList;
    }

    public static String[] arrayListToArray(ArrayList<String> arrayList) {
        String[] array = new String[arrayList.size()];
        return arrayList.toArray(array);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Chuyen doi tu Mang (Array) sang Danh sach (ArrayList) ---");
        System.out.print("Nhap so luong ten ban muon nhap: ");
        int size = scanner.nextInt();
        scanner.nextLine();

        String[] namesArray = new String[size];
        System.out.println("Nhap " + size + " ten:");
        for (int i = 0; i < size; i++) {
            System.out.print("Ten thu " + (i + 1) + ": ");
            namesArray[i] = scanner.nextLine();
        }

        System.out.println("Mang ban dau: " + Arrays.toString(namesArray));
        ArrayList<String> namesArrayList = arrayToArrayList(namesArray);
        System.out.println("Sau khi chuyen doi sang ArrayList: " + namesArrayList);

        System.out.println("\n---------------------------------------------");

        System.out.println("--- Chuyen doi tu Danh sach (ArrayList) sang Mang (Array) ---");
        ArrayList<String> citiesArrayList = new ArrayList<>();
        System.out.println("Nhap ten cac thanh pho (nhap 'ketthuc' de dung):");
        while (true) {
            System.out.print("Ten thanh pho: ");
            String city = scanner.nextLine();
            if (city.equalsIgnoreCase("ketthuc")) {
                break;
            }
            citiesArrayList.add(city);
        }

        System.out.println("ArrayList ban dau: " + citiesArrayList);
        String[] citiesArray = arrayListToArray(citiesArrayList);
        System.out.println("Sau khi chuyen doi sang Mang: " + Arrays.toString(citiesArray));
        
        scanner.close();
    }
}