/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import MyConnect.MyConnect;
import DTO.WorkerDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Asus
 */
public class WorkerDAO {
     private Connection cnn = null;
    private PreparedStatement ps = null;
    ResultSet rs = null;
     private void closeConnection() throws SQLException
    {
        if(rs != null)
            rs.close();
        if(ps != null)
            ps.close();
        if(cnn != null)
            cnn.close();
    }
    public Vector<WorkerDTO> getAllWorker() throws SQLException, ClassNotFoundException
    {
        Vector<WorkerDTO> result= new Vector<>();
        String sql = "select u.Name,w.detail from Workers w,Users u where w.IdUser=u.IdUser";
        try 
        {
            cnn = MyConnect.myConnect();
            ps = cnn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
                WorkerDTO w= new WorkerDTO(rs.getString("Name"),rs.getString("detail"));
                result.add(w);
            }
        } 
        finally
        {
            closeConnection();
        }
        return result;
    }
    public Vector<WorkerDTO> getAllWorkerByJobID(int id) throws SQLException, ClassNotFoundException
    {
        Vector<WorkerDTO> result= new Vector<>();
        String sql = "select u.Name,w.detail from Workers w,Users u where w.IdUser=u.IdUser and w.IdJob = ? ";
        try 
        {
            cnn = MyConnect.myConnect();
            ps = cnn.prepareStatement(sql);
            ps.setObject(1,id);
            rs = ps.executeQuery();
            while(rs.next())
            {
                WorkerDTO w= new WorkerDTO(rs.getString("Name"),rs.getString("detail"));
                result.add(w);
            }
            
                    
        } 
        finally
        {
            closeConnection();
        }
        return result;
    }
    public boolean findWorker(int idUser, int idJob) throws SQLException, ClassNotFoundException
    {
        int idTest = -1;
        boolean check = false;
        String sql = "select idUser from Workers where idUser = ? and idJob = ?";
        try 
        {
            cnn = MyConnect.myConnect();
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, idUser);
            ps.setInt(2, idJob);
            rs = ps.executeQuery();
            while(rs.next())
            {
                idTest = rs.getInt("idUser");
            }
            if(idTest >= 0)
                check = true;
        } 
        finally
        {
            closeConnection();
        }
        return check;
    }
    public boolean updateDetailWorker(int idUser, int idJob, String detail) throws SQLException, ClassNotFoundException
    {
        boolean check = false;
        String sql = "update Workers set detail = ? where idUser = ? and idJob = ?";
        try 
        {
            cnn = MyConnect.myConnect();
            cnn.setAutoCommit(false);
            ps = cnn.prepareStatement(sql);
            ps.setString(1, detail);
            ps.setInt(2, idUser);
            ps.setInt(3, idJob);
            check = ps.executeUpdate() > 0;
            cnn.commit();
        } 
        finally
        {
            closeConnection();
        }
        return check;
    }
}
