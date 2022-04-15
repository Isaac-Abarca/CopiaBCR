/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.CambioVista;
import Models.ConnectionBD;
import Models.RememberUser;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author abarc
 */
public class LoginController implements Initializable {

    @FXML
    private Button btnLogin;
    @FXML
    private TextField txtUser;
    @FXML
    private CheckBox checkBoxRecordarUsuario;
    @FXML
    private CheckBox checkBoxLoginFacia;

    ConnectionBD conectar = new ConnectionBD();
    Connection con;

    RememberUser rU = new RememberUser();
    @FXML
    private PasswordField txtPasword;
    @FXML
    private Button btnMas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //cargarImgBtn();
        if (!"****".equals(rU.recuperaInfo())) {
            txtUser.setText(rU.recuperaInfo());
            checkBoxRecordarUsuario.setSelected(true);
        }

    }

    @FXML
    private void ActionLogin(ActionEvent event) {
        recordarUser();
        Entrar(event);
    }

    private void Entrar(ActionEvent event) {
        String usuario = txtUser.getText();
        String pasword = txtPasword.getText();
        if (!"".equals(usuario)) {
            if (!"".equals(pasword)) {
                comprobarUserAndPaswor(event, usuario, pasword);
            } else {
                JOptionPane.showMessageDialog(null, "No as ingresado una contraseña");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No as ingresado un usuario");
        }
    }

    private void comprobarUserAndPaswor(ActionEvent event, String usuario, String pasword) {
//        con = conectar.getConexion();
//       try {
//            String SQL = "select COUNT(id) AS I from usuarios where id = '"+usuario+"' and pasword = '"+pasword+"'";
//            Statement rt = con.createStatement();
//            ResultSet rs = rt.executeQuery(SQL);
//            while(rs.next()){
//                if (rs.getString("I").equals("1")) {
        CambioVista vs = new CambioVista();
        vs.cambioVista(event, "/view/ViewPrincipal.fxml");
//                }else{
//                    JOptionPane.showMessageDialog(null, "Error nombre de usuario o contaseña, incorrecto");
//                }
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al ejcutar la consutal"+ex.getMessage());
//        }
    }

    private void recordarUser() {
        if (checkBoxRecordarUsuario.isSelected()) {
            rU.escribirArchivo(txtUser.getText() + " ");
        } else {
            rU.escribirArchivo("****");
        }
    }

    private void cargarImgBtn() {
        URL linkMas = getClass().getResource("/img/mas.png");

        Image imgMas = new Image(linkMas.toString(), 50, 50, false, true);

        btnMas.setGraphic(new ImageView(imgMas));
    }

}
