import com.aurawin.core.lang.Table;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.beans.Transient;

public class itmObject extends JPanel {
    itmState State;
    itmWrapper Wrapper;
    itmObject Owner;
    itmObject Self;
    itmObjectTools Tools;
    itmObjectView View;

    Dimension dimMax = new Dimension(0, 148);
    Dimension dimMin = new Dimension(0, 50);

    public void setState(itmState state){
        Tools.setState(state);
        View.setState(state);
        State = state;
        switch (State){
            case isCollapsed:
                break;
            case isExpanded:
                break;
        }
        Wrapper.updateUI();
    }
    public itmObject(itmWrapper wrapper) {
        super(new MigLayout(migLayout.Object.getLoConstraints(migLayout.Debug)));
        Self = this;
        Owner=null;
        Wrapper=wrapper;
        State = itmState.isExpanded;
        setBorder(BorderFactory.createEtchedBorder());
        Wrapper.add(this, "growx, growy");
        Tools = new itmObjectTools(this,false);
        View = new itmObjectView(this);
        View.lblHeader.setVisible(false);
    }
    public itmObject(itmObject owner){
        super(new MigLayout(migLayout.Object.getLoConstraints(migLayout.Debug)));
        Self = this;
        Owner=owner;
        Wrapper=owner.Wrapper;
        State = itmState.isExpanded;
        setBorder(BorderFactory.createEtchedBorder());

        Owner.View.Client.add(this, "growx, growy");
        Tools = new itmObjectTools(this,true);
        View = new itmObjectView(this);
        View.lblHeader.setText(Table.String(Table.JSON.Title) + ":" + Table.String(Table.JSON.Object));
    }
    public void Remove(){
        Owner.View.Client.remove(Self);
        Wrapper.updateUI();
    }
    public void Remove (itmSimple Child){
        View.Client.remove(Child);
        Wrapper.updateUI();
    }
}
