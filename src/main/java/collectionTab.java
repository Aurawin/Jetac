
import javax.swing.*;
import java.awt.*;
//import pnlCollectionClient;
//import pnlCollectionToolbar;
//import spCollectionView;
import javafx.scene.control.Tab;
import com.aurawin.core.lang.Table;
import org.json.JSONObject;

public class collectionTab extends JPanel {
    public String Filename;
    public String Name;
    public JTabbedPane Owner;
    public pnlCollectionClient Client;
    public pnlCollectionToolbar Toolbar;
    public spCollectionView View;
    public int itemIndex;
    public int itemTotal;
    public JSONObject JSON;

    public collectionTab(JTabbedPane aOwner) {
        super(new BorderLayout());
        Owner=aOwner;
        Client=new pnlCollectionClient(this);
        ImageIcon ico = null;
        Toolbar = new pnlCollectionToolbar(Client);
        View = new spCollectionView(Client);
        Name=Table.String(Table.Label.Untitled);
        Owner.addTab(Name, ico, this, Table.Hint.Format(Table.Hint.Unsaved,Table.Item.JSONSource));
        JSON=new JSONObject();
    }
}
