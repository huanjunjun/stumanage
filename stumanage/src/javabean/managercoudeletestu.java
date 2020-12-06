package javabean;
import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import c3p0.c3p0utils;
public class managercoudeletestu {
	public int deletebyid(int cid,int sid) throws SQLException
	{
		System.out.println(cid+" "+sid);
		QueryRunner queryRunner=new QueryRunner(c3p0utils.getDataSource());
		int num=queryRunner.update("delete from middle where mcid=? and msid=?",cid,sid);
		return num;
	}
	public int deletebyname(String cname,int sid) throws SQLException
	{
		System.out.println(cname+" "+sid);
		QueryRunner queryRunner=new QueryRunner(c3p0utils.getDataSource());
		Object object=queryRunner.query("select cid from course where cname=?", new ScalarHandler(),cname);
		System.out.println(((Integer)object).intValue());
		int num=queryRunner.update("delete from middle where mcid=? and msid=?",((Integer)object).intValue(),sid);
		return num;
	}
}
