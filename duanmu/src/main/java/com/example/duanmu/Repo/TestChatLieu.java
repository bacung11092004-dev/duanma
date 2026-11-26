package com.example.duanmu;

import com.example.duanmu.entity.ChatLieu;
import com.example.duanmu.repository.ChatLieuRepository;

import java.util.List;

public class TestChatLieu {
    public static void main(String[] args) {
        ChatLieuRepository repo = new ChatLieuRepository();

        // 1. Test thêm mới
        ChatLieu clMoi = new ChatLieu();
        clMoi.setMa("CL_TEST_01");
        clMoi.setTen("Vải Kaki Test");

        boolean added = repo.add(clMoi);
        System.out.println("Thêm mới thành công: " + added);

        // 2. Test lấy toàn bộ danh sách
        List<ChatLieu> list = repo.getAll();
        System.out.println("Tổng số chất liệu hiện có: " + list.size());
        for (ChatLieu item : list) {
            System.out.println("ID: " + item.getId() + " | Mã: " + item.getMa() + " | Tên: " + item.getTen());
        }

        // 3. Test sửa & xóa bản ghi vừa thêm (nếu có ID)
        if (clMoi.getId() != null) {
            clMoi.setTen("Vải Kaki Đã Sửa");
            boolean updated = repo.update(clMoi);
            System.out.println("Cập nhật thành công: " + updated);

            boolean deleted = repo.delete(clMoi.getId());
            System.out.println("Xóa bản ghi test thành công: " + deleted);
        }
    }
}