package xyz.jfjk.Service;

import xyz.jfjk.po.Movie;

import java.util.List;

public interface movieService {
    public List<Movie> getSearchMoiveService(String  keyword);
    public List<Movie> getSelectAllMoiveService(int page,int pageSize);
    public int getSelectCountService();
}
