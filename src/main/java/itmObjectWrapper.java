import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;

public class itmObjectWrapper extends JPanel {
    JPanel Owner;

    public itmObjectWrapper(JPanel owner){
        super();
        Owner=owner;

        setLayout(new GridBagLayout());
        setAlignmentX(0.0f);
        setAlignmentY(0.0f);
        setAutoscrolls(true);
        setMinimumSize(new Dimension(-1, 124));
        setPreferredSize(new Dimension(-1, 132));
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        Owner.add(this, gbc);
        setBackground(new Color(204, 40, 40));

    }

}
