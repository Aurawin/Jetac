import com.aurawin.core.lang.Table;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.*;
//import pnlCollectionClient;

public class spCollectionView extends JScrollPane {
    pnlCollectionClient Owner;
    DefaultMutableTreeNode Root;
    TreeView View;
    public DefaultMutableTreeNode addSimpleEntry(String Name, String Value){

        DefaultMutableTreeNode tnResult = new DefaultMutableTreeNode(Name);
        TreePath tpSel = View.getSelectionPath();
        DefaultMutableTreeNode Parent = Root;
        if (tpSel!=null){
            Parent=(DefaultMutableTreeNode) tpSel.getLastPathComponent();
        } else {
            tpSel=new TreePath(Parent.getPath());
        }
        Parent.add(tnResult);
        View.expandPath(tpSel);

        TreePath tpResult = new TreePath(tnResult.getPath());

        View.scrollPathToVisible(tpResult);
        View.setSelectionPath(tpResult);

        return tnResult;
        //Result.setUserObject(); todo
    }
    public spCollectionView(pnlCollectionClient aOwner) {
        super();
        Owner = aOwner;
        Owner.add(this, BorderLayout.CENTER);
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), null));

        Root = new DefaultMutableTreeNode(Table.String(Table.Item.JSONObject));
        View=new TreeView(Root);

        View.setDropMode(DropMode.ON_OR_INSERT);
        View.setEnabled(true);
        View.setFocusCycleRoot(true);
        View.setFocusTraversalPolicyProvider(true);
        View.setInvokesStopCellEditing(true);
        View.setLargeModel(true);
        View.setRootVisible(true);
        View.putClientProperty("JTree.lineStyle", "Angled");
        setViewportView(View);
    }
}
