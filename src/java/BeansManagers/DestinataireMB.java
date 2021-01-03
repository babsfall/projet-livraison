/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeansManagers;

import beans.*;
import beans.HibernateUtil;
import beans.Livraison;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Admin
 */
@ManagedBean(name = "destinataireMB")
@RequestScoped

public class DestinataireMB {
    
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    
    private Integer iddestinatairebean;
     private Integer userbean;
     private String nomCompletDestinatairebean;
     private String adresseDestinatairebean;
     private String telephoneDestinatairebean;
               private SessionFactory sessionFactory;

     
Session session = null;

    public Integer getIddestinatairebean() {
        return iddestinatairebean;
    }

    public void setIddestinatairebean(Integer iddestinatairebean) {
        this.iddestinatairebean = iddestinatairebean;
    }

    public Integer getUserbean() {
        return userbean;
    }

    public void setUserbean(Integer userbean) {
        this.userbean = userbean;
    }

    public String getNomCompletDestinatairebean() {
        return nomCompletDestinatairebean;
    }

    public void setNomCompletDestinatairebean(String nomCompletDestinatairebean) {
        this.nomCompletDestinatairebean = nomCompletDestinatairebean;
    }

    public String getAdresseDestinatairebean() {
        return adresseDestinatairebean;
    }

    public void setAdresseDestinatairebean(String adresseDestinatairebean) {
        this.adresseDestinatairebean = adresseDestinatairebean;
    }

    public String getTelephoneDestinatairebean() {
        return telephoneDestinatairebean;
    }

    public void setTelephoneDestinatairebean(String telephoneDestinatairebean) {
        this.telephoneDestinatairebean = telephoneDestinatairebean;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }


    public DestinataireMB() {
        
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public DestinataireMB(Integer iddestinatairebean, Integer userbean, String nomCompletDestinatairebean, String adresseDestinatairebean, String telephoneDestinatairebean) {
        this.iddestinatairebean = iddestinatairebean;
        this.userbean = userbean;
        this.nomCompletDestinatairebean = nomCompletDestinatairebean;
        this.adresseDestinatairebean = adresseDestinatairebean;
        this.telephoneDestinatairebean = telephoneDestinatairebean;
    }

    
    
    
    public String actionsave(){
        int tarif = 1;
        int tarif2 = 4;
        DestinataireHelper rh = new DestinataireHelper();
            Destinataire et =  new Destinataire();
            et.setUser(1);
            et.setNomCompletDestinataire(getNomCompletDestinatairebean());
            et.setAdresseDestinataire(getAdresseDestinatairebean().toString());
            et.setTelephoneDestinataire(getTelephoneDestinatairebean().toString());
            
            String msg = rh.insererUser(et);
                       
            return "dest";
            
}

    
}

 