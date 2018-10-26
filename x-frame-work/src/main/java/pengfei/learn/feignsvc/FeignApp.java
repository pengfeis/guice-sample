package pengfei.learn.feignsvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import feign.Feign;
import feign.Logger;
import feign.form.FormEncoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;

import java.io.File;
import java.util.Map;

public class FeignApp {
    public static void main(String[] args) throws JsonProcessingException {


        UploadService svc = Feign.builder()
                .encoder(new FormEncoder(new JacksonEncoder()))
                .decoder(new JacksonDecoder())
                .logger(new Slf4jLogger(UploadService.class))
                .logLevel(Logger.Level.FULL)
                .target(UploadService.class, "https://cloudapi.linkface.cn");


        VideoParam v = new VideoParam();
        v.setMotions("MOUTH");
        v.setComplexity(0);
        v.setAnti_hack(false);
        v.setLiveness_data_file(new File("/Users/pengfeisu/Documents/pengfeis-mouth.mp4"));

        Map<String, Object> video = svc.video(v, new File("/Users/pengfeisu/Documents/pengfeis-mouth.mp4"));
        System.out.println(new ObjectMapper().writeValueAsString(video));
    }

    public static class VideoParam {
        public String getApi_id() {
            return api_id;
        }

        public void setApi_id(String api_id) {
            this.api_id = api_id;
        }

        public String getApi_secret() {
            return api_secret;
        }

        public void setApi_secret(String api_secret) {
            this.api_secret = api_secret;
        }

        public String getMotions() {
            return motions;
        }

        public void setMotions(String motions) {
            this.motions = motions;
        }

        public Integer getComplexity() {
            return complexity;
        }

        public void setComplexity(Integer complexity) {
            this.complexity = complexity;
        }

        public Boolean getAnti_hack() {
            return anti_hack;
        }

        public void setAnti_hack(Boolean anti_hack) {
            this.anti_hack = anti_hack;
        }

        private String api_id;
        private String api_secret;
        private String motions;
        private Integer complexity;
        private Boolean anti_hack;

        public File getLiveness_data_file() {
            return liveness_data_file;
        }

        public void setLiveness_data_file(File liveness_data_file) {
            this.liveness_data_file = liveness_data_file;
        }

        private File liveness_data_file;

    }
}
