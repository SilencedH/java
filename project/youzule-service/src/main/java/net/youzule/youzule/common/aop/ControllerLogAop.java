package net.youzule.youzule.common.aop;

import com.alibaba.fastjson.JSON;
import org.apache.commons.logging.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @title:ControllerLogAop
 * @description:controller日志打印
 * @company:
 * @author:zhaodahai
 * @date:2018/5/17 14:28
 **/

@Aspect
@Component
public class ControllerLogAop {

    private static final Logger logger = LoggerFactory.getLogger(ControllerLogAop.class);

    private Signature signature;
    /*定义切点*/
    @Pointcut(value = "execution(* net.youzule.youzule.module..*.controller..*(..))")
    public void pointCut() {

    }

    /*前置通知*/
    @Before(value = "pointCut()")
    public void before(JoinPoint joinPoint) {
        this.signature = joinPoint.getSignature();
        Object[] o = joinPoint.getArgs();
        logger.info("controller调用开始-类:{},方法:{},入参:{}", JSON.toJSONString(this.signature.getDeclaringTypeName()), JSON.toJSON(this.signature.getName()), JSON.toJSON(o));
    }

    /*后置通知*/
    @AfterReturning(value = "pointCut()", returning = "retVal")
    public void afterReturning(Object retVal) {
        logger.info("controller调用结束-类:{},方法:{},出参:{}", JSON.toJSONString(this.signature.getDeclaringTypeName()), JSON.toJSON(this.signature.getName()), JSON.toJSON(retVal));
    }
    /*异常通知*/
    @AfterThrowing(value = "pointCut()")
    public void afterThrowing() {
        logger.info("controller调用异常-类:{},方法:{}", JSON.toJSONString(this.signature.getDeclaringTypeName()), JSON.toJSON(this.signature.getName()));

    }
}
