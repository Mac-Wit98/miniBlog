package pl.akademiakodu.miniBlog.model;

import javafx.geometry.Pos;

import javax.persistence.*;

@Entity
public class Tag {

    public Tag(String name) {
        this.name = name;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
