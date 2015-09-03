import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class TreeView extends JTree {
    public TreeView(DefaultMutableTreeNode root){
        super (root);
        setRowHeight(25);
        setUI(new TreeUI());
    }
}
