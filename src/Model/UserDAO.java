/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import MyConnect.MyConnect;
import Entity.Account;
import Entity.User;
import Entity.Worker;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Asus
 */
public class UserDAO {
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
    public boolean changePassword(String email,String newPassword) throws Exception
    {
        boolean result = false;
        try
        {
            cnn = MyConnect.myConnect();
            String sql = "select iduser from Users where email = ?";
            ps = cnn.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            int idUser = 0;
            if(rs.next())
                idUser = rs.getInt("iduser");
            if(idUser != 0)
            {
                rs.close();
                sql = "update Accounts set password = ? where idUser = ?";
                 cnn.setAutoCommit(false);
                ps = cnn.prepareStatement(sql);
                ps.setString(1, newPassword);
                ps.setInt(2, idUser);
                result  = ps.executeUpdate() > 0;
                cnn.commit();
            }
                
        }
        finally{
            closeConnection();
        }
        return result;
    }
    public boolean addUser(User dto) throws SQLException, ClassNotFoundException, ParseException
    {
        boolean check = false;
        try 
        {
            cnn = MyConnect.myConnect();
            cnn.setAutoCommit(false);
            String sql = "insert into Users (Name, Gender, BOD, Province, Address, Email)"
                    + " values (?,?,?,?,?,?)";
            ps = cnn.prepareStatement(sql);
            ps.setString(1, dto.getName());
            ps.setString(2, dto.getGender());
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date d= new Date(format.parse(dto.getBirth()).getTime());
            ps.setDate(3, d);
            ps.setString(4, dto.getProvince());
            ps.setString(5, dto.getAddress());
            ps.setString(6, dto.getEmail());
            check = ps.executeUpdate() > 0;
            if(check == true)
                check = true;
            cnn.commit();
        } 
        finally
        {
            closeConnection();
        }
        return check;
    }
    public int getIdAddedUser() throws SQLException, ClassNotFoundException
    {
        int idUser = 0;
        try 
        {
            cnn = MyConnect.myConnect();
            String sql = "SELECT MAX(iduser) as 'id' FROM users";
            ps = cnn.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next())
                idUser = rs.getInt("id");
        } 
        finally
        {
            closeConnection();
        }
        return idUser;
    }
    
    public boolean addAccount(String phone, String password, int idUser) throws SQLException, ClassNotFoundException
    {
        boolean check = false;
        try 
        {
            cnn = MyConnect.myConnect();
            String sql = "insert into Accounts values (?,?,?)";
            ps = cnn.prepareStatement(sql);
            ps.setString(1, phone);
            ps.setString(2, password);
            ps.setInt(3, idUser);
            check = ps.executeUpdate() > 0;
            if(check == true)
                check = true;
        } 
        finally
        {
            closeConnection();
        }
        return check;
    }
    
    public int checkLogin(String phone, String password) throws SQLException, ClassNotFoundException
    {
        int id = -1;
        try 
        {
            cnn = MyConnect.myConnect();
            String sql = "select iduser,password from Accounts where phone = ?";
            ps = cnn.prepareStatement(sql);
            ps.setString(1, phone);
            rs = ps.executeQuery();
            if(rs.next()){
                id = rs.getInt("iduser");
                String passwordData=rs.getString("password");
                if(BCrypt.checkpw(password,passwordData)){
                    return id;
                }
                else{
                    return -1;
                }
            }
                
                
        } 
        finally
        {
            closeConnection();
        }
        return id;
    }
    public User getInforOfUser(int id) throws SQLException, ClassNotFoundException
    {
         boolean check = false;
        User user = null;
        try 
        {
            cnn = MyConnect.myConnect();
            String sql = "select name, gender, BOD, Province, Address, Email  from "
                    + "Users where iduser = ?";
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next())
            {
                String name = rs.getString("Name");
                String gender = rs.getString("gender");
                Date bod = rs.getDate("BOD");
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                String BOD = format.format(bod);
                String province = rs.getString("Province");
                String add = rs.getString("Address");
                String email = rs.getString("Email");
                user = new User(id,name, gender, BOD, province, add, email);                
            }
        } 
        finally
        {
            closeConnection();
        }
        return user;
    }
    public Account  getAccOfUser(int id) throws SQLException, ClassNotFoundException
    {
        boolean check = false;
        User user = null;
        Account acc = null;
        try 
        {
            cnn = MyConnect.myConnect();
            String sql = "select phone, password  from "
                    + "Accounts where iduser = ?";
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next())
            {
                String phone = rs.getString("phone");
                String password = rs.getString("password");
                acc = new Account(phone, password);
            }
        } 
        finally
        {
            closeConnection();
        }
        return acc;
    }
    public boolean updateCadidate(User dto) throws SQLException, ClassNotFoundException, ParseException
    {
        boolean check = false;
        try 
        {
            cnn = MyConnect.myConnect();
            cnn.setAutoCommit(false);
            String sql = "update Users set Name = ?, Gender = ?, BOD = ?, Province = ?, "
                    + "Address = ?, Email = ? where idUser = ?";
            ps = cnn.prepareStatement(sql);
            ps.setString(1, dto.getName());
            ps.setString(2, dto.getGender());
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date d= new Date(format.parse(dto.getBirth()).getTime());
            ps.setDate(3, d);
            ps.setString(4, dto.getProvince());
            ps.setString(5, dto.getAddress());
            ps.setString(6, dto.getEmail());
            ps.setInt(7, dto.getIdUser());
            check = ps.executeUpdate() > 0;
            if(check == true)
                check = true;
            cnn.commit();
        } 
        finally
        {
            closeConnection();
        }
        return check;
    }
    public boolean updateAccountWithoutPass(String phone, int id) throws SQLException, ClassNotFoundException
    {
        boolean check = false;
        try 
        {
            cnn = MyConnect.myConnect();
            String sql = "update Accounts set phone = ?, where idUser = ?";
            ps = cnn.prepareStatement(sql);
            ps.setString(1, phone);
            ps.setInt(2, id);
            check = ps.executeUpdate() > 0;
            if(check == true)
                check = true;
        } 
        finally
        {
            closeConnection();
        }
        return check;
    }
    public boolean updateAccount(String phone, String password, int id) throws SQLException, ClassNotFoundException
    {
        boolean check = false;
        try 
        {
            cnn = MyConnect.myConnect();
            cnn.setAutoCommit(false);
            String sql = "update Accounts set phone = ?, password = ? where idUser = ?";
            ps = cnn.prepareStatement(sql);
            ps.setString(1, phone);
            ps.setString(2, password);
            ps.setInt(3, id);
            check = ps.executeUpdate() > 0;
            if(check == true)
                check = true;
            cnn.commit();
        } 
        finally
        {
            closeConnection();
        }
        return check;
    }
    
    public boolean checkPhone(String phone) throws SQLException, ClassNotFoundException
    {
        int id = -1;
        boolean check = false;
        try 
        {
            cnn = MyConnect.myConnect();
            String sql = "select iduser from Accounts where phone = ?";
            ps = cnn.prepareStatement(sql);
            ps.setString(1, phone);
            rs = ps.executeQuery();
            if(rs.next())
                id = rs.getInt("iduser");
            if(id > 0)
                check = true;
        } 
        finally
        {
            closeConnection();
        }
        return check;
    }
    public Vector<String> getJobData() throws SQLException, ClassNotFoundException
    {
        Vector<String> list = new Vector<>();
        try 
        {
            cnn = MyConnect.myConnect();
            String sql = "select name from Jobs";
            ps = cnn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
                String name = rs.getString("name");
                list.add(name);
            }
        } 
        finally
        {
            closeConnection();
        }
        return list;
    }
    public int getIdOfJob(String job) throws SQLException, ClassNotFoundException
    {
        int id = -1;
        try 
        {
            cnn = MyConnect.myConnect();
            String sql = "select idJob from Jobs where name like N'" + job +"'";
            ps = cnn.prepareStatement(sql);            
           // ps.setString(1, job);
            rs = ps.executeQuery();
            if(rs.next())
                id = rs.getInt("idJob");
        } 
        finally
        {
            closeConnection();
        }
        return id;
    }
    public boolean addWorker(Worker worker) throws SQLException, ClassNotFoundException
    {
        boolean check = false;
        try 
        {
            cnn = MyConnect.myConnect();
            cnn.setAutoCommit(false);
            String sql = "insert into Workers (idUser, idJob, Detail) values(?,?,?)";
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, worker.getIdUser());
            ps.setInt(2, worker.getIdJob());
            ps.setString(3, worker.getDetail());
            check = ps.executeUpdate() > 0;
            cnn.commit();
        } 
        finally
        {
            closeConnection();
        }
        return check;
    }
    public ArrayList<Worker> getWorker(int idUser) throws SQLException, ClassNotFoundException
    {
       ArrayList<Worker> workerList = new ArrayList<>();
        try 
        {
            cnn = MyConnect.myConnect();
            String sql = "select idJob, detail from Workers where idUser = ? ";
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, idUser);
            rs = ps.executeQuery();
            while(rs.next())
            {
                int idJob = rs.getInt("idJob");
                String detail = rs.getString("detail");
                Worker w = new Worker(idUser, idJob, detail);
                workerList.add(w);
            }
        } 
        finally
        {
            closeConnection();
        }
        return workerList;
    }
    public String getJobName(int idJob) throws SQLException, ClassNotFoundException
    {
        String name = "";
        try 
        {
            cnn = MyConnect.myConnect();
            String sql = "select name from Jobs where idJob = ?";
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, idJob);
            rs = ps.executeQuery();
            while(rs.next())
            {
                name = rs.getString("name");
            }
        } 
        finally
        {
            closeConnection();
        }
        return name;
    }
    public String getContentOfWorker(int idJob, int idUser) throws SQLException, ClassNotFoundException
    {
        String content = "";
        try 
        {
            cnn = MyConnect.myConnect();
            String sql = "select detail from Workers where idJob = ? and idUser = ?";
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, idJob);
            ps.setInt(2, idUser);
            rs = ps.executeQuery();
            while(rs.next())
            {
                content = rs.getString("detail");
            }
        } 
        finally
        {
            closeConnection();
        }
        return content;
    }

    public boolean checkExistWorker(int idUser, int idJob) throws SQLException, ClassNotFoundException
    {
        boolean check = false;
        int idcheck = -1;
        try 
        {
            cnn = MyConnect.myConnect();
            String sql = "select idJob from Workers where idJob = ? and idUser = ?";
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, idJob);
            ps.setInt(2, idUser);
            rs = ps.executeQuery();
            while(rs.next())
            {
                idcheck = rs.getInt("idJob");
            }
            if(idJob >= 0)
                check = true;
        } 
        finally
        {
            closeConnection();
        }
        return check;
    }
    public boolean removeWorker(int idUser, int idJob) throws SQLException, ClassNotFoundException
    {
        boolean check = false;
        try 
        {
            cnn = MyConnect.myConnect();
            cnn.setAutoCommit(false);
            String sql = "delete from Workers where idJob = ? and idUser = ?";
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, idJob);
            ps.setInt(2, idUser);
            check = ps.executeUpdate() > 0;
            cnn.commit();
        } 
        finally
        {
            closeConnection();
        }
        return check;
    }
    public boolean checkEmail(String email){
        String sql = "select Email from Users where Email = ?";
        try{
            cnn=MyConnect.myConnect();
            if(cnn!=null){
                ps=cnn.prepareStatement(sql);
                ps.setObject(1,email);
                rs=ps.executeQuery();
                while(rs.next()){
                    return true;
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
        return false;
    }
}
