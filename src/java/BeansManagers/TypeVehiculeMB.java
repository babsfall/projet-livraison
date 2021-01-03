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
@ManagedBean(name = "typevehiculeMB")

public class TypeVehiculeMB {
    
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    
    private Integer idtypeVehiculebean;
     private String nomvehiculebean;
     
               private SessionFactory sessionFactory;

     
Session session = null;

    public TypeVehiculeMB(Integer idtypeVehiculebean, String nomvehiculebean, SessionFactory sessionFactory) {
        this.idtypeVehiculebean = idtypeVehiculebean;
        this.nomvehiculebean = nomvehiculebean;
        this.sessionFactory = sessionFactory;
    }

    public Integer getIdtypeVehiculebean() {
        return idtypeVehiculebean;
    }

    public void setIdtypeVehiculebean(Integer idtypeVehiculebean) {
        this.idtypeVehiculebean = idtypeVehiculebean;
    }

    public String getNomvehiculebean() {
        return nomvehiculebean;
    }

    public void setNomvehiculebean(String nomvehiculebean) {
        this.nomvehiculebean = nomvehiculebean;
    }


    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }


    public TypeVehiculeMB() {
        
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    
    
    public String actionsave(){
        int tarif = 5;
        int tarif2 = 4;
        TypeVehiculeHelper rh = new TypeVehiculeHelper();
            TypeVehicule et =  new TypeVehicule();
            et.setNomvehicule(getNomvehiculebean());
            String msg = rh.insererTypeVehicule(et);
                       
            return "evenmt";
            
}

    
}

 