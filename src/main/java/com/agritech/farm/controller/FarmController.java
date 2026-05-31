package com.agritech.farm.controller;

import com.agritech.farm.entity.Crop;
import com.agritech.farm.entity.Greenhouse;
import com.agritech.farm.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FarmController {


    @Autowired
    private FarmService farmService;

    @GetMapping("/greenhouses")
    public String showGreenhouses(Model model) {
        model.addAttribute("greenhouses", farmService.getAllGreenhouses());
        model.addAttribute("newGreenhouse", new Greenhouse());
        return "greenhouses";
    }

    @PostMapping("/greenhouses/save")
    public String saveGreenhouse(@ModelAttribute("newGreenhouse") Greenhouse greenhouse) {
        farmService.saveGreenhouse(greenhouse);
        return "redirect:/greenhouses";
    }

    @GetMapping("/crops")
    public String showCrops(Model model) {
        model.addAttribute("crops", farmService.getAllCrops());
        model.addAttribute("greenhouses", farmService.getAllGreenhouses());
        model.addAttribute("newCrop", new Crop());
        return "crops";
    }

    @PostMapping("/crops/save")
    public String saveCrop(@ModelAttribute("newCrop") Crop crop) {
        farmService.saveCrop(crop);
        return "redirect:/crops";
    }

    @GetMapping("/crops/delete/{id}")
    public String deleteCrop(@PathVariable("id") Long id) {
        farmService.deleteCrop(id);
        return "redirect:/crops";
    }
}