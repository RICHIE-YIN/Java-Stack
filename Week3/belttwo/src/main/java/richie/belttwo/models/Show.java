package richie.belttwo.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="shows")
public class Show {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @NotBlank(message="Title is required!")
    @Size(min=2, max=128, message="Title must be 2 or more characters!")
    private String title;

    @NotBlank(message="Network is required!")
    @Size(min=2, max=128, message="Network must be 2 or more characters!")
    private String network;

    @NotBlank(message="Description is required!")
    @Size(min=2, max=128, message="Description must have 2 or more characters!")
    private String description;

    
    @ManyToOne(fetch=FetchType.LAZY) //many to one for singular gets
    @JoinColumn(name="user_id") //many to one for singular gets
    private User user; //many to one for singular gets
    
    @OneToMany(mappedBy="show", fetch=FetchType.LAZY)
    private List<Rating> ratings;


    public Show() {
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNetwork() {
        return this.network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Rating> getRatings() {
        return this.ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

}
