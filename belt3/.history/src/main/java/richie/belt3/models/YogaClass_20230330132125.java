package richie.belt3.models;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "yoga_classes")
public class YogaClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required!")
    @Size(min = 2, message = "Name must be at least 2 characters!")
    private String name;

    @NotBlank(message = "Day of week is required!")
    private String dayOfWeek;

    @NotNull(message = "Price is required!")
    private Double price;

    @DateTimeFormat(pattern = "hh:mm a")
    private LocalTime time;

    @NotBlank(message = "Description is required!")
    @Size(min = 2, message = "Description must be at least 2 characters!")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "student_classes",
            joinColumns = @JoinColumn(name = "yoga_class_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;

    public YogaClass() {
    }


    public YogaClass(Long id, String name, String dayOfWeek, Double price, LocalTime time, String description, User user, List<Student> students) {
        this.id = id;
        this.name = name;
        this.dayOfWeek = dayOfWeek;
        this.price = price;
        this.time = time;
        this.description = description;
        this.user = user;
        this.students = students;
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

    public String getDayOfWeek() {
        return this.dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalTime getTime() {
        return this.time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalTime getLocalTime() {
        return LocalTime.parse(time.toString(), DateTimeFormatter.ofPattern("HH:mm"));
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

    public List<Student> getStudents() {
        return this.students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}