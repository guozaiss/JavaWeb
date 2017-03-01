package com.example.controller;

import com.example.service.PersonService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Admin on 2017/3/1.
 */
@Controller
@RequestMapping(value = "/meizhi")
public class MeizhiServlet extends HttpServlet {
    @Autowired
    private PersonService personService;

    @RequestMapping(method = RequestMethod.GET)
    public void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.append(new Gson().toJson(personService.getUserById("id_01")));
    }

    @RequestMapping(value = "/hehe", method = RequestMethod.GET)
    public void hehe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.append("abcd");
    }
}
