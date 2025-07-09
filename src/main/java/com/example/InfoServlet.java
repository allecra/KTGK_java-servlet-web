package com.example;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/info")
public class InfoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Thông tin nhóm:</h2>");
        out.println("<ul>");
        out.println("<li>Nguyễn Thị Tâm - MSSV: BIT230372</li>");
        out.println("<li>Đỗ Thị Phúc - MSSV: BIT230373</li>");
        out.println("<li>Nguyễn Thị Xinh - MSSV: BIT230374</li>");
        out.println("</ul>");
    }
}
