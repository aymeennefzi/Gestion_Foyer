package tn.esprit.tp1_aymen_nefzi_4twin7.Configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Before("execution(* tn.esprit.tp1_aymen_nefzi_4twin7.services.ChambreServiceImpl.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Entering method: " + methodName);
    }
    @After("execution(* tn.esprit.tp1_aymen_nefzi_4twin7.services.ChambreServiceImpl.*(..))")
    public void logMethodExit(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Exiting method: " + methodName);
    }



}
