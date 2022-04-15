/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abarc
 */
public class RememberUser {

    public void escribirArchivo(String user) {
        String archivo = "registro.txt";
        try (FileWriter arch = new FileWriter(archivo, true)) {
            arch.write(user+"\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String recuperaInfo() {
        BufferedReader obj = null;
        String strng="";
        String user = "";
        try {
            File doc = new File("registro.txt");
            obj = new BufferedReader(new FileReader(doc));
            while ((strng = obj.readLine()) != null) {
                if (strng != null) {
                    user = strng;
                }
            }   
            obj.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RememberUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RememberUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                obj.close();
            } catch (IOException ex) {
                Logger.getLogger(RememberUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return user;
    }

}
