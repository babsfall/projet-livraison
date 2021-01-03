/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeansManagers;

import beans.*;
import beans.HibernateUtil;
import beans.Livraison;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Admin
 */
@ManagedBean(name = "evenementMB")
@RequestScoped

public class EvenementMB {
    
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    
    private Integer idevenementbean;
     private Integer userbean;
     private String natureevenementbean;
     private String detailevenementbean;
               private SessionFactory sessionFactory;

     
Session session = null;

    public Integer getIdevenementbean() {
        return idevenementbean;
    }

    public void setIdevenementbean(Integer idevenementbean) {
        this.idevenementbean = idevenementbean;
    }

    public Integer getUserbean() {
        return userbean;
    }

    public void setUserbean(Integer userbean) {
        this.userbean = userbean;
    }

    public String getNatureevenementbean() {
        return natureevenementbean;
    }

    public void setNatureevenementbean(String natureevenementbean) {
        this.natureevenementbean = natureevenementbean;
    }

    public String getDetailevenementbean() {
        return detailevenementbean;
    }

    public void setDetailevenementbean(String detailevenementbean) {
        this.detailevenementbean = detailevenementbean;
    }

    
    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }


    public EvenementMB() {
        
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public EvenementMB(Integer idevenementbean, Integer userbean, String natureevenementbean, String detailevenementbean, SessionFactory sessionFactory) {
        this.idevenementbean = idevenementbean;
        this.userbean = userbean;
        this.natureevenementbean = natureevenementbean;
        this.detailevenementbean = detailevenementbean;
        this.sessionFactory = sessionFactory;
    }
    
    @PostConstruct
public void init(){
     Util ut = new Util();

   HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		  System.out.println("=========ID EVENEMENT=========>"+session.getAttribute("idUser").toString());
                  System.out.println("=========LOGIN EVENEMENT=========>"+session.getAttribute("login").toString());
}

    
    
    
    public String actionsave(){
       
        int tarif2 = 4;
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
          int tarif = Integer.valueOf(session.getAttribute("idUser").toString());
        EvenementHelper rh = new EvenementHelper();
            Evenement et =  new Evenement();
            
            et.setUser(tarif);
            et.setNatureevenement(getNatureevenementbean());
            et.setDetailevenement(getDetailevenementbean().toString());
            String msg = rh.insererUser(et);
                       
            return "indexListEvenement";
            
}
    
    public ArrayList<Evenement> getListALLEvenement() {
        ArrayList<Evenement> List = new ArrayList();
        Evenement reclamation = null;
        try {
            String url = "jdbc:mysql://localhost:3306/livraisonbd" ;
                        Connection conn=DriverManager.getConnection(url, "root", "");
                        PreparedStatement ps = null;
                        ps = conn.prepareStatement("select * from evenement");
//                        ps.setString(1, mat);
            		ResultSet rs= ps.executeQuery();

            while (rs.next()) {
                reclamation = new Evenement();
                reclamation.setIdevenement(rs.getInt("idevenement"));
                reclamation.setDetailevenement(rs.getString("detailevenement"));
                reclamation.setNatureevenement(rs.getString("natureevenement"));
                reclamation.setUser(rs.getInt("user_idUser"));
                             
                List.add(reclamation);
                
            }
            rs.close();
        } catch (SQLException e) {
        }
        return List;
    }
    

    
}

 