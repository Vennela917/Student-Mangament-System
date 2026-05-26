import java.util.*;

class Student {

    int id;
    String name;
    int age;

    // Constructor
    Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Display Student Details
    void display() {
        System.out.println(id + " " + name + " " + age);
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();

        while(true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            // ADD STUDENT
            if(choice == 1) {

                System.out.print("Enter ID: ");
                int id = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Age: ");
                int age = sc.nextInt();

                Student s = new Student(id, name, age);

                students.add(s);

                System.out.println("Student Added Successfully!");
            }

            // VIEW STUDENTS
            else if(choice == 2) {

                if(students.isEmpty()) {
                    System.out.println("No Students Found");
                }

                else {

                    System.out.println("\nStudent Records:");

                    for(Student s : students) {
                        s.display();
                    }
                }
            }

            // SEARCH STUDENT
            else if(choice == 3) {

                System.out.print("Enter ID to Search: ");

                int searchId = sc.nextInt();

                boolean found = false;

                for(Student s : students) {

                    if(s.id == searchId) {

                        System.out.println("Student Found:");

                        s.display();

                        found = true;

                        break;
                    }
                }

                if(!found) {
                    System.out.println("Student Not Found");
                }
            }

            // UPDATE STUDENT
            else if(choice == 4) {

                System.out.print("Enter ID to Update: ");

                int updateId = sc.nextInt();

                boolean updated = false;

                for(Student s : students) {

                    if(s.id == updateId) {

                        sc.nextLine();

                        System.out.print("Enter New Name: ");
                        s.name = sc.nextLine();

                        System.out.print("Enter New Age: ");
                        s.age = sc.nextInt();

                        updated = true;

                        System.out.println("Student Updated Successfully!");

                        break;
                    }
                }

                if(!updated) {
                    System.out.println("Student Not Found");
                }
            }

            // DELETE STUDENT
            else if(choice == 5) {

                System.out.print("Enter ID to Delete: ");

                int deleteId = sc.nextInt();

                boolean removed = false;

                for(int i = 0; i < students.size(); i++) {

                    if(students.get(i).id == deleteId) {

                        students.remove(i);

                        removed = true;

                        System.out.println("Student Deleted Successfully!");

                        break;
                    }
                }

                if(!removed) {
                    System.out.println("Student Not Found");
                }
            }

            // EXIT
            else if(choice == 6) {

                System.out.println("Program Ended");

                break;
            }

            // INVALID CHOICE
            else {
                System.out.println("Invalid Choice");
            }
        }

        sc.close();
    }
}