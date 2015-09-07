import net.miginfocom.swing.MigLayout;
import javax.swing.*;

import java.awt.*;

public class itmObjectViewClient extends JPanel {
    itmObjectView Owner;
    int maxHeight = 300;
    itmObjectViewClient Self;
    public itmObjectViewClient(itmObjectView owner){
        super(new MigLayout(migLayout.Object.View.Client.getLoConstraints(migLayout.Debug)));
        Owner=owner;
        Self=this;
        Owner.add(this,"gaptop 0, newline, push, grow");
    }

    public void setState(itmState state){
        switch (state) {
            case isCollapsed:
                setVisible(false);
                break;
            case isExpanded:
                setVisible(true);
                break;

        }

    }
    public void Release(){
        for (int iLcv=0; iLcv<getComponentCount(); iLcv++){
            Component c=getComponent(iLcv);
            if (c instanceof itmSimple){
                itmSimple is = (itmSimple) c;
                is.Release();
            } else if (c instanceof itmArray){
                itmArray ia = (itmArray) c;
                ia.Release();
            } else if (c instanceof itmObject){
                itmObject io = (itmObject)c;
                io.Release();
            }

        }
        Owner.remove(this);
        Owner.Client=null;
        Self=null;
    }

}
