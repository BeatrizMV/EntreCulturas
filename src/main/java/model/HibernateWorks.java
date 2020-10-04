package model;

import javax.persistence.*;
import java.util.List;

public class HibernateWorks {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistencia");
    EntityManager man = factory.createEntityManager();
    private Object id;

    //Insertar nuevos registros en tabla Proyectos
    public <T> void createProyecto(T t){
        //man es el EntityManager creado más arriba
        EntityTransaction tx = man.getTransaction();
        tx.begin();

        try {
            man.persist(new Proyecto(t));
            //si el cambio va bien, se actualiza en la base de datos
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            //vuelve atrás si se detecta un fallo
            tx.rollback();
        }

    }

    //Consulta que facilita una lista de los proyectos existentes
    public List<Proyecto> listProyectos() {

        // Nuevamente, manager es el EntityManager obtenido anteriormente.
        List<Proyecto> resultList = man.createQuery(
                /*dos parámetros: la consulta que se quiere realizar en JPLQ
                y la clase en la que queremos que nos devuelva la consulta */
                "Select a From Proyecto a", Proyecto.class).getResultList();
        System.out.println("num de proyectos:" + resultList.size());
        for (Proyecto next : resultList) {
            System.out.println("siguiente proyecto: " + next);
        }
        return resultList;
    }

    //Consulta de un proyecto por su nombre
    public Proyecto queryForProyecto(int idCodigoProyecto) {
        System.out.println("QUERY FOR "+idCodigoProyecto);
        Query query = man
                .createQuery("Select a from Proyecto a where a.id = :idCodigoProyecto");
        query.setParameter("idCodigoProyecto", idCodigoProyecto);
        Proyecto anProyecto = (Proyecto) query.getSingleResult();
        System.out.println("Los datos del proyecto que buscas son : " + anProyecto.toString());
        return anProyecto;
    }

    public void saveOrUpdate (Proyecto p){
        EntityTransaction tx = man.getTransaction();
        tx.begin();

        try{
            p =man.find(Proyecto.class, id);
            man.merge(p);
            man.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }
            man.close();
    }

    public void erase (Proyecto p){
        EntityTransaction tx = man.getTransaction();
        tx.begin();

        try{
            Proyecto proyecto= man.find(Proyecto.class, id);
            man.remove(proyecto);
            tx.commit();
;
        } catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }
        man.close();
    }

}

