package xyz.jfjk.po;


import javax.persistence.Column;
import javax.persistence.Table;

import java.util.Date;

@Table(name = "crawlerBTdata")
public class Movie {
    //1主键
    private Integer id;
    //2电影名
    @Column(name = "movie_name")
    private String movieName;

    //3电影海报链接(图片)
    @Column(name = "image_url")
    private String imageUrl;
    //4上映日期
    @Column(name = "update_time")
    private String updateTime;
    //5清晰度
    private String sharpness;
    //6类型
    private String type;
    //7地区
    private String region;
    //8语言
    @Column(name = "movie_language")
    private String movieLanguage;
    //9剧情简介
    private  String intro;
    //10豆瓣评分
    private String rate;
    //11迅雷链接
    private String thunder;
    //12爬取时间
    @Column(name = "crawler_Time")
    private Date crawlerTime;
    //13年份
    @Column(name = "show_year")
    private String showYear;

    public Movie() {
    }

    public Movie( String movieName, String imageUrl, String updateTime, String sharpness, String type, String region, String movieLanguage, String intro, String rate, String thunder, Date crawlerTime, String showYear) {

        this.movieName = movieName;
        this.imageUrl = imageUrl;
        this.updateTime = updateTime;
        this.sharpness = sharpness;
        this.type = type;
        this.region = region;
        this.movieLanguage = movieLanguage;
        this.intro = intro;
        this.rate = rate;
        this.thunder = thunder;
        this.crawlerTime = crawlerTime;
        this.showYear = showYear;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;

    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;

    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getSharpness() {
        return sharpness;
    }

    public void setSharpness(String sharpness) {
        this.sharpness = sharpness;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getMovieLanguage() {
        return movieLanguage;
    }

    public void setMovieLanguage(String movieLanguage) {
        this.movieLanguage = movieLanguage;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getThunder() {
        return thunder;
    }

    public void setThunder(String thunder) {
        this.thunder = thunder;
    }

    public Date getCrawlerTime() {
        return crawlerTime;
    }

    public void setCrawlerTime(Date crawlerTime) {
        this.crawlerTime = crawlerTime;
    }

    public String getShowYear() {
        return showYear;
    }

    public void setShowYear(String showYear) {
        this.showYear = showYear;
    }



    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", movieName='" + movieName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", sharpness='" + sharpness + '\'' +
                ", type='" + type + '\'' +
                ", region='" + region + '\'' +
                ", movieLanguage='" + movieLanguage + '\'' +
                ", intro='" + intro + '\'' +
                ", rate='" + rate + '\'' +
                ", thunder='" + thunder + '\'' +
                ", crawlerTime=" + crawlerTime +
                ", showYear='" + showYear + '\'' +
                '}';
    }
}
