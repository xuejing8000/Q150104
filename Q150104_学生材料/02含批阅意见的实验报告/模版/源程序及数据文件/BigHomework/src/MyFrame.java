import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame {

	public MyFrame() throws HeadlessException {
		super();
		
		this.setTitle("学生成绩管理系统");
		this.setSize(700,320);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		StuPanel p1 = new StuPanel();
		this.add(p1);
		this.setVisible(true);
	}
	
}

class StuPanel extends JPanel{

	private JTextField stuNo=new JTextField();											//学号
	private JTextField stuName=new JTextField();										//姓名
	private JTextField stuSex=new JTextField();											//性别
	private JTextField stuBirthday=new JTextField();
	
	StuPanel(){
		this.setLayout(null);
		//显示学号
		JLabel lb1=new JLabel("学号：");
		lb1.setBounds(30, 10, 100, 20);
		this.add(lb1);
		stuNo.setBounds(100,10, 100, 20);
		this.add(stuNo);
		//显示姓名
		JLabel lb2=new JLabel("姓名：");
		lb2.setBounds(30, 60, 100, 20);
		this.add(lb2);
		stuName.setBounds(100,60, 100, 20);
		this.add(stuName);
		//显示性别
		JLabel lb3=new JLabel("性别：");
		lb3.setBounds(30, 110, 100, 20);
		this.add(lb3);
		stuSex.setBounds(100,110, 100, 20);
		this.add(stuSex);
		//显示出生日期
		JLabel lb4=new JLabel("生日：");
		lb4.setBounds(30, 160, 100, 20);
		this.add(lb4);
		stuBirthday.setBounds(100,160, 100, 20);
		this.add(stuBirthday);
	}
}
