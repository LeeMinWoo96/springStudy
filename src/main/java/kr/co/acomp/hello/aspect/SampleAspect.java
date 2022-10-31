package kr.co.acomp.hello.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SampleAspect {

    // AoP 를 적용할 메소드
    // 아래 메소드가 Aspect
    @Before("execution(* kr.co.acomp.hello..*.*(..))")
    public void before(JoinPoint joinPoint){
        String targetMethodName = joinPoint.getSignature().getName();
        System.out.println(targetMethodName + " is invoked");
    }
}
