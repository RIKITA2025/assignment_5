import java.util.*;

interface Department {
    String deptName = "Computer Science";
    String deptHead = "Dr. Shukla";

    void printDeptName();
    void printDeptHead();
}

class Hostel {
    String hostelName;
    String hostelLocation;
    int numberofRooms;

    void getHostelData(Scanner sc) {
        System.out.print("Enter Hostel Name: ");
        hostelName = sc.nextLine();

        System.out.print("Enter Hostel Location: ");
        hostelLocation = sc.nextLine();

        System.out.print("Enter Number of Rooms: ");
        numberofRooms = sc.nextInt();
        sc.nextLine();
    }

    void printHostelData() {
        System.out.println("Hostel Name: " + hostelName);
        System.out.println("Hostel Location: " + hostelLocation);
        System.out.println("Number of Rooms: " + numberofRooms);
    }
}

class Student extends Hostel implements Department {
    String studentName;
    int regdNo;
    String electiveSubject;
    double avgMarks;

    void getData(Scanner sc) {
        System.out.print("Enter Student Name: ");
        studentName = sc.nextLine();

        System.out.print("Enter Registration Number: ");
        regdNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Elective Subject: ");
        electiveSubject = sc.nextLine();

        System.out.print("Enter Average Marks: ");
        avgMarks = sc.nextDouble();
        sc.nextLine();

        getHostelData(sc);
    }

    void printData() {
        System.out.println("\n----- STUDENT DETAILS -----");
        System.out.println("Student Name: " + studentName);
        System.out.println("Registration Number: " + regdNo);
        System.out.println("Elective Subject: " + electiveSubject);
        System.out.println("Average Marks: " + avgMarks);

        printHostelData();
        printDeptName();
        printDeptHead();
    }

    public void printDeptName() {
        System.out.println("Department Name: " + deptName);
    }

    public void printDeptHead() {
        System.out.println("Department Head: " + deptHead);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT MENU =====");
            System.out.println("1. Admit New Student");
            System.out.println("2. Migrate a Student");
            System.out.println("3. Display Details");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    Student s = new Student();
                    System.out.println("\nEnter Student Details:");
                    s.getData(sc);
                    students.add(s);
                    System.out.println("Student Admitted Successfully!");
                    break;

                case 2:
                    System.out.print("Enter Registration Number to Migrate: ");
                    int reg = sc.nextInt();

                    boolean found = false;

                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).regdNo == reg) {
                            students.remove(i);
                            System.out.println("Student Migrated Successfully!");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student Not Found!");
                    }
                    break;

                case 3:
                    if (students.isEmpty()) {
                        System.out.println("No Student Records Found!");
                    } else {
                        for (Student st : students) {
                            st.printData();
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid Choice! Try Again.");
            }

        } while (choice != 4);

        sc.close();
    }
}