package daoroot.xml;

import daoroot.DAO;
import exceptions.DaoException;
import root.Proyecto;
import root.Sede;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Optional;

public class XMLSedeDAO extends XMLDAO<Sede> implements DAO<Sede> {

    private static final String PREFIX_FILE = "sede/sede";
    private static final String PREFIX_PATH = "output/sede";

    public XMLSedeDAO(){
    }

    public void crearNuevaSede(Sede sede) {
        String fileName = this.buildFileName(sede.getIdSede(), PREFIX_FILE);
        this.createDirectoryIfNotExists(PREFIX_PATH);
        this.crearNuevoArchivo(sede, fileName, Sede.class);
    }

    @Override
    public void actualizar(Sede sede) {
    }

    @Override
    public void borrar(Sede sede) {

    }

    @Override
    public List<Sede> obtenerDatos() {
        return null;
    }
}
