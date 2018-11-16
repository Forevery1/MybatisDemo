package com.ambition.controller.Market;

import com.ambition.entity.Customer.Customer;
import com.ambition.entity.Shop.Shop;
import com.ambition.service.Front.LoginService;
import com.ambition.service.Shop.ListService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: ambition
 * @Date: 2018/11/16 17:11
 * @Version 1.0
 */
@WebServlet("/MarketServlet")
public class IndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");       //调用Service层方法进行用户查询
        ListService listService=new ListService();
        List<Shop> shopList=listService.queryShopList("22222222201","0");
//        List<Customer> customers=loginService.customerInfoQuery(String.valueOf(session.getAttribute("userId")),"0");
//        String headimages=customers.get(0).getHeaderimages();

        request.setAttribute("shopList",shopList);
        request.getRequestDispatcher("/Shop/in/index.jsp").forward(request,response);
    }
}