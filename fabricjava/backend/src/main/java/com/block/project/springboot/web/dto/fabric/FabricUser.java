package com.block.project.springboot.web.dto.fabric;

public class FabricUser {
    String UserID;
    String role;

    public FabricUser(String UserID, String role){
        this.UserID = UserID;
        this.role = role;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "FabricUser{" +
                "UserID='" + UserID + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
