package service;
import model.Result;
import model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserService implements UserServiceImpl {
//   search to list
    public Result search(String name, String password, List<User> userList) {
        Result result = new Result();
        if (!userList.isEmpty()){
            result.setMessage("Bunday foydalanuvchi ro'yxatdan o'tmagan");
            for (User user : userList) {
                if (user.getName().equals(name) && user.getPassword().equals(password)){
                    result.setMessage("Siz tizimga muvofqqiyatli kirdingiz !!!\n" + "User List.\n" + userList.toString());
                    result.setSituation(true);
                    return result;
                }
            }
        }else {
            result.setMessage("Tizimdan xechkim ro'yatdan o'tmagan !!!");
        }
        return result;
    }

//    Read to database
    public List<User> read() {
        Connection c = null;
        Statement stmt = null;
        List<User> userList = new ArrayList<User>();
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "admin", "123");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM USERS;" );
            while ( rs.next() ) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                userList.add(user);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        return userList;
    }

}
