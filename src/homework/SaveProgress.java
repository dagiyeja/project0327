/*스트림과 쓰레드의 복합 사용-이 코드 이해하기★★*/
package homework;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class SaveProgress extends JFrame implements ActionListener{
	JProgressBar bar;
	JButton bt_open, bt_save, bt_copy;
	JTextField t_open, t_save;
	FileInputStream fis;
	FileOutputStream fos;
	
	JFileChooser chooser;
	SaveThread st;
	
	public SaveProgress() {
		bar=new JProgressBar();
		bar.setPreferredSize(new Dimension(400, 40));
		
		bt_open=new JButton("열기");
		bt_save=new JButton("저장");
		bt_copy=new JButton("복사실행");
		
		t_open=new JTextField("C:/java_workspace2/project0327",30);
		t_save=new JTextField("C:/java_workspace2/project0327",30);
		
		setLayout(new FlowLayout());
		add(bar,BorderLayout.NORTH);
		add(bt_open);
		add(t_open);
		add(bt_save);
		add(t_save);
		add(bt_copy,BorderLayout.SOUTH);
		
		bt_open.addActionListener(this);
		bt_save.addActionListener(this);
		bt_copy.addActionListener(this);
			
		chooser=new JFileChooser("C:/java_workspace2/project0327");
		
		setSize(450,230);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if(obj==bt_open){
			open();
		}else if(obj==bt_save){
			save();
		}else if(obj==bt_copy){
			copy();
		}
		
	}
	
	public void open(){
		int state = chooser.showOpenDialog(this);
		if(state == JFileChooser.APPROVE_OPTION) {
			File file=chooser.getSelectedFile();
			
			//얻어진 인스턴스를 이용하여 절대경로 얻기
			String path=file.getAbsolutePath();
			
			//절대 경로 텍스트 필드에 출력하기
			t_open.setText(path);
		}
	}
	public void save(){
		int state = chooser.showSaveDialog(this);
		if(state==JFileChooser.APPROVE_OPTION){
		File file=chooser.getSelectedFile(); //난생 처음 보는 객체명을 만났을 때! 여기서는 File . ->File이라는 클래스 받아옴
		
		//파일클래스가 보유한 절대경로 메서드를 이용하여 경로 반환
		String path=file.getAbsolutePath();
		
		t_save.setText(path);
		}
	}
	
	//read()메서드를 스레드에 붙이기. main에 말고
	public void copy(){
		String oriPath=t_open.getText();
		String destPath=t_save.getText();

		try{
			fis=new FileInputStream(oriPath);
			fos=new FileOutputStream(destPath);
			
			SaveThread st=new SaveThread(bar);

			int data=-1; //-1은 아무것도 읽지 않은 상태 ,초기값 안줘도 상관없다 어차피 read에서 초기화하므로
			while(true){
				data=fis.read(); //현재 실행중인 프로그램으로 1byte 읽어들임! 
				if(data==-1)break;
				fos.write(data); //데이터가 -1이므로 읽을 것이 없는 상황에서 쓸것도 없다
			
			}
			JOptionPane.showMessageDialog(this, "복사완료");
		}catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(this, "파일을 찾을 수 없습니다.");
			
			//try문 안에서 닫을 경우 문제점 ->보완하기 위해 finally사용
		}catch(IOException e){
			JOptionPane.showMessageDialog(this, "IO작업중 에러 발생했네요");
		}finally{
			try{
				//객체가 메모리에 올라왔다면..
				if(fis!=null){
					fis.close();
				}if(fos!=null){
					fos.close();
				}
			}catch(IOException e){
			
			}
		}
	}
	
	public static void main(String[] args) {
		new SaveProgress();

	}

	

}
