package toy.toyproject1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import toy.toyproject1.domain.entity.member.Member;
import toy.toyproject1.domain.entity.member.MemberAddDto;
import toy.toyproject1.domain.repository.MemberRepository;
import toy.toyproject1.service.MemberService;

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
        memberRepository.save(member);
        return "redirect:/boards";
    }
}
