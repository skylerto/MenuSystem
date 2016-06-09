package action;

import bean.MenuItemBean;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class represents ...
 * <p>
 * Created by Skyler Layne © 2016
 */
public class LeftActionTest {
    @Test
    public void performTest() throws Exception {
        MenuItemBean bean = new MenuItemBean("first", "second", (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0);
        Action action = new LeftAction(bean);
        assertEquals(action.perform(), 0);
    }

}