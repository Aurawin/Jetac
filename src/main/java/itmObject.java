package com.aurawin.jetac;

import com.aurawin.core.lang.Table;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import net.miginfocom.swing.MigLayout;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.beans.Transient;
import java.util.Iterator;

public class itmObject extends JPanel {
    itmState State;
    itmKind Kind;
    itmWrapper Wrapper;
    itmObject Owner;
    itmObject Self;
    itmObjectTools Tools;
    itmObjectView View;
    Dimension dimMax = new Dimension(0, 148);
    Dimension dimMin = new Dimension(0, 50);


    public void setState(itmState state) {
        Tools.setState(state);
        View.setState(state);
        State = state;
        switch (State) {
            case isCollapsed:
                break;
            case isExpanded:
                break;
        }
        Wrapper.updateUI();
    }


    public JSONArray Export(JSONArray ja){
        for (int iLcv=0; iLcv<View.Client.getComponentCount(); iLcv++){
            Component c=View.Client.getComponent(iLcv);
            if (c instanceof itmSimple){
                itmSimple is = (itmSimple) c;
                try {
                    ja.put(iLcv, is.txtValue.getText());
                } catch(Exception e){

                }
            } else if (c instanceof itmArray){
                itmArray ia = (itmArray) c;
                ia.Export(ja);
            } else if (c instanceof itmObject){
                itmObject io = (itmObject)c;
                io.Export(ja);
            }
        }
        return ja;
    }
    public void Import(String name, JSONObject jo){
        Iterator it =jo.keys();
        String key="";
        String value="";
        View.Header.txtName.setText(name);
        while (it.hasNext()){
            key = (String) it.next();
            try {
                Object o = jo.get(key);
                if (o instanceof JSONObject) {
                    itmObject itmO = new itmObject(Self);
                    itmO.Import(key, (JSONObject) o);
                } else if (o instanceof JSONArray) {
                    itmArray itmA = new itmArray(Self);
                    itmA.Import(key, (JSONArray) o);
                } else if (o instanceof String) {
                    itmSimple itmS = new itmSimple(Self);
                    itmS.Import(key, (String) o);
                }
            } catch (Exception e){

            }

        }

    }

    public JSONObject Export(JSONObject jo) {
        for (int iLcv=0; iLcv<View.Client.getComponentCount(); iLcv++){
            Component c=View.Client.getComponent(iLcv);
            if (c instanceof itmSimple){
                itmSimple is = (itmSimple) c;
                try {
                    jo.put(is.txtName.getText(), is.txtValue.getText());
                } catch(Exception e){

                }
            } else if (c instanceof itmArray){
                itmArray ia = (itmArray) c;
                JSONArray ja = ia.Export(new JSONArray());
                try {
                    String Key=ia.View.Header.txtName.getText();
                    //jo.append(Key, ja);
                    jo.put(Key, ja);
                } catch (Exception e){

                }
            } else if (c instanceof itmObject){
                itmObject io = (itmObject)c;
                JSONObject jo1 = io.Export( new JSONObject());
                try {
                    jo.put(io.View.Header.txtName.getText(), jo1);
                } catch (Exception e){

                }
            }

        }
        return jo;
    }
    public itmObject(itmWrapper wrapper) {
        super(new MigLayout(migLayout.Object.getLoConstraints(migLayout.Debug)));
        Self = this;
        Owner = null;
        Wrapper = wrapper;
        State = itmState.isExpanded;
        Kind = itmKind.ikObject;
        setBorder(BorderFactory.createEtchedBorder());
        Wrapper.add(this, "aligny top, gaptop 0, gapleft 0, growx, growy");
        Tools = new itmObjectTools(this, false);
        View = new itmObjectView(this);
        View.Header.setVisible(false);
        Tools.btnState.setVisible(false);

    }
    public itmObject(itmObject owner){
        super(new MigLayout(migLayout.Object.getLoConstraints(migLayout.Debug)));
        Self = this;
        Owner=owner;
        Wrapper=owner.Wrapper;
        State = itmState.isExpanded;
        setBorder(BorderFactory.createEtchedBorder());
        Owner.View.Client.add(this, "aligny top, gaptop 0, gapleft 0, growx, growy");
        Tools = new itmObjectTools(this,true);
        View = new itmObjectView(this);
        View.Header.lblName.setText(Table.String(Table.JSON.Object));

        Owner.updateHeader(Owner.View.Client.getComponentCount());

        if (Owner instanceof itmObject) {
            View.Header.lblName.setVisible(true);
            View.Header.txtName.setVisible(true);
        }
    }
    public void Release(){
        Tools.Release();
        View.Release();
        if (Owner==null){
            Wrapper.remove(Self);
        } else {
          Owner.View.Client.remove(Self);
        }
    }
    public void Remove(){
        Self.Release();
        Owner.updateHeader(Owner.View.Client.getComponentCount());
        Wrapper.updateUI();
    }
    public void Remove (itmSimple Child){
        Child.Release();
        updateHeader(View.Client.getComponentCount());
        Wrapper.updateUI();
    }
    public void updateHeader(int Count){
       View.Header.lblName.setText(Table.String(Table.JSON.Object)+" {"+Table.Print(Count)+"}");
    }
}
