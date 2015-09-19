package com.aurawin.jetac;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
//import pnlCollectionClient;
//import pnlCollectionToolbar;
//import spCollectionView;
import com.aurawin.core.file.Reader;
import com.aurawin.core.stream.FileStream;
import javafx.scene.control.Tab;
import com.aurawin.core.lang.Table;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONString;

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

    public void loadFromFile(File input){
        String js=Reader.toString(input);
        try {
            JSONObject jo = new JSONObject(js);
            Iterator it =jo.keys();
            String key="";
            String value="";
            while (it.hasNext()){
                key = (String) it.next();
                Object o = jo.get(key);
                if (o instanceof JSONObject){
                    itmObject itmO = new itmObject(Root);
                    itmO.Import(key, (JSONObject) o);
                } else if(o instanceof JSONArray){
                    itmArray itmA = new itmArray(Root);
                    itmA.Import(key, (JSONArray) o);
                } else if(o instanceof String){
                    itmSimple itmS = new itmSimple(Root);
                    itmS.Import(key, (String) o);
                }

            }
            Filename=input.getAbsolutePath();
            Name=input.getName();
        } catch (JSONException e){
           formMain.mainForm.lblStatus.setText(e.toString());
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
                            }
                            saveToFile(output);
                        }catch (Exception e){
                            output = null;
                        }

                    } else {
                        saveToFile(output);
                    }
                    break;
            }

        } else {
            saveToFile(Filename);
        }
    }
    public void saveToFile(String fileName){
        File output = new File(fileName);
        saveToFile(output);
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
    public void Close(){
        Release();
    }
    public void Release(){
        Root.Release();
        Scroller.remove(Wrapper);
        remove(Scroller);
        Owner.remove(this);
        Owner.updateUI();
    }
}
