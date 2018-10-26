package pengfei.learn.feignsvc;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

import java.io.File;
import java.util.Map;

public interface UploadService {
    @RequestLine("POST /liveness/check_liveness")
    @Headers("Content-Type: multipart/form-data")
    Map<String, Object> video(@QueryMap FeignApp.VideoParam param, @Param("liveness_data_file") File liveness_data_file);
}


