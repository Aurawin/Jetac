package com.aurawin.jetac;

import com.aurawin.core.file.OpenFileFilter;
import com.aurawin.core.file.SystemDialog;
import com.aurawin.core.lang.Table;
import com.aurawin.core.theme.Theme;
import com.jidesoft.swing.JideSplitButton;
import org.json.JSONObject;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static com.aurawin.core.file.DialogKind.dkNew;
import static com.aurawin.core.file.DialogKind.dkOpen;
import static com.aurawin.core.file.DialogMode.dmFile;

public class Controller {
    public static boolean navRevealed;
    public static String [] DisplayText = {"\u2039","\u203A"};
    public static String captionSave = "\u21A7";
    public static String captionSaveAs = "\u21A1";
    public static String captionNew = "\u2747";
    public static String captionOpen = "\u21A5";
    protected JSONObject jsonEdit;
    private static boolean Loading;

    public static View viewMain;
    public static JFrame frameView;

    public static SystemDialog Dialog;

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {

        }
        Loading = true;
        Dialog = new SystemDialog(dkNew,dmFile);
        OpenFileFilter off = new OpenFileFilter("json","JSON Files (*.json)");
        Dialog.addChoosableFileFilter(off );
        Dialog.setFileFilter(off);
        frameView = new JFrame("View");
        viewMain = new View();
        frameView.setContentPane(viewMain.Viewer);

        frameView.setPreferredSize(new Dimension(640, 480));
        frameView.setTitle("Aurawin Jetac");
        frameView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameView.pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frameView.setLocation(dim.width/2-frameView.getSize().width/2, dim.height/2-frameView.getSize().height/2);
        frameView.setVisible(true);


        Loading = false;
    }


}
