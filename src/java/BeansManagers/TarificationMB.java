/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeansManagers;

import beans.*;
import beans.HibernateUtil;
import beans.Livraison;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
//import java.util.logging.Logger;
//import javafx.event.ActionEvent;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.primefaces.context.RequestContext;
//import org.primefaces.context.RequestContext;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;

/**
 *
 * @author Admin
 */
@ManagedBean(name = "tarificationMB")
@RequestScoped

public class TarificationMB implements Serializable{
    
    
   private Integer idtarificationbean;
     private String zonebean;
     private int prixbean;
     private Tarification selectedTarification;
     LazyDataModel<Tarification> tarifs;
     private SessionFactory sessionFactory;
     public Logger log  = Logger.getLogger(TarificationMB.class);


    public Tarification getSelectedTarification() {
        return selectedTarification;
    }

    public void setSelectedTarification(Tarification selectedTarification) {
        this.selectedTarification = selectedTarification;
    }

    public LazyDataModel<Tarification> getTarifs() {
        return tarifs;
    }

    public List<String> getTar() {
        return tar;
    }

    public void setTar(List<String> tar) {
        this.tar = tar;
    }
    
    

    public void setTarifs(LazyDataModel<Tarification> tarifs) {
        this.tarifs = tarifs;
    }
    
    

     
Session session = null;

    public TarificationMB(Integer idtarificationbean, String zonebean, int prixbean, SessionFactory sessionFactory) {
        this.idtarificationbean = idtarificationbean;
        this.zonebean = zonebean;
        this.prixbean = prixbean;
        this.sessionFactory = sessionFactory;
    }

    public Integer getIdtarificationbean() {
        return idtarificationbean;
    }

    public void setIdtarificationbean(Integer idtarificationbean) {
        this.idtarificationbean = idtarificationbean;
    }

    public String getZonebean() {
        return zonebean;
    }

    public void setZonebean(String zonebean) {
        this.zonebean = zonebean;
    }

    public int getPrixbean() {
        return prixbean;
    }

    public void setPrixbean(int prixbean) {
        this.prixbean = prixbean;
    }

    
    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }


    public TarificationMB() {
        
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    
    
     public String actionsave(){
        int tarif = 1;
        int tarif2 = 4;
        TarificationHelper rh = new TarificationHelper();
            Tarification et =  new Tarification();
            et.setPrix(getPrixbean());
            et.setZone(getZonebean().toString());
           
            String msg = rh.insererTarification(et);
                       
            return "tarif";
            
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
    
public ArrayList<Tarification> getListALLTarification() {
        ArrayList<Tarification> List = new ArrayList();
        Tarification reclamation = null;
        try {
            String url = "jdbc:mysql://localhost:3306/livraisonbd" ;
                        Connection conn=DriverManager.getConnection(url, "root", "");
                        PreparedStatement ps = null;
                        ps = conn.prepareStatement("select * from tarification");
//                        ps.setString(1, mat);
            		ResultSet rs= ps.executeQuery();

            while (rs.next()) {
                reclamation = new Tarification();
                reclamation.setIdtarification(rs.getInt("idtarification"));
                reclamation.setZone(rs.getString("zone"));
                reclamation.setPrix(rs.getInt("prix"));

                                             List.add(reclamation);

            }
            rs.close();
        } catch (SQLException e) {
        }
        return List;
    }
@PostConstruct
public void init(){
//             HttpServletRequest request=null;
//
//    HttpSession session = request.getSession(true);
//            User u = (User) session.getAttribute("user");
//            System.out.println("++++++++++++>>"+u.getLogin());
 Util ut = new Util();
   HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
      HttpSession session1 = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

		  System.out.println("=========ID USER=========>"+session1.getAttribute("idUser").toString());
                  		  System.out.println("=========LOGIN=========>"+session.getAttribute("login").toString());

//if(session.getAttribute("login").toString()== null){
//return "indexLogin";
//}

    tarifs = new LazyDataModel<Tarification>() {
        
   @Override
   public List<Tarification> load(int first, int pagesize,List<SortMeta>MultiSortMeta,Map<String,Object> filter){
   tarifs.setRowCount(getListALLTarification().size());
   return getListALLTarification();
   }
   
     @Override
   public List<Tarification> load(int first, int pagesize, String sortField,SortOrder sortOrder,Map<String,Object> filter){
   tarifs.setRowCount(getListALLTarification().size());
   return getListALLTarification();
   }
        
};
    showform=false;
    System.out.println("id ::::" +getParams("idtarification"));
    System.out.println("Zone ::::" +getParams("zone"));
    
    if ("edit".equalsIgnoreCase(getParams("zone"))){
    String  id = getParams("idtarification");
    TarificationHelper thlp = new TarificationHelper();
    Tarification tarification = thlp.gettarifbyID(id);
    prixbean = tarification.getPrix();
    idtarificationbean=tarification.getIdtarification();
    zonebean=tarification.getZone().toString();
    
        System.out.println("info 1 :"+idtarificationbean);
                System.out.println("info 1 :"+zonebean);
                        System.out.println("info 1 :"+prixbean);
                        
                          UserLogMB umb = new UserLogMB();
         
                        System.out.println(" veriiiiiiifffffiiiiiiiiiication"+umb.getLoginbean());  
         


    }
//idtarificationbean = Integer.valueOf(getParams("idtarification"));
//    System.out.println("id --------->" +idtarificationbean);

}

//public void EditActionTarif(ActionEvent event){
// 
//    selectedTarification = (Tarification)tarifs.getRowData();
//    System.out.println("ttttttttttttttttttttttttttttt");
//    System.out.println("zone selectionnée : "+selectedTarification.getZone());
//    
//   // RequestContext.getCurrentInstance().execute("PF('dgEditTarif').show();");
//    //PrimeFaces.current().executeScript("window.open('myUrl');");
//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaa");
//
//    
//}

public String getParams (String id){
FacesContext fc = FacesContext.getCurrentInstance();
Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
return params.get(id);
}
private boolean showform;

    public boolean isShowform() {
        return showform;
    }

    public void setShowform(boolean showform) {
        this.showform = showform;
    }

public void showformAction(ActionEvent e){
log.info("true");
showform = true;
}


public void EditTarif(){
    TarificationHelper tar = new TarificationHelper();
    Tarification et =  new Tarification();
    et.setIdtarification(getIdtarificationbean());
            et.setPrix(getPrixbean());
            et.setZone(getZonebean().toString());
   tar.UpdateTarification(et);
    
  
    
//     Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//     int  id =Integer.valueOf(getParams("idtarification"));
//String  zone = getParams("idtarification");
//int  prix = Integer.valueOf(getParams("idtarification"));
//		Tarification s;
//                Integer a =1;
//                 s = new Tarification(id,zone,prix);
//		session.beginTransaction();
//		session.update(s);
//		session.getTransaction().commit();
//		session.close();
//        
//     return "indexAccueil";
    
}
    
}

 