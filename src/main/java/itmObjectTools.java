import com.aurawin.core.theme.Theme;
import com.intellij.uiDesigner.core.GridConstraints;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        setMinimumSize(new Dimension(32, 32));
        setPreferredSize(new Dimension(32, 148));
        Owner.add(this, BorderLayout.WEST);

        setBackground(new Color(255, 255, 0));

        btnState = new JButton();
        btnState.setIconTextGap(0);
        setStateIcon(itmState.isExpanded);
        btnState.setPreferredSize(new Dimension(32, 32));
        btnState.setText("");
        add(btnState);

        btnAddArray = new JButton();
        btnAddArray.setIconTextGap(0);
        btnAddArray.setIcon(Theme.Image(Theme.Light.Button.Default.Attribute));
        btnAddArray.setPressedIcon(Theme.Image(Theme.Light.Button.Pressed.Attribute));
        btnAddArray.setRolloverIcon(Theme.Image(Theme.Light.Button.Rollover.Attribute));
        btnAddArray.setRolloverSelectedIcon(Theme.Image(Theme.Light.Button.RolloverSelected.Attribute));
        btnAddArray.setSelectedIcon(Theme.Image(Theme.Light.Button.Selected.Attribute));
        btnAddArray.setPreferredSize(new Dimension(32, 32));
        btnAddArray.setText("");
        add(btnAddArray);

        btnAddObject = new JButton();
        btnAddObject.setIconTextGap(0);
        btnAddObject.setIcon(Theme.Image(Theme.Light.Button.Default.InsertRow));
        btnAddObject.setPressedIcon(Theme.Image(Theme.Light.Button.Pressed.InsertRow));
        btnAddObject.setRolloverIcon(Theme.Image(Theme.Light.Button.Rollover.InsertRow));
        btnAddObject.setRolloverSelectedIcon(Theme.Image(Theme.Light.Button.RolloverSelected.InsertRow));
        btnAddObject.setSelectedIcon(Theme.Image(Theme.Light.Button.Selected.InsertRow));
        btnAddObject.setPreferredSize(new Dimension(32, 32));
        btnAddObject.setText("");
        add(btnAddObject);

        btnAddString = new JButton();
        btnAddString.setIconTextGap(0);
        btnAddString.setIcon(Theme.Image(Theme.Light.Button.Default.List));
        btnAddString.setPressedIcon(Theme.Image(Theme.Light.Button.Pressed.List));
        btnAddString.setRolloverIcon(Theme.Image(Theme.Light.Button.Rollover.List));
        btnAddString.setRolloverSelectedIcon(Theme.Image(Theme.Light.Button.RolloverSelected.List));
        btnAddString.setSelectedIcon(Theme.Image(Theme.Light.Button.Selected.List));
        btnAddString.setPreferredSize(new Dimension(32, 32));
        btnAddString.setText("");
        add(btnAddString);

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
                setStateIcon(state);
                setPreferredSize(new Dimension(32,32));
                setSize(32,32);
                break;
            case isExpanded:
                btnAddArray.setVisible(true);
                btnAddObject.setVisible(true);
                btnAddString.setVisible(true);
                setStateIcon(state);
                setPreferredSize(new Dimension(32,148));
                break;

        }
    }
}
