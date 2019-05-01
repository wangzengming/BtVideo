package xyz.jfjk.Service;

import xyz.jfjk.dao.MovieDao;

import xyz.jfjk.dao.MovieDaoImpl;

import xyz.jfjk.po.Movie;

import java.util.List;

public class movieServiceImpl implements movieService {
    MovieDao movieDao  = new MovieDaoImpl();
    @Override
    public List<Movie> getSearchMoiveService(String keyword) {

        return movieDao.getSearchMovieDao(keyword);
    }

    @Override
    public List<Movie> getSelectAllMoiveService(int page, int pageSize) {

        return movieDao.getSelectPageMovieDao(page,pageSize);
    }
    public int getSelectCountService(){
        return movieDao.selectCountDao();
    }
}
