package model;

import javax.persistence.*;
import java.util.List;

public class HibernateWorks {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistencia");

    //Insertar proyectos
    public void createProyecto(Proyecto proyecto){
        EntityManager man = factory.createEntityManager();
        EntityTransaction tx = man.getTransaction();
        tx.begin();

        try {
            man.merge(proyecto);
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        } finally {
            man.close();
        }
    }

    //Lista de los proyectos
    public List<Proyecto> listProyectos() {
        EntityManager man = factory.createEntityManager();
        List<Proyecto> resultList = man.createQuery(
                "Select a From Proyecto a", Proyecto.class).getResultList();
        man.close();
        return resultList;
    }

    //Proyecto por su nombre
    public Proyecto queryForProyecto(int idCodigoProyecto) {
        EntityManager man = factory.createEntityManager();
        Query query = man
                .createQuery("Select a from Proyecto a where a.id = :idCodigoProyecto");
        query.setParameter("idCodigoProyecto", idCodigoProyecto);
        Proyecto anProyecto = (Proyecto) query.getSingleResult();
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

