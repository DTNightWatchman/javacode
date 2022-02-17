/**
 * created by YT
 * description:
 * User:lenovo
 * Data:2022-02-16
 * Time:15:13
 */
public class ExitOperation implements IOperation{
    @Override
    public void work() {
        System.out.println("退出");
        System.exit(0);
    }
}
