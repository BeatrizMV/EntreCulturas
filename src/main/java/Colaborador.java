import Enums.Rol;

public class Colaborador extends MiembroEquipo{
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
    public Colaborador (int idPersona, String dni, String nombre, 
    String apellido1, String apellido2, Direccion direccion,
    int telefono, String email, String usuario, String password,
    Rol rol){
        super (idPersona, dni, nombre, apellido1, apellido2, direccion,
        telefono, email, usuario, password, rol);
    }
    
}