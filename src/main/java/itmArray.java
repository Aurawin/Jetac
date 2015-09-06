import com.aurawin.core.lang.Table;

import javax.swing.*;

public class itmArray extends itmObject{
    JTextField txtName;
    public itmArray(itmObject owner) {
        super(owner);
        View.Header.lblName.setText(Table.String(Table.JSON.Array) + " []");
        View.Header.txtName.setVisible(true);
        Kind = itmKind.ikArray;
    }
    public void updateHeader(int Count){
        View.Header.lblName.setText(Table.String(Table.JSON.Array)+" ["+Table.Print(Count)+"]");
    }
}
