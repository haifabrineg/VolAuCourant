/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vol_au_courant.test;



import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import vol_au_courant.entity.Evenements;
import vol_au_courant.service.EvenementsService;
import vol_au_courant.utils.MyDB;

/**
 *
 * @author haifa
 */
public class MainTest {

    /**t
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        MyDB.getInstance();
        Timestamp d = Timestamp.valueOf("2018-09-01 09:01:15");
         Timestamp d1 = Timestamp.valueOf("2020-09-01 09:01:15");
        Evenements e = new Evenements(d, 12,12, 12, "1234","rrrr", "rr", "rr", "rr", "rr", "rr", d1 );
        
        EvenementsService E = new EvenementsService ();
        E.update(e, 810);
      
      
 
                    
    }
    
}
