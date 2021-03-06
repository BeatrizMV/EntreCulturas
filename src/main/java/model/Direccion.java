package model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable

public class Direccion {

    @Column (name = "tipoVia")
    private String tipoVia;
    @Column (name = "via")
    private String via;
    @Column (name = "num")
    private int num;
    @Column (name = "provincia")
    private String provincia;
    @Column (name = "cp")
    private int codigoPostal;
    @Column (name = "pais")
    private String pais;
    @Column (name = "observaciones")
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

    @Override
    public String toString() {
        return "Tipo via: " +
                this.tipoVia +
                "\nVia: " +
                this.via +
                "\nNumero: " +
                this.num +
                "\nProvincia: " +
                this.provincia +
                "\nCodigo Postal: " +
                this.codigoPostal +
                "\nPais: " +
                this.pais +
                "\nObservaciones: " +
                this.observaciones;
    }
}
