package com.image.axe.controller;

import com.image.axe.entity.Image;
import com.image.axe.service.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Controller
public class ImageController {
    private final ImageService imageService;

    @GetMapping(path = "/image")
    public String showImageForm(Model model) {
        model.addAttribute("image", new Image());
        return "/createImageForm";
    }
    @PostMapping(path="/image", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String saveImage(@ModelAttribute Image image) {
        imageService.save(image);
        return "/success";
    }
}
