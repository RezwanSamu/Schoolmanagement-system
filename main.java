import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService studentService = new StudentService();
        TeacherService teacherService = new TeacherService();

        while (true) {
            System.out.println("\n--- School Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Add Teacher");
            System.out.println("4. View Teachers");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    studentService.addStudent();
                    break;
                case 2:
                    studentService.viewStudents();
                    break;
                case 3:
                    teacherService.addTeacher();
                    break;
                case 4:
                    teacherService.viewTeachers();
                    break;
                case 5:
                    System.out.println("Exiting... Bye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}

