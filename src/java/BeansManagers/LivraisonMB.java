/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

////          OOOOOOOOOO    
////                    OOOOOO 
////                            LLLLLLLLL
////                                    LLLLLLL
////                                          DDDDDDD  
////                                                DDDDDDDDDDDD        
package BeansManagers;

import beans.Evenement;
import beans.LivraisonHelper;
import beans.Livraison;
import beans.Livraison;
import beans.Reclamation;
import beans.Tarification;
import beans.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.jboss.logging.Logger;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;

/**
 *
 * @author Admin
 */
@ManagedBean(name = "livraison")
@RequestScoped

public class LivraisonMB {

    private int idlivraisonbean;
    private Tarification tarificationbean;
    private int userByUserIdUserClientbean;
    private int userByUserIduserLivreurbean;
    private Date datelivraisonbean;
    private String adresserecuperationbean;
    private Date dateRecuperationbean;
    private String telephonerrecuperationbean;
    private String nomCompletDestinatairebean;
    private String adresselivraisonbean;
    private String naturecolisbean;
    private String typevehiculebean;
    private String statutlivraisonbean;
    private String paiementbean;
    private String statutpaiementbean;
    
    
    // For List and Update
    
         private Livraison selectedLivraison;
         LazyDataModel<Livraison> tarifs;
         public Logger log  = Logger.getLogger(LivraisonMB.class);

    public Livraison getSelectedLivraison() {
        return selectedLivraison;
    }

    public void setSelectedLivraison(Livraison selectedLivraison) {
        this.selectedLivraison = selectedLivraison;
    }

    public LazyDataModel<Livraison> getTarifs() {
        return tarifs;
    }

    public void setTarifs(LazyDataModel<Livraison> tarifs) {
        this.tarifs = tarifs;
    }
         


    public LivraisonMB() {

    }

    public int getIdlivraisonbean() {
        return idlivraisonbean;
    }

    public void setIdlivraisonbean(int idlivraisonbean) {
        this.idlivraisonbean = idlivraisonbean;
    }

    public Tarification getTarificationbean() {
        return tarificationbean;
    }

    public void setTarificationbean(Tarification tarificationbean) {
        this.tarificationbean = tarificationbean;
    }

    public int getUserByUserIdUserClientbean() {
        return userByUserIdUserClientbean;
    }

    public void setUserByUserIdUserClientbean(int userByUserIdUserClientbean) {
        this.userByUserIdUserClientbean = userByUserIdUserClientbean;
    }

    public int getUserByUserIduserLivreurbean() {
        return userByUserIduserLivreurbean;
    }

    public void setUserByUserIduserLivreurbean(int userByUserIduserLivreurbean) {
        this.userByUserIduserLivreurbean = userByUserIduserLivreurbean;
    }

    public Date getDatelivraisonbean() {
        return datelivraisonbean;
    }

    public void setDatelivraisonbean(Date datelivraisonbean) {
        this.datelivraisonbean = datelivraisonbean;
    }

    public String getAdresserecuperationbean() {
        return adresserecuperationbean;
    }

    public void setAdresserecuperationbean(String adresserecuperationbean) {
        this.adresserecuperationbean = adresserecuperationbean;
    }

    public Date getDateRecuperationbean() {
        return dateRecuperationbean;
    }

    public void setDateRecuperationbean(Date dateRecuperationbean) {
        this.dateRecuperationbean = dateRecuperationbean;
    }

    public String getTelephonerrecuperationbean() {
        return telephonerrecuperationbean;
    }

    public void setTelephonerrecuperationbean(String telephonerrecuperationbean) {
        this.telephonerrecuperationbean = telephonerrecuperationbean;
    }

    public String getNomCompletDestinatairebean() {
        return nomCompletDestinatairebean;
    }

    public void setNomCompletDestinatairebean(String nomCompletDestinatairebean) {
        this.nomCompletDestinatairebean = nomCompletDestinatairebean;
    }

    public String getAdresselivraisonbean() {
        return adresselivraisonbean;
    }

    public void setAdresselivraisonbean(String adresselivraisonbean) {
        this.adresselivraisonbean = adresselivraisonbean;
    }

    public String getNaturecolisbean() {
        return naturecolisbean;
    }

    public void setNaturecolisbean(String naturecolisbean) {
        this.naturecolisbean = naturecolisbean;
    }

    public String getTypevehiculebean() {
        return typevehiculebean;
    }

    public void setTypevehiculebean(String typevehiculebean) {
        this.typevehiculebean = typevehiculebean;
    }

    public String getStatutlivraisonbean() {
        return statutlivraisonbean;
    }

    public void setStatutlivraisonbean(String statutlivraisonbean) {
        this.statutlivraisonbean = statutlivraisonbean;
    }

    public String getPaiementbean() {
        return paiementbean;
    }

    public void setPaiementbean(String paiementbean) {
        this.paiementbean = paiementbean;
    }

    public String getStatutpaiementbean() {
        return statutpaiementbean;
    }

    public void setStatutpaiementbean(String statutpaiementbean) {
        this.statutpaiementbean = statutpaiementbean;
    }
    
    

    public String actionsave() {
        
        LivraisonHelper rh = new LivraisonHelper();
        Livraison et = new Livraison();
        et.setDatelivraison(getDatelivraisonbean());
        et.setDateRecuperation(getDateRecuperationbean());
        et.setAdresserecuperation(getAdresserecuperationbean().toString());
        et.setTelephonerrecuperation(getTelephonerrecuperationbean().toString());
        et.setNomCompletDestinataire(getNomCompletDestinatairebean().toString());
        et.setAdresselivraison(getAdresselivraisonbean().toString());
        et.setNaturecolis(getNaturecolisbean().toString());
        et.setTypevehicule(getTypevehiculebean().toString());
        et.setStatutlivraison("Soumis");
        et.setPaiement(getPaiementbean().toString());
        et.setStatutpaiement("non payé");
        String a = getTarificationbean().toString();
        Tarification idusss = rh.getTarifByZone(a);
        et.setTarification(idusss);
        //   et.setTarification(tarif);
        HttpSession session1 = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		  System.out.println("=========ID USER=========>"+session1.getAttribute("idUser").toString());
                  int tarif = Integer.valueOf(session1.getAttribute("idUser").toString());
                  
        et.setUserByUserIdUserClient(tarif);

        String msg = rh.insererUser(et);
        System.out.println("=========ID USER=========>"+session1.getAttribute("idUser").toString());

        return "lvrais";

    }

    public ArrayList<Livraison> getListALLLivraison() {
        ArrayList<Livraison> List = new ArrayList();
        Livraison et = null;
        try {
            String url = "jdbc:mysql://localhost:3306/livraisonbd";
            Connection conn = DriverManager.getConnection(url, "root", "");
            PreparedStatement ps = null;
            ps = conn.prepareStatement("select * from livraison");
//                        ps.setString(1, mat);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                 et = new Livraison();
                
                et.setIdlivraison(rs.getInt("idlivraison"));
                et.setDatelivraison(rs.getDate("datelivraison"));
                et.setDateRecuperation(rs.getDate("daterecuperation"));
                et.setAdresserecuperation(rs.getString("adresserecuperation"));
                et.setTelephonerrecuperation(rs.getString("telephonerrecuperation"));
                et.setNomCompletDestinataire(rs.getString("nomCompletDestinataire"));
                et.setAdresselivraison(rs.getString("adresselivraison"));
                et.setNaturecolis(rs.getString("naturecolis"));
                et.setTypevehicule(rs.getString("typevehicule"));
                et.setStatutlivraison(rs.getString("statutlivraison"));
                et.setPaiement(rs.getString("paiement"));
                et.setStatutpaiement(rs.getString("statutpaiement"));

                List.add(et);

            }
            rs.close();
        } catch (SQLException e) {
        }
        return List;
    }
    
    
    public ArrayList<Livraison> getListLivraisonUnassigned() {
        ArrayList<Livraison> List = new ArrayList();
        Livraison reclamation = null;
        try {
            String url = "jdbc:mysql://localhost:3306/livraisonbd";
            Connection conn = DriverManager.getConnection(url, "root", "");
            PreparedStatement ps = null;
            ps = conn.prepareStatement("select * from livraison where user_iduser_livreur is Null");
//                        ps.setString(1, mat);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Livraison et = new Livraison();
                
                et.setIdlivraison(rs.getInt("idlivraison"));
                et.setDatelivraison(rs.getDate("datelivraison"));
                et.setDateRecuperation(rs.getDate("daterecuperation"));
                et.setAdresserecuperation(rs.getString("adresserecuperation"));
                et.setTelephonerrecuperation(rs.getString("telephonerrecuperation"));
                et.setNomCompletDestinataire(rs.getString("nomCompletDestinataire"));
                et.setAdresselivraison(rs.getString("adresselivraison"));
                et.setNaturecolis(rs.getString("naturecolis"));
                et.setTypevehicule(rs.getString("typevehicule"));
                et.setStatutlivraison(rs.getString("statutlivraison"));
                et.setPaiement(rs.getString("paiement"));
                et.setStatutpaiement(rs.getString("statutpaiement"));

                List.add(reclamation);

            }
            rs.close();
        } catch (SQLException e) {
        }
        return List;
    }
    
    public String getParams (String id){
FacesContext fc = FacesContext.getCurrentInstance();
Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
return params.get(id);
}
    
    
    public Livraison getlivraisonbyID(String mat) {
         Livraison et= null;

			try {
                             String url = "jdbc:mysql://localhost:3306/livraisonbd" ;
                        Connection conn=DriverManager.getConnection(url, "root", "");
                        PreparedStatement ps = null;
                        ps = conn.prepareStatement("select * from livraison where idlivraison= ?");
                        ps.setString(1, mat);
            		ResultSet rs= ps.executeQuery();

				while (rs.next()) {
					
					 et = new Livraison();
					et.setIdlivraison(rs.getInt("idlivraison"));
                et.setDatelivraison(rs.getDate("datelivraison"));
                et.setDateRecuperation(rs.getDate("daterecuperation"));
                et.setAdresserecuperation(rs.getString("adresserecuperation"));
                et.setTelephonerrecuperation(rs.getString("telephonerrecuperation"));
                et.setNomCompletDestinataire(rs.getString("nomCompletDestinataire"));
                et.setAdresselivraison(rs.getString("adresselivraison"));
                et.setNaturecolis(rs.getString("naturecolis"));
                et.setTypevehicule(rs.getString("typevehicule"));
                et.setStatutlivraison(rs.getString("statutlivraison"));
                et.setPaiement(rs.getString("paiement"));
                et.setStatutpaiement(rs.getString("statutpaiement"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return et;
		}

     
    
    
    @PostConstruct
public void init(){
         HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
      System.out.println("=========LOGIN Livraison=========>"+session.getAttribute("login").toString());
     HttpSession session1 = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		  System.out.println("====++++++ID+++USER++++=====>"+session1.getAttribute("idUser").toString());
    tarifs = new LazyDataModel<Livraison>() {
        
   @Override
   public List<Livraison> load(int first, int pagesize,List<SortMeta>MultiSortMeta,Map<String,Object> filter){
   tarifs.setRowCount(getListALLLivraison().size());
   return getListALLLivraison();
   }
   
     @Override
   public List<Livraison> load(int first, int pagesize, String sortField,SortOrder sortOrder,Map<String,Object> filter){
   tarifs.setRowCount(getListALLLivraison().size());
   return getListALLLivraison();
   }
        
};
    System.out.println("id ::::" +getParams("idtarification"));
    System.out.println("Zone ::::" +getParams("zone"));
    
    if ("edit".equalsIgnoreCase(getParams("zone"))){
    String  id = getParams("idtarification");
    Livraison livraison = getlivraisonbyID(id);
    
    idlivraisonbean=livraison.getIdlivraison();
     userByUserIdUserClientbean=livraison.getUserByUserIdUserClient();
    userByUserIduserLivreurbean=livraison.getUserByUserIduserLivreur();
    datelivraisonbean=livraison.getDatelivraison();
    adresserecuperationbean=livraison.getAdresserecuperation();
    dateRecuperationbean=livraison.getDateRecuperation();
    telephonerrecuperationbean=livraison.getTelephonerrecuperation();
    nomCompletDestinatairebean=livraison.getNomCompletDestinataire();
    adresselivraisonbean=livraison.getAdresselivraison();
    naturecolisbean=livraison.getNaturecolis();
    typevehiculebean=livraison.getTypevehicule();
    statutlivraisonbean=livraison.getStatutlivraison();
    paiementbean=livraison.getPaiement();
    statutpaiementbean=livraison.getStatutpaiement();
    
    
    
        System.out.println("info 1 :"+idlivraisonbean);
                System.out.println("info 1 :"+adresselivraisonbean);
                        System.out.println("info 1 :"+nomCompletDestinatairebean);


    }
//idtarificationbean = Integer.valueOf(getParams("idtarification"));
//    System.out.println("id --------->" +idtarificationbean);

}

}
