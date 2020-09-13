package daoroot.db;

import DBConnector.DBConnector;
import daoroot.DAO;
import root.Proyecto;
import root.Voluntario;
import root.MiembroEquipo;
import enums.Rol;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import exceptions.DaoException;


public class DbVoluntarioDao implements DAO<Voluntario>, DbConstants {

    private final DBConnector dbConnector;

    public DbVoluntarioDao(DBConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    @Override
    public List<Voluntario> listAll() throws DaoException {
        List<Voluntario> listaVoluntarios = new ArrayList<>();
        Connection connection = null;
        try {
            connection = dbConnector.connect();

            Statement stmt = connection.createStatement();
            String query = "Select * from " + TABLA_PERSONAS;
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Voluntario v = resultSetToVoluntario(rs);
                listaVoluntarios.add(v);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dbConnector.disconnect(connection);
        }
        return listaVoluntarios;
    }

    @Override
    public Optional<Voluntario> findById(int id) throws DaoException {
        Voluntario voluntario = null;
        Connection connection = null;
        try {
            connection = dbConnector.connect();

            PreparedStatement stmt = connection.prepareStatement("Select * from " + TABLA_PERSONAS+ " where "+PERSONAS_ID+ " = ? LIMIT 1");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                voluntario = resultSetToVoluntario(rs);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dbConnector.disconnect(connection);
        }
        return Optional.ofNullable(voluntario);
    }

    @Override
    public void updateFieldById(int field, String value, int idArchivo) throws DaoException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Optional<Voluntario> v = findById(idArchivo);
            if (v.isPresent()) {
            Voluntario voluntario = v.get();
            switch (field) {
                case 0:
                    throw new DaoException("El ID no se puede modificar");
                case 1:
                    voluntario.setDni(value);
                    break;
                case 2:
                	voluntario.setNombre(value);
                    break;
                case 3:
                	voluntario.setApellido1(value);
                    break;
                case 4:
                	voluntario.setApellido2(value);
                    break;
                case 5:
                	voluntario.setDireccion(value);
                    break;
                case 6:
                	voluntario.setTelefono(value);
                    break;
                case 7:
                	voluntario.setEmail(value);
                    break;
                case 8:
                	voluntario.setUsuario(value);
                    break;
                case 9:
                	voluntario.setPassword(value);
                    break;
                case 10:
                	voluntario.setRol(value);
                    break;   
                case 11:
                	voluntario.setMiembroEquipo(value);
                    break; 
                
            }

            update(voluntario);
        }
    }

    public void update(Voluntario data) throws DaoException {
        Connection connection = null;
        try {
            connection = dbConnector.connect();
            PreparedStatement stmt = connection.prepareStatement("Update "+TABLA_PERSONAS+" set "+
                    PERSONAS_DNI +" = ?," +
                    PERSONAS_NOMBRE +" = ?," +
                    PERSONAS_APELLIDO1 +" = ?," +
                    PERSONAS_APELLIDO2 +" = ?," +
                    PERSONAS_TIPOVIA +" = ?," +
                    PERSONAS_VIA +" = ?," +
                    PERSONAS_NUM +" = ?," +
                    PERSONAS_PROVINCIA +" = ?," +
                    PERSONAS_CP +" = ?," +
                    PERSONAS_PAIS +" = ?," +
                    PERSONAS_OBSERVACIONES +" = ?," +
                    PERSONAS_TELEFONO +" = ?," +
                    PERSONAS_EMAIL +" = ?, " +
                    PERSONAS_USUARIO +" = ? " +
                    PERSONAS_PASSWORD +" = ? " +
                    PERSONAS_ROL +" = ? " +
                    PERSONAS_MIEMBROEQUIPO +" = ? " +
                    " where "+PROYECTOS_ID+"= ?");

            int n = 1;
            // campos, respetar el orden

            
            stmt.setInt(n++, data.getId());
            stmt.setString(n++, data.getDni());
            stmt.setString(n++, data.getNombre());
            stmt.setString(n++, data.getApellido1());
            stmt.setString(n++, data.getApellido2());
            stmt.setString(n++, data.getDireccion().getTipoVia());
            stmt.setString(n++, data.getDireccion().getVia());
            stmt.setInt(n++, data.getDireccion().getNum());
            stmt.setString(n++, data.getDireccion().getProvincia());
            stmt.setInt(n++, data.getDireccion().getCP());
            stmt.setString(n++, data.getDireccion().getPais());
            stmt.setString(n++, data.getDireccion().getObservaciones());
            stmt.setString(n++, data.getTelefono());
            stmt.setString(n++, data.getEmail());
            stmt.setString(n++, data.getUsuario());
            stmt.setString(n++, data.getPassword());
            stmt.setString(n++, data.getRol()!= null ? data.getRol().name() : "");
            stmt.setString(n++, data.getMiembroEquipo()!= null ? data.getMiembroEquipo().name() : "");
            
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
            PreparedStatement stmt = connection.prepareStatement("delete from " + TABLA_PERSONAS + " where " + PERSONAS_ID + "= ?");
            stmt.setInt(1, id);
            int updated = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("No se pudo borrar el voluntario");
        }
    }

    @Override
    public void create(Voluntario data) throws DaoException {
        Connection connection = null;
        try {
            connection = dbConnector.connect();
            PreparedStatement stmt = connection.prepareStatement("insert into "+TABLA_PERSONAS+" ("+
                    // campos, respetar el orden
                    PERSONAS_ID+", "+
                    PERSONAS_DNI+", "+
                    PERSONAS_NOMBRE+", "+
                    PERSONAS_APELLIDO1+", "+
                    PERSONAS_APELLIDO2+", "+
                    PERSONAS_TIPOVIA+", "+
                    PERSONAS_VIA+", "+
                    PERSONAS_NUM+", "+
                    PERSONAS_PROVINCIA+", "+
                    PERSONAS_CP+", "+
                    PERSONAS_PAIS+", "+
                    PERSONAS_OBSERVACIONES+", "+
                    PERSONAS_TELEFONO+", "+
                    PERSONAS_EMAIL+", "+
                    PERSONAS_USUARIO+", "+
                    PERSONAS_PASSWORD+", "+
                    PERSONAS_ROL+", "+
                    PERSONAS_MIEMBROEQUIPO+") "+
                    " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");

            int n = 1;
            // datos, respetar el orden

                stmt.setInt(n++, data.getId());
                stmt.setString(n++, data.getDni());
                stmt.setString(n++, data.getNombre());
                stmt.setString(n++, data.getApellido1());
                stmt.setString(n++, data.getApellido2());
            if (data.getDireccion() != null) {
                stmt.setString(n++, data.getDireccion().getTipoVia());
                stmt.setString(n++, data.getDireccion().getVia());
                stmt.setInt(n++, data.getDireccion().getNum());
                stmt.setString(n++, data.getDireccion().getProvincia());
                stmt.setInt(n++, data.getDireccion().getCP());
                stmt.setString(n++, data.getDireccion().getPais());
                stmt.setString(n++, data.getDireccion().getObservaciones());
            }else {
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
            stmt.setString(n++, data.getUsuario());
            stmt.setString(n++, data.getPassword());
            stmt.setInt(n++, data.getRol()!= null ? data.getRol().ordinal() + 1 : 1);
            stmt.setInt(n++, data.getMiembroEquipo()!= null ? data.getMiembroEquipo().ordinal() + 1 : 1);
            
            int updated = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dbConnector.disconnect(connection);
        }
    }

    private Voluntario resultSetToVoluntario(ResultSet rs) throws SQLException {

        Rol rol = null;
        try {
            String srol = rs.getString(PERSONAS_ROL);
            //restar 1 al array del enum ROL, porque en bbdd empiezan desde el indice 1, y en el enum del 0
            rol = srol != null && !srol.equals("") ? Rol.values()[Integer.parseInt(srol) - 1]: null;
        } catch (NullPointerException e) {
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Voluntario(
                rs.getInt(PERSONAS_ID),
                rs.getString(PERSONAS_DNI),
                rs.getString(PROYECTOS_NOMBRE),
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
                rs.getString(PERSONAS_EMAIL),
                rs.getString(PERSONAS_USUARIO),
                rs.getString(PERSONAS_PASSWORD),
                rol
                );
    }
}
