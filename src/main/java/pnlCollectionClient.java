package com.aurawin.jetac;

import javax.swing.*;
import java.awt.*;
import com.aurawin.jetac.collectionTab;
/**
 * Created by Andrew on 9/1/2015.
 */
public class pnlCollectionClient extends JPanel {
    collectionTab Owner;
    public pnlCollectionClient(collectionTab aOwner){
        super();
        Owner=aOwner;
        Owner.add(this,BorderLayout.CENTER);
        setBorder(BorderFactory.createEtchedBorder());
    }
}
