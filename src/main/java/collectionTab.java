
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
//import pnlCollectionClient;
//import pnlCollectionToolbar;
//import spCollectionView;
import javafx.scene.control.Tab;
import com.aurawin.core.lang.Table;
import org.json.JSONObject;

public class collectionTab extends JPanel {
    public String Filename;
    public String Name;
    public JTabbedPane Owner;
    public JScrollPane Scroller;
    public itmWrapper Wrapper;
    public itmObject Root;
    public int itemIndex;
    public int itemTotal;


    public void saveToFile(File output){
        JSONObject jo = Root.Export(new JSONObject());
        try {
            FileWriter w = new FileWriter(output);
            jo.write(w);
            w.flush();
            w.close();
        } catch (Exception e){

        }

    }
    public void saveToFile() {
        if (Filename.isEmpty()){
            formMain.mainForm.Dialog.setKind(fcKind.fcSave);
            int ioR=formMain.mainForm.Dialog.showSaveDialog(this);
            switch (ioR){
                case JFileChooser.APPROVE_OPTION:
                    File output = formMain.mainForm.Dialog.getSelectedFile();
                    if (!output.exists()){
                        try {
                            if (!output.getName().toLowerCase().endsWith(".json")) {
                                output = new File(formMain.mainForm.Dialog.getSelectedFile()+".json");
                                output.createNewFile();
                                saveToFile(output);
                            }
                        }catch (Exception e){
                            output = null;
                        }

                    } else {
                        saveToFile(output);
                    }
                    break;
            }

        }
    }

    public collectionTab(JTabbedPane aOwner) {
        super(new BorderLayout());
        Owner=aOwner;
        ImageIcon ico = null;
        Name=Table.String(Table.Label.Untitled);
        Filename="";
        Owner.addTab(Name, ico, this, Table.Format(Table.Hint.Unsaved,Table.JSON.Source));
        Scroller=new JScrollPane();
        add(Scroller, BorderLayout.CENTER);
        Wrapper = new itmWrapper(Scroller);
        Root = new itmObject(Wrapper);

        Owner.setSelectedIndex(Owner.getTabCount()-1);
    }
}
