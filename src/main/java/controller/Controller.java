package controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    //id de las imagenes de las flechas para que queden enlazadas
    @FXML private ImageView userArrow;
    @FXML private ImageView listArrow;
    @FXML private ImageView insertArrow;
    @FXML private ImageView updateArrow;
    @FXML private ImageView deleteArrow;
    //id de las imagenes de los paneles para que queden enlazadas
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
    @FXML private TextField passText;
    //id casillas a rellenar listado
    @FXML private TextField listIdText;
    //@FXML private TextField listProyectos;
    //id casillas a rellenar insertar
    @FXML private TextField insertNombre;
    @FXML private TextField insertSocio;
    @FXML private TextField insertObservaciones;
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
    //@FXML private TextField deleteProyecto;
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
    //insertDateInicio
    //insertDateFinal
    //id data modificar

    ObservableList<String> choiceBoxIDContent =
            FXCollections.observableArrayList(
                    "Cooperacion desarrollo",
                    "Accion humanitaria",
                    "Fortalecimiento institucional",
                            "Educacion desarrollo"
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

}
