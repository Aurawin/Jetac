import javax.swing.*;
import javax.swing.plaf.basic.BasicTreeUI;
import javax.swing.tree.TreePath;
import java.awt.*;


public class TreeUI extends BasicTreeUI {
    @Override
    protected void paintRow(Graphics g, Rectangle clipBounds, Insets insets, Rectangle bounds, TreePath path, int row, boolean isExpanded, boolean hasBeenExpanded, boolean isLeaf)
    {
        if(tree.isRowSelected(row))
        {
            g.setColor(Color.RED);
            g.fillRect(0, row * tree.getRowHeight(), tree.getWidth(), tree.getRowHeight());
        }

        super.paintRow(g, clipBounds, insets, bounds, path, row, isExpanded, hasBeenExpanded, isLeaf);
    }
}
