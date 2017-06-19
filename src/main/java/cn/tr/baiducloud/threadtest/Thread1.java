package cn.tr.baiducloud.threadtest;

public class Thread1 implements Runnable {
	
	private String name;
	
	public Thread1(String name) {
		this.name = name;
	}

	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println(name + "运行");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
