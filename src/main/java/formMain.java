package com.aurawin.jetac;

import com.aurawin.core.stream.FileStream;
import com.aurawin.core.theme.Theme;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import com.aurawin.core.lang.Table;

import com.jidesoft.swing.JidePopupMenu;
import com.jidesoft.swing.JideSplitButton;
import org.json.JSONObject;
import org.pushingpixels.substance.api.skin.SubstanceBusinessLookAndFeel;


public class formMain {


    protected JSONObject jsonEdit;
    private static boolean Loading;
    protected static formMain mainForm;

    private JPanel frmMain;
    private JPanel pnlMain;
    private JPanel pnlToolbarButtons;
    private JPanel sbStatus;
    private JPanel pnlToolbar;
    private JToolBar tbCollection;
    protected fileDialog Dialog;
    JLabel lblStatus;


    JTabbedPane tpPages;
    JPanel sbPosition;
    JPanel sbCaption;
    JLabel lblCollectionTitle;
    JLabel lblCollectionName;
    JLabel lblCollectionIndex;
    JLabel lblCollectionTotal;
    JideSplitButton btnFile;

    JMenuItem miFileNew;
    JSeparator spFileSep1;
    JMenuItem miFileOpen;
    JMenuItem miFileClose;
    JSeparator spFileSep2;
    JMenuItem miFileSave;
    JMenuItem miFileSaveAs;

    public formMain() {
        $$$setupUI$$$();
        createUIComponents();
    }


    public void setCollectionPositionStatus(int current, int total) {
        lblCollectionIndex.setText(Table.Print(current));
        lblCollectionTotal.setText(Table.Print(total));
    }

    public static void setStatusMessage(String Status) {
        mainForm.lblStatus.setText(Status);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new SubstanceBusinessLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Loading = true;
        JFrame frame = new JFrame("formMain");
        mainForm = new formMain();
        frame.setContentPane(mainForm.frmMain);
        frame.setPreferredSize(new Dimension(640, 480));
        frame.setTitle("Aurawin Jtac");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


        Loading = false;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        Dialog = new fileDialog(fcKind.fcNew);
        setFileMenuButton();
        miFileNew = btnFile.add(Table.String(Table.Label.New));
        miFileNew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                collectionTab tab = new collectionTab(mainForm.tpPages);
                miFileSave.setEnabled(true);
                miFileSaveAs.setEnabled(true);
                miFileClose.setEnabled(true);
            }
        });
        setFileNewMenuItem(miFileNew);
        spFileSep1 = new JSeparator(SwingConstants.HORIZONTAL);
        btnFile.add(spFileSep1);

        miFileOpen = btnFile.add(Table.String(Table.Label.Open));
        miFileOpen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Dialog.setKind(fcKind.fcOpen);
                int ioR = Dialog.showOpenDialog(mainForm.tpPages);
                switch (ioR) {
                    case JFileChooser.APPROVE_OPTION:
                        File input = mainForm.Dialog.getSelectedFile();
                        if (input.exists()) {
                            collectionTab tab = new collectionTab(mainForm.tpPages);
                            miFileSave.setEnabled(true);
                            miFileSaveAs.setEnabled(true);
                            miFileClose.setEnabled(true);
                            tab.loadFromFile(input);
                            mainForm.tpPages.setTitleAt(mainForm.tpPages.indexOfComponent(tab), tab.Name);
                            lblCollectionName.setText(tab.Name);
                        }
                        break;
                }
            }
        });
        setFileOpenMenuItem(miFileOpen);
        miFileClose = btnFile.add(Table.String(Table.Label.Close));
        miFileClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tpPages.getSelectedIndex() > -1) {
                    collectionTab ct = (collectionTab) tpPages.getComponentAt(tpPages.getSelectedIndex());
                    // todo
                    // This file was modified????
                    ct.Close();
                    // should free
                }

                // release tab
                // should update gui
                /*miFileSave.setEnabled(false);
                miFileSaveAs.setEnabled(false);
                miFileClose.setEnabled(false);*/
            }
        });
        setFileCloseMenuItem(miFileClose);


        spFileSep2 = new JSeparator(SwingConstants.HORIZONTAL);
        btnFile.add(spFileSep2);

        miFileSave = btnFile.add(Table.String(Table.Label.Save));
        miFileSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                collectionTab ct = (tpPages.getSelectedIndex() > -1) ? (collectionTab) tpPages.getComponentAt(tpPages.getSelectedIndex()) : null;
                ct.saveToFile();
            }
        });
        setFileSaveMenuItem(miFileSave);

        miFileSaveAs = btnFile.add(Table.String(Table.Label.SaveAs));
        miFileSaveAs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                collectionTab ct = (tpPages.getSelectedIndex() > -1) ? (collectionTab) tpPages.getComponentAt(tpPages.getSelectedIndex()) : null;
                ct.saveToFile();
            }
        });
        setFileSaveMenuItem(miFileSaveAs);


        tpPages.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                collectionTab tab = (tpPages.getSelectedIndex() > -1) ? (collectionTab) tpPages.getComponentAt(tpPages.getSelectedIndex()) : null;
                if (tab != null) {
                    setCollectionPositionStatus(tab.itemIndex, tab.itemTotal);
                    setStatusMessage(tab.Filename);
                    lblCollectionName.setText(tab.Name);
                } else {
                    setFileMenuOptions(true);
                }

            }
        });
    }

    private void setFileMenuOptions(Boolean Closed) {
        miFileClose.setEnabled(!Closed);
        miFileSave.setEnabled(!Closed);
        miFileSaveAs.setEnabled(!Closed);
        setCollectionPositionStatus(0, 0);
        setStatusMessage("");
        lblCollectionName.setText("");

    }

    private void setFileMenuButton() {
        btnFile.setMaximumSize(new Dimension(40, 24));
        btnFile.setPreferredSize(new Dimension(40, 24));
        btnFile.setText(Table.String(Table.Label.File));
        btnFile.setAlwaysDropdown(true);
    }

    private void setFileNewMenuItem(JMenuItem mi) {
        mi.setToolTipText(Table.Format(Table.Hint.Create, Table.Action.a, Table.JSON.Document));
        mi.setDisabledIcon(Theme.Image(Theme.Light.Button.Disabled.New));
        mi.setIcon(Theme.Image(Theme.Light.Button.Default.New));
        mi.setPressedIcon(Theme.Image(Theme.Light.Button.Pressed.New));
        mi.setRolloverIcon(Theme.Image(Theme.Light.Button.Rollover.New));
        mi.setRolloverSelectedIcon(Theme.Image(Theme.Light.Button.RolloverSelected.New));
        mi.setSelectedIcon(Theme.Image(Theme.Light.Button.Selected.New));
        mi.setEnabled(true);
    }

    private void setFileSaveMenuItem(JMenuItem mi) {
        mi.setDisabledIcon(Theme.Image(Theme.Light.Button.Disabled.Download));
        mi.setIcon(Theme.Image(Theme.Light.Button.Default.Download));
        mi.setPressedIcon(Theme.Image(Theme.Light.Button.Pressed.Download));
        mi.setRolloverIcon(Theme.Image(Theme.Light.Button.Rollover.Download));
        mi.setRolloverSelectedIcon(Theme.Image(Theme.Light.Button.RolloverSelected.Download));
        mi.setSelectedIcon(Theme.Image(Theme.Light.Button.Selected.Download));
        mi.setEnabled(false);
    }

    private void setFileOpenMenuItem(JMenuItem mi) {
        mi.setEnabled(true);
    }

    private void setFileCloseMenuItem(JMenuItem mi) {
        mi.setEnabled(false);
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        frmMain = new JPanel();
        frmMain.setLayout(new CardLayout(0, 0));
        frmMain.setMinimumSize(new Dimension(640, 480));
        frmMain.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), null));
        pnlMain = new JPanel();
        pnlMain.setLayout(new BorderLayout(0, 0));
        frmMain.add(pnlMain, "Collection");
        pnlToolbar = new JPanel();
        pnlToolbar.setLayout(new BorderLayout(0, 0));
        pnlMain.add(pnlToolbar, BorderLayout.NORTH);
        tbCollection = new JToolBar();
        tbCollection.setFloatable(false);
        pnlToolbar.add(tbCollection, BorderLayout.CENTER);
        pnlToolbarButtons = new JPanel();
        pnlToolbarButtons.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 1));
        tbCollection.add(pnlToolbarButtons);
        pnlToolbarButtons.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), null));
        btnFile = new JideSplitButton();
        btnFile.setMaximumSize(new Dimension(50, 22));
        btnFile.setMinimumSize(new Dimension(50, 22));
        btnFile.setPreferredSize(new Dimension(50, 22));
        pnlToolbarButtons.add(btnFile);
        final Spacer spacer1 = new Spacer();
        pnlToolbarButtons.add(spacer1);
        lblCollectionTitle = new JLabel();
        lblCollectionTitle.setHorizontalAlignment(0);
        lblCollectionTitle.setHorizontalTextPosition(0);
        lblCollectionTitle.setText("Collection Editor");
        pnlToolbarButtons.add(lblCollectionTitle);
        final Spacer spacer2 = new Spacer();
        pnlToolbarButtons.add(spacer2);
        final JLabel label1 = new JLabel();
        label1.setHorizontalAlignment(0);
        label1.setHorizontalTextPosition(0);
        label1.setText("-");
        pnlToolbarButtons.add(label1);
        final Spacer spacer3 = new Spacer();
        pnlToolbarButtons.add(spacer3);
        lblCollectionName = new JLabel();
        lblCollectionName.setText("");
        pnlToolbarButtons.add(lblCollectionName);
        sbStatus = new JPanel();
        sbStatus.setLayout(new BorderLayout(0, 0));
        pnlMain.add(sbStatus, BorderLayout.SOUTH);
        sbStatus.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), null));
        sbPosition = new JPanel();
        sbPosition.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1, true, true));
        sbPosition.setMaximumSize(new Dimension(32767, 25));
        sbPosition.setPreferredSize(new Dimension(105, 24));
        sbStatus.add(sbPosition, BorderLayout.WEST);
        sbPosition.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), null));
        lblCollectionIndex = new JLabel();
        lblCollectionIndex.setText("");
        sbPosition.add(lblCollectionIndex, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lblCollectionTotal = new JLabel();
        lblCollectionTotal.setAlignmentX(0.0f);
        lblCollectionTotal.setText("");
        sbPosition.add(lblCollectionTotal, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        sbCaption = new JPanel();
        sbCaption.setLayout(new BorderLayout(0, 0));
        sbStatus.add(sbCaption, BorderLayout.CENTER);
        sbCaption.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, new Color(-4473925)));
        lblStatus = new JLabel();
        lblStatus.setPreferredSize(new Dimension(0, 24));
        lblStatus.setText("");
        sbCaption.add(lblStatus, BorderLayout.CENTER);
        tpPages = new JTabbedPane();
        tpPages.setMinimumSize(new Dimension(2, 20));
        pnlMain.add(tpPages, BorderLayout.CENTER);
        tpPages.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), null));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return frmMain;
    }
}
