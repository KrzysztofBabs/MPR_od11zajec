package com.example.zajecia2.controllers;


import com.example.zajecia2.model.Auto;
import com.example.zajecia2.services.AutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MyViewController {
    private AutoService autoService;

    public MyViewController(AutoService autoService) {
        this.autoService = autoService;
    }

    @GetMapping("/view/all")
    public String displayAllCars(Model model){
        List<Auto> listaAut = autoService.getAll();
        model.addAttribute("Auta", listaAut);
        return "viewAll";

    }

//    @GetMapping("/view/add")
//    public String addCar(Model model){
//        model.addAttribute("Auto", new Auto());
//        return "add";
//    }
//    @PostMapping("/view/add")
//    public String sendForm(@ModelAttribute Auto auto){
//        autoService.Add(auto);
//        return "redirect:/view/all";
//    }
//
//    @GetMapping("/view/delete")
//    public String deleteCar(Model model){
//        model.addAttribute("Auto", new Auto());
//        return "delete";
//    }
//
//    @PostMapping("/view/delete")
//    public String deleteCar(@ModelAttribute Auto auto){
//        autoService.deleteAutoById(auto.getId());
//        return "redirect:/view/all";
//    }
//
//
//    @GetMapping("/view/update")
//    public String updateCar(Model model){
//        model.addAttribute("Auto", new Auto());
//        return "update";
//    }
//
//    @PostMapping("/view/update")
//    public String updateCar(@ModelAttribute Auto auto){
//        autoService.update(auto);
//        return "redirect:/view/all";
//    }





}
