package tree;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * PreOrderIterator visits nodes in order (root, left, right).
 * User: Michael
 * Date: Oct 17, 2009
 * Time: 5:40:37 PM
 * @link http://www.cs.princeton.edu/courses/archive/fall06/cos226/lectures/27iterator.pdf
 * @link http://en.wikipedia.org/wiki/Tree_traversal
 */
public class DepthFirstIterator<T extends Comparable<T>> extends AbstractBinaryTreeIterator<T> {
    protected Stack<Node<T>> stack = new Stack<Node<T>>();

    public DepthFirstIterator(BinaryTree<T> tree) {
        init(tree.getRoot());
    }

    public void init(Node<T> root) {
        if (root != null) {
            stack.push(root);
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

            // Visit the node; traverse the right tree, then the left
            x = stack.pop();
            if (x.getRight() != null) {
                stack.push(x.getRight());
            }
            if (x.getLeft() != null) {
                stack.push(x.getLeft());
            }
        }

        return x;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
