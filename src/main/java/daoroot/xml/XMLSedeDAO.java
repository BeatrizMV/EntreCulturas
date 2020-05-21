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

    public XMLSedeDAO() {
        this.subfolderPrefixFile = "sede/sede";
        this.prefixPath = "output/sede";
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