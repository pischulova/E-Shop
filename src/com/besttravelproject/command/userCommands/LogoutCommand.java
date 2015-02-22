package com.besttravelproject.command.userCommands;

        import com.besttravelproject.command.Command;

        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;

/**
 * Created by А on 13.02.15.
 */
public class LogoutCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getSession().invalidate();
            response.sendRedirect("/home");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
