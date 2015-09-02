package com.aurawin.jetac;

import javax.swing.*;
import java.awt.*;
import com.aurawin.jetac.pnlCollectionClient;
import javafx.scene.control.Tab;
import com.aurawin.core.lang.Table;

/**
 * Created by Andrew on 9/1/2015.
 */

public class collectionTab extends JPanel {
    public String Filename;
    public JTabbedPane Owner;
    public pnlCollectionClient Client;

    public collectionTab(JTabbedPane aOwner) {
        super();
        Owner=aOwner;
        Client=new pnlCollectionClient(this);
        ImageIcon ico = null;
        Owner.addTab(Table.String(Table.Label.Untitled), ico, this, "Does nothing at all");


    }
}
