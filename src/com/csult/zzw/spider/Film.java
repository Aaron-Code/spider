package com.csult.zzw.spider;

/*
 * ZZW
 */

public class Film implements Comparable<Film>{
	/*
	 * 影片名称
	 */

	String title;
	/*
	 * 相关信息
	 */
	String info;
	/*
	 * 评分
	 */
	double rating;
	/*
	 * 评分人数
	 */
	int num;
	/*
	 * 
	 */
	int id;
	/*
	 * 海报
	 */
	String poster;
	
	/*
	 * 短评
	 */
	String quote;
	/*
	 * 
	 * 
	 */
	String url;
	
	public String toCSV(){
		return String.format("%d,%s,%d,%.1f\n",
				id,
				title,
				num,
				rating);
	}

	@Override
	public String toString() {
		return "Film [title=" + title + ", info=" + info + ", rating=" + rating + ", num=" + num + ", id=" + id
				+ ", poster=" + poster + ", url=" + url + "]";
	}

	@Override
	public int compareTo(Film o) {
		// TODO Auto-generated method stub
		return id-o.id;
	}
	
	
	
}
