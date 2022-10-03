package br.com.gw_sistemas.transportadora_wwg.nucleo.base.conection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class conexaoBD {

     public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        String driver = "org.postgresql.Driver";
        String url = "jdbc:postgresql://localhost:5432/transportadoraWWG";
        String login = "postgres";
        String password = "postgres";
        Connection con = null;

        try {
            Class.forName(driver).newInstance();
        } catch (InstantiationException ex) {
            Logger.getLogger(conexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(conexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        con = DriverManager.getConnection(url);

        return con;

    }
}
