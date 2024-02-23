package Models;

import java.sql.ResultSet;
import java.sql.SQLException;

import Resources.ScreenDTO;

public class ScreenDAO extends Connect{
    private static ScreenDAO instance;
    private ScreenDAO() throws SQLException{

    }

    public static ScreenDAO getInstance() throws SQLException{
        if(instance==null){
            instance=new ScreenDAO();
        }
        return instance;
    }

    public ScreenDTO getById(int id) throws SQLException{
        ResultSet res=statement.executeQuery("SELECT * FROM screen_types WHERE screen_type_id=(SELECT screen_type_id FROM screen WHERE screen_id="+id+")");
        if(res.next()){
            return new ScreenDTO(res.getString(2), res.getInt(3), res.getInt(4));
        }
        return null;
    }
}
