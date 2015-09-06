
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
    public JScrollPane Scroller;
    public itmWrapper Wrapper;
    public itmObject Root;
    public int itemIndex;
    public int itemTotal;
    public JSONObject JSON;

    public void saveToFile() {
        if (Filename.isEmpty()){

        }
    }

    public collectionTab(JTabbedPane aOwner) {
        super(new BorderLayout());
        Owner=aOwner;
        ImageIcon ico = null;
        Name=Table.String(Table.Label.Untitled);
        Owner.addTab(Name, ico, this, Table.Format(Table.Hint.Unsaved,Table.JSON.Source));
        Scroller=new JScrollPane();
        add(Scroller, BorderLayout.CENTER);
        Wrapper = new itmWrapper(Scroller);
        Root = new itmObject(Wrapper);
        JSON=new JSONObject();

        Owner.setSelectedIndex(Owner.getTabCount()-1);
    }
}
