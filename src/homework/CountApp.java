/*���� �ٸ� �ӵ��� �ö󰡴� ī��Ʈ, thread 2�� �ʿ�*/
package homework;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class CountApp extends JFrame{
	JLabel lb1, lb2;
	
	
	public CountApp() {

		lb1=new JLabel("0");
		lb2=new JLabel("0");
		
		setLayout(new FlowLayout());
		
		//�˾ƺ��� ���� ��� ��������!
		lb1.setBackground(Color.YELLOW);
		lb2.setBackground(Color.YELLOW);
		lb1.setPreferredSize(new Dimension(300, 380));
		lb2.setPreferredSize(new Dimension(300, 380));
		lb1.setFont(new Font("Dotum", Font.BOLD,75));
		lb2.setFont(new Font("Dotum", Font.BOLD,75));
		
		add(lb1);
		add(lb2);
		
		setSize(700,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//������ 2�� ��������
		CountThread ct1=new CountThread(lb1, 10);
		CountThread ct2=new CountThread(lb2, 100);
		
		}
	
	public void count(){
		
		
	}

	
	public static void main(String[] args) {
		 new CountApp();

	}

}
