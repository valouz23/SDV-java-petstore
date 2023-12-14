package fr.sdvnte.m1dev2324.valentine.entities.animals;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "fish")
public class Fish extends Animal {
    @Enumerated
    @Column(name = "living_env", nullable = false)
    private FishLivEnv livingEnv;

    public Fish(){

    }

    public Fish(LocalDate birth, String color, FishLivEnv livingEnv) {
        super(birth, color);
        this.livingEnv = livingEnv;
    }

    public FishLivEnv getLivingEnv() {
        return livingEnv;
    }

    public void setLivingEnv(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "livingEnv=" + livingEnv +
                '}';
    }
}
