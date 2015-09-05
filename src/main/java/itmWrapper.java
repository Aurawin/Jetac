import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class itmWrapper extends JPanel{
    JScrollPane Owner;

    public itmWrapper(JScrollPane owner){
        super(new MigLayout(migLayout.Wrapper.getLoConstraints(migLayout.Debug)));
        Owner=owner;
        setBorder(BorderFactory.createEtchedBorder());
        Owner.add(this);
        Owner.setViewportView(this);
    }
}
