package kr.co.acomp.hello.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MeasuringInterceptor extends HandlerInterceptorAdapter {

//    Logger 불러오기
    Logger logger = LoggerFactory.getLogger(MeasuringInterceptor.class);


    @Override
    public boolean preHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler) throws Exception {
//       시작시간 저장
        request.setAttribute("mi.beginTime",System.currentTimeMillis());
        return true;
    }

    @Override
    public void afterCompletion(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        저장해왔던 시간 갖고오기
//        명시적 형변환 필수
        long beginTime = (long) request.getAttribute("mi.beginTime");
        long endTime = System.currentTimeMillis();

        logger.debug(request.getRequestURI() + "실행시간 : "
                        + (endTime-beginTime));

    }
}
