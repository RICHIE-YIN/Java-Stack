package richie.belt.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="characters")
public class Character {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @NotBlank(message="Name is required!")
    @Size(min=2, max=128, message="Name must be 2 or more characters!")
    private String name;

    @NotBlank(message="Gender is required!")
    private String gender;

    @NotBlank(message="Origin is required!")
    @Size(min=2, max=128, message="Origin must have 2 or more characters!")
    private String origin;

    @NotBlank(message="Meaning is required!")
    @Size(min=2, max=128, message="Meaning must have 2 or more characters!")
    private String meaning;

    
    @ManyToOne(fetch=FetchType.LAZY) //many to one for singular gets
    @JoinColumn(name="user_id") //many to one for singular gets
    private User user; //many to one for singular gets
    
    private Integer upvotes = 0;
    
    @ManyToMany(fetch = FetchType.LAZY) 
    @JoinTable(
        name = "upvoters_characters", 
        joinColumns = @JoinColumn(name = "character_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> upvoters; //named it upvoters as we're trying to track upvoters in this scenario.


    public Character() {
    }


    public Character(Long id, String name, String gender, String origin, String meaning, User user, Integer upvotes, List<User> upvoters) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.origin = origin;
        this.meaning = meaning;
        this.user = user;
        this.upvotes = upvotes;
        this.upvoters = upvoters;
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

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getMeaning() {
        return this.meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getUpvotes() {
        return this.upvotes;
    }

    public void setUpvotes(Integer upvotes) {
        this.upvotes = upvotes;
    }

    public List<User> getUpvoters() {
        return this.upvoters;
    }

    public void setUpvoters(List<User> upvoters) {
        this.upvoters = upvoters;
    }

}
