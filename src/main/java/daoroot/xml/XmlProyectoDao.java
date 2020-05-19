package daoroot.xml;

import daoroot.XmlDaoFactory;
import root.Proyecto;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Optional;

public class XmlProyectoDao extends XmlDao<Proyecto>{

	@Override
	public void crearNuevo(Proyecto pro) {
		try {
			JAXBContext contextObj = JAXBContext.newInstance(Proyecto.class);
			Marshaller marshallerObj = contextObj.createMarshaller();
			marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshallerObj.marshal(pro, new FileOutputStream("output/proyecto.xml"));
		} catch (JAXBException | FileNotFoundException e) {
			e.printStackTrace();
		} 
	}

	@Override
	public Optional<Proyecto> obtener(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(Proyecto t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar(Proyecto t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Proyecto> obtenerDatos() {
		// TODO Auto-generated method stub
		return null;
	}



}
