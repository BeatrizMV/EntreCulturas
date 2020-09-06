package root;

import enums.LineaAccion;
import enums.Rol;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="voluntario")
public class Voluntario extends MiembroEquipo {
    //Colaborador hereda de la clase padre MiembroEquipo

    public Voluntario(){}

    /**
     * Método constructor con llamada a la clase padre MiembroEquipo
     *
     * @param idPersona numero requerido para el idPersona
     * @param dni       numero de DNI
     * @param nombre    alberga el nombre del socio
     * @param apellido1 alberga el primer apellido
     * @param apellido2 alberga el segundo apellido
     * @param direccion alberga la dirección
     * @param telefono  alberga el telefono
     * @param email     alberga el email
     * @param usuario   alberga el nombre de usuario en el sistema
     * @param password  alberga la contraseña para el usuario
     * @param rol       alberga el rol del usuario
     */
    public Voluntario(int id, String dni, String nombre, String apellido1, String apellido2,
					  String tipoVia, String via, int num, String provincia, int codigoPostal,
					  String pais, String observaciones, String telefono, String email,
					  String usuario, String password, Rol rol) {
        super (id, dni, nombre, apellido1, apellido2,
				tipoVia, via, num, provincia, codigoPostal, pais, observaciones,
				telefono, email, usuario, password, rol);
    }

	public Voluntario(int int1, String string, String string2, String string3, String string4, String string5,
			String string6, int int2, String string7, int int3, String string8, String string9, String string10,
			String string11) {
		// TODO Auto-generated constructor stub
	}

	public void setMiembroEquipo(String value) {
		// TODO Auto-generated method stub
		
	}

	public Persona getDireccion() {
		// TODO Auto-generated method stub
		return null;
	}

	public Enum<LineaAccion> getMiembroEquipo() {
		// TODO Auto-generated method stub
		return null;
	}
}