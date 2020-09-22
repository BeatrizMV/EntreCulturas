package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class bootstrapView extends Application {

   /* @Override
    public void start(Stage stage) throws Exception {

        TextField mainText = new TextField();

        BorderPane pane = new BorderPane();
        pane.setTop(mainText);

        Scene scene = new Scene(pane);
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();
    }
   */

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Entreculturas");


        StackPane root = new StackPane();
        primaryStage.setScene(new Scene(root, 500, 450));
        primaryStage.show();
    }


    public static void startView(String args[]){
        Application.launch(args);
    }


}







