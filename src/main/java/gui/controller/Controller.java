package gui.controller;

import bean.MenuItemBean;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import tree.TreeNode;

/**
 * This class represents ...
 * <p>
 * Created by Skyler Layne © 2016
 */
public class Controller {

    final static Logger logger = Logger.getLogger(Controller.class);

    private static Controller instance = null;
    public TreeNode<MenuItemBean> root;
    public int level;
    private TreeNode<MenuItemBean> current;

    public Controller() {
        if (instance == null) {
            this.root = new TreeNode<>(new MenuItemBean());
            this.level = 0;
            this.current = null;
            instance = this;
        }
    }

    /**
     * Add  new menu item on the current level.
     * @param item
     */
    public void add(MenuItemBean item) {

    }

    /**
     * What Happens with the 'Add Item' Button is pressed.
     *
     * @param actionEvent - the action event.
     */
    public void addItemAction(ActionEvent actionEvent) {

        logger.info("Add item: " + actionEvent.getSource());
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        VBox dialogVbox = new VBox(20);
        dialogVbox.setPadding(new Insets(10));

        Label lcd1Label = new Label("lcd1");
        TextField lcd1Input = new TextField();
        dialogVbox.getChildren().add(lcd1Label);
        dialogVbox.getChildren().add(lcd1Input);

        Label lcd2Label = new Label("lcd2");
        TextField lcd2Input = new TextField();
        dialogVbox.getChildren().add(lcd2Label);
        dialogVbox.getChildren().add(lcd2Input);

        Label modeLabel = new Label("mode");
        TextField modeInput = new TextField();
        dialogVbox.getChildren().add(modeLabel);
        dialogVbox.getChildren().add(modeInput);

        Label parentLabel = new Label("parent(back)");
        TextField parentInput = new TextField();
        dialogVbox.getChildren().add(parentLabel);
        dialogVbox.getChildren().add(parentInput);

        Label leftLabel = new Label("left sibling");
        TextField leftInput = new TextField();
        dialogVbox.getChildren().add(leftLabel);
        dialogVbox.getChildren().add(leftInput);

        Label rightLabel = new Label("right sibling");
        TextField rightInput = new TextField();
        dialogVbox.getChildren().add(rightLabel);
        dialogVbox.getChildren().add(rightInput);

        Label selectLabel = new Label("select");
        TextField selectInput = new TextField();
        dialogVbox.getChildren().add(selectLabel);
        dialogVbox.getChildren().add(selectInput);

        Label enableLabel = new Label("enable");
        TextField enableInput = new TextField();
        dialogVbox.getChildren().add(enableLabel);
        dialogVbox.getChildren().add(enableInput);

        Button addButton = new Button("Add Item");
        dialogVbox.getChildren().add(addButton);
        addButton.setOnAction((event) -> {
            try {
                String lcd1 = lcd1Input.getText();
                String lcd2 = lcd2Input.getText();


                Byte mode = Byte.parseByte(modeInput.getText());
                Byte parent = Byte.parseByte(parentInput.getText());
                Byte left = Byte.parseByte(leftInput.getText());
                Byte right = Byte.parseByte(rightInput.getText());
                Byte select = Byte.parseByte(selectInput.getText());
                Byte enable = Byte.parseByte(enableInput.getText());

                MenuItemBean bean = new MenuItemBean(lcd1, lcd2, mode, parent, left, right, select, enable);
                logger.info("Menu Item Created: " + bean);

                if(level == 0) {
                    root.addChild(bean);
                    this.current = root.children.get(0);
                    level++;
                } else {
                    this.current.addSibling(bean);
                }
                logger.info(root.getCsv());

                dialog.close();
            } catch (Exception e) {
                logger.error("Error in object creation", e);
            }


        });

        Scene dialogScene = new Scene(dialogVbox, 300, 725);
        dialog.setScene(dialogScene);
        dialog.show();

    }
}
