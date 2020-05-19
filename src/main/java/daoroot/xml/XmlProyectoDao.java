package daoroot.xml;

import daoroot.XmlDao;
import exceptions.DaoException;
import root.Proyecto;

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

public class XmlProyectoDao extends XmlDao<Proyecto> {

	private static final String OUTPUT_DIR_PATH = "output/proyectos";
	private static final String PREFIX_FILE = OUTPUT_DIR_PATH + "/proyecto";
	private static final String SUFFIX_FILE = ".xml";
	private static final String ID_SEPARATOR = "_";

	@Override
	public void crearNuevo(Proyecto pro) throws DaoException {


		try(FileOutputStream fo = new FileOutputStream(this.buildFileName(pro.getCodigoProyecto()))) {
			JAXBContext contextObj = JAXBContext.newInstance(Proyecto.class);
			Marshaller marshallerObj = contextObj.createMarshaller();
			marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshallerObj.marshal(pro, fo );
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
	public Optional<Proyecto> obtener(String id) throws DaoException {
		if(! new File(this.buildFileName(id)).exists()) {
			return Optional.empty();
		}
		Proyecto pro=null;
		try {
			JAXBContext context = JAXBContext.newInstance( Proyecto.class );
			Unmarshaller unmarshaller = null;
			unmarshaller = context.createUnmarshaller();
			pro = (Proyecto) unmarshaller.unmarshal(
					new File(this.buildFileName(id)) );
		} catch (JAXBException e) {
			throw new DaoException("Error al obtener:", e);
		}

		return Optional.ofNullable(pro);
	}

	@Override
	public void actualizar(Proyecto t) throws DaoException {
		//Ya que al escribir se sobreescribe, reutilizar 'crearNuevo'
		this.crearNuevo(t);
	}

	@Override
	public void borrar(Proyecto t) throws DaoException {
		File file = new File(this.buildFileName(t.getCodigoProyecto()));
		if(file.exists()) {
			if(file.delete()) {
				System.out.println("Successfully deleted");
			} else {
				throw new DaoException("Could not delete the file for proyecto with id ");
			}
		}
	}

	@Override
	public List<Proyecto> obtenerDatos() throws DaoException {
		File outDir = new File(OUTPUT_DIR_PATH);
		String[] fileNameList = outDir.list();
		List<Proyecto> retList = new ArrayList<>();
		for(String fileName : fileNameList) {
			String id = extraerId(fileName);
			Optional<Proyecto> retOpt = this.obtener(id);
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
