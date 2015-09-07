import com.aurawin.core.lang.Table;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class itmObjectView extends JPanel{
    public itmObjectViewHeader Header;
    itmObject Owner;
    itmObjectViewClient Client;

    public itmObjectView(itmObject owner) {
        super(new MigLayout(migLayout.Object.View.getLoConstraints(migLayout.Debug)));
        Owner =owner;
        Owner.add(this, "gaptop 0, gapleft 1, growx, growy");
        Header=new itmObjectViewHeader(this);
        Client=new itmObjectViewClient(this);
    }
    public void setState(itmState state){
        Client.setState(state);
        switch (state){
            case isCollapsed:
                break;
            case isExpanded:
                setVisible(true);
                break;
        }
    }
    public void Release(){
        Header.Release();
        Client.Release();
        Owner.View=null;
    }
}
