package io;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MemoEditor extends JFrame{
	JPanel p_north;
	JButton bt_open, bt_save;
	ImageIcon icon; //�Ϲ� Ŭ����!! Icon�������̽��� ��ӹ���
	JTextArea area;
	JScrollPane scroll;
	
	//������ ������� �Է��ؾ� �ϹǷ�..
	FileInputStream fis;
	FileOutputStream fos; //���ڱ���� �Է½�Ʈ�� // �� ���� ���� ����
	
	
	InputStreamReader reader; //fis ����
	BufferedReader buffr; //����ó���� ���ڱ�� �Է½�Ʈ��(�ѱ� �ȱ���, ���� ĥ������ ����ó����)
	
	//���ڱ���� ��½�Ʈ��
	OutputStreamWriter writer;
	PrintWriter writer2; //���ڱ���� ��½�Ʈ��
	
	String ori="C:/Java_workspace2/project0327/res/memo.txt"; //����
	String dest="C:/Java_workspace2/project0327/res/memo_copy.txt"; //�ٸ� ������ ������

	public MemoEditor(){
		p_north = new JPanel();
		icon=new ImageIcon("C:/java_workspace2/project0327/res/folder_on.png");
		bt_open = new JButton(icon);
		bt_save = new JButton("����");
		area = new JTextArea(20,30);
		scroll = new JScrollPane(area);
		
		p_north.add(bt_open);
		p_north.add(bt_save);
		
		bt_open.setBorderPainted(false);
		bt_open.setContentAreaFilled(false);
		bt_open.setOpaque(false);
		bt_open.setFocusPainted(false);
		
		add(p_north,BorderLayout.NORTH);
		add(scroll);
		
		//��ư 2�� �����͸����� ����~!
		bt_open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				open();
				
			}
		});
		
		bt_save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				save();
				
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(700, 600);
		
		
	}
	
	//���� �޼���
	public void open(){
		try { //Ư�� ���Ͽ� ���븦 �� ���� ����
			fis = new FileInputStream(ori);
			//���ڱ�� ��Ʈ������ ������ �ڵ��Ӽ��� ������ �� �ִ�.
			reader = new InputStreamReader(fis,"utf-8");
			//fis ���� ���ڱ�� ��Ʈ���� !!
			buffr=new BufferedReader(reader); //�� 3������ �� ������ ����
			
			String data; //int �� �⺻�ڷ��� ,, string �� ��ü�ڷ����� ���Ѵ�!!
			int count=0; //read Ƚ���� �˱�����!!
			
			
			while(true){
			data=buffr.readLine(); //fis ���� 1byte �о���δ�!! // reader �� ����ϴ� 2byte �� ó���Ѵ�!!
			//read() �޼��尡 ���� �ϳ����� ��� �Ͼ. ->�ټ���ŭ �е��� �����غ���(�ӵ� ���)
			count++;
			
			if(data==null)break;
			//char�����ιٲٰ� ĳ���������� ��Ʈ����ü��
			area.append(data+"\n"); //ä���Ҷ� ���밡 3�ܰ�� ���׷��̵� �Ǿ��ٰ� ����
			}
			System.out.println("count="+count);
			
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this, "������ �������� �ʽ��ϴ�."); // - ����ڸ� ���� ���� �α�!!
			e.printStackTrace(); //printStackTrace ������ ���ñ����� �׿��ִ°��� �����Ѵ�.. ���������� console�� ������ 
			//��Ÿ�����ʾ� �����ڰ� Ȯ�� �Ұ� - �����ڸ� ���� ���� �α� ����..
		} catch (IOException e) {//addSurrounding try���� �߰���..
			e.printStackTrace();
		}
		
		
		
	}
	
	//���� �޼���
	public void save(){
		
		try{
			//FileOutputStream�� ������ ����� ������
			//������ ������ ũ��� 0byte�� empty������
			fos=new FileOutputStream(dest);
			//writer=new OutputStreamWriter(fos, "utf-8");
			writer2=new PrintWriter(fos);
			writer2.write(area.getText());
			} catch (FileNotFoundException  e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch(IOException e){
			e.printStackTrace();
		}finally{
			//������� ��Ʈ���� ���� �ݴ� ó��..
			if(writer!=null){ //�����Ѵٸ� �ݴ´�
				writer2.close();
			}
			if(fos!=null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}	
}
	
	
	public static void main(String[] args) {
		new MemoEditor();

	}

}
