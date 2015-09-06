import com.aurawin.core.lang.Table;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;

public class itmArray extends itmObject{
    public itmArray(itmObject owner) {
        super(owner);
        View.Header.lblName.setText(Table.String(Table.JSON.Array) + " []");
        View.Header.txtName.setVisible(true);
        Kind = itmKind.ikArray;
    }
    public void updateHeader(int Count){
        View.Header.lblName.setText(Table.String(Table.JSON.Array)+" ["+Table.Print(Count)+"]");
    }
    public JSONArray Export(JSONArray ja) {
        for (int iLcv=0; iLcv<View.Client.getComponentCount(); iLcv++){
            Component c=View.Client.getComponent(iLcv);
            if (c instanceof itmSimple){
                itmSimple is = (itmSimple) c;
                try{
                    ja.put(is.txtValue.getText());
                } catch (Exception e){

                }
            } else if (c instanceof itmArray){
                itmArray ia = (itmArray) c;
                JSONArray ja1 = ia.Export(new JSONArray());
                try{
                    ja.put(ja1);
                }catch (Exception e){

                }
            } else if (c instanceof itmObject){
                itmObject io = (itmObject)c;
                JSONObject jo=io.Export(new JSONObject());
                try{
                    ja.put(iLcv,jo);
                }catch (Exception e){

                }
            }
        }
        return ja;
    }

}
