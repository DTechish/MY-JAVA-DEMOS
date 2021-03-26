import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class Books{
    private String title;
    private String author;
    private String edition;
    private double price;
    private int quantity;

    List<Books> books = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);

    private Books(){
    }

    private Books(String title, String author, String edition, double price, int quantity){
        this.title = title;
        this.author = author;
        this.edition = edition;
        this.price = price;
        this.quantity = quantity;
    }

    private void printBooks(){
        int index = 1;
        if(books.isEmpty()){
            System.out.println("You must add a book first");
        }else {
            for (Books book : books) {
                System.out.println("\nBOOK" + index + "\nTitle: " + book.title + "\nAuthor: " + book.author + "\nEdition: " + book.edition + "\nPrice: " + book.price + "\nQuantity: " + book.quantity + "\n");
                ++index;
            }
        }
    }

    private void updateBook(){
        if(books.isEmpty()){
            System.out.println("You must add a book first");
        }else {
            System.out.print("Enter book title: ");
            String bookTitle = scanner.nextLine().trim();
            boolean isFound = false;

            for (Books book : books) {
                if (book.title.equals(bookTitle)) {
                    isFound = true;
                    break;
                }
            }

            if(!isFound){
                System.out.println("Book title not found!");
            }else{
                List<String> bookTitles = new ArrayList<>();

                for (Books book : books) {
                    bookTitles.add(book.title);
                }

                System.out.print("Enter new book title: ");
                String newBookTitle = scanner.nextLine().trim();

                if(bookTitles.contains(newBookTitle)){
                    System.out.println("Book title already exits!");
                    return;
                }else{
                    int index = 0;
                    while (index < books.size()) {
                        if (books.get(index).title.equals(bookTitle)) {
                            books.get(index).title = newBookTitle;
                            System.out.println("Book title has been updated.");
                            return;
                        }
                        ++index;
                    }
                }

                for (Books book : books) {
                    if (!book.title.contains(newBookTitle)) {
                        book.title = newBookTitle;
                        System.out.println("Book title has been updated.");
                        break;
                    } else {
                        System.out.println("Book title already exits!");
                    }
                }
            }
        }
    }

    private void removeBook(){
        if(books.isEmpty()){
            System.out.println("You must add a book first");
        }else {
            System.out.print("Enter book title: ");
            String bookTitle = scanner.nextLine().trim();
            boolean isFound = false;

            for (Books book : books) {
                if (book.title.equals(bookTitle)) {
                    isFound = true;
                    break;
                }
            }

            if(!isFound) {
                System.out.println("Book title not found!");
            }else{
                for (Books book : books) {
                    if(book.title.equals(bookTitle)) {
                        System.out.println("Book has been removed.");
                        books.remove(book);
                        break;
                    }
                }
            }
        }
    }

    private double sellBooks(){
        double totalAmount = 0.0;
        if(books.isEmpty()){
            System.out.println("You must add a book first");
        }else {
            System.out.print("Enter book title: ");
            String bookTitle = scanner.nextLine().trim();
            boolean isFound = false;

            for (Books book : books) {
                if (book.title.equals(bookTitle)) {
                    isFound = true;
                    break;
                }
            }
            if(!isFound) {
                System.out.println("Book title not found!");
            }else {
                for (Books book : books) {
                    if (book.title.equals(bookTitle)) {
                        System.out.println("Book has been sold with additional rate of 10%.");
                        totalAmount = book.price / book.quantity * 10.0;
                    }
                }
            }
        }
        return totalAmount;
    }

    private void printRevenue(){
        if(books.isEmpty()){
            System.out.println("You must add a book first");
        }else {
            double sell = sellBooks();
            if(sell == 0.0){
                System.out.println("You have no revenue.");
            }else {
                System.out.println("Revenue : $" + sell);
            }
        }
    }

    private void addNewBook(){
        System.out.print("Enter book title: ");
        String bookTitle = scanner.nextLine().trim();

        for(Books book : books){
            if(book.title.equals(bookTitle)){
                System.out.println("Book Title Already Exits!");
                return;
            }
        }

        System.out.print("Enter book author: ");
        String bookAuthor = scanner.nextLine().trim();

        System.out.print("Enter book edition: ");
        String bookEdition = scanner.nextLine().trim();

        System.out.print("Enter book price: ");
        double bookPrice;
        try{
            bookPrice = scanner.nextDouble();
        }catch (InputMismatchException e){
            System.out.println("That is not a number");
            return;
        }

        System.out.print("Enter book quantity: ");
        int bookQuantity;
        try {
            bookQuantity = scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("That is not a number");
            return;
        }

        books.add(new Books(bookTitle, bookAuthor, bookEdition, bookPrice, bookQuantity));
        System.out.println("Book has been added.");
    }

    public static void main(String[] args) {
        System.out.println("\nBOOK APPLICATION\n1.Adding New Book\n2.Update A Book\n3.Remove A Book\n4.Print All Books\n5.Print Revenue\n6.Sell Book\n7.Exit");
        Books book = new Books();
        String userOption;

        while(true){
            System.out.print("\nEnter an option(1-6): ");
            userOption = scanner.nextLine();

            switch (userOption) {
                case "1" -> {
                    book.addNewBook();
                    scanner = new Scanner(System.in);
                }
                case "2" -> book.updateBook();
                case "3" -> book.removeBook();
                case "4" -> book.printBooks();
                case "5" -> book.printRevenue();
                case "6" -> book.sellBooks();
                case "7" -> {
                    System.out.println("Thanks for using out application.");
                    return;
                }
            }
        }
    }
}
