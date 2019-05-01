package xyz.jfjk.filter;


import javax.servlet.*;
import java.io.IOException;

class CharsetFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }

//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.println("过滤器开始执行!");
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
//        //设置统一编码格式
//        request.setCharacterEncoding("utf-8");
//        response.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
//        System.out.println("过滤器执行");
//        filterChain.doFilter(request,response);//放行
//    }
//
//    @Override
//    public void destroy() {
//        System.out.println("过滤器结束");
//    }
}
