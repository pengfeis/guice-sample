package pengfei.learn.feignsvc;

import feign.Headers;
import feign.RequestLine;

import java.util.Map;

public interface UploadService {
    @RequestLine("POST /liveness/check_liveness")
//    @Headers("Content-Type: application/x-www-form-urlencoded")
//    @Headers("Content-Type: application/x-www-form-urlencoded")
    @Headers("Content-Type: application/json")
    Map<String, Object> video(FeignApp.VideoParam param);
}


