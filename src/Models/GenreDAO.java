package Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Resources.GenreDTO;

public class GenreDAO extends Connect{
    private static GenreDAO instance;
    private GenreDAO(){}

    public static GenreDAO getInstance(){
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
