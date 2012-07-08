package tree;

import java.util.Arrays;
import java.util.List;

/**
 * BinaryTree
 * User: Michael
 * Date: Oct 14, 2009
 * Time: 9:53:35 PM
 * @link http://cslibrary.stanford.edu/
 * @link http://cslibrary.stanford.edu/110/BinaryTrees.html#java
 */
public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root;

    public BinaryTree() {
        this(null);
    }

    public BinaryTree(Node<T> root) {
        this.root = root;
    }

    public Node<T> getRoot() {
        return this.root;
    }

    public boolean contains(T value) {
        return contains(this.root, value);
    }

    private boolean contains(Node<T> node, T value) {
        // empty tree can't contain the value; value cannot be null
        if ((node == null) || (value == null)) {
            return false;
        }

        if (value.equals(node.getValue())) {
            return true;
        } else if (value.compareTo(node.getValue()) < 0) {
            return contains(node.getLeft(), value);
        } else {
            return contains(node.getRight(), value);
        }
    }

    public void insert(T value) {
        this.root = insert(this.root, value);
    }

    public void insert(List<T> values) {
        if ((values != null) && (values.size() > 0)) {
            for (T value : values) {
                insert(value);
            }
        }
    }

    public void insert(T[] values) {
        if ((values != null) && (values.length > 0)) {
            insert(Arrays.asList(values));
        }
    }

    private Node<T> insert(Node<T> node, T value) {
        if (node == null) {
            return new Node<T>(value);
        } else {
            if (value.compareTo(node.getValue()) < 0) {
                node.setLeft(insert(node.getLeft(), value));
            } else {
                node.setRight(insert(node.getRight(), value));
            }
        }

        return node;
    }

    public int size() {
        return size(root);
    }

    private int size(Node<T> node) {
        if (node == null) {
            return 0;
        } else {
            return (size(node.getLeft()) + 1 + size(node.getRight()));
        }
    }

    public int height() {
        return height(root);
    }

    private int height(Node<T> node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = height(node.getLeft());
            int rightHeight = height(node.getRight());

            return (Math.max(leftHeight, rightHeight) + 1);
        }
    }

    public boolean isEmpty() {
        return (root == null);
    }
}
