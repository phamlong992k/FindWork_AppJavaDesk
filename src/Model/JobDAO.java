/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import MyConnect.MyConnect;
import Entity.Job;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


public class JobDAO {
    private Connection cnn = null;
    private PreparedStatement ps = null;
    ResultSet rs = null;
    private void closeConnection() throws SQLException
    {
        if(rs != null){
            rs.close();
        }
        if(ps != null){
            ps.close();
        }
        if(cnn != null){
            cnn.close();
        }
    }
    public Vector<Job> getAllJob(){
        String sql="select IdJob,Name,Description from Jobs";
        Vector<Job> result= new Vector<>();
        try{
            cnn=MyConnect.myConnect();
            if(cnn!=null){
                ps=cnn.prepareStatement(sql);
                rs=ps.executeQuery();
                while(rs.next()){
                    Job job= new Job(rs.getInt("IdJob"),rs.getString("Name"),rs.getString("Description"));
                    result.add(job);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
               closeConnection();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }
    public Job getJobById(int idJob){
        String sql="select IdJob,Name,Description from Jobs where IdJob = ?";
        
        try{
            cnn=MyConnect.myConnect();
            if(cnn!=null){
                ps=cnn.prepareStatement(sql);
                ps.setObject(1,idJob);
                rs=ps.executeQuery();
                while(rs.next()){
                    Job job= new Job(rs.getInt("IdJob"),rs.getString("Name"),rs.getString("Description"));
                    return job;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
               closeConnection();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }
}
