package root;
public class Sede {
    private int idSede;
    private String nombreSede;
    private Direccion direccion;
    private String telefono;
    private String email;
    private boolean central;

    public Sede(int idSede, String nombreSede, String tipoVia, String via, int num, String provincia, int codigoPostal, String pais, String observaciones, String telefono, String email, boolean central) {
        setIdSede(idSede);
        setNombreSede(nombreSede);
        setDireccion(tipoVia, via, num, provincia, codigoPostal, pais, observaciones);
        setTelefono(telefono);
        setEmail(email);
        setCentral(central);
    }

    public int getIdSede() {
        return idSede;
    }

    public Sede setIdSede(int idSede) {
        this.idSede = idSede;
        return this;
    }

    public String getNombreSede() {
        return nombreSede;
    }

    public Sede setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
        return this;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Sede setDireccion(String tipoVia, String via, int num, String provincia, int codigoPostal, String pais, String observaciones) {
        direccion = new Direccion(tipoVia, via, num, provincia, codigoPostal, pais, observaciones);
        return this;
    }

    public String getTelefono() {
        return telefono;
    }

    public Sede setTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Sede setEmail(String email) {
        this.email = email;
        return this;
    }

    public boolean isCentral() {
        return central;
    }

    public Sede setCentral(boolean central) {
        this.central = central;
        return this;
    }
}
