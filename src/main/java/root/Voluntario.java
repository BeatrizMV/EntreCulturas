package root;
import enums.Rol;

public class Voluntario extends MiembroEquipo{
    //Colaborador hereda de la clase padre MiembroEquipo

    /**
     * Método constructor con llamada a la clase padre MiembroEquipo
     * @param idPersona numero requerido para el idPersona
     * @param dni numero de DNI
     * @param nombre alberga el nombre del socio
     * @param apellido1 alberga el primer apellido
     * @param apellido2 alberga el segundo apellido
     * @param direccion alberga la dirección
     * @param telefono alberga el telefono
     * @param email alberga el email
     * @param usuario alberga el nombre de usuario en el sistema
     * @param password alberga la contraseña para el usuario
     * @param rol alberga el rol del usuario
     */
    public Voluntario (int idPersona, String dni, String nombre, 
    String apellido1, String apellido2, Direccion direccion,
    int telefono, String email, String usuario, String password,
    Rol rol){
        super (idPersona, dni, nombre, apellido1, apellido2, direccion,
        telefono, email, usuario, password, rol);
    }

	public Voluntario(int i, String string, String string2, String string3, String string4, String string5,
			String string6, int j, String string7, int k, String string8, int l, String string9, String string10,
			String string11, Rol admin) {
	}
    
}