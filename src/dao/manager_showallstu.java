package dao;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import com.mchange.v2.c3p0.impl.NewPooledConnection;
import c3p0.c3p0utils;
import javabean.student;
public class manager_showallstu {
	public ArrayList<student> showall() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0utils.getDataSource());
		ArrayList<student> students = (ArrayList<student>) queryRunner.query("select * from student",
				new BeanListHandler<student>(student.class));
		return students;
	}
}
