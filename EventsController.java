/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vol_au_courant.gui;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import static java.awt.PageAttributes.MediaType.C;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import vol_au_courant.entity.Evenements;
import vol_au_courant.service.EvenementsService;
import vol_au_courant.utils.MyDB;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.SortEvent;
import static javafx.scene.input.KeyCode.C;
import javafx.util.Duration;
import javax.mail.internet.AddressException;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;



/**
 * FXML Controller class
 *
 * @author haifa
 */
public class EventsController implements Initializable {

    @FXML
    private Tab cpage;
    @FXML
    private Button bserach;
    @FXML
    private TextField tfsearchc;
    @FXML
    private Button binsert;
    @FXML
    private Button bupdate;
    @FXML
    private Button bdelete;
    private TextField tfddc;
    @FXML
    private TextField tfamaxc;
    private TextField tfdfc;
    @FXML
    private TextField tfprixc;
    @FXML
    private TextField tfamc;
    @FXML
    private TextField tfldc;
    @FXML
    private TextField tfeqc;
    @FXML
    private TextField tflac;
    @FXML
    private Button bserachr;
    @FXML
    private TextField tfsearchr;
    private TreeTableView<?> tvr;
    @FXML
    private Button binsertr;
    @FXML
    private Button bupdater;
    @FXML
    private TextField tflar;
    @FXML
    private TextField tfeqr;
    @FXML
    private TextField tfprixr;
    @FXML
    private TextField tfamr;
    @FXML
    private TextField tfamaxr;
    @FXML
    private TextField tfmtr;
    @FXML
    private TextField tfldr;
    @FXML
    private Button bseracht;
    @FXML
    private TextField tfsearcht;
    @FXML
    private Button binsertt;
    @FXML
    private Button bupdatet;
    @FXML
    private Button bdeletet;
    @FXML
    private TextField tfamaxt;
    @FXML
    private TextField tfamt;
    @FXML
    private TextField tfldt;
    @FXML
    private TextField tflact;
    @FXML
    private TextField tfmtt;
    @FXML
    private TextField tfspt;
    @FXML
    private TableView<Evenements> camptable;
    @FXML
    private TableColumn<Evenements, Integer> id_event;
    @FXML
    private TableColumn<Evenements, Timestamp> date_debut;
    @FXML
    private TableColumn<Evenements, Timestamp> date_fin;
    @FXML
    private TableColumn<Evenements, Integer> prix;
    @FXML
    private TableColumn<Evenements, Integer> age_min;
    @FXML
    private TableColumn<Evenements, Integer> age_max;
    @FXML
    private TableColumn<Evenements, String> equipements;
    @FXML
    private TableColumn<Evenements, String> lieu_depart;
    @FXML
    private TableColumn<Evenements, String> lieu_arrive;
    private static Evenements e;
    private static Evenements v ;
    private static Evenements w ;

    /**
     * Initializes the controller class.
     */
   
    public EvenementsService cs;
    private Label test;
    @FXML
    private DatePicker dpddc;
    @FXML
    private TextField heured;
    @FXML
    private TextField minuted;
    @FXML
    private TextField heurefin;
    @FXML
    private TextField minutefin;
    @FXML
    private DatePicker date_f;
    @FXML
    private DatePicker dpdatedeb;
    @FXML
    private TextField heurdeb;
    @FXML
    private TextField minutedeb;
    @FXML
    private Tab rpage;
    @FXML
    private Tab tpage;
    @FXML
    private TableView<Evenements> rentable;
    @FXML
    private TableColumn<Evenements, Integer> id_eventr;
    @FXML
    private TableColumn<Evenements, Timestamp> date_debutr;
    @FXML
    private TableColumn<Evenements, String> moy_tr;
    @FXML
    private TableColumn<Evenements, Integer> prixr;
    @FXML
    private TableColumn<Evenements, Integer> age_minr;
    @FXML
    private TableColumn<Evenements, Integer> age_maxr;
    @FXML
    private TableColumn<Evenements, String> equipementsr;
    @FXML
    private TableColumn<Evenements, String> lieu_departr;
    @FXML
    private TableColumn<Evenements, String> lieu_arriver;
    @FXML
    private Button supr;
    @FXML
    private TableView<Evenements> tourtable;
    @FXML
    private TableColumn<Evenements, Integer> id_eventt;
    @FXML
    private TableColumn<Evenements, Timestamp> date_debutt;
    @FXML
    private TableColumn<Evenements, String> moy_trt;
    @FXML
    private TableColumn<Evenements, Integer> prixt;
    @FXML
    private TableColumn<Evenements, Integer> age_mint;
    @FXML
    private TableColumn<Evenements, Integer> age_maxt;
    @FXML
    private TableColumn<Evenements, String> lieu_departt;
    @FXML
    private TableColumn<Evenements, String> lieu_arrivet;
    @FXML
    private TableColumn<Evenements, String> sites_princip;
    @FXML
    private DatePicker datedebt;
    @FXML
    private TextField heurt;
    @FXML
    private TextField minutet;
    @FXML
    private TextField tfprixt;
    @FXML
    private Button buttonPDF;
    
    /**
 * Initializes the controller class.
 * @param url
 * @param rb
 */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            this.cs = new EvenementsService();
            showEvents();
            getFromTable();
            getFromTabler ();
            getEventsListt();
            getFromTablet();
            
            
            } catch (SQLException ex) {
 
            
        }
        }

    private void showEvents()throws SQLException {
        ObservableList<Evenements> list = getEventsList() ;
id_event.setCellValueFactory(new PropertyValueFactory<Evenements, Integer>("id_event"));
date_debut.setCellValueFactory(new PropertyValueFactory<Evenements, Timestamp>("date_debut"));
date_fin.setCellValueFactory(new PropertyValueFactory<Evenements, Timestamp>("date_fin_camp"));
prix.setCellValueFactory(new PropertyValueFactory<Evenements, Integer>("prix"));
age_min.setCellValueFactory(new PropertyValueFactory<Evenements, Integer>("age_min"));
age_max.setCellValueFactory(new PropertyValueFactory<Evenements, Integer>("age_max"));
equipements.setCellValueFactory(new PropertyValueFactory<Evenements, String>("equipements_camping"));
lieu_depart.setCellValueFactory(new PropertyValueFactory<Evenements, String>("lieu_depart"));
lieu_arrive.setCellValueFactory(new PropertyValueFactory<Evenements, String>("lieu_arrive"));


camptable.setItems(list);
        
}
    

   private ObservableList<Evenements> getEventsList()throws SQLException  {
        ObservableList<Evenements> coachList = FXCollections.observableArrayList();
        Connection connection = MyDB.getInstance().getConnection();
     try {
 String req = "SELECT * FROM evenements2";
 Statement st = connection.createStatement();
 ResultSet rs = st.executeQuery(req);
 while(rs.next()){
 

 
 /*c = new 
Evenements(rs.getInt("id_event"),rs.getTimestamp("date_debut"),rs.getInt("prix"),rs.getInt
("age_min"),rs.getInt("age_max"),rs.getString("equipements_camping"),
rs.getString("lieu_depart"),rs.getString("lieu_arrive"),rs.getTimestamp("date_fin"));*/
 if (rs.getString("equipement_ren").equals("-") && rs.getString("sites_principeaux").equals("-")){
 Evenements c = new Evenements(rs.getInt(1),rs.getTimestamp(2), rs.getInt(3),rs.getInt(4),rs.getInt(5),
                        rs.getString(6),rs.getString(7),  rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12), rs.getTimestamp(13));
 coachList.add(c);}
 } } catch (SQLException ex) {
 ex.printStackTrace();
 }
return coachList;
  

        
}   
 private void getFromTable () {
  camptable.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
      @Override
      public void handle(javafx.scene.input.MouseEvent event) {
          e= camptable.getItems().get(camptable.getSelectionModel().getSelectedIndex());
          heured.setText(String.valueOf(e.getDate_debut().getHours()));
           minuted.setText(String.valueOf(e.getDate_debut().getMinutes()));
           heurefin.setText(String.valueOf(e.getDate_fin_camp().getHours()));
           minutefin.setText(String.valueOf(e.getDate_fin_camp().getMinutes()));
           tfprixc.setText(String.valueOf(e.getPrix()));
           tfamc.setText(String.valueOf(e.getAge_min()));
           tfamaxc.setText(String.valueOf(e.getAge_max()));
           tfeqc.setText(e.getEquipements_camping());
           tfldc.setText(e.getLieu_depart());
           tflac.setText(e.getLieu_arrive());
            
           
     
       
           
           
           
          
      }
  });   
        
  
 }
 
   
     @FXML
    private void search(ActionEvent event) throws IOException, SQLException {
  
       
  
       List<Evenements> list = cs.rechercher(Integer.parseInt(tfprixc.getText())) ;
id_event.setCellValueFactory(new PropertyValueFactory<Evenements, Integer>("id_event"));
date_debut.setCellValueFactory(new PropertyValueFactory<Evenements, Timestamp>("date_debut"));
date_fin.setCellValueFactory(new PropertyValueFactory<Evenements, Timestamp>("date_fin_camp"));
prix.setCellValueFactory(new PropertyValueFactory<Evenements, Integer>("prix"));
age_min.setCellValueFactory(new PropertyValueFactory<Evenements, Integer>("age_min"));
age_max.setCellValueFactory(new PropertyValueFactory<Evenements, Integer>("age_max"));
equipements.setCellValueFactory(new PropertyValueFactory<Evenements, String>("equipements_camping"));
lieu_depart.setCellValueFactory(new PropertyValueFactory<Evenements, String>("lieu_depart"));
lieu_arrive.setCellValueFactory(new PropertyValueFactory<Evenements, String>("lieu_arrive"));
Stage stage = (Stage) bserach.getScene().getWindow();
  stage.close();
 Stage Stage = new Stage();
 Parent root = FXMLLoader.load(getClass().getResource("events.fxml"));      
  

camptable.setItems((ObservableList<Evenements>) list);
         
    
    }

    @FXML
    private void searchc(ActionEvent event) {
    }

    @FXML
    private void insert(ActionEvent event)throws IOException, SQLException {
         Timestamp dateD = new Timestamp(dpddc.getValue().getYear() - 1900, dpddc.getValue().getMonthValue() - 1, dpddc.getValue().getDayOfMonth(),
                Integer.parseInt(heured.getText()),Integer.parseInt(minuted.getText()),0,0);
 int prix = Integer.parseInt(tfprixc.getText());
 int age_min = Integer.parseInt(tfamc.getText());
 int age_max = Integer.parseInt(tfamaxc.getText());
 String equipements = tfeqc.getText();
 String lieu_depart = tfldc.getText();
 String lieu_arrive = tflac.getText();
 String equipements_ren="-";
 String sites_principeaux="-";
 String moyen_transport_ren="-";
  String moyen_transport_t="-";
  Timestamp dateF = new Timestamp(date_f.getValue().getYear() - 1900, date_f.getValue().getMonthValue() - 1, date_f.getValue().getDayOfMonth(),
                Integer.parseInt(heurefin.getText()),Integer.parseInt(minutefin.getText()),0,0);
  /*
 if(tfddc.getText().isEmpty())
 { System.out.println("Reference vide !!");
 }else if (tfdfc.getText().isEmpty()){
 System.out.println("nom vide !!");
 }else if (tfprixc.getText().isEmpty()){
 System.out.println("prenom vide !!");
 }else if (tfamc.getText().isEmpty())
 else if (idCombotype.getSelectionModel().getSelectedItem().toString().isEmpty())
 {
 System.out.println("type vide !!");
 }else if (tfamaxc.getText().isEmpty()){
 System.out.println("contact vide !!");
 }else if (tfeqc.getText().isEmpty()){
 System.out.println("contact vide !!");
 }else if (tfldc.getText().isEmpty()){
 System.out.println("contact vide !!");
 }else if (tflac.getText().isEmpty()){
 System.out.println("contact vide !!");
 }else*/
  Evenements c = new Evenements(dateD,prix, age_min,age_max,lieu_depart,
          lieu_arrive,equipements_ren,moyen_transport_ren,moyen_transport_t,
          sites_principeaux,equipements,dateF);
 cs.insert(c);
 JOptionPane.showMessageDialog(null, "evenement ajoutee");
 showEvents();
 
 
 
  
        
    }

    @FXML
    private void update(ActionEvent event) throws IOException, SQLException {
          
        if(e!=null){
  Timestamp dateD = new Timestamp(dpddc.getValue().getYear() - 1900, dpddc.getValue().getMonthValue() - 1, dpddc.getValue().getDayOfMonth(),
                Integer.parseInt(heured.getText()),Integer.parseInt(minuted.getText()),0,0);
   
 int prix = Integer.parseInt(tfprixc.getText());
 int age_min = Integer.parseInt(tfamc.getText());
 int age_max = Integer.parseInt(tfamaxc.getText());
   
 String equipements = tfeqc.getText();
 String lieu_depart = tfldc.getText();
 String lieu_arrive = tflac.getText();
 String equipements_ren="-";
 String sites_principeaux="-";
 String moyen_transport_ren="-";
  String moyen_transport_t="-";
  Timestamp dateF = new Timestamp(date_f.getValue().getYear() - 1900, date_f.getValue().getMonthValue() - 1, date_f.getValue().getDayOfMonth(),
   Integer.parseInt(heurefin.getText()),Integer.parseInt(minutefin.getText()),0,0);
   Evenements c = new Evenements(dateD,prix, age_min,age_max,lieu_depart,lieu_arrive,equipements_ren,moyen_transport_ren,moyen_transport_t,sites_principeaux,equipements,dateF);   
cs.update(c, e.getId_event());
JOptionPane.showMessageDialog(null, "evenement ajoutee");
showEvents();

    }}

    @FXML
    private void delete(ActionEvent event) throws IOException, SQLException {
           if(e!=null){
            cs.delete(e.getId_event());
            JOptionPane.showMessageDialog(null, "evenement supprimée");
            showEvents();
    }}

private void showEventst()throws SQLException {
        ObservableList<Evenements> list = getEventsListt() ;
id_eventt.setCellValueFactory(new PropertyValueFactory<Evenements, Integer>("id_event"));
date_debutt.setCellValueFactory(new PropertyValueFactory<Evenements, Timestamp>("date_debut"));
prixt.setCellValueFactory(new PropertyValueFactory<Evenements, Integer>("prix"));
age_mint.setCellValueFactory(new PropertyValueFactory<Evenements, Integer>("age_min"));
age_maxt.setCellValueFactory(new PropertyValueFactory<Evenements, Integer>("age_max"));
lieu_departt.setCellValueFactory(new PropertyValueFactory<Evenements, String>("lieu_depart"));
lieu_arrivet.setCellValueFactory(new PropertyValueFactory<Evenements, String>("lieu_arrive"));
sites_princip.setCellValueFactory(new PropertyValueFactory<Evenements, String>("sites_principeaux"));
moy_trt.setCellValueFactory(new PropertyValueFactory<Evenements, String>("moyen_transport_t"));




tourtable.setItems(list);
        
}


private ObservableList<Evenements> getEventsListt()throws SQLException  {
        ObservableList<Evenements> coachList = FXCollections.observableArrayList();
        Connection connection = MyDB.getInstance().getConnection();
     try {
 String req = "SELECT * FROM evenements2";
 Statement st = connection.createStatement();
 ResultSet rs = st.executeQuery(req);
 while(rs.next()){
     
 /*c = new 
Evenements(rs.getInt("id_event"),rs.getTimestamp("date_debut"),rs.getInt("prix"),rs.getInt
("age_min"),rs.getInt("age_max"),rs.getString("equipements_camping"),
rs.getString("lieu_depart"),rs.getString("lieu_arrive"),rs.getTimestamp("date_fin"));*/
 if (rs.getString("equipement_ren").equals("-") && rs.getString("equipements_camping").equals("-")){
 Evenements c = new Evenements(rs.getInt(1),rs.getTimestamp(2), rs.getInt(3),rs.getInt(4),rs.getInt(5),
                        rs.getString(6),rs.getString(7),  rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12), rs.getTimestamp(13));

 coachList.add(c);}
  }} catch (SQLException ex) {
 ex.printStackTrace();
 }
    
return coachList;
  

        
}   
private void getFromTablet () {
  tourtable.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
      @Override
      public void handle(javafx.scene.input.MouseEvent event) {
          w = tourtable.getItems().get(tourtable.getSelectionModel().getSelectedIndex());
          heurt.setText(String.valueOf(w.getDate_debut().getHours()));
           minutet.setText(String.valueOf(w.getDate_debut().getMinutes()));
           tfprixt.setText(String.valueOf(w.getPrix()));
           tfamt.setText(String.valueOf(w.getAge_min()));
           tfamaxt.setText(String.valueOf(w.getAge_max()));
           tfspt.setText(w.getSites_principeaux());
           tfldt.setText(w.getLieu_depart());
           tflact.setText(w.getLieu_arrive());
           tfmtt.setText(w.getMoyen_transport_t());
           
            System.out.println(w);   
      }
  });   
        
  
 }
    
    @FXML
    private void amxc(ActionEvent event) {
    }


    @FXML
    private void prixc(ActionEvent event) {
    }

    @FXML
    private void amcamp(ActionEvent event) {
    }

    @FXML
    private void ldepc(ActionEvent event) {
    }

    @FXML
    private void eqcamp(ActionEvent event) {
    }

    @FXML
    private void lac(ActionEvent event) {
    }

    @FXML
    private void camping(Event event) throws SQLException {
        showEvents();
    }

    @FXML
    private void searchr(ActionEvent event) {
    }

    @FXML
    private void insertr(ActionEvent event) throws IOException, SQLException {
      if(v!=null){   
  Timestamp dateD = new Timestamp(dpdatedeb.getValue().getYear() - 1900, dpdatedeb.getValue().getMonthValue() - 1, dpdatedeb.getValue().getDayOfMonth(),
                Integer.parseInt(heurdeb.getText()),Integer.parseInt(minutedeb.getText()),0,0);
 int prix = Integer.parseInt(tfprixr.getText());
 int age_min = Integer.parseInt(tfamr.getText());
 int age_max = Integer.parseInt(tfamaxr.getText());
 String equipements = tfeqr.getText();
 String lieu_depart = tfldr.getText();
 String lieu_arrive = tflar.getText();
 String moyen_t = tfmtr.getText();
 String equipements_camping="-";
 String sites_principeaux="-";
 String date_fin="-";
  String moyen_transport_t="-";
  //Timestamp dateF = new Timestamp(date_f.getValue().getYear() - 1900, date_f.getValue().getMonthValue() - 1, date_f.getValue().getDayOfMonth(),
              //  Integer.parseInt(heurefin.getText()),Integer.parseInt(minutefin.getText()),0,0);
  Evenements c = new Evenements(dateD,prix, age_min,age_max,lieu_depart,
          lieu_arrive,equipements,moyen_t,moyen_transport_t,
          sites_principeaux,equipements_camping,Timestamp.valueOf("2018-09-01 09:01:15"));
 cs.insert(c);
 showEventsr();
 JOptionPane.showMessageDialog(null, "evenement ajouté");}
// Stage stage = (Stage) binsertr.getScene().getWindow();
// stage.close();
// Stage Stage = new Stage();
// Parent root = FXMLLoader.load(getClass().getResource("events.fxml"));
// Stage.setScene(new Scene(root));
// Stage.show();

     
 
    }
    private void getFromTabler () {
  rentable.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
      @Override
      public void handle(javafx.scene.input.MouseEvent event) {
           v = rentable.getItems().get(rentable.getSelectionModel().getSelectedIndex());
                    
          heurdeb.setText(String.valueOf(v.getDate_debut().getHours()));
           minutedeb.setText(String.valueOf(v.getDate_debut().getMinutes()));
           
           tfprixr.setText(String.valueOf(v.getPrix()));
           tfamr.setText(String.valueOf(v.getAge_min()));
           tfamaxr.setText(String.valueOf(v.getAge_max()));
           tfeqr.setText(v.getEquipement_ren());
           tfldr.setText(v.getLieu_depart());
           tflar.setText(v.getLieu_arrive());
           tfmtr.setText(v.getMoyen_transport_ren());
            
           
     
       
           
           
           
          
      }
  });   
        
  
 }

    @FXML
    private void updater(ActionEvent event) throws IOException, SQLException {
         if(v!=null){
  Timestamp dateD = new Timestamp(dpdatedeb.getValue().getYear() - 1900, dpdatedeb.getValue().getMonthValue() - 1, dpdatedeb.getValue().getDayOfMonth(),
                Integer.parseInt(heurdeb.getText()),Integer.parseInt(minutedeb.getText()),0,0);
   
 int prix = Integer.parseInt(tfprixr.getText());
 int age_min = Integer.parseInt(tfamr.getText());
 int age_max = Integer.parseInt(tfamaxr.getText());
   
 String equipements = tfeqr.getText();
 String lieu_depart = tfldr.getText();
 String lieu_arrive = tflar.getText();
  String moyen_transport_ren = tflar.getText();
 String equipements_c="-";
 String sites_principeaux="-";
  String moyen_transport_t="-";
 
   Evenements c = new Evenements(dateD,prix, age_min,age_max,lieu_depart,lieu_arrive,equipements,moyen_transport_ren,moyen_transport_t,sites_principeaux,equipements_c,Timestamp.valueOf("2018-09-01 09:01:15"));   
cs.update(c, v.getId_event());
JOptionPane.showMessageDialog(null, "evenement modifié");
showEventsr();

    }
    }
 private void showEventsr()throws SQLException {
        ObservableList<Evenements> list = getEventsListr() ;
        
id_eventr.setCellValueFactory(new PropertyValueFactory<Evenements, Integer>("id_event"));
date_debutr.setCellValueFactory(new PropertyValueFactory<Evenements, Timestamp>("date_debut"));
 
prixr.setCellValueFactory(new PropertyValueFactory<Evenements, Integer>("prix"));
age_minr.setCellValueFactory(new PropertyValueFactory<Evenements, Integer>("age_min"));
 
age_maxr.setCellValueFactory(new PropertyValueFactory<Evenements, Integer>("age_max"));
equipementsr.setCellValueFactory(new PropertyValueFactory<Evenements, String>("equipement_ren"));
lieu_departr.setCellValueFactory(new PropertyValueFactory<Evenements, String>("lieu_depart"));
 
lieu_arriver.setCellValueFactory(new PropertyValueFactory<Evenements, String>("lieu_arrive"));
moy_tr.setCellValueFactory(new PropertyValueFactory<Evenements, String>("mouyen_transport_ren"));


rentable.setItems(list);
        
}
    

   private ObservableList<Evenements> getEventsListr()throws SQLException  {
        ObservableList<Evenements> coachList = FXCollections.observableArrayList();
        Connection connection = MyDB.getInstance().getConnection();
     try {
 String req = "SELECT * FROM evenements2";
 Statement st = connection.createStatement();
 ResultSet rs = st.executeQuery(req);
 while(rs.next()){
 

 
 /*c = new 
Evenements(rs.getInt("id_event"),rs.getTimestamp("date_debut"),rs.getInt("prix"),rs.getInt
("age_min"),rs.getInt("age_max"),rs.getString("equipements_camping"),
rs.getString("lieu_depart"),rs.getString("lieu_arrive"),rs.getTimestamp("date_fin"));*/
 if (rs.getString("equipements_camping").equals("-") && rs.getString("sites_principeaux").equals("-") ){
 Evenements c = new Evenements(rs.getInt(1),rs.getTimestamp(2), rs.getInt(3),rs.getInt(4),rs.getInt(5),
                        rs.getString(6),rs.getString(7),  rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12), rs.getTimestamp(13));

 coachList.add(c);}}
  } catch (SQLException ex) {
 ex.printStackTrace();
 } 
return coachList;
  

        
}  
    @FXML
    private void lar(ActionEvent event) {
    }

    @FXML
    private void eqren(ActionEvent event) {
    }

    @FXML
    private void prixr(ActionEvent event) {
    }


    @FXML
    private void amren(ActionEvent event) {
    }

    @FXML
    private void amxr(ActionEvent event) {
    }

    @FXML
    private void mtr(ActionEvent event) {
    }

    @FXML
    private void ldepr(ActionEvent event) {
    }
 
    
   
    
    @FXML
    private void searcht(ActionEvent event) {
        
    }

    @FXML
    private void insertt(ActionEvent event) throws SQLException {
        Timestamp dateD = new Timestamp(datedebt.getValue().getYear() - 1900, datedebt.getValue().getMonthValue() - 1, datedebt.getValue().getDayOfMonth(),
                Integer.parseInt(heurt.getText()),Integer.parseInt(minutet.getText()),0,0);
 int prix = Integer.parseInt(tfprixt.getText());
 int age_min = Integer.parseInt(tfamt.getText());
 int age_max = Integer.parseInt(tfamaxt.getText());
 String sites_principeaux = tfspt.getText();
 String lieu_depart = tfldt.getText();
 String lieu_arrive = tflact.getText();
  String moyen_transport_t = tfmtt.getText();

 String equipements_ren="-";
 String equipements ="-";
 String moyen_transport_ren="-";
 
   Evenements c = new Evenements(dateD,prix, age_min,age_max,lieu_depart,
          lieu_arrive,equipements_ren,moyen_transport_ren,moyen_transport_t,
          sites_principeaux,equipements,Timestamp.valueOf("2018-09-01 09:01:15"));
 cs.insert(c);
 JOptionPane.showMessageDialog(null, "evenement ajoutee");
 showEventst();
  
    }

    @FXML
    private void updatet(ActionEvent event) throws SQLException {
         if(w!=null){
   Timestamp dateD = new Timestamp(datedebt.getValue().getYear() - 1900, datedebt.getValue().getMonthValue() - 1, datedebt.getValue().getDayOfMonth(),
                Integer.parseInt(heurt.getText()),Integer.parseInt(minutet.getText()),0,0);
   
 int prix = Integer.parseInt(tfprixt.getText());
 int age_min = Integer.parseInt(tfamt.getText());
 int age_max = Integer.parseInt(tfamaxt.getText());
 String sites_principeaux = tfspt.getText();
 String lieu_depart = tfldt.getText();
 String lieu_arrive = tflact.getText();
  String moyen_transport_t = tfmtt.getText();

 String equipements_ren="-";
 String equipements ="-";
 String moyen_transport_ren="-";
 
Evenements c = new Evenements(dateD,prix, age_min,age_max,lieu_depart,
          lieu_arrive,equipements_ren,moyen_transport_ren,moyen_transport_t,
          sites_principeaux,equipements,Timestamp.valueOf("2018-09-01 09:01:15"));
cs.update(c, w.getId_event());
JOptionPane.showMessageDialog(null, "evenement modifié");
showEventst();

    }
    }

    @FXML
    private void deletet(ActionEvent event) throws SQLException {
         if(w!=null){
            cs.delete(w.getId_event());
            JOptionPane.showMessageDialog(null, "evenement supprimée");
            showEventst();
    }
    }


    @FXML
    private void amxt(ActionEvent event) {
    }

    @FXML
    private void amt(ActionEvent event) {
    }

    @FXML
    private void ldept(ActionEvent event) {
    }

    @FXML
    private void lat(ActionEvent event) {
    }

    @FXML
    private void mtt(ActionEvent event) {
    }

    @FXML
    private void spt(ActionEvent event) {
    }


    @FXML
    private  LocalDate ddc() {
        LocalDate myDate = dpddc.getValue();
        return myDate;    
        
    }

    @FXML
    private void datefin(ActionEvent event) {
    }

    @FXML
    private void datedeb(ActionEvent event) {
    }

    @FXML
    private void renpage(Event event) throws SQLException {
        
        showEventsr();
        
    }

    @FXML
    private void tourpage(Event event) throws SQLException {
        showEventst();
    }

    @FXML
    private void supprimerr(ActionEvent event) throws IOException, SQLException {
         if(v!=null){
            cs.delete(v.getId_event());
            JOptionPane.showMessageDialog(null, "evenement supprimée");
             showEventsr();
    }
    }

    @FXML
    private void datedebutt(ActionEvent event) {
        
    }
   @FXML
    void PDF (ActionEvent event) throws SQLException, FileNotFoundException, DocumentException {
        try {
Connection connection = MyDB.getInstance().getConnection();

        ResultSet rs;
        rs = connection.createStatement().executeQuery("SELECT * FROM evenements2");
                    /* Step-2: Initialize PDF documents - logical objects */
                    Document my_pdf_report = new Document();
                    PdfWriter.getInstance(my_pdf_report, new FileOutputStream("Liste_Reservation.pdf"));
                    my_pdf_report.open();
                    //we have four columns in our table
                    PdfPTable my_report_table = new PdfPTable(13);
                    //create a cell object
                    PdfPCell table_cell;

                    while (rs.next()) {
                                
                        
                                   String dept_name1=rs.getString("id_event");
                                    table_cell=new PdfPCell(new Phrase(dept_name1));
                                    my_report_table.addCell(table_cell);

                                    String dept_name=rs.getString("date_debut");
                                    table_cell=new PdfPCell(new Phrase(dept_name));
                                    my_report_table.addCell(table_cell);

                                    String manager_id3=rs.getString("prix");
                                    table_cell=new PdfPCell(new Phrase(manager_id3));
                                    my_report_table.addCell(table_cell);
                                    
                                    String manager_id=rs.getString("age_min");
                                    table_cell=new PdfPCell(new Phrase(manager_id));
                                    my_report_table.addCell(table_cell);
                                    
                                    String manager_id1=rs.getString("age_max");
                                    table_cell=new PdfPCell(new Phrase(manager_id1));
                                    my_report_table.addCell(table_cell);
                                    
                                     String datef=rs.getString("lieu_depart");
                                    table_cell=new PdfPCell(new Phrase(datef));
                                    my_report_table.addCell(table_cell);

                                    String location_id=rs.getString("lieu_arrive");
                                    table_cell=new PdfPCell(new Phrase(location_id));
                                    my_report_table.addCell(table_cell);
                                    
                                    String location_id9=rs.getString("equipement_ren");
                                    table_cell=new PdfPCell(new Phrase(location_id9));
                                    my_report_table.addCell(table_cell);
                                    
                                    String location_id8=rs.getString("mouyen_transport_ren");
                                    table_cell=new PdfPCell(new Phrase(location_id8));
                                    my_report_table.addCell(table_cell);
                                    
                                    String location_id10=rs.getString("moyen_transport_t");
                                    table_cell=new PdfPCell(new Phrase(location_id10));
                                    my_report_table.addCell(table_cell);
                                    
                                    String location_id11=rs.getString("sites_principeaux");
                                    table_cell=new PdfPCell(new Phrase(location_id11));
                                    my_report_table.addCell(table_cell);
                                    

                                    String dated=rs.getString("equipements_camping");
                                    table_cell=new PdfPCell(new Phrase(dated));
                                    my_report_table.addCell(table_cell);

                                   String manager_id2=rs.getString("date_fin_camp");
                                    table_cell=new PdfPCell(new Phrase(manager_id2));
                                    my_report_table.addCell(table_cell);
                                    
                                    }
                    /* Attach report table to PDF */
                    my_pdf_report.add(my_report_table);
                    my_pdf_report.close();

                    /* Close all DB related objects */
                    rs.close();





    } catch (FileNotFoundException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
    } catch (DocumentException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();

    }
         String title = "Succes! ";
        String message = "Le fichier PDF est generé";

        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.seconds(5));

    }
    

    }
    

    