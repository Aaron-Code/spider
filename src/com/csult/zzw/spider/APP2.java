package com.csult.zzw.spider;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class APP2 {
	public static void main(String[] args) {
		String url = "https://movie.douban.com/subject/1291561/";
		try {
			Document doc = Jsoup.connect(url).get();
			Elements es = doc.select("#info");
			for (Element e : es) {
				Film2 ff = new Film2();
				ff.daoyan = e.select(".attrs").first().text();
				System.out.println(ff);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
