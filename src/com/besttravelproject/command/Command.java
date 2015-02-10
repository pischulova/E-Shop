package com.besttravelproject.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by А on 08.01.15.
 */
public interface Command {
    void execute(HttpServletRequest request, HttpServletResponse response);
}
