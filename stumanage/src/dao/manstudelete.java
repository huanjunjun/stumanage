package dao;
import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;
import c3p0.c3p0utils;
public class manstudelete {
	 public int delete(int sid) throws SQLException
     {
   	  QueryRunner queryRunner=new QueryRunner(c3p0utils.getDataSource());
   	  int flag=queryRunner.update("delete from student where sid=?",sid);
		  return flag;
     }
}
