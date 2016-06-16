package tree;

import export.Csvable;
import org.apache.log4j.Logger;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


/**
 * This class represents a generic tree.
 * <p>
 * Created by Skyler Layne © 2016
 */

public class TreeNode<T extends Csvable> implements Iterable<TreeNode<T>>, Tree<TreeNode<T>>, Csvable {

    final static Logger log = Logger.getLogger(TreeNode.class);

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
            log.info("no right sibling");
            return false;
        }
        int index = parent.children.indexOf(this);
        boolean right = index < parent.children.size();
        log.info("Has a right sibling? " + right);
        return right;
    }

    /**
     * Does the current node have a left sibling?
     *
     * @return - true if the current node has a left sibling
     */
    public boolean hasLeftSibling() {
        if (parent == null) {
            log.info("no left child");
            return false;
        }
        int index = parent.children.indexOf(this);
        boolean left = index > 0;
        log.info("Has a right sibling? " + left);
        return left;
    }

    /**
     * Get the right sibling of the current node
     *
     * @return the node directly to the right of the current node
     */
    @Override
    public TreeNode<T> getRightSibling() {
        try {
            int index = parent.children.indexOf(this);
            return parent.children.get(index + 1);
        } catch(NullPointerException | IndexOutOfBoundsException e) {
            log.error(e);
        }
        return null;
    }

    /**
     * Get the left sibling of the current node
     *
     * @return the node directly to the left of the current node
     */
    @Override
    public TreeNode<T> getLeftSibling() {
        try {
            int index = parent.children.indexOf(this);
            return parent.children.get(index - 1);
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            log.error(e);
        }
        return null;
    }

    /**
     * Add left sibling
     *
     * @param node add the node as the left sibling to the current node
     */
    public void addLeftSibling(T node) {
        if (parent == null) {
            return;
        }
        int index = parent.children.indexOf(this);
        TreeNode<T> element = new TreeNode<T>(node);
        parent.children.add(index, element);
    }

    /**
     * Add right sibling
     *
     * @param node add the node as the right sibling to the current node
     */
    public void addRightSibling(T node) {
        if (parent == null) {
            return;
        }
        int index = parent.children.indexOf(this);
        TreeNode<T> element = new TreeNode<T>(node);
        parent.children.add(index + 1, element);
    }

    @Override
    public String getCsv() {
        StringBuilder csv = new StringBuilder();
        this.iterator().forEachRemaining(item -> {
            csv.append(item.data.getCsv());
            csv.append("\n");
        });

        return csv.toString();
    }
}