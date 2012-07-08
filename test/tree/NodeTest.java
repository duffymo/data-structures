package tree;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * NodeTest
 * User: Michael
 * Date: Oct 15, 2009
 * Time: 10:21:48 PM
 */
@Test
public class NodeTest {
    /**
     * For any non-null reference value x, x.equals(null) must return false.
     * @link http://java.sun.com/developer/Books/effectivejava/Chapter3.pdf
     */
    public void testNotNull() {
        Node<String> x = new Node<String>("test");

        assertFalse(x.equals(null));
    }

    /**
     * It is reflexive: For any reference value x, x.equals(x) must return true.
     * @link http://java.sun.com/developer/Books/effectivejava/Chapter3.pdf
     */
    public void testReflexive() {
        Node<String> x = new Node<String>("test");

        assertTrue(x.equals(x));
        assertEquals(0, x.compareTo(x));
    }

    /**
     * It is symmetric: For any reference values x and y, x.equals(y) must return
     * true if and only if y.equals(x) returns true.
     * @link http://java.sun.com/developer/Books/effectivejava/Chapter3.pdf
     */
    public void testSymmetric() {
        Node<String> x = new Node<String>("test");
        Node<String> y = new Node<String>("test");
        Node<String> z = new Node<String>("something else");

        assertTrue(x.equals(y) && y.equals(x));
        assertTrue((x.compareTo(y) == 0) && (y.compareTo(x) == 0));
        assertFalse(x.equals(z));
        assertTrue(x.compareTo(z) > 0);
    }

    /**
     * It is transitive: For any reference values x, y, and z, if x.equals(y) returns
     * true and y.equals(z) returns true, then x.equals(z) must return true
     * @link http://java.sun.com/developer/Books/effectivejava/Chapter3.pdf
     */
    public void testTransitive() {
        Node<String> x = new Node<String>("test");
        Node<String> y = new Node<String>("test");
        Node<String> z = new Node<String>("test");

        assertTrue(x.equals(y) && y.equals(z) && z.equals(x));
        assertTrue((x.compareTo(y) == 0) && (y.compareTo(z) == 0) && (z.compareTo(x) == 0));
    }

    public void testHashCode() {
        Node<String> x = new Node<String>("test");
        Node<String> y = new Node<String>("test");
        Node<String> z = new Node<String>("something else");

        assertTrue(x.hashCode() == y.hashCode());
        assertFalse(x.hashCode() == z.hashCode());
    }

    public void testToString() {
        String expected = "expected";

        Node<String> node = new Node<String>(expected);
        assertEquals(node.toString(), expected);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testCompareToNull() {
        Node<String> x = new Node<String>("test");

        x.compareTo(null);
    }

    public void testCompareTo() {
        Node<String> x = new Node<String>("x");
        Node<String> y = new Node<String>("y");
        Node<String> z = new Node<String>("z");

        assertTrue((x.compareTo(x) == 0) && (x.compareTo(y) < 0) && (x.compareTo(z) < 0));
        assertTrue((y.compareTo(x) > 0) && (y.compareTo(y) == 0) && (y.compareTo(z) < 0));
        assertTrue((z.compareTo(x) > 0) && (z.compareTo(y) > 0) && (z.compareTo(z) == 0));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNullValue() {
        Node<String> x = new Node<String>(null);
    }

    public void testIsLeaf() {
        Node<String> x = new Node<String>("test");

        assertTrue(x.isLeaf());

        x.setLeft(new Node<String>("left"));
        x.setRight(new Node<String>("right"));

        assertFalse(x.isLeaf());

        assertEquals("left", x.getLeft().getValue());
        assertEquals("right", x.getRight().getValue());
    }
}


