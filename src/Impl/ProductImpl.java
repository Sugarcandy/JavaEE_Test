package Impl;

import Dao.ProductDao;
import bean.Product;
import com.liuvei.common.DbFun;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static bean.Dbcon.getData;

/**
 * @author chen
 * @create 2019/3/21 0021
 */
public class ProductImpl implements ProductDao {

    public Long insert(Product bean) {
        Long result = 0L;

        StringBuffer sbSQL = new StringBuffer();
        List<Object> paramsList = new ArrayList<Object>();
        sbSQL.append(" Insert into Product");
        sbSQL.append(" (");
        sbSQL.append("productId, productName, price, address");
        sbSQL.append(" )");
        sbSQL.append(" values(?,?,?,?)");

        paramsList.add(bean.getProductId());
        paramsList.add(bean.getProductName());
        paramsList.add(bean.getPrice());
        paramsList.add(bean.getAddress());

        result=getData(sbSQL,paramsList);
        return result;
    }

    @Override
    public Long delete(Long id) {
        Long result = 0L;

        StringBuffer sbSQL = new StringBuffer();
        List<Object> paramsList = new ArrayList<Object>();

        sbSQL.append(" delete from Product");
        sbSQL.append(" where productId=?");

        paramsList.add(id);

        result=getData(sbSQL,paramsList);
        return result;
    }

    @Override
    public Long update(Product bean) {
        Long result = 0L;

        StringBuffer sbSQL = new StringBuffer();
        List<Object> paramsList = new ArrayList<Object>();

        sbSQL.append("update Product set ");
        sbSQL.append("productName=?, price=?, address=?");
        sbSQL.append(" where productId=?");

        paramsList.add(bean.getProductName());
        paramsList.add(bean.getPrice());
        paramsList.add(bean.getAddress());
        paramsList.add(bean.getProductId());

        result=getData(sbSQL,paramsList);
        return result;
    }

    @Override
    public Product loadbyNo(String id) {
        Product bean = null;

        StringBuffer sbSQL = new StringBuffer();
        List<Object> paramsList = new ArrayList<Object>();

        sbSQL.append(" select * from Product");
        sbSQL.append(" where productId=?");

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

    @Override
    public List<Product> load() {
        List<Product> list=new ArrayList<>();
        StringBuffer sbSQL = new StringBuffer();
        sbSQL.append("select * from Product");
        String sql=sbSQL.toString();
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = DbFun.getConn();
            rs = DbFun.query(conn, sql);
            while (rs.next()) {
                list.add(toBean(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DbFun.close(conn);
        }
        return list;
    }

    private Product toBean(ResultSet rs) {

        Product bean = new Product();

        try {
            bean.setProductId(rs.getString("productId"));
            bean.setProductName(rs.getString("productName"));
            bean.setPrice(rs.getInt("price"));
            bean.setAddress(rs.getString("address"));
        } catch (SQLException e) {
            e.printStackTrace();

            throw new RuntimeException(e);
        }

        return bean;
    }
}
