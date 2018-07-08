/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javafx.application.Application;

/**
 *
 * @author Renzo
 */
public abstract class LibreriaStart extends Application {
    
    public LibreriaStart() {
        Login login = new Login();
        login.setVisible(true);
    }
    
    public static void main(String args[]) {
        Login login = new Login();
        login.setVisible(true);
    }
}
