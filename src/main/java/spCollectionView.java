import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
//import pnlCollectionClient;

public class spCollectionView extends JScrollPane {
    pnlCollectionClient Owner;
    JTree View;
    public spCollectionView(pnlCollectionClient aOwner) {
        super();
        Owner = aOwner;
        Owner.add(this, BorderLayout.CENTER);
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), null));

        View=new JTree();

        View.setDropMode(DropMode.ON_OR_INSERT);
        View.setEnabled(true);
        View.setFocusCycleRoot(true);
        View.setFocusTraversalPolicyProvider(true);
        View.setInvokesStopCellEditing(true);
        View.setLargeModel(true);
        View.setRootVisible(true);
        View.putClientProperty("JTree.lineStyle", "Angled");
        setViewportView(View);
        DefaultTreeModel model = (DefaultTreeModel) View.getModel();
        model.setRoot(null);

    }
}
