package dao;
import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import c3p0.c3p0utils;
import javabean.middle;
public class stuchoosecou {
      public String choosesou(int sid,int cid) throws SQLException
      {
    	  QueryRunner queryRunner=new QueryRunner(c3p0utils.getDataSource());
    	  middle middle1=null;
    	  try {
			middle1=queryRunner.query("select * from middle where msid=? and mcid=?",new BeanHandler<middle>(middle.class),sid,cid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  int num=0;
    	if (middle1 ==null) {
			  num=queryRunner.update("insert into middle values(?,?,null)",sid,cid);
		      if (num>0) {
				return "ѡ�γɹ���";
			}
		      else {
				return "ѡ��ʧ�ܣ�";
			}
    	}
    	else {
    		return "����ѡ���ÿΣ������ظ�ѡ�Σ�";
		}
      }
}
