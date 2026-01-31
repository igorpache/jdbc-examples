import db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        Connection conn = null; //connects to the database
        Statement st = null; //query to retrieve the data
        ResultSet rs = null; //query result saved here

        try {
            conn = DB.getConnection();

            st = conn.createStatement();

            rs = st.executeQuery("select * from department");

            while(rs.next())
            {
                System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));

            }
        }
        catch (SQLException error)
        {
            error.printStackTrace();
        }
        finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}