package richie.booksapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import richie.booksapi.models.Book;
import richie.booksapi.repositories.BookRepository;

@Service //we need to designate this as a service!!! service will talk to repository
public class BookService {
    

    @Autowired BookRepository bookRepository;

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

    public Book getOneBook(Long id) {
        Optional<Book> optionalbook = bookRepository.findById(id); //"Optional" because we're searching for something that may or may not be there
        Book book = optionalbook.orElse(null); //if we find the book, return the book; if not return null
    return book;
    }

    public void createBook(Book book) {
        bookRepository.save(book);
    }

    public void updateBook(Book book) {
        bookRepository.save(book);
    }
    

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
    
}
