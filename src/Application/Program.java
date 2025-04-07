package Application;

import db.DB;
import db.DbIntegrityException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();
            st = conn.prepareStatement("DELETE from Department " +
                    "WHERE " +
                    "Id = ?");

            st.setInt(1, 5);
            int rowsAffected = st.executeUpdate();

            System.out.println("Pronto! Rows Affected: " + rowsAffected);
        }catch (SQLException e){
            throw new DbIntegrityException(e.getMessage());
        }finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }

    }
}   