package model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

import static daoroot.db.DbConstants.DIR_STR_SEPARATOR;

@XmlRootElement(name="sede")
@Entity
@Table(name = "Sedes")
public class Sede implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name="idSede")
    private int id;

    @Column (name="nombreSede")
    private String nombreSede;

    @OneToOne (cascade = {CascadeType.ALL})
    @JoinColumn (name = "direccion")
    private Direccion direccion = new Direccion();

    @Column (name="telefono")
    private String telefono;

    @Column (name="email")
    private String email;

    @Column (name= "central")
    private boolean central;

    public Sede(){}

    public Sede(int idSede, String nombreSede, String tipoVia, String via, int num, String provincia, int codigoPostal, String pais, String observaciones, String telefono, String email, boolean central) {
        setId(idSede);
        setNombreSede(nombreSede);
        setDireccion(tipoVia, via, num, provincia, codigoPostal, pais, observaciones);
        setTelefono(telefono);
        setEmail(email);
        setCentral(central);
    }

    public Sede(int int1, String string, String string2, String string3, int int2, String string4, int int3,
			String string5, String string6, String string7, String string8, String string9) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
        return id;
    }

    public Sede setId(int id) {
        this.id = id;
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

    public Sede setDireccion(String concatenated) {
        String[] params = concatenated.split(DIR_STR_SEPARATOR);
        this.setDireccion(params[0],
                params[1],
                Integer.parseInt(params[2]),
                params[3],
                Integer.parseInt(params[4]),
                params[5],
                params[6]);
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

    public Sede setCentral(String isCentralStr) {
        if(isCentralStr == null) {
            this.central = true;
        } else {
            this.central = false;
        }
        return this;
    }
}
