package pengfei.learn.corejava.app;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AHCApp {
    public static void main(String[] args) {


        List<String> result = AHCApp.getRemoteWordsUnprivileged("http://localhost:8080/ext/dict/download/self.txt");
        System.out.println(result);


    }

    /**
     * 从远程服务器上下载自定义词条
     */
    public static List<String> getRemoteWordsUnprivileged(String location) {

        List<String> buffer = new ArrayList<String>();
        RequestConfig rc = RequestConfig.custom().setConnectionRequestTimeout(10 * 1000).setConnectTimeout(10 * 1000)
                .setSocketTimeout(60 * 1000).build();
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response;
        BufferedReader in;
        HttpGet get = new HttpGet(location);
        get.setConfig(rc);
        try {
            response = httpclient.execute(get);
            if (response.getStatusLine().getStatusCode() == 200) {

                String charset = "UTF-8";
                // 获取编码，默认为utf-8
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    Header contentType = entity.getContentType();
                    if (contentType != null && contentType.getValue() != null) {
                        String typeValue = contentType.getValue();
                        if (typeValue != null && typeValue.contains("charset=")) {
                            charset = typeValue.substring(typeValue.lastIndexOf("=") + 1);
                        }
                    }

                    if (entity.getContentLength() > 0) {
                        in = new BufferedReader(new InputStreamReader(entity.getContent(), charset));
                        String line;
                        while ((line = in.readLine()) != null) {
                            buffer.add(line);
                        }
                        in.close();
                        response.close();
                        return buffer;
                    }
                }
            }
            response.close();
        } catch (IllegalStateException | IOException e) {
        }
        return buffer;
    }
}
