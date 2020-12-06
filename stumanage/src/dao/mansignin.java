package dao;
import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import com.mchange.v2.c3p0.impl.NewPooledConnection;
import c3p0.c3p0utils;
import javabean.manager;
public class mansignin {
	public manager signin(manager manager1) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0utils.getDataSource());
		manager existManager= queryRunner.query("select * from manager where mname=? and mpassword=?",
				new BeanHandler<manager>(manager.class), manager1.getMname(), manager1.getMpassword());
		return existManager;
	}
}
