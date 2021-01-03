/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeansManagers;

import beans.*;
import beans.HibernateUtil;
import beans.Livraison;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Admin
 */
@ManagedBean(name = "listtarificationMB")
@SessionScoped

public class ListTarificationMB implements Serializable{
   // tarifdatamodel <Tarification> tarifs;
    private Tarification selectedtarification;
    
   private Integer idtarificationbean;
     private String zonebean;
     private int prixbean;
     private SessionFactory sessionFactory;

     
Session session = null;

    public ListTarificationMB(Integer idtarificationbean, String zonebean, int prixbean, SessionFactory sessionFactory) {
        this.idtarificationbean = idtarificationbean;
        this.zonebean = zonebean;
        this.prixbean = prixbean;
        this.sessionFactory = sessionFactory;
    }

    public Integer getIdtarificationbean() {
        return idtarificationbean;
    }

    public void setIdtarificationbean(Integer idtarificationbean) {
        this.idtarificationbean = idtarificationbean;
    }

    public String getZonebean() {
        return zonebean;
    }

    public void setZonebean(String zonebean) {
        this.zonebean = zonebean;
    }

    public int getPrixbean() {
        return prixbean;
    }

    public void setPrixbean(int prixbean) {
        this.prixbean = prixbean;
    }

    
    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }


    public ListTarificationMB() {
        
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    
    
     public String actionsave(){
        int tarif = 1;
        int tarif2 = 4;
        TarificationHelper rh = new TarificationHelper();
            Tarification et =  new Tarification();
            et.setPrix(getPrixbean());
            et.setZone(getZonebean().toString());
           
            String msg = rh.insererTarification(et);
                       
            return "tarif";
            
}
     
      private List<String> tar =  new ArrayList<>();
    public List<String> myTarif(){
        Connection connection = null;
         try {
             Class.forName("com.mysql.jdbc.Driver");
       
                        String url = "jdbc:mysql://localhost:3306/livraisonbd" ;
                        Connection conn=DriverManager.getConnection(url, "root", "");
                        PreparedStatement ps = null;
                        ps = conn.prepareStatement("select * from tarification");
            		ResultSet rs= ps.executeQuery();
                        
                        while(rs.next()){
                           // userrr.add(rs)
                            tar.add(rs.getString("zone"));
                        }
        
                  } catch (Exception ex) {
            ex.printStackTrace();
                  }
                return tar;
    }
    
public ArrayList<Tarification> getListALLTarification() {
        ArrayList<Tarification> List = new ArrayList();
        Tarification reclamation = null;
        try {
            String url = "jdbc:mysql://localhost:3306/livraisonbd" ;
                        Connection conn=DriverManager.getConnection(url, "root", "");
                        PreparedStatement ps = null;
                        ps = conn.prepareStatement("select * from tarification");
//                        ps.setString(1, mat);
            		ResultSet rs= ps.executeQuery();

            while (rs.next()) {
                reclamation = new Tarification();
                reclamation.setIdtarification(rs.getInt("idtarification"));
                reclamation.setZone(rs.getString("zone"));
                reclamation.setPrix(rs.getInt("prix"));

                             
                List.add(reclamation);
            }
            rs.close();
        } catch (SQLException e) {
        }
        return List;
    }
    
    
}

 