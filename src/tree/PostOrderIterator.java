package tree;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * PostOrderIterator visits nodes in order (left, right, root).
 * User: Michael
 * Date: Oct 17, 2009
 * Time: 6:50:52 PM
 */
public class PostOrderIterator<T extends Comparable<T>> extends AbstractBinaryTreeIterator<T> {
    protected Stack<Node<T>> stack = new Stack<Node<T>>();

    public PostOrderIterator(BinaryTree<T> tree) {
        init(tree.getRoot());
    }

    public void init(Node<T> root) {
        if (root != null) {
            stack.clear();
            stackChildren(root);
        }
    }

    private void stackChildren(Node<T> node) {
        stack.push(node);
        Node<T> next = node.getRight();
        if (next != null) {
            stackChildren(next);
        }
        next = node.getLeft();
        if (next != null) {
            stackChildren(next);
        }
    }

    public Node<T> nextNode() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        Node<T> x = null;

        if (!stack.empty()) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(stack);
            }

            x = stack.pop();
        }

        return x;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
