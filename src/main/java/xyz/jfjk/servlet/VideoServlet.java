package xyz.jfjk.servlet;


import xyz.jfjk.Service.movieServiceImpl;
import xyz.jfjk.po.Movie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "VideoServlet")
public class VideoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置统一编码格式
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //获取标志信息
        movieServiceImpl movieService = new movieServiceImpl();
        String sign = request.getParameter("sign");

        //通过标志信息判断请求是否是搜索请求
        if ("search".equals(sign)){
            //获取搜索值
            String keyword="";
             keyword  = request.getParameter("keyword");
            if (keyword!=null){
                //获取搜索数据

                List<Movie> movieList = movieService.getSearchMoiveService(keyword);
                //将数据存入request.setAttribute
                request.setAttribute("keyword",keyword);
                request.setAttribute("movieList",movieList);
                //请求转发
                request.getRequestDispatcher("index.jsp").forward(request,response);
                return;
            }
        }

        //获取全部数据的个数
        int countMovie=0;
        countMovie = movieService.getSelectCountService();
        //将数据存入request.setAttribute
        request.setAttribute("countMovie",countMovie);
        System.out.println(countMovie);

        //获取跳转页面
        String page0=null;
        page0 = request.getParameter("page");
        page0=((page0==null)||("".equals(page0)))?"1":page0;
        int page  =  Integer.parseInt(page0);
        int pageSize = 10;
        request.setAttribute("page",page);
        //获取全部数据
        List<Movie> selectAllList = movieService.getSelectAllMoiveService(page, pageSize);
        //将数据存入request.setAttribute
        request.setAttribute("movieList",selectAllList);
        System.out.println(selectAllList);
        request.getRequestDispatcher("index.jsp").forward(request,response);
        return;
    }
}
