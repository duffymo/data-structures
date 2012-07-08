package tree;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertEquals;

/**
 * BinaryTreeIteratorTest
 * User: Michael
 * Date: Oct 17, 2009
 * Time: 6:01:38 PM
 * @link http://www.cs.princeton.edu/courses/archive/fall06/cos226/lectures/27iterator.pdf
 * @link http://cslibrary.stanford.edu/110/BinaryTrees.html#java
 */
@Test
public class BinaryTreeIteratorTest {
    public void testHasNextEmptyTree() {
        BinaryTree<String> empty = new BinaryTree<String>();
        AbstractBinaryTreeIterator<String> iterator = new DepthFirstIterator<String>(empty);

        assertFalse(iterator.hasNext());
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testRemove() {
        BinaryTree<String> empty = new BinaryTree<String>();
        AbstractBinaryTreeIterator<String> iterator = new DepthFirstIterator<String>(empty);
        iterator.remove();
    }

    public void testNextDepthFirst() {
        Integer[] data = {5, 3, 9, 1, 4, 6,};
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        tree.insert(data);

        String expected = "5,3,1,4,9,6,";
        AbstractBinaryTreeIterator<Integer> iterator = new DepthFirstIterator<Integer>(tree);
        String actual = createCommaSeparatedString(iterator);

        assertEquals(actual.toString(), expected);
    }

    public void testNextPostOrder() {
        Integer[] data = {5, 3, 9, 1, 4, 6,};
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        tree.insert(data);

        String expected = "1,4,3,6,9,5,";
        AbstractBinaryTreeIterator<Integer> iterator = new PostOrderIterator<Integer>(tree);
        String actual = createCommaSeparatedString(iterator);

        assertEquals(actual.toString(), expected);
    }

    private static String createCommaSeparatedString(Iterator iterator) {
        StringBuffer actual = new StringBuffer(1024);
        while (iterator.hasNext()) {
            actual.append(iterator.next()).append(',');
        }

        return actual.toString();
    }

    @DataProvider(name = "emptyTreeIterators")
    public Object[][] createEmptyTreeIterators() {
        BinaryTree<String> tree = new BinaryTree<String>();

        return new Object[][]{
                {new BreadthFirstIterator<String>(tree)},
                {new DepthFirstIterator<String>(tree)},
                {new InOrderIterator<String>(tree)},
                {new PostOrderIterator<String>(tree)},
        };
    }


    @Test(expectedExceptions = NoSuchElementException.class, dataProvider = "emptyTreeIterators")
    public void testNextEmptyTree(AbstractBinaryTreeIterator<String> iterator) {
        iterator.next();
    }

    public void testNext() {
        String[] data = {"F", "B", "A", "D", "C", "E", "G", "I", "H",};
        BinaryTree<String> tree = new BinaryTree<String>();
        tree.insert(data);

        Map<String, String> expected = new HashMap<String, String>();
        expected.put("depth-first", "F,B,A,D,C,E,G,I,H,");
        expected.put("in-order", "A,B,C,D,E,F,G,H,I,");
        expected.put("post-order", "A,C,E,D,B,H,I,G,F,");
        expected.put("breadth-first", "F,B,G,A,D,I,C,E,H,");

        String name = "depth-first";
        AbstractBinaryTreeIterator<String> iterator = new DepthFirstIterator<String>(tree);
        AbstractBinaryTreeIterator.LOGGER.debug(name);
        assertEquals(name, expected.get(name), createCommaSeparatedString(iterator));

        name = "in-order";
        iterator = new InOrderIterator<String>(tree);
        AbstractBinaryTreeIterator.LOGGER.debug(name);
        assertEquals(name, expected.get(name), createCommaSeparatedString(iterator));

        name = "post-order";
        iterator = new PostOrderIterator<String>(tree);
        AbstractBinaryTreeIterator.LOGGER.debug(name);
        assertEquals(name, expected.get(name), createCommaSeparatedString(iterator));

        name = "breadth-first";
        iterator = new BreadthFirstIterator<String>(tree);
        AbstractBinaryTreeIterator.LOGGER.debug(name);
        assertEquals(name, expected.get(name), createCommaSeparatedString(iterator));
    }
}
