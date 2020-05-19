package root;

import enums.Rol;

public class Socio extends Persona {
    //Socio hereda de persona

    private int numSocio;

    /**
     * Método constructor
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
     * @param numSocio  alberga el número de socio
     */
    public Socio(int idPersona, String dni, String nombre, String apellido1, String apellido2, Direccion direccion, int telefono, String email, String usuario, String password, Rol rol, int numSocio) {
        super(idPersona, dni, nombre, apellido1, apellido2, direccion, telefono, email, usuario, password, rol);
        this.numSocio = numSocio;
    }

    /**
     * Metodo destructor destruye cosas
     */
    public void finalize() {
        // hacer algo para borrar
    }

    /**
     * Metodos para consultar y modificar los atributos
     *
     * @return retorna numSocio
     */
    public int getNumSocio() {
        return numSocio;
    }
}