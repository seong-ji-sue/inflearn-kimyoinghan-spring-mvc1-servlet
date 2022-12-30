package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.ModelView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MyHandlerAdapter {
    //받은 핸들러(컨트롤러)가 어뎁터(컨트롤러 구분)에 맞는지 체크
    boolean support(Object handler);
    //요청 파라미터를 처리하고 컨트롤러를 실행하여 ModelView 을 반환
    ModelView handler(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws ServletException, IOException;
}
