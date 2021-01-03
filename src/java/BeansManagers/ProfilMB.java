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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Admin
 */
@ManagedBean(name = "profilMB")
@RequestScoped

public class ProfilMB {
    
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    
     private Integer idprofilbean;
     private String nomProfilbean;
               private SessionFactory sessionFactory;

     
Session session = null;

    public Integer getIdprofilbean() {
        return idprofilbean;
    }

    public void setIdprofilbean(Integer idprofilbean) {
        this.idprofilbean = idprofilbean;
    }

    public String getNomProfilbean() {
        return nomProfilbean;
    }

    public void setNomProfilbean(String nomProfilbean) {
        this.nomProfilbean = nomProfilbean;
    }

    

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }


    public ProfilMB() {
        
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public ProfilMB(Integer idprofilbean, String nomProfilbean, SessionFactory sessionFactory) {
        this.idprofilbean = idprofilbean;
        this.nomProfilbean = nomProfilbean;
        this.sessionFactory = sessionFactory;
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
                            //userrr.add(rs.getString())
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
    
     @PostConstruct
    public void initdropprof(){
   //     List<Profil> etudiant = null;

       proflist = new ArrayList<>();
       
       //proflist.add(new SelectItem(1, "cheikh"));
       
//        List<Profil> listeprofil = Profil.findAll();
//Session session = sessionFactory.openSession();
//    org.hibernate.Transaction tx = session.beginTransaction();
//        Query q = session.createQuery("from beans.User");
//        
//        etudiant = (List<Profil>) q.list();

//session.createQuery("select o from beans.Profil o").list();
Session session = sessionFactory.openSession();
List<Profil>pro= session.createQuery("beans.Profil").list();
        for(Profil o:pro){
                        System.out.println("Result -------->"+o.getNomProfil()+" "+o.getIdprofil());

      proflist.add(new SelectItem(o.getIdprofil(),o.getNomProfil()));
            System.out.println("Result -------->"+o.getNomProfil()+" "+o.getIdprofil());
        }


        
    }
    
}

 