package daoroot.db;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import daoroot.DAO;
import exceptions.DaoException;

public class DbVoluntarioDao<T> implements DAO<T> {

	@Override
	public void crearNuevoArchivo(T t) throws DaoException {
		// TODO Auto-generated method stub
		
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

}
