import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

class book {
    private String name;
    private int year;
    private String author;
    private boolean isAvailable;

    book(String name, int year, String author, boolean isAvailable) {
        this.name = name;
        this.year = year;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public String getName() {
        return name;
    }

    public Integer getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }

    public Boolean isAvailable() {
        return isAvailable;
    }

    public void setYear(int year) {
        if (year > 0) {
            this.year = year;
        } else {
            throw new IllegalArgumentException("Wth try normally");
        }
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    void borrowBook(){
        if (!isAvailable) {
            System.out.println("Книга уже занята!");
        } else {
            isAvailable = false;
            System.out.println("Книга успешно взята!");
        }
    }

    void returnBook(){
        if (isAvailable) {
            System.out.println("Книга уже возвращена!");
        } else {
            isAvailable = true;
            System.out.println("Книга успешно возвращена!");
        }
    }


    @Override
    public String toString() {
        return "book{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", author='" + author + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}

class user{
    private String name;
    private int id;
    ArrayList<book> borrowedBooks = new ArrayList<>();

    user(String name, int id ){
        this.name = name;
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    void BorrowBook(book book){
        if(book.isAvailable()){
            borrowedBooks.add(book);
            book.borrowBook();
        }else {
            System.out.println("This book isn't available");}
    }

    void returnBook(book book){
        borrowedBooks.remove(book);
        book.returnBook();
    }

    @Override
    public String toString() {
        return "user{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }
}

class Library{
    ArrayList<book> books = new ArrayList<>();
    HashMap<Integer, user> users = new HashMap<>();

    void addBook(book book){
        books.add(book);
    }

    void addUser(user user){
        users.put(user.getId(), user);
    }

    void removeBook(String name){
        Iterator<book> it = books.iterator();
        while (it.hasNext()){
            if(it.next().getName().equalsIgnoreCase(name)){
                it.remove();
                break;
            }
        }
    }

    void findBook(String name){
        Iterator<book> it = books.iterator();
        while (it.hasNext()){
            book b = it.next();
            if(b.getName().equalsIgnoreCase(name)){
                System.out.println(b);
            }
        }
    }

    void listAvailableBooks(){
        for (book b : books){
            if(b.isAvailable()){
                System.out.println(b);
            }
        }
    }

    void sortBooksByYear(){
        books.sort(Comparator.comparingInt(s->s.getYear()));
        for(book a : books){
            System.out.println(a);
        }
    }
    void getBookByAuthor(String author){
        Iterator<book> it = books.listIterator();
        while(it.hasNext()){
            book b = it.next();
            if(b.getAuthor().equalsIgnoreCase(author)){
                System.out.println(b);
            }
        }
    }
}


public class Main {
    public static void main(String[] args) {
        // Создаём библиотеку
        Library library = new Library();

        // Создаём книги
        book b1 = new book("1984", 1949, "George Orwell", true);
        book b2 = new book("Dune", 1965, "Frank Herbert", true);
        book b3 = new book("Metro 2033", 2005, "Glukhovsky", true);

        // Добавляем книги в библиотеку
        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);

        // Создаём пользователей
        user u1 = new user("Adilet", 1);
        user u2 = new user("Alice", 2);

        // Добавляем пользователей в библиотеку
        library.addUser(u1);
        library.addUser(u2);

        // Пользователь берёт книгу
        u1.BorrowBook(b1);

        // Список доступных книг после взятия
        System.out.println("Доступные книги:");
        library.listAvailableBooks();

        // Поиск книги по имени
        System.out.println("\nПоиск книги 'Dune':");
        library.findBook("Dune");

        // Пользователь возвращает книгу
        u1.returnBook(b1);

        // Снова список доступных книг
        System.out.println("\nДоступные книги после возврата:");
        library.listAvailableBooks();

        // Сортировка книг по году
        System.out.println("\nКниги, отсортированные по году:");
        library.sortBooksByYear();

        // Получение книг по автору
        System.out.println("\nКниги автора Glukhovsky:");
        library.getBookByAuthor("Glukhovsky");

        // Удаление книги
        library.removeBook("Metro 2033");
        System.out.println("\nСписок книг после удаления:");
        library.listAvailableBooks();
    }
}
