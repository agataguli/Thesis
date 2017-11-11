package com.thesis.visageapp.domain.repository.impl;

import com.thesis.visageapp.domain.Admin;
import com.thesis.visageapp.domain.repository.AdminRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by Agatka
 */
@Repository
public class InMemoryAdminRepository implements AdminRepository {

    private List<Admin> listOfAdmins = new ArrayList<>();

    // TODO: replace this fake repository with some JDBC solution, best Hibernate.
    public InMemoryAdminRepository() {
        // TODO: mocked admins
        Admin agataAdmin = new Admin("1", "agataAdmin", "agata123", "GLOBAL_ADMIN", "Agata", "Kołtun", "agataguli@gmail.com", "737409946", true);
        Admin ewelinaAdmin = new Admin("2", "ewelinaAdmin", "ewelina123", "GLOBAL_ADMIN", "Ewelina", "Mysiak", "exampleEwelina@gmail.com", "737409947", true);
        listOfAdmins.add(agataAdmin);
        listOfAdmins.add(ewelinaAdmin);
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
            // TODO: move all messsages and strings to property file!
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
