//도형의 움직임 정의
package thread4;

import java.util.Random;

public class MoveThread2 extends Thread{
	ThreadStudy threadStudy;
	
	public MoveThread2(ThreadStudy threadStudy){
		this.threadStudy=threadStudy;
	}
	
	public void run(){
		
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			threadStudy.move();	
		}
		
	}

}
