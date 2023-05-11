package cat.itacademy.barcelonactiva.Ros.Ivan.s04.t02.n03.domain;


//data model class corresponds to entity and table for DataBase.

import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Document(collection = "Fruits")
public class Fruit {

    @Transient
    public static final String SEQUENCE_NAME = "fruit_sequence";

    @Id
    private Integer id;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "quantity")
    private Integer quantity;


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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Fruit( String name, Integer quantity) {

        this.name = name;
        this.quantity = quantity;
    }

    public Fruit() {
    }
}
