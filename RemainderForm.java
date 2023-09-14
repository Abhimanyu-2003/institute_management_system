package raysproject;

import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class RemainderForm extends javax.swing.JFrame {
    Connection con;
    PreparedStatement stmt,stmt1;
    ResultSet rs,rst;
    DefaultTableModel model;
    byte rol,kk=0;
    public RemainderForm(byte role) throws SQLException {
        initComponents();
        con=ConnDb.conLink();
        rol=role;
        setTitle("Remainder Form");
        this.setLocationRelativeTo(null);
        this.getRootPane().setDefaultButton(sub_bt);
        fr_dt.setDate(new java.sql.Date(System.currentTimeMillis()));
        to_dt.setDate(new java.sql.Date(System.currentTimeMillis()));
        Image icon=Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/icon/repl_logo_(1)-small.png"));
        this.setIconImage(icon);
        tab.setVisible(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        sub_bt = new javax.swing.JButton();
        fr_dt = new com.toedter.calendar.JDateChooser();
        tab = new javax.swing.JPanel();
        tb_pan = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        to_dt = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ref_bt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        kGradientPanel1.setkEndColor(new java.awt.Color(51, 102, 255));
        kGradientPanel1.setkGradientFocus(800);
        kGradientPanel1.setkStartColor(new java.awt.Color(102, 153, 255));

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INSTALLMENT REMAINDER FORM");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 330, -1));

        jButton3.setBackground(new java.awt.Color(102, 102, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/home.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 0, 70, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Installment Date");

        sub_bt.setBackground(new java.awt.Color(0, 116, 226));
        sub_bt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        sub_bt.setForeground(new java.awt.Color(255, 255, 255));
        sub_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search-icon-png-9964.png"))); // NOI18N
        sub_bt.setText("SEARCH");
        sub_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sub_btActionPerformed(evt);
            }
        });

        fr_dt.setDateFormatString("yyyy-MM-dd");

        table.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Aform_no", "Sname", "Course Name", "Total Fee", "Total_Amt_Paid", "Dues_Amt", "Ins_Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setEnabled(false);
        table.getTableHeader().setReorderingAllowed(false);
        tb_pan.setViewportView(table);

        javax.swing.GroupLayout tabLayout = new javax.swing.GroupLayout(tab);
        tab.setLayout(tabLayout);
        tabLayout.setHorizontalGroup(
            tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tb_pan)
                .addContainerGap())
        );
        tabLayout.setVerticalGroup(
            tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabLayout.createSequentialGroup()
                .addComponent(tb_pan, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        to_dt.setDateFormatString("yyyy-MM-dd");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setText("FROM");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setText("TO");

        ref_bt.setBackground(new java.awt.Color(255, 0, 51));
        ref_bt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ref_bt.setForeground(new java.awt.Color(255, 255, 255));
        ref_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        ref_bt.setText("REFRESH");
        ref_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ref_btActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel5)
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(436, 436, 436))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(fr_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(to_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33)
                .addComponent(sub_bt)
                .addGap(18, 18, 18)
                .addComponent(ref_bt)
                .addGap(14, 14, 14))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fr_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sub_bt)
                        .addComponent(ref_bt))
                    .addComponent(jLabel5)
                    .addComponent(to_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void ref_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ref_btActionPerformed
        if(kk==0);
        else{
            model.setRowCount(0);
        }
        fr_dt.setDate(new java.sql.Date(System.currentTimeMillis()));
        to_dt.setDate(new java.sql.Date(System.currentTimeMillis()));
    }//GEN-LAST:event_ref_btActionPerformed
     
    private void sub_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sub_btActionPerformed
        SimpleDateFormat f=new SimpleDateFormat("dd-MMM-yy");
        Date dt=null,dt1=null;
        try {
            dt = f.parse(f.format(fr_dt.getDate()));
            dt1=f.parse(f.format(to_dt.getDate()));
        } catch (ParseException ex) {
            Logger.getLogger(RemainderForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(dt.compareTo(dt1)>0){
            JOptionPane.showMessageDialog(this,"From Date Must be Before To Date!");
        }
        else{
            try {
                stmt=con.prepareStatement("select distinct reg_no from money_receipt where ins_date>=? and ins_date<=?");
                String s=((JTextField)fr_dt.getDateEditor().getUiComponent()).getText();
                DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
                java.sql.Date sql=null,sq=null;
                java.util.Date date=df.parse(s);
                sql=new java.sql.Date(date.getTime());
                stmt.setDate(1,sql);
                String sd=((JTextField)to_dt.getDateEditor().getUiComponent()).getText();
                java.util.Date dtt=df.parse(sd);
                sq=new java.sql.Date(dtt.getTime());
                stmt.setDate(2,sq);
                ResultSet sr=stmt.executeQuery();
                model=(DefaultTableModel) table.getModel();
                model.setRowCount(0);
                boolean flag=true;
                while(sr.next()){
                    flag=false;
                    stmt=con.prepareStatement("select max(aform_no) from money_receipt where reg_no=?");
                    stmt.setString(1,sr.getString(1));
                    rs=stmt.executeQuery();
                    rs.next();
                    stmt=con.prepareStatement("select sum(cash+upi+cheque+dd), min(dues_amt), max(ins_date) from money_receipt where aform_no=?");
                    stmt.setString(1,rs.getString(1));
                    ResultSet rs1=stmt.executeQuery();
                    rs1.next();
                    stmt=con.prepareCall("select sname from registration where reg_no=?");
                    stmt.setString(1,sr.getString(1));
                    ResultSet rs2=stmt.executeQuery();
                    rs2.next();
                    stmt=con.prepareCall("select cou_apply,fee from admission where adm_no=?");
                    stmt.setString(1,rs.getString(1));
                    ResultSet rs3=stmt.executeQuery();
                    rs3.next();
                    kk=(byte) (kk+1);
                    tab.setVisible(true);
                    model.addRow(new Object[]{rs.getString(1),rs2.getString(1),rs3.getString(1),rs3.getString(2),rs1.getString(1),rs1.getString(2),rs1.getDate(3)});
                }
                if(flag)
                    JOptionPane.showMessageDialog(this,"Records not found!");
            } catch (SQLException ex) {
                Logger.getLogger(RemainderForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(RemainderForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_sub_btActionPerformed
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(RemainderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(RemainderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(RemainderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(RemainderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new RemainderForm().setVisible(true);
//                } catch (SQLException ex) {
//                    Logger.getLogger(RemainderForm.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser fr_dt;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JButton ref_bt;
    private javax.swing.JButton sub_bt;
    private javax.swing.JPanel tab;
    private javax.swing.JTable table;
    private javax.swing.JScrollPane tb_pan;
    private com.toedter.calendar.JDateChooser to_dt;
    // End of variables declaration//GEN-END:variables
}
