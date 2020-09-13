package daoroot.db;

import DBConnector.DBConnector;
import daoroot.DAO;
import exceptions.DaoException;
import root.Sede;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DbSedeDao implements DAO<Sede>, DbConstants {

    private final DBConnector dbConnector;

    public DbSedeDao(DBConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    @Override
    public List<Sede> listAll() throws DaoException {
        List<Sede> listaSedes = new ArrayList<>();
        Connection connection = null;
        try {
            connection = dbConnector.connect();

            Statement stmt = connection.createStatement();
            String query = "Select * from " + TABLA_SEDES;
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Sede s = resultSetToSede(rs);
                listaSedes.add(s);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dbConnector.disconnect(connection);
        }
        return listaSedes;
    }

    @Override
    public Optional<Sede> findById(int id) throws DaoException {
        Sede sede = null;
        Connection connection = null;
        try {
            connection = dbConnector.connect();

            PreparedStatement stmt = connection.prepareStatement("Select * from " + TABLA_SEDES+ " where "+SEDES_ID+ " = ? LIMIT 1");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                sede = resultSetToSede(rs);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dbConnector.disconnect(connection);
        }
        return Optional.ofNullable(sede);
    }

    @Override
    public void updateFieldById(int field, String value, int idArchivo) throws DaoException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Optional<Sede> s = findById(idArchivo);
       
        if (s.isPresent()) {
            Sede sede = s.get();
            switch (field) {
                case 0:
                    throw new DaoException("El ID no se puede modificar");
                case 1:
                    sede.setNombreSede(value);
                    break;
                case 2:
                	sede.setDireccion(value);
                    break;
                case 3:
                	sede.setTelefono(value);
                    break;
                case 4:
                	sede.setEmail(value);
                    break;
                case 5:
                	sede.setCentral(value);
                    break;

            }

            update(sede);
        }
    }

    public void update(Sede data) throws DaoException {
        Connection connection = null;
        try {
            connection = dbConnector.connect();
            PreparedStatement stmt = connection.prepareStatement("Update "+TABLA_SEDES+" set "+
                    SEDES_ID +" = ?," +
                    SEDES_NOMBRE +" = ?," +
                    SEDES_TIPOVIA +" = ?," +
                    SEDES_VIA +" = ?," +
                    SEDES_NUM +" = ?," +
                    SEDES_PROVINCIA +" = ?," +
                    SEDES_CP +" = ?," +
                    SEDES_PAIS +" = ?," +
                    SEDES_OBSERVACIONES +" = ?," +
                    SEDES_TELEFONO +" = ?," +
                    SEDES_EMAIL +" = ?," +
                    SEDES_CENTRAL +" = ?," +
                    " where "+SEDES_ID+"= ?");

            int n = 1;
            // campos, respetar el orden
           
            stmt.setInt(n++, data.getId());
            stmt.setString(n++, data.getNombreSede());
            stmt.setString(n++, data.getDireccion().getTipoVia());
            stmt.setString(n++, data.getDireccion().getVia());
            stmt.setInt(n++, data.getDireccion().getNum());
            stmt.setString(n++, data.getDireccion().getProvincia());
            stmt.setInt(n++, data.getDireccion().getCodigoPostal());
            stmt.setString(n++, data.getDireccion().getPais());
            stmt.setString(n++, data.getDireccion().getObservaciones());
            stmt.setString(n++, data.getTelefono());
            stmt.setString(n++, data.getEmail());
            stmt.setString(n++, data.isCentral() ? null : "false");
           
            // where
            stmt.setInt(n++, data.getId());
            int updated = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dbConnector.disconnect(connection);
        }
    }

    @Override
    public void deleteById(int id) throws DaoException {
        Connection connection = null;
        try {
            connection = dbConnector.connect();
            PreparedStatement stmt = connection.prepareStatement("delete from " + TABLA_SEDES + " where " + SEDES_ID + "= ?");
            stmt.setInt(1, id);
            int updated = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("No se pudo borrar la sede");
        }
    }

    @Override
    public void create(Sede data) throws DaoException {
        Connection connection = null;
        try {
            connection = dbConnector.connect();
            PreparedStatement stmt = connection.prepareStatement("insert into "+TABLA_SEDES+" ("+
                    // campos, respetar el orden
                    SEDES_ID+", "+
                    SEDES_NOMBRE+", "+
                    SEDES_TIPOVIA+", "+
                    SEDES_VIA+", "+
                    SEDES_NUM+", "+
                    SEDES_PROVINCIA+", "+
                    SEDES_CP+", "+
                    SEDES_PAIS+", "+
                    SEDES_OBSERVACIONES+", "+
                    SEDES_TELEFONO+", "+
                    SEDES_EMAIL+", "+
                    SEDES_CENTRAL+", "+
                    " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");

            int n = 1;
            // datos, respetar el orden

            stmt.setInt(n++, data.getId());
            stmt.setString(n++, data.getNombreSede());
            if (data.getDireccion() != null) {
                stmt.setString(n++, data.getDireccion().getTipoVia());
                stmt.setString(n++, data.getDireccion().getVia());
                stmt.setInt(n++, data.getDireccion().getNum());
                stmt.setString(n++, data.getDireccion().getProvincia());
                stmt.setInt(n++, data.getDireccion().getCodigoPostal());
                stmt.setString(n++, data.getDireccion().getPais());
                stmt.setString(n++, data.getDireccion().getObservaciones());
            }else{
                stmt.setString(n++, "No especificado");
                stmt.setString(n++,"No especificado");
                stmt.setInt(n++,0);
                stmt.setString(n++, "No especificado");
                stmt.setInt(n++, 0);
                stmt.setString(n++, "No especificado");
                stmt.setString(n++, "No especificado");
            }
            stmt.setString(n++, data.getTelefono());
            stmt.setString(n++, data.getEmail());
            stmt.setString(n++, data.isCentral() ? null : "false");
            
            int updated = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dbConnector.disconnect(connection);
        }
    }

    private Sede resultSetToSede(ResultSet rs) throws SQLException {
    
        // OJO: Descomentar cuando esten las sublineas
//        try {
//            String ssublineaAccion = rs.getString(PROYECTOS_SUBLINEA);
//            sublineaAccion = ssublineaAccion != null && !ssublineaAccion.equals("") ? SublineaAccion.valueOf(ssublineaAccion): null;
//    } catch (NullPointerException e) {
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        return new Sede(
                rs.getInt(SEDES_ID),
                rs.getString(SEDES_NOMBRE),
                rs.getString(SEDES_TIPOVIA),
                rs.getString(SEDES_VIA),
                rs.getInt(SEDES_NUM),
                rs.getString(SEDES_PROVINCIA),
                rs.getInt(SEDES_CP),
                rs.getString(SEDES_PAIS),
                rs.getString(SEDES_OBSERVACIONES),
                rs.getString(SEDES_TELEFONO),
                rs.getString(SEDES_EMAIL),
                rs.getString(SEDES_CENTRAL));
    }
}
