/*
 * 모양이나 크기가 서로 다른 도형이 3개가 출력되고, 버튼을 눌렀을 때 각자 다른 속도로 이동한다.
 * 어떤 방법으로 쓰레드를 생성할지 고려해보자! -여기서는 .java로 따로 만들자
 * */
package thread4;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.Border;

import thread.MoveThread;

public class ThreadStudy extends JFrame {
	JButton bt;
	Canvas can;
	int x,y;
	ThreadStudy threadStudy;
	
	public ThreadStudy() {
		threadStudy=this;
		
		bt=new JButton("물체이동");
		can=new Canvas(){
			@Override
			public void paint(Graphics g) {
				g.drawOval(0, 0, 50, 50);
				g.drawRect(100,100, 40, 50);
				g.drawRoundRect(300, 200, 60,40, 5, 10);
			}
		};
		
		can.setBackground(Color.YELLOW);
		
		add(bt, BorderLayout.NORTH);
		add(can);
		
		//버튼과 리스너 연결
		bt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				MoveThread2 mt1=new MoveThread2(threadStudy); //기존 애니메인 레퍼런스를 불러와야 함
				MoveThread2 mt2=new MoveThread2(threadStudy);
				MoveThread2 mt3=new MoveThread2(threadStudy);
				mt1.start();
				mt2.start();
				mt3.start();
			}
		});
		
		setSize(700,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
	}
	
	public void move(){
		x+=5;
		y+=5;
		can.repaint();
	}
	
	public static void main(String[] args) {
		new ThreadStudy();

	}

}
