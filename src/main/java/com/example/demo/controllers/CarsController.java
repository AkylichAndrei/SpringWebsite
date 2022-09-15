package com.example.demo.controllers;

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

@Controller
@RequestMapping("/cars")
public class CarsController {
    @Autowired
    ItemRepo itemRepo;
    @GetMapping
    public  String getPage(Model model){
        List<ItemModel> list = (List<ItemModel>) itemRepo.findAll();
        model.addAttribute("cars", list);
        return "cars";
    }

}
