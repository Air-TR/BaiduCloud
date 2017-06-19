package cn.tr.baiducloud.threadtest;

public class Mian {
	
	public static void main(String[] args) {
		
		int n = 10;
		
		System.out.println("start");
		
		for (int i = 1; i <= n; i++) {
			/** 
			 * 多线程测试
			 */
			// 多线程并发执行(需要1秒)
			new Thread(new Thread1(String.valueOf(i))).start();
			
			// 单线程执行(需要n秒)
//			try {
//				Thread.sleep(1000);
//				System.out.println(i + "运行");
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
		
		System.out.println("over");
		
	}

}
