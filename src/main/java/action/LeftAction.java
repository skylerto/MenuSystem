package action;

import bean.MenuItemBean;

/**
 * This class represents what it means to take a left action, reflexive to a right action.
 * <p>
 * Created by Skyler Layne © 2016
 */
public class LeftAction implements Action {

    private MenuItemBean bean;
    public LeftAction(MenuItemBean bean) {
        this.bean = bean;
    }

    @Override
    public int perform() {
        return this.bean.getRef();
    }
}
