package fr.sdvnte.m1dev2324.valentine.entities.products;

import fr.sdvnte.m1dev2324.valentine.entities.PetStore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "code",length = 20, nullable = false)
    private String code;
    // Longueur par défaut d'un string est 255, j'ai choisi de le laisser comme tel
    @Column(name = "label", nullable = false)
    private String label;
    @Enumerated
    @Column(name = "type", nullable = false)
    private ProdType type;
    @Column(name = "price", nullable = false)
    private double price;
    @ManyToMany(mappedBy = "produits", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<PetStore> petstores;

    public Product() {

    }

    public Product(String code, String label, ProdType type, double price) {
        this.code = code;
        this.label = label;
        this.type = type;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ProdType getType() {
        return type;
    }

    public void setType(ProdType type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<PetStore> getPetstores() {
        return petstores;
    }

    public void setPetstores(Set<PetStore> petstores) {
        this.petstores = petstores;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", label='" + label + '\'' +
                ", type=" + type +
                ", price=" + price +
                ", petstores=" + petstores +
                '}';
    }
}
