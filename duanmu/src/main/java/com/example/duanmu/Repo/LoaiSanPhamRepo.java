package com.example.duanmu.Repo;


import com.example.duanmu.entity.LoaiSanPham;
import com.example.duanmu.utils.EntityManagerUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class LoaiSanPhamRepo {

    public List<LoaiSanPham> findAll() {
        EntityManager em = EntityManagerUtils.getEntityManager();
        try {
            return em.createQuery("SELECT l FROM LoaiSanPham l", LoaiSanPham.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public LoaiSanPham findById(Integer id) {
        EntityManager em = EntityManagerUtils.getEntityManager();
        try {
            return em.find(LoaiSanPham.class, id);
        } finally {
            em.close();
        }
    }

    public boolean create(LoaiSanPham entity) {
        EntityManager em = EntityManagerUtils.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(entity);
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

    public boolean update(LoaiSanPham entity) {
        EntityManager em = EntityManagerUtils.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(entity);
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

    public boolean deleteById(Integer id) {
        EntityManager em = EntityManagerUtils.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            LoaiSanPham entity = em.find(LoaiSanPham.class, id);
            if (entity != null) {
                em.remove(entity);
            }
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
}
