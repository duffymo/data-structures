package tree;

import java.util.Iterator;

/**
 * BinaryTreeIterator
 * User: Michael
 * Date: Oct 20, 2009
 * Time: 7:32:09 PM
 */
public interface BinaryTreeIterator<T extends Comparable<T>> extends Iterator<T> {
    Node<T> nextNode();
}
