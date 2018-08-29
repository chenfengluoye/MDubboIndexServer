package com.ckj.projects;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * created by ChenKaiJu on 2018/8/4  14:45
 */
public class IndexServer extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("有客户端获取注册中心列表。。。");
        PrintWriter writer= resp.getWriter();
        writer.write(Utils.getCenterList(this).toString());
        writer.flush();
    }
}
