/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import BeansManagers.TarificationHelper;
import BeansManagers.UserHelper;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class test {
             Session session = null;
             public test() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
//session = HibernateUtil.getSessionFactory().getCurrentSession();
//    private userMB umb;
        public static void main(String[] args)  {
//            Profil user = new Profil();
//            UserHelper uhlp = new UserHelper();
//            user = (Profil) uhlp.getBS("livreur");
//            System.out.println("resultat profil : "+user.getNomProfil()+" "+user.getIdprofil());
//            TarificationHelper rh = new TarificationHelper();
//            Tarification tr = new Tarification();
//            String a ="parcelles";
//            tr=rh.getTarifByZone(a);
//            System.out.println("resultttttttttttttt " +tr.getIdtarification());
        //  User user = new User();
                //user =  (User) userhlp.getStudent();
             //   System.out.println("" +userhlp.myuser());
               //System.out.println("teeeeeest");
               
               
		Session session = HibernateUtil.getSessionFactory().openSession();
		Tarification s;
                Integer a =1;
                 s = new Tarification(1,"Gibraltar",500);
		session.beginTransaction();
		session.update(s);
		session.getTransaction().commit();
		session.close();
	
                        
            
            
        }
    
    
}
