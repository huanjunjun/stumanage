package dao;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import c3p0.c3p0utils;
import javabean.coursescore;
public class stugetmyscore {
	public ArrayList<coursescore> getCoursescore(int sid) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0utils.getDataSource());
		ArrayList<coursescore> coursescores = (ArrayList<coursescore>) queryRunner.query(
				"select cid,cname,mscore from student,middle,course where sid=msid and cid=mcid and sid=? ",
				new BeanListHandler<coursescore>(coursescore.class), sid);
		return coursescores;
	}
}
