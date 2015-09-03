import com.aurawin.core.lang.Table;
import com.aurawin.core.theme.Theme;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;

public class itmSimple extends JPanel {
    JPanel Owner;

    JLabel lblName;
    JTextField txtName;
    JLabel lblValue;
    JTextField txtValue;

    JButton btnAdd;
    JButton btnDelete;



    public itmSimple(JPanel owner) {
        super();
        Owner = owner;
        setBorder(BorderFactory.createEmptyBorder());
        setLayout(new GridLayoutManager(1, 6, new Insets(0, 0, 0, 0), -1, -1));
        Owner.add(this, BorderLayout.NORTH);

        lblName = new JLabel();
        lblName.setText(Table.String(Table.Label.Name));
        add(lblName, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        txtName = new JTextField();
        add(txtName, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(-1, 28), new Dimension(100, 28), null, 0, false));

        lblValue = new JLabel();
        lblValue.setText(Table.String(Table.Label.Value));
        add(lblValue, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        txtValue = new JTextField();
        txtValue.setEditable(true);
        add(txtValue, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(100, 28), null, 0, false));

        btnAdd = new JButton();
        btnAdd.setText("");
        btnAdd.setIconTextGap(0);
        btnAdd.setIcon(Theme.Image(Theme.Light.Button.Default.Add));
        btnAdd.setPressedIcon(Theme.Image(Theme.Light.Button.Pressed.Add));
        btnAdd.setRolloverIcon(Theme.Image(Theme.Light.Button.Rollover.Add));
        btnAdd.setRolloverSelectedIcon(Theme.Image(Theme.Light.Button.RolloverSelected.Add));
        btnAdd.setSelectedIcon(Theme.Image(Theme.Light.Button.Selected.Add));
        btnAdd.setVerticalAlignment(0);
        btnAdd.setVerticalTextPosition(0);
        add(btnAdd, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }
}

