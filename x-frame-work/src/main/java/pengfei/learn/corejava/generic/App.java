package pengfei.learn.corejava.generic;

import com.baidu.bjf.remoting.protobuf.ProtobufIDLProxy;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class App<T extends List<String>> {

    public static void main(String[] args) throws IOException {


        //应还款日
        LocalDateTime dueDateLocalTime = LocalDateTime.of(2020, 7, 1, 0, 0, 0);
        //代偿时间点
        LocalDateTime timePoint = LocalDateTime.of(
                dueDateLocalTime.toLocalDate().plusDays(2),
                LocalTime.of(20, 30));
        LocalDateTime nowLocalDateTime = LocalDateTime.of(2020, 7, 2, 21, 26, 17);
        if (nowLocalDateTime.isAfter(dueDateLocalTime.plusDays(1))
                && nowLocalDateTime.isBefore(timePoint)) {
//                return true;
            System.out.println("11111");
        } else {

            System.out.println("22222");
        }
    }


}
