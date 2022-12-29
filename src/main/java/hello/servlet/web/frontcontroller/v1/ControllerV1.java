package hello.servlet.web.frontcontroller.v1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 컨트롤러를 하나의 인터페이스로 다형성을 구현하기 위해
 * 사용합니다.
 */
public interface ControllerV1 {
    //컨트롤러마다 무조건 구현해야 하는 메서드
    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
