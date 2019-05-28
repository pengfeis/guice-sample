package pengfei.learn.feignsvc;

import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;

public class SayApp {

    public static void main(String[] args) {

        SayService svc = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .logger(new Slf4jLogger(SayService.class))
                .logLevel(Logger.Level.FULL)
                .target(SayService.class, "http://localhost:8888/");
        SayResp jjj = svc.contributors("jjj", "110", "411481");
        System.out.println(jjj);
    }
}
