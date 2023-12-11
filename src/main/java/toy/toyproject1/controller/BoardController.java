package toy.toyproject1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import toy.toyproject1.domain.repository.BoardRepository;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardRepository boardRepository;
}
