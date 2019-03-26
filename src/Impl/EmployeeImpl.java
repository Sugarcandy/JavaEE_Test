package Impl;

import Dao.EmployeeDao;
import bean.Employee;
import com.liuvei.common.DbFun;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static bean.Dbcon.getData;

/**
 * @author chen
 * @create 2019/3/14 0014
 */
public class EmployeeImpl implements EmployeeDao {


    public Long insert(Employee bean) {
        Long result = 0L;

        StringBuffer sbSQL = new StringBuffer();
        List<Object> paramsList = new ArrayList<Object>();
        sbSQL.append(" Insert into Employee");
        sbSQL.append(" (");
        sbSQL.append("empno, ename, password");
        sbSQL.append(" )");
        sbSQL.append(" values(?,?,?)");

        paramsList.add(bean.getEmpNo());
        paramsList.add(bean.getName());
        paramsList.add(bean.getPassWord());

        result=getData(sbSQL,paramsList);
        return result;
    }

    @Override
    public Long delete(Long id) {
        Long result = 0L;

        StringBuffer sbSQL = new StringBuffer();
        List<Object> paramsList = new ArrayList<Object>();

        sbSQL.append(" delete from employee");
        sbSQL.append(" where empno=?");

        paramsList.add(id);

        result=getData(sbSQL,paramsList);

        return result;
    }

    @Override
    public Long update(Employee bean) {
        Long result = 0L;

        StringBuffer sbSQL = new StringBuffer();
        List<Object> paramsList = new ArrayList<Object>();

        sbSQL.append("update employee set ");
        sbSQL.append("ename=?, password=?");
        sbSQL.append(" where empno=?");

        paramsList.add(bean.getName());
        paramsList.add(bean.getPassWord());
        paramsList.add(bean.getEmpNo());

        result=getData(sbSQL,paramsList);

        return result;
    }

    @Override
    public Employee loadbyNo(String id) {
        Employee bean = null;

        StringBuffer sbSQL = new StringBuffer();
        List<Object> paramsList = new ArrayList<Object>();

        sbSQL.append(" select * from Employee");
        sbSQL.append(" where empno=?");

        paramsList.add(id);

        String sql = sbSQL.toString();
        Object[] params = paramsList.toArray();

        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = DbFun.getConn();

            rs = DbFun.query(conn, sql, params);

            while (rs.next()) {
                bean = toBean(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DbFun.close(conn);
        }

        return bean;
    }

    private Employee toBean(ResultSet rs) {

        Employee bean = new Employee();

        try {
            bean.setEmpNo(rs.getLong("empno"));
            bean.setName(rs.getString("ename"));
            bean.setPassWord(rs.getString("password"));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

            throw new RuntimeException(e);
        }

        return bean;
    }

}
