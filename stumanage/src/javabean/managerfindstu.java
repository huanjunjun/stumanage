package javabean;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import com.mchange.v2.c3p0.impl.NewPooledConnection;
import c3p0.c3p0utils;
public class managerfindstu {
	public student findbyid(int id) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0utils.getDataSource());
		student student=queryRunner.query("select * from student where sid=?", 
				new BeanHandler<student>(student.class), id);
		return student;
	}
	public ArrayList<student> findbyname(String name) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0utils.getDataSource());
		ArrayList<student> students = (ArrayList<student>) queryRunner.query("select * from student where sname=?",
				new BeanListHandler<student>(student.class),name);
		return students;
	}
}
