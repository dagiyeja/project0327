package progressbar;

import javax.swing.JProgressBar;

public class MyBar extends Thread{
	JProgressBar bar;
	int interval;
	int count;
	
	public MyBar(JProgressBar bar, int interval) {
		this.bar=bar;
		this.interval=interval;
		
		this.start(); //�¾�ڸ��� �ڱ� run ȣ��
	}
	
	
	public void run() {
		while(true){
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count++;
			bar.setValue(count);
		}	
	}
}
