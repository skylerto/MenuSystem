package gui.controller;

import bean.MenuItemBean;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import kit.MenuItemKit;
import org.apache.log4j.Logger;
import tree.Tree;
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
    private static TreeNode<MenuItemBean> empty = new TreeNode<>(new MenuItemBean());

    @FXML
    HBox parentLayer;

    @FXML
    HBox currentLayer;

    @FXML
    HBox childrenLayer;

    @FXML
    BorderPane mainPane;

    Button addChild;

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
     *
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
                MenuItemBean bean = new MenuItemKit().make(lcd1Input, lcd2Input, modeInput, parentInput, leftInput, rightInput, selectInput, enableInput);
                logger.info("Menu Item Created: " + bean);
                TreeNode<MenuItemBean> item = new TreeNode<MenuItemBean>(bean);

                if (level == 0) {
                    root.addChild(bean);
                    this.current = empty;
                    level++;
                    currentLayer.getChildren().add(menuNode(item));
                } else {
                    this.current.addSibling(bean);
                    currentLayer.getChildren().add(menuNode(item));
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

    private Node menuNode(TreeNode<MenuItemBean> item) {
        VBox box = new VBox();

        box.setStyle("-fx-border-color: none;");

        Label lcd1Label = new Label("LCD1: " + item.data.getLcd1());
        box.getChildren().add(lcd1Label);

        Label lcd2Label = new Label("LCD2: " + item.data.getLcd2());
        box.getChildren().add(lcd2Label);

        Label modeLabel = new Label("MODE: " + item.data.getMode());
        box.getChildren().add(modeLabel);

        Label parentLabel = new Label("PARENT(BACK): " + item.data.getBack());
        box.getChildren().add(parentLabel);

        Label leftLabel = new Label("LEFT: " + item.data.getLeft());
        box.getChildren().add(leftLabel);

        Label rightLabel = new Label("RIGHT: " + item.data.getRight());
        box.getChildren().add(rightLabel);

        Label selectLabel = new Label("SELECT: " + item.data.getSelect());
        box.getChildren().add(selectLabel);

        Label enableLabel = new Label("ENABLE: " + item.data.getEnable());
        box.getChildren().add(enableLabel);

        box.setPadding(new Insets(10));

        box.setOnMouseClicked((event) -> {
            box.setStyle("-fx-border-color: none;");

            currentLayer.getChildren().forEach(e -> {
                e.setStyle("-fx-border-color: none;");
            });

            childrenLayer.getChildren().forEach(e -> {
                e.setStyle("-fx-border-color: none;");
            });


            if (this.current.equals(item)) {
                this.current = empty;
                logger.info(this.current);
                removeSideBar();
            } else {
                box.setStyle("-fx-border-color: grey;");
                this.current = item;
                logger.info(this.current);
                addSideBar(item);
            }
        });

        return box;
    }

    private void removeSideBar() {
        mainPane.setRight(new VBox());
    }

    private void addSideBar(TreeNode<MenuItemBean> item) {
        VBox box = new VBox();

        Text title = new Text("Component: ");
        box.getChildren().add(title);

        HBox b = new HBox();
        Label lcd1Label = new Label("LCD1:");
        TextField lcd1Input = new TextField(item.data.getLcd1());
        b.getChildren().add(lcd1Label);
        b.getChildren().add(lcd1Input);
        box.getChildren().add(b);
        b = null;

        b = new HBox();
        Label lcd2Label = new Label("LCD2:");
        TextField lcd2Input = new TextField(item.data.getLcd2());
        b.getChildren().add(lcd2Label);
        b.getChildren().add(lcd2Input);
        box.getChildren().add(b);
        b = null;

        b = new HBox();
        Label modeLabel = new Label("MODE:");
        TextField modeInput = new TextField("" + item.data.getMode());
        b.getChildren().add(modeLabel);
        b.getChildren().add(modeInput);
        box.getChildren().add(b);
        b = null;

        b = new HBox();
        Label parentLabel = new Label("PARENT(BACK):");
        TextField parentInput = new TextField("" + item.data.getBack());
        b.getChildren().add(parentLabel);
        b.getChildren().add(parentInput);
        box.getChildren().add(b);
        b = null;

        b = new HBox();
        Label leftLabel = new Label("LEFT:");
        TextField leftInput = new TextField("" + item.data.getLeft());
        b.getChildren().add(leftLabel);
        b.getChildren().add(leftInput);
        box.getChildren().add(b);
        b = null;


        b = new HBox();
        Label rightLabel = new Label("RIGHT:");
        TextField rightInput = new TextField("" + item.data.getRight());
        b.getChildren().add(rightLabel);
        b.getChildren().add(rightInput);
        box.getChildren().add(b);
        b = null;

        b = new HBox();
        Label selectLabel = new Label("SELECT:");
        TextField selectInput = new TextField("" + item.data.getSelect());
        b.getChildren().add(selectLabel);
        b.getChildren().add(selectInput);
        box.getChildren().add(b);
        b = null;

        b = new HBox();
        Label enableLabel = new Label("ENABLE:");
        TextField enableInput = new TextField("" + item.data.getEnable());
        b.getChildren().add(enableLabel);
        b.getChildren().add(enableInput);
        box.getChildren().add(b);
        b = null;

        Button update = new Button("Update");
        box.getChildren().add(update);
        update.setOnAction((event) -> {
            updateMenuNode(item, lcd1Input, lcd2Input, modeInput, parentInput, leftInput, rightInput, selectInput, enableInput);
        });

        addChild = new Button("Add Child");
        box.getChildren().add(addChild);
        addChild.setOnAction(this::addChildAction);

        box.setPadding(new Insets(20, 50, 20, 20));

        mainPane.setRight(box);
    }

    private void updateMenuNode(TreeNode<MenuItemBean> item, TextField lcd1Input, TextField lcd2Input, TextField modeInput, TextField parentInput, TextField leftInput, TextField rightInput, TextField selectInput, TextField enableInput) {
        try {
            String lcd1 = lcd1Input.getText();
            String lcd2 = lcd2Input.getText();
            Byte mode = Byte.parseByte(modeInput.getText());
            Byte parent = Byte.parseByte(parentInput.getText());
            Byte left = Byte.parseByte(leftInput.getText());
            Byte right = Byte.parseByte(rightInput.getText());
            Byte select = Byte.parseByte(selectInput.getText());
            Byte enable = Byte.parseByte(enableInput.getText());

            item.data.setLcd1(lcd1);
            item.data.setLcd2(lcd2);
            item.data.setMode(mode);
            item.data.setBack(parent);
            item.data.setLeft(left);
            item.data.setRef(right);
            item.data.setSelect(select);
            item.data.setEnable(enable);
            logger.info("Menu Item updated: " + item);

            logger.info(item.getCsv());

            mainPane.requestLayout();

        } catch (Exception e) {
            logger.error("Error in object creation", e);
        }
    }

    private void addChildAction(ActionEvent actionEvent) {
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
                MenuItemBean bean = new MenuItemKit().make(lcd1Input, lcd2Input, modeInput, parentInput, leftInput, rightInput, selectInput, enableInput);
                logger.info("Menu Item Created: " + bean);
                TreeNode<MenuItemBean> item = new TreeNode<MenuItemBean>(bean);

                if (level == 0) {
                    root.addChild(bean);
                    this.current = empty;
                    level++;
                    currentLayer.getChildren().add(menuNode(item));
                } else {
                    this.current.addChild(bean);
                    childrenLayer.getChildren().add(menuNode(item));
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
