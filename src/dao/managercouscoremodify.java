package dao;
import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import c3p0.c3p0utils;
public class managercouscoremodify {
	 public int modifyscorebyid(int cid,int sid,int score) throws SQLException
     {
   	  QueryRunner queryRunner=new QueryRunner(c3p0utils.getDataSource());
   	  int num=queryRunner.update("update middle set mscore=? where msid=? and mcid=?",score,sid,cid);
   	  return num;
     }
	 public int modifyscorebyname(String cname,int sid,int score) throws SQLException
     {
   	  QueryRunner queryRunner=new QueryRunner(c3p0utils.getDataSource());
   	  Object object=queryRunner.query("select cid from course where cname=?", new ScalarHandler(),cname);
   	  int num=queryRunner.update("update middle set mscore=? where msid=? and mcid=?",score,sid,((Integer)object).intValue());
   	  return num;
     }
}
