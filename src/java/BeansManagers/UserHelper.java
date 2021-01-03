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
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Admin
 */
public class UserHelper {
   private String login;
    Boolean b = true;
    
     private SessionFactory sessionFactory;
         Session session = null;


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public UserHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

//    public UserDao() {
//        Configuration configuration = new Configuration().configure();
//    }
    
    public List getStudent (){
    List<User> etudiant = null;
    try{
    Session session = sessionFactory.openSession();
    org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from beans.User");
        
        etudiant = (List<User>) q.list();
    }catch(Exception e){
    e.printStackTrace();
    }
    return etudiant;
    }
    
    public List getcourseByName (String prenomUser){
    List<User> courseList = null;
    try{
    Session session = sessionFactory.openSession();
    org.hibernate.Transaction tx = session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class)
                .add(Restrictions.eq("prenomUser", prenomUser));
        courseList = (List<User>) criteria.list();
    }catch(Exception e){
    e.printStackTrace();
    }
    return courseList;
    }
    
    public List<Profil> getProfilById (String profil){
    List<Profil> courseList = null;
    try{
    Session session = sessionFactory.openSession();
    org.hibernate.Transaction tx = session.beginTransaction();
        Criteria criteria = session.createCriteria(Profil.class)
                .add(Restrictions.eq("nomProfil", profil));
        courseList = (List<Profil>) criteria.list();
    }catch(Exception e){
    e.printStackTrace();
    }
    return courseList;
    }
    
    
    private List<String> userrr =  new ArrayList<>();
    public List<String> myuser(){
        Connection connection = null;
         try {
             Class.forName("com.mysql.jdbc.Driver");
       
                        String url = "jdbc:mysql://localhost:3306/livraisonbd" ;
                        Connection conn=DriverManager.getConnection(url, "root", "");
                        PreparedStatement ps = null;
                        ps = conn.prepareStatement("select * from user");
            		ResultSet rs= ps.executeQuery();
                        
                        while(rs.next()){
                            userrr.add(rs.getString("login"));
                        }
        
                  } catch (Exception ex) {
            ex.printStackTrace();
                  }
                return userrr;
    }
    
    public Profil getBS(String mat) {
         Profil p= null;

			try {
                             String url = "jdbc:mysql://localhost:3306/livraisonbd" ;
                        Connection conn=DriverManager.getConnection(url, "root", "");
                        PreparedStatement ps = null;
                        ps = conn.prepareStatement("select idprofil from profil where nomProfil= ?");
                        ps.setString(1, mat);
            		ResultSet rs= ps.executeQuery();

				while (rs.next()) {
					
					 p = new Profil();
					p.setIdprofil(rs.getInt("idprofil"));
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

    String insererUser(User et) {

org.hibernate.Transaction tx = session.beginTransaction();
        String log = et.getLogin();
        System.out.println("-----------------" + log);
        Query query = session.createQuery("from beans.User");
      //  Query query1 = session.createQuery("from beans.profil");
        List<User> etudiant = query.list();
        for (Iterator it = etudiant.iterator(); it.hasNext();) {
            User etu = (User) it.next();
            if (etu.getLogin().equals(log)) {
                b = false;
            }
        }

        if (b = false) {
            return "error";
        } else {
           // try{
//            int rn=0;
//            Query q = session.createQuery("select max(registrationnumber) from Etudiant");
//            List currenrgNum = q.list();
//            rn= (Integer)currenrgNum.get(0)+1;
//                System.out.println("looooooooooooooook"+rn);
//            et.setRegistrationnumber(rn);
//            stc.setRegistrationnumber(rn);
              //  Serializable objId= session.save(et);
                //  session.saveOrUpdate(stc);
           // }catch(Exception e){
//            if(tx != null){
//            tx.rollback();
//            }
//                System.out.println(e.getMessage());
//            }
            session.save(et);
            tx.commit();
            return "succes";
        }
    
    }
    
    public List getpro (){
    List<Profil> etudiant = null;
    try{
    Session session = sessionFactory.openSession();
    org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from beans.Profil");
        
        etudiant = (List<Profil>) q.list();
    }catch(Exception e){
    e.printStackTrace();
    }
    return etudiant;
    }
    
    
    
      public ArrayList<User> getListALLUser() {
        ArrayList<User> List = new ArrayList();
        User user = null;
        try {
            String url = "jdbc:mysql://localhost:3306/livraisonbd" ;
                        Connection conn=DriverManager.getConnection(url, "root", "");
                        PreparedStatement ps = null;
                        ps = conn.prepareStatement("select * from user");
//                        ps.setString(1, mat);
            		ResultSet rs= ps.executeQuery();

            while (rs.next()) {
                user = new User();
                user.setIdUser(rs.getInt("idUser"));
                user.setNomUser(rs.getString("nomUser"));
                user.setPrenomUser(rs.getString("prenomUser"));
                  user.setDatenaiss(rs.getDate("datenaiss"));
                user.setEmail(rs.getString("email"));
                  user.setLogin(rs.getString("login"));
                  user.setPassword(rs.getString("password"));
               // user.setProfil(rs.get("profil_idProfil"));
                  user.setTelephone(rs.getInt("telephone"));
                
                             
                List.add(user);
            }
            rs.close();
        } catch (SQLException e) {
        }
        return List;
    }
      
      
      
}
