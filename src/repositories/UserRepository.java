package repositories;

import models.User;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {

    private static UserRepository userRepository = new UserRepository();

    private UserRepository() {
    }

    public static UserRepository getInstance() {
        return userRepository;
    }

    public void registerUser(User c) {
        String query = "INSERT INTO user (`cfirstname`, `clastname`, `pass`, `username`) VALUES (?, ?, ?, ?);";
        try (Connection con = DBUtils.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, c.getFirstName());
            ps.setString(2, c.getLastName());
            ps.setString(3, c.getPassword());
            ps.setString(4, c.getUsername());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public User login(String username, String password) {
        User c = null;
        String query = "SELECT * FROM user WHERE username=? AND pass=?";
        try (Connection con = DBUtils.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                c = new User(rs.getString(2), rs.getString(3), rs.getString(4));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return c;
    }

}
