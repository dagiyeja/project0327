/*
 * 원이든 사각형이든 어떤 도형을 표현하든지 
 * 모두 이 클래스의 자식으로 두자.
 * 왜?? 공통적인 특징이 있으므로..
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
	
	
	//자식들이 정해야 하므로 
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
