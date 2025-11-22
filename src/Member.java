public class Member {

    private int id;
    private String name;
    private int borrowedCount;

    // session stats
    private int numViewBorrowed;
    private int numBorrows;
    private int numReturns;
    private double sessionFees;

    // static global stats
    public static double TotalRevenue = 0.0;
    public static int TotalViewBorrowed = 0;
    public static int TotalBorrows = 0;
    public static int TotalReturns = 0;

    public Member(int id, String name, int borrowedCount) {
        this.id = id;
        this.name = name;
        this.borrowedCount = borrowedCount;
    }

    private boolean canBorrow() {
        return borrowedCount < 5;
    }

    private boolean canReturn() {
        return borrowedCount > 0;
    }

    public void viewBorrowedCount() {
        numViewBorrowed++;
        TotalViewBorrowed++;
        System.out.println("Borrowed books: " + borrowedCount);
    }

    public boolean borrowOne() {
        if (!canBorrow()) {
            System.out.println("You already have 5 books.");
            return false;
        }
        borrowedCount++;
        numBorrows++;
        TotalBorrows++;
        sessionFees += 0.50;
        TotalRevenue += 0.50;
        System.out.println("Borrowed 1 book. Fee = 0.50");
        return true;
    }

    public boolean returnOne() {
        if (!canReturn()) {
            System.out.println("No books to return.");
            return false;
        }
        borrowedCount--;
        numReturns++;
        TotalReturns++;
        System.out.println("Returned 1 book.");
        return true;
    }

    public void displayStatistics() {
        System.out.println("\n=== Stats for " + name + " ===");
        System.out.println("Session Borrows: " + numBorrows);
        System.out.println("Session Returns: " + numReturns);
        System.out.println("Viewed Count: " + numViewBorrowed);
        System.out.printf("Session Fees: %.2f\n", sessionFees);
    }

    public void reset() {
        numViewBorrowed = 0;
        numBorrows = 0;
        numReturns = 0;
        sessionFees = 0.0;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getBorrowedCount() { return borrowedCount; }
    public double getSessionFees() { return sessionFees; }
}
