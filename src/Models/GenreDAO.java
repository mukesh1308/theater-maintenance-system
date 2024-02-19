package Models;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Resources.GenreDTO;

public class GenreDAO extends Connect{
    private static GenreDAO instance;
    // private Connection conn;
    // private Statement statement;
    private GenreDAO() throws SQLException{
        // conn=Connect.getConnection();
        // statement=conn.createStatement();
    }

    public static GenreDAO getInstance() throws SQLException{
        if(instance==null){
            instance=new GenreDAO();
        }
        return instance;
    }

    public ArrayList<GenreDTO> getGenre() throws SQLException{
        ResultSet res=statement.executeQuery("SELECT * FROM genres");
        ArrayList<GenreDTO> arr=new ArrayList<>();
        while(res.next()){
            arr.add(new GenreDTO(res.getInt(1), res.getString(2)));
        }
        return arr;
    }
}
