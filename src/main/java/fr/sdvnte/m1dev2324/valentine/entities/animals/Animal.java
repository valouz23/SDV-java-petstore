package fr.sdvnte.m1dev2324.valentine.entities.animals;

import com.sun.jna.platform.unix.X11;
import fr.sdvnte.m1dev2324.valentine.entities.PetStore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "birth", nullable = true)
    private LocalDate birth;
    // Ici je l'ai appelé color au lieu de couleur parce que tout le reste est en anglais, et ça me faisait mal au coeur d'avoir uniquement un mot de français dans toute cette nomenclature
    @Column(name = "color", nullable = true, length = 20)
    private String color;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "store")
    private PetStore petstore;

    public Animal(){

    }

    public Animal(LocalDate birth, String color) {
        this.birth = birth;
        this.color = color;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public PetStore getPetstore() {
        return petstore;
    }

    public void setPetstore(PetStore petstore) {
        this.petstore = petstore;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", birth=" + birth +
                ", color='" + color + '\'' +
                ", petstore=" + petstore +
                '}';
    }
}
