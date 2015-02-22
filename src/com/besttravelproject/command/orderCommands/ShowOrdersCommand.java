package com.besttravelproject.command.orderCommands;

import com.besttravelproject.command.Command;
import com.besttravelproject.dao.DaoFactory;
import com.besttravelproject.dao.DaoFlight;
import com.besttravelproject.dao.DaoOrder;
import com.besttravelproject.model.Order;
import com.besttravelproject.model.Product;
import com.besttravelproject.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by А on 20.02.15.
 */
public class ShowOrdersCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String isAdmin = (String)session.getAttribute("isAdmin");
        String orderId = request.getParameter("orderId");
        DaoOrder daoOrder = null;
        DaoFlight daoFlight = null;
        try {
            daoOrder = DaoFactory.getDaoOrder();
            daoFlight = DaoFactory.getDaoFlight();
            if (orderId != null) {
                int id = Integer.parseInt(orderId);
                Order order = daoOrder.findOrderInfo(id);
                List<Product> list = order.getProducts();
                List<Product> orderContents = new ArrayList<>();
                for (Product p : list) {
                    int productId = p.getId();
                    orderContents.add(daoFlight.findProductInfoLang(productId));
                }
                session.setAttribute("order", order);
                session.setAttribute("orderContents", orderContents);
                response.sendRedirect("/order_info");
            } else {
                List<Order> list;
                if (isAdmin.equals("true")) {
                    list = daoOrder.findAllOrders();
                } else {
                    User user = (User)session.getAttribute("user");
                    int clientId = user.getId();
                    list = daoOrder.findClientsOrders(clientId);
                }
                session.setAttribute("ordersList", list);
                response.sendRedirect("/orders");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DaoFactory.closeDaoFlight(daoFlight);
            DaoFactory.closeDaoOrder(daoOrder);
        }
    }
}
