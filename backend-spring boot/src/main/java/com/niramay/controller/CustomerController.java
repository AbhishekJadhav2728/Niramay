package com.niramay.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niramay.model.Home;
import com.niramay.model.HomeCategory;
import com.niramay.service.HomeCategoryService;
import com.niramay.service.HomeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final HomeCategoryService homeCategoryService;
    private final HomeService homeService;

    @GetMapping("/home-page")
    public ResponseEntity<Home> getHomePageData() {
//        Home homePageData = homeService.getHomePageData();
//        return new ResponseEntity<>(homePageData, HttpStatus.ACCEPTED);
        return null;
    }

    @PostMapping("/home/categories")
    public ResponseEntity<Home> createHomeCategories(
            @RequestBody List<HomeCategory> homeCategories
    ) {
        List<HomeCategory> categories = homeCategoryService.createCategories(homeCategories);
        Home home=homeService.creatHomePageData(categories);
        return new ResponseEntity<>(home, HttpStatus.ACCEPTED);
    }
}
