package dao;
import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import c3p0.c3p0utils;
import javabean.student;
public class studentsignin {
	public student studentsignin(student student1) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0utils.getDataSource());
		student existStudent = queryRunner.query("select * from student where sid=? and spassword=?",
				new BeanHandler<student>(student.class), student1.getSid(), student1.getSpassword());
		return existStudent;
	}
}
