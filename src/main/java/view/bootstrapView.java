package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class bootstrapView extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fx.fxml"));
        StackPane root = new StackPane();

        primaryStage.setTitle("Entreculturas");
        primaryStage.setScene(new Scene(root, 500, 450));
        primaryStage.show();
    }


    public static void startView(String args[]){
        Application.launch(args);
    }


}







