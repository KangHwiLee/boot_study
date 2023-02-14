package com.kanghwi.study.controller;

import com.kanghwi.study.model.Board;
import com.kanghwi.study.repository.BoardRepository;
import com.kanghwi.study.validator.BoardValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("/list")
    public String list(Model model){
        List<Board> boards = boardRepository.findAll();
        model.addAttribute("boards", boards);
        return "board/list";
    }

    @GetMapping("/form")
    public String form(Model model, @RequestParam(required = false) Long id){
        System.out.println(id);
        if(id == null){
            model.addAttribute("board", new Board());
        }
        else model.addAttribute("board", boardRepository.findById(id).orElse(null));

        return "board/form";
    }

    @Autowired
    private BoardValidator boardValidator;

    @PostMapping("/form")
    public String form(@Valid Board board, BindingResult bindingResult){
        boardValidator.validate(board, bindingResult);
        if(bindingResult.hasErrors()){
            return "board/form";
        }
        boardRepository.save(board);
        return "redirect:/board/list";
    }
}
