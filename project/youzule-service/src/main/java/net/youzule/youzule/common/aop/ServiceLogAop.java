package net.youzule.youzule.common.aop;


import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.SourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @title:serviceAop
 * @description:日志记录service
 * @company:
 * @author:zhaodahai
 * @date:2018/5/16 11:24
 **/


public class ServiceLogAop {

    private static final Logger logger = LoggerFactory.getLogger(ServiceLogAop.class);

    private Signature signature;

    /*定义切点*/
    @Pointcut(value = "execution(* net.youzule.youzule.module..*.service..*(..))")
    public void pointCut() {
    }

    /*前置通知*/
    @Before(value = "pointCut()")
    public void before(JoinPoint joinPoint) {
        this.signature = joinPoint.getSignature();
        Object[] o = joinPoint.getArgs();
        logger.info("service调用开始-类:{},方法:{},入参:{}", JSON.toJSONString(this.signature.getDeclaringTypeName()), JSON.toJSON(this.signature.getName()), JSON.toJSON(o));
    }

    /*后置通知*/
    @AfterReturning(value = "pointCut()", returning = "retVal")
    public void afterReturning(Object retVal) {
        logger.info("service调用结束-类:{},方法:{},出参:{}", JSON.toJSONString(this.signature.getDeclaringTypeName()), JSON.toJSON(this.signature.getName()), JSON.toJSON(retVal));
    }
    /*异常通知*/
    @AfterThrowing(value = "pointCut()")
    public void afterThrowing() {
        logger.info("service调用异常-类:{},方法:{}", JSON.toJSONString(this.signature.getDeclaringTypeName()), JSON.toJSON(this.signature.getName()));

    }
}
