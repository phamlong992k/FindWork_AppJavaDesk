/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Asus
 */
public class WorkerDTO {
    private String nameUser;
    private String detail;

    public WorkerDTO(String nameUser, String detail) {
        this.nameUser = nameUser;
        this.detail = detail;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "WorkerDTO{" + "nameUser=" + nameUser + ", detail=" + detail + '}';
    }
    
}
