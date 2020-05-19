package root;

public class Direccion {
    private String tipoVia;
    private String via;
    private int num;
    private String provincia;
    private int codigoPostal;
    private String pais;
    private String observaciones;

    public Direccion(String tipoVia, String via, int num, String provincia, int codigoPostal, String pais, String observaciones) {
        setTipoVia(tipoVia);
        setVia(via);
        setNum(num);
        setProvincia(provincia);
        setCodigoPostal(codigoPostal);
        setPais(pais);
        setObservaciones(observaciones);
    }

    public Direccion() {}

    public String getTipoVia() {
        return tipoVia;
    }

    public Direccion setTipoVia(String tipoVia) {
        this.tipoVia = tipoVia;
        return this;
    }

    public String getVia() {
        return via;
    }

    public Direccion setVia(String via) {
        this.via = via;
        return this;
    }

    public int getNum() {
        return num;
    }

    public Direccion setNum(int num) {
        this.num = num;
        return this;
    }

    public String getProvincia() {
        return provincia;
    }

    public Direccion setProvincia(String provincia) {
        this.provincia = provincia;
        return this;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public Direccion setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
        return this;
    }

    public String getPais() {
        return pais;
    }

    public Direccion setPais(String pais) {
        this.pais = pais;
        return this;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public Direccion setObservaciones(String observaciones) {
        this.observaciones = observaciones;
        return this;
    }
}
