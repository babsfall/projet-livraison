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
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Admin
 */
public class ReclamationHelper {
    Boolean b = true;
    
     private SessionFactory sessionFactory;
         Session session = null;


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public ReclamationHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    
    public String insererUser(Reclamation et) {

org.hibernate.Transaction tx = session.beginTransaction();
       // String log = et.getLogin();
       // System.out.println("-----------------" + log);
//        Query query = session.createQuery("from beans.Livraison");
//        List<Livraison> etudiant = query.list();
            session.save(et);
            tx.commit();
                return "evenmt";

    }
    
    
    
}
