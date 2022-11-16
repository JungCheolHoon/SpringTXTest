package kr.kwangan2.tx.advice;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Log4j
@Component
public class LogAdvice {
	
	@AfterThrowing(pointcut = "execution(* kr.kwangan2.tx.service.MoneyTXService*.*(..))", throwing="exception")
	public void logException (Exception exception) {
		log.info("출금요청금액이 계좌금액보다 많습니다!");
		System.exit(0);
	}
	
}
