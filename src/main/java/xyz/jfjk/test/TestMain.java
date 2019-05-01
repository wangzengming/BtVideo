package xyz.jfjk.test;

import xyz.jfjk.dao.MovieDao;
import xyz.jfjk.dao.MovieDaoImpl;
import xyz.jfjk.po.Movie;

import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        MovieDao movieDao = new MovieDaoImpl();
        List<Movie> selectAllMovieDao = movieDao.getSelectPageMovieDao(1, 10);
        System.out.println(selectAllMovieDao);

    }
}
