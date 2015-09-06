import com.aurawin.core.lang.Table;
import com.aurawin.core.theme.Theme;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class itmSimple extends JPanel {
    itmObject Owner;
    itmKind Kind;
    JLabel lblName;
    JTextField txtName;
    JLabel lblValue;
    JTextField txtValue;

    JButton btnAdd;
    JButton btnDelete;
    itmSimple Self;


    public itmSimple(itmObject owner) {
        super(new MigLayout(migLayout.Object.Item.Simple.getLoConstraints(migLayout.Debug)));
        Self=this;
        Owner = owner;
        Owner.View.Client.add(this, "grow, gaptop 0");
        Kind = itmKind.ikSimple;

        lblName = new JLabel();
        lblName.setText(Table.String(Table.Label.Name));
        add(lblName,"align label, gap 0 5");

        txtName = new JTextField();
        add(txtName,"align left, grow, height 28, width max(10%,20%)");

        lblValue = new JLabel();
        lblValue.setText(Table.String(Table.Label.Value));
        add(lblValue,"align label, gap 5 5");

        txtValue = new JTextField();
        txtValue.setEditable(true);
        add(txtValue,"align left, height 28, push, grow, width 100:100");

        btnDelete = new JButton();
        btnDelete.setText("");
        btnDelete.setIconTextGap(0);
        btnDelete.setIcon(Theme.Image(Theme.Light.Button.Default.Delete));
        btnDelete.setPressedIcon(Theme.Image(Theme.Light.Button.Pressed.Delete));
        btnDelete.setRolloverIcon(Theme.Image(Theme.Light.Button.Rollover.Delete));
        btnDelete.setRolloverSelectedIcon(Theme.Image(Theme.Light.Button.RolloverSelected.Delete));
        btnDelete.setSelectedIcon(Theme.Image(Theme.Light.Button.Selected.Delete));
        btnDelete.setVerticalAlignment(0);
        btnDelete.setVerticalTextPosition(0);
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Owner.Remove(Self);
            }
        });

        add(btnDelete, "align left, width 30");

        Owner.updateHeader(Owner.View.Client.getComponentCount());

        if (Owner instanceof itmArray){
            lblName.setVisible(false);
            txtName.setVisible(false);
        }
    }
}

