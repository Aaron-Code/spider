package com.csult.zzw.spider;

public class task implements Runnable{

	int num;
	public task(int num) {
		super();
		this.num = num;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String name = Thread.currentThread().getName();
		System.out.println(name + "¿ªÊ¼:" + num);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name + "½áÊø:" + num);
	}

}
