package com.besttravelproject.command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

/**
 * Created by А on 08.01.15.
 */
public class LangCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String lang = request.getParameter("language");
        Locale locale = null;
        if (lang != null) {
            if (lang.equals("ru")) {
                locale = new Locale("ru", "RU");
            } else if (lang.equals("en")) {
                locale = new Locale("en", "EN");
            }
        }
        HttpSession session = request.getSession(true);
        session.setAttribute("userLocale", locale);
        Locale.setDefault(locale);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/home");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
