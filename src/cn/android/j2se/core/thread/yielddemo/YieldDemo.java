package cn.android.j2se.core.thread.yielddemo;

import java.util.Date;


/**
 * yield 方法使用范例
 * @author jhao
 */
public class YieldDemo {

	private static class Runner implements Runnable {
		
		private boolean yield;
		
		public Runner(boolean yield) {
			this.yield = yield;
		}

		@Override
		public void run() {
			Date start = new Date();
			String name = Thread.currentThread().getName();
			for (int i = 0; i < 100; i++) {
				if (yield)
					Thread.yield(); // 主动放弃已经获取的执行机会，转入就绪状态
				if (i % 10 == 0) {
					System.out.println(name + ":" + i / 10);
				}
			}
			Date end = new Date();
			System.out.println(name + "共耗时:" + (end.getTime() - start.getTime()));
		}
		
	}
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runner(true));
		t1.setName("线程1");
		
		Thread t2 = new Thread(new Runner(true));
		t2.setName("线程2");
	
		t1.start();
		t2.start();
	}

}
