package dao;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import com.mchange.v2.c3p0.impl.NewPooledConnection;
import c3p0.c3p0utils;
import javabean.course;
public class stushowallcou {
      public ArrayList<course> showallCourse() throws SQLException
      {
    	  QueryRunner queryRunner=new QueryRunner(c3p0utils.getDataSource());
    	  ArrayList<course> courses=(ArrayList<course>) queryRunner.query("select * from course",new BeanListHandler<course>(course.class));
    	  return courses;
      }
}
