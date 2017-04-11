/*
 *OS�� ���� ���μ������� ���ÿ� �����ϸ鼭
 *������ �� �ֵ���(��Ƽ�½�ŷ,multi-tasking),�ϳ��� �ڹ� 
 *���α׷� ������ ������ ��������� ����� 
 *���ÿ� �����ų �� �ִ�. �̷��� ���� ��������� ������� �Ѵ�
 *
 *�ڹٴ� �����ڰ� �������� �ʾƵ� �̹� �⺻������ �����Ǵ� 
 *����� �����尡 ������ �̷��� �����带 ������ ���ξ������ �Ѵ�.
 *�ᱹ �ڹٴ� ������ ����̴�.
 * */
package thread;

public class ThreadTest {
	//���ξ����� ����, �����ڰ� ���ϴ� ����� ���� ������ �ϳ� ����
	//���ϴ� ���� �۾��� ���Ѻ���!!
	MyThread thread; //java.lang�� ����
	
	public ThreadTest() {
		//���� ������ʹ� ���������� ����� �� �ִ� ���� ��������� ������
		//�����尡 � ���� ������ �����ڰ� �����ؾ� �ϱ� ������.. ->������ ����������(��ӹ���)
		thread=new MyThread();
		//thread.run(); ����:������ ����θ� main����ΰ� ������ . run ���� ����
		thread.start(); //�����ڰ� �ƴ� JVM�� ����
		
		while(true){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("��");
		}
	}
	
	public static void main(String[] args) {
		new ThreadTest();
		
	}

}
