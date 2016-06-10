package tree;

/**
 * This class represents ...
 * <p>
 * Created by Skyler Layne © 2016
 */
public interface Tree<T> {
    boolean hasRightSibling();

    boolean hasLeftSibling();

    T getRightSibling() throws NullPointerException, IndexOutOfBoundsException;

    T getLeftSibling();

//    void addLeftSibling(T element);
//
//    void addRightSibling(T element);

}
