package com.thesis.visageapp.domain.repository.impl;

import com.thesis.visageapp.domain.Admin;
import com.thesis.visageapp.domain.repository.AdminRepository;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class InMemoryAdminRepository implements AdminRepository {
    private List<Admin> listOfAdmins = new ArrayList<>();

    public InMemoryAdminRepository() {
        this.takeAllAdminsFromDatabase();
    }

    private void takeAllAdminsFromDatabase() {
        MysqlConnector.connect();
        ResultSet rs = MysqlConnector.prepareStatement(StaticQueryParts.SELECT_ALL_QUERY + StaticQueryParts.ADMINS_TAB_NAME);
        Admin admin;

        try {
            while (rs.next()) {
                // TODO: in StaticQueryParts you have column lists. Use stream!
                admin = new Admin(
                        rs.getString(StaticQueryParts.ADMINS_ADMIN_ID), rs.getString(StaticQueryParts.ADMINS_LOGIN),
                        rs.getString(StaticQueryParts.ADMINS_PASSWORD), rs.getString(StaticQueryParts.ADMINS_PERMISSION_STATUS),
                        rs.getString(StaticQueryParts.ADMINS_NAME), rs.getString(StaticQueryParts.ADMINS_SURNAME),
                        rs.getString(StaticQueryParts.ADMINS_EMAIL), rs.getString(StaticQueryParts.ADMINS_PHONE_NUMBER),
                        rs.getBoolean(StaticQueryParts.ADMINS_ACTIVE)
                );
                this.listOfAdmins.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        MysqlConnector.disconnect();
    }

    @Override
    public List<Admin> getAllAdmins() {
        return listOfAdmins;
    }

    @Override
    public Admin getAdminWithId(String adminId) throws IllegalAccessException {
        Admin adminById = null;
        for (Admin admin : listOfAdmins) {
            if (admin != null && admin.getAdminId() != null && admin.getAdminId().equals(adminId)) {
                adminById = admin;
                break;
            }
        }
        if (adminById == null) {
            throw new IllegalAccessException("No user with id:" + adminId);
        }
        return adminById;
    }

    @Override
    public List<Admin> getAdminsWithAvailableStatus(boolean isAvailable) {
        List<Admin> adminList = new ArrayList<>();
        for (Admin admin : listOfAdmins) {
            if (admin.isActive() == isAvailable) adminList.add(admin);
        }
        return adminList;
    }
}
