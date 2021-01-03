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
import java.util.Iterator;
import java.util.List;
import javafx.event.ActionEvent;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.primefaces.context.RequestContext;
import org.primefaces.model.LazyDataModel;

/**
 *
 * @author Admin
 */
@ManagedBean(name = "vehiculeMB")
@RequestScoped

public class VehiculeMB {
    
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    
    private Integer idvehiculebean;
     private String typeVehiculebean;
     private Integer userbean;
     private String marquebean;
     private String modelebean;
     private Date dateAchatbean;
     private Date dateRebusbean;

               private SessionFactory sessionFactory;
               private List<Vehicule>listofvehicule;

    public List<Vehicule> getListofvehicule() {
        return listofvehicule;
    }

    public void setListofvehicule(List<Vehicule> listofvehicule) {
        this.listofvehicule = listofvehicule;
    }

     
Session session = null;

    public Integer getIdvehiculebean() {
        return idvehiculebean;
    }

    public void setIdvehiculebean(Integer idvehiculebean) {
        this.idvehiculebean = idvehiculebean;
    }

    public String getTypeVehiculebean() {
        return typeVehiculebean;
    }

    public void setTypeVehiculebean(String typeVehiculebean) {
        this.typeVehiculebean = typeVehiculebean;
    }

    public Integer getUserbean() {
        return userbean;
    }

    public void setUserbean(Integer userbean) {
        this.userbean = userbean;
    }

    public String getMarquebean() {
        return marquebean;
    }

    public void setMarquebean(String marquebean) {
        this.marquebean = marquebean;
    }

    public String getModelebean() {
        return modelebean;
    }

    public void setModelebean(String modelebean) {
        this.modelebean = modelebean;
    }

    public Date getDateAchatbean() {
        return dateAchatbean;
    }

    public void setDateAchatbean(Date dateAchatbean) {
        this.dateAchatbean = dateAchatbean;
    }

    public Date getDateRebusbean() {
        return dateRebusbean;
    }

    public void setDateRebusbean(Date dateRebusbean) {
        this.dateRebusbean = dateRebusbean;
    }

    

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }


    public VehiculeMB() {
        
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public VehiculeMB(Integer idvehiculebean, String typeVehiculebean, Integer userbean, String marquebean, String modelebean, Date dateAchatbean, Date dateRebusbean, SessionFactory sessionFactory) {
        this.idvehiculebean = idvehiculebean;
        this.typeVehiculebean = typeVehiculebean;
        this.userbean = userbean;
        this.marquebean = marquebean;
        this.modelebean = modelebean;
        this.dateAchatbean = dateAchatbean;
        this.dateRebusbean = dateRebusbean;
        this.sessionFactory = sessionFactory;
    }

   

    
    
    
    public String actionsave(){
        int tarif = 1;
        int tarif2 = 4;
        VehiculeHelper rh = new VehiculeHelper();
            Vehicule et =  new Vehicule();
         //   et.setTypeVehicule(1);
         String a =getTypeVehiculebean().toString();
 TypeVehicule idusss=rh.getIdTypeVehBytype(a);
            et.setTypeVehicule(idusss);
            
            et.setUser(1);
            et.setMarque(getMarquebean().toString());
            et.setModele(getModelebean().toString());
            et.setDateAchat(getDateAchatbean());
         //   et.setDateRebus(getDateRebusbean());
            
            String msg = rh.insererVehicule(et);
                       
            return "vehicul";
            
}
    public void actionList(){
//    VehiculeHelper vh =new VehiculeHelper();
//    listofvehicule = vh.FindAllVeh();
            }
    
     public List<Vehicule>FindAllVeh(){
           session =HibernateUtil.getSessionFactory().getCurrentSession();
           listofvehicule = session.createQuery("from beans.Vehicule").list();
           return listofvehicule;
       }
     
     public List<Vehicule> getVehiculeList (){
    List<Vehicule> etudiant = null;
    try{
    Session session = sessionFactory.openSession();
    org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from beans.Vehicule");
        
        etudiant = (List<Vehicule>) q.list();
    }catch(Exception e){
    e.printStackTrace();
    }
    return etudiant;
    }
          List <Vehicule> user = new ArrayList<Vehicule>();

    public List<Vehicule> getUser() {
        return user;
    }

    public void setUser(List<Vehicule> user) {
        this.user = user;
    }

     public List<Vehicule> action(){
    
     VehiculeHelper bhp = new VehiculeHelper();
     
//     String uname = getUserbean();
//     String pass = getPasswordbean();
     boolean b = false;
     user= bhp.getVehicule();
     Vehicule et = new Vehicule();
     for(Iterator it=user.iterator();it.hasNext();){
     et=(Vehicule)it.next();
     user.add(et);
     //et.setModele(getModelebean());
         }
return user;
     }
    private List<String> veh =  new ArrayList<>();
    public List<String> myTypeveh(){
        Connection connection = null;
         try {
             Class.forName("com.mysql.jdbc.Driver");
       
                        String url = "jdbc:mysql://localhost:3306/livraisonbd" ;
                        Connection conn=DriverManager.getConnection(url, "root", "");
                        PreparedStatement ps = null;
                        ps = conn.prepareStatement("select * from type_vehicule");
            		ResultSet rs= ps.executeQuery();
                        
                        while(rs.next()){
                           // userrr.add(rs)
                            veh.add(rs.getString("nomvehicule"));
                        }
        
                  } catch (Exception ex) {
            ex.printStackTrace();
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
                vehicule.setUser(rs.getInt("user_idUser"));
                vehicule.setDateAchat(rs.getDate("dateAchat"));
                vehicule.setDateRebus(rs.getDate("dateRebus"));
              // vehicule.setTypeVehicule(rs.getString("modele"));
                
                             
                List.add(vehicule);
            }
            rs.close();
        } catch (SQLException e) {
        }
        return List;
    }
    
    private List<Vehicule>vehicules =new ArrayList<Vehicule>();

    public List<Vehicule> getVehicules() {
        return vehicules;
    }

    public void setVehicules(List<Vehicule> vehicules) {
        this.vehicules = vehicules;
    }
   @PostConstruct
    public void vehi(){
    VehiculeHelper vehiculeHelper = new VehiculeHelper();
    vehicules= vehiculeHelper.vehList();
    }
    LazyDataModel<Vehicule>vehiculess;
private Vehicule selectedVehicule;
    public void EditAction (ActionEvent event){
        selectedVehicule =(Vehicule)vehiculess.getRowData();
        RequestContext.getCurrentInstance().execute("PF('dgEditVeh'.show();");
    
    }
    
}

 