package daoroot.xml;

import exceptions.DaoException;
import root.Sede;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

public class XMLDAO<T> {
    private static final String INITIAL_OUTPUT_DIR_PATH = "output/";
    private static final String SUFFIX_FILE = ".xml";
    private static final String ID_SEPARATOR = "_";

    protected String subfolderPrefixFile;
    protected String prefixPath;
    protected Class clase;
    private String fileName;

    public final void crearNuevoArchivo(T t) {
        try {
            Field field = clase.getDeclaredField("id");
            field.setAccessible(true);
            int number = (int) field.get(t);

            File file = new File(buildFileName(Integer.toString(number), subfolderPrefixFile));
            JAXBContext contextObj = JAXBContext.newInstance(clase);
            Marshaller marshallerObj = contextObj.createMarshaller();
            marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            marshallerObj.marshal(t, file);

        } catch (JAXBException | NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public final Optional<T> obtenerDatos(String id) {
        File file = new File(this.buildFileName(id, subfolderPrefixFile));
        if (!file.exists()) {
            return Optional.empty();
        }

        T t = null;

        try {
            JAXBContext context = JAXBContext.newInstance(clase);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            t = (T) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(t);
    }

    public final void actualizarArchivo(int field, String value, int idArchivo) throws DaoException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // TODO: Get file and update it

        T t = null;

        Optional<T> dataOptional = obtenerDatos(Integer.toString(idArchivo));
        File file = new File(buildFileName(Integer.toString(idArchivo), subfolderPrefixFile));

        if(dataOptional.isPresent()){
            t = (T) dataOptional.get();
        } else {
            throw new DaoException("El archivo no existe o está vacío");
        }

        switch (field) {
            case 0:
                throw new DaoException("El ID no se puede modificar");
            case 1:
                t.getClass().getDeclaredMethod("setNombreSede").invoke(value);
                break;
        }
    }

    public final void borrarArchivo(String id) throws DaoException {
        File file = new File(this.buildFileName(id, subfolderPrefixFile));
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("El archivo se ha borrado correctamente");
            } else {
                throw new DaoException("No se ha podido eliminar el fichero con ID " + id);
            }
        }
    }

    protected String buildFileName(String id, String prefixFile) {
        createDirectoryIfNotExists();
        createDirectoryIfNotExists(prefixPath);
        return INITIAL_OUTPUT_DIR_PATH + prefixFile + ID_SEPARATOR + id + SUFFIX_FILE;
    }

    protected void showCreatedMessage(String message) {
        System.out.println(message);
    }

    protected void createDirectoryIfNotExists() {
        File f = new File("output/");
        if (!checkIfDirectoryExists(f)) {
            f.mkdirs();
        }
    }

    ;

    protected void createDirectoryIfNotExists(String path) {
        File f = new File(path);
        if (!checkIfDirectoryExists(f)) {
            f.mkdirs();
        }
    }

    ;

    protected boolean checkIfDirectoryExists(File f) {
        if (!f.exists()) {
            return false;
        }
        return true;
    }

    public String getFileName() {
        return fileName;
    }

    public XMLDAO<T> setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }
}
