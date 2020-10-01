package test;

import model.Proyecto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.GregorianCalendar;
import java.util.List;

public class testProyectos {

    private static EntityManager manager;

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia");

    public static void main(String[] args){
        //Crea el gestor de persistencia EM
        manager  = emf.createEntityManager();
        //insertInit();

        manager.getTransaction().begin();
        Proyecto p =manager.find(Proyecto.class, 10);
        manager.merge(p);
        manager.getTransaction().commit();

        printAll();

        Proyecto p = new Proyecto(10, "Educar personas, generar oportunidades", "Calle Wallaby 42 Sidney",
                "Cooperación al desarrollo", "Formación para el trabajo",
                new GregorianCalendar(2019, 11, 11).getTime(),
                new GregorianCalendar(2021, 12, 12).getTime(), "INDITEX");

        manager.getTransaction().begin();

        manager.persist(p);

        manager.getTransaction().commit();

        printAll();
        manager.close();

    }
    @SuppressWarnings("unchecked")
    private static void printAll(){
        //Query para obtener todos los proyectos existentes
        List<Proyecto> proyectos = (List<Proyecto>) manager.createQuery("FROM proyectos").getResultList();
        System.out.println("En esta base de datos hay "+ proyectos.size() + "proyectos");
        for (Proyecto proy:proyectos){
            System.out.println(proy.toString());
        }
    }
}

