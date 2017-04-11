/*클래스로 따로 만들 경우 장점: 재사용성이 높다
 * 단점: 멤버변수를 내것처럼 쓸 수 없다*/
package thread;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AniMain extends JFrame{
	JButton bt;
	Canvas can;
	int x, y;
	AniMain aniMain;
	
	public AniMain() {
		aniMain=this;
		
		bt=new JButton("물체이동");
		add(bt,BorderLayout.NORTH);
		
		
		can=new Canvas(){
			@Override
			public void paint(Graphics g) {
				g.drawOval(x, y, 50, 50);
			}
		};
		
		can.setBackground(Color.YELLOW);
		
		add(can);
		
		//버튼과 리스너 연결
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//이동하는 메서드 호출
				//동생쓰레드를 만들어 일시키자!!
				MoveThread mt=new MoveThread(aniMain); //기존 애니메인 레퍼런스를 불러와야 함
				//MoveThread mt=new MoveThread(AniMain.this);  ->2번째 방법
				mt.start();
				
			}
		});
		
		setSize(700,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void move(){
		x+=5;
		can.repaint();
	}
	
	public static void main(String[] args) {
		new AniMain();
	}

}
