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

        Menu menu = Menu.builder()
                .menu(registerMenuRequestDto.getMenu())
                .price(registerMenuRequestDto.getPrice())
                .build();

        menuRepository.save(menu);

        return new RegisterMenuResponseDto(true);
    }
}
