package dao;
import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;
import com.alibaba.fastjson.serializer.AdderSerializer;
import c3p0.c3p0utils;
public class manageraddstu {
       public int insert(int sid,String name,String sex,int age,String major,String password) throws SQLException
       {
    	   System.out.println("3");
    	   QueryRunner queryRunner=new QueryRunner(c3p0utils.getDataSource());
    	   int num=queryRunner.update("insert into student values (?,?,?,?,?,?)",sid,name,sex,major,age,password);
    	   System.out.println("2");
    	   return num;
       }
}
