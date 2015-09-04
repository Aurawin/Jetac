import com.aurawin.core.lang.Table;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.*;
//import pnlCollectionClient;

public class spCollectionView extends JScrollPane {
    pnlCollectionClient Owner;

    public spCollectionView(pnlCollectionClient aOwner) {
        super();
        Owner = aOwner;
        Owner.add(this, BorderLayout.CENTER);
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), null));
    }
}
