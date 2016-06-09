package tree;


import bean.MenuItemBean;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class represents ...
 * <p>
 * Created by Skyler Layne © 2016
 */
public class MenuTreeTest {
    @Test
    public void menuTreeCreation() throws Exception {
        MenuItemBean bean = new MenuItemBean("first", "second", (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0);
        TreeNode<MenuItemBean> tree = new TreeNode<>(null);

        tree.addChild(bean);

        assertEquals(tree.data, null);
        assertEquals(tree.children.get(0).data, bean);
    }
    @Test(expected=IndexOutOfBoundsException.class)
    public void testIndexError()throws Exception {
        MenuItemBean bean = new MenuItemBean("first", "second", (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0);
        MenuItemBean one = new MenuItemBean("first", "second", (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0);
        MenuItemBean two = new MenuItemBean("first", "second", (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0);
        MenuItemBean three = new MenuItemBean("first", "second", (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0);
        TreeNode<MenuItemBean> tree = new TreeNode<>(null);

        tree.addChild(bean);
        assertEquals(tree.hasRightSibling(), false);
        assertEquals(tree.hasLeftSibling(), false);


        TreeNode<MenuItemBean> root = tree.children.get(0);
        root.getLeftSibling();

//
//
//        root.addChild(one);
//        root.addChild(two);
//        root.addChild(three);
//
//        TreeNode<MenuItemBean> current = root.children.get(0);
//
//        assertEquals(current.hasRightSibling(), true);
//        assertEquals(current.hasLeftSibling(), false);
//
//        assertEquals(current.getRightSibling().data, two);


    }

    @Test
    public void testSiblings() throws Exception {
        MenuItemBean bean = new MenuItemBean("first", "second", (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0);
        MenuItemBean one = new MenuItemBean("first", "second", (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0);
        MenuItemBean two = new MenuItemBean("first", "second", (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0);
        MenuItemBean three = new MenuItemBean("first", "second", (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0);
        TreeNode<MenuItemBean> tree = new TreeNode<>(null);

        tree.addChild(bean);
        assertEquals(tree.hasRightSibling(), false);
        assertEquals(tree.hasLeftSibling(), false);



        TreeNode<MenuItemBean> root = tree.children.get(0);
        root.addChild(one);
        root.addChild(two);
        root.addChild(three);

        TreeNode<MenuItemBean> current = root.children.get(0);

        assertEquals(current.hasRightSibling(), true);
        assertEquals(current.hasLeftSibling(), false);

//        assertEquals(current.getRightSibling().data, two);

        current = current.getRightSibling();

        assertEquals(current.getLeftSibling().data, one);

    }
}
