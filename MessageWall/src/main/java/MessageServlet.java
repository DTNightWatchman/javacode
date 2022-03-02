import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.internal.util.xml.impl.Input;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * created by YT
 * description:
 * User:lenovo
 * Data:2022-03-02
 * Time:15:39
 */
class Message {
    public String from;
    public String to;
    public String say;

    @Override
    public String toString() {
        return "Message{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", say='" + say + '\'' +
                '}';
    }
}
@WebServlet("/message")
public class MessageServlet extends HttpServlet {
    private List<Message> list = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");
        //获取到表白列表
        ObjectMapper objectMapper = new ObjectMapper();
        //这里的是一个List类型，所以转换后的类型就是[{},{},{}]这样的格式
        String json = objectMapper.writeValueAsString(list);
        //将json格式的数据作为body返回
        resp.getWriter().write(json);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        Message message = objectMapper.readValue(req.getInputStream(),Message.class);
        list.add(message);
        System.out.println(message.toString());
        System.out.println(list);
        resp.getWriter().write("insert OK");
    }
}
