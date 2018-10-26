package com.ynt.mediaquality.modeanalyze.protobuf;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.EnumReadable;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
public class PersonJProtoBufProtoClass {
@Protobuf(fieldType=FieldType.INT32, order=1, required=false)
public Integer id;
@Protobuf(fieldType=FieldType.STRING, order=2, required=false)
public String name;
@Protobuf(fieldType=FieldType.STRING, order=3, required=false)
public String email;
}
