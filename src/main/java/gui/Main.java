package gui;

import gui.MenuBuilder;
import gui.controller.Controller;
import gui.handler.NewMenuItemHandler;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * This class represents ...
 * <p>
 * Created by Skyler Layne © 2016
 */
public class Main extends Application {

    Stage window;
    private Button button;
    Scene one, two;
    static HBox level;
    static StackPane pane;


    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Menu Builder");
        button = new Button("New Menu Item");
        button.setOnAction(new NewMenuItemHandler(window));

        pane = new StackPane();
        level = new HBox();
        pane.getChildren().add(level);
        update();

        pane.getChildren().add(button);
        one = new Scene(pane, 300, 250);

        window.setScene(one);
        window.show();
    }

    public static void update() {
        Controller controller = Controller.getInstance();

        level.getChildren().clear();

        controller.menuItems.forEach(e -> {
            Pane canvas = new Pane();
            canvas.setStyle("-fx-background-color: white;");
            canvas.setPrefSize(100, 10);
            canvas.setPadding(new Insets(10));

            Label name = new Label(e.getName());
            canvas.getChildren().add(name);
            level.getChildren().add(canvas);

        });
    }
}
