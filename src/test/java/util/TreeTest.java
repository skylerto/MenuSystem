package util;

import org.junit.Test;
import tree.TreeNode;

import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * This class represents ...
 * <p>
 * Created by Skyler Layne © 2016
 */
public class TreeTest {
    @Test
    public void testConstructor() throws Exception {
        TreeNode<String> tree = new TreeNode<>(null);
        tree.addChild("one");
        tree.addChild("two");

        assertEquals(tree.children.get(1).data, "two");
        assertEquals(tree.children.get(0).data, "one");

    }

    @Test
    public void testIterator() throws Exception {
        TreeNode<String> tree = new TreeNode<>(null);
        tree.addChild("one");
        System.out.println(tree.isRoot());

        TreeNode<String> one = tree.children.get(0);
        System.out.println(one.isRoot());
        one.addChild("one,one");
        one.addChild("one,two");
        one.addChild("one,three");
        tree.addChild("two");

        tree.iterator().forEachRemaining(e -> {
            System.out.println(e.data);
        });
    }
}