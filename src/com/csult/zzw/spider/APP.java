package com.csult.zzw.spider;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * 程序的入口
 */
public class APP {
	//alt+/
	public static void main(String[] args) {
		
		//目标URL
		String url = "https://movie.douban.com/top250";
		
		//使用jsoup抓取文件
		try {
			Document doc= Jsoup.connect(url).get();
			
			
			Elements es = doc.select(".grid_view .item");
			
			System.out.println(es.size());
			ArrayList<Film> list = new ArrayList();
			
			for (Element e : es) {
				Film f = new Film();
				Element t = e.select(".title").first();
				String num = e.select(".star span").last().text();
				System.out.println(t.text()+ "," + num);
				//f.id;
				//f.title
				list.add(f);
			
			}
			
			String title = doc.title();
			String html = doc.html();
			String data = doc.data();
			
			System.out.println(title);
			System.out.println(html);
			System.out.println(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
