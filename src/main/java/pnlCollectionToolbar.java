package com.aurawin.jetac;

import javax.swing.*;
import java.awt.*;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.aurawin.core.lang.Table;

import com.aurawin.jetac.pnlCollectionClient;
/**
 * Created by Andrew on 9/1/2015.
 */
public class pnlCollectionToolbar extends JPanel {
    pnlCollectionClient Owner;
    JLabel lblInputName;
    JTextField txtInputName;
    JLabel lblInputValue;
    JComboBox cbInputValue;
    JButton btnAdd;
    JButton btnRemove;

    public pnlCollectionToolbar(pnlCollectionClient aOwner){
        super(new BorderLayout());


        Owner=aOwner;


        Owner.add(this, BorderLayout.NORTH);
        setBorder(BorderFactory.createEtchedBorder());


        lblInputName=new JLabel(Table.String(Table.Label.Untitled));
        add(lblInputName);

        txtInputName=new JTextField();
        add(txtInputName);

        lblInputValue=new JLabel(Table.String(Table.Label.Value));
        add(lblInputValue);

        cbInputValue= new JComboBox();
        cbInputValue.addItem(Table.String(Table.JSON.Array));
        cbInputValue.addItem(Table.String(Table.JSON.Object));
        cbInputValue.addItem(Table.String(Table.JSON.KeyPair));
        cbInputValue.setSelectedIndex(2);
        add(cbInputValue);

        JButton btnAdd = new JButton();
        add(btnAdd);

        JButton btnRemove = new JButton();
        add(btnAdd);

        setLayout(new GridLayoutManager(1, 6, new Insets(0, 0, 0, 0), -1, -1));

        setAlignmentY((float) 0.5);
        setAlignmentX((float) 0.5);

        setPreferredSize(new Dimension(489,40));
    }
}
