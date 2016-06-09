package menu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * This is a test class for MenuItem
 * <p>
 * Created by Skyler Layne © 2016
 */
public class MenuItemTest {
    @Test
    public void createNewMenuItemWithAName() throws Exception {
        MenuItem item = new MenuItem("menu Item Name");
        assertEquals(item.getName(), "menu Item Name");
    }

    @Test
    public void addChildren() throws Exception {
        MenuItem item = new MenuItem("item");
        MenuItem child = new MenuItem("child");
        MenuItem childTwo = new MenuItem("child_two");
        MenuItem childThree = new MenuItem("child_three");

        item.addChild(child);
        item.addChild(childTwo);
        item.addChild(childThree);

        List<MenuItem> list = new ArrayList<MenuItem>();
        list.add(child);
        list.add(childTwo);
        list.add(childThree);

        assertEquals(item.getChildren(), list);
        assertEquals(child.getParent(), item);
    }
}
