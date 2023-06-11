package richie.safetravels.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //tells spring this is something you want to keep track of
@Table(name="expenses") //tells spring you want this stored in a database and in a certain table

public class Expense {
    
    @Id //all books need an id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gives book a unique id
    private Long id; //anytime you add a private_________ it adds it into MySQL database

    private String name;
    private String vendor;
    private Integer amount;
    private String description;

    public Expense() {
    }

    public Expense(String name, String vendor, Integer amount, String description) {
        // this.id = id; //db taking care of id
        this.name = name;
        this.vendor = vendor;
        this.amount = amount;
        this.description = description;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVendor() {
        return this.vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
