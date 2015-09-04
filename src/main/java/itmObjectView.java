import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;

public class itmObjectView extends JPanel{
    itmObject Owner;
    itmObjectViewClient Client;
    public itmObjectView(itmObject owner) {
        super();
        Owner =owner;
        setLayout(new BorderLayout(0, 0));
        setAlignmentX(0.0f);
        setAlignmentY(0.0f);
        Owner.add(this, BorderLayout.CENTER);

        Client=new itmObjectViewClient(this);

        setBackground(new Color(225,125,125));
    }
    public void setState(itmState state){
        Client.setState(state);
        switch (state){
            case isCollapsed:
                setPreferredSize(new Dimension(-1,32));
                break;
            case isExpanded:
                setPreferredSize(new Dimension(Owner.getWidth(),-1));
                break;
        }
    }
}
