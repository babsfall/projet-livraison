package beans;
// Generated 3 d�c. 2020 16:11:03 by Hibernate Tools 4.3.1



/**
 * Destinataire generated by hbm2java
 */
public class Destinataire  implements java.io.Serializable {


     private Integer iddestinataire;
     private Integer user;
     private String nomCompletDestinataire;
     private String adresseDestinataire;
     private String telephoneDestinataire;

    public Destinataire() {
    }

    public Destinataire(Integer user, String nomCompletDestinataire, String adresseDestinataire, String telephoneDestinataire) {
       this.user = user;
       this.nomCompletDestinataire = nomCompletDestinataire;
       this.adresseDestinataire = adresseDestinataire;
       this.telephoneDestinataire = telephoneDestinataire;
    }
   
    public Integer getIddestinataire() {
        return this.iddestinataire;
    }
    
    public void setIddestinataire(Integer iddestinataire) {
        this.iddestinataire = iddestinataire;
    }
    public Integer getUser() {
        return this.user;
    }
    
    public void setUser(Integer user) {
        this.user = user;
    }
    public String getNomCompletDestinataire() {
        return this.nomCompletDestinataire;
    }
    
    public void setNomCompletDestinataire(String nomCompletDestinataire) {
        this.nomCompletDestinataire = nomCompletDestinataire;
    }
    public String getAdresseDestinataire() {
        return this.adresseDestinataire;
    }
    
    public void setAdresseDestinataire(String adresseDestinataire) {
        this.adresseDestinataire = adresseDestinataire;
    }
    public String getTelephoneDestinataire() {
        return this.telephoneDestinataire;
    }
    
    public void setTelephoneDestinataire(String telephoneDestinataire) {
        this.telephoneDestinataire = telephoneDestinataire;
    }




}


