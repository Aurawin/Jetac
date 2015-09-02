import javax.swing.*;
import java.awt.*;

public class pnlCollectionClient extends JPanel {

    collectionTab Owner;
    public pnlCollectionClient(collectionTab aOwner){
        super();
        Owner=aOwner;
        Owner.add(this, BorderLayout.CENTER);
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEtchedBorder());
        setAlignmentX((float) 0.5);
        setAlignmentY((float) 0.5);
    }
}
