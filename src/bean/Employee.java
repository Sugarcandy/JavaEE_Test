package bean;

import java.sql.Connection;

/**
 * @author chen
 * @create 2019/3/14 0014
 */
public class Employee {
    String name;
    Long empNo;
    String passWord;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Long empNo) {
        this.empNo = empNo;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
