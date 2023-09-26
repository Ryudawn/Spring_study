package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.PersonDTO;

@Controller
@RequestMapping("/quiz")
public class QuizController {

    @GetMapping("/q1")
    public void ex1(){
    }
    
    @GetMapping("/q2")
    public void ex2(){
    }
    
    @GetMapping("/q3")
    public void ex3(Model model){
        model.addAttribute("name", "둘리");
        model.addAttribute("age", "20");
        model.addAttribute("address", "인천 구월동");
    }
    
    @GetMapping("/q4")
    public void ex4(Model model){
        PersonDTO personDTO = new PersonDTO("둘리",20,"인천 구월동");
        model.addAttribute("dto", personDTO);
    }
    
    @GetMapping("/q5")
    public void ex5(Model model){
    	int[] intArr = {1,2,3,4,5};
        model.addAttribute("arr", intArr);
    }
    
    @GetMapping("/q6")
    public void ex6(Model model){
        List<PersonDTO> dtoList = new ArrayList<>();
        dtoList.add(new PersonDTO("둘리",20,"인천 구월동"));
        dtoList.add(new PersonDTO("또치",30,"서울 신림동"));
        dtoList.add(new PersonDTO("도우너",40,"부산 문래동"));
        model.addAttribute("list", dtoList);
    }

    @GetMapping("/q7")
    public void ex7(Model model){
        List<PersonDTO> dtoList = new ArrayList<>();
        dtoList.add(new PersonDTO("박하나",20,"인천 구월동"));
        dtoList.add(new PersonDTO("홍재범",30,"서울 신림동"));
        dtoList.add(new PersonDTO("문유리",40,"부산 문래동"));
        model.addAttribute("list", dtoList);
    }
    
}
