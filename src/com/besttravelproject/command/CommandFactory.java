package com.besttravelproject.command;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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
                default:
                    return commands.get("default");
            }
        }
        return commands.get("bad");
    }
}
