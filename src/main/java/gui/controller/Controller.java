package gui.controller;

import menu.MenuItem;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents ...
 * <p>
 * Created by Skyler Layne © 2016
 */
public class Controller {
    private static Controller instance = null;
    public List<MenuItem> menuItems;

    private Controller() {
        this.menuItems = new ArrayList<MenuItem>();
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public void add(MenuItem item){
        this.menuItems.add(item);
        System.out.println(item);
    }

}
