package com.example.demo.controllers;

import com.example.demo.enums.Type;
import com.example.demo.models.ItemModel;
import com.example.demo.repos.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/detailing")
public class DetailingController {
    @Autowired
    ItemRepo itemRepo;
    @PostMapping
    public String setData(@RequestParam int n1,
                          @RequestParam int n2,
                          Model model){
        List<ItemModel> list = (List<ItemModel>) itemRepo.findAllByType(Type.Detailing);
        list=list.stream().filter(c-> Integer.parseInt(c.getPrice())>n1
                && Integer.parseInt(c.getPrice())<n2).collect(Collectors.toList());
        model.addAttribute("cars",list);
        return "detailing";
    }
    @GetMapping
    public  String getPage(Model model){
        List<ItemModel> list = (List<ItemModel>) itemRepo.findAllByType(Type.Detailing);
        model.addAttribute("cars", list);
        return "detailing";
    }
}
