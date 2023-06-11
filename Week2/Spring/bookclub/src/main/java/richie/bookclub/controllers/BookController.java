package richie.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import richie.bookclub.models.Book;
import richie.bookclub.models.User;
import richie.bookclub.services.BookService;
import richie.bookclub.services.UserService;

@Controller
public class BookController {
    
    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @GetMapping("/books/new")
    public String addBook(@ModelAttribute("book") Book book, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }
        User user = userService.getOneUser(userId);
        // model.addAttribute("book", new Book());
        // model.addAttribute("user", user);
        return "book/newBook.jsp";
    }

    @PostMapping("/addNewBook")
    public String addBook(@Valid Book book, BindingResult result, HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        if(userId==null) {
            return "redirect:/";
        }
        User user = userService.getOneUser(userId);
        if(result.hasErrors()) {
            model.addAttribute("user", user);
            model.addAttribute("book", book);
            return "book/newBook.jsp";
        }
        else {
            book.setUser(user);
            bookService.createBook(book, user);
            // model.addAttribute("user", user); 
            return "redirect:/books";
        }
    }

    // readall
    @GetMapping ("/books")
    public String viewBooks(Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }
        List<Book> allBooks = bookService.getAllBooks();
        // List<Book> userBooks = bookService.findByUserId(userId);
        model.addAttribute("books", allBooks);
        model.addAttribute("user", session.getAttribute("user"));
        // System.out.println(books);
        return "book/index.jsp";
    }

    //BONUS book page 
    @GetMapping("/books/{id}")
    public String viewBookDetails(@PathVariable("id") Long id, Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }
        Book book = bookService.getOneBook(id);
        User user = book.getUser();
        boolean isCurrentUser = user.getId().equals(userId);
        model.addAttribute("book", book);
        model.addAttribute("isCurrentUser", isCurrentUser);
        return"book/bookDetails.jsp";
    }

    //BONUS delete book if user logged in is book owner
    @DeleteMapping("/books/{id}/delete")
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBookById(id);
        return "redirect:/books";
    }

    //BONUS edit book, include validations and prepopulate
    @GetMapping ("/books/{id}/edit")
    public String editBook(@PathVariable("id") Long id, Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
        return "redirect/";
        }
        Book book = bookService.getOneBook(id);
        User user = book.getUser();
        if (!user.getId().equals(userId)) {
            return "redirect:/books/" + id;
        }
        model.addAttribute("book", book);
        return "book/editBook.jsp";
    }
    @PutMapping("/books/{id}/editthisbook")
    public String updateBook(@PathVariable("id") Long id, @Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session, Model model) {
        if (result.hasErrors()) {
            return "book/editBook.jsp";
        }
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }
        book.setUser(userService.getOneUser(userId));
        book.setId(id);
        bookService.updateBook(book);
        model.addAttribute("user", session.getAttribute("user"));
        return "redirect:/books/" + id;
    }
}
