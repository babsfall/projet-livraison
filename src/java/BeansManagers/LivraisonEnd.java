/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeansManagers;

import beans.*;
import BeansManagers.LivraisonMB;
import BeansManagers.TarificationHelper;
import beans.HibernateUtil;
import beans.Livraison;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.jboss.logging.Logger;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;

/**
 *
 * @author Admin
 */
@ManagedBean(name = "livraisonEndMB")
@RequestScoped

public class LivraisonEnd {

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */
    private int idlivraisonbean;
    private String tarificationbean;
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
    private SessionFactory sessionFactory;

    Session session = null;
    private Livraison selectedLivraison;
    LazyDataModel<Livraison> tarifs;
    public Logger log = Logger.getLogger(LivraisonMB.class);

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

    public LivraisonEnd() {

        this.session = HibernateUtil.getSessionFactory().getCurrentSession();

    }

    public List<String> getTarI() {
        return tarI;
    }

    public void setTarI(List<String> tarI) {
        this.tarI = tarI;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public LivraisonEnd(int idlivraisonbean, String tarificationbean, int userByUserIdUserClientbean, int userByUserIduserLivreurbean, Date datelivraisonbean, String adresserecuperationbean, Date dateRecuperationbean, String telephonerrecuperationbean, String nomCompletDestinatairebean, String adresselivraisonbean, String naturecolisbean, String typevehiculebean, String statutlivraisonbean, String paiementbean, String statutpaiementbean) {
        this.idlivraisonbean = idlivraisonbean;
        this.tarificationbean = tarificationbean;
        this.userByUserIdUserClientbean = userByUserIdUserClientbean;
        this.userByUserIduserLivreurbean = userByUserIduserLivreurbean;
        this.datelivraisonbean = datelivraisonbean;
        this.adresserecuperationbean = adresserecuperationbean;
        this.dateRecuperationbean = dateRecuperationbean;
        this.telephonerrecuperationbean = telephonerrecuperationbean;
        this.nomCompletDestinatairebean = nomCompletDestinatairebean;
        this.adresselivraisonbean = adresselivraisonbean;
        this.naturecolisbean = naturecolisbean;
        this.typevehiculebean = typevehiculebean;
        this.statutlivraisonbean = statutlivraisonbean;
        this.paiementbean = paiementbean;
        this.statutpaiementbean = statutpaiementbean;
    }

    public int getIdlivraisonbean() {
        return idlivraisonbean;
    }

    public void setIdlivraisonbean(int idlivraisonbean) {
        this.idlivraisonbean = idlivraisonbean;
    }

    public String getTarificationbean() {
        return tarificationbean;
    }

    public void setTarificationbean(String tarificationbean) {
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

    private List<String> tarI = new ArrayList<>();

    public List<String> myfREELIV() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/livraisonbd";
            Connection conn = DriverManager.getConnection(url, "root", "");
            PreparedStatement ps = null;
            ps = conn.prepareStatement("select * from user where statutLivreur = 'non occupé'");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // userrr.add(rs)
                tarI.add(rs.getString("prenomUser"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return tarI;
    }

    public String actionsave() {
        int tarif = 1;
        int tarif2 = 4;
        LivraisonHelper rh = new LivraisonHelper();
        TarificationHelper th = new TarificationHelper();
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
        Tarification idusss = th.getTarifByZone(a);
        et.setTarification(idusss);
        et.setUserByUserIdUserClient(tarif);
        String val = null;
        // et.setUserByUserIduserLivreur(4);

        String msg = rh.insererUser(et);

        return "livrais";

    }

    public ArrayList<Livraison> getListALLLivraison() {
        ArrayList<Livraison> List = new ArrayList();
        Livraison et = null;
        try {
            String url = "jdbc:mysql://localhost:3306/livraisonbd";
            Connection conn = DriverManager.getConnection(url, "root", "");
            PreparedStatement ps = null;
            ps = conn.prepareStatement("select * from livraison where statutlivraison ='en cours'");
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
                et.setUserByUserIdUserClient(rs.getInt("user_idUser_client"));
                et.setUserByUserIduserLivreur(rs.getInt("user_iduser_livreur"));

                List.add(et);

            }
            rs.close();
        } catch (SQLException e) {
        }
        return List;
    }

    public String getParams(String id) {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        return params.get(id);
    }

    public Livraison getlivraisonbyID(String mat) {
        Livraison et = null;

        try {
            String url = "jdbc:mysql://localhost:3306/livraisonbd";
            Connection conn = DriverManager.getConnection(url, "root", "");
            PreparedStatement ps = null;
            ps = conn.prepareStatement("select * from livraison where idlivraison= ?");
            ps.setString(1, mat);
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
                et.setUserByUserIdUserClient(rs.getInt("user_idUser_client"));
                et.setUserByUserIduserLivreur(rs.getInt("user_iduser_livreur"));
                // et.setTarification(rs.getInt(""));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return et;
    }

    @PostConstruct
    public void init() {

        tarifs = new LazyDataModel<Livraison>() {
//        if(tarifs.){}
            @Override
            public List<Livraison> load(int first, int pagesize, List<SortMeta> MultiSortMeta, Map<String, Object> filter) {

                tarifs.setRowCount(getListALLLivraison().size());
                return getListALLLivraison();
            }

            @Override
            public List<Livraison> load(int first, int pagesize, String sortField, SortOrder sortOrder, Map<String, Object> filter) {
                tarifs.setRowCount(getListALLLivraison().size());
                return getListALLLivraison();
            }

        };
        System.out.println("id ::::" + getParams("idlivraison"));
        System.out.println("Zone ::::" + getParams("zone"));

        if ("edit".equalsIgnoreCase(getParams("zone"))) {
            String id = getParams("idlivraison");
            Livraison livraison = getlivraisonbyID(id);

            idlivraisonbean = livraison.getIdlivraison();
            userByUserIdUserClientbean = livraison.getUserByUserIdUserClient();
            userByUserIduserLivreurbean = livraison.getUserByUserIduserLivreur();
            datelivraisonbean = livraison.getDatelivraison();
            adresserecuperationbean = livraison.getAdresserecuperation().toString();
            dateRecuperationbean = livraison.getDateRecuperation();
            telephonerrecuperationbean = livraison.getTelephonerrecuperation().toString();
            nomCompletDestinatairebean = livraison.getNomCompletDestinataire().toString();
            adresselivraisonbean = livraison.getAdresselivraison().toString();
            naturecolisbean = livraison.getNaturecolis().toString();
            typevehiculebean = livraison.getTypevehicule().toString();
            statutlivraisonbean = livraison.getStatutlivraison().toString();
            paiementbean = livraison.getPaiement().toString();
            statutpaiementbean = livraison.getStatutpaiement().toString();
            //   tarificationbean=livraison.getTarification().toString();

            System.out.println("info 1 :" + idlivraisonbean);
            System.out.println("info 1 :" + adresselivraisonbean);
            System.out.println("info 1 :" + nomCompletDestinatairebean);

        }
//idtarificationbean = Integer.valueOf(getParams("idtarification"));
//    System.out.println("id --------->" +idtarificationbean);
    }

    public User getUserbyName(String mat) {
        User p = null;

        try {
            String url = "jdbc:mysql://localhost:3306/livraisonbd";
            Connection conn = DriverManager.getConnection(url, "root", "");
            PreparedStatement ps = null;
            ps = conn.prepareStatement("select idUser from user where prenomUser= ? and profil_idprofil = 4");
            ps.setString(1, mat);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                p = new User();
                p.setIdUser(rs.getInt("idUser"));
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

    public void EditTarif() {
        TarificationHelper tar = new TarificationHelper();
        Livraison et = new Livraison();
        et.setIdlivraison(getIdlivraisonbean());
        et.setUserByUserIduserLivreur(getUserByUserIduserLivreurbean());
//           

        int r = getIdlivraisonbean();
        int rr =getUserByUserIduserLivreurbean();
        System.out.println("livreuuuuuuuur : "+rr);
//        String c = getTarificationbean().toString();
//        User idussss = getUserbyName(c);
//        int b = idussss.getIdUser();
//        System.out.println("asigné à " + b);
//        et.setUserByUserIduserLivreur(b);
        //  S   et.setUserByUserIduserLivreur(10);
        String val = null;
        String statchang = "non occupé";
        String statutlivraison = "validée";
        updateLivraisons(r, statutlivraison);
        updateUserAssigned(rr, statchang);

        System.out.println("UPDATED");

    }

    public void updateLivraisons(int idlivraison, String statutlivraison) {
        try {
            String url = "jdbc:mysql://localhost:3306/livraisonbd";
            Connection conn = DriverManager.getConnection(url, "root", "");
            PreparedStatement ps = null;
            ps = conn.prepareStatement("update livraison set"
                    + " idlivraison='" + idlivraison
                    + "',statutlivraison='" + statutlivraison
                    + "'where idlivraison='" + idlivraison
                    + "'");

            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateUserAssigned(int idUser, String statuschange) {
        try {
            String url = "jdbc:mysql://localhost:3306/livraisonbd";
            Connection conn = DriverManager.getConnection(url, "root", "");
            PreparedStatement ps = null;
            ps = conn.prepareStatement("update user set"
                    + " idUser='" + idUser
                    + "',statutLivreur='" + statuschange
                    + "'where idUser='" + idUser
                    + "'");

            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void UpdateLivraison(Livraison tarif) {
        Transaction trans = null;
        try {
            trans = session.beginTransaction();
            session.update(tarif);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trans != null) {
                trans.rollback();
            }
        }

    }

}
