package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.data.jpa.provider.HibernateUtils;

public class HibernateWorks {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistencia");
    EntityManager man = factory.createEntityManager();
    private Object id;

    //Insertar nuevos registros en tabla Proyectos
    private <T> void createProyecto(T t){
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
    private void listProyectos() {

        // Nuevamente, manager es el EntityManager obtenido anteriormente.
        List<Proyecto> resultList = man.createQuery(
                /*dos parámetros: la consulta que se quiere realizar en JPLQ
                y la clase en la que queremos que nos devuelva la consulta */
                "Select a From Proyecto a", Proyecto.class).getResultList();
        System.out.println("num de proyectos:" + resultList.size());
        for (Proyecto next : resultList) {
            System.out.println("siguiente proyecto: " + next);
        }
    }

    //Consulta de un proyecto por su nombre
    private Proyecto queryForProyecto(String idCodigoProyecto) {
        System.out.println("QUERY FOR "+idCodigoProyecto);
        Query query = man
                .createQuery("Select a from Proyecto a where a.idCodigoProyecto = :idCodigoProyecto");
        query.setParameter("nombreProyecto", idCodigoProyecto);
        Proyecto anProyecto = (Proyecto) query.getSingleResult();
        System.out.println("Los datos del proyecto que buscas son : " + anProyecto.toString());
        return anProyecto;
    }

    public <T> void saveOrUpdate (T t){
        EntityTransaction tx = man.getTransaction();
        tx.begin();

        try{
            T t =man.find(T.class, id);
            man.merge(t);
            man.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }
            man.close();
    }

    public <T> void erase (T t){
        EntityTransaction tx = man.getTransaction();
        tx.begin();

        try{
            T t= man.find(T.class, id);
            man.remove(t);
            tx.commit();
;
        } catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }
        man.close();
    }


    public <T, K> void joinManyToMany (Class<T> tClass, int idT, Class<K> kClass, int idK){
        try{
            HibernateUtil.openSession();
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.load(tClass, idT);
            session.load(kClass, idK);
        }finally {
            man.close();
        }
    }
}
