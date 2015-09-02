package com.aurawin.jetac;

import javax.swing.*;
import java.awt.*;
import com.aurawin.jetac.pnlCollectionClient;
import com.aurawin.jetac.pnlCollectionToolbar;
import javafx.scene.control.Tab;
import com.aurawin.core.lang.Table;

/**
 * Created by Andrew on 9/1/2015.
 */

public class collectionTab extends JPanel {
    public String Filename;
    public JTabbedPane Owner;
    public pnlCollectionClient Client;
    public pnlCollectionToolbar Toolbar;
    public collectionTab(JTabbedPane aOwner) {
        super(new BorderLayout());
        Owner=aOwner;
        Client=new pnlCollectionClient(this);
        ImageIcon ico = null;
        Toolbar = new pnlCollectionToolbar(Client);
        Owner.addTab(Table.String(Table.Label.Untitled), ico, this, "Todo");
    }
}
