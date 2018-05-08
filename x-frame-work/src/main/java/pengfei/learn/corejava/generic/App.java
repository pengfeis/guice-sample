package pengfei.learn.corejava.generic;

import com.baidu.bjf.remoting.protobuf.ProtobufIDLProxy;
import com.google.common.io.ByteSource;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class App<T extends List<String>> {

    public static void main(String[] args) throws IOException {
        InputStream is = Files.asByteSource(new File("/Users/pengfeisu/IdeaProjects/guice-sample/x-frame-work/src/proto/person.proto")).openStream();
        // generateProtobufDefinedForField
        ProtobufIDLProxy.generateSource(is, new File("."));
    }



}
