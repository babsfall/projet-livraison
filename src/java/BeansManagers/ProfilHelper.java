/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeansManagers;

import beans.*;
import beans.HibernateUtil;
import beans.Livraison;
import beans.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.model.SelectItem;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Admin
 */
public class ProfilHelper {
    Boolean b = true;
    
     private SessionFactory sessionFactory;
         Session session = null;


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public ProfilHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    
     private List<String> userrr =  new ArrayList<>();
    public List<String> myuser(){
        Connection connection = null;
         try {
             Class.forName("com.mysql.jdbc.Driver");
       
                        String url = "jdbc:mysql://localhost:3306/livraisonbd" ;
                        Connection conn=DriverManager.getConnection(url, "root", "");
                        PreparedStatement ps = null;
                        ps = conn.prepareStatement("select * from profil");
            		ResultSet rs= ps.executeQuery();
                        
                        while(rs.next()){
                           // userrr.add(rs)
                            userrr.add(rs.getString("nomProfil"));
                        }
        
                  } catch (Exception ex) {
            ex.printStackTrace();
                  }
                return userrr;
    }
    private List<SelectItem> proflist;

    public List<SelectItem> getProflist() {
        return proflist;
    }

    public void setProflist(List<SelectItem> proflist) {
        this.proflist = proflist;
    }
    
    public void initdropprof(){
   //     List<Profil> etudiant = null;

       proflist = new ArrayList<>();
       
       proflist.add(new SelectItem(1, "client"));
//        List<Profil> listeprofil = Profil.findAll();
//Session session = sessionFactory.openSession();
//    org.hibernate.Transaction tx = session.beginTransaction();
//        Query q = session.createQuery("from beans.User");
//        
//        etudiant = (List<Profil>) q.list();
//        for(Profil o:etudiant){
//        proflist.add(new SelectItem(o.getIdprofil(),o.getNomProfil()));
//        }


        
    }
    
    public List<Profil> getProfilUser (){
    List<Profil> listetudiant = null;
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = session.beginTransaction();
    String sql ="from beans.Profil";
       // Query q = session.createQuery("from beans.Profil");
        try {
        listetudiant    = session.createQuery(sql).list();
        tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            tx.rollback();
        }
        
    return listetudiant;   
    
    }
    
    
}
