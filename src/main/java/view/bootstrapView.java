package view;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class bootstrapView extends Application {

    private double xOffset;
    private double yOffset;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //con esta linea unimos con fxml
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fx.fxml"));

        /** Metodos para mover la aplicacion **/
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneY();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getSceneX() - xOffset);
                primaryStage.setY(event.getSceneY() - xOffset);
            }
        });





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







