package com.thesis.visageapp.service.impl;

import com.thesis.visageapp.domain.Admin;
import com.thesis.visageapp.domain.repository.AdminRepository;
import com.thesis.visageapp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.getAllAdmins();
    }

    @Override
    public Admin getAdminWithId(String adminId) throws IllegalAccessException {
        return adminRepository.getAdminWithId(adminId);
    }

    @Override
    public List<Admin> getAdminsWithAvailableStatus(boolean isAvailable) {
        return adminRepository.getAdminsWithAvailableStatus(isAvailable);
    }
}
