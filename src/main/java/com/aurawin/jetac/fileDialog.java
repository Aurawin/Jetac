package com.aurawin.jetac;

import com.aurawin.core.file.OpenFileFilter;
import com.aurawin.core.lang.Table;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;

public class fileDialog extends JFileChooser {
    private fcKind Kind;
    public File Path = getCurrentDirectory();
    public fcKind getKind(){
        return Kind;
    }
    public void setKind(fcKind kind){
        Kind=kind;
        switch (Kind) {
            case fcNew:
                setDialogTitle(Table.Format(Table.Dialog.New, Table.Action.a, Table.JSON.Document));
                break;
            case fcSave:
                setDialogTitle(Table.Format(Table.Dialog.Save, Table.Action.$this, Table.JSON.Document));
                break;
            case fcOpen:
                setDialogTitle(Table.Format(Table.Dialog.Open, Table.Action.a, Table.JSON.Document));
                break;
        }

    }
    public fileDialog(fcKind kind){
        super();
        setAcceptAllFileFilterUsed(true);
        resetChoosableFileFilters();
        OpenFileFilter ff=new OpenFileFilter(".json", Table.String(Table.JSON.Document)+" (*.json)");
        addChoosableFileFilter(ff);
        setFileFilter(ff);
        setKind(kind);
        if (Path.length()>0) {
            setCurrentDirectory(Path);
        }

    }
}
