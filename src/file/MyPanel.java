//�г��� �󺧰� ��ư�� ������ �ִ�
//JPanel has a Label&Button
package file;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPanel extends JPanel{
	JLabel la;
	JButton bt;
	
	//Ŀ���͸���¡ �� �г� ����,
	//�г��� �¾��, �� ��ǰ�� ���� �¾�� �ϹǷ�, �����ڿ��� �ʱ�ȭ����!!
	public MyPanel(String title, Icon icon){
		la=new JLabel(title);
		bt=new JButton(icon);		
		
		this.setLayout(new BorderLayout());
		this.add(la,  BorderLayout.NORTH);
		this.add(bt);
		
		bt.setBorderPainted(false); //��ư�� ��輱 ���ֱ�
		bt.setContentAreaFilled(false); //����Ʈ ������ �� ä��� ����
		bt.setFocusPainted(false); //��Ŀ���� ���� ��� ���ֱ�
		bt.setOpaque(false); //�������� �����ϱ� 
	
		
		
	}
	
	

}
