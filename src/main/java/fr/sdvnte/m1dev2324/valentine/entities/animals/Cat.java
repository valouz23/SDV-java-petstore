package fr.sdvnte.m1dev2324.valentine.entities.animals;

import fr.sdvnte.m1dev2324.valentine.entities.animals.Animal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "cat")
public class Cat extends Animal {
    @Column(name = "chip_id")
    private String chipId;

    public Cat(){

    }

    public Cat(LocalDate birth, String color, String chipId) {
        super(birth, color);
        this.chipId = chipId;
    }

    public String getChipId() {
        return chipId;
    }

    public void setChipId(String chipId) {
        this.chipId = chipId;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "chipId='" + chipId + '\'' +
                '}';
    }
}
