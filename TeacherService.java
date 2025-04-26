import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class TeacherService {
    Connection conn = DBConnection.getConnection();
    Scanner sc = new Scanner(System.in);

    public void addTeacher() {
        try {
            System.out.print("Enter Teacher Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Subject: ");
            String subject = sc.nextLine();

            String sql = "INSERT INTO teachers(name, subject) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, subject);
            ps.executeUpdate();
            System.out.println("Teacher added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewTeachers() {
        try {
            String sql = "SELECT * FROM teachers";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.println("\n--- Teacher List ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") +
                        ", Subject: " + rs.getString("subject"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
