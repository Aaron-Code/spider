package com.csult.zzw.spider;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class SpiderFilmDetail implements Runnable{


	String url;
	
	List<Film> list;
	
	public SpiderFilmDetail(String url, List<Film> list) {
		super();
		this.url = url;
		this.list = list;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Document doc =  Jsoup.connect(url).get();
			Element e = doc.getElementById("content");
			
			String name = e.selectFirst("h1 span").text();
			String year = e.selectFirst(".year").text();
			
			String director = e.select("#info attrs").select("a").text();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
