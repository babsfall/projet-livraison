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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
@ManagedBean(name = "umb")
@RequestScoped

public class UserMB {
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
private SessionFactory sessionFactory;
         Session session = null;
         private Integer idUserbean;
     private String profilbean;
     private String nomUserbean;
     private String prenomUserbean;
     private String loginbean;
     private String passwordbean;
     private Date datenaissbean;
     private int telephonebean;
     private String emailbean;
     private String statutLivreurbean;
     private Set<Vehicule> vehiculesbean = new HashSet<Vehicule>(0);
     private Set<Destinataire> destinatairesbean = new HashSet<Destinataire>(0);
     private Set<Evenement> evenementsbean = new HashSet<Evenement>(0);
     private Set<Livraison> livraisonsForUserIdUserClientbean = new HashSet<Livraison>(0);
     private Set<Livraison> livraisonsForUserIduserLivreurbean = new HashSet<Livraison>(0);
     
     private Profil prof;
         private List<SelectItem> listprofSI;

    public List<SelectItem> getListprofSI() {
        return listprofSI;
    }

    


   
     

    public Integer getIdUserbean() {
        return idUserbean;
    }

    public void setIdUserbean(Integer idUserbean) {
        this.idUserbean = idUserbean;
    }

    public String getProfilbean() {
        return profilbean;
    }

    public void setProfilbean(String profilbean) {
        this.profilbean = profilbean;
    }

    public String getNomUserbean() {
        return nomUserbean;
    }

    public void setNomUserbean(String nomUserbean) {
        this.nomUserbean = nomUserbean;
    }

    public String getPrenomUserbean() {
        return prenomUserbean;
    }

    public void setPrenomUserbean(String prenomUserbean) {
        this.prenomUserbean = prenomUserbean;
    }

    public String getLoginbean() {
        return loginbean;
    }

    public void setLoginbean(String loginbean) {
        this.loginbean = loginbean;
    }

    public String getPasswordbean() {
        return passwordbean;
    }

    public void setPasswordbean(String passwordbean) {
        this.passwordbean = passwordbean;
    }

    public Date getDatenaissbean() {
        return datenaissbean;
    }

    public void setDatenaissbean(Date datenaissbean) {
        this.datenaissbean = datenaissbean;
    }

    public int getTelephonebean() {
        return telephonebean;
    }

    public void setTelephonebean(int telephonebean) {
        this.telephonebean = telephonebean;
    }

    public String getEmailbean() {
        return emailbean;
    }

    public void setEmailbean(String emailbean) {
        this.emailbean = emailbean;
    }

    public String getStatutLivreurbean() {
        return statutLivreurbean;
    }

    public void setStatutLivreurbean(String statutLivreurbean) {
        this.statutLivreurbean = statutLivreurbean;
    }

    public Set<Vehicule> getVehiculesbean() {
        return vehiculesbean;
    }

    public void setVehiculesbean(Set<Vehicule> vehiculesbean) {
        this.vehiculesbean = vehiculesbean;
    }

    public Set<Destinataire> getDestinatairesbean() {
        return destinatairesbean;
    }

    public void setDestinatairesbean(Set<Destinataire> destinatairesbean) {
        this.destinatairesbean = destinatairesbean;
    }

    public Set<Evenement> getEvenementsbean() {
        return evenementsbean;
    }

    public void setEvenementsbean(Set<Evenement> evenementsbean) {
        this.evenementsbean = evenementsbean;
    }

    public Set<Livraison> getLivraisonsForUserIdUserClientbean() {
        return livraisonsForUserIdUserClientbean;
    }

    public void setLivraisonsForUserIdUserClientbean(Set<Livraison> livraisonsForUserIdUserClientbean) {
        this.livraisonsForUserIdUserClientbean = livraisonsForUserIdUserClientbean;
    }

    public Set<Livraison> getLivraisonsForUserIduserLivreurbean() {
        return livraisonsForUserIduserLivreurbean;
    }

    public void setLivraisonsForUserIduserLivreurbean(Set<Livraison> livraisonsForUserIduserLivreurbean) {
        this.livraisonsForUserIduserLivreurbean = livraisonsForUserIduserLivreurbean;
    }

     
         
         


    

    public UserMB() {
prof = new Profil();
    }

    public Profil getProf() {
        return prof;
    }

    public void setProf(Profil prof) {
        this.prof = prof;
    }
    
    
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
                           //userrr.add(rs.getString("idprofil"));
                            userrr.add(rs.getString("nomProfil"));
                        }
        
                  } catch (Exception ex) {
            ex.printStackTrace();
                  }
                return userrr;
    }
    
    
    public String actionsaveUser(){
        UserHelper rh = new UserHelper();
            User et =  new User();
            et.setIdUser(getIdUserbean());
           // int resultat = Integer.parseInt(et.setpr);
                       System.out.println("----------------------------------------");
String a =getProfilbean().toString();
Profil idusss=rh.getBS(a);
            et.setProfil(idusss);
            System.out.println("-------------------"+rh.getBS(getProfilbean().toString()).getIdprofil());
             et.setNomUser(getNomUserbean().toString());
              et.setPrenomUser(getPrenomUserbean().toString());
               et.setLogin(getLoginbean().toString());
                et.setPassword(getPasswordbean().toString());
                et.setDatenaiss(getDatenaissbean());
                         //       et.setPassword(getPasswordbean().toString());
                et.setTelephone(getTelephonebean());
                et.setEmail(getEmailbean().toString());

                
            
           
//            et.setRegistrationnumber(getRegistrationNumber());
            String msg = rh.insererUser(et);
            
            if(msg.equals("error")){
            
                setLoginbean(" User login already exists. Please choose another one");
                setEmailbean("");
                return "User";
            }
            else if(msg.equals("succes")){
            return "Usera";
            }return "Usera";
}
    
     public String actionsaveUserInsc(){
        UserHelper rh = new UserHelper();
            User et =  new User();
           // et.setIdUser(getIdUserbean());
           // int resultat = Integer.parseInt(et.setpr);
                       System.out.println("----------------------------------------");
String a ="Client";
Profil idusss=rh.getBS(a);
            et.setProfil(idusss);
          //  System.out.println("-------------------"+rh.getBS(getProfilbean().toString()).getIdprofil());
             et.setNomUser(getNomUserbean().toString());
              et.setPrenomUser(getPrenomUserbean().toString());
               et.setLogin(getLoginbean().toString());
                et.setPassword(getPasswordbean().toString());
                et.setDatenaiss(getDatenaissbean());
                         //       et.setPassword(getPasswordbean().toString());
                et.setTelephone(getTelephonebean());
                et.setEmail(getEmailbean().toString());

                
            
           
//            et.setRegistrationnumber(getRegistrationNumber());
            String msg = rh.insererUser(et);
            
            if(msg.equals("error")){
            
                setLoginbean(" User login already exists. Please choose another one");
                setEmailbean("");
                return "User";
            }
            else if(msg.equals("succes")){
            return "indexLogin";
            }return "indexLogin";
}
    
    public List<Profil> findallprofil(){
    return session.createQuery("select o from beans.Profil o").list();
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
              //  user.setProfil(rs.get("profil_idProfil"));
                  user.setTelephone(rs.getInt("telephone"));
                
                             
                List.add(user);
            }
            rs.close();
        } catch (SQLException e) {
        }
        return List;
    }
      
    
    public List<SelectItem> getlistprof(){
        System.out.println("teeeeeeeeeesssssssssssttttttttt");
    this.listprofSI = new ArrayList<SelectItem>();
    UserInterface phlp = new profilimplement();
    List<Profil> p = phlp.getProfilUser();
    listprofSI.clear();
    
    for(Profil pro:p){
    SelectItem proselectitem = new SelectItem(pro.getIdprofil(),pro.getNomProfil());
    this.listprofSI.add(proselectitem);
        System.out.println(""+pro.getNomProfil());
    }
        return listprofSI;
        
    }
    
  
    
    
//    private List<SelectItem> proflist;
////private Profil uint = new UserInterface();
//    public List<SelectItem> getProflist() {
//        return proflist;
//    }
//
//    public void setProflist(List<SelectItem> proflist) {
//        this.proflist = proflist;
//    }
  

      
    //}
    
   
    
}

    


 