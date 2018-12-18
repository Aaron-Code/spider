package com.csult.zzw.spider;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class spider implements Runnable{

	String url;
	public spider(String url, ArrayList<Film> list) {
		super();
		this.url = url;
		this.list = list;
	}
	ArrayList<Film> list;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String name = Thread.currentThread().getName();
//		System.out.println(name + "处理" + url);
		try {
			Document doc =  Jsoup.connect(url).get();
			Elements es =  doc.select(".grid_view .item");
			for (Element e : es) {
			
			Film f = new Film();
			f.id = Integer.parseInt(e.select(".pic em").first().text());
			f.poster = e.select("img").first().attr("src");
			f.info = e.select(".bd p").first().text();
			f.title = e.select(".title").first().text();
			f.rating = Double.parseDouble(e.select(".rating_num").first().text());
			String num = e.select(".star span").last().text();
			f.num = Integer.parseInt(num.substring(0,num.length() - 3));
			f.quote = e.select(".inq").first().text();
//			System.out.println(name + ":" + f);
			
		
			list.add(f);
		
		}
//			System.out.println(name + "完成:" + url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
