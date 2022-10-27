package com.cybersoft.crm.api;

import com.cybersoft.crm.payload.ResponseData;
import com.cybersoft.crm.service.UserService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.cybersoft.crm.model.UsersModel;
import com.google.gson.GsonBuilder;

import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "userApi", urlPatterns = {"/api/user"})
public class UserApi extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        int id = Integer.parseInt(req.getParameter("idUpdate"));
        List<UsersModel> list = userService.getUserById(id);

        boolean isSuccess = list.size() > 0;
        ResponseData responseData = new ResponseData();
        responseData.setStatus(200);
        responseData.setSuccess(isSuccess);
        responseData.setDescription(list);

        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        //toJson : biến đối tượng thành chuỗi JSON
        String json = gson.toJson(responseData);

        out.print(json);

        out.flush();
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(req.getParameter("id"));
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String avatar = req.getParameter("avatar");
        String fullName = req.getParameter("fullname");
        int RoleId = Integer.parseInt(req.getParameter("roleid"));
        boolean isSuccess = userService.updateUser(email, password, avatar, fullName, RoleId, id);

        ResponseData responseData = new ResponseData();
        responseData.setStatus(200);
        responseData.setSuccess(isSuccess);
        responseData.setDescription(isSuccess ? "Cập nhập thành công" : "Cập nhập thất bại");

        Gson gson = new Gson();
        //toJson : biến đối tượng thành chuỗi JSON
        String json = gson.toJson(responseData);

        out.print(json);
        out.flush();
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(req.getParameter("idDelete"));
        boolean isSuccess = userService.deleteUserById(id);

        ResponseData responseData = new ResponseData();
        responseData.setStatus(200);
        responseData.setSuccess(isSuccess);
        responseData.setDescription(isSuccess ? "Xoá thành công" : "Xoá thất bại");

        Gson gson = new Gson();
        //toJson : biến đối tượng thành chuỗi JSON
        String json = gson.toJson(responseData);

        out.print(json);
        out.flush();
    }
}
