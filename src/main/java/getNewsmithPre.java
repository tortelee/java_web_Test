import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * 连接水木社区，进行一次get请求，然后得到返回的数据
 */
public class getNewsmithPre {
    public static void main(String[] args) throws IOException {
        String url1 = "http://www.newsmth.net/";
        //建立连接
        //1.建立url对象
        //2.url调用方法，进行连接
        URL url = new URL(url1);
        URLConnection urlConnection = url.openConnection();

        //urlconnect进行设置参数
        urlConnection.setRequestProperty("Accept","*/*");
        urlConnection.setRequestProperty("Accept-Encodingt","gzip, deflate");
        urlConnection.setRequestProperty("Connection","Keep-Alive");
        urlConnection.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        //进行连接
        urlConnection.connect();
        //获取响应的信息
        Map<String,List<String>> response = urlConnection.getHeaderFields();
        for(String key:response.keySet()){
            System.out.println("Key:"+key);
            System.out.println("value:"+response.get(key));
            System.out.println("---");
        }

    }
}
