package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;



@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    //url : "/springmvc/v2/members/new-form"
    //@GetMapping("/new-form")
    @RequestMapping(value = "/new-form", method = RequestMethod.GET)
    public String newForm() {
        return "new-form";
    }

    //url : "/springmvc/v2/members/save"
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(
            @RequestParam("username") String username,
            @RequestParam("age") int age,
            Model model
    ) {
        //전달 받은 요청 정보를 저장소에 저장
        Member member = new Member(username, age);
        memberRepository.save(member);

        //JSP 파일명과 회원을 ModelView에 저장
        model.addAttribute("member",member);
        return "result";
    }

    //url : "/springmvc/v2/members"
    @RequestMapping(method = RequestMethod.GET)
    public String members(Model model) {
        //회원 모두 꺼내기
        List<Member> members = memberRepository.findAll();

        //모델에 JSP 파일명과 회원 정보 저장
        model.addAttribute("members", members);
        return "members";

    }

}
