package raysproject;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import jxl.write.Label;
import jxl.write.WriteException;
public class CourseMdiForm extends javax.swing.JFrame {
 
    Connection con;
    PreparedStatement stmt;
    ResultSet rs;
    String str,url;
    int ano;
    double t,a,d;
    byte ctr,rol;
    Label l;
    DefaultTableModel model;
    boolean flag;
    public CourseMdiForm(byte role) throws SQLException {
         initComponents();
         rol=role;
         if(role==0){
            cor_Id.setEditable(true);
        }
         else if(role==1){
             del_bt.setVisible(false);
            cor_Id.setEditable(false);
        }
         //###############
         cur_cb.setSelectedIndex(0);
         cb.setVisible(false);
         pan.setVisible(false);
         upd_bt.setVisible(false);
         del_bt.setVisible(false);
         con=ConnDb.conLink();
         this.setLocationRelativeTo(null);
        Image icon=Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/icon/repl_logo_(1)-small.png"));
        this.setIconImage(icon);
         setTitle("CourseForm");
         this.getRootPane().setDefaultButton(add_bt);
         this.setLocationRelativeTo(null);
         cor_nam.requestFocus();
         tabl.setVisible(true);
       //************this code use service form*****************  
        ser_tf.setVisible(true);
        cur_cb.setSelectedIndex(0);
        url="select * from course where upper(CID)=?";  
        stmt=con.prepareStatement("select cid from automatic");
        rs=stmt.executeQuery();
        rs.next();
        ano=rs.getInt(1)+1;
    
     auto();
    }
     void auto(){
       boolean flag=true;
       if(ano<10)
           str="REPLC00"+ano;
       else if(ano<100)
           str="REPLC0"+ano;
       else if(ano<1000)
           str="REPLC"+ano;
       else{
           String showInputDialog = JOptionPane.showInputDialog("more than 999 not allow");
           flag=false;
       }
       if(flag)
       {
       cor_Id.setText(str);
       cor_nam.requestFocus();
       } 
       else
           add_bt.setVisible(false);
}
     void RedBorder(){
         flcourse(cor_nam);
         flcourse(cor_fee);
         flcourse(cor_dur);
//        flcourse(otp);
     }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXSearchPanel1 = new org.jdesktop.swingx.JXSearchPanel();
        jLabel9 = new javax.swing.JLabel();
        tab = new javax.swing.JTabbedPane();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cor_dur = new javax.swing.JTextField();
        cor_nam = new javax.swing.JTextField();
        cor_Id = new javax.swing.JTextField();
        add_bt = new javax.swing.JButton();
        rec_bt = new javax.swing.JButton();
        time_cb = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cor_fee = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        per = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        otp = new javax.swing.JTextField();
        cor_lb = new javax.swing.JLabel();
        kGradientPanel6 = new keeptoo.KGradientPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        Search = new javax.swing.JButton();
        cur_cb = new javax.swing.JComboBox<>();
        del_bt = new javax.swing.JButton();
        upd_bt = new javax.swing.JButton();
        ser_tf = new org.jdesktop.swingx.JXSearchField();
        ref_bt = new javax.swing.JButton();
        pan = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabl = new javax.swing.JTable();
        cb = new javax.swing.JComboBox<>();

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9.setText("*");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tab.setFocusable(false);
        tab.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tab.setRequestFocusEnabled(false);
        tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabMouseClicked(evt);
            }
        });

        kGradientPanel1.setkEndColor(new java.awt.Color(49, 183, 194));
        kGradientPanel1.setkGradientFocus(1500);
        kGradientPanel1.setkStartColor(new java.awt.Color(123, 195, 147));
        kGradientPanel1.setRequestFocusEnabled(false);
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(56, 78, 120));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 205));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("COURSE ENTRY DETAILS");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 230, 29));

        jButton1.setBackground(new java.awt.Color(0, 51, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/home.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 70, 40));

        kGradientPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 60));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("OTP(discount)");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 169, 100, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Course Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 59, 100, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Duration");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 119, 70, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Course Id");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 59, 70, 30));

        cor_dur.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cor_durFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cor_durFocusLost(evt);
            }
        });
        cor_dur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cor_durKeyTyped(evt);
            }
        });
        jPanel1.add(cor_dur, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 119, 110, 30));

        cor_nam.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cor_namFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cor_namFocusLost(evt);
            }
        });
        cor_nam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cor_namActionPerformed(evt);
            }
        });
        cor_nam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cor_namKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cor_namKeyTyped(evt);
            }
        });
        jPanel1.add(cor_nam, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 59, 180, 30));

        cor_Id.setEditable(false);
        cor_Id.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(cor_Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 59, 160, 30));

        add_bt.setBackground(new java.awt.Color(0, 116, 226));
        add_bt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        add_bt.setForeground(new java.awt.Color(255, 255, 255));
        add_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        add_bt.setText("ADD");
        add_bt.setBorder(null);
        add_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add_bt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                add_btFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                add_btFocusLost(evt);
            }
        });
        add_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btActionPerformed(evt);
            }
        });
        jPanel1.add(add_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 229, 100, 30));

        rec_bt.setBackground(new java.awt.Color(204, 0, 51));
        rec_bt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rec_bt.setForeground(new java.awt.Color(255, 255, 255));
        rec_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/clear_1.png"))); // NOI18N
        rec_bt.setText("CLEAR");
        rec_bt.setBorder(null);
        rec_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rec_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rec_btActionPerformed(evt);
            }
        });
        rec_bt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rec_btKeyPressed(evt);
            }
        });
        jPanel1.add(rec_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 229, 100, 30));

        time_cb.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        time_cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HOURS", "DAYS", "MONTHS" }));
        time_cb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(time_cb, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 119, 70, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 0, 0));
        jLabel7.setText("*");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 69, 20, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 0, 0));
        jLabel8.setText("*");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 129, 20, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 0, 0));
        jLabel11.setText("*");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 69, 20, 10));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Course Fee");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 119, 100, 30));

        cor_fee.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cor_feeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cor_feeFocusLost(evt);
            }
        });
        cor_fee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cor_feeKeyTyped(evt);
            }
        });
        jPanel1.add(cor_fee, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 119, 160, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 0, 0));
        jLabel13.setText("*");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 129, 20, -1));

        per.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        per.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        per.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                perKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                perKeyTyped(evt);
            }
        });
        jPanel1.add(per, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 169, 40, 24));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("%");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 169, 20, 20));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/rs.png"))); // NOI18N
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 169, -1, -1));

        otp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        otp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        otp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                otpKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                otpKeyTyped(evt);
            }
        });
        jPanel1.add(otp, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 169, 80, 24));

        cor_lb.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(cor_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 180, 10));

        kGradientPanel1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 750, 340));

        tab.addTab("Course Entry From", kGradientPanel1);

        kGradientPanel6.setkEndColor(new java.awt.Color(38, 144, 140));
        kGradientPanel6.setkGradientFocus(100);
        kGradientPanel6.setkStartColor(new java.awt.Color(38, 173, 166));
        kGradientPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(56, 78, 120));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("COURSE SERVICE FORM");
        jPanel10.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 230, 36));

        kGradientPanel6.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 60));

        Search.setBackground(new java.awt.Color(0, 116, 226));
        Search.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search-icon-png-9964.png"))); // NOI18N
        Search.setText("Search All");
        Search.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });
        kGradientPanel6.add(Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 110, 31));

        cur_cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Course Id","Course Name" }));
        cur_cb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cur_cb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cur_cbActionPerformed(evt);
            }
        });
        kGradientPanel6.add(cur_cb, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 192, 31));

        del_bt.setBackground(new java.awt.Color(255, 22, 0));
        del_bt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        del_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        del_bt.setText("DELETE");
        del_bt.setBorder(null);
        del_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        del_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                del_btActionPerformed(evt);
            }
        });
        kGradientPanel6.add(del_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, 100, 30));

        upd_bt.setBackground(new java.awt.Color(255, 85, 2));
        upd_bt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        upd_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.png"))); // NOI18N
        upd_bt.setText("UPDATE");
        upd_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        upd_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upd_btActionPerformed(evt);
            }
        });
        kGradientPanel6.add(upd_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, 100, 30));

        ser_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ser_tfFocusLost(evt);
            }
        });
        ser_tf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ser_tfKeyTyped(evt);
            }
        });
        kGradientPanel6.add(ser_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 210, 30));

        ref_bt.setBackground(new java.awt.Color(255, 0, 51));
        ref_bt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ref_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        ref_bt.setText("Refresh");
        ref_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ref_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ref_btActionPerformed(evt);
            }
        });
        kGradientPanel6.add(ref_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, 100, 30));

        pan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabl.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        tabl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course Id", "Course Name", "Course Duration", "Course fee", "OTP", "Select"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabl.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tabl.getTableHeader().setReorderingAllowed(false);
        tabl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabl);

        pan.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 260));

        kGradientPanel6.add(pan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 780, 260));

        cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        cb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbActionPerformed(evt);
            }
        });
        kGradientPanel6.add(cb, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 210, 30));

        tab.addTab("Service Form", kGradientPanel6);

        getContentPane().add(tab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rec_btKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rec_btKeyPressed

        char ch=evt.getKeyChar();
        if(ch==10)
        {
            cor_nam.setText("");
            cor_nam.requestFocus();
            cor_nam.setBorder(new LineBorder(Color.BLACK));
            cor_fee.setText("");
            cor_fee.setBorder(new LineBorder(Color.BLACK));
            cor_dur.setText("");
            cor_dur.setBorder(new LineBorder(Color.BLACK));

        }
    }//GEN-LAST:event_rec_btKeyPressed

    private void rec_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rec_btActionPerformed
       cancel();
    }//GEN-LAST:event_rec_btActionPerformed

    private void add_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btActionPerformed
        flag=true;
        RedBorder();
        if(!(cor_lb.getText()==null||cor_lb.getText().isEmpty())){
            flag=false;
        }
        if(flag){
            byte ghj=(byte)JOptionPane.showConfirmDialog(this, "Are You Sure Want to Insert This Record!");
            if(ghj==0){
                try {

                    stmt=con.prepareStatement("insert into course values(?,?,?,?,?)");
                    stmt.setString(1,cor_Id.getText());
                    stmt.setString(2,cor_nam.getText().trim());
                    stmt.setString(3,cor_dur.getText()+" "+time_cb.getSelectedItem());
                    stmt.setString(4,cor_fee.getText());
                    if(otp.getText().isEmpty()||otp.getText()==null||otp.getText().length()==0)
                        stmt.setString(5, "0");
                    else
                        stmt.setString(5,otp.getText());
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record inserted successfully");
                    ano++;
                    backdata.backup("Course");
                    auto();
                    //*********************Update automatic Course id****************
                    stmt=con.prepareStatement("update automatic set cid=?");
                    stmt.setInt(1,ano-1);
                    stmt.executeUpdate();
                    backdata.backup("Automatic");
                    cancel();          
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Something Went Wrong!");

                    } catch (WriteException ex) {
                        Logger.getLogger(CourseMdiForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }  
        }    
     
    }//GEN-LAST:event_add_btActionPerformed

    private void cor_namKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cor_namKeyTyped
        char ch=evt.getKeyChar();       
        if((evt.getKeyChar()==' '||ch=='0'||!(ch>='a'&& ch<='z'|| ch==8||ch==' '||ch>='A'&& ch<='Z'||ch>='0'&& ch<='9')) && cor_nam.getCaretPosition()==0)
        {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        else if(ch!=' ')
        ctr=0;
        else if(evt.getKeyChar()==' ' && ctr==0)
            ctr=1;
        else{
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_cor_namKeyTyped

    private void cor_namFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cor_namFocusLost
        flcourse(cor_nam);  
        try {
            stmt=con.prepareStatement("select *from course where upper(cname)=?");
            stmt.setString(1, cor_nam.getText().toUpperCase().trim());
            rs=stmt.executeQuery();
            if(rs.next()){
                cor_lb.setText("Course is Already Exists!");
                JOptionPane.showMessageDialog(this, "Course is Already Exists!");
            }
            else{
              cor_lb.setText("");  
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseMdiForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cor_namFocusLost

    private void cor_namFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cor_namFocusGained
        
        fgcourse(cor_nam);
    }//GEN-LAST:event_cor_namFocusGained

    private void cor_durKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cor_durKeyTyped
        char ch=evt.getKeyChar();
        if(evt.getKeyChar()=='0'&& cor_dur.getCaretPosition()==0)
        {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        if(!(ch>='0'&& ch<='9'|| ch==8)){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_cor_durKeyTyped

    private void cor_durFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cor_durFocusLost
        
        flcourse(cor_dur);
    }//GEN-LAST:event_cor_durFocusLost

    private void cor_durFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cor_durFocusGained
        
        fgcourse(cor_dur);
    }//GEN-LAST:event_cor_durFocusGained

    private void add_btFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_add_btFocusLost
        
       // add_bt.setBackground(new java.awt.Color(0, 102, 102));
    }//GEN-LAST:event_add_btFocusLost

    private void add_btFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_add_btFocusGained
        
       // add_bt.setBackground(new java.awt.Color(0, 126, 126));
    }//GEN-LAST:event_add_btFocusGained

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
    byte k=0;
        try {
         stmt=con.prepareStatement("select * from course");
         rs=stmt.executeQuery();
         model=(DefaultTableModel)tabl.getModel();
         model.setRowCount(0);
            while(rs.next()){
                k=1;
                if(rol==0){
                    del_bt.setVisible(true);
                }
                else if(rol==1){
                    del_bt.setVisible(false);
                }
                pan.setVisible(true);
                upd_bt.setVisible(true);
                model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),false});
             }
            if(k==0)
                JOptionPane.showMessageDialog(this, "No Record Found!");
        } catch (SQLException ex) {
            Logger.getLogger(CourseMdiForm.class.getName()).log(Level.SEVERE, null, ex);
         
     }
    }//GEN-LAST:event_SearchActionPerformed

    private void cur_cbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cur_cbActionPerformed
        byte k=0;
        url="select * from Course where ";
        if(cur_cb.getSelectedIndex()==0){
            ser_tf.setVisible(true);
            cb.setVisible(false);
            url=url+"upper(CID)=?";
            ser_tf.requestFocus();
        }
        else{
            ser_tf.setText("");
            ser_tf.setVisible(false);
            cb.setVisible(true);
            cb.removeAllItems();
           url="select cname from course" ;
            try {
                stmt=con.prepareStatement(url);
                rs=stmt.executeQuery();
            cb.addItem("Select Any Course");
                while(rs.next()){
                    System.out.println(rs.getString(1));
                    k=1;
                    cb.addItem(rs.getString(1));
                }
                if(k==0)
                    JOptionPane.showMessageDialog(this, "No Record Found!");
            } catch (SQLException ex) {
                Logger.getLogger(CourseMdiForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
    }//GEN-LAST:event_cur_cbActionPerformed

    private void upd_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upd_btActionPerformed

         for(byte i=0;i<tabl.getRowCount();i++){
              if(model.getValueAt(i,4).equals(true)){
               byte a=(byte) JOptionPane.showConfirmDialog(this,"are you sure update recoard?");
                  if(a==0)
                  try {
                      stmt=con.prepareStatement("update course set cdur=?,cfee=?,otp=? where cid=?");
                      stmt.setString(4,model.getValueAt(i,0).toString().toUpperCase());
                      stmt.setString(1,model.getValueAt(i,2).toString().toUpperCase());
                      stmt.setString(2,model.getValueAt(i,3).toString().toUpperCase());
                      stmt.setString(3,model.getValueAt(i,4).toString().toUpperCase());
                      stmt.executeUpdate();
                      JOptionPane.showMessageDialog(this,"Recoard Updated sucessfully!");
                      backdata.backup("Course");
                  } catch (SQLException ex) {
                      Logger.getLogger(CourseMdiForm.class.getName()).log(Level.SEVERE, null, ex);
                      JOptionPane.showMessageDialog(this,"Something Wrong in update_bt");
                  } catch (WriteException ex) {
                   Logger.getLogger(CourseMdiForm.class.getName()).log(Level.SEVERE, null, ex);
               }
              }
            }
    }//GEN-LAST:event_upd_btActionPerformed

 @SuppressWarnings("empty-statement")
    private void del_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_del_btActionPerformed
        for(byte i=0;i<tabl.getRowCount();i++){
              if(model.getValueAt(i,4).equals(true)){
                  byte a=(byte) JOptionPane.showConfirmDialog(this,"are you sure delete recoard?");
                  if(a==0)
                  try {
                      stmt=con.prepareStatement("delete from course where cid=?");
                      stmt.setString(1,model.getValueAt(i,0).toString());
                      stmt.executeUpdate();
                      model.removeRow(i);
                      i--;
                      // JOptionPane.showMessageDialog(this,"Recoard Updated sucessfully!");
                       backdata.backup("Course");
                      backdata.backup("Automatic");
                  } catch (SQLException ex) {
                      Logger.getLogger(CourseMdiForm.class.getName()).log(Level.SEVERE, null, ex);
                      
                  } catch (WriteException ex) {
                      Logger.getLogger(CourseMdiForm.class.getName()).log(Level.SEVERE, null, ex);
                  }
              }                
    }
    }//GEN-LAST:event_del_btActionPerformed

    private void ref_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ref_btActionPerformed
       // serdel();
        ser_tf.setText("");
        ser_tf.requestFocus();
        upd_bt.setVisible(false);
        del_bt.setVisible(false);
      // cur_cb.setSelectedIndex(0);
         model.setRowCount(0);
        
    }//GEN-LAST:event_ref_btActionPerformed

    private void tablMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablMouseClicked
      for(byte i=0; i<tabl.getRowCount();i++){  
          if(model.getValueAt(i,4).equals(true)){
            tabl.addRowSelectionInterval(i,i);
            tabl.setSelectionBackground(Color.yellow);
            tabl.setSelectionForeground(Color.red); 
          }
          else
              tabl.removeRowSelectionInterval(i,i);  
         
    }//GEN-LAST:event_tablMouseClicked
}
    private void tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabMouseClicked
       if(tab.getSelectedIndex()==0)
           this.getRootPane().setDefaultButton(add_bt);
       else
           this.getRootPane().setDefaultButton(Search);
    }//GEN-LAST:event_tabMouseClicked

    private void ser_tfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ser_tfKeyTyped
         char ch=evt.getKeyChar();
        if(cur_cb.getSelectedIndex()==0){         
             if(ser_tf.getText().length()>=8)
            {
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
            }
            if(!(ch>='A'&& ch<='Z'||ch>='a'&&ch<='z'||ch==8 ||ch>='0'&& ch<='9'))
            {
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
            }
        }
//        else if(cur_cb.getSelectedIndex()==1){ 
//            if(ser_tf.getText().length()>=18)
//            {
//                 evt.consume();
//                Toolkit.getDefaultToolkit().beep();
//            }
//            else if(!(ch>='A'&& ch<='Z'||ch>='a'&&ch<='z'||ch==8 ||ch>='0'&& ch<='9'||ch==' '))
//            {
//                evt.consume();
//                Toolkit.getDefaultToolkit().beep();
//            }
//         else if(ch==8||((ch>='a' && ch<='z' )|| (ch>='A'&& ch<='Z' )|| ch>='0'&& ch<='9'))
//            ctr=0;
//        else if(evt.getKeyChar()==' ' && ctr==0)
//            ctr=1;
//        else{
//            evt.consume();
//            Toolkit.getDefaultToolkit().beep();
//        }
//        }
    }//GEN-LAST:event_ser_tfKeyTyped

    private void cor_namKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cor_namKeyReleased
        
    }//GEN-LAST:event_cor_namKeyReleased

    private void cor_namActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cor_namActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cor_namActionPerformed

    private void cor_feeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cor_feeFocusGained
       fgcourse(cor_fee);
    }//GEN-LAST:event_cor_feeFocusGained

    private void cor_feeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cor_feeFocusLost
         flcourse(cor_fee);
    }//GEN-LAST:event_cor_feeFocusLost

    private void cor_feeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cor_feeKeyTyped
         char ch=evt.getKeyChar();
        if(evt.getKeyChar()=='0'&& cor_fee.getCaretPosition()==0)
        {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        if(!(ch>='0'&& ch<='9'|| ch==8)){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_cor_feeKeyTyped

    private void perKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_perKeyReleased
        if(!cor_fee.getText().equals("*Field is mandatory!")&&!cor_fee.getText().equals("0")&&cor_fee.getText().length()!=0){
        String d=per.getText();
            if (!d.equals("")){
               double t=Double.parseDouble(cor_fee.getText());
                double e=Double.parseDouble(per.getText());
                double b=(e*t/100);
                otp.setText(""+String.format("%d",(int)b));
            }
            else if (per.getText().length()==0)
                otp.setText("");
        }
    }//GEN-LAST:event_perKeyReleased

    private void perKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_perKeyTyped
        char ch=evt.getKeyChar();
         if(evt.getKeyChar()=='0'&& per.getCaretPosition()==0||evt.getKeyChar()=='.'&& per.getCaretPosition()==0)
         {
             evt.consume();
             Toolkit.getDefaultToolkit().beep();
         }
         else if(!(ch>='0'&& ch<='9'|| ch==8||ch=='.' && ctr==0)){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
         else if(((ch>='0' && ch<='9')||ch==8)) {
            ctr=0;            
        }
         else if(evt.getKeyChar()=='.'&&ctr==0)
            ctr=1;
        else {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_perKeyTyped

    private void otpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_otpKeyTyped
        char ch=evt.getKeyChar();
        if(evt.getKeyChar()=='0'&& otp.getCaretPosition()==0)
        {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        if(!(ch>='0'&& ch<='9'|| ch==8)){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_otpKeyTyped

    private void otpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_otpKeyReleased
        if(!cor_fee.getText().equals("*Field is mandatory!")&&!cor_fee.getText().equals("0")&&cor_fee.getText().length()!=0){
        String d=otp.getText();
            if (!d.equals("")){
               double t=Double.parseDouble(cor_fee.getText());
                double e=Double.parseDouble(otp.getText());
                double b=(e*100/t);
                per.setText(""+String.format("%.2f",b));
            }
            else if (otp.getText().length()==0)
                per.setText("");
        }
    }//GEN-LAST:event_otpKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ser_tfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ser_tfFocusLost
        byte k=0;    
        try {
                stmt=con.prepareStatement(url);
                stmt.setString(1,ser_tf.getText().toUpperCase());
                rs=stmt.executeQuery();
                model=(DefaultTableModel)tabl.getModel();
                model.setRowCount(0);
                while(rs.next()){
                    k=1;
                    if(rol==0){
                        del_bt.setVisible(true);
                    }
                    else if(rol==1){
                        del_bt.setVisible(false);
                    }
                    pan.setVisible(true);
                    upd_bt.setVisible(true);
                    model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),false});
                 } 
                if(k==0)
                    JOptionPane.showMessageDialog(this, "No Record Found!");
        } catch (SQLException ex) {
            Logger.getLogger(CourseMdiForm.class.getName()).log(Level.SEVERE, null, ex);   
     }
    }//GEN-LAST:event_ser_tfFocusLost

    private void cbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbActionPerformed
        byte k=0;
        if(!(cb.getSelectedItem()==null||cb.getSelectedItem().toString().equalsIgnoreCase("Select Any Course")))
        {
            try {
            stmt=con.prepareStatement("select * from course where cname=?");
            stmt.setString(1,cb.getSelectedItem().toString());
            rs=stmt.executeQuery();
             model=(DefaultTableModel)tabl.getModel();
             model.setRowCount(0);
               while(rs.next()){
                   k=1;
                   if(rol==0){
                       del_bt.setVisible(true);
                   }
                   else if(rol==1){
                       del_bt.setVisible(false);
                   }
                   pan.setVisible(true);
                   upd_bt.setVisible(true);
                   model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),false});
                }
               if(k==0)
                   JOptionPane.showMessageDialog(this, "No Record Found!");
            } catch (SQLException ex) {
                Logger.getLogger(CourseMdiForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cbActionPerformed
    
    public void cancel(){
          cor_nam.requestFocus();
          cor_nam.setText("");
          cor_nam.setForeground(Color.BLACK);
          cor_nam.setBorder(new LineBorder(Color.BLACK));
          cor_fee.setText("");
          cor_fee.setForeground(Color.BLACK);
          cor_fee.setBorder(new LineBorder(Color.BLACK));
          cor_dur.setText("");
          cor_dur.setForeground(Color.BLACK);
          cor_dur.setBorder(new LineBorder(Color.BLACK));
          otp.setText("");
          per.setText("");
//          rec_bt.setEnabled(false);
      }
        
         public void flcourse(JTextField fl)
        {
           String str=fl.getText();
           if(str.length()==0||str.isEmpty()||str==null||str.equalsIgnoreCase("*Field is mandatory!")){
               flag=false;
               fl.setForeground(Color.red);
               fl.setText("*Field is mandatory!");
               fl.setBorder(new LineBorder(Color.RED));
               Toolkit.getDefaultToolkit().beep();
        } 
    }
    public void fgcourse(JTextField fg)
    {
        String str=fg.getText();
        if(str.length()==0||str.isEmpty()||str==null||str.equalsIgnoreCase("*Field is mandatory!")){
            fg.setForeground(Color.BLACK);
            fg.setBorder(new LineBorder(Color.black));
            fg.setText("");
            Toolkit.getDefaultToolkit().beep();
        } 
    }
    public void regKr(JTextField d){
         String str[]=d.getText().split(" ");
         String res="";
         for(String t:str)
             res=res+(t.substring(0,1).toUpperCase()+t.substring(1,t.length()).toLowerCase())+" ";
         d.setText(res);
    } 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Search;
    private javax.swing.JButton add_bt;
    private javax.swing.JComboBox<String> cb;
    private javax.swing.JTextField cor_Id;
    private javax.swing.JTextField cor_dur;
    private javax.swing.JTextField cor_fee;
    private javax.swing.JLabel cor_lb;
    private javax.swing.JTextField cor_nam;
    private javax.swing.JComboBox<String> cur_cb;
    private javax.swing.JButton del_bt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXSearchPanel jXSearchPanel1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel6;
    private javax.swing.JTextField otp;
    private javax.swing.JPanel pan;
    private javax.swing.JTextField per;
    private javax.swing.JButton rec_bt;
    private javax.swing.JButton ref_bt;
    private org.jdesktop.swingx.JXSearchField ser_tf;
    private javax.swing.JTabbedPane tab;
    private javax.swing.JTable tabl;
    private javax.swing.JComboBox<String> time_cb;
    private javax.swing.JButton upd_bt;
    // End of variables declaration//GEN-END:variables
}
