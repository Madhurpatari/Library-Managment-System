import java.util.Scanner;
@SuppressWarnings("all")
public class Main{
    public static void main(String[] args) {
    Library library = new Library();
    Scanner scanner = new Scanner(System.in);

    while (true) {
        System.out.println("\nWelcome to Library Management System.");
        System.out.println("1. Add book");
        System.out.println("2. Register user");
        System.out.println("3. Check out book");
        System.out.println("4. Return book");
        System.out.println("5. Search books");
        System.out.println("6. Exit");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter book title: ");
                scanner.nextLine();
                String title = scanner.nextLine();
                System.out.print("Enter book author: ");
                String author = scanner.nextLine();
                System.out.print("Enter book genre: ");
                String genre = scanner.nextLine();
                System.out.print("Enter book ISBN: ");
                int ISBN = scanner.nextInt();
                library.addBook(title, author, genre, ISBN);
                break;

            case 2:
                System.out.print("Enter user name: ");
                scanner.nextLine();
                String userName = scanner.nextLine();
                System.out.print("Enter user ID: ");
                int userID = scanner.nextInt();
                library.registerUser(userName, userID);
                break;

            case 3:
                System.out.print("Enter user ID: ");
                int checkoutUserID = scanner.nextInt();
                System.out.print("Enter book ISBN: ");
                int checkoutBookISBN = scanner.nextInt();
                library.checkOutBook(checkoutUserID, checkoutBookISBN);
                break;

            case 4:
                System.out.print("Enter user ID: ");
                int returnUserID = scanner.nextInt();
                System.out.print("Enter book ISBN: ");
                int returnBookISBN = scanner.nextInt();
                library.returnBook(returnUserID, returnBookISBN);
                break;

            case 5:
                System.out.print("Enter search keyword: ");
                scanner.nextLine();
                String keyword = scanner.nextLine();
                library.searchBooks(keyword);
                break;

            case 6:
                System.out.println("Exiting Library Management System.");
                System.exit(0);

            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
}