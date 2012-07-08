package tree;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * BinaryTreeIterator
 * User: Michael
 * Date: Oct 17, 2009
 * Time: 7:06:31 PM
 */
public abstract class AbstractBinaryTreeIterator<T extends Comparable<T>> implements BinaryTreeIterator<T> {
    public static final Log LOGGER = LogFactory.getLog(AbstractBinaryTreeIterator.class);

    public void remove() {
        throw new UnsupportedOperationException("cannot remove from a binary tree");
    }

    public T next() {
        Node<T> nextNode = nextNode();

        return nextNode.getValue();
    }
}
