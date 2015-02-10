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
        commands.put("default", new DefaultCommand());
        commands.put("language", new LangCommand());
    }

    public static Command createCommand(HttpServletRequest request){
        String command = request.getParameter("command");
        if (command != null) {
            switch (command) {
                case "login":
                    return commands.get("authorization");
                case "language":
                    return commands.get("language");
                default:
                    return commands.get("default");
            }
        }
        return commands.get("bad");
    }
}
