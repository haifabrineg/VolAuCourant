/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vol_au_courant.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import vol_au_courant.entity.Evenements;

/**
 *
 * @author haifa
 */
public interface Services <T> {
    void insert(T object);
    void update(T object, int id);
    void delete(int id);
    List FindAll();
    List rechercher(int prix);
    List rechercher(Timestamp t);
    List rechercher(Timestamp t,Timestamp d);
    List rechercher(int t,int d);
    List rechercher(String lieu);
    
}
