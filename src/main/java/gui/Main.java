package gui;

import gui.controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.net.URL;

/**
 * This class represents ...
 * <p>
 * Created by Skyler Layne © 2016
 */
public class Main extends Application {
    final static Logger logger = Logger.getLogger(Main.class);


    @Override
    public void start(Stage primaryStage) throws Exception {

        logger.info("app init: " + this);

        /**
         * Start gui.
         */

        String sceneFile = "main_view.fxml";
        Parent root = null;
        URL url  = null;
        try
        {
            url  = getClass().getClassLoader().getResource(sceneFile);
            root = FXMLLoader.load(url);
            System.out.println( "  fxmlResource = " + sceneFile );
        }
        catch ( Exception ex )
        {
            System.out.println(ex);
            throw ex;
        }

        primaryStage.setTitle("Menu Builder");
        Scene mainScene = new Scene(root);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
