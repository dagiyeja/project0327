package homework;

/*file.length()->100% ���Ͽ뷮
 * ���� ���Ͽ뷮 ���->�޼���� �ۼ��غ���
 * ex)286����Ʈ�� 100�ۼ�Ʈ�϶�, read�޼���� �ѹ���Ʈ�� �����ϱ� ��ʽ����� ����
 * 286:100% =5:x%
 * ->x=
 * */

import javax.swing.JProgressBar;

public class SaveThread extends Thread{
	JProgressBar bar;
	int count=0; //���⼭ count�� �۾����෮
	
	public SaveThread(JProgressBar bar) {
		this.bar=bar;
		
		this.start();
	}
	
	
	public void run() {
		while(true){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count++;
			bar.setValue(count);
		}
	}
}
