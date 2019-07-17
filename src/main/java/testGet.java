import java.io.IOException;

/**
 * 百度是TCP链接，不是http协议
 */
public class testGet {
    public static void main(String[] args) throws IOException {
        String url = "www.baidu.com";
        String parm = "abc";
        String xiangying = GetDemo1.sendGet(url,parm);
        System.out.println(xiangying);
    }
}
