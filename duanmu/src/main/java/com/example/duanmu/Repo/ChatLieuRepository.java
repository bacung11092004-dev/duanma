package com.example.duanmu.repository;

import com.example.duanmu.entity.ChatLieu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Collections;
import java.util.List;

public class ChatLieuRepository {

    // Đổi "default" thành tên <persistence-unit name="..."> trong file persistence.xml của bạn
    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("default");

    private EntityManager getEntityManager() {
        return EMF.createEntityManager();
    }

    // 1. Lấy toàn bộ danh sách chất liệu
    public List<ChatLieu> getAll() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT c FROM ChatLieu c ORDER BY c.id DESC", ChatLieu.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        } finally {
            em.close();
        }
    }

    // 2. Tìm chất liệu theo ID
    public ChatLieu findById(Long id) {
        if (id == null) return null;
        EntityManager em = getEntityManager();
        try {
            return em.find(ChatLieu.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    // 3. Thêm mới chất liệu
    public boolean add(ChatLieu chatLieu) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(chatLieu);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }

    // 4. Cập nhật chất liệu
    public boolean update(ChatLieu chatLieu) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(chatLieu);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }

    // 5. Xóa chất liệu theo ID
    public boolean delete(Long id) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            ChatLieu entity = em.find(ChatLieu.class, id);
            if (entity != null) {
                em.remove(entity);
                tx.commit();
                return true;
            }
            tx.rollback();
            return false;
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }
}