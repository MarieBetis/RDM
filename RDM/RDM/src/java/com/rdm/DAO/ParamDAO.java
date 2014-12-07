/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rdm.DAO;

import com.rdm.util.Connexion;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author usager
 */
public class ParamDAO {

    /**
     *
     * @return
     * @throws java.lang.ClassNotFoundException
     */
    public static Connection getConnection() throws ClassNotFoundException{
        Connexion.setUrl("jdbc:mysql://localhost/rdm?user=root");
        Class.forName("com.mysql.jdbc.Driver");


        return Connexion.getInstance();
    }
            
}
