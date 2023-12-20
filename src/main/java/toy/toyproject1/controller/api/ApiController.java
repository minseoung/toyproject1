package toy.toyproject1.controller.api;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import toy.toyproject1.domain.entity.board.BoardAddDto;
import toy.toyproject1.domain.entity.board.BoardDisplayDto;
import toy.toyproject1.domain.entity.board.BoardSearchCondition;
import toy.toyproject1.domain.entity.member.Member;
import toy.toyproject1.domain.entity.member.MemberAddDto;
import toy.toyproject1.domain.repository.BoardRepository;
import toy.toyproject1.domain.repository.MemberRepository;
import toy.toyproject1.service.MemberService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ApiController {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;
    private final MemberService memberService;

    @PostMapping("/api/members/add")
    public Result addMember(@RequestBody @Validated MemberAddDto memberAddDto) {
        Member savedMember = memberService.join(memberAddDto);
        return new Result(savedMember.getId());
    }

    @PutMapping("/api/members/{memberId}")
    public Result editMember(@PathVariable(name = "memberId") Long memberId,
                       @RequestBody @Validated MemberEditDto memberEditDto) {
        Member updatedMember = memberService.update(memberId, memberEditDto.userid, memberEditDto.pw);
        return new Result(new UpdateMemberResponse(updatedMember.getUserid(), updatedMember.getPw()));
    }

//    @PostMapping("/api/boards/add")
//    public Result addBoard(@RequestBody @Validated BoardAddDto boardAddDto) {
//
//    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class MemberEditDto {
        @NotBlank
        private String userid;
        @NotBlank
        private String pw;
    }

    @Data
    @AllArgsConstructor
    static class UpdateMemberResponse {
        private String userid;
        private String pw;
    }


    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
    }

}
