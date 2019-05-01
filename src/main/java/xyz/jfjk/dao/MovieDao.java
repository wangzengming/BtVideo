package xyz.jfjk.dao;

import xyz.jfjk.po.Movie;
import java.util.List;

public interface MovieDao {
    List<Movie> getSearchMovieDao(String keyword) ;
    List<Movie> getSelectPageMovieDao(int page,int pageSize) ;
    int insertMovieDao(Movie movie);
    int selectCountDao();

}

