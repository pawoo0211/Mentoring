package com.example.mentoring.controller;

import com.example.mentoring.menu.in.RegisterMenuIn;
import com.example.mentoring.menu.out.RegisterMenuOut;
import com.example.mentoring.menu.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class MenuController {

    private final MenuService menuService;

    @PostMapping("/menu")
    public RegisterMenuOut registerMenu(@RequestBody @Valid RegisterMenuIn registerMenuIn){
        return menuService.registerMenu(registerMenuIn);
    }
}
