package hello.servlet.basic;

import lombok.Getter;
import lombok.Setter;

/**
 * JSON-> 객체로 파싱하기 위함
 */
@Getter
@Setter
public class HelloData {
    private String username;
    private int age;
}
