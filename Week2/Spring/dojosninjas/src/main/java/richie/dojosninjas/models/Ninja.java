package richie.dojosninjas.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ninjas")
public class Ninja {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String first;
    private String last;
    private Integer age;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dojo_id")
    private Dojo dojo;



    public Ninja() {
    }


    public Ninja(Long id, String first, String last, Integer age, Dojo dojo) {
        this.id = id;
        this.first = first;
        this.last = last;
        this.age = age;
        this.dojo = dojo;
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

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Dojo getDojo() {
        return this.dojo;
    }

    public void setDojo(Dojo dojo) {
        this.dojo = dojo;
    }


}
