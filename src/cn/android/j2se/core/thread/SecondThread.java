package cn.android.j2se.core.thread;

/**
 * Java中操作线程的第二种方式(推荐方式)
 * 
  1、就是通过继承Thread类的方式时，线程类就无法继承其他的类来实现其他一些功能，实现接口的方式就没有这中限制；
  2.也是最重要的一点就是，通过实现Runnable接口的方式可以达到资源共享的效果。



 * @author  jhao
 *
 */
public class SecondThread {
	public static void main(String[] args) {
       HelloRuner r = new HelloRuner(100);
       Thread t1 = new Thread(r,"Thread One");
       Thread t2 = new Thread(r,"Thread Two");
       t1.start();
       t2.start();
	}
}

class HelloRuner implements Runnable {

	private long max;

	public HelloRuner(long max) {
		this.max = max;
	}

	@Override
	public void run() {
		for (int i = 0; i < max; i++) {
			System.out.println(Thread.currentThread().getName() + "========>"
					+ i);
		}
	}
}
