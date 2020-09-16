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
public class User {
    private int idUser;    
    private String  name, gender, birth, province, address, email;

    public User(String name, String gender, String birth, String province, String address, String email) {
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        this.province = province;
        this.address = address;
        this.email = email;
    }

    public User(int idUser, String name, String gender, String birth, String province, String address, String email) {
        this.idUser = idUser;
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        this.province = province;
        this.address = address;
        this.email = email;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getProvince() {
        return province;
    }

    @Override
    public String toString() {
        return "User{" + "idUser=" + idUser + ", name=" + name + ", gender=" + gender + ", birth=" + birth + ", province=" + province + ", address=" + address + ", email=" + email + '}';
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
