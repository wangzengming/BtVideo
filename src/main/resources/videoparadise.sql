CREATE DATABASE videoparadise;

use videoparadise;

-- 80s电影数据表
CREATE TABLE crawlerBTdata (
	id INTEGER PRIMARY KEY AUTO_INCREMENT COMMENT'主键自增',
	movie_name VARCHAR(255) COMMENT'电影名',
	image_url VARCHAR(255) COMMENT'海报链接(图片)',
	show_year VARCHAR(255) COMMENT'上映年份',
	update_time VARCHAR(255) COMMENT'更新时间',
	sharpness VARCHAR(255) COMMENT'清晰度',
	type VARCHAR(255) COMMENT'类型',
	region VARCHAR(255) COMMENT'地区',
	movie_language VARCHAR(255) COMMENT'语言',
	intro VARCHAR(1024) COMMENT'剧情简介',
	rate VARCHAR(255) COMMENT'评分',
	thunder VARCHAR(512) COMMENT'迅雷链接',
	crawler_time datetime COMMENT'抓取时间'
)charset=utf8mb4 COMMENT'BT电影天堂数据表';



-- 清空数据表
TRUNCATE TABLE crawlerBTdata;
