package daoroot.db;

public interface DbConstants {

    //Constantes de las tablas de la BD

    String TABLA_EQUIPOS ="equipos";
    String EQUIPOS_PERSONA="fk_persona";
    String EQUIPOS_PROYECTO="fk_proyecto";

    String TABLA_LINEACCION="lineaccion";
    String LINEACCION_ID="idLineAccion";
    String LINEACCION_NOMBRE="nombre";

    String TABLA_MIEMBROEQUIPO= "miembroequipo";
    String MIEMBROEQUIPO_ID="idMiembroEquipo";
    String MIEMBROEQUIPO_NOMBRE="nombre";

    String TABLA_PERSONAS="personas";
    String PERSONAS_ID="idPersonas";
    String PERSONAS_DNI="dni";
    String PERSONAS_NOMBRE="nombre";
    String PERSONAS_APELLIDO1="apellido1";
    String PERSONAS_APELLIDO2="apellido2";
    String PERSONAS_TIPOVIA="tipoVia";
    String PERSONAS_VIA="via";
    String PERSONAS_NUM="num";
    String PERSONAS_PROVINCIA="provincia";
    String PERSONAS_CP="cp";
    String PERSONAS_PAIS="pais";
    String PERSONAS_OBSERVACIONES="observaciones";
    String PERSONAS_TELEFONO="telefono";
    String PERSONAS_EMAIL="email";
    String PERSONAS_USUARIO="usuario";
    String PERSONAS_PASSWORD="password";
    String PERSONAS_ROL="fk_rol";
    String PERSONAS_MIEMBROEQUIPO="fk_miembroEquipo";   

    String TABLA_PROYECTOS="proyectos";
    String PROYECTOS_ID="idCodigoProyecto";
    String PROYECTOS_NOMBRE="nombreProyecto";
    String PROYECTOS_TIPOVIA="tipoVia";
    String PROYECTOS_VIA="via";
    String PROYECTOS_NUM="num";
    String PROYECTOS_PROVINCIA="provincia";
    String PROYECTOS_CP="cp";
    String PROYECTOS_PAIS="pais";
    String PROYECTOS_OBSERVACIONES="observaciones";
    String PROYECTOS_FECHAINCIO="fechaInicio";
    String PROYECTOS_FECHAFIN="fechaFinal";
    String PROYECTOS_SOCIOLOCAL="socioLocal";
    String PROYECTOS_ACCIONES="accionesRealizar";
    String PROYECTOS_LINEACCION="fk_lineaAccion";
    String PROYECTOS_SUBLINEA="fk_subLineaAccion";

    String TABLA_ROLES="roles";
    String ROLES_ID="idRol";
    String ROLES_NOMBRE="nombreRol";

    String TABLA_SEDES="sedes";
    String SEDES_NOMBRE="nombreSede";
    String SEDES_TIPOVIA="tipoVia";
    String SEDES_VIA="via";
    String SEDES_NUM="num";
    String SEDES_PROVINCIA="provincia";
    String SEDES_CP="cp";
    String SEDES_PAIS="pais";
    String SEDES_OBSERVACIONES="observaciones";
    String SEDES_TELEFONO="telefono";
    String SEDES_EMAIL="email";
    String SEDES_CENTRAL="central";

    String TABLA_SUBLINEAACION="sublieaaccion";
    String SUBLINEAACCION_ID="idSublineaAccion";
    String SUBLINEAACCION_NOMBRE="nombre";



}