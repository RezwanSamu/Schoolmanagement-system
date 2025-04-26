import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class StudentService {
    Connection conn = DBConnection.getConnection();
    Scanner sc = new Scanner(System.in);

    public void addStudent() {
        try {
            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            sc.nextLine(); // consume newline
            System.out.print("Enter Class Name: ");
            String className = sc.nextLine();

            String sql = "INSERT INTO students(name, age, class_name) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, className);
            ps.executeUpdate();
            System.out.println("Student added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewStudents() {
        try {
            String sql = "SELECT * FROM students";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.println("\n--- Student List ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") +
                        ", Age: " + rs.getInt("age") + ", Class: " + rs.getString("class_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

