/*
 * ����̳� ũ�Ⱑ ���� �ٸ� ������ 3���� ��µǰ�, ��ư�� ������ �� ���� �ٸ� �ӵ��� �̵��Ѵ�.
 * � ������� �����带 �������� ����غ���! -���⼭�� .java�� ���� ������
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
		
		bt=new JButton("��ü�̵�");
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
		
		//��ư�� ������ ����
		bt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				MoveThread2 mt1=new MoveThread2(threadStudy); //���� �ִϸ��� ���۷����� �ҷ��;� ��
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
