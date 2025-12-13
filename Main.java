package studentmanagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    /* ========= STUDENT ADT ========= */
    static class Student {
        String id;
        String name;
        double mark;

        Student(String id, String name, double mark) {
            this.id = id;
            this.name = name;
            this.mark = mark;
        }

        String rank() {
            if (mark < 5) return "Fail";
            else if (mark < 6.5) return "Medium";
            else if (mark < 7.5) return "Good";
            else if (mark < 9) return "Very Good";
            else return "Excellent";
        }

        public String toString() {
            return id + " | " + name + " | " + mark + " | " + rank();
        }
    }

    /* ========= STUDENT MANAGER ========= */
    static class StudentManager {
        ArrayList<Student> list = new ArrayList<>();

        // Add
        void add(Student s) {
            list.add(s);
            System.out.println("Student added");
        }

        // Display
        void display() {
            if (list.isEmpty()) {
                System.out.println("No students");
                return;
            }
            list.forEach(System.out::println);
        }

        // Linear Search
        Student searchById(String id) {
            for (Student s : list) {
                if (s.id.equalsIgnoreCase(id)) {
                    return s;
                }
            }
            return null;
        }

        // Edit
        void edit(String id, String name, double mark) {
            Student s = searchById(id);
            if (s != null) {
                s.name = name;
                s.mark = mark;
                System.out.println("Student updated");
            } else {
                System.out.println("Student not found");
            }
        }

        // Delete
        void delete(String id) {
            Student s = searchById(id);
            if (s != null) {
                list.remove(s);
                System.out.println("Student deleted");
            } else {
                System.out.println("Student not found");
            }
        }

        // Quick Sort
        void sortByMark() {
            Collections.sort(list, Comparator.comparingDouble(s -> s.mark));
            System.out.println("Students sorted by mark");
        }
    }

    /* ========= MAIN PROGRAM ========= */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager sm = new StudentManager();

        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT =====");
            System.out.println("1. Add student");
            System.out.println("2. Display students");
            System.out.println("3. Edit student");
            System.out.println("4. Delete student");
            System.out.println("5. Sort students by mark");
            System.out.println("6. Search student by ID");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> {
                    System.out.print("Student ID: ");
                    String id = sc.nextLine();
                    System.out.print("Full name: ");
                    String name = sc.nextLine();
                    System.out.print("Mark: ");
                    double mark = sc.nextDouble();
                    sc.nextLine();
                    sm.add(new Student(id, name, mark));
                }

                case 2 -> sm.display();

                case 3 -> {
                    System.out.print("ID to edit: ");
                    String id = sc.nextLine();
                    System.out.print("New full name: ");
                    String name = sc.nextLine();
                    System.out.print("New mark: ");
                    double mark = sc.nextDouble();
                    sc.nextLine();
                    sm.edit(id, name, mark);
                }

                case 4 -> {
                    System.out.print("ID to delete: ");
                    sm.delete(sc.nextLine());
                }

                case 5 -> sm.sortByMark();

                case 6 -> {
                    System.out.print("Enter ID: ");
                    Student s = sm.searchById(sc.nextLine());
                    System.out.println(s != null ? s : "Student not found");
                }

                case 0 -> {
                    System.out.println("Exit program");
                    System.exit(0);
                }

                default -> System.out.println("Invalid choice");
            }
        }
    }
}
