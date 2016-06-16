package gui.controller;

import bean.MenuItemBean;
import tree.Tree;
import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents ...
 * <p>
 * Created by Skyler Layne © 2016
 */
public class Controller {
    private static Controller instance = null;
    public TreeNode<MenuItemBean> menuItems;
    public int level;

    private Controller() {
        this.menuItems = new TreeNode<>(new MenuItemBean());
        this.level = 1;
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    /**
     * Add  new menu item on the current level.
     * @param item
     */
    public void add(MenuItemBean item) {

    }

}
