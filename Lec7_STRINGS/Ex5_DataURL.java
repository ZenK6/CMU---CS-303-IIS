package Lec7_STRINGS;

import java.util.Scanner;

public class Ex5_DataURL {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter URL::");
        String url = scanner.nextLine();
        scanner.close();

        parseURL(url);
    }

    public static void parseURL(String url) {
        // Kiểm tra nếu URL rỗng hoặc null
        if (url == null || url.isEmpty()) {
            System.out.println("INVALID URL.");
            return;
        }

        // Tìm vị trí kết thúc của giao thức ("://")
        int protocolEndIndex = url.indexOf("://");
        String protocol = "";
        if (protocolEndIndex != -1) {
            protocol = url.substring(0, protocolEndIndex);
        }

        // Tìm vị trí kết thúc của tên miền
        int domainStartIndex = protocolEndIndex != -1 ? protocolEndIndex + 3 : 0;
        int domainEndIndex = url.indexOf("/", domainStartIndex);
        String domain = "";
        String path = "";

        if (domainEndIndex != -1) {
            domain = url.substring(domainStartIndex, domainEndIndex);
            path = url.substring(domainEndIndex);
        } else {
            // Trường hợp URL không có đường dẫn (ví dụ: "http://example.com")
            domain = url.substring(domainStartIndex);
            path = "/";
        }

        // In kết quả
        System.out.println("Protocol: " + protocol);
        System.out.println("Domain: " + domain);
        System.out.println("Path: " + path);
    }
}