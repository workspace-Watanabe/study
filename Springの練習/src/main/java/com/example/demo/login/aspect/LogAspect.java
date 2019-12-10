package com.example.demo.login.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect //AOPクラスにつける
@Component
public class LogAspect {

	@Around("execution(String com.example.demo.login.controller.LoginController.getLogin(..))")
	public Object startLog(ProceedingJoinPoint jp) throws Throwable{
		System.out.println("メソッド開始" + jp.getSignature());

		try {
			Object result = jp.proceed();

			System.out.println("メソッド終了" + jp.getSignature());

			return result;

		}catch(Exception e) {
			System.out.println("メソッド異常終了" + jp.getSignature());
			e.printStackTrace();
			throw e;
		}
	}
	/** ====="execution(<戻り値><パッケージ名>.<クラス名>.<メソッド名>(<引数>)" ======**/
	@Around("execution(* *..*.*UserDAO*.*(..))")
	public Object daoLog(ProceedingJoinPoint jp) throws Throwable{

		System.out.println("メソッド開始");

		try {

			Object result = jp.proceed();

			System.out.println("メソッド終了" + jp.getSignature());

			return result;

		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
