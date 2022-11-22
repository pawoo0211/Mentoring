package com.example.mentoring.controller;

import com.example.mentoring.common.CommonResponse;
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
    public CommonResponse registerMenu(@RequestBody @Valid RegisterMenuIn registerMenuIn) {
        RegisterMenuOut registerMenuOut = menuService.registerMenu(registerMenuIn);

        // 메뉴 등록 실패에 따른 비정상 응답 반환
        if (registerMenuOut.getMessage().equals("등록 실패")) {
            return CommonResponse.fail(registerMenuOut);
        }
        // 메뉴 등록에 따른 정상 응답 반환
        return CommonResponse.ok(registerMenuOut);
    }
}