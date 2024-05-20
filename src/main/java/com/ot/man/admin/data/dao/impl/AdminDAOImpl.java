package com.ot.man.admin.data.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ot.man.admin.data.dao.AdminDAO;
import com.ot.man.admin.data.entity.Admin;

@Repository
public class AdminDAOImpl implements AdminDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Admin findById(String id) {
        return entityManager.find(Admin.class, id);
    }
}
