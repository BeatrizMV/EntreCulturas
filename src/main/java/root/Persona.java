package root;
import enums.Rol;

public class Persona {
    
    /* Atributos
    */
    private int idPersona;
    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Direccion direccion;
    private int telefono;
    private String email;
    private String usuario;
    private String password;
    private Rol rol;

    /*Método constructor
    * @idPersona alberga el número de identificación interno
    * @dni alberga el numero de identificación fiscal de la persona
    * @nombre alberga el nombre
    * @apellido1 alberga el primer apellido
    * @apellido2 alberga el segundo apellido
    * @direccion alberga la dirección
    * @telefono alberga el teléfono
    * @email alberga el email
    * @usuario alberga el nombre de usuario en el sistema
    * @password alberga la contraseña del usuario
    * @rol alberga el rol del usuario en el sistema
    */
    public Persona (int idPersona, String dni, String nombre, 
    String apellido1, String apellido2, Direccion direccion,
    int telefono, String email, String usuario, String password,
    Rol rol){
        this.idPersona = idPersona;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.usuario = usuario;
        this.password = password;
        this.rol = rol;
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
     * @return retorna idPersona
     */
    public int getIdPersona(){
        return idPersona;
    }

    /**
     * @return retorna dni
     */
    public String getDni(){
        return dni;
    }

    /**
     * @return retorna nombre
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * @return retorna apellido1
     */
    public String getApellido1(){
        return apellido1;
    }

    /**
     * @return retorna apellido2
     */
    public String getApellido2(){
        return apellido2;
    }

    /**
     * @return retorna direccion
     */
    public Direccion getDireccion(){
        return direccion;
    }

    /**
     * @return retorna telefono
     */
    public int getTelefono(){
        return telefono;
    }

    /**
     * @return retorna email
     */

     public String getEmail(){
         return email;
     }

    /**
     * @return retorna usuario
     */
    public String getUsuario(){
        return usuario;
    }

    /**
     * @return retorna password
     */
    public String getPassword(){
        return password;
    }

    /**
     * @return retorna rol
     */
    public Rol getRol(){
        return rol;
    }

    /**
     * método para modificar el idPersona
     * @param idPersona
     */
    public void setIdPersona (int idPersona){
        this.idPersona = idPersona;
    }

    /**
     * método para cambiar el dni
     * @param dni
     */
    public void setDni (String dni){
        this.dni = dni;
    }

    /**
     * metodo para cambiar el nombre
     * @param nombre
     */
    public void setNombre (String nombre){
        this.nombre = nombre;
    }

    /**
     * método para cambiar el primer apellido
     * @param apellido1
     */
    public void setApellido1 (String apellido1){
        this.apellido1 = apellido1;
    }   

    /**
     * método para cambiar el segundo apellido
     * @param apellido2
     */
    public void setApellido2 (String apellido2){
        this.apellido2 = apellido2;
    }
    /**
     * método para modificar la dirección
     * 
     * @param direccion modifica la dirección
     */
    public void setDireccion (Direccion direccion){
        this.direccion = direccion;
    }

    /**
     * método para modificar el teléfono
     * @param telefono modifica el teléfono
     *  */    
    public void setTelefono (int telefono){
        this.telefono = telefono;
    }

    /**
     * método para modificar el email
     * @param email modifica el email
     */
    public void setEmail (String email){
        this.email = email;
    }

    /**
     * Método para cambiar el usario
     * @param usuario
     */
    public void setUsuario (String usuario){
        this.usuario = usuario;
    }

    /**
     * Método para cambiar el rol
     * @param rol
     */
    public void setRol (Rol rol){
        this.rol = rol;
    }
    
    /**
     * método para modificar la contraseña
     * @param password modifica la contraseña
     */
    public void setPassword (String password){
        this.password = password;
    }
    
}