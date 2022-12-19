<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    //request, response 사용사능
    MemberRepository memberRepository = MemberRepository.getInstance();
    //복사한 코드(MemberSaveServlet)
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    //객체에 저장
    Member member = new Member(username, age);
    memberRepository.save(member);
%>

<html>
<head>
    <title>회원가입 실행 폼</title>
</head>
<body>
성공
<ul>
    <li>id<%=member.getId()%></li>
    <li>username<%=member.getUsername()%></li>
    <li>age<%=member.getAge()%></li>
</ul>
<a href="/index.html">메인</a>

</body>
</html>
