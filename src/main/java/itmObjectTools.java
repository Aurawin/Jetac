import com.aurawin.core.lang.Table;
import com.aurawin.core.theme.Theme;
import com.intellij.uiDesigner.core.GridConstraints;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class itmObjectTools extends JPanel{
    protected Boolean showDelete = false;
    Dimension defaultSize;
    itmObject Owner;

    protected JButton btnState;
    protected JButton btnAddArray;
    protected JButton btnAddObject;
    protected JButton btnAddString;
    protected JButton btnDelete;

    public itmObjectTools(itmObject owner, Boolean ShowDelete) {
        super(new MigLayout(migLayout.Object.Toolbar.getLoConstraints(migLayout.Debug)));
        Owner=owner;

        defaultSize=new Dimension(32,32);
        showDelete=ShowDelete;
        Owner.add(this, "aligny top");

        btnState = new JButton();
        btnState.setIconTextGap(0);
        setStateIcon(itmState.isExpanded);
        btnState.setPreferredSize(new Dimension(32, 32));
        btnState.setText("");

        add(btnState, "flowy, newline, height :32:, width :32:");

        btnAddArray = new JButton();
        btnAddArray.setIconTextGap(0);
        btnAddArray.setIcon(Theme.Image(Theme.Light.Button.Default.Attribute));
        btnAddArray.setPressedIcon(Theme.Image(Theme.Light.Button.Pressed.Attribute));
        btnAddArray.setRolloverIcon(Theme.Image(Theme.Light.Button.Rollover.Attribute));
        btnAddArray.setRolloverSelectedIcon(Theme.Image(Theme.Light.Button.RolloverSelected.Attribute));
        btnAddArray.setSelectedIcon(Theme.Image(Theme.Light.Button.Selected.Attribute));
        btnAddArray.setPreferredSize(new Dimension(32, 32));
        btnAddArray.setText("");
        btnAddArray.setToolTipText(Table.Format(Table.Hint.Add, Table.Action.a, Table.JSON.Array));

        add(btnAddArray, "flowy, newline");


        btnAddObject = new JButton();
        btnAddObject.setIconTextGap(0);
        btnAddObject.setIcon(Theme.Image(Theme.Light.Button.Default.InsertRow));
        btnAddObject.setPressedIcon(Theme.Image(Theme.Light.Button.Pressed.InsertRow));
        btnAddObject.setRolloverIcon(Theme.Image(Theme.Light.Button.Rollover.InsertRow));
        btnAddObject.setRolloverSelectedIcon(Theme.Image(Theme.Light.Button.RolloverSelected.InsertRow));
        btnAddObject.setSelectedIcon(Theme.Image(Theme.Light.Button.Selected.InsertRow));
        btnAddObject.setPreferredSize(new Dimension(32, 32));
        btnAddObject.setText("");
        btnAddObject.setToolTipText(Table.Format(Table.Hint.Add, Table.Action.a, Table.JSON.Object));

        add(btnAddObject, "flowy, newline");

        btnAddString = new JButton();
        btnAddString.setIconTextGap(0);
        btnAddString.setIcon(Theme.Image(Theme.Light.Button.Default.List));
        btnAddString.setPressedIcon(Theme.Image(Theme.Light.Button.Pressed.List));
        btnAddString.setRolloverIcon(Theme.Image(Theme.Light.Button.Rollover.List));
        btnAddString.setRolloverSelectedIcon(Theme.Image(Theme.Light.Button.RolloverSelected.List));
        btnAddString.setSelectedIcon(Theme.Image(Theme.Light.Button.Selected.List));
        btnAddString.setPreferredSize(new Dimension(32, 32));
        btnAddString.setText("");
        btnAddString.setToolTipText(Table.Format(Table.Hint.Add, Table.Action.a, Table.JSON.KeyPair));
        add(btnAddString, "flowy, newline");

        btnDelete = new JButton();
        btnDelete.setVisible(ShowDelete);
        btnDelete.setIconTextGap(0);
        btnDelete.setIcon(Theme.Image(Theme.Light.Button.Default.Delete));
        btnDelete.setPressedIcon(Theme.Image(Theme.Light.Button.Pressed.Delete));
        btnDelete.setRolloverIcon(Theme.Image(Theme.Light.Button.Rollover.Delete));
        btnDelete.setRolloverSelectedIcon(Theme.Image(Theme.Light.Button.RolloverSelected.Delete));
        btnDelete.setSelectedIcon(Theme.Image(Theme.Light.Button.Selected.Delete));
        btnDelete.setPreferredSize(new Dimension(32, 32));
        btnDelete.setText("");
        btnDelete.setToolTipText(Table.Format(Table.Hint.Delete, Table.Action.$this, Table.JSON.Object));
        add(btnDelete, "flowy, newline");


        btnState.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch (Owner.State) {
                    case isCollapsed:
                        Owner.setState(itmState.isExpanded);
                        break;
                    case isExpanded:
                        Owner.setState(itmState.isCollapsed);
                        break;
                }
            }
        });
        btnAddString.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                itmSimple itm = new itmSimple(Owner);
                Owner.Wrapper.updateUI();
            }
        });
        btnAddObject.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                itmObject itm = new itmObject(Owner);
                Owner.Wrapper.updateUI();
            }
        });
        btnAddArray.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                itmArray itm = new itmArray(Owner);
                Owner.Wrapper.updateUI();
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Owner.Remove();
            }
        });

    }
    public void setStateIcon(itmState state){
        switch (state) {
            case isCollapsed :
                btnState.setIcon(Theme.Image(Theme.Light.Button.Default.ArrowheadRight));
                btnState.setPressedIcon(Theme.Image(Theme.Light.Button.Pressed.ArrowheadRight));
                btnState.setRolloverIcon(Theme.Image(Theme.Light.Button.Rollover.ArrowheadRight));
                btnState.setRolloverSelectedIcon(Theme.Image(Theme.Light.Button.RolloverSelected.ArrowheadRight));
                btnState.setSelectedIcon(Theme.Image(Theme.Light.Button.Selected.ArrowheadRight));
                break;
            case isExpanded:
                btnState.setIcon(Theme.Image(Theme.Light.Button.Default.ArrowheadDown));
                btnState.setPressedIcon(Theme.Image(Theme.Light.Button.Pressed.ArrowheadDown));
                btnState.setRolloverIcon(Theme.Image(Theme.Light.Button.Rollover.ArrowheadDown));
                btnState.setRolloverSelectedIcon(Theme.Image(Theme.Light.Button.RolloverSelected.ArrowheadDown));
                btnState.setSelectedIcon(Theme.Image(Theme.Light.Button.Selected.ArrowheadDown));
                break;

        }
    }
    public void setState(itmState state){
        switch (state) {
            case isCollapsed :
                btnAddArray.setVisible(false);
                btnAddObject.setVisible(false);
                btnAddString.setVisible(false);
                btnDelete.setVisible(false);
                setStateIcon(state);
                break;
            case isExpanded:
                btnAddArray.setVisible(true);
                btnAddObject.setVisible(true);
                btnAddString.setVisible(true);
                if (showDelete==true) btnDelete.setVisible(true);

                setStateIcon(state);
                break;

        }
    }
}
