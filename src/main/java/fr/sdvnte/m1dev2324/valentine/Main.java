package fr.sdvnte.m1dev2324.valentine;


import fr.sdvnte.m1dev2324.valentine.entities.Address;
import fr.sdvnte.m1dev2324.valentine.entities.PetStore;
import fr.sdvnte.m1dev2324.valentine.entities.animals.Animal;
import fr.sdvnte.m1dev2324.valentine.entities.animals.Cat;
import fr.sdvnte.m1dev2324.valentine.entities.animals.Fish;
import fr.sdvnte.m1dev2324.valentine.entities.animals.FishLivEnv;
import fr.sdvnte.m1dev2324.valentine.entities.products.ProdType;
import fr.sdvnte.m1dev2324.valentine.entities.products.Product;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("petstore")) {
            EntityManager em = emf.createEntityManager();

            EntityTransaction et = em.getTransaction();
            et.begin();

            // Création d'adresses
            Address adresse1 = new Address("1", "rue du château", "111111", "Ma ville");
            Address adresse2 = new Address("2", "rue du manoir", "222222", "Une ville");
            Address adresse3 = new Address("3", "rue de la paix", "333333", "Un village");


            // Création de magasin
            PetStore store1 = new PetStore("Mon magasin", "Valentine DJAMEI", adresse1);
            PetStore store2 = new PetStore("Ton magasin", "Lauryne GAULTIER", adresse2);
            PetStore store3 = new PetStore("Un magasin", "Aboubacar CONDE", adresse3);


            // Création d'animaux
            Fish animal1 = new Fish(LocalDate.of(2023, Month.JUNE,15),"gris", store1, FishLivEnv.FRESH_WATER);
            Fish animal2 = new Fish(LocalDate.of(2023, Month.JULY,24),"arc-en-ciel", store2, FishLivEnv.SEA_WATER);
            Fish animal3 = new Fish(LocalDate.of(2023, Month.SEPTEMBER,3),"rouge", store3, FishLivEnv.FRESH_WATER);

            Cat animal4 = new Cat(LocalDate.of(2023, Month.APRIL, 27), "brun", store1, "12345");
            Cat animal5 = new Cat(LocalDate.of(2023, Month.MARCH, 2), "roux", store2, "23456");
            Cat animal6 = new Cat(LocalDate.of(2023, Month.MAY, 11), "noir", store3, "34567");

            // Création de produits
            Product produit1 = new Product("987654321", "Nourriture Poisson", ProdType.FOOD, 10.90);
            Product produit2 = new Product("876543219", "Arbre à chats", ProdType.ACCESSORY, 153.99);
            Product produit3 = new Product("765432198", "Pelle à litière", ProdType.CLEANING, 15.50);


            // Ajout des Produits au magasin
            store1.getProducts().add(produit1);
            store2.getProducts().add(produit1);
            store2.getProducts().add(produit2);
            store3.getProducts().add(produit3);

            // Persistence des animaux
            // Avec le système de cascade, les animaux vont créé les magasins auxquels ils appartiennent, et les magasins vont créé leur propre adresse, et les produits qu'ils contiennent
            em.persist(animal1);
            em.persist(animal2);
            em.persist(animal3);
            em.persist(animal4);
            em.persist(animal5);
            em.persist(animal6);

            et.commit();

            // requête récupérant tous les animaux d'un animalerie donnée (ici "Mon magasin")
            // j'ai adapté les fonctions toString par défaut pour que ce soit un peu plus lisible
            TypedQuery<Animal> query1 = em.createQuery("select a from Animal a JOIN a.petstore p where p.name = 'Mon magasin'", Animal.class);
            List<Animal> animals = query1.getResultList();
            for (Animal animal : animals) {
                System.out.println(animal);
            }

        }
    }
}