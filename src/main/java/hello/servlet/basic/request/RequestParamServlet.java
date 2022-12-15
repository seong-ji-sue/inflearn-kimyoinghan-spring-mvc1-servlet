package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * URL GET POST HTML TEST
 * localhost:8080/request-param?username=hello&age=20
 */

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("파라미터 조회 시작");
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName ->
                        System.out.println(paramName + "=" + request.getParameter(paramName))
                );
        System.out.println("파라미터 조회 끝");
        System.out.println("단일 조회 시작");
        String username = request.getParameter("username");
        System.out.println("username = " + username);
        System.out.println("단일 조회 끝");

        System.out.println("이름이 같은 복수 파라미터 조회시작");
        String[] usernames = request.getParameterValues("username");
        for (String name : usernames) {
            System.out.println(name);
        }
        System.out.println("이름이 같은 복수 파라미터 조회끄");

        response.getWriter().write("ok");
    }
}
