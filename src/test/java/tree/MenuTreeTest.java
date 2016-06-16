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

    @Test
    public void testHasRightSibling() throws Exception {
        MenuItemBean bean = new MenuItemBean("first", "second", (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0);
        MenuItemBean one = new MenuItemBean("first", "second", (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0);
        MenuItemBean two = new MenuItemBean("first", "second", (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0);
        TreeNode<MenuItemBean> tree = new TreeNode<>(null);

        tree.addChild(bean);
        assertEquals(tree.hasRightSibling(), false);

        TreeNode<MenuItemBean> root = tree.children.get(0);
        root.addChild(one);
        root.addChild(two);
        TreeNode<MenuItemBean> current = root.children.get(0);
        assertEquals(current.hasRightSibling(), true);
    }

    @Test
    public void testHasLeftSibling() throws Exception {
        MenuItemBean bean = new MenuItemBean("first", "second", (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0);
        MenuItemBean one = new MenuItemBean("first", "second", (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0);
        MenuItemBean two = new MenuItemBean("first", "second", (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0);
        TreeNode<MenuItemBean> tree = new TreeNode<>(null);
        tree.addChild(bean);
        assertEquals(tree.hasLeftSibling(), false);
        TreeNode<MenuItemBean> root = tree.children.get(0);
        root.addChild(one);
        root.addChild(two);
        TreeNode<MenuItemBean> current = root.children.get(1);
        assertEquals(current.hasLeftSibling(), true);
    }

    @Test
    public void testAddLeftSibling() throws Exception {
        MenuItemBean bean = new MenuItemBean("first", "second", (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0);
        MenuItemBean one = new MenuItemBean("first", "second", (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0);

        TreeNode<MenuItemBean> tree = new TreeNode<>(null);
        tree.addChild(bean);

        TreeNode<MenuItemBean> root = tree.children.get(0);
        root.addLeftSibling(one);

        assertEquals(root.getLeftSibling().data, one);
    }

    @Test
    public void testAddRightSibling() throws Exception {
        MenuItemBean bean = new MenuItemBean("first", "second", (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0);
        MenuItemBean one = new MenuItemBean("first", "second", (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0);

        TreeNode<MenuItemBean> tree = new TreeNode<>(null);
        tree.addChild(bean);

        TreeNode<MenuItemBean> root = tree.children.get(0);
        root.addRightSibling(one);

        assertEquals(root.getRightSibling().data, one);
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
        current = current.getRightSibling();
        assertEquals(current.getLeftSibling().data, one);
    }

    @Test
    public void testGetCsv() throws Exception {
        MenuItemBean bean = new MenuItemBean("first", "second", (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0);
        MenuItemBean one = new MenuItemBean("first", "second", (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0);
        MenuItemBean two = new MenuItemBean("first", "second", (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0);
        MenuItemBean three = new MenuItemBean("first", "second", (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0);
        TreeNode<MenuItemBean> tree = new TreeNode<>(new MenuItemBean());
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
        current = current.getRightSibling();
        assertEquals(current.getLeftSibling().data, one);
        System.out.print(tree.getCsv());
    }
}
