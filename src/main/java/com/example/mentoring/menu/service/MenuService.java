package com.example.mentoring.menu.service;

import com.example.mentoring.menu.domain.Menu;
import com.example.mentoring.menu.domain.MenuRepository;
import com.example.mentoring.menu.dto.RegisterMenuRequestDto;
import com.example.mentoring.menu.dto.RegisterMenuResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MenuService {

    private final MenuRepository menuRepository;

    @Transactional
    public RegisterMenuResponseDto registerMenu(RegisterMenuRequestDto registerMenuRequestDto) {

        // 이미 등록된 메뉴가 있는지 확인
        boolean registerStatus = verifyRegisterMenu(registerMenuRequestDto);

        // 이미 등록된 메뉴가 있다면 등록 실패
        if (registerStatus) {
            return new RegisterMenuResponseDto(false, "등록 실패");
        }

        // 등록된 메뉴가 없을 경우 새로 등록
        Menu menu = Menu.builder()
                .menu(registerMenuRequestDto.getMenu())
                .price(registerMenuRequestDto.getPrice())
                .build();

        // 메뉴 저장
        menuRepository.save(menu);

        return new RegisterMenuResponseDto(true, "등록 성공");
    }

    @Transactional
    private boolean verifyRegisterMenu(RegisterMenuRequestDto registerMenuRequestDto) {

        if (menuRepository.existsByMenu(registerMenuRequestDto.getMenu())) {
            return true;
        }
        return false;
    }
}
