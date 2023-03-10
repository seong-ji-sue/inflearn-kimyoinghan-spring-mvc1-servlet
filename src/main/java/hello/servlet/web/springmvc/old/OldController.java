package hello.servlet.web.springmvc.old;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component("/springmvc/old-controller")//빈의 이름을 URI로 지정한 것 뿐
public class OldController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequest");
        //Model을 반환하고 파일이름은 뷰 리졸버가 논리적인 이름으로 바꿔야함
        return new ModelAndView("new-form");
    }
}
