package daoroot.xml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Optional;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import daoroot.DAO;
import root.Voluntario;

public class XMLVoluntarioDAO implements DAO<Voluntario> {
    @Override
    public void crearNuevo (Voluntario vol){
        try {
			JAXBContext contextObj = JAXBContext.newInstance(Voluntario.class);
			Marshaller marshallerObj = contextObj.createMarshaller();
			marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshallerObj.marshal(vol, new FileOutputStream("output/voluntario.xml"));
		} catch (JAXBException | FileNotFoundException e) {
			e.printStackTrace();
		} 
    }

    @Override
	public Optional<Voluntario> obtener(String id) {
		// TODO Auto-generated method stub
		return null;
    }

    @Override
	public void actualizar(Voluntario vol) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar(Voluntario vol) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Voluntario> obtenerDatos() {
		// TODO Auto-generated method stub
		return null;
	}
}