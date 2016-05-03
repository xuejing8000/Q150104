public class Main {

	public static void main(String[] args) {
		//建立一个窗体对象
		MyFrame f = new MyFrame();
	}

}

class Student{
	private String stuNo;				//学号
	private String stuName;				//姓名
	private String stuSex;				//性别
	private String stuBirthday;			//出生日期
	
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