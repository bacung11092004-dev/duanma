package com.example.duanmu.serverlet;

import com.example.duanmu.Repo.LoaiSanPhamRepo;
import com.example.duanmu.entity.LoaiSanPham;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoaiSanPhamServlet", value = "/LoaiSanPhamServlet")
public class LoaiSanPhamServlet extends HttpServlet {
    private final LoaiSanPhamRepo repo = new LoaiSanPhamRepo();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        List<LoaiSanPham> dsLoai = repo.findAll();
        request.setAttribute("dsLoai", dsLoai);
        request.getRequestDispatcher("/loai-san-pham.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");

        LoaiSanPham item = new LoaiSanPham();
        item.setMa(ma);
        item.setTen(ten);
        repo.create(item);

        response.sendRedirect(request.getContextPath() + "/LoaiSanPhamServlet");
    }
}
