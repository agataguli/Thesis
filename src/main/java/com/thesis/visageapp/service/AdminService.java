package com.thesis.visageapp.service;

import com.thesis.visageapp.domain.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> getAllAdmins();

    Admin getAdminWithId(String adminId) throws IllegalAccessException;

    List<Admin> getAdminsWithAvailableStatus(boolean isAvailable);
}
