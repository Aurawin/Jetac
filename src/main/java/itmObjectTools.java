import com.aurawin.core.theme.Theme;
import com.intellij.uiDesigner.core.GridConstraints;

import javax.swing.*;
import java.awt.*;

public class itmObjectTools extends JPanel{
    itmObject Owner;

    JButton btnState;
    JButton btnAddArray;
    JButton btnAddObject;
    JButton btnAddString;

    public itmObjectTools(itmObject owner) {
        super();
        Owner=owner;

        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        setAlignmentX(0.0f);
        setAlignmentY(0.0f);
        Owner.add(this, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_VERTICAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, new Dimension(40, -1), new Dimension(40, 24), new Dimension(40, -1), 0, false));

        btnState = new JButton();
        btnState.setIconTextGap(0);
        btnState.setIcon(Theme.Image(Theme.Light.Button.Default.ArrowheadDown));
        btnState.setPressedIcon(Theme.Image(Theme.Light.Button.Pressed.ArrowheadDown));
        btnState.setRolloverIcon(Theme.Image(Theme.Light.Button.Rollover.ArrowheadDown));
        btnState.setRolloverSelectedIcon(Theme.Image(Theme.Light.Button.RolloverSelected.ArrowheadDown));
        btnState.setSelectedIcon(Theme.Image(Theme.Light.Button.Selected.ArrowheadDown));
        btnState.setPreferredSize(new Dimension(32, 32));
        btnState.setText("");
        add(btnState);

    }
}
