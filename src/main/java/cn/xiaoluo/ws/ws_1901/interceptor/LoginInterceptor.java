package cn.xiaoluo.ws.ws_1901.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author luowenqin
 * @create 2019-03-03 9:45
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //得到请求的url
        String url = request.getRequestURI();
//        //将不需要验证的地址(公开地址)滤掉
//        if(url.indexOf("login")>=0||url.indexOf("gotoLogin")>=0){
//            return true;
//        }


        String username = (String) request.getSession().getAttribute("username");
        if (username ==null){
            System.out.println(username+"德玛西亚杯万岁");
            request.setAttribute("msg","没有权限登录");
            response.sendRedirect("/login.html");
            return  false;
        }else {
            return  true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
