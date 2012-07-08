package tree;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * BreadthFirstIterator
 * User: Michael
 * Date: Oct 17, 2009
 * Time: 7:28:45 PM
 */
public class BreadthFirstIterator<T extends Comparable<T>> extends AbstractBinaryTreeIterator<T> {
    private LinkedList<Node<T>> queue = new LinkedList<Node<T>>();

    public BreadthFirstIterator(BinaryTree<T> tree) {
        init(tree.getRoot());
    }

    public void init(Node<T> root) {
        if (root != null) {
            queue.addFirst(root);
        }
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public Node<T> nextNode() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        Node<T> current = null;

        if (queue.size() > 0) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(queue);
            }

            current = queue.removeFirst();

            Node<T> next = current.getLeft();
            if (next != null) {
                queue.addLast(next);
            }

            next = current.getRight();
            if (next != null) {
                queue.addLast(next);
            }
        }

        return current;
    }
}
