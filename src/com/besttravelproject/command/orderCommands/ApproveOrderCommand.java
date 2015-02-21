package com.besttravelproject.command.orderCommands;

import com.besttravelproject.command.Command;
import com.besttravelproject.dao.DaoFactory;
import com.besttravelproject.dao.DaoOrder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by А on 21.02.15.
 */
public class ApproveOrderCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        try {
            DaoOrder daoOrder = DaoFactory.getDaoOrder();
            daoOrder.approveOrder(orderId);
            DaoFactory.closeDaoOrder(daoOrder);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/auth?command=show_orders");
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
