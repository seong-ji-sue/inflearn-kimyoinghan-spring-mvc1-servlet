package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * V3는 ModelView를 사용합니다
 * V4에 대한 부분은 좀 더 생각해봅니다.
 */
public class ControllerV3HandlerAdapter implements MyHandlerAdapter {

    //핸들러(컨트롤러)가 헨들러 어뎁터(인스턴스)에 맞는지 체크
    @Override
    public boolean support(Object handler) {
        return (handler instanceof ControllerV3);
    }

    //요청파라미터 처리와 모델뷰 저장 반환
    @Override
    public ModelView handler(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        //위에 support 메서드에서 해당 타입이 맞는지 체크 했기 때문에 케스팅 가능
        ControllerV3 controller = (ControllerV3) handler;

        //요청 파라미터 저장
        Map<String, String> paramMap = createParamMap(request);

        //컨트롤러 수행해서 ModelView 반환
        ModelView mv = controller.process(paramMap);
        return mv;
    }

    //요청 파라미터 저장소 생성 및 요청 정보 저장
    private static Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();

        //요청 파라미터 정보 저장소에 저장
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
