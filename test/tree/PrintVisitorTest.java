package tree;

import org.testng.annotations.Test;

import java.io.StringWriter;

import static org.testng.Assert.assertEquals;

/**
 * PrintVisitorTest
 * User: Michael
 * Date: Oct 25, 2009
 * Time: 7:18:38 PM
 */
@Test
public class PrintVisitorTest {
    public void testVisit() {
        String[] data = {"F", "B", "A", "D", "C", "E", "G", "I", "H",};
        BinaryTree<String> tree = new BinaryTree<String>();
        for (String value : data) {
            tree.insert(value);
        }

        StringWriter actual = new StringWriter(1024);
        NodeVisitor<String> visitor = new PrintVisitor<String>(actual, "%s ");

        for (BinaryTreeIterator<String> iter = new DepthFirstIterator<String>(tree); iter.hasNext(); ) {
            visitor.visit(iter.nextNode());
        }
        String expected = "F B A D C E G I H ";
        assertEquals(actual.toString(), expected);
    }
}
