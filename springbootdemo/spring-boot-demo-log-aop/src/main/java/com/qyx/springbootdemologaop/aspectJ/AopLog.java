package com.qyx.springbootdemologaop.aspectJ;

import cn.hutool.json.JSONUtil;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;

@Aspect
@Component
@Slf4j
public class AopLog {
    private static final String START_TIME = "request-start";

//    @Pointcut("execution(* com.qyx.springbootdemologaop.*.*())")
    @Pointcut("execution(public * com.qyx.springbootdemologaop.controller.*Controller.*(..))")
    public void log(){}

    @Before("log()")
    public void beforeLog(JoinPoint point){
        log.info("前置通知");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();

        log.info("【请求 URL】：{}", request.getRequestURL());
        log.info("【请求 IP】：{}", request.getRemoteAddr());
        log.info("【请求类名】：{}，【请求方法名】：{}", point.getSignature().getDeclaringTypeName(), point.getSignature().getName());

        Map<String, String[]> parameters = request.getParameterMap();
        log.info("【请求参数】：{}，", JSONUtil.toJsonStr(parameters));
        request.setAttribute(START_TIME,System.currentTimeMillis());
    }

    @Around("log()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        log.info("环绕通知 方法执行前");
        Object result = point.proceed();
        log.info("【返回值】：{}", JSONUtil.toJsonStr(result));
        log.info("环绕通知 方法执行后");
        return result;
    }

    /**
     * 后置操作  【无论是否出现异常最终都会执行】
     */
    @After("log()")
    public void afterLog(){
        log.info("后置通知");
    }

    /**
     * 返回后操作  【出现异常不执行】
     */
    @AfterReturning("log()")
    public void afterReturning(){
        log.info("返回后操作");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();

        Long start = (Long) request.getAttribute(START_TIME);
        Long end = System.currentTimeMillis();
        log.info("【请求耗时】：{}毫秒", end - start);

        String header = request.getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(header);
        log.info("【浏览器类型】：{}，【操作系统】：{}，【原始User-Agent】：{}", userAgent.getBrowser().toString(), userAgent.getOperatingSystem().toString(), header);
    }

    /**
     * 异常通知：当目标方法执行异常时候执行此关注点代码
     */
    @AfterThrowing("log()")
    public void afterThrowing(){
        log.info("返回后操作");
    }
}
