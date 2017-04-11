/*��Ʈ���� �������� ���� ���-�� �ڵ� �����ϱ�ڡ�*/
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
		
		bt_open=new JButton("����");
		bt_save=new JButton("����");
		bt_copy=new JButton("�������");
		
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
			
			//����� �ν��Ͻ��� �̿��Ͽ� ������ ���
			String path=file.getAbsolutePath();
			
			//���� ��� �ؽ�Ʈ �ʵ忡 ����ϱ�
			t_open.setText(path);
		}
	}
	public void save(){
		int state = chooser.showSaveDialog(this);
		if(state==JFileChooser.APPROVE_OPTION){
		File file=chooser.getSelectedFile(); //���� ó�� ���� ��ü���� ������ ��! ���⼭�� File . ->File�̶�� Ŭ���� �޾ƿ�
		
		//����Ŭ������ ������ ������ �޼��带 �̿��Ͽ� ��� ��ȯ
		String path=file.getAbsolutePath();
		
		t_save.setText(path);
		}
	}
	
	//read()�޼��带 �����忡 ���̱�. main�� ����
	public void copy(){
		String oriPath=t_open.getText();
		String destPath=t_save.getText();

		try{
			fis=new FileInputStream(oriPath);
			fos=new FileOutputStream(destPath);
			
			SaveThread st=new SaveThread(bar);

			int data=-1; //-1�� �ƹ��͵� ���� ���� ���� ,�ʱⰪ ���൵ ������� ������ read���� �ʱ�ȭ�ϹǷ�
			while(true){
				data=fis.read(); //���� �������� ���α׷����� 1byte �о����! 
				if(data==-1)break;
				fos.write(data); //�����Ͱ� -1�̹Ƿ� ���� ���� ���� ��Ȳ���� ���͵� ����
			
			}
			JOptionPane.showMessageDialog(this, "����Ϸ�");
		}catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(this, "������ ã�� �� �����ϴ�.");
			
			//try�� �ȿ��� ���� ��� ������ ->�����ϱ� ���� finally���
		}catch(IOException e){
			JOptionPane.showMessageDialog(this, "IO�۾��� ���� �߻��߳׿�");
		}finally{
			try{
				//��ü�� �޸𸮿� �ö�Դٸ�..
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
