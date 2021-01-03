/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Admin
 */
//@Named(value = "profilMB1")
@ManagedBean(name = "profilMB1")
@RequestScoped
public class profilMB {

   private Profil prof;
         private List<SelectItem> listprofSI;

    public List<SelectItem> getListprofSI() {
        return listprofSI;
    }

    public void setListprofSI(List<SelectItem> listprofSI) {
        this.listprofSI = listprofSI;
    }
         

    public Profil getProf() {
        return prof;
    }

    public void setProf(Profil prof) {
        this.prof = prof;
    }

    
    public profilMB() {
        prof=new Profil();
    }
    
     public List<SelectItem> getlistprof(){
        System.out.println("teeeeeeeeeesssssssssssttttttttt");
    this.listprofSI = new ArrayList<SelectItem>();
    UserInterface phlp = new profilimplement();
    List<Profil> p = phlp.getProfilUser();
    listprofSI.clear();
    
    for(Profil pro:p){
    SelectItem proselectitem = new SelectItem(pro.getIdprofil(),pro.getNomProfil());
    this.listprofSI.add(proselectitem);
        System.out.println(""+pro.getNomProfil());
    }
        return listprofSI;
        
    }
   
    
}
