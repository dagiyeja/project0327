/*
 *OS가 여러 프로세스들을 동시에 수행하면서
 *관리할 수 있듯이(멀티태스킹,multi-tasking),하나의 자바 
 *프로그램 내에서 세부적 실행단위를 만들어 
 *동시에 수행시킬 수 있다. 이러한 세부 실행단위를 쓰레드라 한다
 *
 *자바는 개발자가 정의하지 않아도 이미 기본적으로 제공되는 
 *실행용 쓰레드가 있으며 이러한 쓰레드를 가리켜 메인쓰레드라 한다.
 *결국 자바는 쓰레드 기반이다.
 * */
package thread;

public class ThreadTest {
	//메인쓰레드 말고, 개발자가 원하는 사용자 정의 쓰레드 하나 만들어서
	//원하는 동시 작업을 시켜보자!!
	MyThread thread; //java.lang에 존재
	
	public ThreadTest() {
		//메인 쓰레드와는 독립적으로 실행될 수 있는 세부 실행단위를 생성함
		//쓰레드가 어떤 일을 할지는 개발자가 결정해야 하기 때문에.. ->쓰레드 재정의하자(상속받자)
		thread=new MyThread();
		//thread.run(); 주의:별도의 실행부를 main실행부가 실행함 . run 쓰지 말자
		thread.start(); //개발자가 아닌 JVM이 실행
		
		while(true){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("☆");
		}
	}
	
	public static void main(String[] args) {
		new ThreadTest();
		
	}

}
