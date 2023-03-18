import java.util.ArrayList;
class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    public void addBook(String title, String author, String genre, int ISBN) {
        Book newBook = new Book(title, author, genre, ISBN, true);
        books.add(newBook);
        System.out.println("Book added to library successfully.");
    }

    public void registerUser(String name, int ID) {
        User newUser = new User(name, ID);
        users.add(newUser);
        System.out.println("User registered successfully.");
    }

    public void checkOutBook(int userID, int bookISBN) {
        boolean userFound = false;
        boolean bookFound = false;
        for (User user : users) {
            if (user.getID() == userID) {
                userFound = true;
                break;
            }
        }
        if (!userFound) {
            System.out.println("User not found.");
            return;
        }
        for (Book book : books) {
            if (book.getISBN() == bookISBN) {
                if (book.isAvailable()) {
                    bookFound = true;
                    book.setAvailable(false);
                    System.out.println("Book checked out successfully.");
                    return;
                } else {
                    System.out.println("Book not available.");
                    return;
                }
            }
        }
        if (!bookFound) {
            System.out.println("Book not found.");
        }
    }

    public void returnBook(int userID, int bookISBN) {
        boolean userFound = false;
        boolean bookFound = false;
        for (User user : users) {
            if (user.getID() == userID) {
                userFound = true;
                break;
            }
        }
        if (!userFound) {
            System.out.println("User not found.");
            return;
        }
        for (Book book : books) {
            if (book.getISBN() == bookISBN) {
                bookFound = true;
                book.setAvailable(true);
                System.out.println("Book returned successfully.");
                return;
            }
        }
        if (!bookFound) {
            System.out.println("Book not found.");
        }
    }

    public void searchBooks(String keyword) {
        boolean booksFound = false;
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())
                    || book.getAuthor().toLowerCase().contains(keyword.toLowerCase())
                    || book.getGenre().toLowerCase().contains(keyword.toLowerCase())
                    || Integer.toString(book.getISBN()).contains(keyword)){
                        booksFound = true;
                        System.out.println(book.getTitle() + " by " + book.getAuthor() + ", Genre: " + book.getGenre()
                                + ", ISBN: " + book.getISBN() + ", Available: " + book.isAvailable());
                }
            if (!booksFound){
                    System.out.println("No books found matching the search criteria.");
                }
            }
        }
    }