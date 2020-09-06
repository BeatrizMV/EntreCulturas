package root;

import enums.Rol;

import static daoroot.db.DbConstants.DIR_STR_SEPARATOR;

public class Persona {

    /* Atributos
     */
    private int id;
    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String tipoVia;
    private String via;
    private int num;
    private String provincia;
    private int cp;
    private String pais;
    private String observaciones;
    private String telefono;
    private String email;
    private String usuario;
    private String password;
    private Rol rol;
    private Direccion direccion;

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

    public Persona(){}

    public Persona(final int id,
                   final String dni,
                   final String nombre,
                   final String apellido1,
                   final String apellido2,
                   final String tipoVia,
                   final String via,
                   final int num,
                   final String provincia,
                   final int cp,
                   final String pais,
                   final String observaciones,
                   final String telefono,
                   final String email,
                   final String usuario,
                   final String password,
                   final Rol rol) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.tipoVia = tipoVia;
        this.via = via;
        this.num = num;
        this.provincia = provincia;
        this.cp = cp;
        this.pais = pais;
        this.observaciones = observaciones;
        this.telefono = telefono;
        this.email = email;
        this.usuario = usuario;
        this.password = password;
        this.rol = rol;
    }

    public Persona (final int id,
                    final String dni,
                    final String nombre,
                    final String apellido1,
                    final String apellido2,
                    final Direccion direccion,
                    final String observaciones,
                    final String telefono,
                    final String email,
                    final String usuario,
                    final String password,
                    final Rol rol) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.direccion = direccion;
        this.observaciones = observaciones;
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
    public int getId() {
        return id;
    }

    /**
     * @return retorna dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @return retorna nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return retorna apellido1
     */
    public String getApellido1() {
        return apellido1;
    }

    /**
     * @return retorna apellido2
     */
    public String getApellido2() {
        return apellido2;
    }

    /**
     * @return retorna tipoVia
     */
    public String getTipoVia() {
        return tipoVia;
    }
    
    /**
     * @return retorna Via
     */
    public String getVia() {
        return via;
    }
    
    /**
     * @return retorna num
     */
    public int getNum() {
        return num;
    }
    
    /**
     * @return retorna provincia
     */
    public String getProvincia() {
        return provincia;
    }
    
    /**
     * @return retorna cp
     */
    public int getCP() {
        return cp;
    }
    
    /**
     * @return retorna pais
     */
    public String getPais() {
        return pais;
    }
    
    /**
     * @return retorna observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * @return retorna telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @return retorna email
     */

    public String getEmail() {
        return email;
    }

    /**
     * @return retorna usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @return retorna password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return retorna rol
     */
    public Rol getRol() {
        return rol;
    }

    /**
     * método para modificar el idPersona
     *
     * @param id
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * método para cambiar el dni
     *
     * @param dni
     */
    public void setDni(final String dni) {
        this.dni = dni;
    }

    /**
     * metodo para cambiar el nombre
     *
     * @param nombre
     */
    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    /**
     * método para cambiar el primer apellido
     *
     * @param apellido1
     */
    public void setApellido1(final String apellido1) {
        this.apellido1 = apellido1;
    }

    /**
     * método para cambiar el segundo apellido
     *
     * @param apellido2
     */
    public void setApellido2(final String apellido2) {
        this.apellido2 = apellido2;
    }

    /**
     * metodo para cambiar la direccion
     * @param tipoVia
     * @param via
     * @param num
     * @param provincia
     * @param codigoPostal
     * @param pais
     * @param observaciones
     */
    public void setDireccion(final String tipoVia, final String via, final int num, final String provincia,
            final int codigoPostal, final String pais, final String observaciones) {
        direccion = new Direccion(tipoVia, via, num, provincia, codigoPostal, pais, observaciones);
    }

    public void setDireccion(final Direccion direccion){
        this.direccion = direccion;
    }

    public void setDireccion(final String direccion){
        String[] params = direccion.split(DIR_STR_SEPARATOR);
        this.setDireccion(params[0],
                params[1],
                Integer.parseInt(params[2]),
                params[3],
                Integer.parseInt(params[4]),
                params[5],
                params[6]);
    }

    /**
     * método para modificar el teléfono
     *
     * @param telefono modifica el teléfono
     */
    public void setTelefono(final String telefono) {
        this.telefono = telefono;
    }

    /**
     * método para modificar el email
     *
     * @param email modifica el email
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * Método para cambiar el usario
     *
     * @param usuario
     */
    public void setUsuario(final String usuario) {
        this.usuario = usuario;
    }

    /**
     * Método para cambiar el rol
     *
     * @param rol
     */
    public void setRol(final Rol rol) {
        this.rol = rol;
    }

    public void setRol(final String rol) {
        this.rol = Rol.values()[Integer.parseInt(rol)];
    }

    /**
     * método para modificar la contraseña
     *
     * @param password modifica la contraseña
     */
    public void setPassword(final String password) {
        this.password = password;
    }

}