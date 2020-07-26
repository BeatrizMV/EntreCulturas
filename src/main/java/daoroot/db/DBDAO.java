package daoroot.db;

import java.sql.Connection;
import java.util.List;

public interface DBDAO<T> {

    //Constantes de las tablas de la BD

    String TABLA_EQUIPOS ="equipos";
    String EQUIPOS_PERSONA="fk_persona";

    String TABLA_LINEACCION="";

    String TABLA_MIEMBROEQUIPO= "";

    String TABLA_PERSONAS="";

    String TABLA_PROYECTOS="";

    String TABLA_ROLES="";

    String TABLA_SEDES="";

    String TABLA_SUBLINEAACIION="";

    // Funciones de la base de datos

    /**
     * Lista los datos de la base de datos
     * @param connection
     * @return una lista con los datos
     */
    public List<T> getData(Connection connection);

    /**
     * Actualiza los datos de la base de datos
     * @param connection
     * @param data
     */
    public void updateData(Connection connection, T data);

    /**
     * Elimina los datos de la base de datos
     * @param connection
     * @param data
     */
    public void removeData(Connection connection, T data);

    /**
     * Inserta datos en la base de datos
     * @param connection
     * @param data
     */
    public void insertData(Connection connection, T data);

}