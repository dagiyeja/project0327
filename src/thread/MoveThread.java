//������ ������ ��� �� ������
package thread;

public class MoveThread extends Thread{
	AniMain aniMain; 
	//�����ڴ� ���� ������ �ڵ带 run�� ����
	//JVM�� run�� �˾Ƽ� ȣ�����ش�!!
	
	public MoveThread(AniMain aniMain) {
		this.aniMain=aniMain; //�� �����带 new�Ҷ� aniMain�� ȣ���� �� ����
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
