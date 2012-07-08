package tree;

/**
 * NodeVisitor
 * User: Michael
 * Date: Oct 25, 2009
 * Time: 1:07:55 PM
 */
public interface NodeVisitor<T extends Comparable<T>> {
    void visit(Node<T> node);
}
