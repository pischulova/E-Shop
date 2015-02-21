package com.besttravelproject.command;

import com.besttravelproject.command.flightCommands.*;
import com.besttravelproject.command.orderCommands.*;
import com.besttravelproject.command.userCommands.*;

import javax.servlet.http.*;
import java.util.*;

/**
 * Created by А on 08.01.15.
 */
public class CommandFactory {
    private static Map<String, Command> commands = new HashMap<String, Command>();
    static{
        commands.put("authorization", new AuthCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("default", new DefaultCommand());
        commands.put("language", new LangCommand());
        commands.put("show_flights", new ShowFlightsCommand());
        commands.put("find_flight", new FindFlightCommand());
        commands.put("edit_flight", new EditFlightCommand());
        commands.put("show_clients", new ShowClientsCommand());
        commands.put("blacklist", new BlacklistCommand());
        commands.put("change_cart", new CartCommand());
        commands.put("make_order", new AddOrderCommand());
        commands.put("show_orders", new ShowOrdersCommand());
        commands.put("approve_order", new ApproveOrderCommand());
    }

    public static Command createCommand(HttpServletRequest request){
        String command = request.getParameter("command");
        if (command != null) {
            switch (command) {
                case "login":
                    return commands.get("authorization");
                case "logout":
                    return commands.get("logout");
                case "language":
                    return commands.get("language");
                case "show_flights":
                    return commands.get("show_flights");
                case "find_flight":
                    return commands.get("find_flight");
                case "edit_flight":
                    return commands.get("edit_flight");
                case "show_clients":
                    return commands.get("show_clients");
                case "blacklist":
                    return commands.get("blacklist");
                case "change_cart":
                    return commands.get("change_cart");
                case "make_order":
                    return commands.get("make_order");
                case "show_orders":
                    return commands.get("show_orders");
                case "approve_order":
                    return commands.get("approve_order");
                default:
                    return commands.get("default");
            }
        }
        return commands.get("bad");
    }
}
