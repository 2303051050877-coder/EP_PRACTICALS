package com.practical.spring;

import com.practical.spring.dao.StudentDAO;
import com.practical.spring.entity.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        StudentDAO dao = context.getBean("studentDAO", StudentDAO.class);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Spring JDBC CRUD Menu ===");
            System.out.println("1. Create Student");
            System.out.println("2. Read Student by ID");
            System.out.println("3. Read All Students");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    dao.saveStudent(new Student(name, email));
                    System.out.println("✅ Student created!");
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    try {
                        Student student = dao.getStudent(id);
                        System.out.println(student);
                    } catch (Exception e) {
                        System.out.println("❌ Student not found!");
                    }
                    break;

                case 3:
                    List<Student> students = dao.getAllStudents();
                    students.forEach(System.out::println);
                    break;

                case 4:
                    System.out.print("Enter ID to update: ");
                    int uid = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        Student s = dao.getStudent(uid);
                        System.out.print("Enter new Name: ");
                        s.setName(scanner.nextLine());
                        System.out.print("Enter new Email: ");
                        s.setEmail(scanner.nextLine());
                        dao.updateStudent(s);
                        System.out.println("✅ Updated!");
                    } catch (Exception e) {
                        System.out.println("❌ Student not found!");
                    }
                    break;

                case 5:
                    System.out.print("Enter ID to delete: ");
                    int did = scanner.nextInt();
                    dao.deleteStudent(did);
                    System.out.println("✅ Deleted!");
                    break;

                case 6:
                    System.out.println("👋 Exiting...");
                    scanner.close();
                    context.close();
                    System.exit(0);
            }
        }
    }
}
