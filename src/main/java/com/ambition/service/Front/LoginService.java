package com.ambition.service.Front;
/**
 * @Author: ambition
 * @Date: 2018/10/29 19:30
 * @Version 1.0
 */

import com.ambition.dao.CustomerDao;
import com.ambition.db.KeyChain;
import com.ambition.entity.Customer.Customer;
import com.ambition.util.decimal._DES;

import java.util.List;



public class LoginService {
    public List<Customer> CustomerLogin(String telephone, String password, String delFlag) {
        CustomerDao customerDao = new CustomerDao();
        //将Servlet中传递的分页需求进过算法转化成Mysql查询语句中的limit和page字段
        String passwords= null;
        try {
            passwords = _DES.encode_des(KeyChain.MYSQL_KEY, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Customer> customers = customerDao.CustomerLogin(telephone, passwords, delFlag);
        return customers;

    }
    public boolean CustomerRegQuery(String telephone) {
        CustomerDao customerDao = new CustomerDao();

        List<Customer> customers = customerDao.CustomerRegQuery(telephone);
        if (customers.size()!=0){
            return false;
        }else{
            return true;
        }

    }
    public List<Customer> customerInfoQuery(String userId,String delFlag ) {
        CustomerDao customerDao = new CustomerDao();
        List<Customer> customers = customerDao.customerInfoQuery(Integer.valueOf(userId),delFlag);
        return customers;

    }
    public void customerInfoEdit(String userId,String username,String email,String weibo,String telephone,String qq,String intro){
        CustomerDao customerDao = new CustomerDao();
        customerDao.editCustomerOthers(Integer.valueOf(userId),username,email,weibo,telephone,qq,intro);
    }
}