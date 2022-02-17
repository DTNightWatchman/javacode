import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * created by YT
 * description:
 * User:lenovo
 * Data:2022-02-14
 * Time:12:06
 */
public class UserDao {
    public static User GetUserByName(String name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from user where name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            resultSet = preparedStatement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                Boolean  isAdmin = resultSet.getInt("isAdmin") == 1;
                if(isAdmin) {
                    user = new Admin();
                } else {
                    user = new NormalUser();
                }
                user.setUserId(resultSet.getInt("userId"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                return user;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("查找用户失败");
        return null;
    }
}
