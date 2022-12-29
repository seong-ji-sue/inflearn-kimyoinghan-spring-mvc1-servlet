package hello.servlet.web.frontcontroller.v1;

import hello.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberListControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberSaveControllerV1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * 프론트 컨트롤러 - 모든 요청을 하나의 컨트롤러로 처리
 */
@WebServlet(name = "frontControllerServletV1",urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {

    //모든 컨트롤러 인스턴스 보관소
    private Map<String, ControllerV1> controllerMap = new HashMap<>();

    //프론트 컨트롤러 생성 시 모든 컨트롤러 인스턴스 저장
    public FrontControllerServletV1() {
        controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //요청 URI 꺼내기
        String requestURL = request.getRequestURI();

        //맞는 컨트롤 객체 꺼내기
        ControllerV1 controller = controllerMap.get(requestURL);

        //예외처리 - 컨트롤러가 없다면
        if(controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //컨트롤러 실행
        controller.process(request, response);
    }
}
