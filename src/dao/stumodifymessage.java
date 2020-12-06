package dao;
import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;
import c3p0.c3p0utils;
public class stumodifymessage {
      public int modify(int sid,int sage,String sname,String ssex,String spassword) throws SQLException
      {
    	  QueryRunner queryRunner=new QueryRunner(c3p0utils.getDataSource());
    	  
    	  int num=queryRunner.update("update student set sname=?,ssex=?,sage=?,spassword=? where sid=?",sname,ssex,sage,spassword,sid);
    	  System.out.println(num);
    	  return num;
      }
}
