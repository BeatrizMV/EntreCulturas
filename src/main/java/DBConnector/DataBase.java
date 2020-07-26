package DBConnector;

import java.sql.Connection;
import java.util.List;

public interface DataBase<T> {
    //Constantes de conexion

    String RUTA= "jdbc:mysql://localhost:3306/entreCulturas";

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

    public Connection connect();

    public void disconnect(Connection connection);

    public List<T> getData(Connection connection);

    public void updateData(Connection connection);

    public void removeData(Connection connection);

    public void insertData(Connection connection);


}