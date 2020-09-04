package daoroot.db;

import DBConnector.DBConnector;

import enums.LineaAccion;
import root.Voluntario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import daoroot.DAO;
import exceptions.DaoException;
import root.Voluntario;

import java.lang.reflect.InvocationTargetException;

import java.util.List;
import java.util.Optional;

public class DbVoluntarioDao implements DAO<Voluntario>, DbConstants {

    private final DBConnector dbConnector;

    public DbVoluntarioDao(DBConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    @Override
    public List<Voluntario> listAll() throws DaoException {
        List<Voluntario> listaVoluntarios = new ArrayList<>();

        try {
            Statement stmt = dbConnector.connect().createStatement();
            String query = "Select * from " + TABLA_PERSONAS;
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Voluntario v = new Voluntario(rs.getInt(PERSONAS_ID),
                        rs.getString(PERSONAS_NOMBRE),
                        //LineaAccion.values()[rs.getInt(PROYECTOS_LINEACCION) - 1],
                        rs.getString(PERSONAS_DNI),
                        rs.getString(PERSONAS_APELLIDO1),
                        rs.getString(PERSONAS_APELLIDO2),
                        rs.getString(PERSONAS_TIPOVIA),
                        rs.getString(PERSONAS_VIA),
                        rs.getInt(PERSONAS_NUM),
                        rs.getString(PERSONAS_PROVINCIA),
                        rs.getInt(PERSONAS_CP),
                        rs.getString(PERSONAS_PAIS),
                        rs.getString(PERSONAS_OBSERVACIONES),
                        rs.getString(PERSONAS_TELEFONO),
                        rs.getString(PERSONAS_EMAIL));
                listaVoluntarios.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("No se pudo mostrar la lista de voluntarios");
        }

        return listaVoluntarios;
    }

    @Override
    public Optional<Voluntario> findById(int id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public void updateFieldById(int field, String value, int idArchivo) throws DaoException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {
    }

    @Override
    public void deleteById(int id) throws DaoException {
        try {
            Statement stmt = dbConnector.connect().createStatement();
            String query = "delete from " + TABLA_PERSONAS + " where " + PERSONAS_ID + "=" + id + "";
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("No se pudo borrar el voluntario");
        }
    }

    @Override
    public void create(Voluntario data) throws DaoException {
        try {
            Statement stmt = dbConnector.connect().createStatement();
            String query = "insert into " + TABLA_PERSONAS + "(" + PERSONAS_ID + ", " + PERSONAS_NOMBRE + ","
                    + PERSONAS_APELLIDO1 + "," + PERSONAS_APELLIDO2 + "," + PERSONAS_TIPOVIA + "," + PERSONAS_VIA + "," + PERSONAS_NUM + "," + PERSONAS_PROVINCIA
                    + "," + PERSONAS_CP + "," + PERSONAS_PAIS + "," + PERSONAS_OBSERVACIONES + "," + PERSONAS_TELEFONO + ","
                    + PERSONAS_EMAIL + "," + PERSONAS_USUARIO + "," + PERSONAS_PASSWORD + "," + PERSONAS_ROL + ") values ('"
                    + data.getId() + "', '" + data.getNombre() + "' , '" + data.getApellido1() + "" + data.getApellido2() + "" + data.getTipoVia() + "' , '"
                    + data.getVia() + "','" + data.getNum() + "','" + data.getProvincia() + "'.'"
                    + data.getCP() + "','" + data.getPais() + "','" + data.getObservaciones() + "','"
                    + data.getTelefono() + "','" + data.getEmail() + "','" + data.getUsuario() + "','" + data.getPassword() + "','" + data.getRol() + ")";
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("No se pudo insertar el voluntario");
        }

    }

    /* public List<Voluntario> getData(Connection connection) {
        List<Voluntario> listaVoluntarios = new ArrayList<>();

        try {
            Statement stmt = connection.createStatement();
            String query = "Select * from " + TABLA_PERSONAS;
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Voluntario v = new Voluntario(rs.getInt(PERSONAS_ID),
                        rs.getString(PERSONAS_NOMBRE),
                        //LineaAccion.values()[rs.getInt(PROYECTOS_LINEACCION) - 1],
                        rs.getString(PERSONAS_DNI),
                        rs.getString(PERSONAS_APELLIDO1),
                        rs.getString(PERSONAS_APELLIDO2),
                        rs.getString(PERSONAS_TIPOVIA),
                        rs.getString(PERSONAS_VIA),
                        rs.getInt(PERSONAS_NUM),
                        rs.getString(PERSONAS_PROVINCIA),
                        rs.getInt(PERSONAS_CP),
                        rs.getString(PERSONAS_PAIS),
                        rs.getString(PERSONAS_OBSERVACIONES),
                        rs.getString(PERSONAS_TELEFONO),
                        rs.getString(PERSONAS_EMAIL));
                listaVoluntarios.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("No se pudo mostrar la lista de voluntarios");
        }

        return listaVoluntarios;
    } */

    /*public void updateData(Connection connection, Voluntario data) {
        try {
            Statement stmt = connection.createStatement();
            String query = "Update "+TABLA_PERSONAS+" "
                    + "set "+PERSONAS_ID+"='"+data.getId()+"', "
                    +PERSONAS_NOMBRE+"='"+data.getNombre()+"', "
                    +PERSONAS_APELLIDO1+"='"+data.getApellido1()+"', "
                    +PERSONAS_APELLIDO2+"='"+data.getApellido2()+"', "
                    +PERSONAS_TIPOVIA+"="+data.getLocalizacion().getTipoVia()+"', "
                    +PERSONAS_VIA+"='"+data.getLocalizacion().getVia()+"', "
                    +PERSONAS_NUM+"='"+data.getLocalizacion().getNum()+"', "
                    +PERSONAS_PROVINCIA+"='"+data.getLocalizacion().getProvincia()+"', "
                    +PERSONAS_CP+"='"+data.getLocalizacion().getCodigoPostal()+"', "
                    +PERSONAS_PAIS+"='"+data.getLocalizacion().getPais()+"', "
                    +PERSONAS_OBSERVACIONES+"='"+data.getLocalizacion().getObservaciones()+"', "
                    +PERSONAS_TELEFONO+"='"+data.getTelefono()+"', "
                    +PERSONAS_EMAIL+"='"+data.getEmail()+"', "
                    +PERSONAS_USUARIO+"='"+data.getUsuario()+"', "
                    +PERSONAS_PASSWORD+"='"+data.getPassword()+"', "
                    +PERSONAS_ROL+"="+data.getRol()+" "
                    + "where "+PERSONAS_ID+"="+data.getId();
            stmt.executeUpdate(query);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("no se pudo modificar el voluntario");
        }
    }*/

    /*public void insertData(Connection connection, Voluntario data) {

        try {
            Statement stmt = connection.createStatement();
            String query = "insert into " + TABLA_PERSONAS + "(" + PERSONAS_ID + ", " + PERSONAS_NOMBRE + ","
                    + PERSONAS_APELLIDO1 + "," + PERSONAS_APELLIDO2 + "," + PERSONAS_TIPOVIA + "," + PERSONAS_VIA + "," + PERSONAS_NUM + "," + PERSONAS_PROVINCIA
                    + "," + PERSONAS_CP + "," + PERSONAS_PAIS + "," + PERSONAS_OBSERVACIONES + "," + PERSONAS_TELEFONO + ","
                    + PERSONAS_EMAIL + "," + PERSONAS_USUARIO + "," + PERSONAS_PASSWORD + "," + PERSONAS_ROL + ") values ('"
                    + data.getId() + "', '" + data.getNombre() + "' , '" + data.getApellido1() + "" + data.getApellido2() + "" + data.getLocalizacion().getTipoVia() + "' , '"
                    + data.getLocalizacion().getVia() + "','" + data.getLocalizacion().getNum() + "','" + data.getLocalizacion().getProvincia() + "'.'"
                    + data.getLocalizacion().getCodigoPostal() + "','" + data.getLocalizacion().getPais() + "','" + data.getLocalizacion().getObservaciones() + "','"
                    + data.getTelefono() + "','" + data.getEmail() + "','" + data.getUsuario() + "','" + data.getPassword() + "','" + data.getRol() + ")";
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("No se pudo insertar el voluntario");
        }
    }*/

    /*public void removeData(Connection connection, Voluntario data) {

        try {
            Statement stmt = connection.createStatement();
            String query = "delete from " + TABLA_PERSONAS + " where " + PERSONAS_ID + "=" + data.getId() + "";
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("No se pudo borrar el voluntario");
        }
    }*/
}
