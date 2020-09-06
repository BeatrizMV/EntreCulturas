package daoroot.db;

import DBConnector.DBConnector;
import daoroot.DAO;
import enums.LineaAccion;
import enums.SublineaAccion;
import exceptions.DaoException;
import root.Proyecto;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DbProyectoDao implements DAO<Proyecto>, DbConstants {

    private final DBConnector dbConnector;

    public DbProyectoDao(DBConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    @Override
    public List<Proyecto> listAll() throws DaoException {
        List<Proyecto> listaProyectos = new ArrayList<>();
        Connection connection = null;
        try {
            connection = dbConnector.connect();

            Statement stmt = connection.createStatement();
            String query = "Select * from " + TABLA_PROYECTOS;
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Proyecto p = resultSetToProyecto(rs);
                listaProyectos.add(p);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dbConnector.disconnect(connection);
        }
        return listaProyectos;
    }

    @Override
    public Optional<Proyecto> findById(int id) throws DaoException {
        Proyecto proyecto = null;
        Connection connection = null;
        try {
            connection = dbConnector.connect();

            PreparedStatement stmt = connection.prepareStatement("Select * from " + TABLA_PROYECTOS+ " where "+PROYECTOS_ID+ " = ? LIMIT 1");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                proyecto = resultSetToProyecto(rs);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dbConnector.disconnect(connection);
        }
        return Optional.ofNullable(proyecto);
    }

    @Override
    public void updateFieldById(int field, String value, int idArchivo) throws DaoException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Optional<Proyecto> p = findById(idArchivo);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if (p.isPresent()) {
            Proyecto proyecto = p.get();
            switch (field) {
                case 0:
                    throw new DaoException("El ID no se puede modificar");
                case 1:
                    proyecto.setNombreProyecto(value);
                    break;
                case 2:
                    // no implementado
                    break;
                case 3:
                    LineaAccion lineaAccion = LineaAccion.valueOf(value);
                    proyecto.setLineaAccion(lineaAccion);
                    break;
                case 4:
                    SublineaAccion sublineaAccion = SublineaAccion.valueOf(value);
                    proyecto.setSublineaAccion(sublineaAccion);
                    break;
                case 5:
                    proyecto.setFechaInicio(LocalDate.parse(value, formatter));
                    break;
                case 6:
                    proyecto.setFechaFin(LocalDate.parse(value, formatter));
                    break;
                case 7:
                    proyecto.setSocioLocal(value);
                    break;
                case 8:
                    proyecto.setAccionesRealizar(value);
                    break;
            }

            update(proyecto);
        }
    }

    public void update(Proyecto data) throws DaoException {
        Connection connection = null;
        try {
            connection = dbConnector.connect();
            PreparedStatement stmt = connection.prepareStatement("Update "+TABLA_PROYECTOS+" set "+
                    PROYECTOS_ID +" = ?," +
                    PROYECTOS_NOMBRE +" = ?," +
                    PROYECTOS_TIPOVIA +" = ?," +
                    PROYECTOS_VIA +" = ?," +
                    PROYECTOS_NUM +" = ?," +
                    PROYECTOS_PROVINCIA +" = ?," +
                    PROYECTOS_CP +" = ?," +
                    PROYECTOS_PAIS +" = ?," +
                    PROYECTOS_OBSERVACIONES +" = ?," +
                    PROYECTOS_FECHAINCIO +" = ?," +
                    PROYECTOS_FECHAFIN +" = ?," +
                    PROYECTOS_SOCIOLOCAL +" = ?," +
                    PROYECTOS_ACCIONES +" = ?," +
                    PROYECTOS_LINEACCION +" = ?, " +
                    PROYECTOS_SUBLINEA +" = ? " +
                    " where "+PROYECTOS_ID+"= ?");

            int n = 1;
            // campos, respetar el orden

            Date fechaInicio = data.getFechaInicio() != null ? new java.sql.Date(Date.from(data.getFechaInicio().atStartOfDay(ZoneId.systemDefault()).toInstant()).getTime()) : null;
            Date fechaFin = data.getFechaFin() != null ? new java.sql.Date(Date.from(data.getFechaFin().atStartOfDay(ZoneId.systemDefault()).toInstant()).getTime()) : null;


            stmt.setInt(n++, data.getCodigoProyecto());
            stmt.setString(n++, data.getNombreProyecto());
            stmt.setString(n++, data.getLocalizacion().getTipoVia());
            stmt.setString(n++, data.getLocalizacion().getVia());
            stmt.setInt(n++, data.getLocalizacion().getNum());
            stmt.setString(n++, data.getLocalizacion().getProvincia());
            stmt.setInt(n++, data.getLocalizacion().getCodigoPostal());
            stmt.setString(n++, data.getLocalizacion().getPais());
            stmt.setString(n++, data.getLocalizacion().getObservaciones());
            stmt.setDate(n++, fechaInicio);
            stmt.setDate(n++, fechaFin);
            stmt.setString(n++, data.getSocioLocal());
            stmt.setString(n++, data.getAccionesRealizar());
            stmt.setString(n++, data.getLineaAccion() != null ? data.getLineaAccion().name() : "");
            stmt.setString(n++, data.getSublineaAccion() != null ? data.getSublineaAccion().name() : "");

            // where
            stmt.setInt(n++, data.getCodigoProyecto());
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
            PreparedStatement stmt = connection.prepareStatement("delete from " + TABLA_PROYECTOS + " where " + PROYECTOS_ID + "= ?");
            stmt.setInt(1, id);
            int updated = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("No se pudo borrar el proyecto");
        }
    }

    @Override
    public void create(Proyecto data) throws DaoException {
        Connection connection = null;
        try {
            connection = dbConnector.connect();
            PreparedStatement stmt = connection.prepareStatement("insert into "+TABLA_PROYECTOS+" ("+
                    // campos, respetar el orden
                    PROYECTOS_ID+", "+
                    PROYECTOS_NOMBRE+", "+
                    PROYECTOS_TIPOVIA+", "+
                    PROYECTOS_VIA+", "+
                    PROYECTOS_NUM+", "+
                    PROYECTOS_PROVINCIA+", "+
                    PROYECTOS_CP+", "+
                    PROYECTOS_PAIS+", "+
                    PROYECTOS_OBSERVACIONES+", "+
                    PROYECTOS_FECHAINCIO+", "+
                    PROYECTOS_FECHAFIN+", "+
                    PROYECTOS_SOCIOLOCAL+", "+
                    PROYECTOS_ACCIONES+", "+
                    PROYECTOS_LINEACCION+", "+
                    PROYECTOS_SUBLINEA+") "+
                    " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");

            int n = 1;
            // datos, respetar el orden

            Date fechaInicio = data.getFechaInicio() != null ? new java.sql.Date(Date.from(data.getFechaInicio().atStartOfDay(ZoneId.systemDefault()).toInstant()).getTime()) : null;
            Date fechaFin = data.getFechaFin() != null ? new java.sql.Date(Date.from(data.getFechaFin().atStartOfDay(ZoneId.systemDefault()).toInstant()).getTime()) : null;

            stmt.setInt(n++, data.getCodigoProyecto());
            stmt.setString(n++, data.getNombreProyecto());
            stmt.setString(n++, data.getLocalizacion().getTipoVia());
            stmt.setString(n++, data.getLocalizacion().getVia());
            stmt.setInt(n++, data.getLocalizacion().getNum());
            stmt.setString(n++, data.getLocalizacion().getProvincia());
            stmt.setInt(n++, data.getLocalizacion().getCodigoPostal());
            stmt.setString(n++, data.getLocalizacion().getPais());
            stmt.setString(n++, data.getLocalizacion().getObservaciones());
            stmt.setDate(n++, fechaInicio);
            stmt.setDate(n++, fechaFin);
            stmt.setString(n++, data.getSocioLocal());
            stmt.setString(n++, data.getAccionesRealizar());
            stmt.setString(n++, data.getLineaAccion() != null ? data.getLineaAccion().name() : "");
            stmt.setString(n++, data.getSublineaAccion() != null ? data.getSublineaAccion().name() : "");

            int updated = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dbConnector.disconnect(connection);
        }
    }

    private Proyecto resultSetToProyecto(ResultSet rs) throws SQLException {
        LineaAccion lineaAccion = null;
        try {
            String slineaAccion = rs.getString(PROYECTOS_LINEACCION);
            //restar 1 al array del enum lineaccion, porque en bbdd empiezan desde el indice 1, y en el enum del 0
            lineaAccion = slineaAccion != null && !slineaAccion.equals("") ? LineaAccion.values()[Integer.parseInt(slineaAccion) - 1]: null;
        } catch (NullPointerException e) {
        } catch (Exception e) {
            e.printStackTrace();
        }

        SublineaAccion sublineaAccion = null;

        // OJO: Descomentar cuando en el futuro se decida añadir las sublineas
//        try {
//            String ssublineaAccion = rs.getString(PROYECTOS_SUBLINEA);
//            sublineaAccion = ssublineaAccion != null && !ssublineaAccion.equals("") ? SublineaAccion.valueOf(ssublineaAccion): null;
//    } catch (NullPointerException e) {
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        return new Proyecto(
                rs.getInt(PROYECTOS_ID),
                rs.getString(PROYECTOS_NOMBRE),
                lineaAccion,
                sublineaAccion,
                rs.getDate(PROYECTOS_FECHAINCIO).toLocalDate(),
                //fecha final puede ser null
                rs.getDate(PROYECTOS_FECHAFIN) == null ? null : rs.getDate(PROYECTOS_FECHAFIN).toLocalDate(),
                rs.getString(PROYECTOS_SOCIOLOCAL),
                rs.getString(PROYECTOS_ACCIONES),
                rs.getString(PROYECTOS_TIPOVIA),
                rs.getString(PROYECTOS_VIA),
                rs.getInt(PROYECTOS_NUM),
                rs.getString(PROYECTOS_PROVINCIA),
                rs.getInt(PROYECTOS_CP),
                rs.getString(PROYECTOS_PAIS),
                rs.getString(PROYECTOS_OBSERVACIONES));
    }
}
