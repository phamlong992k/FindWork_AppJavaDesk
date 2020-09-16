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
public class Rating {
    private int idJob;
    private int idUser;
    private int total;
    private int amount;
    
    public Rating(int idJob, int idUser, int total, int amount) {
        this.idJob = idJob;
        this.idUser = idUser;
        this.total = total;
        this.amount = amount;
    }
    public Rating(int idJob, int idUser) {
        this.idJob = idJob;
        this.idUser = idUser;
        this.total = 0;
        this.amount = 0;
    }
    public int getIdJob() {
        return idJob;
    }

    public void setIdJob(int idJob) {
        this.idJob = idJob;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
}
