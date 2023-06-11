package richie.booksapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import richie.booksapi.models.Book;
import richie.booksapi.repositories.BookRepository;
@RestController //if you set it up to be a RestController instead of just Contrller, you got an API
public class BooksApi {
    //takes all functionality from BookRepository interface and injecting it into methods below.
    // also same thing as @Autowired in MainController
    private final BookRepository bookRepository;
    public BooksApi(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
    
    @RequestMapping(value="/api/books", method=RequestMethod.GET)
    public List<Book> allBooks() {
        List<Book> books = bookRepository.findAll(); //queries db for list of books
        return books; //all you need to do for an API is just return books
    }
}
