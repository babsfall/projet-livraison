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
@ManagedBean(name = "reclamationMB")

public class ReclamationMB {
    
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    
    private Integer idreclamationbean;
     private Integer livraisonbean;
     private String detailReclamationbean;
     
               private SessionFactory sessionFactory;

     
Session session = null;

    public Integer getIdreclamationbean() {
        return idreclamationbean;
    }

    public void setIdreclamationbean(Integer idreclamationbean) {
        this.idreclamationbean = idreclamationbean;
    }

    public Integer getLivraisonbean() {
        return livraisonbean;
    }

    public void setLivraisonbean(Integer livraisonbean) {
        this.livraisonbean = livraisonbean;
    }

    public String getDetailReclamationbean() {
        return detailReclamationbean;
    }

    public void setDetailReclamationbean(String detailReclamationbean) {
        this.detailReclamationbean = detailReclamationbean;
    }

   

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }


    public ReclamationMB() {
        
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public ReclamationMB(Integer idreclamationbean, Integer livraisonbean, String detailReclamationbean, SessionFactory sessionFactory) {
        this.idreclamationbean = idreclamationbean;
        this.livraisonbean = livraisonbean;
        this.detailReclamationbean = detailReclamationbean;
        this.sessionFactory = sessionFactory;
    }

  
public ArrayList<Reclamation> getListALLReclamation() {
        ArrayList<Reclamation> List = new ArrayList();
        Reclamation reclamation = null;
        try {
            String url = "jdbc:mysql://localhost:3306/livraisonbd" ;
                        Connection conn=DriverManager.getConnection(url, "root", "");
                        PreparedStatement ps = null;
                        ps = conn.prepareStatement("select * from reclamation");
//                        ps.setString(1, mat);
            		ResultSet rs= ps.executeQuery();

            while (rs.next()) {
                reclamation = new Reclamation();
                reclamation.setIdreclamation(rs.getInt("idreclamation"));
                reclamation.setDetailReclamation(rs.getString("detailReclamation"));
              //  reclamation.setLivraison(rs.getString("prenomUser"));
                
                             
                List.add(reclamation);
            }
            rs.close();
        } catch (SQLException e) {
        }
        return List;
    }
    
   @PostConstruct
public void init(){
 HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
          int tarif = Integer.valueOf(session.getAttribute("idUser").toString());
          System.out.println("||||||||||||"+session.getAttribute("idUser").toString());
}
    
    
    
    public String actionsave(){
        int tarif = 5;
        int tarif2 = 4;
          HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
         // int tarif = Integer.valueOf(session.getAttribute("idUser").toString());
          System.out.println("||||||||||||"+session.getAttribute("idUser").toString());
        ReclamationHelper rh = new ReclamationHelper();
        
            Reclamation et =  new Reclamation();
            et.setLivraison(tarif);
            et.setDetailReclamation(getDetailReclamationbean());
            String msg = rh.insererUser(et);
                       
            return "indexListReclamation";
            
}

    
}

 