import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;

public class itmObject extends JPanel {
    itmState State;
    JPanel Owner;
    itmObjectTools Tools;
    itmObjectView  View;

    public void setState(itmState state){
        Tools.setState(state);
        View.setState(state);
        State = state;
        switch (State){
            case isCollapsed:
                setPreferredSize(new Dimension(getWidth(), 38));
                break;
            case isExpanded:
                setPreferredSize(new Dimension(getWidth(), -1));

                break;
        }
    }
    public itmObject(JPanel owner) {
        super();

        Owner=owner;
        State = itmState.isExpanded;

        setLayout(new BorderLayout(0, 0));
        setAlignmentX(0.0f);
        setPreferredSize(new Dimension(100, 100));

        Owner.setLayout(new GridLayout(Owner.getComponentCount()+1,1));
        Owner.add(this);

        Tools = new itmObjectTools(this);
        View = new itmObjectView(this);
        setBackground(new Color(20,20,120));
    }
}
