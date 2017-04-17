/*
 * 서로 다름 그래픽, 속도, 기타 값을 갖는 물체를 움직이게 하자!
 * */
package homework;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MultiAni extends JFrame{
	JButton bt;
	Canvas can;
	Graphics gp;
	
	CircleThread ct;
	
	public MultiAni() {
		
		bt=new JButton("각자 움직이기");
		
		can=new Canvas(){
			public void paint(Graphics g) {
				//gp=g;
			}
		};
		
		
		
		can.setBackground(Color.YELLOW);
		
		add(bt, BorderLayout.NORTH);
		add(can);
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphics g=can.getGraphics();
				
				for(int i=0; i<5; i++){
				CircleThread ct=new CircleThread(0, i*(50+10), 50,50,100,g); //버튼 눌렀을 때 움직이도록 시점 조정
				RectThread rt=new RectThread(0, 200, 100, 100, 10, g);
				}
			
				
			}
		});
		
		
		setSize(700,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		
	}
	
	public static void main(String[] args) {
		new MultiAni();
	}
}
