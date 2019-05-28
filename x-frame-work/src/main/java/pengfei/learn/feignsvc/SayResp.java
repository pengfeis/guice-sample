package pengfei.learn.feignsvc;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


/**
 * @author pengfeisu
 */
@Getter
@Setter
@ToString
public class SayResp implements Serializable {
    private Integer resultCode;
    private String resultMsg;
    private Object data;
}
