/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import MyConnect.MyConnect;
import Entity.Rating;
import Entity.RequirementJob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Asus
 */
public class RequireJobDAO {
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
    public ArrayList<RequirementJob> getEntityByOptionForGoogleMap(String jobName,String province) throws Exception
    {
        ArrayList<RequirementJob> list = new ArrayList<>();
        try
        {
            cnn = MyConnect.myConnect();
            //String sql = "SELECT IdJob FROM Jobs WHERE Name = ?";
            String sql ="SELECT IdJob FROM Jobs WHERE Name LIKE "+"N'%"+jobName+"%'";
            ps = cnn.prepareStatement(sql);
            rs = ps.executeQuery();
            int idJob = 0;
            if(rs.next())
                idJob = rs.getInt("IdJob");
            if(idJob != 0)
            {
                if(!province.equals("None"))
                    sql = "SELECT IdUser FROM Requirement_Job WHERE IdJob = ? AND Province LIKE N'%"+province+"%'";
                else
                    sql = "SELECT IdUser FROM Requirement_Job WHERE IdJob = ?";
                ps = cnn.prepareStatement(sql);
                ps.setInt(1, idJob);
                ArrayList<Integer> users = new ArrayList<>();
                rs.close();
                rs = ps.executeQuery();
                while(rs.next())
                    users.add(rs.getInt("IdUser"));
                if(!users.isEmpty())
                {
                    sql = "SELECT IdUser,IdJob,Detail,Title,Rating,Status,Province,Address,Status FROM Requirement_Job WHERE IdUser = ? AND IdJob = ? AND Status = 1";
                    ps = cnn.prepareStatement(sql);
                    for (Integer user : users) {
                        rs.close();
                        ps.setInt(1, user);
                        ps.setInt(2, idJob);
                        rs = ps.executeQuery();
                        if(rs.next())
                        {
                            String detal = rs.getString("Detail");
                            float rating = rs.getFloat("Rating");
                            String provinceTmp = rs.getString("Province");
                            String addressTmp = rs.getString("Address");
                            String title = rs.getString("Title");
                            Byte tmp  = rs.getByte("Status");
                            RequirementJob entity = new RequirementJob(user, idJob, detal, rating, tmp, title, provinceTmp, addressTmp);
                            list.add(entity);
                        }
                    }
                }
            }
        }
        finally
        {
            closeConnection();
        }
        System.out.println(list.size());
        return list;
    }
    public Vector<RequirementJob> findRequireJobByIdUser(int idUser){
        String sql="select IdJob,Detail,Rating,Status,Title,Province from Requirement_Job where IdUser = ? ";
        Vector<RequirementJob> result= new Vector<>();
        try{
            cnn=MyConnect.myConnect();
            if(cnn!=null){
                ps=cnn.prepareStatement(sql);
                ps.setObject(1,idUser);
                rs=ps.executeQuery();
                while(rs.next()){
                    RequirementJob requirementJob= new RequirementJob(idUser,rs.getInt("IdJob"),rs.getString("Detail"),rs.getFloat("Rating"),rs.getByte("Status"),rs.getString("Title"),rs.getString("Province"));
                    
                    result.add(requirementJob);
                }
            }
        }catch(Exception e){
            
        }finally{
            try{
                closeConnection();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }
    public int insertRequirementJobs(RequirementJob requirementJob,Rating rating){
        System.out.println(requirementJob);
        String sql_Requiremnt="Insert into Requirement_Job(IdUser,IdJob,Detail,Rating,Status,Title,Province,Address) values(?,?,?,?,?,?,?,?)";
       
        int rs=-1;
        try{
            cnn=MyConnect.myConnect();
            if(cnn!=null){
                
                cnn.setAutoCommit(false);
                ps=cnn.prepareStatement(sql_Requiremnt);
                ps.setObject(1,requirementJob.getIdUser());
                ps.setObject(2,requirementJob.getIdJob());
                ps.setObject(3,requirementJob.getDetail());
                ps.setObject(4,requirementJob.getRating());
                ps.setObject(5,requirementJob.getStatus());
                ps.setObject(6,requirementJob.getTitle());
                ps.setObject(7,requirementJob.getProvince());
                ps.setObject(8,requirementJob.getAddress());
                rs=ps.executeUpdate();
                cnn.commit();
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
        return rs;
    }
    public int deleteRequirementJobs(int idJob){
     
        String sql_Requiremnt="Delete from Requirement_Job where IdJob = ?";
        int rs=-1;
        try{
            cnn=MyConnect.myConnect();
            if(cnn!=null){
                
                cnn.setAutoCommit(false);
                ps=cnn.prepareStatement(sql_Requiremnt);
                ps.setObject(1,idJob);
                rs=ps.executeUpdate();
                cnn.commit();
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
        return rs;
    }
}
