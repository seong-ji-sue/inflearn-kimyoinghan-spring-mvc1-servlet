package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {
    //MyView 대신 ModelView를 반환하고 Servlet 기능을 수행하지 않는다.
    ModelView process(Map<String,String> paramMap);
}
