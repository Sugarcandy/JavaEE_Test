package Dao;

import bean.Employee;

/**
 * @author chen
 * @create 2019/3/14 0014
 */
public interface EmployeeDao {

     Long insert(Employee bean);

     Long delete(Long id);

     Long update(Employee bean);

     Employee loadbyNo(String id);
}
