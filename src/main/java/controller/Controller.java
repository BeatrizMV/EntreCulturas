package controller;

import daoroot.DAO;
import daoroot.DAOFactory;
import enums.LineaAccion;
import enums.SublineaAccion;
import exceptions.DaoException;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Proyecto;
import model.Voluntario;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    //enlazar imagenes del fxml con los id
    //id de las imagenes de las flechas
    @FXML private ImageView userArrow;
    @FXML private ImageView listArrow;
    @FXML private ImageView insertArrow;
    @FXML private ImageView updateArrow;
    @FXML private ImageView deleteArrow;
    //id de las imagenes de los paneles
    @FXML private AnchorPane userPanel;
    @FXML private AnchorPane listPanel;
    @FXML private AnchorPane insertPanel;
    @FXML private AnchorPane updatePanel;
    @FXML private AnchorPane deletePanel;
    //id para los choiceBox del panel insertar y modificar
    @FXML private ChoiceBox <String> choiceBoxAcciones;
    @FXML private ChoiceBox <String> choiceBoxModificar;
    //id casillas a rellenar usuario
    @FXML private TextField userText;
    @FXML private PasswordField passText;
    //id casillas a rellenar listado
    @FXML private TextField listIdText;
    @FXML private TextArea listProyect;
    //id casillas a rellenar insertar
    @FXML private TextField insertNombre;
    @FXML private TextField insertSocio;
    @FXML private TextField insertObservaciones;
    @FXML private TextField insertAccionesRealizar;
    @FXML private TextField insertTipoVia;
    @FXML private TextField insertNombreVia;
    @FXML private TextField insertProvincia;
    @FXML private TextField insertPais;
    @FXML private TextField insertNumero;
    @FXML private TextField insertCP;
    //id casillas a rellenar update
    @FXML private TextField updateID;
    @FXML private TextField updateNombre;
    @FXML private TextField updateSocio;
    @FXML private TextField updateObservaciones;
    @FXML private TextField updateTipoVia;
    @FXML private TextField updateNombreVia;
    @FXML private TextField updateProvincia;
    @FXML private TextField updatePais;
    @FXML private TextField updateNumero;
    @FXML private TextField updateCP;
    //id casillas a rellenar delate
    @FXML private TextField deleteID;
    @FXML private TextArea deleteProyecto;
    //id botones usuario
    @FXML private Button userButtonEnviar;
    //id botones listar
    @FXML private Button listIDButton;
    @FXML private Button listButtonProyectos;
    //id botones insertar
    @FXML private Button insertButton;
    //id botones modificar
    @FXML private Button updateButton;
    @FXML private Button updateIDButton;
    //id botones delete
    @FXML private Button deleteButtonID;
    @FXML private Button deleteButtonEliminar;
    //id data insertar
    @FXML private DatePicker insertDateInicio;
    @FXML private DatePicker insertDateFinal;
    //id data modificar
    @FXML private DatePicker updateDateInicio;
    @FXML private DatePicker updateDateFinal;

    //instanciamos los DAOFactory
    private DAO<Voluntario> voluntarioDAO = DAOFactory.getDAOFactory(DAOFactory.XML).getVoluntarioDAO();
    private DAO<Proyecto> proyectoDAO = DAOFactory.getDAOFactory(DAOFactory.DB).getProyectoDAO();

    //las opciones que aparecedaran en nuestro choiceBox
    ObservableList<String> choiceBoxIDContent =
            FXCollections.observableArrayList(


                    "COOPERACION_DESARROLLO",
                    "ACCION_HUMANITARIA",
                    "FORTALECIMIENTO_INSTITUCIONAL",
                            "EDUCACION_DESARROLLO"
            );

    //Metodo para poder inicializar todos nuestros atributos graficos
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //asocia handle con el campo de texto
        userText.addEventFilter(KeyEvent.ANY, handlerLetters);
        insertNombre.addEventFilter(KeyEvent.ANY, handlerLetters);
        insertSocio.addEventFilter(KeyEvent.ANY, handlerLetters);
        insertObservaciones.addEventFilter(KeyEvent.ANY, handlerLetters);
        insertTipoVia.addEventFilter(KeyEvent.ANY, handlerLetters);
        insertNombreVia.addEventFilter(KeyEvent.ANY, handlerLetters);
        insertProvincia.addEventFilter(KeyEvent.ANY, handlerLetters);
        insertPais.addEventFilter(KeyEvent.ANY, handlerLetters);
        updateNombre.addEventFilter(KeyEvent.ANY, handlerLetters);
        updateSocio.addEventFilter(KeyEvent.ANY, handlerLetters);
        updateObservaciones.addEventFilter(KeyEvent.ANY, handlerLetters);
        updateTipoVia.addEventFilter(KeyEvent.ANY, handlerLetters);
        updateNombreVia.addEventFilter(KeyEvent.ANY, handlerLetters);
        updateProvincia.addEventFilter(KeyEvent.ANY, handlerLetters);
        updatePais.addEventFilter(KeyEvent.ANY, handlerLetters);

        //asocia handle con el campo numerico
        listIdText.addEventFilter(KeyEvent.ANY, handlerNumbers);
        insertNumero.addEventFilter(KeyEvent.ANY, handlerNumbers);
        insertCP.addEventFilter(KeyEvent.ANY, handlerNumbers);
        updateNumero.addEventFilter(KeyEvent.ANY, handlerNumbers);
        updateCP.addEventFilter(KeyEvent.ANY, handlerNumbers);
        deleteID.addEventFilter(KeyEvent.ANY, handlerNumbers);

        //asocia los choiceBox
        choiceBoxAcciones.setItems(choiceBoxIDContent);
        choiceBoxModificar.setItems(choiceBoxIDContent);
    }

    //boton de salida de la aplicacion
    public void onExitButtonClicked(MouseEvent event){
        Platform.exit();
        System.exit(0);
    }
    //boton de pestaña de loguin
    public void onUserButtonCliked(MouseEvent event){
        //para que se haga invisible el panel sino esta seleccionado
        if(userPanel.isVisible()){
            userPanel.setVisible(false);
            userArrow.setVisible(false);
            return;
        }
        //para que sea visible el panel y la flecha
        userPanel.setVisible(true);
        userArrow.setVisible(true);
        //para que sea invisible el resto de paneles y flechas
        listPanel.setVisible(false);
        listArrow.setVisible(false);
        insertPanel.setVisible(false);
        insertArrow.setVisible(false);
        updatePanel.setVisible(false);
        updateArrow.setVisible(false);
        deletePanel.setVisible(false);
        deleteArrow.setVisible(false);
    }
    //boton de pestaña de listar
    public void onListButtonCliked(MouseEvent event){
        //para que se haga invisible el panel sino esta seleccionado
        if(listPanel.isVisible()){
            listPanel.setVisible(false);
            listArrow.setVisible(false);
            return;
        }
        //para que sea visible el panel y la flecha
        listPanel.setVisible(true);
        listArrow.setVisible(true);
        //para que sea invisible el resto de paneles y flechas
        userPanel.setVisible(false);
        userArrow.setVisible(false);
        insertPanel.setVisible(false);
        insertArrow.setVisible(false);
        updatePanel.setVisible(false);
        updateArrow.setVisible(false);
        deletePanel.setVisible(false);
        deleteArrow.setVisible(false);

    }
    //boton de pestaña de insertar
    public void onInsertButtonCliked(MouseEvent event){
        //para que se haga invisible el panel sino esta seleccionado
        if(insertPanel.isVisible()){
            insertPanel.setVisible(false);
            insertArrow.setVisible(false);
            return;
        }
        //para que sea visible el panel y la flecha
        insertPanel.setVisible(true);
        insertArrow.setVisible(true);
        //para que sea invisible el resto de paneles y flechas
        userPanel.setVisible(false);
        userArrow.setVisible(false);
        listPanel.setVisible(false);
        listArrow.setVisible(false);
        updatePanel.setVisible(false);
        updateArrow.setVisible(false);
        deletePanel.setVisible(false);
        deleteArrow.setVisible(false);
    }
    //boton de pestaña de modificar
    public void onUpdateButtonCliked(MouseEvent event){
        //para que se haga invisible el panel sino esta seleccionado
        if(updatePanel.isVisible()){
            updatePanel.setVisible(false);
            updateArrow.setVisible(false);
            return;
        }
        //para que sea visible el panel y la flecha
        updatePanel.setVisible(true);
        updateArrow.setVisible(true);
        //para que sea invisible el resto de paneles y flechas
        userPanel.setVisible(false);
        userArrow.setVisible(false);
        listPanel.setVisible(false);
        listArrow.setVisible(false);
        insertPanel.setVisible(false);
        insertArrow.setVisible(false);
        deletePanel.setVisible(false);
        deleteArrow.setVisible(false);

    }
    //boton de pestaña de eliminar
    public void onDeleteButtonCliked(MouseEvent event){
        //para que se haga invisible el panel sino esta seleccionado
        if(deletePanel.isVisible()){
            deletePanel.setVisible(false);
            deleteArrow.setVisible(false);
            return;
        }
        //para que sea visible el panel y la flecha
        deletePanel.setVisible(true);
        deleteArrow.setVisible(true);
        //para que sea invisible el resto de paneles y flechas
        userPanel.setVisible(false);
        userArrow.setVisible(false);
        listPanel.setVisible(false);
        listArrow.setVisible(false);
        insertPanel.setVisible(false);
        insertArrow.setVisible(false);
        updatePanel.setVisible(false);
        updateArrow.setVisible(false);

    }
//creamos un evento de teclado y dentro se valida las condiciones de texto
    EventHandler <KeyEvent> handlerLetters = new EventHandler<KeyEvent>() {

        private boolean willConsume = false;

        @Override
        public void handle(KeyEvent event) {
            Object tempO = event.getSource();
            if(willConsume){
                event.consume();
            }
            String temp = event.getCode().toString();
            if(!event.getCode().toString().matches("[a-zA-Z]") && event.getCode() != KeyCode.BACK_SPACE
                &&event.getCode() != KeyCode.SHIFT){
                if (event.getEventType() == KeyEvent.KEY_PRESSED) {
                    willConsume = true;
                }else if (event.getEventType() == KeyEvent.KEY_RELEASED){
                    willConsume = false;
                }
            }
        }
    };

    //creamos un evento de teclado y dentro se valida las condiciones numeros
    EventHandler <KeyEvent> handlerNumbers = new EventHandler<KeyEvent>() {

        private boolean willConsume = false;
        private int maxLength = 100000;

        @Override
        public void handle(KeyEvent event) {
            TextField temp = (TextField) event.getSource();

            if(willConsume){
                event.consume();
            }

            if(!event.getText().matches("[0-9]") && event.getCode() != KeyCode.BACK_SPACE) {
                if (event.getEventType() == KeyEvent.KEY_PRESSED) {
                    willConsume = true;
                }else if (event.getEventType() == KeyEvent.KEY_RELEASED) {
                    willConsume = false;
                }
            }
                if (temp.getText().length() == maxLength -1) {
                    if(event.getEventType() == KeyEvent.KEY_RELEASED) {
                        willConsume = true;
                }else if (event.getEventType() == KeyEvent.KEY_RELEASED) {
                    willConsume = false;
                }
            }
        }
    };

    //botones de enviar panel usuario
    public void onSaveButtonCliked(ActionEvent event){
        //si el usuario se deja algún campo vacio
        if (userText.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Guardar datos");
            alert.setContentText("Existen campos vacios");
            alert.showAndWait();
        }

    }
    //Panel listar
    //boton de enviar por id
    public void buttonIdList(ActionEvent event){
        //si el usuario se deja algún campo vacio
        if (listIdText.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mostrar poryecto por IdD");
            alert.setContentText("Existen campos vacios");
            alert.showAndWait();
        }else{
            try {
                //cogemos el id del proyecto
                Optional<Proyecto> p = proyectoDAO.findById(Integer.parseInt(listIdText.getText()));
                if (p.isPresent()){
                    //mostramos el proyecto
                    Proyecto pro = p.get();
                    listProyect.setText(pro.toString());
                } else {
                    listProyect.setText("No existe proyecto con ese ID");
                }

            } catch (DaoException e) {
                e.printStackTrace();
                System.out.println("Error buscando proyecto por ID");
            }
        }
    }

    //Panel listar
    //boton de mostrar todos
    public void buttonListAll(ActionEvent event){
        try {
            //mostramos todos los proyectos. Los recogemos en una lista
            List<Proyecto> lista = proyectoDAO.listAll();
            String strLista = "";
            for (Proyecto p : lista){
                strLista = strLista + p.toString() + "\n------------------------\n";
            }
            //mostramos todos los proyectos de la lista
            listProyect.setText(strLista);
        } catch (DaoException e) {
            e.printStackTrace();
            System.out.println("Error al mostrar todos los proyectos");
        }
    }

    //botones de enviar panel insert
    public void buttonInsert(ActionEvent event){
        //si el usuario se deja algún campo vacio
        if (insertNombre.getText().isEmpty()
            || insertSocio.getText().isEmpty()
            || insertObservaciones.getText().isEmpty()
            || insertTipoVia.getText().isEmpty()
            || insertNombreVia.getText().isEmpty()
            || insertNumero.getText().isEmpty()
            || insertCP.getText().isEmpty()
            || insertPais.getText().isEmpty()
            || insertProvincia.getText().isEmpty()
            || choiceBoxAcciones.getValue() == null
            || insertDateInicio.getValue() == null
            || insertDateFinal.getValue() == null
        ){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Guardar datos");
            alert.setContentText("Existen campos vacios");
            alert.showAndWait();
        } else {
            Proyecto proyectoAInsertar = new Proyecto(
                    insertNombre.getText(),
                    LineaAccion.valueOf(choiceBoxAcciones.getValue()),
                    SublineaAccion.NINGUNA,
                    insertDateInicio.getValue(),
                    insertDateFinal.getValue(),
                    insertSocio.getText(),
                    insertAccionesRealizar.getText(),
                    insertTipoVia.getText(),
                    insertNombreVia.getText(),
                    Integer.parseInt(insertNumero.getText()),
                    insertProvincia.getText(),
                    Integer.parseInt(insertCP.getText()),
                    insertPais.getText(),
                    insertObservaciones.getText()
                    );
            try {
                proyectoDAO.create(proyectoAInsertar);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Proyecto creado!");
                alert.setContentText("Proyecto creado correctamente!");
                alert.showAndWait();
            } catch (DaoException e) {
                e.printStackTrace();
                System.out.println("Error insertando nuevo proyecto" + proyectoAInsertar.toString());
            }
        }
    }
    //botones de modificar panel update
    public void onSaveButtonClikedUpdate(ActionEvent event){
        //si el usuario se deja algún campo vacio
        if (updateNombre.getText().isEmpty()
                || updateSocio.getText().isEmpty()
                || updateObservaciones.getText().isEmpty()
                || updateTipoVia.getText().isEmpty()
                || updateNombreVia.getText().isEmpty()
                || updateNumero.getText().isEmpty()
                || updateCP.getText().isEmpty()
                || updatePais.getText().isEmpty()
                || updateProvincia.getText().isEmpty()
                || choiceBoxModificar.getValue() == null
                || updateDateInicio.getValue() == null
                || updateDateFinal.getValue() == null
        ){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Guardar datos");
            alert.setContentText("Existen campos vacios");
            alert.showAndWait();
        }
    }
    //botones de enviar panel idUpdate
    public void onSaveButtonClikedIdUpdate(ActionEvent event){
        //si el usuario se deja algún campo vacio
        if (updateID.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Obtener proyecto por Id");
            alert.setContentText("Existen campos vacios");
            alert.showAndWait();
        }
    }

    //Panel delete
    //botones de enviar id
    public void buttonIdDelete(ActionEvent event){
        //si el usuario se deja algún campo vacio
        if (deleteID.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Id poryecto a borrar");
            alert.setContentText("Existen campos vacios");
            alert.showAndWait();
        }else{
            try {
                //cogemos el id del proyecto
                Optional<Proyecto> p = proyectoDAO.findById(Integer.parseInt(deleteID.getText()));
                if (p.isPresent()){
                    //mostramos el proyecto
                    Proyecto pro = p.get();
                    deleteProyecto.setText(pro.toString());
                } else {
                    deleteProyecto.setText("No existe proyecto con ese ID");
                }

            } catch (DaoException e) {
                e.printStackTrace();
                System.out.println("Error buscando proyecto por ID");
            }
        }
    }

    //Panel delete
    //botones de eliminar
    public void buttonDelete(ActionEvent event){
        //si el usuario se deja algún campo vacio
        if (deleteID.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Eliminar proyecto");
            alert.setContentText("Existen campos vacios");
            alert.showAndWait();
        }else {
            try {
                //cogemos el id y lo eliminamos
                proyectoDAO.deleteById(Integer.parseInt(deleteID.getText()));
                //si el usuario se deja algún campo vacio
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Eliminar proyecto");
                alert.setContentText("Ha eliminado el proyecto");
                alert.showAndWait();
            } catch (DaoException e) {
                e.printStackTrace();
                System.out.println("Error eliminando proyecto por ID");
            }
        }
    }

}
