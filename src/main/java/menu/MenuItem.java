package menu;

import action.Action;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a single MenuItem. A MenuItem represents a single unit of work within the MenuBuilder.
 * <p>
 * Created by Skyler Layne © 2016
 */
public class MenuItem {
    private List<MenuItem> children;
    private MenuItem parent;
    private String name;
    private Action action;

    /**
     * Private MenuItem Constructor, initializes the List of children.
     */
    private MenuItem() {
        this.children = new ArrayList<MenuItem>();
    }

    /**
     * Create a new MenuItem with a given name.
     *
     * @param name - the name of the MenuItem.
     */
    public MenuItem(String name) {
        this();
        this.name = name;
    }

    /**
     * Get the name of this MenuItem
     *
     * @return - the name of the MenuItem
     */
    public String getName() {
        return this.name;
    }

    /**
     * Add a Child to the List of children MenuItem.
     *
     * @param child - a child MenuItem.
     */
    public void addChild(MenuItem child) {
        child.setParent(this);
        this.children.add(child);
    }

    /**
     * Add the set the parent of the current MenuItem.
     *
     * @param menuItem - the parent MenuItem.
     */
    private void setParent(MenuItem menuItem) {
        this.parent = menuItem;
    }

    /**
     * Get the menuItems of children.
     *
     * @return - the menuItems of this MenuItems children.
     */
    public List<MenuItem> getChildren() {
        return children;
    }

    /**
     * Get the parent of the current MenuItem.
     *
     * @return - the parent MenuItem.
     */
    public MenuItem getParent() {
        return parent;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
