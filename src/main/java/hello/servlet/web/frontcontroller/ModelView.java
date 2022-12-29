package hello.servlet.web.frontcontroller;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ModelView {
    //JSP 파일 이름
    private String viewName;
    //회원들 저장
    private Map<String, Object> model = new HashMap<>();
    public ModelView(String viewName) {this.viewName = viewName;}
}
