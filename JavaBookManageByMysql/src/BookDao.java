import javafx.beans.binding.BooleanBinding;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * created by YT
 * description:
 * User:lenovo
 * Data:2022--
 * Time:18:24
 */
public class BookDao {
    //增
    public static Boolean AddBook(book book){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "insert into book values(null,?,?,?,?,0)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,book.getName());
            preparedStatement.setString(2,book.getAutor());
            preparedStatement.setInt(3,book.getPrice());
            preparedStatement.setString(4,book.getType());
            int ret = preparedStatement.executeUpdate();
            if(ret == 1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return false;
    }
    //查看全部
    public static List<book> ShowBooks() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<book> list = new ArrayList<>();
        try {
            String sql = "select * from book";
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                book book = new book();
                book.setBookId(resultSet.getInt("bookId"));
                book.setName(resultSet.getString("name"));
                book.setAutor(resultSet.getString("author"));
                book.setPrice(resultSet.getInt("price"));
                book.setType(resultSet.getString("type"));
                book.setIsBorrowed(resultSet.getInt("isBorrowed"));
                list.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return list;
    }
    //查(根据书名)
    public static List<book> FindBook(String name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<book> list = new ArrayList<>();
        try {
            String sql = "select * from book where name = ?";
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                book book = new book();
                book.setBookId(resultSet.getInt("bookId"));
                book.setName(resultSet.getString("name"));
                book.setAutor(resultSet.getString("author"));
                book.setPrice(resultSet.getInt("price"));
                book.setType(resultSet.getString("type"));
                book.setIsBorrowed(resultSet.getInt("isBorrowed"));
                list.add(book);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return list;
    }
    //指定ID删除
    public static boolean DeleteBook(int bookId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "delete from book where bookId = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,bookId);
            int ret = preparedStatement.executeUpdate();
            if(ret != 1) {
                return false;
            } else {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return false;
    }
    //指定名字删除
    public static Boolean DeleteBook(String name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "delete from book where name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            int ret = preparedStatement.executeUpdate();
            if(ret >= 1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    //借书、修改操作
    public static Boolean BorrowBook(int bookId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1 = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from book where bookId = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,bookId);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                int isBorrow = resultSet.getInt("isBorrowed");
                if (isBorrow == 1) {
                    System.out.println("此书已借出");
                    return false;
                }
            } else {
                System.out.println("书不存在，借书失败");
                return false;
            }
            sql = "update book set isBorrowed = 1 where bookId = ?";
            preparedStatement1 = connection.prepareStatement(sql);
            preparedStatement1.setInt(1,bookId);
            int ret = preparedStatement1.executeUpdate();
            if(ret != 1) {
                System.out.println("借书失败");
                return false;
            }
            System.out.println("借书成功！");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement1 != null) {
                try {
                    preparedStatement1.close();
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
        return false;
    }
    //还书
    public static boolean ReturnBook(int bookId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1 = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from book where bookId = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,bookId);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                int isBorrowed = resultSet.getInt("isBorrowed");
                if(isBorrowed == 0) {
                    System.out.println("该书未被借出，不能归还");
                    return false;
                }
            } else {
                System.out.println("没有此书，不能归还");
                return false;
            }
            sql = "update book set isBorrowed = 0 where bookId = ?";
            preparedStatement1 = connection.prepareStatement(sql);
            preparedStatement1.setInt(1,bookId);
            int ret = preparedStatement1.executeUpdate();
            if(ret != 1) {
                System.out.println("还书失败");
                return false;
            } else {
                System.out.println("还书成功");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("还书失败");
        return false;
    }
}
