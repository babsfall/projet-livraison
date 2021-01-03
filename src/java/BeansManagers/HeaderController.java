/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeansManagers;

import beans.Util;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@Named(value = "headerController")
@Dependent
public class HeaderController {

    /**
     * Creates a new instance of HeaderController
     */
    public HeaderController() {
        
        
    }
    
    private boolean showDo=true;
    private boolean showUndo=true;

    public boolean isShowDo() {
        return showDo;
    }

    public void setShowDo(boolean showDo) {
        this.showDo = showDo;
    }

    public boolean isShowUndo() {
        return showUndo;
    }

    public void setShowUndo(boolean showUndo) {
        this.showUndo = showUndo;
    }
private boolean isDisabled = false;
    public void doAction(){

    isDisabled =  false;

    }

    public void undoAction(){
      showDo=false;
    }
     public String logout() {
         
      HttpSession session = Util.getSession();
      session.invalidate();
      return "indexLogin";
   }
    
}
