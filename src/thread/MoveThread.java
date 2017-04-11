//움직임 로직을 담게 될 쓰레드
package thread;

public class MoveThread extends Thread{
	AniMain aniMain; 
	//개발자는 독립 실행할 코드를 run에 기재
	//JVM이 run을 알아서 호출해준다!!
	
	public MoveThread(AniMain aniMain) {
		this.aniMain=aniMain; //이 스레드를 new할때 aniMain을 호출할 수 있음
	}
	
	public void run() {
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			aniMain.move();
			
		}
	}
}
