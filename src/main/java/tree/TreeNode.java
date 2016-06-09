package tree;

import bean.MenuItemBean;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


/**
 * This class represents a generic tree.
 * <p>
 * Created by Skyler Layne © 2016
 */

public class TreeNode<T> implements Iterable<TreeNode<T>> {

    public T data;
    public TreeNode<T> parent;
    public List<TreeNode<T>> children;

    public boolean isRoot() {
        return parent == null;
    }

    public boolean isLeaf() {
        return children.size() == 0;
    }

    private List<TreeNode<T>> elementsIndex;

    public TreeNode(T data) {
        this.data = data;
        this.children = new LinkedList<TreeNode<T>>();
        this.elementsIndex = new LinkedList<TreeNode<T>>();
        this.elementsIndex.add(this);
    }

    public TreeNode<T> addChild(T child) {
        TreeNode<T> childNode = new TreeNode<T>(child);
        childNode.parent = this;
        this.children.add(childNode);
        this.registerChildForSearch(childNode);
        return childNode;
    }

    public int getLevel() {
        if (this.isRoot())
            return 0;
        else
            return parent.getLevel() + 1;
    }

    private void registerChildForSearch(TreeNode<T> node) {
        elementsIndex.add(node);
        if (parent != null)
            parent.registerChildForSearch(node);
    }

    public TreeNode<T> findTreeNode(Comparable<T> cmp) {
        for (TreeNode<T> element : this.elementsIndex) {
            T elData = element.data;
            if (cmp.compareTo(elData) == 0)
                return element;
        }

        return null;
    }

    @Override
    public String toString() {
        return data != null ? data.toString() : "[data null]";
    }

    @Override
    public Iterator<TreeNode<T>> iterator() {
        TreeNodeIterator<T> iter = new TreeNodeIterator<T>(this);
        return iter;
    }

    /**
     * Does the current node have a right sibling?
     *
     * @return - true of the current node has a right sibling
     */
    public boolean hasRightSibling() {
        if (parent == null) {
            return false;
        }
        int index = parent.children.indexOf(this);
        return index < parent.children.size();
    }

    /**
     * Does the current node have a left sibling?
     *
     * @return - true if the current node has a left sibling
     */
    public boolean hasLeftSibling() {
        if (parent == null) {
            return false;
        }
        int index = parent.children.indexOf(this);
        return index > 0;
    }

    /**
     * Get the right sibling of the current node
     *
     * @return the node directly to the right of the current node
     */
    public TreeNode<T> getRightSibling() throws NullPointerException, IndexOutOfBoundsException {
        int index = parent.children.indexOf(this);
        return parent.children.get(index + 1);
    }

    /**
     * Get the left sibling of the current node
     *
     * @return the node directly to the left of the current node
     */
    public TreeNode<T> getLeftSibling() {
        int index = parent.children.indexOf(this);
        return parent.children.get(index - 1);
    }
}