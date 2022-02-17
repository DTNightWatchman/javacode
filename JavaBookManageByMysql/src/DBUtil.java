import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * created by YT
 * description:
 * User:lenovo
 * Data:2022-03-03
 * Time:0:53
 */
public class DBUtil {
    private static String url = "jdbc:mysql://127.0.0.1:3306/javabookmanage?characterEncoding=utf8 && useSSL = false";
    private static String userName = "root";
    private static String password = "1111";
    private static DataSource dataSource = new MysqlDataSource();
    static {
        ((MysqlDataSource)dataSource).setURL(url);
        ((MysqlDataSource)dataSource).setUser(userName);
        ((MysqlDataSource)dataSource).setPassword(password);
    }
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
