import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class itmObjectViewClient extends JPanel {
    itmObjectView Owner;
    int maxHeight = 300;
    itmObjectViewClient Self;
    public itmObjectViewClient(itmObjectView owner){
        super(new MigLayout(migLayout.Object.View.Client.getLoConstraints(migLayout.Debug)));
        Owner=owner;
        Self=this;
        Owner.add(this,"newline, push, grow, gap 0 0");
    }

    public void setState(itmState state){
        switch (state) {
            case isCollapsed:
                setVisible(false);
                break;
            case isExpanded:
                setVisible(true);
                break;

        }

    }

}
