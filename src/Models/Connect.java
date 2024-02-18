package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import Util.Env;

public class Connect {
    protected static Connection conn;
    protected static Statement statement;
    private Connect(){}

    public static void getConnection() throws SQLException{
        conn=DriverManager.getConnection(Env.databaseURL, Env.databaseUser, Env.databasePassword);
        statement=conn.createStatement();
    }
    
}
