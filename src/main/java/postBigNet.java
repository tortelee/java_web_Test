import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.net.URL;
import java.net.URLConnection;

public class postBigNet {
    public static void main(String[] args) throws IOException {
        String url1 = "http://bbs1.netbig.com/member.php?mod=logging&action=login&loginsubmit=yes&infloat=yes&lssubmit=yes&inajax=1";
        URL url = new URL(url1);
        URLConnection urlConnection = url.openConnection();

        urlConnection.setRequestProperty("Referer","http://bbs1.netbig.com/");
        urlConnection.setRequestProperty("Cache-Control"," max-age=0");
        urlConnection.setRequestProperty("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        urlConnection.setRequestProperty("Accept-Language","zh-CN");
        urlConnection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
        urlConnection.setRequestProperty("User-Agent"," Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.140 Safari/537.36 Edge/18.17763");
        urlConnection.setRequestProperty("Accept-Encoding"," gzip, deflate");
        urlConnection.setRequestProperty("Host","bbs1.netbig.com");
        urlConnection.setRequestProperty("Connection","Keep-Alive");
        urlConnection.setRequestProperty("Cookie"," UM_distinctid=16be574bacb75-0315e4aa881b5e-784a5935-144000-16be574bacd17a0; _gid=GA1.2.1156518491.1563173790; _ga=GA1.2.725017131.1562922765; CNZZDATA3360021=cnzz_eid%3D237686837-1563177116-http%253A%252F%252Fbbs1.netbig.com%252F%26ntime%3D1563234106; Hm_lvt_6267796f6ffa0f5cc37dcf252d42467e=1563173787,1563178465,1563198874,1563239437; p7Ao_2132_connect_is_bind=0; p7Ao_2132_lastvisit=1563174829; p7Ao_2132_ulastactivity=c1fbKRLswaWbktwvaLoeUy76sXH%2BwGbQOlgfdQLQnxBAyHvQrWOl; p7Ao_2132_sid=EFFguL; p7Ao_2132_saltkey=aA7xbXkF; p7Ao_2132_lastact=1563239385%09like.php%09; __tins__4347382=%7B%22sid%22%3A%201563239436313%2C%20%22vd%22%3A%201%2C%20%22expires%22%3A%201563241236313%7D; __51cke__=; __51laig__=1; p7Ao_2132_sendmail=1; Hm_lpvt_6267796f6ffa0f5cc37dcf252d42467e=1563239437");
        urlConnection.setRequestProperty("Content-Length","95");
        urlConnection.setConnectTimeout(5000);
        urlConnection.setReadTimeout(5000);
        urlConnection.setUseCaches(false);
        urlConnection.setDoOutput(true);
        urlConnection.connect();

        //发送内容
        PrintWriter pw = new PrintWriter(urlConnection.getOutputStream());
        pw.print("fastloginfield=username&username=weusewindows&password=lt19911218&quickforward=yes&handlekey=ls");
        pw.flush();

        //获得响应结果
        BufferedReader bf = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String line=null;
        while((line=bf.readLine())!=null){
            int ss = line.indexOf("退出");
            System.out.println(ss);
            System.out.println(line);
        }

    }
}
