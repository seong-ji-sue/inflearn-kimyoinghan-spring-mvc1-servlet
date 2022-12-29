package hello.servlet.web.frontcontroller.v4;

import hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV4 {
    //Model을 만들지 않고 프론트 컨트롤러에서 생성한다.
    String process(Map<String,String> paramMap,Map<String,Object> model);
}
