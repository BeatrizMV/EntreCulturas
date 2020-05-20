package daoroot.xml;

import daoroot.DAO;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Optional;

public class XMLDAO<T> {
    private static final String OUTPUT_DIR_PATH = "output/";
    private static final String SUFFIX_FILE = ".xml";
    private static final String ID_SEPARATOR = "_";

    public final void crearNuevoArchivo(T t, String fileName, Class c) {
        try {
            File file = new File(fileName);
            JAXBContext contextObj = JAXBContext.newInstance(c);
            Marshaller marshallerObj = contextObj.createMarshaller();
            marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            createDirectoryIfNotExists();

            marshallerObj.marshal(t, file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public final Optional<T> obtenerDatos(String id, String filePath, Class c) {
        File file = new File(filePath);
        if(!file.exists()){
            return Optional.empty();
        }
        T t = null;

        try {
            JAXBContext context = JAXBContext.newInstance(c);
            Unmarshaller unmarshaller = null;
            unmarshaller = context.createUnmarshaller();
            t = (T) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(t);
    }

    protected String buildFileName(String id, String prefixFile) {
        return OUTPUT_DIR_PATH + prefixFile + ID_SEPARATOR + id + ID_SEPARATOR + SUFFIX_FILE;
    }

    protected String buildFileName(int id, String prefixFile) {
        return this.buildFileName(String.valueOf(id), prefixFile);
    }

    protected void showCreatedMessage(String message){
        System.out.println(message);
    }

    protected void createDirectoryIfNotExists(){
        File f = new File("output/");
        if(!checkIfDirectoryExists(f)){
            f.mkdirs();
        }
    };

    protected void createDirectoryIfNotExists(String path){
        File f = new File(path);
        if(!checkIfDirectoryExists(f)){
            f.mkdirs();
        }
    };

    protected boolean checkIfDirectoryExists(File f){
        if(!f.exists()){
            return false;
        }
        return true;
    }
}
