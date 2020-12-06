package dao;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import com.mchange.v2.c3p0.impl.NewPooledConnection;
import c3p0.c3p0utils;
import javabean.stu_score;
public class managercougetdata {
	public ArrayList<stu_score> cougetstu(int id) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0utils.getDataSource());
		ArrayList<stu_score> stuscoreArrayList = (ArrayList<stu_score>) queryRunner.query(
				"select sid,sname,smajor,mscore from student,middle where mcid=? and sid=msid",
				new BeanListHandler<stu_score>(stu_score.class), id);
		return stuscoreArrayList;
	}
	public ArrayList<stu_score> cougetstubyname(String nameString) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0utils.getDataSource());
		ArrayList<stu_score> stuscoreArrayList = (ArrayList<stu_score>) queryRunner.query(
				"select sid,sname,smajor,mscore from student,middle,course where mcid=cid and sid=msid and cname=?",
				new BeanListHandler<stu_score>(stu_score.class), nameString);
		return stuscoreArrayList;
	}
}
