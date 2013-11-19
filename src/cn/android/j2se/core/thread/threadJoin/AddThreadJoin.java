package cn.android.j2se.core.thread.threadJoin;

/**
 * 添加join方法，join方法类似于一个插队的方法
 * 下面代码演示了，Thread One插队执行，直到Thread One
 * 执行完毕，再去执行主线程的代码
 * @author jhao
 *
 */
public class AddThreadJoin {
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
		t.join();  //让子线程[Thread One]插队
		
		for (int i = 0; i < 10000; i++) {
			if (i % 100 == 0) {
				String name = Thread.currentThread().getName();
				System.out.println(name + ":" + i / 100);
				Thread.sleep(10);
			}
		}

	}

}

