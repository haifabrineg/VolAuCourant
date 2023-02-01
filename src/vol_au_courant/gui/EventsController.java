/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vol_au_courant.gui;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    @FXML
    private TextField tfddc;
    @FXML
    private TextField tfamaxc;
    @FXML
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
    @FXML
    private TreeTableView<?> tvr;
    @FXML
    private TreeTableColumn<?, ?> idr;
    @FXML
    private TreeTableColumn<?, ?> dbr;
    @FXML
    private TreeTableColumn<?, ?> pr;
    @FXML
    private TreeTableColumn<?, ?> amr;
    @FXML
    private TreeTableColumn<?, ?> ldr;
    @FXML
    private TreeTableColumn<?, ?> lar;
    @FXML
    private TreeTableColumn<?, ?> eqr;
    @FXML
    private TreeTableColumn<?, ?> mtr;
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
    private TextField tfddr;
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
    private TreeTableView<?> tvt;
    @FXML
    private TreeTableColumn<?, ?> idt;
    @FXML
    private TreeTableColumn<?, ?> ddt;
    @FXML
    private TreeTableColumn<?, ?> pt;
    @FXML
    private TreeTableColumn<?, ?> amt;
    @FXML
    private TreeTableColumn<?, ?> amxt;
    @FXML
    private TreeTableColumn<?, ?> ldt;
    @FXML
    private TreeTableColumn<?, ?> lat;
    @FXML
    private TreeTableColumn<?, ?> mtt;
    @FXML
    private TreeTableColumn<?, ?> st;
    @FXML
    private Button binsertt;
    @FXML
    private Button bupdatet;
    @FXML
    private Button bdeletet;
    @FXML
    private TextField tfddt;
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

    /**
     * Initializes the controller class.
     */
    public static Evenements c2 ;
    public static int i;
    public EvenementsService cs;
    private Label test;
    @FXML
    private TextField tfidupdelc;
    @FXML
    
    
    private TextField tfidupde;
    @FXML
    private TextField tfidupdel;
    @FXML
    private TableColumn<?, ?> lieu_arrive1;
    
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
     @FXML
    private void search(ActionEvent event) {
                 ObservableList<Evenements> list=  (ObservableList<Evenements>) cs.rechercher(Integer.parseInt(tfsearchc.getText()));
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

    @FXML
    private void searchc(ActionEvent event) {
    }

    @FXML
    private void insert(ActionEvent event)throws IOException {
      //  String text = "2011-10-02 18:48:05.123";
//ts = Timestamp.valueOf(text);
 Timestamp date_debut = Timestamp.valueOf(tfddc.getText());
 Timestamp date_fin = Timestamp.valueOf(tfdfc.getText());
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

 
 
 /*
 if(tfddc.getText().isEmpty())
 { System.out.println("Reference vide !!");
 }else if (tfdfc.getText().isEmpty()){
 System.out.println("nom vide !!");
 }else if (tfprixc.getText().isEmpty()){
 System.out.println("prenom vide !!");
 }else if (tfamc.getText().isEmpty())
// else if (idCombotype.getSelectionModel().getSelectedItem().toString().isEmpty())
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
 }else{*/

  Evenements c = new Evenements(date_debut,prix, age_min,age_max,lieu_depart,lieu_arrive,equipements_ren,moyen_transport_ren,moyen_transport_t,sites_principeaux,equipements,date_fin);
 cs.insert(c);
 JOptionPane.showMessageDialog(null, "evenement ajoutee");
 Stage stage = (Stage) binsert.getScene().getWindow();
 stage.close();
 Stage Stage = new Stage();
 Parent root = FXMLLoader.load(getClass().getResource("/gui/events.fxml"));
 Stage.setScene(new Scene(root));
 Stage.show();
 
 
 
  
        
    }

    @FXML
    private void update(ActionEvent event) throws IOException {
        String equipements_ren="-";
 String sites_principeaux="-";
 String moyen_transport_ren="-";
  String moyen_transport_t="-";

 Timestamp date_debut = Timestamp.valueOf(tfddc.getText());
 Timestamp date_fin = Timestamp.valueOf(tfdfc.getText());
 int prix = Integer.parseInt(tfprixc.getText());
 int age_min = Integer.parseInt(tfamc.getText());
 int age_max = Integer.parseInt(tfamaxc.getText());
 String equipements = tfeqc.getText();
 String lieu_depart = tfldc.getText();
 String lieu_arrive = tflac.getText();
 int i = Integer.parseInt(tfidupdelc.getText());
 
   Evenements c = new Evenements(date_debut,prix, age_min,age_max,lieu_depart,lieu_arrive,equipements_ren,moyen_transport_ren,moyen_transport_t,sites_principeaux,equipements,date_fin);

cs.update(c, i);
JOptionPane.showMessageDialog(null, "evenement modifee");
Stage stage = (Stage) bupdate.getScene().getWindow();
  stage.close();
 Stage Stage = new Stage();
 Parent root = FXMLLoader.load(getClass().getResource("/gui/events.fxml"));      
   Stage.show();
    }

    @FXML
    private void delete(ActionEvent event) throws IOException {
     int i = Integer.parseInt(tfidupdelc.getText());
             cs.delete(i);
           Stage stage = (Stage) bdelete.getScene().getWindow();
          
        
        Stage Stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/gui/events.fxml"));
            //new
           
        JOptionPane.showMessageDialog(null, "evenement supprimé");
        
        Stage.show();
  
    }

    @FXML
    private void ddebcamp(ActionEvent event) {
    }

    @FXML
    private void amxc(ActionEvent event) {
    }

    @FXML
    private void dfincamp(ActionEvent event) {
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
    private void camping(Event event) {
    }

    @FXML
    private void searchr(ActionEvent event) {
    }

    @FXML
    private void insertr(ActionEvent event) {
    }

    @FXML
    private void updater(ActionEvent event) {
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
    private void ddebren(ActionEvent event) {
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
    private void insertt(ActionEvent event) {
    }

    @FXML
    private void updatet(ActionEvent event) {
    }

    @FXML
    private void deletet(ActionEvent event) {
    }

    @FXML
    private void ddebtour(ActionEvent event) {
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

//    private void getFromTableee() {
//      camptable.setOnMouseClicked(new EventHandler<MouseEvent>(){
// @Override
// public void handle(MouseEvent event){
// String ch="";
// c2 = camptable.getItems().get(camptable.getSelectionModel().getSelectedIndex()); 
// i = c2.getId_event();
// 
// tfddc.setText(c2.getDate_debut());
// tfnomauth.setText(c2.getNom_coach());
// tfprenoauth.setText(c2.getPrenom_coach());
// tfTypeauth.setText(c2.getType_coach());
// tfcontaauth.setText(c2.getContact());
// }
// });
// return i ;
//  
//    }


    @FXML
    private void idupdelr(ActionEvent event) {
    }

    @FXML
    private void idupdelt(ActionEvent event) {
    }
    }    

    