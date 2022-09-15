package com.example.demo.controllers;

import com.example.demo.models.ItemModel;
import com.example.demo.repos.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/editCar")
public class EditCarController {
    @Autowired
    ItemRepo itemRepo;

    private ItemModel itemModel1;

    @GetMapping("/{id}")
    public String editCar(Model model, @PathVariable long id){
        Optional<ItemModel> itemModel = itemRepo.findById(id);
        List<ItemModel> list = new ArrayList<>();
        itemModel.ifPresent(list::add);
        itemModel1 = list.get(0);
        model.addAttribute("item",itemModel1);
        return "editCar";
    }
    @PostMapping("/{id}")
    public RedirectView editDate(@RequestParam String name,
                                 @RequestParam String disc,
                                 @RequestParam String url,
                                 @RequestParam String price,
                                 @PathVariable long id){
        itemRepo.deleteById(id);
        itemModel1.setName(name);
        itemModel1.setDisc(disc);
        itemModel1.setImage(url);
        itemModel1.setPrice(price);

        itemRepo.save(itemModel1);
        return  new RedirectView("/cars");

    }
}
