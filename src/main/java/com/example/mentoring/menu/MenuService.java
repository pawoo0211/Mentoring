package com.example.mentoring.menu;
import com.example.mentoring.menu.domain.MenuEntity;
import com.example.mentoring.menu.domain.MenuEntityRepository;
import com.example.mentoring.menu.in.RegisterMenuIn;
import com.example.mentoring.menu.out.RegisterMenuOut;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MenuService {

    private final MenuEntityRepository menuEntityRepository;

    public RegisterMenuOut registerMenu(RegisterMenuIn registerMenuIn) {

        // 이미 등록된 메뉴가 있는지 확인
        boolean registerStatus = verifyRegisterMenu(registerMenuIn);

        // 이미 등록된 메뉴가 있다면 등록 실패 반환
        if (registerStatus) {
            return new RegisterMenuOut("등록 실패");
        }

        // 등록된 메뉴가 없을 경우 새로운 메뉴 객체 생성
        MenuEntity menuEntity = MenuEntity.builder()
                .menu(registerMenuIn.getMenu())
                .price(registerMenuIn.getPrice())
                .build();

        // 메뉴 저장
        menuEntityRepository.save(menuEntity);

        // 메뉴 등록 성공 반환
        return new RegisterMenuOut("등록 성공");

    }

    private boolean verifyRegisterMenu(RegisterMenuIn registerMenuIn) {

        if (menuEntityRepository.existsByMenu(registerMenuIn.getMenu())) {
            return true;
        }
        return false;
    }
}
