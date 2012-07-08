package tree;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

/**
 * BinaryTreeTest
 * User: Michael
 * Date: Oct 17, 2009
 * Time: 5:26:49 PM
 * @link http://cslibrary.stanford.edu/110/BinaryTrees.html#java
 */
@Test
public class BinaryTreeTest {
    private BinaryTree<Integer> tree;
    private Integer[] data = {5, 3, 9, 1, 4, 6,};

    @BeforeTest
    public void setUp() {
        tree = new BinaryTree<Integer>();
        tree.insert(data);
    }

    public void testIsEmpty() {
        assertFalse(tree.isEmpty());
        assertTrue(new BinaryTree<Integer>().isEmpty());
    }

    public void testSize() {
        assertEquals(tree.size(), data.length);
    }

    public void testHeight() {
        int expected = 3;
        assertEquals(tree.height(), expected);
    }

    public void testGetRoot() {
        Node<Integer> expected = new Node<Integer>(data[0]);
        assertEquals(tree.getRoot(), expected);
    }

    public void testContains() {
        for (int value : data) {
            assertTrue(tree.contains(value));
            assertFalse(tree.contains(value * 1000));
        }
    }

    public void testInsertList() {
        // When you insert a list, you get it back without alteration using a pre-order, depth-first traversal.
        List<String> data = Arrays.asList("F", "B", "A", "D", "C", "E", "G", "I", "H");
        BinaryTree<String> tree = new BinaryTree<String>();
        tree.insert(data);

        // Check the size
        assertEquals(tree.size(), data.size());

        // Now check the values
        AbstractBinaryTreeIterator<String> iterator = new DepthFirstIterator<String>(tree);
        int i = 0;
        while (iterator.hasNext()) {
            assertEquals("i = " + i, iterator.next(), data.get(i++));
        }
    }

    public void testInsertArray() {
        // When you insert a list, you get it back without alteration using a pre-order, depth-first traversal.
        String[] data = {"F", "B", "A", "D", "C", "E", "G", "I", "H",};
        BinaryTree<String> tree = new BinaryTree<String>();
        tree.insert(data);

        assertEquals(tree.size(), data.length);

        AbstractBinaryTreeIterator<String> iterator = new DepthFirstIterator<String>(tree);
        int i = 0;
        while (iterator.hasNext()) {
            assertEquals("i = " + i, iterator.next(), data[i++]);
        }
    }

    public void testInsertNullList() {
        List<String> data = null;
        BinaryTree<String> tree = new BinaryTree<String>();
        tree.insert(data);

        assertEquals(tree.size(), 0);
    }

    public void testInsertNullArray() {
        String[] data = null;
        BinaryTree<String> tree = new BinaryTree<String>();
        tree.insert(data);

        assertEquals(tree.size(), 0);
    }
}
