package com.cybersoft.crm.controller;

import com.cybersoft.crm.service.UserService;
import com.cybersoft.crm.model.UsersModel;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "userPage", urlPatterns = {"/user"})
public class UserPage extends HttpServlet {

    private UserService userService = new UserService();
    private List<UsersModel> list = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String account_id = req.getParameter("account_id");
        String action = req.getParameter("action");
        String addSuccess = "Thêm mới thành công";
        String addFail = "Thêm mới thất bại";
        String link = req.getParameter("success");

//        if (account_id != null && !account_id.isEmpty()) {
//            if (action.equals("edit")) { // Cập nhật
//
//                PrintWriter out = resp.getWriter();
//                resp.setContentType("application/json");
//                Gson gson = new Gson();
//
//                list = userService.getUserById(Integer.parseInt(account_id));
//
//                String objectToReturn = gson.toJson(list);
//                out.write(objectToReturn); // Đưa json trả về ajax
//                out.flush();
//                return;
//
//            } else { //Xoá
//                return;
//            }
//        }

        if (link != null) {
            if (link.equals("success")) {
                req.setAttribute("success", addSuccess);
            } else if (link.equals("fail")) {
                req.setAttribute("error", addFail);
            }
        }
        req.setAttribute("users", userService.getAllUsers());
        req.getRequestDispatcher("/user-table.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String avatar = req.getParameter("avatar");
        String fullName = req.getParameter("fullname");
        int roleId = Integer.parseInt(req.getParameter("roleId"));

        String account_id = req.getParameter("account_id");
        if (account_id != null && !account_id.isEmpty()) {
//            if (userService.updateUser(email, password, avatar, fullName, roleId, Integer.parseInt(String.valueOf(account_id))) > 0) {
//                req.setAttribute("success", "Cập nhập thành công");
//            } else {
//                req.setAttribute("error", "Cập nhập thất bại");
//            }
        } else {
            if (userService.addUser(email, password, avatar, fullName, roleId) > 0) {
//                req.setAttribute("success", "them moi thanh cong");
                resp.sendRedirect(req.getContextPath() + "/user?success=success");
            } else {
//                req.setAttribute("error", "them moi that bai");
//                req.setAttribute("users", userService.getAllUsers());
//                req.getRequestDispatcher("/user-table.jsp").forward(req,resp);
                resp.sendRedirect(req.getContextPath() + "/user?success=fail");
            }
        }
    }
}
