import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame {

	public MyFrame() throws HeadlessException {
		super();
		
		this.setTitle("图书信息及借阅管理系统");
		this.setSize(600,320);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		StuPanel p1 = new StuPanel();
		this.add(p1);
		this.setVisible(true);
	}
	
}

class StuPanel extends JPanel{

	private JTextField stuNo=new JTextField();											
	private JTextField stuName=new JTextField();										
	private JTextField stuSex=new JTextField();											
	private JTextField stuBirthday=new JTextField();
	
	StuPanel(){
		this.setLayout(null);
		JLabel lb1=new JLabel("学号：");
		lb1.setBounds(30, 40, 100, 20);
		this.add(lb1);
		stuNo.setBounds(100,40, 100, 20);
		this.add(stuNo);
		JLabel lb2=new JLabel("姓名：");
		lb2.setBounds(30, 90, 100, 20);
		this.add(lb2);
		stuName.setBounds(100,90, 100, 20);
		this.add(stuName);
		JLabel lb3=new JLabel("性别：");
		lb3.setBounds(30, 140, 100, 20);
		this.add(lb3);
		stuSex.setBounds(100,140, 100, 20);
		this.add(stuSex);
		JLabel lb4=new JLabel("出生日期：");
		lb4.setBounds(30, 190, 100, 20);
		this.add(lb4);
		stuBirthday.setBounds(100,190, 100, 20);
		this.add(stuBirthday);
	}
}