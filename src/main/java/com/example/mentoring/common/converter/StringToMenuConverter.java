package com.example.mentoring.common.converter;

import com.example.mentoring.constant.RegisteredMenus;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/* "MenuConverter"의 역할은 "Menu"에 초점을 맞추는 것이 아닌 "변환"에 초점을 맞추는 것
 * 즉 "MenuConverter"의 역할은 "Converter"임
 * 또한 "menu" 패키지에만 사용 되는 것이 아닌 다른 패키지의 클래스에서도 사용되기에 "common" 패키지로 위치
 * 만약 "menu" 패키지에 있을 경우 "StringToMenuConverter"는 "menu" 패키지의 안에서만 주로 사용 되게끔 제한되어야 함
 */
@Component
public class StringToMenuConverter implements Converter<String, RegisteredMenus> {

    @Override
    public RegisteredMenus convert(String menu){
        return RegisteredMenus.valueOf(menu);
    }
}
