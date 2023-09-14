package raysproject;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
public class DashBordForm extends javax.swing.JFrame {
     String a,url,jk,hjk,kj,kjh;
     byte role,ctr = 0,dot=0;;
     Connection con;
     PreparedStatement stmt;
     ResultSet rs;
     DefaultTableModel model,model2,model3;
     Boolean chk=true;
     JComboBox cb1,cb,bc,bc1;
     JTableHeader thead,thead1,thead2;
     ArrayList<Object> obj=new ArrayList<Object>();
    public DashBordForm(String d,String asdf,String name) throws SQLException {
        initComponents();
        con=ConnDb.conLink();
        side_img.setVisible(false);
        side_img1.setVisible(false);
        sc.setVisible(false);
        del_bt.setVisible(false);
        up_bt.setVisible(false);
        nm.setText(nm.getText()+name.toUpperCase());
        sw_sc.setVisible(false);
        ed_sc.setVisible(false);
       role=Byte.parseByte(d);
       a=asdf;
       if(role==0){
            home.setVisible(false);
            tab_pan.setVisible(true);
            ser_pan.setVisible(false);
            String[] st={"Active","Inactive"};
            cb1=new JComboBox(st);
            String[] rl={"Admin","User"};
            cb=new JComboBox(rl);
            table.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(cb));
            table.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(cb1));
            String[] st1={"Active","Inactive"};
            bc1=new JComboBox(st1);
            String[] r2={"Super Admin","Admin","User"};
            bc=new JComboBox(r2);
            sw_table.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(bc));
            sw_table.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(bc1));
            ed_table.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(bc));
            ed_table.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(bc1));
       }
       else if(role==1){
           home.setVisible(true);
           tab_pan.setVisible(false);
           bran_bt.setVisible(false);
           rec_cmb.setVisible(false);
           side_img1.setVisible(true);
       }
       else{
           home.setVisible(true);
           tab_pan.setVisible(false);
           cor_tb.setVisible(false);
           bran_bt.setVisible(false);
           cert_bt.setVisible(false);
           rec_cmb.setVisible(false);
           side_img.setVisible(true);
           side_img1.setVisible(true);
       }
        Image icon=Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/icon/repl_logo_(1)-small.png"));
        this.setIconImage(icon);
        setTitle("DashBoard");
        this.setLocationRelativeTo(null);
        thead=table.getTableHeader();
        thead1=sw_table.getTableHeader();
        thead2=sw_table.getTableHeader();
        thead.setForeground(Color.BLUE);
        thead1.setForeground(Color.BLUE);
        thead2.setForeground(Color.BLUE);
        thead.setFont(new Font("Tahome",Font.BOLD,14));
         //############################################################
         Thread clock=new Thread(){
             @Override
             public void run(){
                 for(;;){
                    
                     try {
                          java.util.Date d=new java.util.Date();
                          lb.setText(DateFormat.getDateTimeInstance().format(d));
                          sleep(1000);
                     } catch (InterruptedException ex) {
                         Logger.getLogger(DashBordForm.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
             }
         };
         clock.start();
        
           
    }
    public  void set(String d){
        this.a=d;
        
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lb = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        nm = new javax.swing.JLabel();
        jPanel55 = new javax.swing.JPanel();
        reg_ser = new javax.swing.JButton();
        adm_ser = new javax.swing.JButton();
        fee_bt = new javax.swing.JButton();
        jPanel56 = new javax.swing.JPanel();
        cert_bt = new javax.swing.JButton();
        chng_pass = new javax.swing.JButton();
        cor_tb = new javax.swing.JButton();
        bran_bt = new javax.swing.JButton();
        book_bt = new javax.swing.JButton();
        rem_tb = new javax.swing.JButton();
        rec_cmb = new javax.swing.JComboBox<>();
        side_img = new javax.swing.JLabel();
        side_img1 = new javax.swing.JLabel();
        img = new javax.swing.JPanel();
        home = new javax.swing.JLabel();
        tab_pan = new javax.swing.JPanel();
        sc = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        del_bt = new javax.swing.JButton();
        up_bt = new javax.swing.JButton();
        sw_rec = new javax.swing.JButton();
        ser_rec = new javax.swing.JButton();
        ser_img = new javax.swing.JLabel();
        ser_pan = new javax.swing.JPanel();
        ser_cb = new javax.swing.JComboBox<>();
        ser_tf = new javax.swing.JTextField();
        ser_bt = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        sw_sc = new javax.swing.JScrollPane();
        sw_table = new javax.swing.JTable();
        ed_sc = new javax.swing.JScrollPane();
        ed_table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setkEndColor(new java.awt.Color(18, 175, 140));
        kGradientPanel1.setkGradientFocus(1000);
        kGradientPanel1.setkStartColor(new java.awt.Color(18, 231, 175));
        kGradientPanel1.setMinimumSize(new java.awt.Dimension(700, 472));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 109, 136));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DASHBOARD");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 11, 151, 48));

        lb.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb.setForeground(new java.awt.Color(255, 255, 255));
        lb.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 200, 22));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout-sign.png"))); // NOI18N
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 30, 80, 30));

        nm.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        nm.setForeground(new java.awt.Color(255, 255, 255));
        nm.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nm.setText("WELCOME,");
        jPanel1.add(nm, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 4, 310, 20));

        kGradientPanel1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 70));

        jPanel55.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        reg_ser.setBackground(new java.awt.Color(0, 153, 153));
        reg_ser.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        reg_ser.setForeground(new java.awt.Color(255, 255, 255));
        reg_ser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/registration1.png"))); // NOI18N
        reg_ser.setText("Registration ");
        reg_ser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reg_ser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reg_serActionPerformed(evt);
            }
        });
        jPanel55.add(reg_ser, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 11, 210, -1));

        adm_ser.setBackground(new java.awt.Color(0, 153, 153));
        adm_ser.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        adm_ser.setForeground(new java.awt.Color(255, 255, 255));
        adm_ser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/admission1.png"))); // NOI18N
        adm_ser.setText("Admission ");
        adm_ser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        adm_ser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adm_serActionPerformed(evt);
            }
        });
        jPanel55.add(adm_ser, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 211, 40));

        fee_bt.setBackground(new java.awt.Color(0, 153, 153));
        fee_bt.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        fee_bt.setForeground(new java.awt.Color(255, 255, 255));
        fee_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/fee_1.png"))); // NOI18N
        fee_bt.setText("Money Receipt");
        fee_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fee_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fee_btActionPerformed(evt);
            }
        });
        jPanel55.add(fee_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(618, 11, 210, 39));

        kGradientPanel1.add(jPanel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 850, 60));

        jPanel56.setBackground(new java.awt.Color(120, 179, 162));
        jPanel56.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cert_bt.setBackground(new java.awt.Color(204, 177, 238));
        cert_bt.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cert_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/certificate.png"))); // NOI18N
        cert_bt.setText("Certificate details");
        cert_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cert_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cert_btActionPerformed(evt);
            }
        });
        jPanel56.add(cert_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 220, 40));

        chng_pass.setBackground(new java.awt.Color(204, 177, 238));
        chng_pass.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        chng_pass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/changepassword1.png"))); // NOI18N
        chng_pass.setText("Change Password");
        chng_pass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chng_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chng_passActionPerformed(evt);
            }
        });
        jPanel56.add(chng_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 220, 40));

        cor_tb.setBackground(new java.awt.Color(204, 177, 238));
        cor_tb.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cor_tb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/coursetb.png"))); // NOI18N
        cor_tb.setText("Course Details");
        cor_tb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cor_tb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cor_tbActionPerformed(evt);
            }
        });
        jPanel56.add(cor_tb, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 220, 40));

        bran_bt.setBackground(new java.awt.Color(204, 177, 238));
        bran_bt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        bran_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/branch1.png"))); // NOI18N
        bran_bt.setText("BranchDetails");
        bran_bt.setBorder(null);
        bran_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bran_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bran_btActionPerformed(evt);
            }
        });
        jPanel56.add(bran_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 220, 40));

        book_bt.setBackground(new java.awt.Color(204, 177, 238));
        book_bt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        book_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/book1.png"))); // NOI18N
        book_bt.setText("BookDetails");
        book_bt.setBorder(null);
        book_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        book_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book_btActionPerformed(evt);
            }
        });
        jPanel56.add(book_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 220, 40));

        rem_tb.setBackground(new java.awt.Color(204, 177, 238));
        rem_tb.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        rem_tb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/remainder1.png"))); // NOI18N
        rem_tb.setText("Check Installment");
        rem_tb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rem_tb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rem_tbActionPerformed(evt);
            }
        });
        jPanel56.add(rem_tb, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 220, 40));

        rec_cmb.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rec_cmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select anyOne For Recovery", "Registration", "Certificate", "Course", "Book_details", "SignUp", "Branch_details", "Automatic", "Admission", "Money_receipt","Branch Code"}));
        rec_cmb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rec_cmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rec_cmbActionPerformed(evt);
            }
        });
        jPanel56.add(rec_cmb, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 220, 40));

        side_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/developer3.png"))); // NOI18N
        jPanel56.add(side_img, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 250, 150));

        side_img1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/view_report.png"))); // NOI18N
        jPanel56.add(side_img1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 140, 140));

        kGradientPanel1.add(jPanel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 290, 490));

        img.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dash1.png"))); // NOI18N
        img.add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 460, 490));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Name", "User Id", "Role", "Status", "Tick Below"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true
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
        sc.setViewportView(table);

        del_bt.setBackground(new java.awt.Color(255, 0, 0));
        del_bt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        del_bt.setForeground(new java.awt.Color(255, 255, 255));
        del_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        del_bt.setText("DELETE");
        del_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                del_btActionPerformed(evt);
            }
        });

        up_bt.setBackground(new java.awt.Color(0, 0, 255));
        up_bt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        up_bt.setForeground(new java.awt.Color(255, 255, 255));
        up_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.png"))); // NOI18N
        up_bt.setText("UPDATE");
        up_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                up_btActionPerformed(evt);
            }
        });

        sw_rec.setBackground(new java.awt.Color(153, 51, 255));
        sw_rec.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sw_rec.setForeground(new java.awt.Color(255, 255, 255));
        sw_rec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/data.png"))); // NOI18N
        sw_rec.setText("SHOW RECORDS");
        sw_rec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sw_recActionPerformed(evt);
            }
        });

        ser_rec.setBackground(new java.awt.Color(153, 51, 255));
        ser_rec.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ser_rec.setForeground(new java.awt.Color(255, 255, 255));
        ser_rec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search-icon-png-9964.png"))); // NOI18N
        ser_rec.setText("EDIT USER DETAILS");
        ser_rec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ser_recActionPerformed(evt);
            }
        });

        ser_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dash2.png"))); // NOI18N

        ser_cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User Name", "User ID" }));
        ser_cb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ser_cbActionPerformed(evt);
            }
        });

        ser_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ser_tfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ser_tfFocusLost(evt);
            }
        });
        ser_tf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ser_tfKeyTyped(evt);
            }
        });

        ser_bt.setBackground(new java.awt.Color(0, 116, 226));
        ser_bt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ser_bt.setForeground(new java.awt.Color(255, 255, 255));
        ser_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search-icon-png-9964.png"))); // NOI18N
        ser_bt.setText("SEARCH");
        ser_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ser_btActionPerformed(evt);
            }
        });

        clear.setBackground(new java.awt.Color(255, 0, 0));
        clear.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        clear.setForeground(new java.awt.Color(255, 255, 255));
        clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/clear_1.png"))); // NOI18N
        clear.setText("CLEAR");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ser_panLayout = new javax.swing.GroupLayout(ser_pan);
        ser_pan.setLayout(ser_panLayout);
        ser_panLayout.setHorizontalGroup(
            ser_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
            .addGroup(ser_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ser_panLayout.createSequentialGroup()
                    .addContainerGap(90, Short.MAX_VALUE)
                    .addComponent(ser_cb, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(96, Short.MAX_VALUE)))
            .addGroup(ser_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ser_panLayout.createSequentialGroup()
                    .addContainerGap(91, Short.MAX_VALUE)
                    .addComponent(ser_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(95, Short.MAX_VALUE)))
            .addGroup(ser_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ser_panLayout.createSequentialGroup()
                    .addContainerGap(128, Short.MAX_VALUE)
                    .addComponent(ser_bt, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(232, Short.MAX_VALUE)))
            .addGroup(ser_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ser_panLayout.createSequentialGroup()
                    .addContainerGap(243, Short.MAX_VALUE)
                    .addComponent(clear)
                    .addContainerGap(133, Short.MAX_VALUE)))
        );
        ser_panLayout.setVerticalGroup(
            ser_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 188, Short.MAX_VALUE)
            .addGroup(ser_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ser_panLayout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(ser_cb, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(119, Short.MAX_VALUE)))
            .addGroup(ser_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ser_panLayout.createSequentialGroup()
                    .addContainerGap(92, Short.MAX_VALUE)
                    .addComponent(ser_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(57, Short.MAX_VALUE)))
            .addGroup(ser_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ser_panLayout.createSequentialGroup()
                    .addContainerGap(145, Short.MAX_VALUE)
                    .addComponent(ser_bt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(ser_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ser_panLayout.createSequentialGroup()
                    .addContainerGap(143, Short.MAX_VALUE)
                    .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        sw_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Name", "User ID", "Security Question", "Security Answer", "Password", "Role", "Status"
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
        sw_table.getTableHeader().setReorderingAllowed(false);
        sw_sc.setViewportView(sw_table);

        ed_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Name", "User ID", "Security Question", "Security Answer", "Password", "Role", "Status", "Tick Below"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ed_table.getTableHeader().setReorderingAllowed(false);
        ed_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ed_tableMouseClicked(evt);
            }
        });
        ed_sc.setViewportView(ed_table);

        javax.swing.GroupLayout tab_panLayout = new javax.swing.GroupLayout(tab_pan);
        tab_pan.setLayout(tab_panLayout);
        tab_panLayout.setHorizontalGroup(
            tab_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab_panLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sc, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(tab_panLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(sw_rec, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(tab_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab_panLayout.createSequentialGroup()
                    .addContainerGap(420, Short.MAX_VALUE)
                    .addComponent(del_bt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(tab_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab_panLayout.createSequentialGroup()
                    .addContainerGap(311, Short.MAX_VALUE)
                    .addComponent(up_bt, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(118, 118, 118)))
            .addGroup(tab_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tab_panLayout.createSequentialGroup()
                    .addGap(294, 294, 294)
                    .addComponent(ser_rec, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(26, Short.MAX_VALUE)))
            .addGroup(tab_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab_panLayout.createSequentialGroup()
                    .addContainerGap(94, Short.MAX_VALUE)
                    .addComponent(ser_img, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(34, Short.MAX_VALUE)))
            .addGroup(tab_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab_panLayout.createSequentialGroup()
                    .addContainerGap(42, Short.MAX_VALUE)
                    .addComponent(ser_pan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(29, Short.MAX_VALUE)))
            .addGroup(tab_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tab_panLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(sw_sc, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(tab_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tab_panLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ed_sc, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        tab_panLayout.setVerticalGroup(
            tab_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab_panLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sw_rec, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 229, Short.MAX_VALUE)
                .addComponent(sc, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(tab_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab_panLayout.createSequentialGroup()
                    .addContainerGap(252, Short.MAX_VALUE)
                    .addComponent(del_bt)
                    .addContainerGap(215, Short.MAX_VALUE)))
            .addGroup(tab_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab_panLayout.createSequentialGroup()
                    .addContainerGap(252, Short.MAX_VALUE)
                    .addComponent(up_bt)
                    .addGap(215, 215, 215)))
            .addGroup(tab_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tab_panLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ser_rec, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(436, Short.MAX_VALUE)))
            .addGroup(tab_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab_panLayout.createSequentialGroup()
                    .addContainerGap(55, Short.MAX_VALUE)
                    .addComponent(ser_img, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(250, Short.MAX_VALUE)))
            .addGroup(tab_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab_panLayout.createSequentialGroup()
                    .addContainerGap(56, Short.MAX_VALUE)
                    .addComponent(ser_pan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(246, Short.MAX_VALUE)))
            .addGroup(tab_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab_panLayout.createSequentialGroup()
                    .addContainerGap(281, Short.MAX_VALUE)
                    .addComponent(sw_sc, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(tab_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab_panLayout.createSequentialGroup()
                    .addContainerGap(283, Short.MAX_VALUE)
                    .addComponent(ed_sc, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        img.add(tab_pan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 490));

        kGradientPanel1.add(img, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 530, 490));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rem_tbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rem_tbActionPerformed
         try {
            RemainderForm ob1=new RemainderForm (role);
            obj.add(ob1);
            ob1.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(DashBordForm.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_rem_tbActionPerformed

    private void adm_serActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adm_serActionPerformed
        try {
            AdmissionDetails ob1=new AdmissionDetails(role);
            obj.add(ob1);
            ob1.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(DashBordForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_adm_serActionPerformed

    private void cor_tbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cor_tbActionPerformed
         try {
            CourseMdiForm ob1=new CourseMdiForm(role);
            obj.add(ob1);
            ob1.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(DashBordForm.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_cor_tbActionPerformed

    private void rec_cmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rec_cmbActionPerformed
        if(!(rec_cmb.getSelectedItem().toString().equalsIgnoreCase("Select anyOne For Recovery"))){
            try {
                Recovery.recmethod(rec_cmb.getSelectedItem().toString());
            } catch (IOException | BiffException | SQLException ex) {
                Logger.getLogger(DashBordForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(DashBordForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Please Select Valid Option for Recovery!");
        }
    }//GEN-LAST:event_rec_cmbActionPerformed
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            for(Object a:obj){
                String s=a.getClass().getSimpleName();
                if(s.equalsIgnoreCase("regEntryForm"))
                    ((regEntryForm)a).dispose();
                else if(s.equalsIgnoreCase("AdmissionDetails"))
                    ((AdmissionDetails)a).dispose();
                else if(s.equalsIgnoreCase("BookEntSerForm"))
                    ((BookEntSerForm)a).dispose();
                else if(s.equalsIgnoreCase("BranchDetails"))
                    ((BranchDetails)a).dispose();
                else if(s.equalsIgnoreCase("CertificatePage"))
                    ((CertificatePage)a).dispose();
                else if(s.equalsIgnoreCase("ChangePassword"))
                    ((ChangePassword)a).dispose();
                else if(s.equalsIgnoreCase("CourseMdiForm"))
                    ((CourseMdiForm)a).dispose();
                else if(s.equalsIgnoreCase("MONEYRECEIPT"))
                    ((MONEYRECEIPT)a).dispose();
                else if(s.equalsIgnoreCase("RemainderForm"))
                    ((RemainderForm)a).dispose();
            }     
            this.dispose();
            new LoginPage().setVisible(true);
        } catch (SQLException ex) {
             Logger.getLogger(DashBordForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void bran_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bran_btActionPerformed
          try {
            BranchDetails ob1=new BranchDetails();
            obj.add(ob1);
            ob1.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(DashBordForm.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }//GEN-LAST:event_bran_btActionPerformed

    private void book_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book_btActionPerformed
          try {
            BookEntSerForm ob1=new BookEntSerForm(role);
            obj.add(ob1);
            ob1.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(DashBordForm.class.getName()).log(Level.SEVERE, null, ex);
        } 
       
    }//GEN-LAST:event_book_btActionPerformed

    private void cert_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cert_btActionPerformed
        try {
            CertificatePage ob1=new CertificatePage(role);
            obj.add(ob1);
            ob1.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(DashBordForm.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_cert_btActionPerformed

    private void chng_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chng_passActionPerformed
        try {
          ChangePassword cp=  new ChangePassword(role);
          obj.add(cp);
          cp.set(a);
          cp.setVisible(true) ; 
        } catch (SQLException ex) {
            Logger.getLogger(DashBordForm.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_chng_passActionPerformed

    private void reg_serActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reg_serActionPerformed
        try {
            regEntryForm ob1=new regEntryForm(role);
            obj.add(ob1);
            ob1.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(DashBordForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
             Logger.getLogger(DashBordForm.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_reg_serActionPerformed

    private void fee_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fee_btActionPerformed
     try {
            MONEYRECEIPT ob1=new MONEYRECEIPT(role);
            obj.add(ob1);
            ob1.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(DashBordForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_fee_btActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if(role==0)
            try {
                stmt=con.prepareStatement("select * from signup where stat='0' ORDER BY SN DESC");
                rs=stmt.executeQuery();
                model=(DefaultTableModel) table.getModel();
                model.setRowCount(0);
                while(rs.next()){
                    sc.setVisible(true);
                    del_bt.setVisible(true);
                    up_bt.setVisible(true);
                    if(rs.getString(2).equals("1")){
                        cb.setSelectedIndex(0);
                        jk="Admin";
                    }
                    else if(rs.getString(2).equals("2")){
                        cb.setSelectedIndex(1);
                        jk="User";
                    }
                    if(rs.getString(8).equals("0")){
                        cb1.setSelectedIndex(1);
                        hjk="InActive";
                    }
                    else if(rs.getString(8).equals("1")){
                        cb1.setSelectedIndex(0);
                        hjk="Active";
                    }
                    model.addRow(new Object []{rs.getString(3),rs.getString(4),jk,hjk,false});
                }
            }
            catch (SQLException ex) {
                Logger.getLogger(DashBordForm.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_formWindowOpened

    private void sw_recActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sw_recActionPerformed
        ser_img.setVisible(true);
        ser_pan.setVisible(false);
        up_bt.setVisible(false);
        del_bt.setVisible(false);
        sw_table.setEnabled(false);
        ed_sc.setVisible(false);
        try {
                stmt=con.prepareStatement("select * from signup");
                rs=stmt.executeQuery();
                model2=(DefaultTableModel) sw_table.getModel();
                model2.setRowCount(0);
                while(rs.next()){
                    sc.setVisible(false);
                    sw_sc.setVisible(true);
                    if(rs.getInt(2)==0){
                        bc.setSelectedItem("Super Admin");
                        kj="Super Admin";
                    }
                    else if(rs.getInt(2)==1){
                        bc.setSelectedItem("Admin");
                        kj="Admin";
                    }
                    else if(rs.getInt(2)==2){
                        bc.setSelectedItem("User");
                        kj="User";
                    }
                    if(rs.getString(8).equals("0")){
                        bc1.setSelectedItem("InActive");
                        kjh="InActive";
                    }
                    else if(rs.getString(8).equals("1")){
                        bc1.setSelectedItem("Active");
                        kjh="Active";
                    }
                    model2.addRow(new Object []{rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),kj,kjh});
                }
            }
            catch (SQLException ex) {
                Logger.getLogger(DashBordForm.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_sw_recActionPerformed

    private void up_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_up_btActionPerformed
        byte up=(byte)JOptionPane.showConfirmDialog(this, "Are you sure to want Update?");
        if(up==0){
                if(sc.isVisible()){
                    for(byte i=0;i<table.getRowCount();i++)
                    {
                        if(model.getValueAt(i,4).toString().equals("true")){
                                    try {
                                        String url="update signup set role=?,stat=? where u_id=?";
                                        stmt=con.prepareStatement(url);
                                        if(model.getValueAt(i,2).toString().equalsIgnoreCase("Admin")){
                                            jk="1";
                                        }
                                        else if(model.getValueAt(i,2).toString().equalsIgnoreCase("User")){
                                            jk="2";
                                        }
                                        if(model.getValueAt(i,3).toString().equalsIgnoreCase("InActive")){
                                            hjk="0";
                                        }
                                        else if(model.getValueAt(i,3).toString().equalsIgnoreCase("Active")){
                                            hjk="1";
                                        }
                                        stmt.setString(1, jk);
                                        stmt.setString(2, hjk);
                                        stmt.setString(3, model.getValueAt(i,1).toString());
                                        stmt.executeUpdate();
                                        JOptionPane.showMessageDialog(this, "Records Updated Successfully!");
                                        //BackUP
                                        backdata.backup("SignUp");
                                    } catch (SQLException ex) {
                                        JOptionPane.showMessageDialog(this, "Something wrong in Update Button!");
                                    } catch (WriteException ex) {
                                    Logger.getLogger(DashBordForm.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                }
                else if(ed_sc.isVisible()){
                    for(byte i=0;i<ed_table.getRowCount();i++)
                    {
                        if(model3.getValueAt(i,7).toString().equals("true")){
                                    try {
                                        String url="update signup set role=?,stat=? where u_id=?";
                                        stmt=con.prepareStatement(url);
                                        if(model3.getValueAt(i,5).toString().equalsIgnoreCase("Super Admin")){
                                            jk="0";
                                        }
                                        else if(model3.getValueAt(i,5).toString().equalsIgnoreCase("Admin")){
                                            jk="1";
                                        }
                                        else if(model3.getValueAt(i,5).toString().equalsIgnoreCase("User")){
                                            jk="2";
                                        }
                                        if(model3.getValueAt(i,6).toString().equalsIgnoreCase("InActive")){
                                            hjk="0";
                                        }
                                        else if(model3.getValueAt(i,6).toString().equalsIgnoreCase("Active")){
                                            hjk="1";
                                        }
                                        stmt.setString(1, jk);
                                        stmt.setString(2, hjk);
                                        stmt.setString(3, model3.getValueAt(i,1).toString());
                                        stmt.executeUpdate();
                                        JOptionPane.showMessageDialog(this, "Records Updated Successfully!");
                                        //BackUP
                                        backdata.backup("SignUp");
                                    } catch (SQLException ex) {
                                        JOptionPane.showMessageDialog(this, "Something wrong in Update Button!");
                                    } catch (WriteException ex) {
                                    Logger.getLogger(DashBordForm.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                }
            }
    }//GEN-LAST:event_up_btActionPerformed

    private void del_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_del_btActionPerformed
        byte b=(byte) JOptionPane.showConfirmDialog(this, "Do you really want to delete this record?");
        if(b==0){
            if(sc.isVisible()){
                for (byte i = 0; i < table.getRowCount(); i++) {
                    if(model.getValueAt(i, 4).equals(true)){
                        try {
                            stmt=con.prepareStatement("delete from signup where  u_id=?");
                            stmt.setString(1, model.getValueAt(i, 1).toString());
                            stmt.executeUpdate();
                            model.removeRow(i);
                            i--;
                            JOptionPane.showMessageDialog(this, "Record deleted successfully!");
                            backdata.backup("SignUp");
                        } catch (SQLException ex) {
                            Logger.getLogger(DashBordForm.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (WriteException ex) {
                            Logger.getLogger(DashBordForm.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }
        
    }//GEN-LAST:event_del_btActionPerformed

    private void ser_recActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ser_recActionPerformed
        ser_img.setVisible(false);
        ser_pan.setVisible(true);
        sw_sc.setVisible(false);
        ser_cb.setSelectedIndex(0);
        ser_tf.setText("");
        ser_tf.requestFocus();
        url="select * from signup where upper(uname)=?";
    }//GEN-LAST:event_ser_recActionPerformed

    private void ser_tfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ser_tfKeyTyped
        if(ser_cb.getSelectedItem().equals("User Name"))
        {
            char ch=evt.getKeyChar();
            if(((evt.getKeyChar()==' '||evt.getKeyChar()=='.')&& ser_tf.getCaretPosition()==0))
            {
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
            }
            else if(!(ch>='a'&& ch<='z'|| ch==8||ch==' '||ch=='.'||ch>='A'&& ch<='Z')){
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
            }

             if(((ch>=65 && ch<=90)|| (ch>=97 && ch<=122))||ch==8) {
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
            if(evt.getKeyChar()==10)
                 ser_bt.doClick();
        }
        else
        {
            char ch=evt.getKeyChar();
            if(ch==' '){
              evt.consume();
              Toolkit.getDefaultToolkit().beep();
            }
            if(evt.getKeyChar()==8 && ser_tf.getCaretPosition()==0)
            {
               evt.consume();
               Toolkit.getDefaultToolkit().beep();
            }
            if(evt.getKeyChar()==10)
                ser_bt.doClick();
        }
    }//GEN-LAST:event_ser_tfKeyTyped

    private void ser_tfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ser_tfFocusLost
        flchk(ser_tf);
    }//GEN-LAST:event_ser_tfFocusLost

    private void ser_tfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ser_tfFocusGained
        fgchk(ser_tf);
    }//GEN-LAST:event_ser_tfFocusGained

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        ser_tf.setText("");
        ser_tf.setForeground(Color.black);
        ser_tf.setBorder(new LineBorder(Color.BLACK));
        ser_cb.setSelectedIndex(0);
    }//GEN-LAST:event_clearActionPerformed

    private void ser_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ser_btActionPerformed
        chk=true;byte kl=0;
        flchk(ser_tf);
        sw_sc.setVisible(false);
        if(ser_tf.getText().equalsIgnoreCase("*Field is mandatory!")||ser_tf.getText()==null||ser_tf.getText().isEmpty())
            chk=false;
        if(chk){
                try {
                    stmt=con.prepareStatement(url);
                    if(ser_cb.getSelectedIndex()==0)
                        stmt.setString(1, ser_tf.getText().trim().toUpperCase());
                    else
                        stmt.setString(1, ser_tf.getText());
                    rs=stmt.executeQuery();
                    model3=(DefaultTableModel) ed_table.getModel();
                    model3.setRowCount(0);
                    while(rs.next()){
                        kl=1;
                        ed_sc.setVisible(true);
                        up_bt.setVisible(true);
                        if(rs.getString(2).equals("0")){
                            bc.setSelectedItem("Super Admin");
                            kj="Super Admin";
                        }
                        else if(rs.getString(2).equals("1")){
                            bc.setSelectedItem("Admin");
                            kj="Admin";
                        }
                        else if(rs.getString(2).equals("2")){
                            bc.setSelectedItem("User");
                            kj="User";
                        }
                        if(rs.getString(8).equals("0")){
                            bc1.setSelectedItem("InActive");
                            kjh="InActive";
                        }
                        else if(rs.getString(8).equals("1")){
                            bc1.setSelectedItem("Active");
                            kjh="Active";
                        }
                        model3.addRow(new Object []{rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),kj,kjh,false});
                    }
                    if(kl==0){
                        JOptionPane.showMessageDialog(this, "No Record Found!");
                        ed_sc.setVisible(false);
                        up_bt.setVisible(false);
                    }
                }
                catch (SQLException ex) {
                    Logger.getLogger(DashBordForm.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }//GEN-LAST:event_ser_btActionPerformed

    private void ser_cbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ser_cbActionPerformed
        url="select * from signup where";
        if(ser_cb.getSelectedIndex()==0)
            url=url+" upper(uname)=?";
        else
            url=url+" u_id=?";
    }//GEN-LAST:event_ser_cbActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        for(byte i=0; i<table.getRowCount();i++){  
          if(model.getValueAt(i,4).equals(true)){
            table.addRowSelectionInterval(i,i);
            table.setSelectionBackground(Color.yellow);
            table.setSelectionForeground(Color.red); 
          }
          else
              table.removeRowSelectionInterval(i,i);  
            }
    }//GEN-LAST:event_tableMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
         try {
             for(Object a:obj){
                String s=a.getClass().getSimpleName();
                if(s.equalsIgnoreCase("regEntryForm"))
                    ((regEntryForm)a).dispose();
                else if(s.equalsIgnoreCase("AdmissionDetails"))
                    ((AdmissionDetails)a).dispose();
                else if(s.equalsIgnoreCase("BookEntSerForm"))
                    ((BookEntSerForm)a).dispose();
                else if(s.equalsIgnoreCase("BranchDetails"))
                    ((BranchDetails)a).dispose();
                else if(s.equalsIgnoreCase("CertificatePage"))
                    ((CertificatePage)a).dispose();
                else if(s.equalsIgnoreCase("ChangePassword"))
                    ((ChangePassword)a).dispose();
                else if(s.equalsIgnoreCase("CourseMdiForm"))
                    ((CourseMdiForm)a).dispose();
                else if(s.equalsIgnoreCase("MONEYRECEIPT"))
                    ((MONEYRECEIPT)a).dispose();
                else if(s.equalsIgnoreCase("RemainderForm"))
                    ((RemainderForm)a).dispose();
            }
             this.dispose();
             new LoginPage().setVisible(true);
         } catch (SQLException ex) {
             Logger.getLogger(DashBordForm.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_formWindowClosing

    private void ed_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ed_tableMouseClicked
        for(byte i=0;i<ed_table.getRowCount();i++){
            if(model3.getValueAt(i,7).equals(true)){
              ed_table.addRowSelectionInterval(i,i);
              ed_table.setSelectionBackground(Color.yellow);
              ed_table.setSelectionForeground(Color.red); 
            }
            else
                ed_table.removeRowSelectionInterval(i,i);  
        }
    }//GEN-LAST:event_ed_tableMouseClicked
    public void flchk(JTextField fl){
        String str=fl.getText();
        if(str.length()==0){
           fl.setForeground(Color.red);
           fl.setText("*Field is mandatory!");
            fl.setBorder(new LineBorder(Color.RED));
            chk=false;
            Toolkit.getDefaultToolkit().beep();
        }
    }
    public void fgchk(JTextField fg){
        String str=fg.getText();
        fg.setForeground(Color.BLACK);
        fg.setBorder(new LineBorder(Color.black));
        if(str.equalsIgnoreCase("*Field is mandatory!")){
            fg.setText("");
             Toolkit.getDefaultToolkit().beep();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adm_ser;
    private javax.swing.JButton book_bt;
    private javax.swing.JButton bran_bt;
    private javax.swing.JButton cert_bt;
    private javax.swing.JButton chng_pass;
    private javax.swing.JButton clear;
    private javax.swing.JButton cor_tb;
    private javax.swing.JButton del_bt;
    private javax.swing.JScrollPane ed_sc;
    private javax.swing.JTable ed_table;
    private javax.swing.JButton fee_bt;
    private javax.swing.JLabel home;
    private javax.swing.JPanel img;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel nm;
    private javax.swing.JComboBox<String> rec_cmb;
    private javax.swing.JButton reg_ser;
    private javax.swing.JButton rem_tb;
    private javax.swing.JScrollPane sc;
    private javax.swing.JButton ser_bt;
    private javax.swing.JComboBox<String> ser_cb;
    private javax.swing.JLabel ser_img;
    private javax.swing.JPanel ser_pan;
    private javax.swing.JButton ser_rec;
    private javax.swing.JTextField ser_tf;
    private javax.swing.JLabel side_img;
    private javax.swing.JLabel side_img1;
    private javax.swing.JButton sw_rec;
    private javax.swing.JScrollPane sw_sc;
    private javax.swing.JTable sw_table;
    private javax.swing.JPanel tab_pan;
    private javax.swing.JTable table;
    private javax.swing.JButton up_bt;
    // End of variables declaration//GEN-END:variables
}
