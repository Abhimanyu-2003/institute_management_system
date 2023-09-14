package raysproject;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import jxl.write.Label;
import jxl.write.WriteException;
public class AdmissionDetails extends javax.swing.JFrame {
    Connection con;
    ResultSet rs,rs1,rs2;
    String str,url,cdata="",adm_ch;
    PreparedStatement stmt;
    int adm_no,year;
    Label l;
    DefaultTableModel model;
    boolean chk=true,flg=true;
    byte ctr=0,rol,dot=0;
    SimpleDateFormat f;
    public AdmissionDetails(byte role) throws SQLException {
        initComponents();
        rol=role;
        if(role==0){
            formno_tf.setEditable(true);
            doa_date.setEnabled(true);
        }
        else if(rol==1){
            del_bt.setVisible(false);
            formno_tf.setEditable(false);
            doa_date.setEnabled(false);
        }
        else{
            tab.remove(tab2);
        }
            
        //######################33
        Image icon=Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/icon/repl_logo_(1)-small.png"));
        this.setIconImage(icon);
        con=ConnDb.conLink();
        setTitle("Admission Entry And Service Form");
        this.setLocationRelativeTo(null);
        f=new SimpleDateFormat("dd-MMM-yyyy");
        this.getRootPane().setDefaultButton(submit_bt);
        up_bt.setVisible(false);
        del_bt.setVisible(false);
        print.setVisible(false);
        otp.setEnabled(false);
        doa_date.setDate(new java.sql.Date(System.currentTimeMillis()));
        regno_tf.requestFocus();
        //autogenerate admission form no
        stmt=con.prepareStatement("select adm_no,ch from automatic");
        rs=stmt.executeQuery();
        rs.next();
        adm_no=rs.getInt(1)+1;
        adm_ch=rs.getString(2);
        Calendar cal=Calendar.getInstance();
        year = (cal.get(Calendar.YEAR))%100;
        stmt=con.prepareStatement("select max(ADM_NO) from ADMISSION");
        rs=stmt.executeQuery();
        if(rs.next()){
            String a=rs.getString(1);
            if(a!=null && year>(Integer.parseInt(a.substring(0, 2))))
                 adm_no=1;}
        autogen();
        url="select * from admission where reg_no=?";
        stmt=con.prepareStatement("select cname from course");
        rs=stmt.executeQuery();
        while(rs.next())
        {
            cou_box.addItem(rs.getString(1));
            cdata=cdata+rs.getString(1)+",";
        }
        ser_bx.setSelectedIndex(0);
    }
    public void autogen(){
        boolean auto=true;
        if(!(adm_ch.charAt(0)=='Z' &&adm_no==1000)){
            if(adm_no!=1000){
                if(adm_no<10)
                    str=""+year+adm_ch+"00"+adm_no;
                else if(adm_no<100)
                    str=""+year+adm_ch+"0"+adm_no;
                else if(adm_no<1000)
                    str=""+year+adm_ch+adm_no;
            }
            else{
                int a=adm_ch.charAt(0);
                adm_ch=String.valueOf((char)(a+1));
                adm_no=1;
                autogen();
            }
        }
        else{
            formno_tf.setText("End Admission No.!");
            auto=false;
            submit_bt.setVisible(false);
        }
       if(auto)
             formno_tf.setText(str);
       else
           submit_bt.setVisible(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tab = new javax.swing.JTabbedPane();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        formno1 = new javax.swing.JLabel();
        formno_tf = new javax.swing.JTextField();
        doa1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        sname1 = new javax.swing.JLabel();
        sname_tf = new javax.swing.JTextField();
        regno1 = new javax.swing.JLabel();
        regno_tf = new javax.swing.JTextField();
        submit_bt = new javax.swing.JButton();
        reset_bt = new javax.swing.JButton();
        crstudied1 = new javax.swing.JLabel();
        prev_tf = new javax.swing.JTextField();
        crapplying1 = new javax.swing.JLabel();
        cou_box = new javax.swing.JComboBox<>();
        cou_tf = new javax.swing.JTextField();
        crfee1 = new javax.swing.JLabel();
        coufee_tf = new javax.swing.JTextField();
        disc1 = new javax.swing.JLabel();
        disc_tf = new javax.swing.JTextField();
        totfee1 = new javax.swing.JLabel();
        tot_fee = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        otp = new javax.swing.JComboBox<>();
        per = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        doa_date = new com.toedter.calendar.JDateChooser();
        tab2 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        ser_bx = new javax.swing.JComboBox<>();
        search_bt = new javax.swing.JButton();
        ser_tf = new org.jdesktop.swingx.JXSearchField();
        ref_bt = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        tab_pan = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        up_bt = new javax.swing.JButton();
        del_bt = new javax.swing.JButton();
        print = new javax.swing.JButton();
        rg = new javax.swing.JButton();
        fr_dt = new com.toedter.calendar.JDateChooser();
        to_dt = new com.toedter.calendar.JDateChooser();
        to_lb = new javax.swing.JLabel();
        fr_lb = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        tab.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabMouseClicked(evt);
            }
        });

        kGradientPanel2.setkEndColor(new java.awt.Color(49, 183, 194));
        kGradientPanel2.setkGradientFocus(800);
        kGradientPanel2.setkStartColor(new java.awt.Color(123, 195, 147));

        jPanel3.setBackground(new java.awt.Color(0, 0, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ADMISSION FORM");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, -1, -1));

        jButton1.setBackground(new java.awt.Color(51, 51, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/home.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 0, 70, 40));

        formno1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        formno1.setText("Form Number");

        formno_tf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        formno_tf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        formno_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formno_tfActionPerformed(evt);
            }
        });

        doa1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        doa1.setText("Date Of Admission");

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sname1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sname1.setText("Student Name");
        jPanel4.add(sname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        sname_tf.setEditable(false);
        sname_tf.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        sname_tf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sname_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sname_tfFocusGained(evt);
            }
        });
        jPanel4.add(sname_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 260, 24));

        regno1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        regno1.setText("Registration Number");
        jPanel4.add(regno1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        regno_tf.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        regno_tf.setAutoscrolls(false);
        regno_tf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        regno_tf.setName(""); // NOI18N
        regno_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                regno_tfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                regno_tfFocusLost(evt);
            }
        });
        regno_tf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                regno_tfKeyTyped(evt);
            }
        });
        jPanel4.add(regno_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 260, 24));

        submit_bt.setBackground(new java.awt.Color(0, 116, 226));
        submit_bt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        submit_bt.setForeground(new java.awt.Color(255, 255, 255));
        submit_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/submit.png"))); // NOI18N
        submit_bt.setText("SUBMIT");
        submit_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submit_bt.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        submit_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_btActionPerformed(evt);
            }
        });
        jPanel4.add(submit_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 295, 120, 30));

        reset_bt.setBackground(new java.awt.Color(204, 0, 51));
        reset_bt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        reset_bt.setForeground(new java.awt.Color(255, 255, 255));
        reset_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/resetpng.png"))); // NOI18N
        reset_bt.setText("CLEAR");
        reset_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reset_bt.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        reset_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_btActionPerformed(evt);
            }
        });
        reset_bt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                reset_btKeyPressed(evt);
            }
        });
        jPanel4.add(reset_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 295, 120, 30));

        crstudied1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        crstudied1.setText("Previous Course");
        jPanel4.add(crstudied1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, -1, -1));

        prev_tf.setEditable(false);
        prev_tf.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        prev_tf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        prev_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prev_tfActionPerformed(evt);
            }
        });
        jPanel4.add(prev_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, 227, 24));

        crapplying1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        crapplying1.setText("Course Applying");
        jPanel4.add(crapplying1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        cou_box.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cou_box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Any Course" }));
        cou_box.setAutoscrolls(true);
        cou_box.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cou_box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cou_boxActionPerformed(evt);
            }
        });
        jPanel4.add(cou_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 260, 30));

        cou_tf.setEditable(false);
        cou_tf.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cou_tf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(cou_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 260, 24));

        crfee1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        crfee1.setText("Course Fee");
        jPanel4.add(crfee1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, -1, -1));

        coufee_tf.setEditable(false);
        coufee_tf.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        coufee_tf.setText("0");
        coufee_tf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(coufee_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 170, 227, 24));

        disc1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        disc1.setText("Discount ");
        jPanel4.add(disc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        disc_tf.setEditable(false);
        disc_tf.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        disc_tf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        disc_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                disc_tfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                disc_tfFocusLost(evt);
            }
        });
        disc_tf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                disc_tfKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                disc_tfKeyTyped(evt);
            }
        });
        jPanel4.add(disc_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 70, 24));

        totfee1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        totfee1.setText("Total Fee");
        jPanel4.add(totfee1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 240, -1, -1));

        tot_fee.setEditable(false);
        tot_fee.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tot_fee.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(tot_fee, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 240, 227, 24));
        jPanel4.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 862, 10));

        otp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Installment","OTP" }));
        otp.setSelectedIndex(0);
        otp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        otp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                otpFocusLost(evt);
            }
        });
        otp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otpActionPerformed(evt);
            }
        });
        jPanel4.add(otp, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, 100, 24));

        per.setEditable(false);
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
        jPanel4.add(per, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 40, 24));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/rs.png"))); // NOI18N
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, -1, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("%");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 20, 20));

        doa_date.setAutoscrolls(true);
        doa_date.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(formno1)
                .addGap(18, 18, 18)
                .addComponent(formno_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(doa1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(doa_date, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 907, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(doa_date, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(formno1)
                        .addComponent(formno_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(doa1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        tab.addTab("Admission Entry Form", kGradientPanel2);

        tab2.setBackground(new java.awt.Color(38, 110, 115));
        tab2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tab2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ser_bx.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ser_bx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Registration Number", "Student Name","Admission Number" }));
        ser_bx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ser_bxActionPerformed(evt);
            }
        });
        jPanel9.add(ser_bx, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 190, 30));

        search_bt.setBackground(new java.awt.Color(0, 116, 226));
        search_bt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        search_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search-icon-png-9964.png"))); // NOI18N
        search_bt.setText("SEARCH");
        search_bt.setBorder(null);
        search_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        search_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_btActionPerformed(evt);
            }
        });
        jPanel9.add(search_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 110, 30));

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
        jPanel9.add(ser_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 180, 30));

        ref_bt.setBackground(new java.awt.Color(255, 0, 51));
        ref_bt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ref_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        ref_bt.setText("REFRESH");
        ref_bt.setBorder(null);
        ref_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ref_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ref_btActionPerformed(evt);
            }
        });
        jPanel9.add(ref_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, 110, 30));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel9.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(896, 159, -1, -1));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Adm_No", "Adm_Date", "Reg_No", "Cou_Apply", "Fee", "Discount", "Tick Below"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, true, true
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

        jPanel9.add(tab_pan, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 159, 888, 260));

        up_bt.setBackground(new java.awt.Color(255, 85, 2));
        up_bt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        up_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.png"))); // NOI18N
        up_bt.setText("UPDATE");
        up_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        up_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                up_btActionPerformed(evt);
            }
        });
        jPanel9.add(up_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 40, 100, 31));

        del_bt.setBackground(new java.awt.Color(255, 22, 0));
        del_bt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        del_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        del_bt.setText("DELETE");
        del_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                del_btActionPerformed(evt);
            }
        });
        jPanel9.add(del_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 90, 90, 31));

        print.setBackground(new java.awt.Color(0, 204, 204));
        print.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/print.png"))); // NOI18N
        print.setText("PRINT");
        print.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        jPanel9.add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 40, 90, 31));

        rg.setBackground(new java.awt.Color(153, 255, 153));
        rg.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/range.png"))); // NOI18N
        rg.setText("Range Search");
        rg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rgActionPerformed(evt);
            }
        });
        jPanel9.add(rg, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 140, 30));

        fr_dt.setDateFormatString("yyyy-MM-dd");
        jPanel9.add(fr_dt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 190, 30));

        to_dt.setDateFormatString("yyyy-MM-dd");
        jPanel9.add(to_dt, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 180, 30));

        to_lb.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        to_lb.setText("To Date");
        jPanel9.add(to_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

        fr_lb.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fr_lb.setText("From Date");
        jPanel9.add(fr_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        tab2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 53, 891, 424));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("ADMISSION SERVICE FORM");
        jLabel7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 51, 51)));
        tab2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 12, -1, -1));

        tab.addTab("Admission Service Form", tab2);

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

    private void formno_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formno_tfActionPerformed
    }//GEN-LAST:event_formno_tfActionPerformed

    private void regno_tfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_regno_tfFocusGained
        fgcheck(regno_tf);
        fgcheck(sname_tf);
    }//GEN-LAST:event_regno_tfFocusGained

    private void regno_tfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_regno_tfFocusLost
        flcheck(regno_tf);
        regno_tf.setText(regno_tf.getText().toUpperCase());
        if(!(regno_tf.getText()==null||regno_tf.getText().isEmpty()||regno_tf.getText().length()==0||regno_tf.getText().equalsIgnoreCase("Field is mandatory"))){
            if(regno_tf.getText().length()==18){
                try {
                stmt=con.prepareStatement("select sname from registration where upper(reg_no)=?");
                stmt.setString(1, regno_tf.getText().toUpperCase());
                rs=stmt.executeQuery();
                if(rs.next())
                    sname_tf.setText(rs.getString(1));
                else{
                    JOptionPane.showMessageDialog(this,"Registration Number Doesn`t Exist!");
                    sname_tf.setText("");
                }
                stmt=con.prepareStatement("select distinct cou_apply from admission where upper(reg_no)=?");
                stmt.setString(1, regno_tf.getText().toUpperCase());
                rs=stmt.executeQuery();
                String str="";
                while(rs.next())
                    str=str+rs.getString(1)+",";
                ArrayList <String> x=new ArrayList<>();
                for(String a:str.split(","))
                {
                    if(!x.contains(a))
                         x.add(a);
                }    
                prev_tf.setText(x.toString().substring(1,x.toString().length()-1));
                if(prev_tf.getText().length()==0)
                    prev_tf.setText("None");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this,"Something Went wrong!!");
            }
            }
        }
    }//GEN-LAST:event_regno_tfFocusLost

    private void regno_tfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_regno_tfKeyTyped
        char ch=evt.getKeyChar();
        if(evt.getKeyChar()==0&& regno_tf.getCaretPosition()==0||evt.getKeyChar()=='/' && regno_tf.getCaretPosition()==0)
        {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        else if(!(ch>=65 && ch<=90||ch>=97 && ch<=122||ch>=48 && ch<=57||ch=='/'))
        {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_regno_tfKeyTyped

    private void submit_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_btActionPerformed
        chk=true;
        check();
        String hjk;
        if(chk){
            byte b=(byte) JOptionPane.showConfirmDialog(this, "Do you really want to Insert this record?");
            if(b==0)
            try {
//                SimpleDateFormat f=new SimpleDateFormat("dd-MM-yyyy");
                stmt=con.prepareStatement("insert into admission values(?,?,?,?,?,?)");
                stmt.setString(1, formno_tf.getText());
                String s=((JTextField)doa_date.getDateEditor().getUiComponent()).getText();
                DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
                java.sql.Date sql=null;
                java.util.Date date=df.parse(s);
                sql=new java.sql.Date(date.getTime());
                stmt.setDate(2,sql);
                stmt.setString(3, regno_tf.getText().toUpperCase());
                String str=cou_tf.getText();
                str=str.substring(0, str.length()-1);
                stmt.setString(4, str.toUpperCase());
                stmt.setString(5, coufee_tf.getText());
                if(disc_tf.getText().isEmpty()||disc_tf.getText()==null){
                    hjk="0";
                    stmt.setString(6, hjk);
                }
                else{
                    hjk=disc_tf.getText();
                    stmt.setString(6,hjk);
                }
                stmt.executeUpdate();
                adm_no=adm_no+1;
                JOptionPane.showMessageDialog(this, "Records inserted successfully!");
                 backdata.backup("Admission");
                    stmt=con.prepareStatement("update automatic set  adm_no=?,ch=?");
                    stmt.setInt(1, adm_no-1);
                    stmt.setString(2, adm_ch);
                    stmt.executeUpdate();
                 backdata.backup("Automatic");
                byte bkl=(byte) JOptionPane.showConfirmDialog(this, "Do you really want to Print this record?");
                if(bkl==0){
                    String kk=regno_tf.getText().toUpperCase();
                    String data[]={formno_tf.getText(),sql.toString(),kk,prev_tf.getText(),sname_tf.getText(),str,coufee_tf.getText(),hjk,tot_fee.getText()};
                   reset();
                    new AdmissionInvoice(data).setVisible(true);}
                else{
                    reset();
                }
                 autogen();
            } catch (SQLException ex) {
                Logger.getLogger(AdmissionDetails.class.getName()).log(Level.SEVERE, null, ex);
            } catch (WriteException ex) {
                Logger.getLogger(AdmissionDetails.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(AdmissionDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_submit_btActionPerformed

    private void reset_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_btActionPerformed
        reset();
    }//GEN-LAST:event_reset_btActionPerformed

    private void reset_btKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reset_btKeyPressed
        char ch=evt.getKeyChar();
        if(ch==10)
        reset();
    }//GEN-LAST:event_reset_btKeyPressed

    private void cou_boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cou_boxActionPerformed
        if(cou_box.getSelectedIndex()==-1)
            cou_box.addItem("Select Any Course");
        String st=cou_tf.getText();
        int a=Integer.parseInt(coufee_tf.getText());

        if(!(cou_box.getSelectedIndex()==0))
        {
            try {
                stmt=con.prepareStatement("select cfee from course where upper(cname)=?");
                stmt.setString(1, cou_box.getSelectedItem().toString().toUpperCase());
                rs=stmt.executeQuery();
                if(rs.next()){
                    coufee_tf.setText(String.valueOf(a+rs.getInt(1)));
                    per.setEditable(true);
                    disc_tf.setEditable(true);
                    otp.setEnabled(true);
                }
                else
                    JOptionPane.showMessageDialog(this,"Error in Course Box Selection!");
                tot_fee.setText(coufee_tf.getText());
            } catch (SQLException ex) {
            Logger.getLogger(AdmissionDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
            cou_tf.setText(st+cou_box.getSelectedItem()+",");
            cou_box.removeItemAt(cou_box.getSelectedIndex());
        }
    }//GEN-LAST:event_cou_boxActionPerformed

    private void disc_tfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_disc_tfFocusGained
        fgcheck(disc_tf);
    }//GEN-LAST:event_disc_tfFocusGained

    private void disc_tfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_disc_tfFocusLost

    }//GEN-LAST:event_disc_tfFocusLost

    private void disc_tfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_disc_tfKeyTyped
        char ch=evt.getKeyChar();
        if(evt.getKeyChar()=='0' && disc_tf.getCaretPosition()==0)
        {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        else if(!(ch>=48 && ch<=57||ch==8))
        {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();

        }
    }//GEN-LAST:event_disc_tfKeyTyped

    private void search_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_btActionPerformed
        byte kl=0;
        if(fr_dt.isVisible()){
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
                    stmt=con.prepareStatement("select * from Admission where adm_date>=? and adm_date<=?");
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
                    rs=stmt.executeQuery();
                    model=(DefaultTableModel) table.getModel();
                    model.setRowCount(0);
                    while(rs.next()){
                        kl=1;
                        if(rol==0){
                            del_bt.setVisible(true);
                        }
                        else if(rol==1){
                            del_bt.setVisible(false);
                        }
                        table.setVisible(true);
                        up_bt.setVisible(true);
                        print.setVisible(true);
                        model.addRow(new Object []{rs.getString(1),rs.getDate(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),false});
                    }
                    if(kl==0)
                        JOptionPane.showMessageDialog(this,"No Record Found!");
                } catch (SQLException ex) {
                    Logger.getLogger(AdmissionDetails.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(AdmissionDetails.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else{
            if(ser_tf.getText().length()==0)
                JOptionPane.showMessageDialog(this, "Search Field is Empty!");
            else{
                try {
                    stmt=con.prepareStatement(url);
                    stmt.setString(1, ser_tf.getText().toUpperCase());
                    rs=stmt.executeQuery();
                    model=(DefaultTableModel) table.getModel();
                    model.setRowCount(0);
                    while(rs.next()){
                        kl=1;
                        if(rol==0){
                            del_bt.setVisible(true);
                        }
                        else if(rol==1){
                            del_bt.setVisible(false);
                        }
                        table.setVisible(true);
                        up_bt.setVisible(true);
                        print.setVisible(true);
                        model.addRow(new Object []{rs.getString(1),rs.getDate(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),false});
                    }
                    if(kl==0)
                        JOptionPane.showMessageDialog(this,"No Record Found!");
                }
                catch (SQLException ex) {
                    Logger.getLogger(AdmissionDetails.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_search_btActionPerformed

    private void ref_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ref_btActionPerformed
       table.setVisible(false);
       fr_lb.setVisible(false);
        to_lb.setVisible(false);
        fr_dt.setVisible(false);
        to_dt.setVisible(false);
        ser_bx.setVisible(true);
        ser_tf.setVisible(true);
        ser_tf.requestFocus();
    }//GEN-LAST:event_ref_btActionPerformed

    private void ser_tfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ser_tfKeyTyped
        if(ser_bx.getSelectedItem().equals("Registration Number"))
        {
            char ch=evt.getKeyChar();
            if(ser_tf.getText().length()>=18)
            {
                 evt.consume();
                Toolkit.getDefaultToolkit().beep();
            }
            else if((evt.getKeyChar()=='0'||evt.getKeyChar()=='/')&& ser_tf.getCaretPosition()==0)
            {
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
            }
            else if(!(ch>=65 && ch<=90||ch>=97 && ch<=122||ch>=48 && ch<=57||ch=='/' && ctr==0||ch==8))
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
        else if(ser_bx.getSelectedItem().equals("Admission Number")){
            char ch=evt.getKeyChar();
            if(ser_tf.getText().length()>=6)
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
        else
        {
            char ch=evt.getKeyChar();
            if(evt.getKeyChar()==' ' && ser_tf.getCaretPosition()==0)
            {
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
            }
            else if(!(ch>=65 && ch<=90||ch>=97 && ch<=122||ch==' '||ch=='.'||ch==8))
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
    }//GEN-LAST:event_ser_tfKeyTyped

    private void ser_bxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ser_bxActionPerformed
       if(ser_bx.getSelectedIndex()==1){
           ser_tf.setText("");
           ser_tf.requestFocus();
           url="select * from admission where reg_no in(select reg_no from registration where upper(sname)=?)";
       }
       else if(ser_bx.getSelectedIndex()==2){
           ser_tf.setText("");
           ser_tf.requestFocus();
           url="select * from admission where upper(adm_no)=?";
       }
       else{
           ser_tf.setText("");
           ser_tf.requestFocus();
           url="select * from admission where upper(reg_no)=?";
       }
    }//GEN-LAST:event_ser_bxActionPerformed

    private void del_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_del_btActionPerformed
        byte b=(byte) JOptionPane.showConfirmDialog(this, "Do you really want to delete this record?");
        if(b==0){
            for (byte i = 0; i < table.getRowCount(); i++) {
                if(model.getValueAt(i, 6).equals(true)){
                    try {
                        stmt=con.prepareStatement("delete from admission where  adm_no=?");
                        stmt.setString(1, model.getValueAt(i, 0).toString());
                        stmt.executeUpdate();
                        model.removeRow(i);
                        i--;
                        JOptionPane.showMessageDialog(this, "Record deleted successfully!");
                        backdata.backup("Admission");
                    } catch (SQLException ex) {
                        Logger.getLogger(AdmissionDetails.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (WriteException ex) {
                        Logger.getLogger(AdmissionDetails.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_del_btActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        for(byte i=0; i<table.getRowCount();i++){  
          if(model.getValueAt(i,6).equals(true)){
            table.addRowSelectionInterval(i,i);
            table.setSelectionBackground(Color.yellow);
            table.setSelectionForeground(Color.red); 
          }
          else
              table.removeRowSelectionInterval(i,i);  
    }
    }//GEN-LAST:event_tableMouseClicked

    private void disc_tfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_disc_tfKeyReleased
        percentage();
    }//GEN-LAST:event_disc_tfKeyReleased

    private void up_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_up_btActionPerformed
        byte up=(byte)JOptionPane.showConfirmDialog(this, "Are you sure to want Update?");
        if(up==0){
        for(byte i=0;i<table.getRowCount();i++)
            {
                if(model.getValueAt(i,6).toString().equals("true")){
                            try {
                                String url="update admission set adm_date=?,dis=? where adm_no=?";
                                stmt=con.prepareStatement(url);
                                stmt.setDate(1,(java.sql.Date)model.getValueAt(i,1));
                                stmt.setString(2, model.getValueAt(i,5).toString());
                                stmt.setString(3, model.getValueAt(i,0).toString());
                                stmt.executeUpdate();
                                JOptionPane.showMessageDialog(this, "Records Updated Successfully!");
                                //BackUP
                                backdata.backup("Admission");
                            } catch (SQLException ex) {
                                JOptionPane.showMessageDialog(this, "Something wrong in Update Button!");
                            } catch (WriteException ex) {
                            Logger.getLogger(BranchDetails.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
    }//GEN-LAST:event_up_btActionPerformed

    private void otpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otpActionPerformed
        if(otp.getSelectedIndex()==1){
            if(cou_tf.getText().trim().length()!=0)
            disc_tf.setEditable(false);
            per.setEditable(false);
            try {
                stmt=con.prepareStatement("select otp from course where upper(cname)=?");
                String stt=cou_tf.getText();
                stt=stt.substring(0, stt.length()-1);
                stmt.setString(1,stt.toUpperCase());
                rs=stmt.executeQuery();
                if(rs.next()){
                    disc_tf.setText(rs.getString(1));
                    tot_fee.setText(""+(Integer.parseInt(coufee_tf.getText())-Integer.parseInt(disc_tf.getText())));
                    percentage();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AdmissionDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else{
            disc_tf.setEditable(true);
            per.setEditable(true);
            disc_tf.setText("");
            per.setText("");
            tot_fee.setText(coufee_tf.getText());
        }
    }//GEN-LAST:event_otpActionPerformed

    private void otpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_otpFocusLost
     
    }//GEN-LAST:event_otpFocusLost

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        int kk=0;
        for(byte i=0; i<table.getRowCount();i++){
             if(model.getValueAt(i,6).equals(true))
                 kk=kk+1;
                 }
        if(kk==1){
        try {          
            for(byte i=0; i<table.getRowCount();i++)
             if(model.getValueAt(i,6).equals(true)){
                    stmt=con.prepareStatement("select * from admission where adm_no=?");
                    stmt.setString(1,model.getValueAt(i,0).toString());
                    rs=stmt.executeQuery();
                    rs.next();

                 stmt=con.prepareStatement("select sname from registration where reg_no=?");
                        stmt.setString(1,rs.getString(3));
                        rs1=stmt.executeQuery();
                        rs1.next();
                     stmt=con.prepareStatement("select distinct cou_apply from admission where reg_no=?");
                            stmt.setString(1,rs.getString(3));
                            rs2=stmt.executeQuery();
                            rs2.next();
                    kk=Integer.parseInt(rs.getString(5))-Integer.parseInt(rs.getString(6));
                    String d[]={rs.getString(1),String.valueOf(rs.getDate(2)),rs.getString(3),rs2.getString(1),rs1.getString(1),rs.getString(4),rs.getString(5),rs.getString(6),String.valueOf(kk)};
                    new AdmissionInvoice(d).setVisible(true);
            }
            } catch (SQLException ex) {
                Logger.getLogger(AdmissionDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
                JOptionPane.showMessageDialog(this, "Please Select Only One row!");
    }//GEN-LAST:event_printActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabMouseClicked
        if(tab.getSelectedIndex()==0){
           this.getRootPane().setDefaultButton(submit_bt);
           regno_tf.requestFocus();
           fr_lb.setVisible(false);
            to_lb.setVisible(false);
            fr_dt.setVisible(false);
            to_dt.setVisible(false);
            ser_bx.setVisible(true);
            ser_tf.setVisible(true);
        }
        else{
           this.getRootPane().setDefaultButton(search_bt);
           ser_tf.requestFocus();
           fr_lb.setVisible(false);
            to_lb.setVisible(false);
            fr_dt.setVisible(false);
            to_dt.setVisible(false);
            ser_bx.setVisible(true);
            ser_tf.setVisible(true);
        }
    }//GEN-LAST:event_tabMouseClicked

    private void perKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_perKeyReleased
//        int t=0,b=0;
        if(!coufee_tf.getText().equals("*Field is mandatory!")&&!coufee_tf.getText().equals("0")&&coufee_tf.getText().length()!=0){
        String d=per.getText();
            if (!d.equals("")){
               double t=Double.parseDouble(coufee_tf.getText());
                double e=Double.parseDouble(per.getText());
                double b=(e*t/100);
                int kk=(int)t-(int)b;
                tot_fee.setText(String.valueOf(kk));
                disc_tf.setText(""+String.format("%d",(int)b));
            }
            else if (per.getText().length()==0)
                disc_tf.setText("");
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

    private void ser_tfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ser_tfFocusLost
        if(ser_bx.getSelectedIndex()==0)
            ser_tf.setText(ser_tf.getText().toUpperCase());
    }//GEN-LAST:event_ser_tfFocusLost

    private void prev_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prev_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prev_tfActionPerformed

    private void sname_tfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sname_tfFocusGained
        fgcheck(sname_tf);
    }//GEN-LAST:event_sname_tfFocusGained

    private void rgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rgActionPerformed
        fr_lb.setVisible(true);
        to_lb.setVisible(true);
        fr_dt.setVisible(true);
        to_dt.setVisible(true);
        ser_bx.setVisible(false);
        ser_tf.setVisible(false);
        fr_dt.setDate(new java.sql.Date(System.currentTimeMillis()));
        to_dt.setDate(new java.sql.Date(System.currentTimeMillis()));
    }//GEN-LAST:event_rgActionPerformed
    public void fgcheck(JTextField c){
        String str=c.getText();
        if(str.equalsIgnoreCase("*Field is Mandatory")||str.isEmpty()||str==null)
        {
            c.setText("");
            c.setBorder(new LineBorder(Color.BLACK));
            c.setForeground(Color.black);
        }
    }
    public void flcheck(JTextField c){
        String str=c.getText();
        if(str.length()==0||str.isEmpty()||str==null||str.equalsIgnoreCase("*Field is Mandatory"))
        {
            chk=false;
            c.setText("*Field is Mandatory");
            c.setForeground(Color.red);
            c.setBorder(new LineBorder(Color.RED));
        }
    }
    public void reset()
    {
        per.setText("");
        regno_tf.setText("");
        cou_tf.setText("");
        prev_tf.setText("");
        sname_tf.setText("");
        coufee_tf.setText("0");
        tot_fee.setText("");
        cou_box.setSelectedIndex(0);
        cou_box.setBorder(new LineBorder(Color.BLACK));
        regno_tf.requestFocus();
        regno_tf.setBorder(new LineBorder(Color.BLACK));
        regno_tf.setForeground(Color.black);
        disc_tf.setBorder(new LineBorder(Color.BLACK));
        disc_tf.setForeground(Color.black);
        cou_tf.setBorder(new LineBorder(Color.BLACK));
        cou_tf.setForeground(Color.black);
        cou_tf.setEditable(false);
        submit_bt.setEnabled(true);
        disc_tf.setText("0");
        cou_box.removeAllItems();
        for(String a:cdata.split(","))
            cou_box.addItem(a);
        per.setEditable(false);
        disc_tf.setEditable(false);
        otp.setEnabled(false);
        otp.setSelectedIndex(0);
    }
    public void check(){
        flcheck(regno_tf);
        flcheck(sname_tf);
        String kk;
        kk=coufee_tf.getText();
        if(kk==null||kk.equals("0")||kk.isEmpty()){
            chk=false;
            JOptionPane.showMessageDialog(this, "Please Select Any Course!");
        }
        if(doa_date.getDate()==null){
            chk=false;
            JOptionPane.showMessageDialog(this, "Please Select Valid Date!");
        }
    }
    public void percentage(){
        if(!coufee_tf.getText().equals("*Field is mandatory!")&&!coufee_tf.getText().equals("0")&&coufee_tf.getText().length()!=0){
        String d=disc_tf.getText();
            if (!d.equals("")){
               double t=Double.parseDouble(coufee_tf.getText());
                double e=Double.parseDouble(disc_tf.getText());
                int kk=Integer.parseInt(coufee_tf.getText())-Integer.parseInt(disc_tf.getText());
                tot_fee.setText(String.valueOf(kk));
                double b=(e*100/t);
                per.setText(""+String.format("%.2f",b));
            }
            else if (disc_tf.getText().length()==0)
                per.setText("");
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cou_box;
    private javax.swing.JTextField cou_tf;
    private javax.swing.JTextField coufee_tf;
    private javax.swing.JLabel crapplying1;
    private javax.swing.JLabel crfee1;
    private javax.swing.JLabel crstudied1;
    private javax.swing.JButton del_bt;
    private javax.swing.JLabel disc1;
    private javax.swing.JTextField disc_tf;
    private javax.swing.JLabel doa1;
    private com.toedter.calendar.JDateChooser doa_date;
    private javax.swing.JLabel formno1;
    private javax.swing.JTextField formno_tf;
    private com.toedter.calendar.JDateChooser fr_dt;
    private javax.swing.JLabel fr_lb;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator2;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JComboBox<String> otp;
    private javax.swing.JTextField per;
    private javax.swing.JTextField prev_tf;
    private javax.swing.JButton print;
    private javax.swing.JButton ref_bt;
    private javax.swing.JLabel regno1;
    private javax.swing.JTextField regno_tf;
    private javax.swing.JButton reset_bt;
    private javax.swing.JButton rg;
    private javax.swing.JButton search_bt;
    private javax.swing.JComboBox<String> ser_bx;
    private org.jdesktop.swingx.JXSearchField ser_tf;
    private javax.swing.JLabel sname1;
    private javax.swing.JTextField sname_tf;
    private javax.swing.JButton submit_bt;
    private javax.swing.JTabbedPane tab;
    private javax.swing.JPanel tab2;
    private javax.swing.JScrollPane tab_pan;
    private javax.swing.JTable table;
    private com.toedter.calendar.JDateChooser to_dt;
    private javax.swing.JLabel to_lb;
    private javax.swing.JTextField tot_fee;
    private javax.swing.JLabel totfee1;
    private javax.swing.JButton up_bt;
    // End of variables declaration//GEN-END:variables
}
