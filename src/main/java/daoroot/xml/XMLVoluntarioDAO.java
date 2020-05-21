package daoroot.xml;

import daoroot.XmlDao;
import exceptions.DaoException;
import root.Voluntario;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class XMLVoluntarioDAO extends XmlDao<Voluntario> {

    private static final String OUTPUT_DIR_PATH = "output/voluntarios";
    private static final String PREFIX_FILE = OUTPUT_DIR_PATH + "/voluntario";
    private static final String SUFFIX_FILE = ".xml";
    private static final String ID_SEPARATOR = "_";

    @Override
    public void crearNuevo(Voluntario voluntario) throws DaoException {


        try(FileOutputStream fo = new FileOutputStream(this.buildFileName(voluntario.getIdPersona()))) {
            JAXBContext contextObj = JAXBContext.newInstance(Voluntario.class);
            Marshaller marshallerObj = contextObj.createMarshaller();
            marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshallerObj.marshal(voluntario, fo );
        } catch (JAXBException | IOException e) {
            throw new DaoException("Error al crear:", e);
        }
    }

    private String buildFileName(String id) {
        return PREFIX_FILE + ID_SEPARATOR  + id + ID_SEPARATOR + SUFFIX_FILE;
    }

    private String buildFileName(int id) {
        return this.buildFileName(String.valueOf(id));
    }

    @Override
    public Optional<Voluntario> obtener(String id) throws DaoException {
        if(! new File(this.buildFileName(id)).exists()) {
            return Optional.empty();
        }
        Voluntario voluntario=null;
        try {
            JAXBContext context = JAXBContext.newInstance( Voluntario.class );
            Unmarshaller unmarshaller = null;
            unmarshaller = context.createUnmarshaller();
            voluntario = (Voluntario) unmarshaller.unmarshal(
                    new File(this.buildFileName(id)) );
        } catch (JAXBException e) {
            throw new DaoException("Error al obtener:", e);
        }

        return Optional.ofNullable(voluntario);
    }

    @Override
    public void actualizar(Voluntario t) throws DaoException {
        //Ya que al escribir se sobreescribe, reutilizar 'crearNuevo'
        this.crearNuevo(t);
    }

    @Override
    public void borrar(Voluntario t) throws DaoException {
        File file = new File(this.buildFileName(t.getIdPersona()));
        if(file.exists()) {
            if(file.delete()) {
                System.out.println("Successfully deleted");
            } else {
                throw new DaoException("Could not delete the file for voluntario with id ");
            }
        }
    }

    @Override
    public List<Voluntario> obtenerDatos() throws DaoException {
        File outDir = new File(OUTPUT_DIR_PATH);
        String[] fileNameList = outDir.list();
        List<Voluntario> retList = new ArrayList<>();
        for(String fileName : fileNameList) {
            String id = extraerId(fileName);
            Optional<Voluntario> retOpt = this.obtener(id);
            if(retOpt.isPresent()) {
                retList.add(retOpt.get());
            }
        }
        return retList;
    }

    private String extraerId(String fileName) {
        if(fileName != null && !fileName.isEmpty()) {
            String[] splitRes = fileName.split(ID_SEPARATOR);
            return splitRes[1];
        }
        return "";
    }
}