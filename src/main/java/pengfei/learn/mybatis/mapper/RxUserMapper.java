package pengfei.learn.mybatis.mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import pengfei.learn.hibernate.domain.RxUserEntity;

import java.util.Collection;

public interface RxUserMapper {

    String SELECT_BY_ID = "SELECT * FROM DEV.RX_USER WHERE ID = #{ID}";
    String SELECT_ALL = "SELECT * FROM DEV.RX_USER";

    @Select(SELECT_BY_ID)
    RxUserEntity getUser();

    @Select(SELECT_ALL)
    @Results(value = {
            @Result(column = "mobile_number", property = "mobileNumber"),
            @Result(column = "last_login", property = "lastLogin"),
            @Result(column = "nick_name", property = "nickName"),
            @Result(column = "gender", property = "gender"),
            @Result(column = "is_admin", property = "isAdmin")
    })
    Collection<RxUserEntity> selectAll();

//    id	int(11)	NO	PRI		auto_increment
//    password	varchar(128)	NO
//    last_login	datetime	NO
//    nick_name	varchar(40)	YES
//    mobile_number	varchar(20)	NO	UNI
//    register_dt	datetime	NO
//    date_of_birth	datetime	NO
//    update_dt	datetime	NO
//    is_admin	tinyint(1)	NO
//    gender	varchar(1)	NO
}
