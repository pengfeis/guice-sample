package algorithm;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author pengfeisu
 */
@Getter
@Setter
@ToString
public class SomeHowVo implements Comparable<SomeHowVo>{
    private String code;
    private String name;
    private Integer age;

    public SomeHowVo(String code, String name, Integer age) {
        this.code = code;
        this.name = name;
        this.age = age;
    }


    @Override
    public int compareTo(SomeHowVo o) {
        return 0;
    }
}
