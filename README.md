# Mini Library System in Java

This is a simple library management system implemented in Java. It demonstrates basic object-oriented programming concepts such as classes, objects, encapsulation, and collections.

## Features

- Manage books and users.
- Borrow and return books with availability checks.
- Find books by name or author.
- List all available books.
- Sort books by publication year.
- Add or remove books and users.

## Classes

- **Book**
  - Attributes: `name`, `year`, `author`, `isAvailable`.
  - Methods: `borrowBook()`, `returnBook()`, getters/setters.

- **User**
  - Attributes: `name`, `id`, list of borrowed books.
  - Methods: `BorrowBook(Book)`, `returnBook(Book)`.

- **Library**
  - Attributes: list of books, map of users.
  - Methods: add/remove books/users, find books by name/author, list available books, sort books by year.

## Usage

1. Clone the repository.
2. Compile and run `Main.java`.
3. The program demonstrates:
   - Adding books and users.
   - Borrowing and returning books.
   - Searching, listing, sorting, and removing books.

```java
Library library = new Library();
Book book1 = new Book("1984", 1949, "George Orwell", true);
User user1 = new User("Adilet", 1);
library.addBook(book1);
library.addUser(user1);
user1.BorrowBook(book1);
