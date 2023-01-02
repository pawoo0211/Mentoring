package com.example.mentoring.exception.domain;

import com.example.mentoring.constant.ExceptionKeyword;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ExceptionManager implements InitializingBean {

    private final ApplicationContext applicationContext;
    private final Map<String, MentoringException> mentoringExceptionMap = new HashMap<>();

    @Override
    public void afterPropertiesSet() {
        Collection<MentoringException> mentoringExceptions = applicationContext.getBeansOfType(MentoringException.class)
                .values();

        for (MentoringException mentoringException : mentoringExceptions){
            mentoringExceptionMap.put(mentoringException.getKeyword(), mentoringException);
        }
    }

    public MentoringException choice(ExceptionKeyword exceptionKeyword){

        MentoringException mentoringException = mentoringExceptionMap.get(exceptionKeyword.getKeyword());
        return mentoringException;
    }
}
