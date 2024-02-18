package Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Resources.LanguageDTO;

public class LanguageDAO extends Connect{
    private static LanguageDAO instance;

    private LanguageDAO(){}

    public static LanguageDAO getInstance(){
        if(instance==null){
            instance=new LanguageDAO();
        }
        return instance;
    }
    public ArrayList<LanguageDTO> getLanguage() throws SQLException{
        ArrayList<LanguageDTO> arr=new ArrayList<>();
        ResultSet res=statement.executeQuery("SELECT * FROM languages");
        while(res.next()){
            arr.add(new LanguageDTO(res.getInt(1), res.getString(2)));
        }
        return arr;
    }
}
