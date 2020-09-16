/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import MyConnect.MyConnect;
import Entity.Rating;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Asus
 */
public class RatingDAO {
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
    public int insertRating(Rating rating){
        String sql_Rating="Insert into Rating(IdUser,IdJob,Total,Amount) values(?,?,?,?)";
        int rs=-1;
        try{
            cnn=MyConnect.myConnect();
            if(cnn!=null){
                cnn.setAutoCommit(false);
                ps=cnn.prepareStatement(sql_Rating);
                ps.setObject(1,rating.getIdUser());
                ps.setObject(2,rating.getIdJob());
                ps.setObject(3,rating.getTotal());
                ps.setObject(4,rating.getAmount());
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
    public int deleteRating(int idJob,int idUser){
        String sql_Rating="Delete from Rating where IdJob = ? and IdUser = ?";
        int rs=-1;
        try{
            cnn=MyConnect.myConnect();
            if(cnn!=null){
                cnn.setAutoCommit(false);
                ps=cnn.prepareStatement(sql_Rating);
                ps.setObject(1,idJob);
                ps.setObject(2,idUser);
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
