package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class bootstrapView extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //con esta linea unimos con fxml
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fx.fxml"));
        //Con esta line hacemos que lo blanco de nuestro menu sea transparente
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        //con esta linea le damos el nombre
        primaryStage.setTitle("Entreculturas");
        //cremos una scena para darle el color transparente
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        //con esta linea creamos la escena que nos coja el diseño que tenemos, en caso de querer dar un tamaño concreto usamos (new Scene(root, 500, 450));
        primaryStage.setScene(scene);
        //primaryStage.setScene(new Scene(root, 500, 450));
        primaryStage.show();
    }

    public static void startView(String args[]){
        Application.launch(args);
    }

}







