/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Home.recruitment;

import Entity.Job;
import Entity.Rating;
import Entity.RequirementJob;
import Entity.User;
import Model.JobDAO;
import Model.RatingDAO;
import Model.RequireJobDAO;
import View.Login.LoginDetailFrame;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class Upload extends javax.swing.JPanel {

    /**
     * Creates new form Upload
     */
    User user;
    Vector<Job> jobList= new Vector<>();
    JobDAO jobDAO= new JobDAO();
    HomeRecruitment homeRecruitment;
    RequireJobDAO requireJobDAO= new RequireJobDAO();
    public Upload(User user,HomeRecruitment homeRecruitment) {
        
        initComponents();
        setImage();
        this.user=user;
        setJobList();
        this.homeRecruitment=homeRecruitment;
        
    }
    
    private void setImage()
    {
        try 
        {
            BufferedImage imageMain;            
            imageMain = ImageIO.read(getClass().getResource("/icon/UV.png"));
            ImageIcon iconMain = new ImageIcon(imageMain.getScaledInstance(1100 , 825, imageMain.SCALE_SMOOTH));
            uploadLabel.setIcon(iconMain);
        } catch (IOException ex) {
            Logger.getLogger(LoginDetailFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void setJobList(){
        jobList = jobDAO.getAllJob();
        Vector<String> jobNames= new Vector<>();
        for(Job job:jobList){
            jobNames.add(job.getName());
        }
        DefaultComboBoxModel model= new DefaultComboBoxModel(jobNames);
        cbxUpJob.setModel(model);
    }
    private int getIDItem(String name){
        for(Job job:jobList){
            if(job.getName().equals(name)){
                return job.getId();
            }
        }
        return -1;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtTitle = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        cbxUpJob = new javax.swing.JComboBox<>();
        btnUpload = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbxProvince = new javax.swing.JComboBox<>();
        txtAddress = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        uploadLabel = new javax.swing.JLabel();

        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 825));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTitle.setText("fresher");
        jPanel1.add(txtTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, 609, 31));

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        txtDescription.setText("2 nam");
        jScrollPane2.setViewportView(txtDescription);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 470, 609, 245));

        cbxUpJob.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbxUpJob, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, 238, 30));

        btnUpload.setText("Upload");
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpload, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 730, 170, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Tiêu đề");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Mô tả");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 440, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Nghề nghiệp");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Tỉnh/Thành Phố");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, -1, -1));

        cbxProvince.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "An Giang", "Bà Rịa–Vũng Tàu", "Bắc Giang", "Bắc Kạn", "Bạc Liêu", "Bắc Ninh", "Bến Tre", "Bình Ðịnh", "Bình Dương", "Bình Phướcc", "Bình Thuận", "Cà Mau", "Cần Thơ", "Cao Bằng", "Ðà Nẵng", "Ðắk Lắk", "Ðắk Nông", "Ðiện Biên", "Ðồng Nai", "Ðồng Tháp", "Gia Lai", "Hà Giang", "Hà Nam", "Hà Nội", "Hà Tĩnh ", "Hải Duong", "Hải Phòng", "Hậu Giang", "TP.Hồ Chí Minh", "Hòa Bình ", "Hưng Yên", "Khánh Hòa", "Kiên Giang", "Kon Tum", "Lai Châu", "Lâm Ðồng", "Lạng Son", "Lào Cai", "Long An", "Nam Ðịnh", "Nghệ An", "Ninh Bình", "Ninh Thuận", "Phú Thọ", "Phú Yên", "Quảng Bình", "Quảng Nam", "Quảng Ngãi", "Quảng Ninh", "Quảng Trị", "Sóc Trăng", "Sơn La ", "Tây Ninh", "Thái Bình", "Thái Nguyên", "Thanh Hóa", "Thừa Thiên–Huế ", "Tiền Giang", "Trà Vinh", "Tuyên Quang", "Vinh Long", "Vinh Phúc", "Yên Bái" }));
        jPanel1.add(cbxProvince, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 238, 30));
        jPanel1.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 260, 246, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Địa chỉ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 230, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 2, 60)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Đăng tin tuyển dụng");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 140));
        jPanel1.add(uploadLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 830));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1100, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 825, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
        int k=-1;
        String nameJob= (String) cbxUpJob.getSelectedItem();
        System.out.println(nameJob);
        int idJob=getIDItem(nameJob);
        int idUser=user.getIdUser();
        Rating rating = new Rating(idJob, idUser);
        RatingDAO ratingDAO= new RatingDAO();
        k=ratingDAO.insertRating(rating);
        
        if(k>0){
            String detail=txtDescription.getText();
            String title=txtTitle.getText();
            String address=(String) cbxProvince.getSelectedItem();
            String address2 = (String) txtAddress.getText();
            byte status=1;
            RequirementJob requirementJob= new RequirementJob(idUser, idJob, detail,0,status, title, address,address2);
            k=-1;
            k=requireJobDAO.insertRequirementJobs(requirementJob,rating);
            if(k>0){
                JOptionPane.showMessageDialog(null,"Upload thanh cong");
                this.homeRecruitment.jobManagementTabbed.setTable(user);
            }
            else{
                JOptionPane.showMessageDialog(null,"Upload that bai");
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Upload that bai");
        }
                
    }//GEN-LAST:event_btnUploadActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpload;
    private javax.swing.JComboBox<String> cbxProvince;
    private javax.swing.JComboBox<String> cbxUpJob;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtTitle;
    private javax.swing.JLabel uploadLabel;
    // End of variables declaration//GEN-END:variables
}