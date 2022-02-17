import jdk.nashorn.internal.ir.SplitReturn;

/**
 * created by YT
 * description:
 * User:lenovo
 * Data:2022-03-03
 * Time:0:35
 */
public abstract class User {
    private int userId;
    private String name;
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    IOperation[] iOperation;
    public abstract int menu();

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
