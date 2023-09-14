package raysproject;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import jxl.write.Label;
import jxl.write.WriteException;

public class BranchDetails extends javax.swing.JFrame {
    Connection con;
    ResultSet rs;
    PreparedStatement stmt;
    int bcode,kk=0;
    byte ctr=0,dot=0,rol;
    String str,st,stt,url,s;
    boolean chk=true;
    DefaultTableModel model;
    Label l;
    public BranchDetails() throws SQLException {
        initComponents();
        con=ConnDb.conLink();
        cur_dt.setDate(new java.sql.Date(System.currentTimeMillis()));
        Image icon=Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/icon/repl_logo_(1)-small.png"));
        this.setIconImage(icon);
        setTitle("Branch Details Form");
        this.setLocationRelativeTo(null);
        bran_tf.requestFocus();
        this.getRootPane().setDefaultButton(add_bt);
        sta_box.setSelectedIndex(3);
        stt=sta_box.getSelectedItem().toString();
        stt=stt.substring(0, stt.length()-3);
        stmt=con.prepareStatement("select br from state");
        rs=stmt.executeQuery();
        rs.next();
        bcode=rs.getInt(1)+1;
        st="BR";
        autogen();
        ser_box.setSelectedIndex(1);
        ser_cb.removeAllItems();
        stmt=con.prepareStatement("select distinct bname from branch_details");
        rs=stmt.executeQuery();
        while(rs.next())
            ser_cb.addItem(rs.getString(1));
        tb.setVisible(false);
        upd_bt.setVisible(false);
        del_bt.setVisible(false);
        stadis("Bihar");
    }
    public void autogen(){
        boolean flag=true;
        if(bcode<10)
            str=st+"00"+bcode;
        else if(bcode<100)
            str=st+"0"+bcode;
        else if(bcode<1000)
            str=st+bcode;
        else{
            JOptionPane.showMessageDialog(this, "More than 999 branch code not allowed!");
            flag=false;
        }
        if(flag)
            br_code.setText(str.toUpperCase());
        else
            add_bt.setVisible(flag);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tab2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        br_code = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cur_dt = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        bran_tf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        brc_tf = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        mail_tf = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        con_tf = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        add_bt = new javax.swing.JButton();
        can_bt = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        adds_tf = new javax.swing.JTextArea();
        sta_box = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        dis_cb = new javax.swing.JComboBox<>();
        con_lb = new javax.swing.JLabel();
        mail_lb = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        tab3 = new javax.swing.JPanel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel17 = new javax.swing.JLabel();
        ser_box = new javax.swing.JComboBox<>();
        ser_bt = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        del_bt = new javax.swing.JButton();
        upd_bt = new javax.swing.JButton();
        ser_cb = new javax.swing.JComboBox<>();
        ser_lb = new javax.swing.JLabel();
        ref_bt = new javax.swing.JButton();
        tb = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tab2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tab2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab2MouseClicked(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setkEndColor(new java.awt.Color(51, 102, 255));
        kGradientPanel1.setkGradientFocus(1500);
        kGradientPanel1.setkStartColor(new java.awt.Color(102, 153, 255));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Branch Code");
        kGradientPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 100, -1));

        br_code.setEditable(false);
        kGradientPanel1.add(br_code, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 277, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Date");
        kGradientPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 47, 30));
        kGradientPanel1.add(cur_dt, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 277, 30));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Branch Name");

        bran_tf.setNextFocusableComponent(brc_tf);
        bran_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bran_tfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bran_tfFocusLost(evt);
            }
        });
        bran_tf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bran_tfKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Branch Contact person");

        brc_tf.setNextFocusableComponent(mail_tf);
        brc_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                brc_tfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                brc_tfFocusLost(evt);
            }
        });
        brc_tf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                brc_tfKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Email ID");

        mail_tf.setNextFocusableComponent(con_tf);
        mail_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                mail_tfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                mail_tfFocusLost(evt);
            }
        });
        mail_tf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mail_tfKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Phone Number");

        con_tf.setNextFocusableComponent(adds_tf);
        con_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                con_tfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                con_tfFocusLost(evt);
            }
        });
        con_tf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                con_tfKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Address");

        add_bt.setBackground(new java.awt.Color(0, 116, 226));
        add_bt.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        add_bt.setForeground(new java.awt.Color(255, 255, 255));
        add_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        add_bt.setText("ADD");
        add_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btActionPerformed(evt);
            }
        });

        can_bt.setBackground(new java.awt.Color(204, 0, 51));
        can_bt.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        can_bt.setForeground(new java.awt.Color(255, 255, 255));
        can_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/clear_1.png"))); // NOI18N
        can_bt.setText("CLEAR");
        can_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                can_btActionPerformed(evt);
            }
        });
        can_bt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                can_btKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 153));
        jLabel8.setText("BRANCH ENTRY DETAILS");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("State");

        adds_tf.setColumns(20);
        adds_tf.setLineWrap(true);
        adds_tf.setRows(5);
        adds_tf.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        adds_tf.setNextFocusableComponent(sta_box);
        adds_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                adds_tfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                adds_tfFocusLost(evt);
            }
        });
        adds_tf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                adds_tfKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(adds_tf);

        sta_box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Andhra Pradesh-AD","Arunachal Pradesh-AR","Assam-AM","Bihar-BR","Chattisgarh-CG","Delhi-DL","Goa-GA","Gujarat-GJ","Haryana-HR","Himachal Pradesh-HP","Jammu & Kashmir-JK","Jharkhand-JH","Karnataka-KA","Kerala-KL","Lakshadweep-LD","Madhya Pradesh-MP","Maharashtra-MH","Manipur-MN","Meghalaya-ML","Mizoram-MZ","Nagaland-NL","Odisha-OD","Punjab-PB","Rajasthan-RJ","Sikkim-SK","Tamil Nadu-TN","Telangana-TS","Tripura-TR","Uttar Pradesh-UP","Uttarakhand-UK","West Bengal-WB","Andaman & Nicobar-AN","Chandigarh-CH","Dadra & Nagar Haveli and Daman & Diu-DN","Pondicherry-PY","Chandigarh-CH",
        }));
        sta_box.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        sta_box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sta_boxActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("District");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("*");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("*");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("*");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setText("*");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setText("*");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 0, 0));
        jLabel16.setText("*");

        dis_cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        dis_cb.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        con_lb.setForeground(new java.awt.Color(255, 0, 0));

        mail_lb.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        mail_lb.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 958, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14)
                                .addGap(34, 34, 34)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(add_bt, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sta_box, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(can_bt)
                                    .addComponent(dis_cb, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel11)
                        .addGap(9, 9, 9)
                        .addComponent(bran_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addGap(27, 27, 27)
                        .addComponent(brc_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(48, 48, 48)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(mail_lb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mail_tf, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
                        .addGap(42, 42, 42)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(con_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(con_lb, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(326, 326, 326))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bran_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel11))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(brc_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel12)))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mail_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(con_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel14)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel16)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(con_lb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mail_lb, javax.swing.GroupLayout.DEFAULT_SIZE, 13, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(sta_box, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(dis_cb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel15)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_bt)
                    .addComponent(can_bt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        kGradientPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 943, -1));

        jButton1.setBackground(new java.awt.Color(0, 0, 153));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/home.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 70, 40));

        jPanel1.add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 460));

        tab2.addTab("Branch Entry Form", jPanel1);

        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("BRANCH SERVICE FORM");
        kGradientPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 11, -1, -1));

        ser_box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Branch Code","Branch Name","District","State" }));
        ser_box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ser_boxActionPerformed(evt);
            }
        });
        kGradientPanel2.add(ser_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 210, 40));

        ser_bt.setBackground(new java.awt.Color(0, 116, 226));
        ser_bt.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        ser_bt.setForeground(new java.awt.Color(255, 255, 255));
        ser_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search-icon-png-9964.png"))); // NOI18N
        ser_bt.setText("SEARCH");
        ser_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ser_btActionPerformed(evt);
            }
        });
        kGradientPanel2.add(ser_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, -1, 30));
        kGradientPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 45, 1045, 10));

        del_bt.setBackground(new java.awt.Color(255, 22, 0));
        del_bt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        del_bt.setForeground(new java.awt.Color(255, 255, 255));
        del_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        del_bt.setText("DELETE");
        del_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                del_btActionPerformed(evt);
            }
        });
        kGradientPanel2.add(del_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 90, 100, 30));

        upd_bt.setBackground(new java.awt.Color(255, 85, 2));
        upd_bt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        upd_bt.setForeground(new java.awt.Color(255, 255, 255));
        upd_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.png"))); // NOI18N
        upd_bt.setText("UPDATE");
        upd_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upd_btActionPerformed(evt);
            }
        });
        kGradientPanel2.add(upd_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 90, 110, 30));

        ser_cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        ser_cb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ser_cbActionPerformed(evt);
            }
        });
        kGradientPanel2.add(ser_cb, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 220, 40));
        kGradientPanel2.add(ser_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 180, -1));

        ref_bt.setBackground(new java.awt.Color(255, 0, 51));
        ref_bt.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        ref_bt.setForeground(new java.awt.Color(255, 255, 255));
        ref_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        ref_bt.setText("REFRESH");
        ref_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ref_btActionPerformed(evt);
            }
        });
        kGradientPanel2.add(ref_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, 130, 30));

        table.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bcode", "Bname", "Bcont_pers", "Email", "Address", "Cont_No", "Dist", "State", "Select"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false, true, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.getTableHeader().setReorderingAllowed(false);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table);

        javax.swing.GroupLayout tbLayout = new javax.swing.GroupLayout(tb);
        tb.setLayout(tbLayout);
        tbLayout.setHorizontalGroup(
            tbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tbLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        tbLayout.setVerticalGroup(
            tbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
        );

        kGradientPanel2.add(tb, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 940, 230));

        javax.swing.GroupLayout tab3Layout = new javax.swing.GroupLayout(tab3);
        tab3.setLayout(tab3Layout);
        tab3Layout.setHorizontalGroup(
            tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab3Layout.createSequentialGroup()
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 964, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        tab3Layout.setVerticalGroup(
            tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tab2.addTab("Branch Service Form", tab3);

        getContentPane().add(tab2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void can_btKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_can_btKeyPressed
        char ch=evt.getKeyChar();
        if(ch==10)
        refresh();
    }//GEN-LAST:event_can_btKeyPressed

    private void can_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_can_btActionPerformed
        refresh();
    }//GEN-LAST:event_can_btActionPerformed

    private void add_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btActionPerformed
        chk=true;
        Check();
            if(con_tf.getText().length()<10){
                chk=false;
                con_lb.setText("*contact no. must be 10 digits!");
            }
            if(!(mail_lb.getText().isEmpty()||mail_lb.getText()==null)){
                chk=false;
            }
        if(bran_tf.getText().equalsIgnoreCase("*Field is Mandatory")){
            fgcheck(bran_tf);
        }
//Data entry in table
        if(chk){
            byte up=(byte)JOptionPane.showConfirmDialog(this, "Are you sure to want Insert Data?");
            if(up==0)
                try {
                    stmt=con.prepareStatement("insert into branch_details values(?,?,?,?,?,?,?,?)");
                    stmt.setString(1, br_code.getText());
                    stmt.setString(2, bran_tf.getText().trim());
                    stmt.setString(3, brc_tf.getText().trim());
                    if(mail_tf.getText()==null||mail_tf.getText().equals("*Please enter a valid email Id!"))
                        stmt.setString(4, "");
                    else
                        stmt.setString(4, mail_tf.getText().trim().toLowerCase());
                    stmt.setString(5, adds_tf.getText().trim());
                    stmt.setString(6, con_tf.getText().trim());
                    stmt.setString(7, dis_cb.getSelectedItem().toString());
                    stmt.setString(8, stt);
                    stmt.executeUpdate();
                    bcode=bcode+1;
                    JOptionPane.showMessageDialog(this, "Records inserted Successfully!");
                    autogen();
                    refresh();
//                    add_bt.setEnabled(false);
                     backdata.backup("Branch_details");
    //Update State automatic in table
                    try {
                        stmt=con.prepareStatement("update state set "+st+"=?");
                        stmt.setInt(1, bcode-1);
                        stmt.executeUpdate();
                        backdata.backup("Branch Code");
                    } catch (SQLException ex) {
                        Logger.getLogger(BranchDetails.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Something went wrong!");
                } catch (WriteException ex) {
                    Logger.getLogger(BranchDetails.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }//GEN-LAST:event_add_btActionPerformed

    private void con_tfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_con_tfKeyTyped
        char ch=evt.getKeyChar();
          if(evt.getKeyChar()=='0'&& con_tf.getCaretPosition()==0) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
      }
       else if(con_tf.getText().length()>=10)
        {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        else if(!(ch>='0'&& ch<='9'|| ch==8))
        {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_con_tfKeyTyped

    private void con_tfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_con_tfFocusLost
        flcheck(con_tf);
        if(con_tf.getText().length()<10){
            chk=false;
             con_lb.setText("*contact no. must be 10 digits!");
             con_tf.setBorder(new LineBorder(Color.red));
       }
        else
            con_lb.setText("");
    }//GEN-LAST:event_con_tfFocusLost

    private void con_tfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_con_tfFocusGained
        con_tf.setBorder(new LineBorder(Color.BLACK));
        fgcheck(con_tf);
    }//GEN-LAST:event_con_tfFocusGained

    private void mail_tfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mail_tfKeyTyped
        keycheck(mail_tf,evt);
    }//GEN-LAST:event_mail_tfKeyTyped

    private void mail_tfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mail_tfFocusLost
        String last[] = {".com", ".org",".in", ".net", ".edu", ".gov", ".mil", ".biz", ".info", ".pro", ".name", ".coop", ".aero", ".museum", ".asia", ".cat", ".jobs", ".mobi", ".tel", ".travel", ".xxx", ".arpa", ".int", ".post", ".root", ".test"};
        mail_lb.setForeground(Color.red);
        String str = mail_tf.getText();
        boolean emailchk=false;   
        if (str.length()>0  )
        {
            if(str.contains(".")){
           s=str.substring(str.lastIndexOf('.'), str.length());
            for (byte i = 0; i < last.length; i++) {
                if(last[i].equalsIgnoreCase(s)){
                    emailchk=true;
                    
                }
            }
            }
            else 
              mail_lb.setText("*Please enter a valid email Id!");  
            if (emailchk)
            {
                if(str.contains("@"))
                {
                    byte index1=(byte) str.indexOf("@");
                    byte index2=(byte) str.indexOf(".");
                    if (index2==(index1+1))
                    {
                        mail_tf.setBorder(new LineBorder(Color.red));
                        Toolkit.getDefaultToolkit().beep();
                        mail_lb.setText("*Please enter a valid email Id!");
                    }
                    else
                    mail_lb.setText("");

                }
                else
                {
                    mail_tf.setBorder(new LineBorder(Color.red));
                    Toolkit.getDefaultToolkit().beep();
                    mail_lb.setText("*Please enter a valid email Id!");
                }
            }
            else{
                mail_tf.setBorder(new LineBorder(Color.red));
                Toolkit.getDefaultToolkit().beep();
                mail_lb.setText("*Please enter a valid email Id!");
            }
        }
        else
         mail_lb.setText("");
    }//GEN-LAST:event_mail_tfFocusLost

    private void mail_tfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mail_tfFocusGained
        fgcheck(mail_tf);
    }//GEN-LAST:event_mail_tfFocusGained

    private void brc_tfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_brc_tfKeyTyped
        keycheck(brc_tf,evt);
    }//GEN-LAST:event_brc_tfKeyTyped

    private void brc_tfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_brc_tfFocusLost
        if(brc_tf.getText().length()==0 || brc_tf.getText().equalsIgnoreCase("*Field is mandatory!"))
            flcheck(brc_tf);
        else
            regKr(brc_tf); 
    }//GEN-LAST:event_brc_tfFocusLost

    private void brc_tfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_brc_tfFocusGained
        fgcheck(brc_tf);
    }//GEN-LAST:event_brc_tfFocusGained

    private void bran_tfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bran_tfKeyTyped
        keycheck(bran_tf,evt);
    }//GEN-LAST:event_bran_tfKeyTyped

    private void bran_tfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bran_tfFocusLost
        if(bran_tf.getText().length()==0 || bran_tf.getText().equalsIgnoreCase("*Field is mandatory!"))
            flcheck(bran_tf);
        else
            regKr(bran_tf);   
    }//GEN-LAST:event_bran_tfFocusLost
    private void bran_tfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bran_tfFocusGained
        fgcheck(bran_tf);
    }//GEN-LAST:event_bran_tfFocusGained

    private void sta_boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sta_boxActionPerformed
        st=sta_box.getSelectedItem().toString();
        stt=st.substring(0, st.length()-3);
        st=st.substring(st.length()-2, st.length());
        stadis(stt);
        try {
            stmt=con.prepareStatement("select "+st+" from state");
            rs=stmt.executeQuery();
            if(rs.next())
            {
                  bcode=rs.getInt(1)+1;
                  autogen();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BranchDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(chk){
            try {
                   // TODO add your handling code here:
                stmt=con.prepareStatement("update state set "+st+"=?");
                stmt.setInt(1, bcode-1);
                stmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(BranchDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_sta_boxActionPerformed

    private void adds_tfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adds_tfKeyTyped
        char ch=evt.getKeyChar();
        if((evt.getKeyChar()==' '||evt.getKeyChar()==9 ||evt.getKeyChar()=='0')&& adds_tf.getCaretPosition()==0||!(evt.getKeyChar()>=65 && evt.getKeyChar()<=90||evt.getKeyChar()>=97 && evt.getKeyChar()<=122||evt.getKeyChar()>='0' && evt.getKeyChar()<='9')&&adds_tf.getCaretPosition()==0)
        {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        else if(((ch>=65 && ch<=90)|| (ch>=97 && ch<=122))||ch>='0'&&ch<='9'||ch==8) {
            dot=0;
//            ctr=0;
            if(!(evt.getKeyChar()>=65 && evt.getKeyChar()<=90||evt.getKeyChar()>=97 && evt.getKeyChar()<=122||evt.getKeyChar()>='0' && evt.getKeyChar()<='9'))
                dot=0;
//            else if(ch=='.')
//                ctr=0;
        }
//        else if(((ch=='@')&& ctr==0))
//            ctr=1;
        else if(!(evt.getKeyChar()>=65 && evt.getKeyChar()<=90||evt.getKeyChar()>=97 && evt.getKeyChar()<=122||evt.getKeyChar()>='0' && evt.getKeyChar()<='9')&&dot==0)
            dot=1;
        else {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        if(ch==10){
            add_bt.doClick();
        }
    }//GEN-LAST:event_adds_tfKeyTyped

    private void adds_tfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_adds_tfFocusLost
        String str=adds_tf.getText();
        if(adds_tf.getText().length()==0 || adds_tf.getText().equalsIgnoreCase("*Field is mandatory!")){
                  add();
        }
        else{
                regflta(adds_tf);
        } 
    }//GEN-LAST:event_adds_tfFocusLost

    private void adds_tfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_adds_tfFocusGained
        String str=adds_tf.getText();
        if(str.equals("*Field is Mandatory")||str.equals("*Invalid Input")||str.isEmpty())
        {
            adds_tf.setText("");
            adds_tf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            adds_tf.setForeground(Color.black);
        }
    }//GEN-LAST:event_adds_tfFocusGained

    private void ser_boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ser_boxActionPerformed
        String s;
        ser_cb.removeAllItems();
        int i=ser_box.getSelectedIndex();
        if(i==0)
            s="bcode";
        else if(i==1)
            s="bname";
        else if(i==2)
            s="dist";
        else
            s="state1";
        try {
            stmt=con.prepareStatement("select distinct "+s+" from branch_details");
            rs=stmt.executeQuery();
            while(rs.next())
                ser_cb.addItem(rs.getString(1));
            url="select * from branch_details where "+s+"=?";
        } catch (SQLException ex) {
            Logger.getLogger(BranchDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ser_boxActionPerformed

    private void del_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_del_btActionPerformed
        byte up=(byte)JOptionPane.showConfirmDialog(this, "Are you sure to want Delete?");
        if(up==0){    
            for(byte i=0;i<table.getRowCount();i++)
                {
                    if(model.getValueAt(i,8).toString().equals("true")){
                            try {
                                stmt=con.prepareStatement("delete from branch_details where upper(bcode)=?");
                                stmt.setString(1, model.getValueAt(i, 0).toString().toUpperCase());
                                stmt.executeUpdate();
                                model.removeRow(i);
                                 i--;
                                JOptionPane.showMessageDialog(this, "Records Deleted Successfully!");
                                backdata.backup("Branch_details");
                                backdata.backup("Branch Code");
                            } catch (SQLException ex) {
                                JOptionPane.showMessageDialog(this, "Something wrong in Delete Button!");
                            } catch (WriteException ex) {
                                Logger.getLogger(BranchDetails.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
            }
    }//GEN-LAST:event_del_btActionPerformed

    private void upd_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upd_btActionPerformed
        byte up=(byte)JOptionPane.showConfirmDialog(this, "Are you sure to want Update?");
        if(up==0){    
            for(byte i=0;i<table.getRowCount();i++)
                {
                    if(model.getValueAt(i,8).toString().equals("true")){
                                try {
                                    String url="update branch_details set bcont_pr=?,email=?,badd=?,phno=? where upper(bcode)=?";
                                    stmt=con.prepareStatement(url);
                                    stmt.setString(5, model.getValueAt(i,0).toString().toUpperCase());
                                    stmt.setString(1, model.getValueAt(i,2).toString());
                                    if(model.getValueAt(i,3)==null)
                                         stmt.setString(2,"");
                                    else
                                        stmt.setString(2,model.getValueAt(i,3).toString());
                                    stmt.setString(3, model.getValueAt(i,4).toString());
                                    stmt.setString(4, model.getValueAt(i,5).toString());
                                    stmt.executeUpdate();
                                    backdata.backup("Branch_details");
                                    backdata.backup("Branch Code");
                                    JOptionPane.showMessageDialog(this, "Records Updated Successfully!");        
                                     }catch (SQLException ex) {
                                    JOptionPane.showMessageDialog(this, "Something wrong in Update Button!");
                                Logger.getLogger(BranchDetails.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (WriteException ex) {
                            Logger.getLogger(BranchDetails.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
    }//GEN-LAST:event_upd_btActionPerformed

    private void ser_cbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ser_cbActionPerformed
    }//GEN-LAST:event_ser_cbActionPerformed

    private void ser_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ser_btActionPerformed
        tb.setVisible(true);
        if(ser_cb.getSelectedItem()==null);
        else{
            try {
                stmt=con.prepareStatement(url);
                stmt.setString(1,ser_cb.getSelectedItem().toString());
                rs=stmt.executeQuery();
                model=(DefaultTableModel) table.getModel();
                model.setRowCount(0);
                while(rs.next()){
                    del_bt.setVisible(true);
                    upd_bt.setVisible(true);
                    kk=1;
                    model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),false});
                }      
            } catch (SQLException ex) {
                Logger.getLogger(BranchDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_ser_btActionPerformed

    private void ref_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ref_btActionPerformed
        if(kk==0);
        else{
            model.setRowCount(0);
        }
        ser_cb.removeAllItems();
        try {
            stmt=con.prepareStatement("select distinct bname from branch_details");
            rs=stmt.executeQuery();
            while(rs.next())
                ser_cb.addItem(rs.getString(1));
        } catch (SQLException ex) {
            Logger.getLogger(BranchDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        ser_box.setSelectedIndex(1);
    }//GEN-LAST:event_ref_btActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        for(byte i=0;i<table.getRowCount();i++){
            if(model.getValueAt(i,8).toString().equals("true")){
                table.addRowSelectionInterval(i, i);
                table.setSelectionBackground(Color.yellow);
                table.setSelectionForeground(Color.red);
            }
            else
              table.removeRowSelectionInterval(i,i);
        }
    }//GEN-LAST:event_tableMouseClicked

    private void tab2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab2MouseClicked
        if(tab2.getSelectedIndex()==0)
           this.getRootPane().setDefaultButton(add_bt);
       else
           this.getRootPane().setDefaultButton(ser_bt);
        try {
            stmt=con.prepareStatement("select distinct bname from branch_details");
            rs=stmt.executeQuery();
            ser_cb.removeAllItems();
            ser_box.setSelectedIndex(1);
            while(rs.next())
                ser_cb.addItem(rs.getString(1));
        } catch (SQLException ex) {
            Logger.getLogger(BranchDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }//GEN-LAST:event_tab2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    public void fgcheck(JTextField c ){
        String str=c.getText();
        c.setBorder(new LineBorder(Color.BLACK));
        c.setForeground(Color.black);
        if(str.equalsIgnoreCase("*Field is Mandatory"))
        {
            c.setText("");
        }
    }
    public void flcheck(JTextField c){
        String str=c.getText();
        if(str.length()==0||str==null||str.isEmpty()||str.equalsIgnoreCase("*Field is Mandatory"))
        {
            chk=false;
            c.setText("*Field is Mandatory");
            c.setForeground(Color.red);
            c.setBorder(new LineBorder(Color.RED));
        }
    }
    public void keycheck(JTextField c,KeyEvent evt){
        char ch=evt.getKeyChar();
        if(evt.getKeyChar()==' '&& c.getCaretPosition()==0||evt.getKeyChar()=='.'&& c.getCaretPosition()==0){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        else{
            if(c.equals(mail_tf)){
                if(evt.getKeyChar()==' '||evt.getKeyChar()=='@'&&mail_tf.getCaretPosition()==0){
                    evt.consume();
                    Toolkit.getDefaultToolkit().beep();
                }
                else if(!(ch>=65&& ch<=90 || ch>=97 && ch<=122 ||ch>='0' && ch<='9'|| ch=='@'||ch=='.'||ch==8))
                {
                    evt.consume();
                    Toolkit.getDefaultToolkit().beep();
                }else if(((ch>=65 && ch<=90)|| (ch>=97 && ch<=122))||ch==8) {
                    dot=0;
                    ctr=0;
                    if(ch=='@')
                         dot=0;
                    else if(ch=='.')
                     ctr=0;
                }
                else if(((ch=='@')&& ctr==0))
                    ctr=1;
                else if(ch=='.'&&dot==0)
                    dot=1;
                else {
                    evt.consume();
                    Toolkit.getDefaultToolkit().beep();
                }
            }
            else if(!(ch>=65 && ch<=90||ch>=97 && ch<=122||ch==8||ch==' '||ch==8||ch=='.')){
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
            }
            else if(((ch>=65 && ch<=90)|| (ch>=97 && ch<=122))||ch==8) {
                dot=0;
                ctr=0;
                if(ch==' ')
                     dot=0;
                else if(ch=='.')
                 ctr=0;
            }
            else if(((ch==' ')&& ctr==0))
                ctr=1;
            else if(ch=='.'&&dot==0)
                dot=1;
            else {
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
    public void Check(){
        flcheck(bran_tf);
        flcheck(brc_tf);
        flcheck(con_tf);
        add();
    }
    public void refresh()
    {
        bran_tf.setText("");
        brc_tf.setText("");
        mail_tf.setText("");
        con_tf.setText("");
        adds_tf.setText("");
        bran_tf.requestFocus();
        bran_tf.setBorder(new LineBorder(Color.BLACK));
        bran_tf.setForeground(Color.black);
        brc_tf.setBorder(new LineBorder(Color.BLACK));
        brc_tf.setForeground(Color.black);
        mail_tf.setBorder(new LineBorder(Color.BLACK));
        mail_tf.setForeground(Color.black);
        con_tf.setBorder(new LineBorder(Color.BLACK));
        con_tf.setForeground(Color.black);
        adds_tf.setBorder(new LineBorder(Color.BLACK));
        adds_tf.setForeground(Color.black);
    }
    public void regKr(JTextField d){
         String str[]=d.getText().split(" ");
         String res="";
         for(String t:str)
             res=res+(t.substring(0,1).toUpperCase()+t.substring(1,t.length()).toLowerCase())+" ";
         d.setText(res);
    }
    public void regflta(JTextArea a){
        String bb=a.getText();
        if(bb.contains(",")){
            String str[]=bb.split(",");
            String res="";
            for(String t:str)
                res=res+(t.substring(0,1).toUpperCase()+t.substring(1,t.length()).toLowerCase())+",";
            a.setText(res);
        }
        else{
            String str[]=bb.split(" ");
            String res="";
            for(String t:str)
                res=res+(t.substring(0,1).toUpperCase()+t.substring(1,t.length()).toLowerCase())+" ";
            a.setText(res);
        }
    }
    public void stadis(String stt){
        try {
            stmt=con.prepareStatement("select distr from state1 where upper(stat)=?");
            stmt.setString(1, stt.toUpperCase());
            rs=stmt.executeQuery();
            if(rs.next()){
                dis_cb.removeAllItems();
                for(String a:rs.getString(1).split(",")){
                    dis_cb.addItem(a);
                }
            }
            if(stt=="Bihar")
                dis_cb.setSelectedItem("Patna");
        } catch (SQLException ex) {
            Logger.getLogger(BranchDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void add(){
        if(adds_tf.getText().length()==0 || adds_tf.getText().equalsIgnoreCase("*Field is mandatory")||adds_tf.getText().isEmpty()||adds_tf.getText()==null){
                chk=false;
                adds_tf.setText("*Field is Mandatory");
                adds_tf.setBorder(new LineBorder(Color.RED));
                adds_tf.setForeground(Color.red); 
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_bt;
    private javax.swing.JTextArea adds_tf;
    private javax.swing.JTextField br_code;
    private javax.swing.JTextField bran_tf;
    private javax.swing.JTextField brc_tf;
    private javax.swing.JButton can_bt;
    private javax.swing.JLabel con_lb;
    private javax.swing.JTextField con_tf;
    private com.toedter.calendar.JDateChooser cur_dt;
    private javax.swing.JButton del_bt;
    private javax.swing.JComboBox<String> dis_cb;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JLabel mail_lb;
    private javax.swing.JTextField mail_tf;
    private javax.swing.JButton ref_bt;
    private javax.swing.JComboBox<String> ser_box;
    private javax.swing.JButton ser_bt;
    private javax.swing.JComboBox<String> ser_cb;
    private javax.swing.JLabel ser_lb;
    private javax.swing.JComboBox<String> sta_box;
    private javax.swing.JTabbedPane tab2;
    private javax.swing.JPanel tab3;
    private javax.swing.JTable table;
    private javax.swing.JPanel tb;
    private javax.swing.JButton upd_bt;
    // End of variables declaration//GEN-END:variables
}
