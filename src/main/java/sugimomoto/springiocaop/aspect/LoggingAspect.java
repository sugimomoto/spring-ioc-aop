package sugimomoto.springiocaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class LoggingAspect {
    
    @Before("execution(String sugimomoto.springiocaop.controller.HomeController.showList(..))")
    public void startLog(JoinPoint jp){
        log.info("{}: Before処理",jp.getSignature());
    }

    @After("execution(* sugimomoto.springiocaop.controller.HomeController.*(..))")
    public void endLog(JoinPoint jp){
        log.info("{}: After処理", jp.getSignature());
    }

    @Around("execution(* sugimomoto.springiocaop..*(..))")
    public Object startAndEndLog(ProceedingJoinPoint pjp) throws Throwable{
        log.info("{}: Around前処理",pjp.getSignature());

        var result = pjp.proceed();


        // 処理結果を受け取って、違うページにレスポンスを切り替えることができる。
        if(result instanceof String && result == "index"){
            result = "change";
        }

        log.info("{}: Around後処理",pjp.getSignature());
        return result;
    }

    @AfterReturning(pointcut = "within(sugimomoto.springiocaop.controller.*Controller)", returning = "result")
    public void afterReturning(JoinPoint jp, Object result){
        log.info("{}: return結果 = {}", jp.getSignature(), result);
    }

    @AfterThrowing(pointcut = "bean(homeController)",throwing = "e")
    public void afterThrowing(JoinPoint jp, Throwable e){
        log.error("{}: 処理中に例外が発生しました。", e.getMessage());
    }


}


