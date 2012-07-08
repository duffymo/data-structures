package tree;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * PrintVisitor
 * User: Michael
 * Date: Oct 25, 2009
 * Time: 1:14:32 PM
 */
public class PrintVisitor<T extends Comparable<T>> implements NodeVisitor<T> {
    private PrintWriter pw;
    private String format;

    public PrintVisitor(OutputStream os, String format) {
        this(new PrintWriter(os), format);
    }

    public PrintVisitor(Writer w, String format) {
        this.pw = new PrintWriter(w);
        this.format = format;
    }

    public void visit(Node<T> node) {
        pw.printf(this.format, node.getValue());
    }
}
