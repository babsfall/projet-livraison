/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import beans.HibernateUtil;
import beans.Livraison;
import beans.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Admin
 */
public class LivraisonHelper {
    Boolean b = true;
    
     private SessionFactory sessionFactory;
         Session session = null;


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public LivraisonHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    
    public String insererUser(Livraison et) {

org.hibernate.Transaction tx = session.beginTransaction();
       // String log = et.getLogin();
       // System.out.println("-----------------" + log);
        Query query = session.createQuery("from beans.Livraison");
        List<Livraison> etudiant = query.list();
            session.save(et);
            tx.commit();
                return "lvrais";

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
    
    
    
    
}
