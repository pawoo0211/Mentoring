package com.example.mentoring.menu;

import com.example.mentoring.menu.domain.MenuEntity;
import com.example.mentoring.menu.domain.MenuEntityRepository;
import com.example.mentoring.menu.in.RegisterMenuIn;
import com.example.mentoring.menu.out.RegisterMenuOut;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MenuService {

    private final MenuEntityRepository menuEntityRepository;

    @Transactional
    public RegisterMenuOut registerMenu(RegisterMenuIn registerMenuIn) {

        // 이미 등록된 메뉴가 있는지 확인
        boolean registerStatus = verifyRegisterMenu(registerMenuIn);

        // 이미 등록된 메뉴가 있다면 등록 실패
        if (registerStatus) {
            return new RegisterMenuOut(false, "등록 실패");
        }

        // 등록된 메뉴가 없을 경우 새로 등록
        MenuEntity menuEntity = MenuEntity.builder()
                .menu(registerMenuIn.getMenu())
                .price(registerMenuIn.getPrice())
                .build();

        // 메뉴 저장
        menuEntityRepository.save(menuEntity);

        return new RegisterMenuOut(true, "등록 성공");
    }

    @Transactional
    private boolean verifyRegisterMenu(RegisterMenuIn registerMenuIn) {

        if (menuEntityRepository.existsByMenu(registerMenuIn.getMenu())) {
            return true;
        }
        return false;
    }
}
