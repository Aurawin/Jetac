package com.aurawin.jetac;

import com.aurawin.core.file.SystemDialog;
import com.aurawin.core.lang.Table;
import com.aurawin.core.theme.Theme;
import com.jidesoft.swing.JideSplitButton;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static com.aurawin.core.file.DialogKind.dkNew;
import static com.aurawin.core.file.DialogKind.dkOpen;
import static com.aurawin.core.file.DialogMode.dmFile;

public class View {
    public JPanel Viewer;
    public JPanel pnlMain;
    public JPanel sbStatus;
    public JPanel sbPosition;
    public JLabel lblCollectionIndex;
    public JLabel lblCollectionTotal;
    public JPanel sbCaption;
    public JLabel lblStatus;
    public JTabbedPane tpPages;
    public JPanel pnlTop;
    public JButton btnDisplay;
    public JButton btnSaveAs;
    public JButton btnSave;
    public JLabel lblTitle;
    public JButton btnNew;
    private JButton btnOpen;

    public View() {
        createUIComponents();

    }

    public void setCollectionPositionStatus(int current, int total) {
        lblCollectionIndex.setText(Table.Print(current));
        lblCollectionTotal.setText(Table.Print(total));
    }

    public static void setStatusMessage(String Status) {
        Controller.viewMain.lblStatus.setText(Status);
    }

    private void createUIComponents() {
        btnOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.Dialog.setKind(dkOpen);
                ;
                int ioR = Controller.Dialog.showOpenDialog(tpPages);
                switch (ioR) {
                    case JFileChooser.APPROVE_OPTION:
                        File input = Controller.Dialog.getSelectedFile();
                        if (input.exists()) {
                            collectionTab tab = new collectionTab(tpPages);
                            tab.loadFromFile(input);
                            tpPages.setTitleAt(tpPages.indexOfComponent(tab), tab.Name);
                        }
                        break;
                }
            }
        });
        btnNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                collectionTab tab = new collectionTab(tpPages);
            }
        });
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                collectionTab ct = (tpPages.getSelectedIndex() > -1) ? (collectionTab) tpPages.getComponentAt(tpPages.getSelectedIndex()) : null;
                if (ct!=null) ct.saveToFile();
            }
        });
        btnSaveAs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                collectionTab ct = (tpPages.getSelectedIndex() > -1) ? (collectionTab) tpPages.getComponentAt(tpPages.getSelectedIndex()) : null;
                if (ct!=null) ct.saveToFile();
            }
        });
        tpPages.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                collectionTab tab = (tpPages.getSelectedIndex() > -1) ? (collectionTab) tpPages.getComponentAt(tpPages.getSelectedIndex()) : null;
                if (tab != null) {
                    setCollectionPositionStatus(tab.itemIndex, tab.itemTotal);
                    setStatusMessage(tab.Filename);

                }

            }
        });
    }


    public void setNavExpansion(boolean value){
        Controller.navRevealed = value;
        btnNew.setVisible(Controller.navRevealed);
        btnSave.setVisible(Controller.navRevealed);
        btnSaveAs.setVisible(Controller.navRevealed);

        btnDisplay.setText(Controller.DisplayText[(value)? 0:1]);
        btnDisplay.setText(Controller.DisplayText[(value)? 0:1]);
    }

    public void setButtonCaptions(){
        btnNew.setText(Controller.captionNew);
        btnSave.setText(Controller.captionSave);
        btnSaveAs.setText(Controller.captionSaveAs);
        btnOpen.setText(Controller.captionOpen);
    }
}
