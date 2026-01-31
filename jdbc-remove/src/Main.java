import db.DB;
import db.DbIntegrityException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DB.getConnection();
            ps = conn.prepareStatement(
                    "DELETE FROM department "
                            + "WHERE "
                            + "Id = ?");
            ps.setInt(1, 5);

            int rowsAffected = ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        }
    }

}