package toy.toyproject1.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import toy.toyproject1.domain.entity.board.*;
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
    public String boards(@ModelAttribute(name = "searchCond") BoardSearchCondition searchCond,
                         @SessionAttribute(name = "loginMemberId", required = false) Long loginMemberId,  Model model
    ) {
        //게시판 목록에 보여질 게시글 목록 Dto: BoardDisplayDto
        List<BoardDisplayDto> searchedBoards = boardRepository.search(searchCond);
        model.addAttribute("searchedBoards", searchedBoards);

        //보여질 로그인 한 회원의 이름
        String username = memberRepository.findUsernameById(loginMemberId);
        model.addAttribute("username", username);

        return "boards/boards";
    }

    @GetMapping("/boards/{boardId}")
    public String board(@PathVariable(name = "boardId") Long boardId, Model model,
                        @SessionAttribute(name = "loginMemberId", required = false) Long loginMemberId) {
        //상세페이지에 보여질 보드와 멤버 정보 Dto: BoardDto
        BoardDto boardDto = boardRepository.findBoardDtoById(boardId);
        model.addAttribute("boardDto", boardDto);

        //현재 로그인한 멤버에 따라 보여져야하는 페이지 요소가 있어서 id를 넘김
        model.addAttribute("loginMemberId", loginMemberId);

        return "boards/board";
    }


    @GetMapping("/boards/add")
    public String addForm(Model model, HttpServletRequest request) {
        model.addAttribute("boardAddDto", new BoardAddDto());
        return "boards/addForm";
    }

    @PostMapping("/boards/add")
    public String add(@Validated BoardAddDto boardAddDto,
                      BindingResult bindingResult,
                      @SessionAttribute(name = "loginMemberId", required = false) Long loginMemberId,
                      RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "boards/addForm";
        }

        boardService.post(loginMemberId, boardAddDto.getTitle(), boardAddDto.getContent());

        return "redirect:/boards";
    }

    @GetMapping("/boards/{boardId}/edit")
    public String editForm(@PathVariable(name = "boardId") Long boardId, Model model) {
        BoardEditDto boardEditDto = boardRepository.findEditDtoById(boardId);
        model.addAttribute("boardEditDto", boardEditDto);
        return "boards/editForm";
    }

    @PostMapping("/boards/{boardId}/edit")
    public String edit(@PathVariable(name = "boardId") Long boardId, @Validated BoardEditDto boardEditDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "boards/editForm";
        }

        boardService.edit(boardId, boardEditDto);

        return "redirect:/boards/{boardId}";
    }

    @GetMapping("/boards/{boardId}/delete")
    public String delete(@PathVariable(name = "boardId") Long boardId) {
        boardRepository.deleteById(boardId);
        return "redirect:/boards";
    }
}
