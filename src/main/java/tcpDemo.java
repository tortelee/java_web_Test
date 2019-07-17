import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 模拟一个客户端，实现三个事情：
 *     1，建立连接  3次握手
 *     2保证数据传输可靠性
 *     3，关闭连接  4次挥手
 *
 */
public class tcpDemo {


    public static void main(String[] args) throws IOException {
        //1，建立TCP连接 1）IP地址 2）端口号
        String ip = "www.baidu.com";
        int port =80;
        Socket socket = new Socket(ip,port);

        //2 传输内容
        String content ="this is contents";
        byte[] bytes= content.getBytes();  //网络传输字节流
        //  传递给对方
        OutputStream os = socket.getOutputStream(); //建立输出流
        os.write(bytes);


        //3 关闭TCP连接
        socket.close();

    }
}
