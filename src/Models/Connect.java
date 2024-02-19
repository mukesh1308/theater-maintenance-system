package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import Util.Env;

public class Connect {
    protected static Connection conn;
    protected static Statement statement;

    public static void getConnection() throws SQLException{
        conn=DriverManager.getConnection(Env.databaseURL, Env.databaseUser, Env.databasePassword);
        statement=conn.createStatement();
    }


    // private static Connection conn;
    // private Connect(){}
    // public static Connection getConnection() throws SQLException{
    //     if(conn==null){
    //         conn=DriverManager.getConnection(Env.databaseURL, Env.databaseUser, Env.databasePassword);
    //     }
    //     return conn;
    // }
}
