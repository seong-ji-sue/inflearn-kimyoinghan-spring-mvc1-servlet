package hello.servlet.web.springmvc.v2;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/springmvc/v2/members")
public class SpringMemberControllerV2 {
    private MemberRepository memberRepository = MemberRepository.getInstance();


    //url : "/springmvc/v2/members/new-form"
    @RequestMapping("/new-form")
    public ModelAndView newForm() {
        return new ModelAndView("new-form");
    }

    //url : "/springmvc/v2/members/save"
    @RequestMapping("/save")
    public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {
        //전달 받은 요청 정보를 저장소에 저장
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        Member member = new Member(username, age);
        memberRepository.save(member);

        //JSP 파일명과 회원을 ModelView에 저장
        ModelAndView mv = new ModelAndView("save-result");
        mv.addObject("member",member);
        return mv;
    }

    //url : "/springmvc/v2/members"
    @RequestMapping
    public ModelAndView members() {
        //회원 모두 꺼내기
        List<Member> members = memberRepository.findAll();

        //모델에 JSP 파일명과 회원 정보 저장
        ModelAndView mv = new ModelAndView("members");
        mv.addObject("members", members);
        return mv;

    }




}
