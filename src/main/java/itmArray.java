import com.aurawin.core.lang.Table;

import javax.swing.*;

public class itmArray extends itmObject{
    public itmArray(itmObject owner) {
        super(owner);
        View.lblHeader.setText(Table.String(Table.JSON.Title)+":"+Table.String(Table.JSON.Array)+"[]");
    }
}
