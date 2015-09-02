package com.aurawin.jetac;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import com.aurawin.core.lang.Table;
import com.aurawin.jetac.collectionTab;

import org.json.JSONObject;
import org.pushingpixels.substance.api.skin.SubstanceBusinessLookAndFeel;


public class formMain {


    protected JSONObject jsonEdit;
    private static boolean Loading;
    private static formMain mainForm;

    private JPanel frmMain;
    private JPanel pnlCollection;
    private JPanel pnlCollectionButtons;
    private JPanel sbCollection;
    private JPanel pnlCollectionClient;
    private JPanel pnlCollectionToolbar;
    private JToolBar tbCollection;
    private JLabel lblCollectionTitle;
    private JLabel lblCollectionName;
    private JButton btnCollectionEditorAdd;
    private JButton btnCollectionEditorDelete;
    JLabel lblCollectionInputName;
    JTextField txtCollectionInputName;
    JLabel lblCollectionInputValue;
    JPanel sbCollectionItemIndex;
    JLabel lblCollectionItemIndex;
    JPanel sbCollectionItemTotal;
    JLabel lblCollectionItemTotal;
    JLabel lblCollectionItemStatus;
    JComboBox cbCollectionInputValue;
    JButton btnCollectionNew;
    JScrollPane spTree;
    JTree tvCollection;
    public JPanel pnlCollectionUntitled;
    JTabbedPane tpPages;

    public formMain() {
        btnCollectionEditorAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //mainForm.lblCollectionEditorItemCount.setText();

            }
        });
        btnCollectionEditorDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //mainForm.lblCollectionEditorItemCount.setText();

            }
        });
        cbCollectionInputValue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adjustCollectionLabels();

//                SwingUtilities.invokeLater(new Runnable() {
//                    @Override
//                    public void run() {
//                    }
//                });

            }
        });
        btnCollectionNew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                collectionTab tab = new collectionTab(mainForm.tpPages);
            }
        });
    }

    public void adjustCollectionLabels() {
        switch (mainForm.cbCollectionInputValue.getSelectedIndex()) {
            case (0):
                cbCollectionInputValue.setEditable(false);
                txtCollectionInputName.setEnabled(true);
                break;
            case (1):
                cbCollectionInputValue.setEditable(false);
                txtCollectionInputName.setEnabled(false);
                break;
            case (2):
                txtCollectionInputName.setEnabled(true);
                cbCollectionInputValue.setEditable(true);
                txtCollectionInputName.setText("");
                Timer tmr = new Timer();
                TimerTask tt = new TimerTask() {
                    public void run() {
                        mainForm.clearCollectionCombo();
                        Loading = false;
                    }
                };
                tmr.schedule(tt, 250);
                break;
        }

    }

    public void clearCollectionCombo() {
        cbCollectionInputValue.getEditor().setItem("");
    }

    public static void setTheme() {
        Icon leafIcon = new ImageIcon(Class.class.getResource("/icons/tree/leafO_16.png"));
        Icon openIcon = new ImageIcon(Class.class.getResource("/icons/tree/nodeO_16.png"));
        Icon closedIcon = new ImageIcon(Class.class.getResource("/icons/tree/nodeC_16.png"));

        UIManager.put("Tree.leafIcon", leafIcon);
        UIManager.put("Tree.openIcon", openIcon);
        UIManager.put("Tree.closedIcon", closedIcon);

    }

    public static void setLanguage() {
        mainForm.cbCollectionInputValue.removeAllItems();
        mainForm.cbCollectionInputValue.addItem(Table.String(Table.JSON.Array));
        mainForm.cbCollectionInputValue.addItem(Table.String(Table.JSON.Object));
        mainForm.cbCollectionInputValue.addItem(Table.String(Table.JSON.KeyPair));
        mainForm.cbCollectionInputValue.setSelectedIndex(2);
        mainForm.lblCollectionInputName.setText(Table.String(Table.Label.Name));
        mainForm.lblCollectionInputValue.setText(Table.String(Table.Label.Value));
        mainForm.btnCollectionNew.setToolTipText(Table.Action.Format(Table.Action.AddNew, Table.Item.JSONObject));
    }

    public static void main(String[] args) {
        //setTheme();
        Table.Load();// default language
        try {
//            UIManager.setLookAndFeel("com.bulenkov.darcula.DarculaLaf");
            UIManager.setLookAndFeel(new SubstanceBusinessLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Loading = true;
        JFrame frame = new JFrame("formMain");
        mainForm = new formMain();
        DefaultTreeModel model = (DefaultTreeModel) mainForm.tvCollection.getModel();
        model.setRoot(null);

        frame.setContentPane(mainForm.frmMain);

        setLanguage();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        //setTheme();
        frame.setVisible(true);

        Loading = false;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
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
        pnlCollection = new JPanel();
        pnlCollection.setLayout(new BorderLayout(0, 0));
        frmMain.add(pnlCollection, "Collection");
        pnlCollectionToolbar = new JPanel();
        pnlCollectionToolbar.setLayout(new BorderLayout(0, 0));
        pnlCollection.add(pnlCollectionToolbar, BorderLayout.NORTH);
        tbCollection = new JToolBar();
        tbCollection.setFloatable(false);
        pnlCollectionToolbar.add(tbCollection, BorderLayout.CENTER);
        pnlCollectionButtons = new JPanel();
        pnlCollectionButtons.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 1));
        tbCollection.add(pnlCollectionButtons);
        pnlCollectionButtons.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), null));
        btnCollectionNew = new JButton();
        btnCollectionNew.setIcon(new ImageIcon(getClass().getResource("/icons/default/new_16.png")));
        btnCollectionNew.setIconTextGap(4);
        btnCollectionNew.setPressedIcon(new ImageIcon(getClass().getResource("/icons/pressed/new_16.png")));
        btnCollectionNew.setRolloverIcon(new ImageIcon(getClass().getResource("/icons/rollover/new_16.png")));
        btnCollectionNew.setRolloverSelectedIcon(new ImageIcon(getClass().getResource("/icons/rollover-pressed/new_16.png")));
        btnCollectionNew.setSelectedIcon(new ImageIcon(getClass().getResource("/icons/pressed/new_16.png")));
        btnCollectionNew.setText("");
        btnCollectionNew.setVerticalAlignment(0);
        btnCollectionNew.setVerticalTextPosition(0);
        pnlCollectionButtons.add(btnCollectionNew);
        final JButton button1 = new JButton();
        button1.setText("");
        pnlCollectionButtons.add(button1);
        final JButton button2 = new JButton();
        button2.setText("Validate");
        pnlCollectionButtons.add(button2);
        final Spacer spacer1 = new Spacer();
        pnlCollectionButtons.add(spacer1);
        lblCollectionTitle = new JLabel();
        lblCollectionTitle.setHorizontalAlignment(0);
        lblCollectionTitle.setHorizontalTextPosition(0);
        lblCollectionTitle.setText("Collection Editor");
        pnlCollectionButtons.add(lblCollectionTitle);
        final Spacer spacer2 = new Spacer();
        pnlCollectionButtons.add(spacer2);
        lblCollectionName = new JLabel();
        lblCollectionName.setText("");
        pnlCollectionButtons.add(lblCollectionName);
        sbCollection = new JPanel();
        sbCollection.setLayout(new BorderLayout(0, 0));
        pnlCollection.add(sbCollection, BorderLayout.SOUTH);
        sbCollection.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), null));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 2));
        sbCollection.add(panel1, BorderLayout.WEST);
        sbCollectionItemIndex = new JPanel();
        sbCollectionItemIndex.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(sbCollectionItemIndex);
        sbCollectionItemIndex.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), null));
        lblCollectionItemIndex = new JLabel();
        lblCollectionItemIndex.setText("Index");
        sbCollectionItemIndex.add(lblCollectionItemIndex, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        sbCollectionItemTotal = new JPanel();
        sbCollectionItemTotal.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(sbCollectionItemTotal);
        sbCollectionItemTotal.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), null));
        lblCollectionItemTotal = new JLabel();
        lblCollectionItemTotal.setText("Total");
        sbCollectionItemTotal.add(lblCollectionItemTotal, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        sbCollection.add(panel2, BorderLayout.CENTER);
        lblCollectionItemStatus = new JLabel();
        lblCollectionItemStatus.setText("");
        panel2.add(lblCollectionItemStatus, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tpPages = new JTabbedPane();
        pnlCollection.add(tpPages, BorderLayout.CENTER);
        pnlCollectionUntitled = new JPanel();
        pnlCollectionUntitled.setLayout(new BorderLayout(0, 0));
        tpPages.addTab("Untitled", pnlCollectionUntitled);
        pnlCollectionClient = new JPanel();
        pnlCollectionClient.setLayout(new BorderLayout(0, 0));
        pnlCollectionUntitled.add(pnlCollectionClient, BorderLayout.CENTER);
        pnlCollectionClient.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), null));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(1, 6, new Insets(0, 0, 0, 0), -1, -1));
        pnlCollectionClient.add(panel3, BorderLayout.NORTH);
        btnCollectionEditorAdd = new JButton();
        btnCollectionEditorAdd.setIcon(new ImageIcon(getClass().getResource("/icons/default/add_16.png")));
        btnCollectionEditorAdd.setIconTextGap(4);
        btnCollectionEditorAdd.setPressedIcon(new ImageIcon(getClass().getResource("/icons/pressed/add_16.png")));
        btnCollectionEditorAdd.setRolloverIcon(new ImageIcon(getClass().getResource("/icons/rollover/add_16.png")));
        btnCollectionEditorAdd.setRolloverSelectedIcon(new ImageIcon(getClass().getResource("/icons/rollover-pressed/add_16.png")));
        btnCollectionEditorAdd.setSelectedIcon(new ImageIcon(getClass().getResource("/icons/pressed/add_16.png")));
        btnCollectionEditorAdd.setText("");
        btnCollectionEditorAdd.setVerticalAlignment(0);
        btnCollectionEditorAdd.setVerticalTextPosition(0);
        panel3.add(btnCollectionEditorAdd, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnCollectionEditorDelete = new JButton();
        btnCollectionEditorDelete.setIcon(new ImageIcon(getClass().getResource("/icons/default/delete_16.png")));
        btnCollectionEditorDelete.setLabel("");
        btnCollectionEditorDelete.setPressedIcon(new ImageIcon(getClass().getResource("/icons/pressed/delete_16.png")));
        btnCollectionEditorDelete.setRolloverEnabled(true);
        btnCollectionEditorDelete.setRolloverIcon(new ImageIcon(getClass().getResource("/icons/rollover/delete_16.png")));
        btnCollectionEditorDelete.setRolloverSelectedIcon(new ImageIcon(getClass().getResource("/icons/rollover-pressed/delete_16.png")));
        btnCollectionEditorDelete.setSelectedIcon(new ImageIcon(getClass().getResource("/icons/pressed/delete_16.png")));
        btnCollectionEditorDelete.setText("");
        panel3.add(btnCollectionEditorDelete, new GridConstraints(0, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lblCollectionInputName = new JLabel();
        lblCollectionInputName.setText("Name");
        panel3.add(lblCollectionInputName, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        txtCollectionInputName = new JTextField();
        panel3.add(txtCollectionInputName, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        lblCollectionInputValue = new JLabel();
        lblCollectionInputValue.setText("Value");
        panel3.add(lblCollectionInputValue, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cbCollectionInputValue = new JComboBox();
        cbCollectionInputValue.setEditable(true);
        panel3.add(cbCollectionInputValue, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new BorderLayout(0, 0));
        pnlCollectionClient.add(panel4, BorderLayout.CENTER);
        spTree = new JScrollPane();
        panel4.add(spTree, BorderLayout.CENTER);
        spTree.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), null));
        tvCollection = new JTree();
        tvCollection.setDropMode(DropMode.ON_OR_INSERT);
        tvCollection.setEnabled(true);
        tvCollection.setFocusCycleRoot(true);
        tvCollection.setFocusTraversalPolicyProvider(true);
        tvCollection.setInvokesStopCellEditing(true);
        tvCollection.setLargeModel(true);
        tvCollection.setRootVisible(true);
        tvCollection.putClientProperty("JTree.lineStyle", "Angled");
        spTree.setViewportView(tvCollection);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return frmMain;
    }
}
