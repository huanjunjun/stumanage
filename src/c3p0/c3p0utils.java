package c3p0;
import java.sql.Connection;
import java.sql.SQLException;
import javax.activation.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.impl.NewPooledConnection;
public class c3p0utils {
       private static final ComboPooledDataSource comboPooledDataSource=new  ComboPooledDataSource();
       public static Connection getConnection() throws SQLException
       { 
    	   return comboPooledDataSource.getConnection();
       }
       public static ComboPooledDataSource getDataSource()
       {
    	   return comboPooledDataSource;
       }
}
