package raysproject;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.SQLException;

public class ReceiptInvoice extends javax.swing.JFrame {
    Connection con;
    public ReceiptInvoice(String d[]) throws SQLException{
        initComponents();
        Image icon=Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/icon/repl_logo_(1)-small.png"));
        this.setIconImage(icon);
        setTitle("Receipt-Invoice");
        this.setLocationRelativeTo(null);
        this.getRootPane().setDefaultButton(print);
       rec_lb.setText(d[0]);
        det_lb.setText(d[1]);
        frm_lb.setText(d[2]);
        cor_lb.setText(d[3]);
        stu_lb.setText(d[4]);
        pdues_lb.setText(d[5]);
        fee_lb.setText(d[6]);
        Disc_lb.setText(d[7]);
        tot_lb.setText(d[8]);
        inst_lb1.setText(d[9]);
        CAS.setText(d[10]);
        UPI.setText(d[11]);
        CHE.setText(d[12]);
        DD.setText(d[13]);
        amo_lb.setText(d[17]);
        due_lb.setText(d[14]);
        recf_lb.setText(d[15]);
        word_lb.setText(d[16]);
    }

    ReceiptInvoice() {
         }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel21 = new javax.swing.JLabel();
        jXSearchPanel1 = new org.jdesktop.swingx.JXSearchPanel();
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
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        recf_lb = new javax.swing.JLabel();
        rec_lb = new javax.swing.JLabel();
        frm_lb = new javax.swing.JLabel();
        stu_lb = new javax.swing.JLabel();
        tot_lb = new javax.swing.JLabel();
        det_lb = new javax.swing.JLabel();
        cor_lb = new javax.swing.JLabel();
        pdues_lb = new javax.swing.JLabel();
        amo_lb = new javax.swing.JLabel();
        due_lb = new javax.swing.JLabel();
        print = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        inst_lb1 = new javax.swing.JLabel();
        DD = new javax.swing.JLabel();
        CHE = new javax.swing.JLabel();
        UPI = new javax.swing.JLabel();
        CAS = new javax.swing.JLabel();
        cas1 = new javax.swing.JLabel();
        che1 = new javax.swing.JLabel();
        upi1 = new javax.swing.JLabel();
        upi2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Disc_lb = new javax.swing.JLabel();
        fee_lb = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        word_lb = new javax.swing.JTextArea();

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel21.setText("Date:-");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pan.setBackground(new java.awt.Color(255, 255, 255));
        pan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/raysnewbg.png"))); // NOI18N
        pan.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 130, 100));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("CIN: U80904BR2013PTC20489");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pan.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, 16));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("RAYS Edutech Pvt. Ltd.");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pan.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, 32));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("VisitUs:-www.raysonline.in");
        pan.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 190, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("MailUs:-info@raysonline.in");
        pan.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 190, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Cell No:-7091599160, 9308654075");
        pan.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 50, 200, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("2ndFloor, Mithulok, West Boring Canal Road, Near Bharat Petrol Pump, Opposite Of New Tanishq, Patna, Bihar -800001");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pan.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 660, -1));
        pan.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 102, 800, 10));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Payment Receipt");
        pan.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 110, 20));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Date  :");
        pan.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, 60, 20));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Receipt No :");
        pan.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 100, 20));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel23.setText("Form No :");
        pan.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 80, 20));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel24.setText("Student Name :");
        pan.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 100, 20));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel25.setText("Course Applied :");
        pan.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, 120, 20));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel26.setText("Pre Dues Amount :");
        pan.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 200, 130, 20));
        pan.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 800, 10));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel27.setText("Total Payable Fee :");
        pan.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 130, 20));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel28.setText("Paid amount :");
        pan.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, 90, 20));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel29.setText("Dues Amount :");
        pan.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 350, 100, 20));

        jLabel30.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel30.setText("Signature...................................");
        pan.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 200, 20));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel32.setText("Amout in word :");
        pan.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 120, 20));
        pan.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 110, -1));

        recf_lb.setBorder(new javax.swing.border.MatteBorder(null));
        pan.add(recf_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 390, 170, 20));

        rec_lb.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rec_lb.setBorder(new javax.swing.border.MatteBorder(null));
        pan.add(rec_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 230, 20));

        frm_lb.setBorder(new javax.swing.border.MatteBorder(null));
        pan.add(frm_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 230, 20));

        stu_lb.setBorder(new javax.swing.border.MatteBorder(null));
        pan.add(stu_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 230, 20));

        tot_lb.setBorder(new javax.swing.border.MatteBorder(null));
        pan.add(tot_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 230, 20));

        det_lb.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        det_lb.setBorder(new javax.swing.border.MatteBorder(null));
        pan.add(det_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, 170, 20));

        cor_lb.setBorder(new javax.swing.border.MatteBorder(null));
        pan.add(cor_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 170, 170, 20));

        pdues_lb.setBorder(new javax.swing.border.MatteBorder(null));
        pan.add(pdues_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 200, 170, 20));

        amo_lb.setBorder(new javax.swing.border.MatteBorder(null));
        pan.add(amo_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 320, 170, 20));

        due_lb.setBorder(new javax.swing.border.MatteBorder(null));
        pan.add(due_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 350, 170, 20));

        print.setBackground(new java.awt.Color(0, 255, 255));
        print.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        print.setForeground(new java.awt.Color(51, 51, 51));
        print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/print.png"))); // NOI18N
        print.setText("Print");
        print.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        pan.add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 420, 110, 30));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel33.setText("Recived From :");
        pan.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 390, 100, 20));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel34.setText("Installment Date :");
        pan.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 260, 120, 20));

        inst_lb1.setBorder(new javax.swing.border.MatteBorder(null));
        pan.add(inst_lb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 260, 170, 20));

        DD.setBorder(new javax.swing.border.MatteBorder(null));
        pan.add(DD, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 350, 70, 20));

        CHE.setBorder(new javax.swing.border.MatteBorder(null));
        pan.add(CHE, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 80, 20));

        UPI.setBorder(new javax.swing.border.MatteBorder(null));
        pan.add(UPI, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 70, 20));

        CAS.setBorder(new javax.swing.border.MatteBorder(null));
        pan.add(CAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 80, 20));

        cas1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        cas1.setText("Cas :");
        pan.add(cas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 90, 20));

        che1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        che1.setText("Cheque :");
        pan.add(che1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 90, 20));

        upi1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        upi1.setText("DD :");
        pan.add(upi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, 60, 20));

        upi2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        upi2.setText("Upi :");
        pan.add(upi2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 60, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setText("Discount :-");
        pan.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, 100, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setText("Fee :-");
        pan.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 100, 20));

        Disc_lb.setBorder(new javax.swing.border.MatteBorder(null));
        pan.add(Disc_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 230, 170, 20));

        fee_lb.setBorder(new javax.swing.border.MatteBorder(null));
        pan.add(fee_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 230, 20));

        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane3.setEnabled(false);
        jScrollPane3.setOpaque(false);
        jScrollPane3.setRequestFocusEnabled(false);
        jScrollPane3.setWheelScrollingEnabled(false);

        word_lb.setEditable(false);
        word_lb.setColumns(20);
        word_lb.setLineWrap(true);
        word_lb.setRows(5);
        word_lb.setWrapStyleWord(true);
        word_lb.setBorder(null);
        jScrollPane3.setViewportView(word_lb);

        pan.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 300, 40));

        getContentPane().add(pan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
//        int r;//=JOptionPane.showConfirmDialog(null,"DO U WANT TO PRINT THE RECORD","Confirmation Window",JOptionPane.YES_NO_OPTION);
//         if(r==0)
         {
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
         }
    }//GEN-LAST:event_printActionPerformed
public static class Printer implements Printable {
    final Component comp;

    public Printer(Component comp){
        this.comp = comp;
    }
   
        public int print(Graphics g, PageFormat format, int page_index) 
            throws PrinterException {
        if (page_index > 0) {
            return Printable.NO_SUCH_PAGE;
        }

        // get the bounds of the component
        Dimension dim = comp.getSize();
        double cHeight = dim.getHeight();
        double cWidth = dim.getWidth();
        // get the bounds of the printable area
        double pHeight = format.getImageableHeight();
        double pWidth = format.getImageableWidth();

        double pXStart = format.getImageableX();
        double pYStart = format.getImageableY();

        double xRatio = pWidth / cWidth;
        double yRatio = pHeight / cHeight;
        Graphics2D g2 = (Graphics2D) g;
        g2.translate(pXStart, pYStart);
        g2.scale(xRatio, yRatio);
        comp.paint(g2);
        return Printable.PAGE_EXISTS;
}}
    /**
     * @param args the command line arguments
     */
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
//            java.util.logging.Logger.getLogger(ReceiptInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ReceiptInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ReceiptInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ReceiptInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ReceiptInvoice().setVisible(true); // Logger.getLogger(ReceiptInvoice.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CAS;
    private javax.swing.JLabel CHE;
    private javax.swing.JLabel DD;
    private javax.swing.JLabel Disc_lb;
    private javax.swing.JLabel UPI;
    private javax.swing.JLabel amo_lb;
    private javax.swing.JLabel cas1;
    private javax.swing.JLabel che1;
    private javax.swing.JLabel cor_lb;
    private javax.swing.JLabel det_lb;
    private javax.swing.JLabel due_lb;
    private javax.swing.JLabel fee_lb;
    private javax.swing.JLabel frm_lb;
    private javax.swing.JLabel inst_lb1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private org.jdesktop.swingx.JXSearchPanel jXSearchPanel1;
    private javax.swing.JPanel pan;
    private javax.swing.JLabel pdues_lb;
    private javax.swing.JButton print;
    private javax.swing.JLabel rec_lb;
    private javax.swing.JLabel recf_lb;
    private javax.swing.JLabel stu_lb;
    private javax.swing.JLabel tot_lb;
    private javax.swing.JLabel upi1;
    private javax.swing.JLabel upi2;
    private javax.swing.JTextArea word_lb;
    // End of variables declaration//GEN-END:variables
}
