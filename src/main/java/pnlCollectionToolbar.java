import javax.swing.*;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.aurawin.core.lang.Table;
import com.aurawin.core.theme.Theme;

//import pnlCollectionClient;

public class pnlCollectionToolbar extends JPanel {
    public pnlCollectionClient Owner;
    public JLabel lblInputName;
    public JTextField txtInputName;
    public JLabel lblInputValue;
    public JComboBox cbInputValue;
    public JButton btnAdd;
    public JButton btnRemove;

    public void adjustCollectionLabels() {

        switch (cbInputValue.getSelectedIndex()) {
            case (0):
                cbInputValue.setEditable(false);
                txtInputName.setEnabled(true);
                break;
            case (1):
                cbInputValue.setEditable(false);
                txtInputName.setEnabled(false);
                break;
            case (2):
                txtInputName.setEnabled(true);
                cbInputValue.setEditable(true);
                txtInputName.setText("");
                java.util.Timer tmr = new java.util.Timer();
                TimerTask tt = new TimerTask() {
                    public void run() {
                        clearCollectionCombo();
                    }
                };
                tmr.schedule(tt, 250);
                break;
        }

    }

    public void clearCollectionCombo() {
        cbInputValue.getEditor().setItem("");
    }
    public pnlCollectionToolbar(pnlCollectionClient aOwner){
        super();
        Owner=aOwner;

        setLayout(new GridLayoutManager(1, 6, new Insets(0, 0, 0, 0), -1, -1));
        Owner.add(this, BorderLayout.NORTH);
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), null));
        setAlignmentY((float) 0.5);
        setAlignmentX((float) 0.5);


        lblInputName=new JLabel(Table.String(Table.Label.Name));
        lblInputName.setBorder(new EmptyBorder(0, 5, 0, 5));
        add(lblInputName, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        txtInputName=new JTextField();
        txtInputName.setToolTipText(Table.Hint.Format(Table.Hint.Input, Table.Label.Name));
        txtInputName.setPreferredSize(new Dimension(-1, 20));
        txtInputName.setBorder(BorderFactory.createCompoundBorder(txtInputName.getBorder(), BorderFactory.createEmptyBorder(2, 4, 2, 4)));
        add(txtInputName, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));

        lblInputValue=new JLabel(Table.String(Table.Label.Value));
        add(lblInputValue, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));


        cbInputValue = new JComboBox();
        cbInputValue.addItem(Table.String(Table.JSON.Array));
        cbInputValue.addItem(Table.String(Table.JSON.Object));
        cbInputValue.addItem(Table.String(Table.JSON.KeyPair));
        cbInputValue.setSelectedIndex(2);
        cbInputValue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adjustCollectionLabels();
            }
        });
        add(cbInputValue, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        btnAdd = new JButton();
        btnAdd.setIcon(Theme.Image(Theme.Light.Button.Default.Add));
        btnAdd.setPressedIcon(Theme.Image(Theme.Light.Button.Pressed.Add));
        btnAdd.setRolloverIcon(Theme.Image(Theme.Light.Button.Rollover.Add));
        btnAdd.setRolloverSelectedIcon(Theme.Image(Theme.Light.Button.RolloverSelected.Add));
        btnAdd.setSelectedIcon(Theme.Image(Theme.Light.Button.Selected.Add));
        btnAdd.setToolTipText(Table.Hint.Format(Table.Hint.Add, Table.Action.a, Table.Label.Item));
        add(btnAdd, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch (Owner.Owner.Toolbar.cbInputValue.getSelectedIndex()){
                    case 0:
                        break;
                    case 1:
                        break;
                    default :
                        break;
                }
            }
        });


        btnRemove = new JButton();
        btnRemove.setIcon(Theme.Image(Theme.Light.Button.Default.Delete));
        btnRemove.setPressedIcon(Theme.Image(Theme.Light.Button.Pressed.Delete));
        btnRemove.setRolloverIcon(Theme.Image(Theme.Light.Button.Rollover.Delete));
        btnRemove.setRolloverSelectedIcon(Theme.Image(Theme.Light.Button.RolloverSelected.Delete));
        btnRemove.setSelectedIcon(Theme.Image(Theme.Light.Button.Selected.Delete));
        btnRemove.setToolTipText(Table.Hint.Format(Table.Hint.Delete, Table.Action.an, Table.Label.Item));
        add(btnRemove, new GridConstraints(0, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }
}
