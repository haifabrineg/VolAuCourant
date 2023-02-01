/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vol_au_courant.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.IOException;


/**
 *
 * @author haifa
 */
public class NewFXMain extends Application {
    
    
    @Override
    public void start(Stage Stage) throws IOException {
        
            Parent root = FXMLLoader.load(getClass().getResource("events.fxml"));
            //new
           Scene scene = new Scene(root);
        
        
        Stage.setScene(scene);
        Stage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }


    /**
     * @param args the command line arguments
     */
}
