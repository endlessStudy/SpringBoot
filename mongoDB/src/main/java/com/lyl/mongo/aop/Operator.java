package com.lyl.mongo.aop;


import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.aspectj.AspectJAopUtils;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Author liuyl
 * @date 2018-11-13-16:24
 * @description
 */
@Component
@Aspect
public class Operator {

    @Pointcut("execution(* com.lyl.mongo.aop.UserService.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println("getArgs: " + Arrays.toString(args));
        Signature signature = joinPoint.getSignature();
        System.out.println("signature.getName :" + signature.getName());
        System.out.println("getSignature.getDeclaringTypeName :" + signature.getDeclaringTypeName());
        System.out.println("getSignature.getDeclaringType :" + signature.getDeclaringType().getSimpleName());
        System.out.println("getSignature.getModifiers :" + signature.getModifiers());
        System.out.println("getTarget :" + joinPoint.getTarget());
        System.out.println("getThis :" + joinPoint.getThis());
        System.out.println("AOP Before Advice...");
        getKey(joinPoint);
    }

    @After("pointCut()")
    public void doAfter(JoinPoint joinPoint) {
        System.out.println("AOP After Advice...");
    }

    @AfterReturning(pointcut = "pointCut()", returning = "returnVal")
    public void afterReturn(JoinPoint joinPoint, Object returnVal) {
        System.out.println("AOP AfterReturning Advice:" + returnVal);
    }

    @AfterThrowing(pointcut = "pointCut()", throwing = "error")
    public void afterThrowing(JoinPoint joinPoint, Throwable error) {
        System.out.println("AOP AfterThrowing Advice..." + error);
        System.out.println("AfterThrowing...");
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) {
        System.out.println("AOP Around before...");
        Object proceed = null;
        try {
            proceed = pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("AOP Around after...");
        return proceed;
    }

    private void getKey(JoinPoint joinPoint) {
        //传入的参数     
        Object[] arguments = joinPoint.getArgs();
        //此处joinPoint的实现类是MethodInvocationProceedingJoinPoint
        Signature signature = joinPoint.getSignature();
        //获取参数名
        MethodSignature methodSignature = (MethodSignature) signature;
        String[] parameterNames = methodSignature.getParameterNames();
        for (int i = 0; i < parameterNames.length; i++) {
            if (StringUtils.equals(parameterNames[i],"string")) {
                System.out.println(arguments[i]);
            }
        }
    }

}