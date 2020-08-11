package daoroot.db;

import DBConnector.DBConnector;
import enums.LineaAccion;
import root.Proyecto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbProyectoDao implements  DBDAO<Proyecto> {

    private DBConnector conexion = new DBConnector();

    @Override
    public List<Proyecto> getData(Connection connection) {
        List<Proyecto> listaProyectos = new ArrayList<>();

        try {
            Statement stmt = connection.createStatement();
            String query = "Select * from " + TABLA_PROYECTOS;
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Proyecto p = new Proyecto(rs.getInt(PROYECTOS_ID),
                        rs.getString(PROYECTOS_NOMBRE),
                        LineaAccion.values()[rs.getInt(PROYECTOS_LINEACCION) - 1],
                        rs.getDate(PROYECTOS_FECHAINCIO).toLocalDate(),
                        rs.getString(PROYECTOS_SOCIOLOCAL),
                        rs.getString(PROYECTOS_ACCIONES),
                        rs.getString(PROYECTOS_TIPOVIA),
                        rs.getString(PROYECTOS_VIA),
                        rs.getInt(PROYECTOS_NUM),
                        rs.getString(PROYECTOS_PROVINCIA),
                        rs.getInt(PROYECTOS_CP),
                        rs.getString(PROYECTOS_PAIS),
                        rs.getString(PROYECTOS_OBSERVACIONES));
                listaProyectos.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("No se pudo mostrar la lista de proyectos");
        }

        return listaProyectos;
    }

    @Override
    public void updateData(Connection connection, Proyecto data) {

    }

    @Override
    public void removeData(Connection connection, Proyecto data) {

        try {
            Statement stmt = connection.createStatement();
            String query = "delete from " + TABLA_PROYECTOS + " where " + PROYECTOS_ID + "=" + data.getCodigoProyecto() + "";
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("No se pudo borrar el proyecto");
        }
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
