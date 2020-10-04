package daoroot.db;

import DBConnector.DBConnector;
import daoroot.DAO;
import enums.LineaAccion;
import enums.SublineaAccion;
import exceptions.DaoException;
import model.HibernateWorks;
import model.Proyecto;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class DbProyectoDao implements DAO<Proyecto>, DbConstants {

    private final DBConnector dbConnector;

    public DbProyectoDao(DBConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    private HibernateWorks hibernate = new HibernateWorks();

    @Override
    public List<Proyecto> listAll() throws DaoException {
        return this.hibernate.listProyectos();
    }

    @Override
    public Optional<Proyecto> findById(int id) throws DaoException {
        return Optional.ofNullable(this.hibernate.queryForProyecto(id));
    }

    @Override
    public void updateFieldById(int field, String value, int idArchivo) throws DaoException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Optional<Proyecto> p = findById(idArchivo);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if (p.isPresent()) {
            Proyecto proyecto = p.get();
            switch (field) {
                case 0:
                    throw new DaoException("El ID no se puede modificar");
                case 1:
                    proyecto.setNombreProyecto(value);
                    break;
                case 2:
                    if(value != null && !value.equals("")){
                        String[] params = value.split(DIR_STR_SEPARATOR);

                        proyecto.setLocalizacion(params[0],
                                params[1],
                                Integer.parseInt(params[2]),
                                params[3],
                                Integer.parseInt(params[4]),
                                params[5],
                                params[6]);
                    }
                    break;
                case 3:
                    LineaAccion lineaAccion = LineaAccion.valueOf(value);
                    proyecto.setLineaAccion(lineaAccion);
                    break;
                case 4:
                    SublineaAccion sublineaAccion = SublineaAccion.NINGUNA;
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

    public void update(Proyecto p) throws DaoException {
        this.hibernate.saveOrUpdate(p);
    }

    @Override
    public void deleteById(int id) throws DaoException {
        this.hibernate.erase(id);
    }

    @Override
    public void create(Proyecto data) throws DaoException {
        this.hibernate.createProyecto(data);
    }
}
