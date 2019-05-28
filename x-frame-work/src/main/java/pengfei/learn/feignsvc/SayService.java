package pengfei.learn.feignsvc;

import feign.Param;
import feign.RequestLine;

/**
 * @author pengfeisu
 */
public interface SayService {

    /**
     * 获取三要素信息
     *
     * @param name
     * @param mobile
     * @param idNum
     * @return
     */
    @RequestLine("GET /hello/{name}/{mobile}/{idNum}")
    SayResp contributors(@Param("name") String name, @Param("mobile") String mobile, @Param("idNum") String idNum);

}
