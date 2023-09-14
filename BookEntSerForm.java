package raysproject;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
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
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import jxl.write.Label;
import jxl.write.WriteException;

public class BookEntSerForm extends javax.swing.JFrame {
    
    Connection con;
    PreparedStatement stmt;
    ResultSet rs;
    String url;
    DefaultTableModel model;
    Label l;
    JComboBox cb;
    byte ctr=0,dot=0,kk=0,rol,role=0;
    boolean chk=true;
    SimpleDateFormat f;
    public BookEntSerForm(byte role) throws SQLException {
        initComponents();
        this.setTitle("Book Entry & Service Form");
        regno_tf.requestFocus();
        rol=role;
        if(role==0){
            del_bt.setVisible(true);
        }
        else if(rol==1){
            del_bt.setVisible(false);
        }
        else if(rol==2){
            tab.remove(tab2);
        }
        String[] rl={"YES","NO"};
        cb=new JComboBox(rl);
        table.getColumnModel().getColumn(7).setCellEditor(new DefaultCellEditor(cb));
        this.getRootPane().setDefaultButton(submit_bt);
        Image icon=Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/icon/repl_logo_(1)-small.png"));
        this.setIconImage(icon);
        issue_dt.setDate(new java.sql.Date(System.currentTimeMillis()));
        subm_dt.setDate(new java.sql.Date(System.currentTimeMillis()));
        this.setLocationRelativeTo(null);
        con=ConnDb.conLink();
        f=new SimpleDateFormat("dd-MM-yyyy");
        tb.setVisible(false);
        ser_cb.setSelectedIndex(0);
        del_bt.setVisible(false);
        up_bt.setVisible(false);
        ser_dt.setVisible(false);
        url="select * from book_details where upper(SNAME)=?";
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tab = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        regno_tf = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        sname_tf = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        bname_tf = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        aname_tf = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        pname_tf = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        issue_dt = new com.toedter.calendar.JDateChooser();
        jLabel25 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        subm_dt = new com.toedter.calendar.JDateChooser();
        submit_bt = new javax.swing.JButton();
        cancel_bt = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        tab2 = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        ser_dt = new com.toedter.calendar.JDateChooser();
        ser_bt = new javax.swing.JButton();
        ref_bt = new javax.swing.JButton();
        tb = new javax.swing.JPanel();
        tab_pan = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        ser_cb = new javax.swing.JComboBox<>();
        del_bt = new javax.swing.JButton();
        ser_tf = new org.jdesktop.swingx.JXSearchField();
        up_bt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        tab.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabMouseClicked(evt);
            }
        });

        kGradientPanel2.setkEndColor(new java.awt.Color(153, 204, 255));
        kGradientPanel2.setkStartColor(new java.awt.Color(153, 153, 255));
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("BOOK DETAILS");
        kGradientPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, -1));

        jLabel20.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Registration Number");
        kGradientPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("*");
        kGradientPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, -1, -1));

        regno_tf.setNextFocusableComponent(bname_tf);
        regno_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                regno_tfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                regno_tfFocusLost(evt);
            }
        });
        regno_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regno_tfActionPerformed(evt);
            }
        });
        regno_tf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                regno_tfKeyTyped(evt);
            }
        });
        kGradientPanel2.add(regno_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 81, 215, 34));

        jLabel24.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Student Name");
        kGradientPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(541, 87, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("*");
        kGradientPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 90, -1, -1));

        sname_tf.setEditable(false);
        kGradientPanel2.add(sname_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(676, 81, 215, 34));

        jLabel21.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Book Name");
        kGradientPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 51));
        jLabel8.setText("*");
        kGradientPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, -1, -1));

        bname_tf.setNextFocusableComponent(aname_tf);
        bname_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bname_tfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bname_tfFocusLost(evt);
            }
        });
        bname_tf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bname_tfKeyTyped(evt);
            }
        });
        kGradientPanel2.add(bname_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 140, 215, 34));

        jLabel22.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Author Name");
        kGradientPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(541, 146, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setText("*");
        kGradientPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, 10, -1));

        aname_tf.setNextFocusableComponent(pname_tf);
        aname_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                aname_tfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                aname_tfFocusLost(evt);
            }
        });
        aname_tf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                aname_tfKeyTyped(evt);
            }
        });
        kGradientPanel2.add(aname_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(676, 140, 215, 34));

        jLabel23.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Publication Name");
        kGradientPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 51, 51));
        jLabel9.setText("*");
        kGradientPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, -1, -1));

        pname_tf.setNextFocusableComponent(subm_dt);
        pname_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pname_tfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                pname_tfFocusLost(evt);
            }
        });
        pname_tf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pname_tfKeyTyped(evt);
            }
        });
        kGradientPanel2.add(pname_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 199, 215, 34));

        jLabel26.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Issue Date");
        kGradientPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(541, 205, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 51, 51));
        jLabel6.setText("*");
        kGradientPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 200, -1, -1));

        issue_dt.setDateFormatString("yyyy-MM-dd");
        kGradientPanel2.add(issue_dt, new org.netbeans.lib.awtextra.AbsoluteConstraints(676, 199, 215, 34));

        jLabel25.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Submission Date");
        kGradientPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setText("*");
        kGradientPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, -1, -1));

        subm_dt.setDateFormatString("yyyy-MM-dd");
        kGradientPanel2.add(subm_dt, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 258, 215, 34));

        submit_bt.setBackground(new java.awt.Color(0, 116, 226));
        submit_bt.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        submit_bt.setForeground(new java.awt.Color(255, 255, 255));
        submit_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/submit.png"))); // NOI18N
        submit_bt.setText("SUBMIT");
        submit_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submit_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_btActionPerformed(evt);
            }
        });
        kGradientPanel2.add(submit_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 257, 120, 30));

        cancel_bt.setBackground(new java.awt.Color(204, 0, 51));
        cancel_bt.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        cancel_bt.setForeground(new java.awt.Color(255, 255, 255));
        cancel_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/resetpng.png"))); // NOI18N
        cancel_bt.setText("RESET");
        cancel_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancel_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_btActionPerformed(evt);
            }
        });
        kGradientPanel2.add(cancel_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 257, 120, 30));
        kGradientPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 940, 10));

        jButton1.setBackground(new java.awt.Color(0, 0, 153));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/home.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        kGradientPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, 70, 40));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        tab.addTab("Book Entry Form", jPanel1);

        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ser_dt.setDateFormatString("yyyy-MM-dd");
        kGradientPanel1.add(ser_dt, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 210, 40));

        ser_bt.setBackground(new java.awt.Color(51, 153, 255));
        ser_bt.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        ser_bt.setForeground(new java.awt.Color(255, 255, 255));
        ser_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search-icon-png-9964.png"))); // NOI18N
        ser_bt.setText("SEARCH");
        ser_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ser_btActionPerformed(evt);
            }
        });
        kGradientPanel1.add(ser_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 110, 30));

        ref_bt.setBackground(new java.awt.Color(255, 0, 51));
        ref_bt.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        ref_bt.setForeground(new java.awt.Color(255, 255, 255));
        ref_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        ref_bt.setText("REFRESH");
        ref_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ref_btActionPerformed(evt);
            }
        });
        kGradientPanel1.add(ref_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, -1, 30));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reg_No", "Sname", "Bname", "Aname", "Pname", "Issue_Date", "Submission_Date", "Receive", "Select"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true, true
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
        tab_pan.setViewportView(table);

        javax.swing.GroupLayout tbLayout = new javax.swing.GroupLayout(tb);
        tb.setLayout(tbLayout);
        tbLayout.setHorizontalGroup(
            tbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab_pan, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE)
        );
        tbLayout.setVerticalGroup(
            tbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab_pan, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
        );

        kGradientPanel1.add(tb, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 132, 940, -1));

        ser_cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Student Name","Submission Date" }));
        ser_cb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ser_cbActionPerformed(evt);
            }
        });
        kGradientPanel1.add(ser_cb, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 206, 40));

        del_bt.setBackground(new java.awt.Color(255, 22, 0));
        del_bt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        del_bt.setForeground(new java.awt.Color(255, 255, 255));
        del_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        del_bt.setText("DELETE");
        del_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                del_btActionPerformed(evt);
            }
        });
        kGradientPanel1.add(del_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 50, -1, 30));

        ser_tf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ser_tfKeyTyped(evt);
            }
        });
        kGradientPanel1.add(ser_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 210, 40));

        up_bt.setBackground(new java.awt.Color(255, 85, 2));
        up_bt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        up_bt.setForeground(new java.awt.Color(255, 255, 255));
        up_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.png"))); // NOI18N
        up_bt.setText("UPDATE");
        up_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                up_btActionPerformed(evt);
            }
        });
        kGradientPanel1.add(up_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 50, 110, 30));

        javax.swing.GroupLayout tab2Layout = new javax.swing.GroupLayout(tab2);
        tab2.setLayout(tab2Layout);
        tab2Layout.setHorizontalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tab2Layout.setVerticalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tab.addTab("Book Service Form", tab2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regno_tfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_regno_tfFocusGained
        regno_tf.setBorder(new LineBorder(Color.BLACK));
        sname_tf.setBorder(new LineBorder(Color.BLACK));
        fgcheck(regno_tf);
        fgcheck(sname_tf);
    }//GEN-LAST:event_regno_tfFocusGained

    private void regno_tfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_regno_tfFocusLost
        flcheck(regno_tf);
        if(!(regno_tf.getText().length()==0||regno_tf.getText().equalsIgnoreCase("*Field is Mandatory"))){
            try {
                stmt=con.prepareStatement("select sname from REGISTRATION where reg_no=?");
                stmt.setString(1, regno_tf.getText().toUpperCase());
                rs=stmt.executeQuery();
                if(rs.next())
                    sname_tf.setText(rs.getString(1));
                else{
                    sname_tf.setText("");
                    JOptionPane.showMessageDialog(this, "No Records Found!");}
            } catch (SQLException ex) {
                Logger.getLogger(BookEntSerForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        regno_tf.setText(regno_tf.getText().toUpperCase());
    }//GEN-LAST:event_regno_tfFocusLost

    private void regno_tfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_regno_tfKeyTyped
        keycheck(regno_tf,evt);
    }//GEN-LAST:event_regno_tfKeyTyped

    private void bname_tfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bname_tfFocusGained
        bname_tf.setBorder(new LineBorder(Color.BLACK));
        fgcheck(bname_tf);
    }//GEN-LAST:event_bname_tfFocusGained

    private void bname_tfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bname_tfFocusLost
        if(bname_tf.getText().length()==0)
            flcheck(bname_tf);
        else
         regKr(bname_tf);
    }//GEN-LAST:event_bname_tfFocusLost

    private void bname_tfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bname_tfKeyTyped
        keycheck(bname_tf,evt);
    }//GEN-LAST:event_bname_tfKeyTyped

    private void aname_tfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_aname_tfFocusGained
        aname_tf.setBorder(new LineBorder(Color.BLACK));
        fgcheck(aname_tf);
    }//GEN-LAST:event_aname_tfFocusGained

    private void aname_tfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_aname_tfFocusLost
        if(aname_tf.getText().length()==0)
            flcheck(aname_tf);
        else
         regKr(aname_tf);
    }//GEN-LAST:event_aname_tfFocusLost

    private void aname_tfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aname_tfKeyTyped
        keycheck(aname_tf,evt);
    }//GEN-LAST:event_aname_tfKeyTyped

    private void pname_tfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pname_tfFocusGained
        pname_tf.setBorder(new LineBorder(Color.BLACK));
        fgcheck(pname_tf);
    }//GEN-LAST:event_pname_tfFocusGained

    private void pname_tfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pname_tfFocusLost
        if(pname_tf.getText().length()==0)
            flcheck(pname_tf);
        else
         regKr(pname_tf);
    }//GEN-LAST:event_pname_tfFocusLost

    private void pname_tfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pname_tfKeyTyped
        keycheck(pname_tf,evt);
    }//GEN-LAST:event_pname_tfKeyTyped

    private void submit_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_btActionPerformed
        chk=true;
        Check();
        if(subm_dt.getDate()==null){
            chk=false;
            subm_dt.setBorder(new LineBorder(Color.RED));
        }
        else{
            subm_dt.setBorder(new LineBorder(Color.BLACK));
        }
        dtchk();
        if(chk)
        {
            byte up=(byte)JOptionPane.showConfirmDialog(this, "Are you sure to want Insert Data?");
            if(up==0)
            try {
                stmt=con.prepareStatement("insert into book_details values(?,?,?,?,?,?,?,?)");
                stmt.setString(1, regno_tf.getText().toUpperCase().trim());
                stmt.setString(2, sname_tf.getText());
                stmt.setString(3, bname_tf.getText().trim());
                stmt.setString(4, aname_tf.getText().trim());
                stmt.setString(5, pname_tf.getText().trim());
                String s=((JTextField)issue_dt.getDateEditor().getUiComponent()).getText();
                DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
                java.sql.Date sql=null,sq=null;
                java.util.Date date=df.parse(s);
                sql=new java.sql.Date(date.getTime());
                stmt.setDate(6,sql);
                String sd=((JTextField)subm_dt.getDateEditor().getUiComponent()).getText();
                java.util.Date dt=df.parse(sd);
                sq=new java.sql.Date(dt.getTime());
                stmt.setDate(7,sq);
                stmt.setInt(8, 1);
                rs=stmt.executeQuery();
                rs.next();
                JOptionPane.showMessageDialog(this, "Records Inserted Succesfully!");
                cancel();
                backdata.backup("Book_details");  
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Something Wrong in Submit Button!");
            } catch (WriteException ex) {
                Logger.getLogger(BookEntSerForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(BookEntSerForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_submit_btActionPerformed

    private void cancel_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_btActionPerformed
        cancel();
    }//GEN-LAST:event_cancel_btActionPerformed

    private void ser_cbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ser_cbActionPerformed
        String s;
        url="select * from BOOK_DETAILS where ";
        if(ser_cb.getSelectedIndex()==1){
            ser_tf.setVisible(false);
            ser_tf.setText("");
            ser_dt.setVisible(true);
            s="SUBM_DT=? and RECEICE='1'";
            url=url+s;
            ser_dt.setDate(new java.sql.Date(System.currentTimeMillis()));
        }
        else{
            ser_tf.setVisible(true);
            ser_tf.requestFocus();
            ser_dt.setVisible(false);
            ser_dt.setDate(null);
            s="upper(SNAME)=?";
            url=url+s;
        }
    }//GEN-LAST:event_ser_cbActionPerformed

    private void ser_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ser_btActionPerformed
        byte kl=0;
        if(ser_cb.getSelectedIndex()==0 && ser_tf.getText().isEmpty()||ser_cb.getSelectedIndex()==1 && ser_dt.getDate()==null){
            JOptionPane.showMessageDialog(this,"Please Fill Search Field!");
        }
        else{
            try {
                stmt=con.prepareStatement(url);
                if(ser_tf.isVisible()){
                    stmt.setString(1, ser_tf.getText().trim().toUpperCase());}
                else if(ser_dt.isVisible()){
                    String s=((JTextField)ser_dt.getDateEditor().getUiComponent()).getText();
                    DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
                    java.sql.Date sql=null,sq=null;
                    java.util.Date date=df.parse(s);
                    sql=new java.sql.Date(date.getTime());
                    stmt.setDate(1,sql);
                }
                rs=stmt.executeQuery();
                model=(DefaultTableModel) table.getModel();
                model.setRowCount(0);
                while(rs.next()){
                    if(rol==1){
                        del_bt.setVisible(false);}
                    else if(rol==0){
                        del_bt.setVisible(true);
                    }
                    kk=1;
                    kl=1;
                    tb.setVisible(true);
                    up_bt.setVisible(true);
                    String kkl;
                    if(rs.getString(8).equals("1")){
                        cb.setSelectedItem("NO");
                        kkl="NO";
                    }
                    else{
                        cb.setSelectedItem("YES");
                        kkl="YES";
                    }
                    model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDate(6),rs.getDate(7),kkl,false});
                }
                if(kl==0)
                    JOptionPane.showMessageDialog(this, "No Record Found!");
            } catch (SQLException ex) {
                Logger.getLogger(BookEntSerForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(BookEntSerForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_ser_btActionPerformed

    private void del_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_del_btActionPerformed
        byte up=(byte)JOptionPane.showConfirmDialog(this, "Are you sure to want Delete?");
        if(up==0){    
            for(byte i=0;i<table.getRowCount();i++)
                {
                    if(model.getValueAt(i,8).toString().equals("true")){
                            try {
                                stmt=con.prepareStatement("delete from book_details where reg_no=? and bname=?");
                                stmt.setString(1, model.getValueAt(i, 0).toString());
                                stmt.setString(2, model.getValueAt(i, 2).toString());
                                stmt.executeUpdate();
                                model.removeRow(i);
                                 i--;
                                JOptionPane.showMessageDialog(this, "Records Deleted Successfully!");
                                backdata.backup("Book_details");
                            } catch (SQLException ex) {
                                JOptionPane.showMessageDialog(this, "Something wrong in Delete Button!");
                            } catch (WriteException ex) {
                                Logger.getLogger(BookEntSerForm.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                }
            }
    }//GEN-LAST:event_del_btActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        for(byte i=0; i<table.getRowCount();i++){  
          if(model.getValueAt(i,8).equals(true)){
            table.addRowSelectionInterval(i,i);
            table.setSelectionBackground(Color.yellow);
            table.setSelectionForeground(Color.red); 
          }
          else
              table.removeRowSelectionInterval(i,i);  
    }
    }//GEN-LAST:event_tableMouseClicked

    private void ser_tfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ser_tfKeyTyped
        keycheck(ser_tf,evt);        
    }//GEN-LAST:event_ser_tfKeyTyped

    private void up_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_up_btActionPerformed
            for(byte i=0;i<table.getRowCount();i++)
            {
                if(model.getValueAt(i,8).toString().equals("true")){
                    byte up=(byte)JOptionPane.showConfirmDialog(this, "Are you sure to want Update?");
                    if(up==0){
                        try {
                            String kk;
                            String url="update BOOK_DETAILS set SUBM_DT=?,RECEICE=? where REG_NO=? and bname=?";
                            stmt=con.prepareStatement(url);
                            if(cb.getSelectedItem().toString().equalsIgnoreCase("NO")){
                                kk="1";
                            }
                            else{
                                kk="0";
                            }
                            stmt.setString(4, model.getValueAt(i,2).toString());
                            stmt.setString(3, model.getValueAt(i,0).toString());
                            stmt.setDate(1,(java.sql.Date) model.getValueAt(i, 6));
                            stmt.setString(2, kk);
                            stmt.executeUpdate();
                            JOptionPane.showMessageDialog(this, "Records Updated Successfully!");
                            //BackUP
                            backdata.backup("Book_details");
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(this, "Something wrong in Update Button!");
                        } catch (WriteException ex) {
                            Logger.getLogger(BookEntSerForm.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
    }//GEN-LAST:event_up_btActionPerformed

    private void ref_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ref_btActionPerformed
        if(kk==0);
        else if(kk==1){
            model.setRowCount(0);}
        ser_cb.setSelectedIndex(0);
        ser_tf.setText("");
        ser_tf.requestFocus();
//        ser
    }//GEN-LAST:event_ref_btActionPerformed

    private void tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabMouseClicked
       if(tab.getSelectedIndex()==0){
           this.getRootPane().setDefaultButton(submit_bt);
           regno_tf.requestFocus();
       }
       else{
           this.getRootPane().setDefaultButton(ser_bt);
           ser_tf.requestFocus();
       }
    }//GEN-LAST:event_tabMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void regno_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regno_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regno_tfActionPerformed

    /**
     * @param args the command line arguments
     */
    public void keycheck(JTextField c,KeyEvent evt){
        char ch=evt.getKeyChar();
        if((evt.getKeyChar()==' '||evt.getKeyChar()=='.'||evt.getKeyChar()=='0'||evt.getKeyChar()=='/')&& c.getCaretPosition()==0){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        else{
            if(c.equals(regno_tf)){
                if(regno_tf.getText().length()>=18)
                {
                     evt.consume();
                    Toolkit.getDefaultToolkit().beep();
                }
                else if(!(ch>=65&& ch<=90 || ch>=97 && ch<=122||ch>=48 && ch<=57||ch=='/' && ctr==0||ch==8)){
                    evt.consume();
                    Toolkit.getDefaultToolkit().beep();
                }
                else if(((ch>=65 && ch<=90)|| (ch>=97 && ch<=122))||ch>=48 && ch<=57||ch==8) {
                    ctr=0;
                }
                else if(((evt.getKeyChar()=='/')&& ctr==0))
                        ctr=1;
                else {
                        evt.consume();
                        Toolkit.getDefaultToolkit().beep();
                }
            }
            else{
               if(!(ch>=65&& ch<=90 || ch>=97 && ch<=122||ch==' '||ch=='.'||ch==8))
                {
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
                else if(((evt.getKeyChar()==' ')&& ctr==0))
                        ctr=1;
                else if(evt.getKeyChar()=='.'&&dot==0)
                        dot=1;
                else {
                        evt.consume();
                        Toolkit.getDefaultToolkit().beep();
                }
            }
        }
    }
    public void flcheck(JTextField c){
        String str=c.getText();
        if(str.length()==0||str.isEmpty()||str.equalsIgnoreCase("*Field is Mandatory"))
        {
            chk=false;
            c.setText("*Field is Mandatory");
            c.setForeground(Color.red);
            c.setBorder(new LineBorder(Color.RED));
        }
    }
    public void fgcheck(JTextField c){
        String str=c.getText();
        if(str.equalsIgnoreCase("*Field is Mandatory")||str.isEmpty()||str==null)
        {
            c.setText("");
            c.setBorder(new LineBorder(Color.BLACK));
            c.setForeground(Color.black);
        }
    }
    public void Check(){
        flcheck(regno_tf);
        flcheck(sname_tf);
        flcheck(bname_tf);
        flcheck(aname_tf);
        flcheck(pname_tf);
    }
    public void regKr(JTextField d){
         String str[]=d.getText().split(" ");
         String res="";
         for(String t:str)
             res=res+(t.substring(0,1).toUpperCase()+t.substring(1,t.length()).toLowerCase())+" ";
         d.setText(res);
    }
    public void dtchk(){
        SimpleDateFormat f=new SimpleDateFormat("dd-MMM-yyyy");
        Date dt=null,dt1=null;
        try {
            dt = f.parse(f.format(issue_dt.getDate()));
            dt1=f.parse(f.format(subm_dt.getDate()));
        } catch (ParseException ex) {
            Logger.getLogger(BookEntSerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(dt.compareTo(dt1)>0){
            subm_dt.setBorder(new LineBorder(Color.red));
            chk=false;
            JOptionPane.showMessageDialog(this,"Submission Date Should Always greater than Issue Date!");
        }
        else
           subm_dt.setBorder(new LineBorder(Color.black)); 
    }
    public void cancel(){
        regno_tf.setText("");
        sname_tf.setText("");
        bname_tf.setText("");
        aname_tf.setText("");
        pname_tf.setText("");
        subm_dt.setDate(new java.sql.Date(System.currentTimeMillis()));
        regno_tf.requestFocus();
        bname_tf.setBorder(new LineBorder(Color.BLACK));
        pname_tf.setBorder(new LineBorder(Color.BLACK));
        aname_tf.setBorder(new LineBorder(Color.BLACK));
        subm_dt.setBorder(new LineBorder(Color.BLACK));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aname_tf;
    private javax.swing.JTextField bname_tf;
    private javax.swing.JButton cancel_bt;
    private javax.swing.JButton del_bt;
    private com.toedter.calendar.JDateChooser issue_dt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JTextField pname_tf;
    private javax.swing.JButton ref_bt;
    private javax.swing.JTextField regno_tf;
    private javax.swing.JButton ser_bt;
    private javax.swing.JComboBox<String> ser_cb;
    private com.toedter.calendar.JDateChooser ser_dt;
    private org.jdesktop.swingx.JXSearchField ser_tf;
    private javax.swing.JTextField sname_tf;
    private com.toedter.calendar.JDateChooser subm_dt;
    private javax.swing.JButton submit_bt;
    private javax.swing.JTabbedPane tab;
    private javax.swing.JPanel tab2;
    private javax.swing.JScrollPane tab_pan;
    private javax.swing.JTable table;
    private javax.swing.JPanel tb;
    private javax.swing.JButton up_bt;
    // End of variables declaration//GEN-END:variables
}
