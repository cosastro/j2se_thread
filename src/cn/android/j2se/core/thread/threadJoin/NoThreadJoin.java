package cn.android.j2se.core.thread.threadJoin;

/**
 * 没有加入Join方法，子线程与主线程交互执行，没有规则
 * @author jhao
 *
 */
public class NoThreadJoin {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		class Runner implements Runnable {
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					if (i % 100 == 0) {
						String name = Thread.currentThread().getName();
						System.out.println(name + ":" + i / 100);
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		
		Thread t = new Thread(new Runner(),"[Thread One]");
		t.start();
		
		for (int i = 0; i < 10000; i++) {
			if (i % 100 == 0) {
				String name = Thread.currentThread().getName();
				System.out.println(name + ":" + i / 100);
				Thread.sleep(10);
			}
		}

	}

}
