package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class bootstrapView extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        TextField mainText = new TextField();

        BorderPane pane = new BorderPane();
        pane.setTop(mainText);

        Scene scene = new Scene(pane);
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void startView(String args[]){
        Application.launch(args);
    }
}
