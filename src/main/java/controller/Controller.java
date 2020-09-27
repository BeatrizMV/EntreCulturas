package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Controller {

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


}
