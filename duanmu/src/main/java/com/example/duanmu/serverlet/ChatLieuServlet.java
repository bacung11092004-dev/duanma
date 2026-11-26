package com.example.duanmu.serverlet;

import com.example.duanmu.Repo.ChatLieuRepository;
import com.example.duanmu.entity.ChatLieu;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ChatLieuServlet", value = "/ChatLieuServlet")
public class ChatLieuServlet extends HttpServlet {

    private final ChatLieuRepository repo = new ChatLieuRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String idParam = request.getParameter("id");
        long id = 1L;
        if (idParam != null && !idParam.trim().isEmpty()) {
            try {
                id = Long.parseLong(idParam.trim());
            } catch (NumberFormatException ignored) {
                id = 1L;
            }
        }

        List<ChatLieu> dsChatLieu = new ArrayList<>();
        ChatLieu item = repo.findById(id);
        if (item != null) {
            dsChatLieu.add(item);
        }

        request.setAttribute("dsChatLieu", dsChatLieu);
        request.getRequestDispatcher("/chat-lieu.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");

        ChatLieu item = new ChatLieu();
        item.setMa(ma);
        item.setTen(ten);
        repo.add(item);

        response.sendRedirect(request.getContextPath() + "/ChatLieuServlet");
    }
}