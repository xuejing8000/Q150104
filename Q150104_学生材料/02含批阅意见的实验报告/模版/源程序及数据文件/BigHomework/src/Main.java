import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Vector;

import javax.swing.*;

public class Main{
	public static void main(String[] args) {
		MainFrame f = new MainFrame();
	}
}

class MainFrame extends JFrame {
	Vector stuList=new Vector();
	
	MainFrame(){
		super("ѧ���ɼ�����ϵͳ");
		
		this.setTitle("ѧ���ɼ�����ϵͳ");
		this.setSize(700,320);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		this.readStuFile();
		this.showStuPanel();
		this.setVisible(true);

		this.setResizable(false);
		this.setSize(700,320);
		this.setLocationRelativeTo(this.getOwner());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	void readStuFile(){
		try {
			FileInputStream fis;
			fis = new FileInputStream("Student.txt");
			InputStreamReader dis=new InputStreamReader(fis);
			BufferedReader reader=new BufferedReader(dis);
			String s;
			while((s=reader.readLine())!=null)
			{
				Student stu=new Student();
				String[] temp=s.split(" ");
				stu.setStuNo(temp[0]);
				stu.setStuName(temp[1]);
				stu.setStuSex(temp[2]);
				stu.setStuBirthday(temp[3]);
				stuList.add(stu);
			}
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	}
	
	void showStuPanel(){
		StuPanel stuPanel=new StuPanel();
		stuPanel.stuList=this.stuList;
		this.add(stuPanel,BorderLayout.CENTER);
		stuPanel.showStudent(0);
		this.setVisible(true);
	}
}

class StuPanel extends JPanel implements ActionListener {
	private JTextField stuNo=new JTextField();											//ѧ��
	private JTextField stuName=new JTextField();										//����
	private JTextField stuSex=new JTextField();											//�Ա�
	private JTextField stuBirthday=new JTextField();									//��������
	Vector stuList=new Vector();
	private String[] btnStr={"��һ��","��һ��","��һ��","���һ��","���","�޸�","ɾ��"};
	private JButton[] btn= new JButton[btnStr.length];
	int count=0,current=0,inserting=0;
	
	StuPanel(){
		this.setLayout(null);
		//��ʾѧ��
		JLabel lb1=new JLabel("ѧ�ţ�");
		lb1.setBounds(30, 10, 100, 20);
		this.add(lb1);
		stuNo.setBounds(100,10, 100, 20);
		this.add(stuNo);
		//��ʾ����
		JLabel lb2=new JLabel("������");
		lb2.setBounds(30, 60, 100, 20);
		this.add(lb2);
		stuName.setBounds(100,60, 100, 20);
		this.add(stuName);
		//��ʾ�Ա�
		JLabel lb3=new JLabel("�Ա�");
		lb3.setBounds(30, 110, 100, 20);
		this.add(lb3);
		stuSex.setBounds(100,110, 100, 20);
		this.add(stuSex);
		//��ʾ��������
		JLabel lb4=new JLabel("���գ�");
		lb4.setBounds(30, 160, 100, 20);
		this.add(lb4);
		stuBirthday.setBounds(100,160, 100, 20);
		this.add(stuBirthday);
		//��ʾ���ư�ť
		for(int i=0;i<btn.length;i++){
			btn[i]=new JButton(btnStr[i]);
			btn[i].setBounds(30+i*90, 210, 90, 30);
			btn[i].addActionListener(this);
			this.add(btn[i]);
		}
	}
	
	void showStudent(int offset){
		Student stu=(Student) stuList.get(offset);
		this.stuNo.setText(stu.getStuNo());
		this.stuName.setText(stu.getStuName());
		this.stuSex.setText(stu.getStuSex());
		this.stuBirthday.setText(stu.getStuBirthday());
	}

	public void actionPerformed(ActionEvent e) {
		count=this.stuList.size();
		if(e.getSource()==this.btn[0]){
			this.showStudent(0);
			current=0;
		}
		if(e.getSource()==this.btn[1] && current>0){
			this.showStudent(current-1);
			current=current-1;
		}
		if(e.getSource()==this.btn[2] && current<count-1){
			this.showStudent(current+1);
			current=current+1;
		}
		if(e.getSource()==this.btn[3]){
			this.showStudent(count-1);
			current=count-1;
		}
		if(e.getSource()==this.btn[4]){
			if(this.inserting==0){
				this.stuNo.setText("");
				this.stuName.setText("");
				this.stuSex.setText("");
				this.stuBirthday.setText("");
				btn[4].setText("����");
				btn[5].setText("ȡ��");
				this.inserting=1;
			}else{
				Student stu=new Student();
				stu.setStuNo(this.stuNo.getText().trim());
				stu.setStuName(this.stuName.getText().trim());
				stu.setStuSex(this.stuSex.getText().trim());
				stu.setStuBirthday(this.stuBirthday.getText().trim());
				stuList.add(stu);
				count++;
				current=count-1;
				btn[4].setText("���");
				btn[5].setText("�޸�");
				this.inserting=0;
			}
			for(int i=0;i<btn.length;i++){
				if(i==4||i==5) continue;
				btn[i].setEnabled(!btn[i].isEnabled());
			}
		}

		if(e.getSource()==this.btn[5]){
			if(this.inserting==0){
				Student stu=(Student)stuList.get(current);
				stu.setStuNo(this.stuNo.getText().trim());
				stu.setStuName(this.stuName.getText().trim());
				stu.setStuSex(this.stuSex.getText().trim());
				stu.setStuBirthday(this.stuBirthday.getText().trim());
			}else{
				btn[4].setText("���");
				btn[5].setText("�޸�");
				for(int i=0;i<btn.length;i++){
					if(i==4||i==5) continue;
					btn[i].setEnabled(!btn[i].isEnabled());
				}
				this.inserting=0;
				this.showStudent(current);
			}
		}
		if(e.getSource()==this.btn[6]){
			if(count==0)
				return;
			stuList.remove(current);
			count--;
			if(count==0){
				this.stuNo.setText("");
				this.stuName.setText("");
				this.stuSex.setText("");
				this.stuBirthday.setText("");
			}else{
				if(current>count-1){
					this.showStudent(current-1);
					current=current-1;
				}
				else
					this.showStudent(current);
			}
		}
		this.repaint();
	}
}

class Student {
	private String stuNo;											//ѧ��
	private String stuName;										//����
	private String stuSex;											//�Ա�
	private String stuBirthday;									//��������
	
	public String getStuNo() {
		return stuNo;
	}
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuSex() {
		return stuSex;
	}
	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}
	public String getStuBirthday() {
		return stuBirthday;
	}
	public void setStuBirthday(String stuBirthday) {
		this.stuBirthday = stuBirthday;
	}
}

class Course{
	private String courseNo;										//�γ̱��
	private String courseName;									//�γ�����
	private double courseScore;								//�γ�ѧ��
	private String teacher;											//�ον�ʦ
	
	public String getCourseNo() {
		return courseNo;
	}
	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public double getCourseScore() {
		return courseScore;
	}
	public void setCourseScore(double courseScore) {
		this.courseScore = courseScore;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
}

class Score{
	private String stuNo;											//ѧ��
	private String courseNo;										//�γ̴���
	private double score;											//�ɼ�
	
	public String getStuNo() {
		return stuNo;
	}
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	public String getCourseNo() {
		return courseNo;
	}
	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
}