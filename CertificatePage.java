package raysproject;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import jxl.write.Label;
import jxl.write.WriteException;


public class CertificatePage extends javax.swing.JFrame {
    Connection con;
    PreparedStatement stmt;
    int cer_no;
    String str,url,cert_ch;
    ResultSet rs;
    int year,cert_no;
    boolean flag=true;
    DefaultTableModel model;
    Label l;
    byte rol,kk=0,ctr=0,dot=0;
    SimpleDateFormat f;
    public CertificatePage(byte role) throws SQLException {
        initComponents();
        rol=role;
        if(role==0){
            cerno_tf.setEditable(true);
            doi_dt.setEnabled(true);
        }
        else if(role==1){
            rec_del.setVisible(false);
            cerno_tf.setEditable(false);
            doi_dt.setEnabled(false);
        }
        //#####################333
        Image icon=Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/icon/repl_logo_(1)-small.png"));
        this.setIconImage(icon);
        sub_cmb.setEnabled(false);
        doi_dt.setDate(new java.sql.Date(System.currentTimeMillis()));
        con=ConnDb.conLink();
        this.setTitle("Certificate Page");
        this.setLocationRelativeTo(null);
        reg_tf.requestFocus();
        f=new SimpleDateFormat("dd-MM-yyyy");
        cer_cb.setSelectedIndex(1);
        url="select * from certificate where upper(REG_NO)=?";
        ser_lb.setVisible(false);
        rec_upd.setVisible(false);
        rec_del.setVisible(false);
        this.getRootPane().setDefaultButton(sub_bt);
        stmt=con.prepareStatement("select cert_no,cert_ch from automatic");
        rs=stmt.executeQuery();
        rs.next();
        cert_no=rs.getInt(1)+1;
        cert_ch=rs.getString(2);
        //+++++++++get current year of system++++++++++++++++
        Calendar cal=Calendar.getInstance();
         year = (cal.get(Calendar.YEAR))%100;
         stmt=con.prepareStatement("select max(cref_no) from certificate");
         rs=stmt.executeQuery();
         if(rs.next()){
             String a=rs.getString(1);
             if(a!=null && year>(Integer.parseInt(a.substring(10,12))))
                cert_no=1;
         }   
          autogen(); 
    }
    public void autogen(){
        boolean flag=true;
        if(!(cert_ch.charAt(0)=='Z'&&cert_no==10000)){
            if(cert_no!=10000){
                if(cert_no<10)
                    str="REPL/CERT/"+year+"/"+cert_ch+"000"+cert_no;
                else if(cert_no<100)
                    str="REPL/CERT/"+year+"/"+cert_ch+"00"+cert_no;
                else if(cert_no<1000)
                    str="REPL/CERT/"+year+"/"+cert_ch+"0"+cert_no;
                else if(cert_no<10000)
                    str="REPL/CERT/"+year+"/"+cert_ch+cert_no;
            }
            else{
                int a=cert_ch.charAt(0);
                cert_ch=String.valueOf((char)(a+1));
                cert_no=1;
                autogen();
            }
        }
        else{
            flag=false;
            cerno_tf.setText("End certificate no.!");
            sub_bt.setVisible(false);
        }
       if(flag)
             cerno_tf.setText(str);
       else
           sub_bt.setVisible(false);
    }
    public void cer_reset()
    {   
       sub_cmb.removeAllItems();
       cerno_tf.setText("");
       sub_cmb.setEnabled(false);
       stu_tf.setText("");
       fat_tf.setText("");
       cerdur_tf.setText("");
       dob.setDate(null);
       reg_tf.setBorder(new LineBorder(Color.black));
       reg_tf.setForeground(Color.black);
       reg_tf.requestFocus();
       sub_cmb.setBorder(new LineBorder(Color.black));
       sub_cmb.setForeground(Color.black);
       cerdur_tf.setText("");
       cerdur_tf.setBorder(new LineBorder(Color.black));
       cerdur_tf.setForeground(Color.black);
       reg_tf.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tab = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        stu_tf = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        fat_tf = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cerdur_tf = new javax.swing.JTextField();
        sub_bt = new javax.swing.JButton();
        res_bt = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        reg_tf = new javax.swing.JTextField();
        sub_cmb = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        dob = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        doi_dt = new com.toedter.calendar.JDateChooser();
        cerno_tf = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        sea_bt = new javax.swing.JButton();
        cer_cb = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cer_tf = new org.jdesktop.swingx.JXSearchField();
        rec_del = new javax.swing.JButton();
        rec_upd = new javax.swing.JButton();
        ser_lb = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        rec_del1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tab.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabMouseClicked(evt);
            }
        });

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setkEndColor(new java.awt.Color(49, 183, 194));
        kGradientPanel1.setkStartColor(new java.awt.Color(123, 195, 147));
        kGradientPanel1.setkTransparentControls(false);
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Certificate Ref. No.");
        kGradientPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 142, 20));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Registration No.");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 120, 29));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Student Name");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 75, 110, 29));

        stu_tf.setEditable(false);
        stu_tf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        stu_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                stu_tfFocusGained(evt);
            }
        });
        jPanel6.add(stu_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 75, 221, 29));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Father's Name");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 122, 142, 29));

        fat_tf.setEditable(false);
        fat_tf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.add(fat_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 122, 221, 29));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Course");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 28, 60, 29));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Certificate Duration");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 75, 130, 29));

        cerdur_tf.setEditable(false);
        cerdur_tf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cerdur_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cerdur_tfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cerdur_tfFocusLost(evt);
            }
        });
        cerdur_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerdur_tfActionPerformed(evt);
            }
        });
        jPanel6.add(cerdur_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(672, 75, 220, 29));

        sub_bt.setBackground(new java.awt.Color(0, 116, 226));
        sub_bt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        sub_bt.setForeground(new java.awt.Color(255, 255, 255));
        sub_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/submit.png"))); // NOI18N
        sub_bt.setText("SUBMIT");
        sub_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sub_btActionPerformed(evt);
            }
        });
        jPanel6.add(sub_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 100, -1));

        res_bt.setBackground(new java.awt.Color(204, 0, 51));
        res_bt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        res_bt.setForeground(new java.awt.Color(255, 255, 255));
        res_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/clear_1.png"))); // NOI18N
        res_bt.setText("CLEAR");
        res_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                res_btActionPerformed(evt);
            }
        });
        jPanel6.add(res_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 199, 100, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Date Of Birth");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 122, 142, 29));

        reg_tf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        reg_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                reg_tfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                reg_tfFocusLost(evt);
            }
        });
        reg_tf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                reg_tfKeyTyped(evt);
            }
        });
        jPanel6.add(reg_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 28, 221, 29));

        sub_cmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select anyone" }));
        sub_cmb.setNextFocusableComponent(cerdur_tf);
        sub_cmb.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sub_cmbFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                sub_cmbFocusLost(evt);
            }
        });
        sub_cmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sub_cmbActionPerformed(evt);
            }
        });
        jPanel6.add(sub_cmb, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, 220, 30));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 0, 0));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel33.setText("*");
        jPanel6.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, 10, 20));

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 0, 0));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel34.setText("*");
        jPanel6.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 20, 20));

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 0, 0));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel35.setText("*");
        jPanel6.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, 20, 20));

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 0, 0));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel36.setText("*");
        jPanel6.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 20, 20));

        dob.setDateFormatString("yyyy-MM-dd");
        dob.setEnabled(false);
        jPanel6.add(dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 120, 220, 30));

        kGradientPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 910, 270));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("Date Of Issue:");
        kGradientPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, 92, 29));

        doi_dt.setDateFormatString("yyyy-MM-dd");
        doi_dt.setEnabled(false);
        kGradientPanel1.add(doi_dt, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, 220, 29));

        cerno_tf.setEditable(false);
        cerno_tf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        kGradientPanel1.add(cerno_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 220, 29));

        jPanel5.setBackground(new java.awt.Color(56, 78, 120));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CERTIFICATE");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 347, 40));

        jButton2.setBackground(new java.awt.Color(0, 51, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/home.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 70, 40));

        kGradientPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 40));

        jPanel3.add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 440));

        tab.addTab("Certificate Entry Form", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel2.setkEndColor(new java.awt.Color(0, 153, 255));
        kGradientPanel2.setkStartColor(new java.awt.Color(102, 255, 255));
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sea_bt.setBackground(new java.awt.Color(0, 116, 226));
        sea_bt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        sea_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search-icon-png-9964.png"))); // NOI18N
        sea_bt.setText("SEARCH");
        sea_bt.setToolTipText("");
        sea_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sea_btActionPerformed(evt);
            }
        });
        kGradientPanel2.add(sea_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 110, 31));

        cer_cb.setBackground(new java.awt.Color(255, 248, 246));
        cer_cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Student Name", "Registration Number", "Certificate Number" }));
        cer_cb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cer_cbActionPerformed(evt);
            }
        });
        kGradientPanel2.add(cer_cb, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 201, 31));

        jPanel7.setBackground(new java.awt.Color(56, 78, 120));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CERTIFICATE SERVICE FORM");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(281, 281, 281)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(332, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
        );

        kGradientPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, 0, 960, -1));

        cer_tf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cer_tfKeyTyped(evt);
            }
        });
        kGradientPanel2.add(cer_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 230, 31));

        rec_del.setBackground(new java.awt.Color(255, 22, 0));
        rec_del.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rec_del.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        rec_del.setText("DELETE");
        rec_del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rec_delActionPerformed(evt);
            }
        });
        kGradientPanel2.add(rec_del, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 90, 110, 30));

        rec_upd.setBackground(new java.awt.Color(255, 85, 2));
        rec_upd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rec_upd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.png"))); // NOI18N
        rec_upd.setText("UPDATE");
        rec_upd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rec_updActionPerformed(evt);
            }
        });
        kGradientPanel2.add(rec_upd, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 90, 110, 30));

        ser_lb.setBackground(new java.awt.Color(255, 255, 255));
        ser_lb.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Certificate No.", "Registration No.", "Date Of Issue", "Name", "Father's name", "D.O.b", "Course", "Course Duration", "Select"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false, false, false, true
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
        jScrollPane1.setViewportView(table);

        ser_lb.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 250));

        kGradientPanel2.add(ser_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 930, 250));

        rec_del1.setBackground(new java.awt.Color(255, 0, 51));
        rec_del1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rec_del1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        rec_del1.setText("REFRESH");
        rec_del1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rec_del1ActionPerformed(evt);
            }
        });
        kGradientPanel2.add(rec_del1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, 110, 30));

        jPanel1.add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 420));

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, -1));

        tab.addTab("Service Form", jPanel4);

        getContentPane().add(tab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dateFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_dateFocusLost

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    }//GEN-LAST:event_formWindowClosing

    private void cer_cbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cer_cbActionPerformed
        // TODO add your handling code here:
        cer_tf.requestFocus();
       url="select * from certificate where ";
       if(cer_cb.getSelectedIndex()==0){
           cer_tf.setText("");
           url=url+"upper(SNAME)=?";}
       else if(cer_cb.getSelectedIndex()==1){
           cer_tf.setText("");
           url=url+"upper(REG_NO)=?";}
       else{
           cer_tf.setText("");
           url=url+"upper(CREF_NO)=?";}
    }//GEN-LAST:event_cer_cbActionPerformed
    public void subcmbFl(){
        if(sub_cmb.getSelectedItem().toString().equalsIgnoreCase("Select anyone")||sub_cmb.getSelectedItem()==null){
            flag=false;
            sub_cmb.setBorder(new LineBorder (Color.red));}
    }
    private void sea_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sea_btActionPerformed
    if(!(cer_tf.getText().isEmpty()))
            try {
                stmt=con.prepareStatement(url);
                stmt.setString(1,cer_tf.getText().toUpperCase());
                rs=stmt.executeQuery();
                model=(DefaultTableModel)table.getModel();
                model.setRowCount(0);
                while(rs.next()){
                    if(rol==0){
                        rec_del.setVisible(true);
                    }
                    else if(rol==1){
                        rec_del.setVisible(false);
                    }
                    kk=1;
                    ser_lb.setVisible(true);
                    rec_upd.setVisible(true);
                    model.addRow(new Object[]{rs.getString(1),rs.getString(3),rs.getDate(2),rs.getString(5),rs.getString(7),rs.getDate(8),rs.getString(4),rs.getString(6),false}); 
                    }
                } catch (SQLException ex) {
                Logger.getLogger(CertificatePage.class.getName()).log(Level.SEVERE, null, ex);
                }
    }//GEN-LAST:event_sea_btActionPerformed
    private void rec_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rec_delActionPerformed
        byte b=(byte) JOptionPane.showConfirmDialog(this, "Do you really want to delete this record?");
        if(b==0){
        for (byte i = 0; i < table.getRowCount(); i++) {
            if(model.getValueAt(i, 8).equals(true)){
                try {
                    stmt=con.prepareStatement("delete from certificate where upper(cref_no)=?");
                    stmt.setString(1, model.getValueAt(i, 0).toString());
                    stmt.executeUpdate();
                    model.removeRow(i);
                    i--;
                    JOptionPane.showMessageDialog(this, "Record deleted successfully!");
                   backdata.backup("Certificate");
                } catch (SQLException ex) {
                    Logger.getLogger(CertificatePage.class.getName()).log(Level.SEVERE, null, ex);
                }   catch (WriteException ex) {
                        Logger.getLogger(CertificatePage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } 
            }
        }
    }//GEN-LAST:event_rec_delActionPerformed

    private void rec_updActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rec_updActionPerformed
        byte b=(byte) JOptionPane.showConfirmDialog(this, "Do you really want to Update this record?");
          if(b==0){
        for (byte i = 0; i < table.getRowCount(); i++) {
             
            if(model.getValueAt(i,8).equals(true)){
                
                try {
                    stmt=con.prepareStatement("update certificate set  CER_DATE=? where upper(CREF_NO)=?");
                    stmt.setString(2, model.getValueAt(i, 0).toString().toUpperCase());
                    stmt.setDate(1,(java.sql.Date)model.getValueAt(i,2));
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Record updated successfully!");
                    backdata.backup("Certificate");
                } catch (SQLException ex) {
                    Logger.getLogger(CertificatePage.class.getName()).log(Level.SEVERE, null, ex);
                } catch (WriteException ex) {
                    Logger.getLogger(CertificatePage.class.getName()).log(Level.SEVERE, null, ex);
                }
                }    
            }
        }
    }//GEN-LAST:event_rec_updActionPerformed

    private void rec_del1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rec_del1ActionPerformed
        if(kk==0);
        else if(kk==1){
            model.setRowCount(0);}
        ser_lb.setVisible(false);
    }//GEN-LAST:event_rec_del1ActionPerformed

    private void cer_tfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cer_tfKeyTyped
        char ch=evt.getKeyChar();
        if((evt.getKeyChar()==' '||evt.getKeyChar()=='/'||evt.getKeyChar()=='0'||evt.getKeyChar()=='.')&& cer_tf.getCaretPosition()==0)
            {
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
            }
        if(cer_cb.getSelectedIndex()==1)
        {
            if(cer_tf.getText().length()>=18)
            {
                 evt.consume();
                Toolkit.getDefaultToolkit().beep();
            }
            else if(!(ch>='0' && ch<='9' || ch>='A'&& ch<='Z'||ch>='a'&&ch<='z'|| ch=='/' && ctr==0||ch==8))
            {
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
        else if(cer_cb.getSelectedIndex()==2){
             if(cer_tf.getText().length()>=25)
            {
                 evt.consume();
                Toolkit.getDefaultToolkit().beep();
            }
            else if(!(ch>='0' && ch<='9' || ch>='A'&& ch<='Z'||ch>='a'&&ch<='z'|| ch=='/' && ctr==0||ch==8))
            {
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
        else {
            if(!(ch>=65&& ch<=90 || ch>=97 && ch<=122 || ch==' '||ch=='.'||ch==8))
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
    }//GEN-LAST:event_cer_tfKeyTyped

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
         for(byte i=0;i<table.getRowCount();i++){
                if(model.getValueAt(i,8).equals(true)){
                    table.addRowSelectionInterval(i,i);
                    table.setSelectionBackground(Color.yellow);
                    table.setSelectionForeground(Color.red);
                }
                else
                    table.removeRowSelectionInterval(i, i);
            } 
    }//GEN-LAST:event_tableMouseClicked

    private void sub_cmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sub_cmbActionPerformed
        cerfg(cerdur_tf);
        if(!(sub_cmb.getSelectedItem()==null||sub_cmb.getSelectedItem().toString().equalsIgnoreCase("Select anyone"))&& reg_tf.getText().length()==18){
            try {
                stmt=con.prepareStatement("select  CDUR from course where upper(CNAME)=?");
                stmt.setString(1,sub_cmb.getSelectedItem().toString().toUpperCase());
               rs=stmt.executeQuery();
               if(rs.next())
                   cerdur_tf.setText(rs.getString(1));
//                    stmt=con.prepareStatement("select ADM_NO from admission where REG_NO=? and COU_APPLY=?");
//                    stmt.setString(1,reg_tf.getText().toUpperCase());
//                    stmt.setString(2,sub_cmb.getSelectedItem().toString());
//                    rs=stmt.executeQuery();
//                    if(rs.next())
//                        cerno_tf.setText(reg_tf.getText().toUpperCase()+"/"+rs.getString(1));
//                    else
//                        JOptionPane.showMessageDialog(this,"Records  not available");
            } catch (SQLException ex) {
                Logger.getLogger(CertificatePage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_sub_cmbActionPerformed

    private void sub_cmbFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sub_cmbFocusLost
        subcmbFl();
    }//GEN-LAST:event_sub_cmbFocusLost

    private void sub_cmbFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sub_cmbFocusGained
        sub_cmb.setBorder(new LineBorder(Color.black));
    }//GEN-LAST:event_sub_cmbFocusGained

    private void reg_tfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reg_tfKeyTyped
        char ch=evt.getKeyChar();
        if(reg_tf.getText().length()>=18)
        {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        else if(!(ch>='0' && ch<='9' || ch>='A'&& ch<='Z'||ch>='a'&&ch<='z'|| ch=='/'||ch==8))
        {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_reg_tfKeyTyped

    private void reg_tfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_reg_tfFocusLost
        byte kl=0;
        if(!(reg_tf.getText().length()==0||reg_tf.getText().isEmpty()||reg_tf.getText()==null||reg_tf.getText().equalsIgnoreCase("*Field is mandatory!")))
        try {
            stmt=con.prepareStatement("select sname,fname,sdob from registration where reg_no=?");
            stmt.setString(1,reg_tf.getText().toUpperCase());
            rs=stmt.executeQuery();
            if(rs.next())
            {
                stu_tf.setText(rs.getString(1));
                fat_tf.setText(rs.getString(2));
                DateFormat df=new SimpleDateFormat("dd-MM-yy");
                java.sql.Date sql=null;
                java.util.Date date=df.parse(rs.getString(3));
                sql=new java.sql.Date(date.getTime());
                dob.setDate(sql);
                stmt=con.prepareStatement("select distinct cou_apply from admission where upper(reg_no)=?");
                stmt.setString(1,reg_tf.getText().toUpperCase());
                rs=stmt.executeQuery();
                sub_cmb.removeAllItems();
                sub_cmb.addItem("Select anyOne");
                while(rs.next()){
                    kl=1;
                    sub_cmb.setEnabled(true);
                    sub_cmb.addItem(rs.getString(1));
                }
                if(kl==0)
                    JOptionPane.showMessageDialog(this,"There is not any Application Form for this Registration Number!");
            }
            else{
                sub_cmb.setEnabled(false);
                JOptionPane.showMessageDialog(this,"No record found");}
        } catch (SQLException ex) {
            Logger.getLogger(CertificatePage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(CertificatePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        cerfl(reg_tf);
        reg_tf.setText(reg_tf.getText().toUpperCase());
    }//GEN-LAST:event_reg_tfFocusLost

    private void reg_tfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_reg_tfFocusGained
        cerfg(reg_tf);
        cerfg(stu_tf);
    }//GEN-LAST:event_reg_tfFocusGained

    private void res_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_res_btActionPerformed
        cer_reset();
    }//GEN-LAST:event_res_btActionPerformed

    private void sub_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sub_btActionPerformed
        flag=true;
        valchk();
        if(flag){
            byte b=(byte) JOptionPane.showConfirmDialog(this, "Do you really want to Insert this record?");
            if(b==0)
            try {
                stmt=con.prepareStatement("insert into certificate values(?,?,?,?,?,?,?,?)");
                stmt.setString(1,cerno_tf.getText());
                String s=((JTextField)doi_dt.getDateEditor().getUiComponent()).getText();
                DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
                Date sql=null,sq=null;
                java.util.Date date=df.parse(s);
                sql=new Date(date.getTime());
                stmt.setDate(2,sql);
                stmt.setString(3,reg_tf.getText().toUpperCase());
                stmt.setString(4,sub_cmb.getSelectedItem().toString());
                stmt.setString(5,stu_tf.getText());
                stmt.setString(6,cerdur_tf.getText());
                stmt.setString(7,fat_tf.getText());
                String sd=((JTextField)dob.getDateEditor().getUiComponent()).getText();
                java.util.Date dt=df.parse(sd);
                sq=new Date(dt.getTime());
                stmt.setDate(8,sq);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(this,"Certificate Generated Successfully!");
                cer_reset();
                backdata.backup("Certificate");
                stmt=con.prepareStatement("update automatic set cert_no=?,cert_ch=?");
                stmt.setInt(1, cert_no);
                stmt.setString(2, cert_ch);
                stmt.executeUpdate();
                backdata.backup("Automatic");
                cert_no=cert_no+1;
                autogen();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this," Something Went Wrong!");
            } catch (WriteException | ParseException ex) {
                Logger.getLogger(CertificatePage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//        else
//        JOptionPane.showMessageDialog(this, "Please Fill all the mandatory fields!");
    }//GEN-LAST:event_sub_btActionPerformed

    private void cerdur_tfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cerdur_tfFocusLost
        cerfl(cerdur_tf);
    }//GEN-LAST:event_cerdur_tfFocusLost

    private void cerdur_tfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cerdur_tfFocusGained
        cerfg(cerdur_tf);
    }//GEN-LAST:event_cerdur_tfFocusGained

    private void cerdur_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerdur_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cerdur_tfActionPerformed

    private void tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabMouseClicked
          if(tab.getSelectedIndex()==0)
            this.getRootPane().setDefaultButton(sub_bt);
       else
            this.getRootPane().setDefaultButton(sea_bt);
    }//GEN-LAST:event_tabMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void stu_tfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stu_tfFocusGained
        cerfg(stu_tf);
    }//GEN-LAST:event_stu_tfFocusGained
   
    public void cerfg(JTextField fg){
        String str=fg.getText();
        if(str.equalsIgnoreCase("*Field is mandatory!")||str.isEmpty()||str==null)
        {
            fg.setForeground(Color.black);
            fg.setText("");
            fg.setBorder(new LineBorder(Color.black));
        }
       
    }
    public void cerfl(JTextField fl){
         String str=fl.getText();
        if(str.length()==0||str.isEmpty()||str==null||str.equalsIgnoreCase("*Field is mandatory!")){
            flag=false;
            fl.setForeground(Color.red);
            fl.setText("*Field is mandatory!");
            fl.setBorder(new LineBorder(Color.red));
        }
    }
    public void valchk(){
       cerfl(reg_tf);
       subcmbFl();
       cerfl(cerdur_tf);
       cerfl(stu_tf);
       if(doi_dt.getDate()==null){
           flag=false;
           doi_dt.setBorder(new LineBorder(Color.red));
       }
       else{
           doi_dt.setBorder(new LineBorder(Color.black));
       }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cer_cb;
    private org.jdesktop.swingx.JXSearchField cer_tf;
    private javax.swing.JTextField cerdur_tf;
    private javax.swing.JTextField cerno_tf;
    private com.toedter.calendar.JDateChooser dob;
    private com.toedter.calendar.JDateChooser doi_dt;
    private javax.swing.JTextField fat_tf;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JButton rec_del;
    private javax.swing.JButton rec_del1;
    private javax.swing.JButton rec_upd;
    private javax.swing.JTextField reg_tf;
    private javax.swing.JButton res_bt;
    private javax.swing.JButton sea_bt;
    private javax.swing.JPanel ser_lb;
    private javax.swing.JTextField stu_tf;
    private javax.swing.JButton sub_bt;
    private javax.swing.JComboBox<String> sub_cmb;
    private javax.swing.JTabbedPane tab;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
