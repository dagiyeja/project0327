//패널이 라벨과 버튼을 가지고 있다
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
	
	//커스터마이징 된 패널 생성,
	//패널이 태어날때, 그 부품도 같이 태어나야 하므로, 생성자에서 초기화하자!!
	public MyPanel(String title, Icon icon){
		la=new JLabel(title);
		bt=new JButton(icon);		
		
		this.setLayout(new BorderLayout());
		this.add(la,  BorderLayout.NORTH);
		this.add(bt);
		
		bt.setBorderPainted(false); //버튼의 경계선 없애기
		bt.setContentAreaFilled(false); //컨텐트 영역의 색 채우기 없앰
		bt.setFocusPainted(false); //포커스에 의한 경계 없애기
		bt.setOpaque(false); //투명으로 설정하기 
	
		
		
	}
	
	

}
