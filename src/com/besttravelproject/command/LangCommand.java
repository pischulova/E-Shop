package com.besttravelproject.command;

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
        try {
            response.sendRedirect(getLastPage(request));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getLastPage(HttpServletRequest request) {
        String [] url = request.getHeader("referer").split("/");
        if (url.length < 4)
            return "/home";
        return ("/"+ url[url.length-1]);
    }
}
