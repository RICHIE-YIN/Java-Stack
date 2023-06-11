package richie.booksapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import richie.booksapi.models.Book;
import richie.booksapi.services.BookService;

@Controller
public class MainController {

    @Autowired BookService bookService; //connects book repository. BookRepository is class/object, bookRepository is the instance of that object of which you can call on and grab from DB

    // !CREATE
    @GetMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) { //creates new book as soon as link is pressed
        return "books/new.jsp";
    }

    @PostMapping("/books")
    public String createBook(
        @ModelAttribute("book") Book book
        // @RequestParam("author")String author,
        // @RequestParam("title")String title,
        // @RequestParam("pages")Integer pages
        ) {
        // Book book = new Book(author, title, pages);
        bookService.createBook(book);
        return "redirect:/";
    }


    //! READ ALL
    @GetMapping("/")
    public String index(Model model){ //Model model allows us to get stuff front the backend to the backend
        List<Book> books = bookService.getAllBooks(); //we created a method called getAllBooks. in BookService, we actuallu implement the getall method by the bookRepository 
        // System.out.println(books); //in terminal it shows the list of books in your db
        model.addAttribute("books", books); //sends books down to models
        return "books/index.jsp";
    }

    // !READ ONE
    @GetMapping("/books/{id}")
        public String show(@PathVariable("id") Long id, Model model) { //allows you to access whatever is typed into that route
            Book book = bookService.getOneBook(id); //calls the method from BookService
            model.addAttribute("book", book);
            // System.out.println(id); //print out id
            // System.out.println(book); //print out book
            return "books/show.jsp";
    }

    // !UPDATE
    @GetMapping("/books/{id}/edit")
        public String edit(@PathVariable("id") Long id, Model model) {
        Book book = bookService.getOneBook(id);
        model.addAttribute("book", book);
        return "books/edit.jsp";
}

    @PutMapping("/books/{id}")
    public String updateBook(@ModelAttribute("book") Book book) {
        bookService.updateBook(book);
        return "redirect:/";
    }

    // !DELETE
    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/";
    }
}
    