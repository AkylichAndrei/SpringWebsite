package com.example.demo.controllers;

import com.example.demo.enums.Type;
import com.example.demo.models.ItemModel;
import com.example.demo.repos.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/addCar")
public class addCarControler {
    @Autowired
    ItemRepo itemRepo;
    @GetMapping
    public String getPage(){
    return "addCar";
    }
    @PostMapping
    public RedirectView setData(@RequestParam String name,
                                @RequestParam String price,
                                @RequestParam String disc,
                                @RequestParam String image,
                                @RequestParam String type){
        ItemModel itemModel = new ItemModel();
        itemModel.setName(name);
        itemModel.setPrice(price);
        itemModel.setDisc(disc);
        itemModel.setImage(image);
        switch (type){
            case "Машина":
                itemModel.setType(Type.Car);
                break;
            case "Деталь":
                itemModel.setType(Type.Components);
                break;
            case "Комплектующие":
                itemModel.setType(Type.ForCars);
                break;
            case "Для салона":
                itemModel.setType(Type.Detailing);
                break;
        }
        itemRepo.save(itemModel);

        return  new RedirectView("/");
    }
}
