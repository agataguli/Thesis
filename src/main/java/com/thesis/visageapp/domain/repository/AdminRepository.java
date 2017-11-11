package com.thesis.visageapp.domain.repository;

import com.thesis.visageapp.domain.Admin;

import java.util.List;

public interface AdminRepository {
    List<Admin> getAllAdmins();

    Admin getAdminWithId(String adminId) throws IllegalAccessException;

    List<Admin> getAdminsWithAvailableStatus(boolean isAvailable);
}
