package fr.sdvnte.m1dev2324.valentine;


import fr.sdvnte.m1dev2324.valentine.entities.PetStore;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("petstore")) {
            EntityManager em = emf.createEntityManager();

            EntityTransaction et = em.getTransaction();
            et.begin();


            PetStore store1 = new PetStore("Mon magasin", "Valentine DJAMEI", );

            et.commit();
        }
    }
}