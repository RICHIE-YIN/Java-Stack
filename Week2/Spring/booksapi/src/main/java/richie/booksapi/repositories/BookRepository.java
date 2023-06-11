package richie.booksapi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository; //part of framework

import richie.booksapi.models.Book; //imported from book MODEL

public interface BookRepository  extends CrudRepository<Book, Long>{ //keeps track of books and id
    List<Book> findAll(); //overrides what it returns (in controller) by default so instead of returning iterable it returns the list
}
