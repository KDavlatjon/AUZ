package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InserDb {
    public static void main(String args[]) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "admin", "123");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "INSERT INTO USERS (ID,NAME,PASSWORD) "
                    + "VALUES (1, 'Davlatjon', '123');";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO USERS (ID,NAME,PASSWORD) "
                    + "VALUES (2, 'Anvar', '1234');";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO USERS (ID,NAME,PASSWORD) "
                    + "VALUES (3, 'Sobir', '12345');";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO USERS (ID,NAME,PASSWORD) "
                    + "VALUES (4, 'Anvar', '134');";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }
}