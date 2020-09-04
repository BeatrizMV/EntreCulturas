package daoroot.xml;

import daoroot.DAO;
import exceptions.DaoException;
import others.Helper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class XMLDAO<T> implements DAO<T> {
    private static final String INITIAL_OUTPUT_DIR_PATH = "output/";
    private static final String SUFFIX_FILE = ".xml";
    private static final String ID_SEPARATOR = "_";

    protected String subfolderPrefixFile;
    protected String prefixPath;
    protected Class clase;
    private String fileName;

    public final void create(T t) {
        try {
            Field field = Helper.findFieldInTopParent(clase, "id");
            field.setAccessible(true);
            int number = (int) field.get(t);

            File file = new File(buildFileName(number, subfolderPrefixFile));
            JAXBContext contextObj = JAXBContext.newInstance(clase);
            Marshaller marshallerObj = contextObj.createMarshaller();
            marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            marshallerObj.marshal(t, file);

        } catch (JAXBException | IllegalAccessException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    public final Optional<T> findById(int id) {
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

    public final List<T> listAll() throws DaoException {
        File outDir = new File(prefixPath);
        String[] fileNameList = outDir.list();
        List<T> retList = new ArrayList<>();
        for (String fileName : fileNameList) {
            int id = extraerId(fileName);
            Optional<T> retOpt = this.findById(id);
            if (retOpt.isPresent()) {
                retList.add(retOpt.get());
            }
        }
        return retList;
    }

    public final void updateFieldById(int field, String value, int idArchivo) throws DaoException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Object t = null;

        Optional<T> dataOptional = findById(idArchivo);
        File file = new File(buildFileName(idArchivo, subfolderPrefixFile));

        if (dataOptional.isPresent()) {
            t = dataOptional.get();
        } else {
            throw new DaoException("El archivo no existe o está vacío");
        }

        updateFile(t, field, value);
    }

    public final void deleteById(int id) throws DaoException {
        File file = new File(this.buildFileName(id, subfolderPrefixFile));
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("El archivo se ha borrado correctamente");
            } else {
                throw new DaoException("No se ha podido eliminar el fichero con ID " + id);
            }
        }
    }

    private int extraerId(String fileName) {
        if (fileName != null && !fileName.isEmpty()) {
            String[] splitRes = fileName.split(ID_SEPARATOR);
            fileName = splitRes[1];
            splitRes = fileName.split("\\.");
            return Integer.parseInt(splitRes[0]);
        }
        return -1;
    }

    // Este metodo está vacío porque esta implementado en los hijos
    abstract void updateFile(Object t, int field, String value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, DaoException, NoSuchFieldException;

    protected String buildFileName(int id, String prefixFile) {
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

    protected void createDirectoryIfNotExists(String path) {
        File f = new File(path);
        if (!checkIfDirectoryExists(f)) {
            f.mkdirs();
        }
    }

    protected boolean checkIfDirectoryExists(File f) {
        if (!f.exists()) {
            return false;
        }
        return true;
    }

    public Class<?> getFieldType(T t, String fieldName) throws NoSuchFieldException {
        Class<?> type = null;

        type = t.getClass().getDeclaredField(fieldName).getType();

        return type;
    }
}
