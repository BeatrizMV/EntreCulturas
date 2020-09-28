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

        primaryStage.setTitle("Entreculturas");
        primaryStage.setScene(new Scene(root, 500, 450));
        primaryStage.show();
    }


    public static void startView(String args[]){
        Application.launch(args);
    }


}







