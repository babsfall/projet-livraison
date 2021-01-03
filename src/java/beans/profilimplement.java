/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Admin
 */
public class profilimplement implements UserInterface{

    @Override
    public List<Profil> getProfilUser() {
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
