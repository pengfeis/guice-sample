package pengfei.learn.httpreq;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.util.Map;

public class HttpClientUtil {

//    static class CmHolder {
//        private static PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
//    }


    public static final HttpClient getClient(String url) {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(200);
        cm.setDefaultMaxPerRoute(20);
        HttpHost httpHost = new HttpHost(url, 80);
        cm.setMaxPerRoute(new HttpRoute(httpHost), 50);
        return HttpClients.custom().setConnectionManager(cm).build();
    }


    public static String doGet(String url, Map<String, String> params) {





        return "";
    }

    public static String doPost(String url, Map<String, String> params) {
        return "";
    }







    public static final String getStrResponse(Map<String, String> paramMap) {
        if (paramMap != null && !paramMap.isEmpty()) {

        }

        return JSONObject.toJSONString("");
    }



}
