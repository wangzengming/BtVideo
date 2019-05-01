package xyz.jfjk.crawler;

import java.util.Date;
import java.util.logging.Level;

import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import xyz.jfjk.mapper.MovieMapper;
import xyz.jfjk.po.Movie;
import xyz.jfjk.utils.MybatisHelper;

public class BtVideo {
    public static void main(String[] args)throws Exception{
    	System.out.println("爬取开始.......");
    	//计数器
    	int count=1;
    	//爬取起始页码
    	int pageMin=1;
    	int pageMax=40;
        //获取session
        SqlSession sqlSession = MybatisHelper.getSqlSessionLocal();
        //注入要操作的表mapper,方便单表操作
        MovieMapper mapper = sqlSession.getMapper(MovieMapper.class);

        //需要爬取的URL链接
        String url ="http://www.btbtdy.me";
 
        //循环遍历每一页
        for(int page=pageMin;page<=pageMax;page++) {
   
	        //爬取的页面
	        String urlPageList = url+"/btfl/dy1-"+page+".html";
	        Document document = Jsoup.connect(urlPageList)
	                .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.109 Safari/537.36")//设置响应头
	                .timeout(5000)//设置超时时间
	                .get();
	        
	        Elements div= document.select("body > div.list_su > ul > li");
	        
	        //循环遍历网页中的每一个电影div标签
	        for (Element element : div) {
	        	try {
		        	System.out.println(count++);
		        	//1获取电影海报
		        	String imageUrl = element.select(".lazy").attr("data-src");
		        	//2获取电影名
		        	String movieName = element.select(" div.cts_ms > p.title > a").text();
		        	//获取电影详细信息的URl
		        	String movieHref ="http://www.btbtdy.me" +element.select(" div.cts_ms > p.title > a").attr("href");
		        	
		        	/**
		        	 * 通过使用htmlunit 来获取js延时后加载的网页信息
		        	 */
		        	//构造一个webClient 模拟Chrome 浏览器
		        	@SuppressWarnings("resource")
					WebClient webClient = new WebClient(BrowserVersion.CHROME);
		        	//屏蔽日志信息
		        	LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log",
		        	        "org.apache.commons.logging.impl.NoOpLog");
		        	java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
		        	//支持JavaScript
		        	webClient.getOptions().setJavaScriptEnabled(true);
		        	webClient.getOptions().setCssEnabled(false);
		        	webClient.getOptions().setActiveXNative(false);
		        	webClient.getOptions().setCssEnabled(false);
		        	webClient.getOptions().setThrowExceptionOnScriptError(false);
		        	webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
		        	webClient.getOptions().setTimeout(7000);
		        	HtmlPage rootPage = webClient.getPage(movieHref);
		        	//设置一个运行JavaScript的时间
		        	webClient.waitForBackgroundJavaScript(2000);
		        	String html = rootPage.asXml();

		        	//获取电影信息div,
		        	Document movieDoc = Jsoup.parse(html);
		        	
		        	Element movieDiv=  movieDoc.select("div.vod_intro.rt").get(0);
		        	//3获取上映年份
		        	String year = movieDiv.select("span.year").text().substring(1,5);
		        	//4获取更新日期
		        	String updateTime = movieDiv.select("dl > dd:nth-child(2)").text();
		        	//5获取清晰度
		        	String sharpness = movieDiv.select("dl > dd:nth-child(4)").text();
		        	//6获取电影类型
		        	Elements types =movieDiv.select("dl > dd:nth-child(6) a");
		        	String type="";
		        	for (Element typeone : types) {
						type = type + "/"+typeone.text();
					}
		        	type=type.substring(1,type.length());
		        	//7获取电影地区
		        	String region = movieDiv.select("dl > dd:nth-child(8) a").text();
		        	//8获取电影语言
		        	String movieLanguage = movieDiv.select("dl > dd:nth-child(10) a").text();
		        	//9获取电影简介
		        	String intro = movieDiv.select("div.des > div > span").text();
		        	//10获取电影评分	
		        	String rate = movieDiv.select("#filmStarScore").text();
		        	//11获取电影迅雷链接
		        	String thunder= movieDoc.select("a.d1").attr("href");
		        	//12获取抓起时间
		        	Date crawlerTime  = new Date();	
		        	
		    	

		        	//实例化对象,并赋值
		        	Movie movie = new Movie();
		        	movie.setImageUrl(imageUrl);
		        	movie.setMovieName(movieName);
		        	movie.setShowYear(year);
		        	movie.setUpdateTime(updateTime);
		        	movie.setSharpness(sharpness);
		        	movie.setType(type);
		        	movie.setRegion(region);
		        	movie.setMovieLanguage(movieLanguage);
		        	movie.setIntro(intro);
		        	movie.setRate(rate);
		        	movie.setThunder(thunder);
		        	movie.setCrawlerTime(crawlerTime);
		        	//入库
		        	mapper.insert(movie);
		        	//提交事务
		        	sqlSession.commit();


					//打印操作
					System.out.println("----------------------");
					System.out.println("1电影海报:"+imageUrl);
					System.out.println("2电影名称:"+movieName);
					System.out.println("3上映年份:"+year);
					System.out.println("4更新日期:"+updateTime);
					System.out.println("5清晰  度:"+sharpness);
					System.out.println("6电影类型:"+type);
					System.out.println("7电影地区:"+region);
					System.out.println("8电影语言:"+movieLanguage);
					System.out.println("9电影简介:"+intro);
					System.out.println("10电影评分:"+rate);
					System.out.println("11迅雷链接:"+thunder);
					System.out.println("12抓取时间:"+crawlerTime);
					System.out.println("----------------------");

				}catch(Exception e) {
	        		//失败则回滚,并打印错误
	        		sqlSession.rollback();
	        		System.err.println(e);
	        	}
	        }
        }
        System.out.println("爬取结束.......");
        sqlSession.close();
    }
}
