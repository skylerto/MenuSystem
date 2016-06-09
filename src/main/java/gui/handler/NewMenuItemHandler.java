package gui.handler;

import gui.Main;
import gui.controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import menu.MenuItem;


/**
 * This class handles new menu item button clicks.
 * <p>
 * Created by Skyler Layne © 2016
 */
public class NewMenuItemHandler implements EventHandler<ActionEvent> {

    private Stage window;

    public NewMenuItemHandler(Stage window) {
        this.window = window;
    }

    public void handle(ActionEvent event) {
        final Scene previous = this.window.getScene();

        // Layout 1 - children are laid out in vertical column.
        VBox layout = new VBox(20);
        layout.setPadding(new Insets(10));
        layout.setSpacing(8);

        Scene newMenuItem = new Scene(layout, 250, 150);

        Text t = new Text();
        t.setText("New Menu Item");
        t.setFont(Font.font (20));
        layout.getChildren().add(t);

        Label label = new Label("Name");
        layout.getChildren().add(label);
        final TextField nameField = new TextField();
        layout.getChildren().add(nameField);

        Button button = new Button("Create Menu Item");
        layout.getChildren().add(button);
        button.setOnAction(e -> {
            MenuItem item = new MenuItem(nameField.getText());
            Controller controller = Controller.getInstance();
            controller.add(item);
            window.setScene(previous);
            Main.update();
        });

        this.window.setScene(newMenuItem);
        System.out.println("New Menu Item Button Clicked!");
    }
}
