package com.example.mentoring.menu.controller;

import com.example.mentoring.menu.dto.RegisterMenuRequestDto;
import com.example.mentoring.menu.dto.RegisterMenuResponseDto;
import com.example.mentoring.menu.service.MenuService;
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
    public RegisterMenuResponseDto registerMenu(@RequestBody @Valid RegisterMenuRequestDto registerMenuRequestDto){
        return menuService.registerMenu(registerMenuRequestDto);
    }
}
