package kit;

import bean.MenuItemBean;
import javafx.scene.control.TextField;

/**
 * This class represents a kit for generating {@link MenuItemBean} from UI elements.
 * <p>
 * Created by Skyler Layne © 2016
 */
public class MenuItemKit implements Kit {

    /**
     * Create a new MenuItemBean from a list of {@link TextField}.
     *
     * @param fields the fields which hold the data.
     * @return a new {@link MenuItemBean} from the given fields.
     */
    @Override
    public MenuItemBean make(TextField... fields) {
        String lcd1 = fields[0].getText();
        String lcd2 = fields[1].getText();
        Byte mode = Byte.parseByte(fields[2].getText());
        Byte parent = Byte.parseByte(fields[3].getText());
        Byte left = Byte.parseByte(fields[4].getText());
        Byte right = Byte.parseByte(fields[5].getText());
        Byte select = Byte.parseByte(fields[6].getText());
        Byte enable = Byte.parseByte(fields[7].getText());

        return new MenuItemBean(lcd1, lcd2, mode, parent, left, right, select, enable);
    }
}
