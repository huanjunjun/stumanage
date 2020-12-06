package dao;
import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;
import c3p0.c3p0utils;
public class studeletecou {
	public int deletecou(int cid, int sid) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0utils.getDataSource());
		int num = queryRunner.update("delete from middle where mcid=? and msid=? ", cid, sid);
	    return num;
	}
}
