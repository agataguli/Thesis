package com.thesis.visageapp.controller;

import com.thesis.visageapp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String listAdmins(Model model) {
        model.addAttribute("admins", adminService.getAllAdmins());
        return "admins";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String getAdminWithId(@RequestParam("id") String adminId, Model model) throws IllegalAccessException {
        model.addAttribute("admin", adminService.getAdminWithId(adminId));
        return "admin";
    }
}
