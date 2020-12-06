package dao;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import c3p0.c3p0utils;
import javabean.course;
public class stumycourse {
	public ArrayList<course> getmyCourses(int sid) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0utils.getDataSource());
		ArrayList<course> courses = (ArrayList<course>) queryRunner.query(
				"select cid,cname from middle,course where cid=mcid and ?=msid ",
				new BeanListHandler<course>(course.class), sid);
		return courses;
	}
}
