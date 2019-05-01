package xyz.jfjk.dao;

import org.apache.ibatis.session.SqlSession;

import xyz.jfjk.mapper.MovieMapper;
import xyz.jfjk.po.Movie;

import xyz.jfjk.utils.MybatisHelper;

import java.util.List;

public class MovieDaoImpl implements MovieDao{
    //获取session
    SqlSession sqlSession = MybatisHelper.getSqlSessionLocal();
    //注入要操作的表mapper,方便单表操作
    MovieMapper mapper = sqlSession.getMapper(MovieMapper.class);

    /**
     * 通过字符查询搜索相关电影
     * @param keyword
     * @return
     */
    @Override
    public List<Movie> getSearchMovieDao(String keyword){

        //查询
        List<Movie> movies =  mapper.searchMapper(keyword);
        //关流
        sqlSession.close();
        return movies;
    }

    /**
     * 分页查询,查询所有数据
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public List<Movie> getSelectPageMovieDao(int page, int pageSize) {

        //查询
        List<Movie> movies = mapper.selectPageMapper((page-1)*pageSize,pageSize);
        //关流
        sqlSession.close();
        return movies;
    }

    /**
     * 插入数据
     * @param movie
     * @return
     */

    @Override
    public int insertMovieDao(Movie movie) {


        int m = mapper.insert(movie);
        sqlSession.commit();
        sqlSession.close();
        return m;
    }
    public  int selectCountDao(){
        int count = mapper.selectMovieCount();
        return count;
    }
}
