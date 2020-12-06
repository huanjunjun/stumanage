package javabean;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class createsqlfile {
	public static void main(String[] args) throws IOException {
		middle();
	}
	public static void student() throws IOException {
		String[] firstname = { "张", "王", "李", "刘", "赵", "钱", "孙", "周", "吴", "郑", "王", "冯", "陈", "卫", "朱", "秦", "尤", "许",
				"孔", "曹" };
		String[] secondname = { "伟", "芳", "秀", "英", "娜", "静", "丽", "敏", "洋", "强", "鹏", "硕", "军", "磊", "艳", "杰", "娟",
				"涛", "霞", "平", "刚" };
		String[] sex = { "男", "女" };
		String[] major = { "自动化与机械", "计算机", "大数据科学", "物联网技术", "通信技术", "人文经法", "管理", "数学", "物理", "化学", "临床医学" };
		String[] age = { "18", "19", "20", "21", "22" };
		String password = "123456";
		FileWriter writer = new FileWriter("C:/Users/Administrator/Desktop/studentmessage.txt");
		writer.write("");
		for (int i = 2; i < 9999; i++) {
			String name1 = firstname[(int) (Math.random() * firstname.length)];
			String name2 = secondname[(int) (Math.random() * secondname.length)];
			String name = name1 + name2;
			String sexString = sex[(int) (Math.random() * sex.length)];
			String majorString = major[(int) (Math.random() * major.length)];
			String ageString = age[(int) (Math.random() * age.length)];
			String passwordString = password;
			String sqlString = "insert into student values (" + (i+20200000) + ",'" + name + "','" + sexString + "','" + majorString
					+ "'," + ageString+",'"+passwordString+"');\r\n";
			writer.write(sqlString);
		}
		 writer.flush();
         writer.close();
         System.out.println("完成");
	}
	public static void middle() throws IOException {
		int course=1;
		int courseid=0;
		String sqlString="";
		FileWriter writer = new FileWriter("C:/Users/Administrator/Desktop/middlemessage.txt");
		writer.write("");
		for(int i=1;i<1000;i++)
		{
			for(int j=0;j<8;j++)
			{
				course+=3;
				courseid=course%60;
				sqlString = "insert into middle values ("+(i+20200000)+","+courseid+","+(int)Math.rint((Math.random() * 100))+");\r\n";
				writer.write(sqlString);
			}
		}
		
		 writer.flush();
        writer.close();
	}
}
