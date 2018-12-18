package com.csult.zzw.spider;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
		
		ExecutorService pool = Executors.newFixedThreadPool(4);
//		ExecutorService pool = Executors.newCachedThreadPool();
//		pool = Executors.newSingleThreadExecutor();
		ArrayList<Film> list = new ArrayList<Film>();
		String url = "https://movie.douban.com/top250?start";
		for (int i = 0; i < 100; i++) {
			String path = String .format("%s=%d", url, i*25);
			pool.submit(new spider(path, list));
		}
		pool.shutdown();
		while (!pool.isTerminated()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		System.out.println(list.size());
//		for (Film film : list) {
//			System.out.println(film.toCSV());
//		}
		/*
		 * 写入文件
		 */
		String file = "F:/hithub/film.csv";
		file = "film.csv";
		//排序
		Collections.sort(list);
		
		try(FileWriter out = new FileWriter(file)) {
			for (Film film : list) {
				out.write(film.toCSV());
			}
			System.out.println("OK");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
