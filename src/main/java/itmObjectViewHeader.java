import com.aurawin.core.lang.Table;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class itmObjectViewHeader extends JPanel{
    itmObjectView Owner;

    public JLabel lblName;
    public JTextField txtName;

    public itmObjectViewHeader(itmObjectView owner){
        super(new MigLayout(migLayout.Object.View.Header.getLoConstraints(migLayout.Debug)));
        Owner=owner;
        Owner.add(this, "growx, growy, height 22");

        lblName = new JLabel();
        lblName.setText(Table.String(Table.Label.Name));
        add(lblName, "align label, gap 0 5");

        txtName = new JTextField();
        add(txtName,"align left, grow");
    }

}
