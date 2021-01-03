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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Admin
 */
public class VehiculeHelper {
    Boolean b = true;
    
     private SessionFactory sessionFactory;
         Session session = null;


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public VehiculeHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    
    public String insererVehicule(Vehicule et) {

org.hibernate.Transaction tx = session.beginTransaction();
       // String log = et.getLogin();
       // System.out.println("-----------------" + log);
//        Query query = session.createQuery("from beans.Livraison");
//        List<Livraison> etudiant = query.list();
            session.save(et);
            tx.commit();
                return "vehicul";

    }
    
      public TypeVehicule getIdTypeVehBytype(String mat) {
         TypeVehicule p= null;

			try {
                             String url = "jdbc:mysql://localhost:3306/livraisonbd" ;
                        Connection conn=DriverManager.getConnection(url, "root", "");
                        PreparedStatement ps = null;
                        ps = conn.prepareStatement("select idtype_vehicule from type_vehicule where nomvehicule= ?");
                        ps.setString(1, mat);
            		ResultSet rs= ps.executeQuery();

				while (rs.next()) {
					
					 p = new TypeVehicule();
					p.setIdtypeVehicule(rs.getInt("idtype_vehicule"));
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
    
      public TypeVehicule getAllVehicule(String mat) {
         TypeVehicule p= null;

			try {
                             String url = "jdbc:mysql://localhost:3306/livraisonbd" ;
                        Connection conn=DriverManager.getConnection(url, "root", "");
                        PreparedStatement ps = null;
                        ps = conn.prepareStatement("select idtype_vehicule from type_vehicule where nomvehicule= ?");
                        ps.setString(1, mat);
            		ResultSet rs= ps.executeQuery();

				while (rs.next()) {
					
					 p = new TypeVehicule();
					p.setIdtypeVehicule(rs.getInt("idtype_vehicule"));
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
      
      public ArrayList<Vehicule> getListALL() {
        ArrayList<Vehicule> List = new ArrayList();
        Vehicule vehicule = null;
        try {
            String url = "jdbc:mysql://localhost:3306/livraisonbd" ;
                        Connection conn=DriverManager.getConnection(url, "root", "");
                        PreparedStatement ps = null;
                        ps = conn.prepareStatement("select * from vehicule");
//                        ps.setString(1, mat);
            		ResultSet rs= ps.executeQuery();

            while (rs.next()) {
                vehicule = new Vehicule();
                vehicule.setIdvehicule(rs.getInt("idvehicule"));
                vehicule.setMarque(rs.getString("marque"));
                vehicule.setModele(rs.getString("modele"));
                
                             
                List.add(vehicule);
            }
            rs.close();
        } catch (SQLException e) {
        }
        return List;
    }

      public List<Vehicule>vehList(){
      List<Vehicule>veh = null;
      try{
      veh = (List<Vehicule>)sessionFactory.getCurrentSession().createQuery("from beans.Vehicule").list();
      }catch(Exception e){
      e.printStackTrace();
      }
      return veh;
      }
      
      
      
    
  
       public List getVehicule(){
    List<Vehicule> vehicule = null;
    try{
        
    org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("FROM beans.Vehicule");
        vehicule = (List<Vehicule>)q.list();
    }catch(Exception e){
    e.printStackTrace();
    }
    return vehicule;
    }
       
       public List<Vehicule>FindAllVeh(){
           session =HibernateUtil.getSessionFactory().openSession();
           return session.createQuery("from beans.Vehicule").list();
       }
    
    
    
}
