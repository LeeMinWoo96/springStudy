package kr.co.acomp.hello.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MeasuringAspect {

//    target method 의 실행 전/후로 실행되는 Around Aspect
//    보통 메소드 시간 측정 등에 많이 쓰임
    // 서비스 클래스에 적용하겠(
    @Around("execution(* kr.co.acomp.hello.service.*Service.*(..))")
    public Object measuringMethodRunningTime(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();

        // 이게 target 메소드 실행 코드 무조건 예외로 감싸야함
        try {
            return joinPoint.proceed();
        } finally {

//            target 메소드 실행 후 코드s
            long result = System.currentTimeMillis() - start;
            String targetMethodName = joinPoint.getSignature().getName();
            System.out.println(targetMethodName + " running time is " + result);
        }
    }
}
