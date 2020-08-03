package daoroot.db;

import DBConnector.DBConnector;
import root.Proyecto;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DbProyectoDao implements  DBDAO<Proyecto> {

    private DBConnector conexion = new DBConnector();

    @Override
    public List<Proyecto> getData(Connection connection) {
        return null;
    }

    @Override
    public void updateData(Connection connection, Proyecto data) {

    }

    @Override
    public void removeData(Connection connection, Proyecto data) {

    }

    @Override
    public void insertData(Connection connection, Proyecto data) {

        try {
            Statement stmt = connection.createStatement();
            String query = "insert into " + TABLA_PROYECTOS + "(" + PROYECTOS_ID + ", " + PROYECTOS_NOMBRE
                    + "," + PROYECTOS_TIPOVIA + "," + PROYECTOS_VIA + "," + PROYECTOS_NUM + "," + PROYECTOS_PROVINCIA
                    + "," + PROYECTOS_CP + "," + PROYECTOS_PAIS + "," + PROYECTOS_OBSERVACIONES + "," + PROYECTOS_FECHAINCIO + ","
                    + PROYECTOS_SOCIOLOCAL +  "," + PROYECTOS_ACCIONES + "," + PROYECTOS_LINEACCION + "," + PROYECTOS_SUBLINEA + ") values ('"
                    + data.getCodigoProyecto() + "', '" + data.getNombreProyecto()+"' , '" + data.getLocalizacion().getTipoVia() + "' , '"
                    + data.getLocalizacion().getVia() + "','" + data.getLocalizacion().getNum() + "','" + data.getLocalizacion().getProvincia() + "'.'"
                    + data.getLocalizacion().getCodigoPostal() + "','" + data.getLocalizacion().getPais() + "','" + data.getLocalizacion().getObservaciones() + "','"
                    + data.getFechaInicio() + "','" + data.getSocioLocal() + "','" + data.getAccionesRealizar() + "','" + data.getLineaAccion() + "','" + data.getSublineaAccion() +")";
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("No se pudo insertar el proyecto");
        }

    }
}
