package pengfei.learn.feignsvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Feign;
import feign.Logger;
import feign.form.FormEncoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.util.Map;

public class FeignApp {


    private static final String API_ID = "go";
    private static final String API_SECRET = "go";


    public static void main(String[] args) throws JsonProcessingException {


        UploadService svc = Feign.builder()
                .encoder(new FormEncoder(new JacksonEncoder()))
                .decoder(new JacksonDecoder())
                .logger(new Slf4jLogger(UploadService.class))
                .logLevel(Logger.Level.FULL)
                .target(UploadService.class, "https://cloudapi.linkface.cn");




        VideoParam v = new VideoParam();
        v.setMotions("YAW");
        v.setComplexity(0);
        v.setAnti_hack(false);
        v.setLiveness_data_url("https://file11info.ppdai.com/85e1c7c222c24b58a8ff92e34dc5b4df.MOV");
        v.setApi_id(API_ID);
        v.setApi_secret(API_SECRET);

        Map<String, Object> video = svc.video(v);
        System.out.println(new ObjectMapper().writeValueAsString(video));
    }

    @Setter
    @Getter
    public static class VideoParam {
        private String api_id;
        private String api_secret;
        private String motions;
        private Integer complexity;
        private Boolean anti_hack;
        private File liveness_data_file;
        private String liveness_data_url;

    }
}
