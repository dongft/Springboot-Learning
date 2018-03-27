package com.dft.aspect;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.mongodb.BasicDBObject;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @Class Name WebLogAspect
 * @Author dongfuting
 * @Create In 2018年03月27日 18:07
 */
@Aspect
@Order(1)
@Component
public class WebLogAspect {

  private Logger logger = Logger.getLogger("mongodb");

  ThreadLocal<Long> startTime = new ThreadLocal<>();

  @Pointcut("execution(public * com.dft.web..*.*(..))")
  public void webLog() {}

  @Before("webLog()")
  public void doBefore(JoinPoint joinPoint) throws Throwable {
    // 接收到请求，记录请求内容
    ServletRequestAttributes attributes =
        (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = attributes.getRequest();

    BasicDBObject logInfo = getBasicObject(request, joinPoint);
    logger.info(logInfo);
  }

  private BasicDBObject getBasicObject(HttpServletRequest request, JoinPoint joinPoint) {
    // 基本信息
    BasicDBObject r = new BasicDBObject();
    r.append("requestURL", request.getRequestURL().toString());
    r.append("requestURI", request.getRequestURI());
    r.append("queryString", request.getQueryString());
    r.append("remoteAddr", request.getRemoteAddr());
    r.append("remoteHost", request.getRemoteHost());
    r.append("remotePort", request.getRemotePort());
    r.append("localAddr", request.getLocalAddr());
    r.append("localName", request.getLocalName());
    r.append("method", request.getMethod());
    r.append("headers", getHeadersInfo(request));
    r.append("parameters", request.getParameterMap());
    r.append("classMethod",
        joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    r.append("args", Arrays.toString(joinPoint.getArgs()));
    return r;
  }

  /**
   * 获取头信息
   *
   * @param request
   * @return
   */
  private Map<String, String> getHeadersInfo(HttpServletRequest request) {
    Map<String, String> map = new HashMap<>();
    Enumeration headersNames = request.getHeaderNames();
    while (headersNames.hasMoreElements()) {
      String key = (String) headersNames.nextElement();
      String value = request.getHeader(key);
      map.put(key, value);
    }
    return map;
  }

}
