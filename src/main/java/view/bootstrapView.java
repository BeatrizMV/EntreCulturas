package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class bootstrapView extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        //TODO Esta es la línea que tenemos que conseguir hacer que funcione que es donde se enlaza el fxml
        //Parent root = FXMLLoader.load(getClass().getResource("fx.fxml"));

        //TODO Con esta linea compila pero al no estar enlazado el fxml no se ve el contenido de la interfaz pero si el scenario. Cuando funcione la de arriba boirrar esta
        StackPane root = new StackPane();

        //con esta linea le damos el nombre
        primaryStage.setTitle("Entreculturas");

        primaryStage.show();

        //TODO Lineas a descomentar cuando consigamos que funcione el código

        //Con esta line hacemos que lo blanco de la ventana sea transparente
        //primaryStage.initStyle(StageStyle.TRANSPARENT);

        //con esta linea le damos un color trasparente
        //Scene scene = new Scene(root);
        //scene.setFill(Color.TRANSPARENT);

        primaryStage.setScene(new Scene(root, 500, 450));
        //Cuando funcione eliminamos la linea de arriba y ponemos la de abajo
        //primaryStage.setScene(scene);


    }


    public static void startView(String args[]){
        Application.launch(args);
    }


}







