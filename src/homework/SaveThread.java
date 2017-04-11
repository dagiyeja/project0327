package homework;

/*file.length()->100% 파일용량
 * 남은 파일용량 계산->메서드로 작성해보자
 * ex)286바이트가 100퍼센트일때, read메서드는 한바이트씩 읽으니까 비례식으로 생각
 * 286:100% =5:x%
 * ->x=
 * */

import javax.swing.JProgressBar;

public class SaveThread extends Thread{
	JProgressBar bar;
	int count=0; //여기서 count는 작업실행량
	
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
