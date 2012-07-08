package tree;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * InOrderIterator visits nodes in order (left, root, right)
 * User: Michael
 * Date: Oct 17, 2009
 * Time: 7:20:23 PM
 * @link http://www.cs.princeton.edu/courses/archive/fall06/cos226/lectures/27iterator.pdf
 * @link http://en.wikipedia.org/wiki/Tree_traversal
 */
public class InOrderIterator<T extends Comparable<T>> extends AbstractBinaryTreeIterator<T> {
    protected Stack<Node<T>> stack = new Stack<Node<T>>();

    public InOrderIterator(BinaryTree<T> tree) {
        init(tree.getRoot());
    }

    public void init(Node<T> root) {
        if (root != null) {
            stack.clear();
            slideLeft(root);
        }
    }

    private void slideLeft(Node<T> current) {
        while (current != null) {
            stack.push(current);
            current = current.getLeft();
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
            Node<T> next = x.getRight();
            if (next != null) {
                slideLeft(next);
            }
        }

        return x;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
