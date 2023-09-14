
package raysproject;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AdmissionInvoice extends javax.swing.JFrame {
     Connection con;
    public AdmissionInvoice(String d[]) throws SQLException {
        initComponents();
        Image icon=Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/icon/repl_logo_(1)-small.png"));
        this.setIconImage(icon);
        setTitle("AdmissionInvoice");
        this.setLocationRelativeTo(null);
        this.getRootPane().setDefaultButton(print);
       for_no.setText(d[0]);
       adm_dt.setText(d[1]);
       reg_no.setText(d[2]);
       pre_cur.setText(d[3]);
       stu_nam.setText(d[4]);
       cur_apply.setText(d[5]);
       cur_fee.setText(d[6]);
       disc.setText(d[7]);
       tot_fee.setText(d[8]);
                
                
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pan = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        disc = new javax.swing.JLabel();
        adm_dt = new javax.swing.JLabel();
        print = new javax.swing.JButton();
        regno1 = new javax.swing.JLabel();
        sname1 = new javax.swing.JLabel();
        crapplying1 = new javax.swing.JLabel();
        for_no = new javax.swing.JLabel();
        reg_no = new javax.swing.JLabel();
        stu_nam = new javax.swing.JLabel();
        cur_apply = new javax.swing.JLabel();
        disc2 = new javax.swing.JLabel();
        crstudied1 = new javax.swing.JLabel();
        crfee1 = new javax.swing.JLabel();
        totfee1 = new javax.swing.JLabel();
        tot_fee = new javax.swing.JLabel();
        cur_fee = new javax.swing.JLabel();
        pre_cur = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pan.setBackground(new java.awt.Color(255, 255, 255));
        pan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/raysnewbg.png"))); // NOI18N
        pan.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 110));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("CIN: U80904BR2013PTC20489");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pan.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, 16));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("RAYS Edutech Pvt. Ltd.");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pan.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, 32));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("VisitUs:-www.raysonline.in");
        pan.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, 190, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("MailUs:-info@raysonline.in");
        pan.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 190, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Cell No:-7091599160, 9308654075");
        pan.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 40, 200, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("2ndFloor, Mithulok, West Boring Canal Road, Near Bharat Petrol Pump, Opposite Of New Tanishq, Patna, Bihar -800001");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pan.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 670, -1));
        pan.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 102, 820, 10));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Admission Receipt");
        pan.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 110, 20));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Date Of Admission :");
        pan.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, 140, 20));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Form Number :");
        pan.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 110, 20));

        jLabel30.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel30.setText("Signature...................................");
        pan.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 200, 20));
        pan.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 110, -1));

        disc.setBorder(new javax.swing.border.MatteBorder(null));
        pan.add(disc, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 260, 180, 20));

        adm_dt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        adm_dt.setBorder(new javax.swing.border.MatteBorder(null));
        pan.add(adm_dt, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, 180, 20));

        print.setBackground(new java.awt.Color(0, 255, 255));
        print.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        print.setForeground(new java.awt.Color(102, 102, 102));
        print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/print.png"))); // NOI18N
        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        pan.add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 380, 110, 30));

        regno1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        regno1.setText("Registration Number :");
        pan.add(regno1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        sname1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sname1.setText("Student Name :");
        pan.add(sname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        crapplying1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        crapplying1.setText("Course Applying :");
        pan.add(crapplying1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, -1, -1));

        for_no.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        for_no.setBorder(new javax.swing.border.MatteBorder(null));
        pan.add(for_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 180, 20));

        reg_no.setBorder(new javax.swing.border.MatteBorder(null));
        pan.add(reg_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 180, 20));

        stu_nam.setBorder(new javax.swing.border.MatteBorder(null));
        pan.add(stu_nam, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 180, 20));

        cur_apply.setBorder(new javax.swing.border.MatteBorder(null));
        pan.add(cur_apply, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 220, 180, 20));

        disc2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        disc2.setText("Discount : ");
        pan.add(disc2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 260, -1, -1));

        crstudied1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        crstudied1.setText("Previous Course :");
        pan.add(crstudied1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, -1, -1));

        crfee1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        crfee1.setText("Course Fee :");
        pan.add(crfee1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        totfee1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        totfee1.setText("Total Fee :");
        pan.add(totfee1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        tot_fee.setBorder(new javax.swing.border.MatteBorder(null));
        pan.add(tot_fee, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 180, 20));

        cur_fee.setBorder(new javax.swing.border.MatteBorder(null));
        pan.add(cur_fee, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 180, 20));

        pre_cur.setBorder(new javax.swing.border.MatteBorder(null));
        pan.add(pre_cur, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 180, 180, 20));
        pan.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 820, -1));

        getContentPane().add(pan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
//        int r=JOptionPane.showConfirmDialog(null,"DO U WANT TO PRINT THE RECORD","Confirmation Window",JOptionPane.YES_NO_OPTION);
//        if(r==0)
//        {
            print.setBorder(null);
            PrinterJob pjob = PrinterJob.getPrinterJob();
            PageFormat preformat = pjob.defaultPage();
            preformat.setOrientation(PageFormat.PORTRAIT);
            PageFormat postformat = pjob.pageDialog(preformat);
            //If user does not hit cancel then print.
            if (preformat != postformat) {
                //Set print component
                pjob.setPrintable(new ReceiptInvoice .Printer(this), postformat);
                if (pjob.printDialog()) {
                    try {
                        print.setVisible(false);
                        pjob.print();
                        this.dispose();
                    } catch (PrinterException ex) {
                    }
                }
            }
//        }
    }//GEN-LAST:event_printActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adm_dt;
    private javax.swing.JLabel crapplying1;
    private javax.swing.JLabel crfee1;
    private javax.swing.JLabel crstudied1;
    private javax.swing.JLabel cur_apply;
    private javax.swing.JLabel cur_fee;
    private javax.swing.JLabel disc;
    private javax.swing.JLabel disc2;
    private javax.swing.JLabel for_no;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPanel pan;
    private javax.swing.JLabel pre_cur;
    private javax.swing.JButton print;
    private javax.swing.JLabel reg_no;
    private javax.swing.JLabel regno1;
    private javax.swing.JLabel sname1;
    private javax.swing.JLabel stu_nam;
    private javax.swing.JLabel tot_fee;
    private javax.swing.JLabel totfee1;
    // End of variables declaration//GEN-END:variables
}
