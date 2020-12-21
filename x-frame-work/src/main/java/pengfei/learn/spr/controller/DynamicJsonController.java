package pengfei.learn.spr.controller;

import com.google.common.collect.Lists;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author supengfei
 */
@RestController
@RequestMapping("dy")
public class DynamicJsonController {

    @RequestMapping("greet")
    public List<Greeting> say(@RequestBody Greeting greeting) {
        return Lists.newArrayList(greeting);
    }


    @Getter
    @Builder
    @ToString
    public static class Greeting {
        private Integer code;
        private String name;
        private Long blc;
    }
}
