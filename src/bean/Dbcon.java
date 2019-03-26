package bean;


import Dao.EmployeeDao;
import Impl.EmployeeImpl;
import com.liuvei.common.DbFun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 * @author chen
 * @create 2019/3/14 0014
 */
public class Dbcon {
    public static Long getData(StringBuffer sbSQL, List<Object> paramsList){
        Long result=0L;
        String sql = sbSQL.toString();
        Object[] params = paramsList.toArray();
        Connection conn = null;
        try {
            conn = DbFun.getConn();

            result = DbFun.update(conn, sql, params);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DbFun.close(conn);
        }
        return result;
    }
}
