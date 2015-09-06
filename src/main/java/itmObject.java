import com.aurawin.core.lang.Table;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import net.miginfocom.swing.MigLayout;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.beans.Transient;

public class itmObject extends JPanel {
    itmState State;
    itmKind Kind;
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
        Kind = itmKind.ikObject;
        setBorder(BorderFactory.createEtchedBorder());
        Wrapper.add(this, "growx, growy");
        Tools = new itmObjectTools(this,false);
        View = new itmObjectView(this);
        View.Header.setVisible(false);

    }
    public itmObject(itmObject owner){
        super(new MigLayout(migLayout.Object.getLoConstraints(migLayout.Debug)));
        Self = this;
        Owner=owner;
        Wrapper=owner.Wrapper;
        State = itmState.isExpanded;
        setBorder(BorderFactory.createEtchedBorder());
        Owner.View.Client.add(this, "gaptop 0, gapleft 0, growx, growy");
        Tools = new itmObjectTools(this,true);
        View = new itmObjectView(this);
        View.Header.lblName.setText(Table.String(Table.JSON.Object));

        Owner.updateHeader(Owner.View.Client.getComponentCount());

    }
    public void Remove(){

        Owner.View.Client.remove(Self);
        Owner.updateHeader(Owner.View.Client.getComponentCount());
        Wrapper.updateUI();
    }
    public void Remove (itmSimple Child){
        View.Client.remove(Child);
        updateHeader(View.Client.getComponentCount());
        Wrapper.updateUI();
    }
    public void updateHeader(int Count){
       View.Header.lblName.setText(Table.String(Table.JSON.Object)+" {"+Table.Print(Count)+"}");
    }
}
