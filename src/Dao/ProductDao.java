package Dao;

import bean.Product;

import java.util.List;

/**
 * @author chen
 * @create 2019/3/21 0021
 */
public interface ProductDao {

    Long insert(Product bean);

    Long delete(Long id);

    Long update(Product bean);

    Product loadbyNo(String id);

    List<Product> load();
}
