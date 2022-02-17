import java.util.Scanner;

/**
 * created by YT
 * description:
 * User:lenovo
 * Data:2022-02-16
 * Time:23:39
 */
public class Main {
    public static void main(String[] args) {
        User user = login();
        //这里可以这样使用，但是太麻烦，可以直接使用多态
//        if(user instanceof NormalUser) {
//            System.out.println("普通用户");
//        } else if(user instanceof Admin) {
//            System.out.println("管理员");
//        }
        while (true) {
            //使用多态来选择调用哪个menu
            int choice = user.menu();
            user.iOperation[choice].work();
        }
    }

    private static User login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入你的用户名:>");
        String userName = scanner.next();
        System.out.print("请输入账号对应的密码:>");
        String userPassword = scanner.next();
        User user = UserDao.GetUserByName(userName);
        if(user == null) {
            System.out.println("账号或密码错误");
            System.exit(0);
        }
        if(!user.getPassword().equals(userPassword)) {
            System.out.println("账号或密码错误");
            System.exit(0);
        }
        return user;
    }
}
