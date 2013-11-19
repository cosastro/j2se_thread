package MulitiThreadDemo;

/**
 * 主文件
 * 
 * @author Administrator
 * 
 */
public class Main {
	String urlFile;// 网络文件地址
	int threadNum;// 要启动下载的线程数
	String localFileAddress;// 要保存的本地地址，请保重该处没有名为"tmp"的文件夹

	public Main() {
		/**
		 * 下面的由使用者自己设为定
		 */
		urlFile = "http://dl.google.com/android/android-sdk_r12-windows.zip";
		threadNum = 9;// 要同时下载的线程数
		localFileAddress = "d://multiDownTest//";
	}

	private void start() {
		Thread thread = new Thread(new MultiThreadGetFile(urlFile, threadNum,
				localFileAddress));
		thread.start();
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.start();
	}
}
