package daoroot.db;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import daoroot.DAO;
import daoroot.DAOException;
import exceptions.DaoException;
import root.Persona;

public class DbVoluntarioDao<T> /*implements DAO<T> */ {
	/*
	final String INSERT = "INSERT INTO personas (idPersona, dni, nombre, apellido1, apellido2, tipoVia, via, num, provincia, cp, pais, observaciones, telefono, email, usuario, password, fk_rol, fk_miembroEquipo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	final String UPDATE = "UPDATE personas SET dni = ?, apellido1 = ?, apellido2 = ?, tipoVia = ?, via = ?, num = ?, provincia = ?, cp = ?, pais = ?, observaciones = ?, telefono = ?, email = ?, usuario = ?, password = ?, fk_rol = ?, fk_miembroEquipo = ? WHERE idPersona = ?";
	final String DELETE = "DELETE FROM personas WHERE idPersona = ?";
	final String GETALL = "SELECT idPersona, nombre, apellido1, apellido2, tipoVia, via, num, provincia, cp, pais, observaciones, telefono, email, usuario, password, fk_rol, fk_miembroEquipo FROM personas";
	final String GETONE = "SELECT idPersona, nombre, apellido1, apellido2, tipoVia, via, num, provincia, cp, pais, observaciones, telefono, email, usuario, password, fk_rol, fk_miembroEquipo FROM personas WHERE idPersona = ?";
	
	private Connection connection;

	public DbVoluntarioDao (Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void crearNuevoArchivo(Persona t) throws DaoException {
	
		PreparedStatement stat = null;
		try {
			stat = connection.prepareStatement(INSERT);
			stat.setInt(1, t.getId());
			stat.setString(2, t.getNombre());
			stat.setString(3, t.getApellido1());
			stat.setString(4, t.getApellido2());
			stat.setString(5, t.getTipoVia());
			stat.setString(6, t.getVia());
			stat.setInt(7, t.getNum());
			stat.setString(8, t.getProvincia());
			stat.setInt(9, t.getCP());
			stat.setString(10, t.getPais());
			stat.setString(11, t.getObservaciones());
			stat.setString(12, t.getTelefono());
			stat.setString(13,  t.getEmail());
			stat.setString(14, t.getUsuario());
			stat.setString(15, t.getPassword());
			stat.setLong(16, t.getRol());
			stat.setString(17, t.getFk_miembroEquipo());
			
			if (stat.executeUpdate() == 0) {
				throw new DAOException ("Puede que no se haya guardado");
			}
			} catch (SQLException ex) {
				throw new DAOException ("Error en SQL", ex);
			}
		finally {
			if (stat != null) {
				try {
				stat.close();
				}catch (SQLException ex){
					throw new DAOException ("Error en SQL", ex);
				}
			}
		  }
		}

	@Override
	public Optional<T> obtenerDatos(String id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizarArchivo(int field, String value, int idArchivo) throws DaoException, NoSuchMethodException,
			InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrarArchivo(String id) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<T> obtenerDatos() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}
*/
}
