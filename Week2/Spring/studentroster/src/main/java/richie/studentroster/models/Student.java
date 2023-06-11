package richie.studentroster.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String first;
    private String last;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dorm_id")
    private Dorm dorm;


    public Student() {
    }


    public Student(Long id, String first, String last, Dorm dorm) {
        this.id = id;
        this.first = first;
        this.last = last;
        this.dorm = dorm;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst() {
        return this.first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return this.last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public Dorm getDorm() {
        return this.dorm;
    }

    public void setDorm(Dorm dorm) {
        this.dorm = dorm;
    }

}
