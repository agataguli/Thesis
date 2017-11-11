package com.thesis.visageapp.domain;

/**
 * Created by Agatka
 */
public class Admin {
    private String adminId;
    private String login;
    private String password;
    private String permissionStatus;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private boolean active;

    public Admin(String adminId, String login, String password, String permissionStatus, String name, String surname, String email, String phoneNumber, boolean active) {
        this.adminId = adminId;
        this.login = login;
        this.password = password;
        this.permissionStatus = permissionStatus;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.active = active;
    }

    @Override
    public String toString() {
        return "Admin [login=" + this.login + ", name: " + this.name + " " + this.surname + "]";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        Admin other = (Admin) object;
        if (adminId == null) {
            if (other.adminId != null) {
                return false;
            }
        } else if (!adminId.equals(other.adminId)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((adminId == null) ? 0 : adminId.hashCode());
        return result;
    }


    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPermissionStatus() {
        return permissionStatus;
    }

    public void setPermissionStatus(String permissionStatus) {
        this.permissionStatus = permissionStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}