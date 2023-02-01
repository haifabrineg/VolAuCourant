/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vol_au_courant.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author haifa
 */
public class Evenements {
     
    private int id_event;
    private Timestamp date_debut;
    private int prix;
    private int age_min;
    private int age_max;
    private String  lieu_depart;
    private String lieu_arrive ;
    private String equipement_ren;
    private String moyen_transport_ren;
    private String moyen_transport_t;
    private String sites_principeaux;
    private String equipements_camping;
    private Timestamp date_fin_camp;

    public Evenements() {
    }

    public Evenements(int prix, int age_min) {
        this.prix = prix;
        this.age_min = age_min;
    }

    public Evenements(int id_event, Timestamp date_debut, int prix, int age_min, 
            int age_max, String lieu_depart, String lieu_arrive, String equipement_ren,
            String moyen_transport_ren, String moyen_transport_t, String sites_principeaux, String equipements_camping
            , Timestamp date_fin_camp) {
        this.id_event = id_event;
        this.date_debut = date_debut;
        this.prix = prix;
        this.age_min = age_min;
        this.age_max = age_max;
        this.lieu_depart = lieu_depart;
        this.lieu_arrive = lieu_arrive;
        this.equipement_ren = equipement_ren;
        this.moyen_transport_ren = moyen_transport_ren;
        this.moyen_transport_t = moyen_transport_t;
        this.sites_principeaux = sites_principeaux;
        this.equipements_camping = equipements_camping;
        this.date_fin_camp = date_fin_camp;
    }

    public Evenements(int id_event) {
        this.id_event = id_event;
    }

    
    
     public Evenements(Timestamp date_debut, int prix, int age_min, int age_max,
            String lieu_depart, String lieu_arrive, String equipement_ren, String moyen_transport_ren,
            String moyen_transport_t, String sites_principeaux, String equipements_camping, Timestamp date_fin_camp) {
        this.date_debut = date_debut;
        this.prix = prix;
        this.age_min = age_min;
        this.age_max = age_max;
        this.lieu_depart = lieu_depart;
        this.lieu_arrive = lieu_arrive;
        this.equipement_ren = equipement_ren;
        this.moyen_transport_ren = moyen_transport_ren;
        this.moyen_transport_t = moyen_transport_t;
        this.sites_principeaux = sites_principeaux;
        this.equipements_camping = equipements_camping;
        this.date_fin_camp = date_fin_camp;
    }

    public Evenements(int id_event, Timestamp date_debut, int prix, int age_min, int age_max, String lieu_depart, String lieu_arrive, String equipement_ren, String moyen_transport_ren, String moyen_transport_t, String sites_principeaux, String equipements_camping) {
        this.id_event = id_event;
        this.date_debut = date_debut;
        this.prix = prix;
        this.age_min = age_min;
        this.age_max = age_max;
        this.lieu_depart = lieu_depart;
        this.lieu_arrive = lieu_arrive;
        this.equipement_ren = equipement_ren;
        this.moyen_transport_ren = moyen_transport_ren;
        this.moyen_transport_t = moyen_transport_t;
        this.sites_principeaux = sites_principeaux;
        this.equipements_camping = equipements_camping;
    }

    public Evenements(int aInt, Timestamp timestamp, int aInt0, int aInt1, int aInt2, String string, String string0, Timestamp timestamp0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Evenements(String date_debut, String date_fin, int prix, int age_min, int age_max, String equipements, String lieu_depart, String lieu_arrive) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Evenements(Timestamp date_debut, Timestamp date_fin, int prix, int age_min, int age_max, String equipements, String lieu_depart, String lieu_arrive) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Evenements(int aInt, Timestamp timestamp, int aInt0, int aInt1, int aInt2, String string, String string0, String string1, Timestamp timestamp0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Evenements{" + "id_event=" + id_event + ", date_debut=" + date_debut + ", prix=" + prix + ", age_min=" + age_min + ", age_max=" + age_max + ", lieu_depart=" + lieu_depart + ", lieu_arrive=" + lieu_arrive + ", equipement_ren=" + equipement_ren + ", moyen_transport_ren=" + moyen_transport_ren + ", moyen_transport_t=" + moyen_transport_t + ", sites_principeaux=" + sites_principeaux + ", equipements_camping=" + equipements_camping + ", date_fin_camp=" + date_fin_camp + '}';
    }
    
    

    public int getId_event() {
        return id_event;
    }

    public Timestamp getDate_debut() {
        return date_debut;
    }

    public int getPrix() {
        return prix;
    }

    public int getAge_min() {
        return age_min;
    }

    public int getAge_max() {
        return age_max;
    }


    public String getLieu_depart() {
        return lieu_depart;
    }

    public String getLieu_arrive() {
        return lieu_arrive;
    }

    public String getEquipement_ren() {
        return equipement_ren;
    }

    public String getMoyen_transport_ren() {
        return moyen_transport_ren;
    }

    public String getMoyen_transport_t() {
        return moyen_transport_t;
    }

    public String getSites_principeaux() {
        return sites_principeaux;
    }

    public String getEquipements_camping() {
        return equipements_camping;
    }

    public Date getDate_fin_camp() {
        return date_fin_camp;
    }

    
    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public void setDate_debut(Timestamp date_debut) {
        this.date_debut = date_debut;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void setAge_min(int age_min) {
        this.age_min = age_min;
    }

    public void setAge_max(int age_max) {
        this.age_max = age_max;
    }

    public void setLieu_depart(String lieu_depart) {
        this.lieu_depart = lieu_depart;
    }

    public void setLieu_arrive(String lieu_arrive) {
        this.lieu_arrive = lieu_arrive;
    }

    public void setEquipement_ren(String equipement_ren) {
        this.equipement_ren = equipement_ren;
    }

    public void setMoyen_transport_ren(String moyen_transport_ren) {
        this.moyen_transport_ren = moyen_transport_ren;
    }

    public void setMoyen_transport_t(String moyen_transport_t) {
        this.moyen_transport_t = moyen_transport_t;
    }

    public void setSites_principeaux(String sites_principeaux) {
        this.sites_principeaux = sites_principeaux;
    }

    public void setEquipements_camping(String equipements_camping) {
        this.equipements_camping = equipements_camping;
    }

    public void setDate_fin_camp(Timestamp date_fin_camp) {
        this.date_fin_camp = date_fin_camp;
    }

    
    
    
    
    
    
    
    
}
