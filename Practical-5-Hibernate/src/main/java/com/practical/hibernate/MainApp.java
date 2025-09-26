package com.practical.hibernate;

import com.practical.hibernate.dao.StudentDAO;
import com.practical.hibernate.entity.Student;

import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Hibernate CRUD Menu ===");
            System.out.println("1. Create Student");
            System.out.println("2. Read Student by ID");
            System.out.println("3. Read All Students");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Student Email: ");
                    String email = scanner.nextLine();
                    Student newStudent = new Student(name, email);
                    dao.saveStudent(newStudent);
                    System.out.println("✅ Student created successfully!");
                    break;

                case 2:
                    System.out.print("Enter Student ID to read: ");
                    int id = scanner.nextInt();
                    Student student = dao.getStudent(id);
                    if (student != null) {
                        System.out.println("Found: " + student);
                    } else {
                        System.out.println("❌ Student not found!");
                    }
                    break;

                case 3:
                    List<Student> students = dao.getAllStudents();
                    if (students.isEmpty()) {
                        System.out.println("⚠️ No students found.");
                    } else {
                        students.forEach(System.out::println);
                    }
                    break;

                case 4:
                    System.out.print("Enter Student ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    Student updateStudent = dao.getStudent(updateId);
                    if (updateStudent != null) {
                        System.out.print("Enter new name: ");
                        updateStudent.setName(scanner.nextLine());
                        System.out.print("Enter new email: ");
                        updateStudent.setEmail(scanner.nextLine());
                        dao.updateStudent(updateStudent);
                        System.out.println("✅ Student updated successfully!");
                    } else {
                        System.out.println("❌ Student not found!");
                    }
                    break;

                case 5:
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    dao.deleteStudent(deleteId);
                    break;

                case 6:
                    System.out.println("👋 Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("⚠️ Invalid choice, try again.");
            }
        }
    }
}
