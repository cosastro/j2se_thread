package MulitiThreadDemo;

/**
 * 监视线程，检测其它的线程是否已经运行完毕 原理：
 * 在MultiThreadGetFile里定义一个全局静态boolean数组，在启动每个GetFileThread
 * 的时候，就将对应的数组的值设为false，当对应线程完成后就把对应的数组设为true，
 * 在当前线程采用不停检测是否所有数组的值都为true，如是那就说明所有的线程已经运行完 毕，如果没有就继续检测。
 * 等到所有的GetFileThread线程都完成后，那么就调用文件拼合线程，合并下载的文件块并删除 临时文件块。
 */
public class PoliceThread extends Thread {
	int totalThread;
	String localFileAddress;
	String localFileAddress_tmp;

	public PoliceThread(int totalThread, String localFileAddress,
			String localFileAddress_tmp) {
		this.totalThread = totalThread;
		this.localFileAddress = localFileAddress;
		this.localFileAddress_tmp = localFileAddress_tmp;
	}

	public void run() {
		boolean isRun = true;
		int allStop = 0;
		while (isRun) {
			allStop = 0;
			for (int i = 1; i <= totalThread; i++) {
				if (MultiThreadGetFile.checkList[i] == true) {
					allStop++;
				}
			}
			try {
				this.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (allStop == totalThread)
				isRun = false;
		}
		Thread thread = new Thread(new FileCombination(localFileAddress,
				localFileAddress_tmp));
		thread.start();
	}
}
