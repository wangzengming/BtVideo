package xyz.jfjk.mapper;


import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;
import xyz.jfjk.po.Movie;

import java.util.List;
//movie_name AS movieName,image_url AS imageUrl,show_year AS showYear,update_time AS updateTime,movie_language AS movieLanguage,id,sharpness,type,region,intro,rate,thunder
public interface MovieMapper  extends Mapper<Movie> {
    @Select("select movie_name AS movieName,image_url AS imageUrl,show_year AS showYear,update_time AS updateTime,movie_language AS movieLanguage,id,sharpness,type,region,intro,rate,thunder from crawlerBTdata  WHERE movie_name like CONCAT('%',#{keyword},'%');")
    List<Movie> searchMapper(String keyword) ;

    @Select("select movie_name AS movieName,image_url AS imageUrl,show_year AS showYear,update_time AS updateTime,movie_language AS movieLanguage,id,sharpness,type,region,intro,rate,thunder from crawlerBTdata Limit #{param1},#{param2} ;")
    List<Movie> selectPageMapper(int count,int pageSize);


    @Select("select count(*) from crawlerBTdata;")
    int selectMovieCount();
}
