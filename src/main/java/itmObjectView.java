import com.aurawin.core.lang.Table;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class itmObjectView extends JPanel{
    JLabel lblHeader;
    itmObject Owner;
    itmObjectViewClient Client;

    public itmObjectView(itmObject owner) {
        super(new MigLayout(migLayout.Object.View.getLoConstraints(migLayout.Debug)));
        Owner =owner;
        Owner.add(this, "growx, growy");

        lblHeader=new JLabel();
        lblHeader.setText(Table.String(Table.Label.Name));
        add(lblHeader, "aligny top, gap 0 5, height 30");

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

}
