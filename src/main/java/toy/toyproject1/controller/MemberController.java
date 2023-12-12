package toy.toyproject1.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import toy.toyproject1.domain.entity.member.LoginDto;
import toy.toyproject1.domain.entity.member.Member;
import toy.toyproject1.domain.entity.member.MemberAddDto;
import toy.toyproject1.domain.repository.MemberRepository;
import toy.toyproject1.service.MemberService;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;
    private final MemberService memberService;

    @GetMapping("/members/add")
    public String addForm(Model model) {
        model.addAttribute("memberAddDto", new MemberAddDto());
        return "members/addForm";
    }

    @PostMapping("/members/add")
    public String add(@Validated MemberAddDto memberAddDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "members/addForm";
        }
        Member member = new Member(memberAddDto.getUsername(), memberAddDto.getUserid(), memberAddDto.getPw());
        Member savedMember = memberRepository.save(member);
        return "redirect:/home";
    }

    @GetMapping("/members/login")
    public String loginForm(Model model) {
        model.addAttribute("loginDto", new LoginDto());
        return "members/loginForm";
    }

    @PostMapping("/members/login")
    public String login(@Validated LoginDto loginDto, BindingResult bindingResult, HttpServletRequest request,
                        @RequestParam(name = "redirectURL", defaultValue = "/boards") String redirectURL) {
        Member findMember = memberRepository.findByUserid(loginDto.getUserid());
        if (findMember == null || (findMember.getPw().equals(loginDto.getPw())) == false) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "members/loginForm";
        }

        HttpSession session = request.getSession();
        session.setAttribute("loginMemberId", findMember.getId());

        return "redirect:" + redirectURL;
    }

    @PostMapping("/members/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/home";
    }
}
