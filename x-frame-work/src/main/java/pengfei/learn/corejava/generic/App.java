package pengfei.learn.corejava.generic;

import com.baidu.bjf.remoting.protobuf.ProtobufIDLProxy;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.List;

public class App<T extends List<String>> {

    public static void main(String[] args) throws IOException {

        String path = Paths.get(".").toAbsolutePath().normalize().toString();
        System.out.println(path);

        InputStream is = Files.asByteSource(new File("src/proto/person.proto")).openStream();
        // generateProtobufDefinedForField
        ProtobufIDLProxy.generateSource(is, new File("."));
    }


}
