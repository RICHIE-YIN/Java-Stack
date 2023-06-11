package richie.booksapi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //tells spring this is something you want to keep track of
@Table(name="books") //tells spring you want this stored in a database and in a certain table

public class Book {

    @Id //all books need an id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gives book a unique id
    private Long id; //anytime you add a private_________ it adds it into MySQL database

    private String author;
    private String title;
    private Integer pages;

    // when we setup a model to handle data, it has to be a special type of Java object. These objects are called POJOS/BEANS
    //we do this by creating a constructor as well as getters and setters

    public Book() {
    }


    public Book(String author, String title, Integer pages) {
        // this.id = id; //db taking care of id
        this.author = author;
        this.title = title;
        this.pages = pages;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPages() {
        return this.pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

}
