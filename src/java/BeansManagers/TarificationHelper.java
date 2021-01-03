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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Admin
 */
public class TarificationHelper {
    Boolean b = true;
    
     private SessionFactory sessionFactory;
         Session session = null;
       


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public TarificationHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    
    public String insererTarification(Tarification et) {

org.hibernate.Transaction tx = session.beginTransaction();
       // String log = et.getLogin();
       // System.out.println("-----------------" + log);
//        Query query = session.createQuery("from beans.Livraison");
//        List<Livraison> etudiant = query.list();
            session.save(et);
            tx.commit();
                return "dest";

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
    
    public Tarification getTarifByZone(String mat) {
         Tarification p= null;

			try {
                             String url = "jdbc:mysql://localhost:3306/livraisonbd" ;
                        Connection conn=DriverManager.getConnection(url, "root", "");
                        PreparedStatement ps = null;
                        ps = conn.prepareStatement("select idtarification from tarification where zone= ?");
                        ps.setString(1, mat);
            		ResultSet rs= ps.executeQuery();

				while (rs.next()) {
					
					 p = new Tarification();
					p.setIdtarification(rs.getInt("idtarification"));
					//p.setNomProfil(rs.getString("nomProfil"));
//				
//					
					//maint.add(p);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return p;
		}
    
     public Tarification gettarifbyID(String mat) {
         Tarification p= null;

			try {
                             String url = "jdbc:mysql://localhost:3306/livraisonbd" ;
                        Connection conn=DriverManager.getConnection(url, "root", "");
                        PreparedStatement ps = null;
                        ps = conn.prepareStatement("select * from tarification where idtarification= ?");
                        ps.setString(1, mat);
            		ResultSet rs= ps.executeQuery();

				while (rs.next()) {
					
					 p = new Tarification();
					p.setIdtarification(rs.getInt("idtarification"));
                                        p.setZone(rs.getString("zone"));
                                         p.setPrix(rs.getInt("prix"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return p;
		}

     
     public void UpdateTarification (Tarification tarif){
         Transaction trans=null;
        try{
         trans =  session.beginTransaction();
         session.update(tarif);
         session.getTransaction().commit();
        }catch(RuntimeException e){
        if(trans!=null){
        trans.rollback();
        }
        }
         
        
//        Session session = HibernateUtil.getSessionFactory().openSession();
//		Tarification s;
//                Integer a =1;
//                 s = new Tarification(1,"Gibraltar",500);
//		session.beginTransaction();
//		session.update(s);
//		session.getTransaction().commit();
//		session.close();
        
     }
    
}
