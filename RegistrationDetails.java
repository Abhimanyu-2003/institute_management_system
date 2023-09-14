
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


public class RegistrationDetails extends javax.swing.JFrame {
    Connection con;
    public RegistrationDetails(String data[]) throws SQLException {
        initComponents();
        peradd.setBorder(null);
        this.setLocationRelativeTo(null);
        Image icon=Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/icon/repl_logo_(1)-small.png"));
        this.setIconImage(icon);
        con=ConnDb.conLink();
        this.getRootPane().setDefaultButton(print);
        reg_no.setText(data[0]);
        date.setText(data[1]);
        nam.setText(data[2]);
        fat.setText(data[3]);
        mot.setText(data[4]);
        dob.setText(data[5]);
        if(data[6]==null)
            ema.setText("");
        else
            ema.setText(data[6]);
        cont.setText(data[7]);
        pro.setText(data[8]);
        bg.setText(data[9]);
        col.setText(data[10]);
       gen.setText(data[11]);
        peradd.setText(data[12]);
        dis.setText(data[13]);
        sta.setText(data[14]);
        coradd.setText(data[15]);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel34 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        gen_rb = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        sta = new javax.swing.JLabel();
        col = new javax.swing.JLabel();
        pro = new javax.swing.JLabel();
        ema = new javax.swing.JLabel();
        mot = new javax.swing.JLabel();
        nam = new javax.swing.JLabel();
        reg_no = new javax.swing.JLabel();
        fat = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        dob = new javax.swing.JLabel();
        cont = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();
        gen = new javax.swing.JLabel();
        dis = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        print = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        peradd = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        coradd = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registration-Details");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/raysnewbg.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 110, 110));

        jLabel3.setBackground(new java.awt.Color(51, 204, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Rays Edutech Pvt. Ltd.");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 280, 32));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("CIN: U80904BR2013PTC20489");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, 16));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("2ndFloor, Mithulok, West Boring Canal Road, Near Bharat Petrol Pump, Opposite Of New Tanishq, Patna, Bihar -800001");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 660, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Cell No:-7091599160, 9308654075");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 50, 200, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("MailUs:-info@raysonline.in");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 30, 190, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("VisitUs:-www.raysonline.in");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 190, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 108, 912, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Registration Details");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 130, 20));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 120, -1));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel34.setText("Registration No.");
        jPanel1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 107, 24));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel36.setText("Date of Registration :");
        jPanel1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 130, 24));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Name ");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 80, 24));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Father's Name");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, 90, 24));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Mother's Name");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 90, 24));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("D.O.B");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, 106, 24));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setText("Email Id");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 50, 22));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setText("Program");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 145, 22));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setText("College Name");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 137, 22));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setText("Contact No.");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 106, 22));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setText("Blood Group");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, 95, 22));

        gen_rb.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        gen_rb.setText("Gender");
        jPanel1.add(gen_rb, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, 56, 22));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setText("Permanent address");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 131, 22));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("District");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 330, 78, 25));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("State");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 78, 25));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel26.setText("Correspondance address");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 370, 140, -1));

        sta.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(sta, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 300, 20));

        col.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(col, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 300, 20));

        pro.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 300, 20));

        ema.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(ema, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 300, 20));

        mot.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(mot, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 300, 20));

        nam.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(nam, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 300, 20));

        reg_no.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        reg_no.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(reg_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 300, 20));

        fat.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(fat, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 180, 270, 20));

        date.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        date.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 150, 270, 20));

        dob.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 210, 270, 20));

        cont.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(cont, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 240, 270, 20));

        bg.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 270, 270, 20));

        gen.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(gen, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 300, 270, 20));

        dis.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(dis, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 330, 270, 20));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 414, 920, -1));

        print.setBackground(new java.awt.Color(0, 255, 255));
        print.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/print.png"))); // NOI18N
        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        jPanel1.add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 420, 120, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel11.setText("Signature....................................");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 220, -1));

        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane3.setEnabled(false);
        jScrollPane3.setOpaque(false);
        jScrollPane3.setRequestFocusEnabled(false);
        jScrollPane3.setWheelScrollingEnabled(false);

        peradd.setEditable(false);
        peradd.setColumns(20);
        peradd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        peradd.setLineWrap(true);
        peradd.setRows(5);
        peradd.setWrapStyleWord(true);
        peradd.setBorder(null);
        jScrollPane3.setViewportView(peradd);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 300, 40));

        jScrollPane5.setBorder(null);
        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane5.setEnabled(false);
        jScrollPane5.setOpaque(false);
        jScrollPane5.setRequestFocusEnabled(false);
        jScrollPane5.setWheelScrollingEnabled(false);

        coradd.setEditable(false);
        coradd.setColumns(20);
        coradd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        coradd.setLineWrap(true);
        coradd.setRows(5);
        coradd.setWrapStyleWord(true);
        coradd.setBorder(null);
        jScrollPane5.setViewportView(coradd);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 370, 270, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 916, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        // TODO add your handling code here:
      
//              flag=false;
             print.setBorder(null);
             PrinterJob pjob = PrinterJob.getPrinterJob();
             PageFormat preformat = pjob.defaultPage();
             preformat.setOrientation(PageFormat.LANDSCAPE);
             PageFormat postformat = pjob.pageDialog(preformat);
             //If user does not hit cancel then print.
             if (preformat != postformat) {
                 //Set print component
                 pjob.setPrintable(new RegistrationDetails.Printer(this), postformat);
                 if (pjob.printDialog()) {
                     try {
                         print.setVisible(false);
                         pjob.print();
                         this.dispose();
                     } catch (PrinterException ex) {
                     }
                 }
             }
         
    }//GEN-LAST:event_printActionPerformed
    public static class Printer implements Printable {
    final Component comp;

    public Printer(Component comp){
        this.comp = comp;
    }
    @Override
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel col;
    private javax.swing.JLabel cont;
    private javax.swing.JTextArea coradd;
    private javax.swing.JLabel date;
    private javax.swing.JLabel dis;
    private javax.swing.JLabel dob;
    private javax.swing.JLabel ema;
    private javax.swing.JLabel fat;
    private javax.swing.JLabel gen;
    private javax.swing.JLabel gen_rb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel mot;
    private javax.swing.JLabel nam;
    private javax.swing.JTextArea peradd;
    private javax.swing.JButton print;
    private javax.swing.JLabel pro;
    private javax.swing.JLabel reg_no;
    private javax.swing.JLabel sta;
    // End of variables declaration//GEN-END:variables
}
