import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * 这里是登录一个参数，有rul地址和输入的参数
 * 跟get相比 主要是多了3行代码
 * 建立一个输入的Printerwriter
 * 然后将参数写入PW
 * pw发送过去
 */
public class postDemo1 {
    public static void main(String[] args) throws IOException {
        String url1 = "http://www.newsmth.net/nForum/user/ajax_login.json";
        //建立连接
        //1.建立url对象
        //2.url调用方法，进行连接
        URL url = new URL(url1);
        URLConnection urlConnection = url.openConnection();
        urlConnection.setRequestProperty("accept", "*/*");
        urlConnection.setRequestProperty("connection", "Keep-Alive");
        urlConnection.setRequestProperty("user-agent",
                "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        urlConnection.setRequestProperty("Host","www.newsmth.net");
        urlConnection.setRequestProperty("Origin","http://www.newsmth.net");
        urlConnection.setRequestProperty("Referer","http://www.newsmth.net/nForum/");
        urlConnection.setRequestProperty("X-Requested-With","XMLHttpRequest");
        urlConnection.setConnectTimeout(5000);
        urlConnection.setReadTimeout(5000);
        urlConnection.setUseCaches(false);
        urlConnection.setDoOutput(true);
        urlConnection.connect();

        String param = "id=tortelee&passwd=lt19911218&mode=0&CookieDate=0";

        //这个就需要往服务器传递参数，传过去，因此用outputStream
        PrintWriter pw = new PrintWriter(urlConnection.getOutputStream());
        pw.print(param);  //将参数添加到输出流
        pw.flush(); // 清理掉 传过去

        //获取响应内容---正文内容，不是SessionID,也不是Cookie
        BufferedReader in = new BufferedReader(new InputStreamReader(
                urlConnection.getInputStream()));
        String line;
        while((line=in.readLine())!=null){
            String s = new String(line.getBytes(),"gbk");
            System.out.println(line);

        }
    }
}
