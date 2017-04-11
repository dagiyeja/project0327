/*
 * ���̵� �簢���̵� � ������ ǥ���ϵ��� 
 * ��� �� Ŭ������ �ڽ����� ����.
 * ��?? �������� Ư¡�� �����Ƿ�..
 * */
package homework;

import java.awt.Graphics;


abstract public class ShapeThread {

	int x;
	int y;
	int width;
	int height;
	int interval;
	Graphics g;
	
	public ShapeThread( int x, int y, int width, int height, int interval, Graphics g) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.interval=interval;
		this.g=g;
		
		
	}
	
	
	//�ڽĵ��� ���ؾ� �ϹǷ� 
	abstract public void render();
	
	public void run() {
		while(true){
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			render();
		}
	}

}
