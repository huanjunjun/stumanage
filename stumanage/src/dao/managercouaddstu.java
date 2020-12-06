package dao;
import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;
import c3p0.c3p0utils;
public class managercouaddstu {
      public int addstu(int sid,int cid) throws SQLException
      {
    	  QueryRunner queryRunner=new QueryRunner(c3p0utils.getDataSource());
    	  int num =queryRunner.update("insert into middle values (?,?,null)",sid,cid);
    	  return num;
      }
}
