package toy.toyproject1.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import toy.toyproject1.domain.entity.board.Board;
import toy.toyproject1.domain.entity.board.BoardAddDto;
import toy.toyproject1.domain.entity.board.BoardDisplayDto;
import toy.toyproject1.domain.entity.board.BoardSearchCondition;
import toy.toyproject1.domain.entity.member.Member;
import toy.toyproject1.domain.repository.BoardRepository;
import toy.toyproject1.domain.repository.MemberRepository;
import toy.toyproject1.service.BoardService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;
    private final BoardService boardService;

    @GetMapping("/boards")
    public String boards(Model model, HttpServletRequest request) {
        List<BoardDisplayDto> searchedBoards = boardRepository.search(new BoardSearchCondition());
        model.addAttribute("searchedBoards", searchedBoards);
        Long loginMemberId = (Long) request.getSession(false).getAttribute("loginMemberId");
        Member loginMember = memberRepository.findById(loginMemberId).get();
        model.addAttribute("member", loginMember);
        return "boards/boards";
    }

    @GetMapping("/boards/add")
    public String addForm(Model model, HttpServletRequest request) {
        model.addAttribute("boardAddDto", new BoardAddDto());
        return "boards/addForm";
    }

    @PostMapping("/boards/add")
    public String add(@Validated BoardAddDto boardAddDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "boards/addForm";
        }

        Long loginMemberId = (Long) request.getSession(false).getAttribute("loginMemberId");
        boardService.post(loginMemberId, boardAddDto.getTitle(), boardAddDto.getContent());

        return "redirect:/boards";
    }
}
