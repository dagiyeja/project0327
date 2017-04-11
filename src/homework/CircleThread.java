//원을 표현한 객체 및 그 움직임 
package homework;

import java.awt.Color;
import java.awt.Graphics;

public class CircleThread extends ShapeThread{

	//오버라이딩-업그레이드
	public CircleThread( int x, int y, int width, int height, int interval, Graphics g) {
		super(x, y, width, height, interval, g);
	}
	
	public void render(){
		System.out.println("g는 "+g);
		//노란색 페인트로 윈도우에 적용하고 
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, 700, 600);
		
		//그리자
		x+=5;
		g.setColor(Color.BLACK); //검정색으로 설정됨
		g.drawOval(x, y, width, height);
		
		
	}
}
