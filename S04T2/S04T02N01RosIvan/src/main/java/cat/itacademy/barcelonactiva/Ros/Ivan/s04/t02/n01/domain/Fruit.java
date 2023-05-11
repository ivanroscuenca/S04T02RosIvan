package cat.itacademy.barcelonactiva.Ros.Ivan.s04.t02.n01.domain;


import jakarta.persistence.*;


//data model class corresponds to entity and table for DataBase.

    @Entity
    @Table(name = "fruits")
    public class Fruit {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;
        @Column(name = "name", length = 50)
        private String name;
        @Column(name = "quantity")
        private Integer quantity;


    public int getId() {
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
