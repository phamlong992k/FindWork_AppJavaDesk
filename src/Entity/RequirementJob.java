/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Asus
 */
public class RequirementJob {
    private int idUser;
    private int idJob;
    private String detail;
    private float rating;
    private byte status;
    private String title;
    private String province;
    private String address;

    public RequirementJob(int idUser, int idJob, String detail, float rating, byte status, String title, String province, String address) {
        this.idUser = idUser;
        this.idJob = idJob;
        this.detail = detail;
        this.rating = rating;
        this.status = status;
        this.title = title;
        this.province = province;
        this.address = address;
    }
    public RequirementJob(int idUser, int idJob, String detail, float rating, byte status, String title, String province) {
        this.idUser = idUser;
        this.idJob = idJob;
        this.detail = detail;
        this.rating = rating;
        this.status = status;
        this.title = title;
        this.province = province;
        this.address = "";
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdJob() {
        return idJob;
    }

    public void setIdJob(int idJob) {
        this.idJob = idJob;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
    
    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    

    public void setAddress(String address) {
        this.province = address;
    }

    @Override
    public String toString() {
        return "RequirementJob{" + "idUser=" + idUser + ", idJob=" + idJob + ", detail=" + detail + ", rating=" + rating + ", status=" + status + ", title=" + title + ", province=" + province + ", address=" + address + '}';
    }

  
   
    
    
}
