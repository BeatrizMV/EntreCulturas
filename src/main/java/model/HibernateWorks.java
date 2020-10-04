package model;

import javax.persistence.*;
import java.util.List;

public class HibernateWorks {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistencia");


    //Insertar nuevos registros en tabla Proyectos
    public void createProyecto(Proyecto proyecto){
        //man es el EntityManager creado más arriba
        EntityManager man = factory.createEntityManager();
        EntityTransaction tx = man.getTransaction();
        tx.begin();

        try {
            //man.persist(proyecto);
            man.merge(proyecto);
            //si el cambio va bien, se actualiza en la base de datos
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            //vuelve atrás si se detecta un fallo
            tx.rollback();
        } finally {
            man.close();
        }

    }

    //Consulta que facilita una lista de los proyectos existentes
    public List<Proyecto> listProyectos() {
        EntityManager man = factory.createEntityManager();
        // Nuevamente, manager es el EntityManager obtenido anteriormente.
        List<Proyecto> resultList = man.createQuery(
                /*dos parámetros: la consulta que se quiere realizar en JPLQ
                y la clase en la que queremos que nos devuelva la consulta */
                "Select a From Proyecto a", Proyecto.class).getResultList();
        System.out.println("num de proyectos:" + resultList.size());
        for (Proyecto next : resultList) {
            System.out.println("siguiente proyecto: " + next);
        }
        man.close();
        return resultList;
    }

    //Consulta de un proyecto por su nombre
    public Proyecto queryForProyecto(int idCodigoProyecto) {
        EntityManager man = factory.createEntityManager();
        System.out.println("QUERY FOR "+idCodigoProyecto);
        Query query = man
                .createQuery("Select a from Proyecto a where a.id = :idCodigoProyecto");
        query.setParameter("idCodigoProyecto", idCodigoProyecto);
        Proyecto anProyecto = (Proyecto) query.getSingleResult();
        System.out.println("Los datos del proyecto que buscas son : " + anProyecto.toString());
        man.close();
        return anProyecto;
    }

    public void saveOrUpdate (Proyecto p){
        EntityManager anotherMan = factory.createEntityManager();
        EntityTransaction tx = anotherMan.getTransaction();
        tx.begin();

        try{
            Proyecto fromDb =anotherMan.find(Proyecto.class, p.getCodigoProyecto());
            fromDb.setCodigoProyecto(p.getCodigoProyecto());
            fromDb.setNombreProyecto(p.getNombreProyecto());
            fromDb.setLineaAccion(p.getLineaAccion());
            fromDb.setSublineaAccion(p.getSublineaAccion());
            fromDb.setFechaInicio(p.getFechaInicio());
            fromDb.setFechaFin(p.getFechaFin());
            fromDb.setSocioLocal(p.getSocioLocal());
            fromDb.setAccionesRealizar(p.getAccionesRealizar());
            fromDb.setLocalizacion(p.getLocalizacion());
            anotherMan.merge(fromDb);
            //anotherMan.persist(p);
            tx.commit();
        } catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        } finally {
            anotherMan.close();
        }

    }

    public void erase (int proyectoId){
        EntityManager man = factory.createEntityManager();
        EntityTransaction tx = man.getTransaction();
        tx.begin();

        try{
            Proyecto proyecto= man.find(Proyecto.class, proyectoId);
            man.remove(proyecto);
            tx.commit();
;
        } catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        } finally {
            man.close();
        }

    }

}

