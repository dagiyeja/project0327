package progressbar;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;



public class ProgressBarTest extends JFrame {
	JProgressBar[] bar=new JProgressBar[3];
	MyBar[] mb=new MyBar[3];
	int[] interval={100,500,1000};
	
	JButton bt;
	
	public ProgressBarTest() {
		setLayout(new FlowLayout());
		
		for(int i=0; i<bar.length; i++){
			bar[i]=new JProgressBar(); //bar[i]를 JProgressBar에 넣을거야
			mb[i]=new MyBar(bar[i],interval[i]);
			bar[i].setPreferredSize(new Dimension(450, 40));
			add(bar[i]);
		}
		
		bt=new JButton("작동");
	
		
		add(bt);
		
		
		setSize(500,230);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		new ProgressBarTest();
	}

}
