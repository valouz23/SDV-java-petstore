package fr.sdvnte.m1dev2324.valentine.entities;

import fr.sdvnte.m1dev2324.valentine.entities.animals.Animal;
import fr.sdvnte.m1dev2324.valentine.entities.products.Product;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "store")
public class PetStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "manager_name", nullable = false, length = 50)
    private String managerName;
    @ManyToMany
    @JoinColumn(name = "Product")
    private Set<Product> products;
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Address adresse;
    @OneToMany(mappedBy = "petstore")
    @JoinColumn(name = "Animal")
    private Set<Animal> animals;

    public PetStore() {

    }

    public PetStore(String name, String managerName, Address adresse) {
        this.name = name;
        this.managerName = managerName;
        this.adresse = adresse;
    }

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

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Address getAdresse() {
        return adresse;
    }

    public void setAdresse(Address adresse) {
        this.adresse = adresse;
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "PetStore{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", managerName='" + managerName + '\'' +
                ", products=" + products +
                ", adresse=" + adresse +
                ", animals=" + animals +
                '}';
    }
}
