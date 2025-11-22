// CSC111 Project Phase 2
// Github: https://github.com/AzzamAlsaud/cscprojectp2
// Group Members: 
// AZZAM ABDULRAHMAN IBRAHIM ALSAUD 446109011 
// SAEED AHMAD SAEED ALQAHTANI 446104468 
// NAWAF ABDULLAH SALEH ALZAHRANI 446106325 
// MAJED AJLAN MOHAMMED ALSHEHRI 446104687

import java.util.Scanner;

public class LibrarySimulator {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // library members
        Member m1 = new Member(1, "Azzam Alsaud", 0);
        Member m2 = new Member(2, "Saeed Alqahtani", 0);
        Member m3 = new Member(3, "Abdullah Alzahrani", 0);
        Member m4 = new Member(4, "Majed Alshehri", 0);

        boolean run = true; 

        while (run) {
            // main menu
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. Login as " + m1.getName());
            System.out.println("2. Login as " + m2.getName());
            System.out.println("3. Login as " + m3.getName());
            System.out.println("4. Login as " + m4.getName());
            System.out.println("5. Admin Login");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int c = in.nextInt();
            in.nextLine(); // fix skip

            if (c >= 1 && c <= 4) {

                // check which member
                Member current;
                if (c == 1) current = m1;
                else if (c == 2) current = m2;
                else if (c == 3) current = m3;
                else current = m4;

                current.reset(); // clear old session stats

                boolean session = true; 

                while (session) {
                    // member menu
                    System.out.println("\nWelcome " + current.getName());
                    System.out.println("1. View Borrowed Count");
                    System.out.println("2. Borrow");
                    System.out.println("3. Return");
                    System.out.println("4. View Session Stats");
                    System.out.println("5. Back");
                    System.out.print("Pick: ");

                    int op = in.nextInt();
                    in.nextLine(); 

                    if (op == 1) {
                        current.viewBorrowedCount(); 
                    } else if (op == 2) {
                        current.borrowOne(); 
                    } else if (op == 3) {
                        current.returnOne(); 
                    } else if (op == 4) {
                        current.displayStatistics(); 
                    } else if (op == 5) {
                        System.out.println("Leaving session...");
                        session = false; 
                    } else {
                        System.out.println("Wrong input"); 
                    }
                }

            } else if (c == 5) {
                // admin section
                System.out.print("Enter admin password: ");
                String pw = in.nextLine();

                if (!pw.equals("admin")) {
                    System.out.println("Wrong password.");
                } else {
                    boolean adm = true; 

                    while (adm) {
                        System.out.println("\n=== Admin ===");
                        System.out.println("1. Total Revenue");
                        System.out.println("2. Most Used Operation");
                        System.out.println("3. Back");
                        System.out.print("Pick: ");

                        int ac = in.nextInt();
                        in.nextLine(); 

                        if (ac == 1) {
                            System.out.printf("Total revenue: %.2f\n", Member.TotalRevenue);
                        } else if (ac == 2) {
                            // check most used
                            if (Member.TotalBorrows == 0 && Member.TotalReturns == 0) {
                                System.out.println("No operations yet.");
                            } else if (Member.TotalBorrows > Member.TotalReturns) {
                                System.out.println("Most used: Borrow");
                            } else if (Member.TotalReturns > Member.TotalBorrows) {
                                System.out.println("Most used: Return");
                            } else {
                                System.out.println("Tie: Borrow & Return");
                            }

                        } else if (ac == 3) {
                            adm = false; 
                        } else {
                            System.out.println("Invalid option");
                        }
                    }
                }

            } else if (c == 6) {
                System.out.println("Goodbye!");
                run = false; 

            } else {
                System.out.println("Invalid choice.");
            }
        }

        in.close(); 
    }
}
