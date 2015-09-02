
import javax.swing.*;
import java.awt.*;
//import pnlCollectionClient;
//import pnlCollectionToolbar;
//import spCollectionView;
import javafx.scene.control.Tab;
import com.aurawin.core.lang.Table;

public class collectionTab extends JPanel {
    public String Filename;
    public JTabbedPane Owner;
    public pnlCollectionClient Client;
    public pnlCollectionToolbar Toolbar;
    public spCollectionView View;
    public collectionTab(JTabbedPane aOwner) {
        super(new BorderLayout());
        Owner=aOwner;
        Client=new pnlCollectionClient(this);
        ImageIcon ico = null;
        Toolbar = new pnlCollectionToolbar(Client);
        View = new spCollectionView(Client);
        Owner.addTab(Table.String(Table.Label.Untitled), ico, this, Table.Hint.Format(Table.Hint.Unsaved,Table.Item.JSONSource));
    }
}
