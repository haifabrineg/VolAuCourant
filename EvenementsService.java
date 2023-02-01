/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vol_au_courant.service;

import java.sql.SQLException;
import java.sql.Statement;
import vol_au_courant.entity.Evenements;
import vol_au_courant.utils.MyDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author haifa
 */
public class EvenementsService  implements Services <Evenements>{

  private Connection cnx;
    private Statement st;
    private Statement ste;

    private PreparedStatement pst;
    private ResultSet rs;
     public EvenementsService (){
         cnx = MyDB.getInstance().getConnection();
        
     }
    @Override
    public void insert(Evenements p) {
         try {
              
           String req = "INSERT INTO `evenements2`(`date_debut`, `prix`, `age_min`, `age_max`, `lieu_depart`, `lieu_arrive`,`equipement_ren`, `mouyen_transport_ren`, `moyen_transport_t`, `sites_principeaux`, `equipements_camping`, `date_fin_camp`) values ('"+p.getDate_debut()+"','"+p.getPrix()+"','"+p.getAge_min()+"','"+p.getAge_max()+"','"+
                   p.getLieu_depart()+"','"+p.getLieu_arrive()+"','"+p.getEquipement_ren()+"','"+p.getMoyen_transport_ren()+"','"+p.getMoyen_transport_t()
                   +"','"+p.getSites_principeaux()+"','"+p.getEquipements_camping()+"','"+p.getDate_fin_camp()+"')";

           PreparedStatement st = cnx.prepareStatement(req);
             st.executeUpdate(req);
            System.out.println("Event added !");      
            Statement statement = cnx.createStatement();
                     
       
        } catch (SQLException ex) {
            System.out.println("Event ded !");
            System.out.println(ex. getMessage());
        }

        
    }
     
     
     



    @Override
    public void update(Evenements p , int id) {
         try {
              
           String req = " UPDATE `evenements2` SET `date_debut`='"+p.getDate_debut()+"',`prix`='"+p.getPrix()+"',`age_min`='"+p.getAge_min()+"',`age_max`='"+p.getAge_max()+"',`lieu_depart`='"+p.getLieu_depart()+"',`lieu_arrive`='"+p.getLieu_arrive()+"',`equipement_ren`='"+p.getEquipement_ren()+"',`mouyen_transport_ren`='"+p.getMoyen_transport_ren()+"',`moyen_transport_t`='"+p.getMoyen_transport_t()+"',`sites_principeaux`='"+p.getSites_principeaux()+"',`equipements_camping`='"+p.getEquipements_camping()+"',`date_fin_camp`='"+p.getDate_fin_camp()+"' WHERE id_event= '"+id+"'";

           PreparedStatement st = cnx.prepareStatement(req);
             st.executeUpdate(req);
            System.out.println("Event updated !");      
            Statement statement = cnx.createStatement();
         }catch (SQLException ex) {
            System.out.println("Erreur");
            System.out.println(ex. getMessage());
         }
    }

    @Override
    public void delete(int id) {
        try {
         pst = cnx.prepareStatement("delete from evenements2 where id_event=?");
        pst.setInt(1,id);
        pst.execute();
        System.out.println("deleted !");
    } catch (SQLException ex) {
        
        Logger.getLogger(EvenementsService.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }

    @Override
    public List<Evenements> FindAll() {
                

       List<Evenements> list=new ArrayList<>();
        String req = "select * from evenements2 ";
         try {
            st = cnx.createStatement();
            rs = st.executeQuery(req);
            while(rs.next()){ 
                Evenements e = new Evenements(rs.getInt(1),rs.getTimestamp(2), rs.getInt(3),rs.getInt(4),rs.getInt(5),
                        rs.getString(6),rs.getString(7),  rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12), rs.getTimestamp(13));
            list.add(e);                
            }
            
        } catch (SQLException ex) {
              System.out.println ("error");
              Logger.getLogger(EvenementsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    
       
     
    }  

    public List rechercher(int prix,List<Evenements> listr) {
        List<Evenements> list=new ArrayList<>();
        String req = "select * from evenements2 where prix="+prix+"";
         try {
            st = cnx.createStatement();
            rs = st.executeQuery(req);
            while(rs.next()){ 
                Evenements e = new Evenements(rs.getInt(1),rs.getTimestamp(2), rs.getInt(3),rs.getInt(4),rs.getInt(5),
                        rs.getString(6),rs.getString(7),  rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12), rs.getTimestamp(13));
            list.add(e);                
            }
            listr=list;
            
        } catch (SQLException ex) {
              System.out.println ("error");
              Logger.getLogger(EvenementsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
}
  @Override
        public List rechercher(Timestamp t){
        List<Evenements> list=new ArrayList<>();
        String req = "select * from evenements2 ";
         try {
            st = cnx.createStatement();
            rs = st.executeQuery(req);
            while(rs.next()){ 
                Evenements e = new Evenements(rs.getInt(1),rs.getTimestamp(2), rs.getInt(3),rs.getInt(4),rs.getInt(5),
                        rs.getString(6),rs.getString(7),  rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12), rs.getTimestamp(13));
            list.add(e);                
            }
            
        } catch (SQLException ex) {
              System.out.println ("error");
              Logger.getLogger(EvenementsService.class.getName()).log(Level.SEVERE, null, ex);
        }
         list=list.stream().filter(i->i.getDate_debut().compareTo(t)>=0).collect(Collectors.toList());
        return list;
}

    @Override
    public List rechercher(Timestamp t, Timestamp d) {
        List<Evenements> list=new ArrayList<>();
        String req = "select * from evenements2 ";
         try {
            st = cnx.createStatement();
            rs = st.executeQuery(req);
            while(rs.next()){ 
                Evenements e = new Evenements(rs.getInt(1),rs.getTimestamp(2), rs.getInt(3),rs.getInt(4),rs.getInt(5),
                        rs.getString(6),rs.getString(7),  rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12), rs.getTimestamp(13));
            list.add(e);                
            }
            
        } catch (SQLException ex) {
              System.out.println ("error");
              Logger.getLogger(EvenementsService.class.getName()).log(Level.SEVERE, null, ex);
        }
         list=list.stream().filter(i->(i.getDate_debut().compareTo(t)>=0&&i.getDate_fin_camp().compareTo(t)<=0)).collect(Collectors.toList());
        return list;
    }

    @Override
    public List rechercher(int t, int d) {
        List<Evenements> list=new ArrayList<>();
        String req = "select * from evenements2 ";
         try {
            st = cnx.createStatement();
            rs = st.executeQuery(req);
            while(rs.next()){ 
                Evenements e = new Evenements(rs.getInt(1),rs.getTimestamp(2), rs.getInt(3),rs.getInt(4),rs.getInt(5),
                        rs.getString(6),rs.getString(7),  rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12), rs.getTimestamp(13));
            list.add(e);                
            }
            
        } catch (SQLException ex) {
              System.out.println ("error");
              Logger.getLogger(EvenementsService.class.getName()).log(Level.SEVERE, null, ex);
        }
         list=list.stream().filter(i->(i.getPrix()>=t) && (i.getPrix()<=d)).collect(Collectors.toList());
        return list; 
    }
    
     @Override
    public List rechercher(String lieu) {
       List<Evenements> list=new ArrayList<>();
        String req = "select * from evenements2 ";
         try {
            st = cnx.createStatement();
            rs = st.executeQuery(req);
            while(rs.next()){ 
                Evenements e = new Evenements(rs.getInt(1),rs.getTimestamp(2), rs.getInt(3),rs.getInt(4),rs.getInt(5),
                        rs.getString(6),rs.getString(7),  rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12), rs.getTimestamp(13));
            list.add(e);                
            }
            
        } catch (SQLException ex) {
              System.out.println ("error");
              Logger.getLogger(EvenementsService.class.getName()).log(Level.SEVERE, null, ex);
        }
         list=list.stream().filter(i->(i.getLieu_depart().equals(lieu))).collect(Collectors.toList());
        return list;
    }

    @Override
    public List rechercher(int prix) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
