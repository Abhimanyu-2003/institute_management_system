package raysproject;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
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
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import jxl.write.Label;
import jxl.write.WriteException;

public class regEntryForm extends javax.swing.JFrame {
//entry form variable
    boolean flag=true,chk=true,emailchk=true,h=true;
    DefaultTableModel model;
    ButtonGroup bg;
    Connection con;
    Blob b,c;
    PreparedStatement stmt;
    ResultSet rs,rs1;
    int year,reg_no;
     ImageIcon img,img2;
    String str,url,email,s,reg_str;
    File f1,f2;
    FileInputStream fin;
    Label l,d;
    SimpleDateFormat f;
    byte ctr=0,dot=0,rol;
    public regEntryForm(byte role) throws SQLException, ParseException {
        initComponents();
        rol=role;
        f=new SimpleDateFormat("dd-MMM-yyyy");
        if(role==0){
            reg_tf.setEditable(true);
            dat.setEnabled(true);
        }
        else if(role==1){
            Delete.setVisible(false);
            reg_tf.setEditable(false);
            dat.setEnabled(false);
        }
        else{
            tab.remove(tab2);
        }   
       Calendar dd=Calendar.getInstance();
       dob.setMaxSelectableDate(dd.getTime());
        Image icon=Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/icon/repl_logo_(1)-small.png"));
        this.setIconImage(icon);
            //******************autogenerate for reg_no************************
        con=ConnDb.conLink();
        stmt=con.prepareStatement("select reg_no from automatic");
        rs=stmt.executeQuery();
        rs.next();
        reg_no=rs.getInt(1)+1;
        //+++++++++get current year of system++++++++++++++++
        Calendar cal=Calendar.getInstance();
         year = (cal.get(Calendar.YEAR))%100;
         stmt=con.prepareStatement("select max(reg_no) from registration");
         rs=stmt.executeQuery();
         if(rs.next()){
             String a=rs.getString(1);
             if(a!=null && year>(Integer.parseInt(a.substring(10,12))))
                reg_no=1;
         }   
          autogen();         
        ///**********************************************
//        rangepan.setVisible(false);
        fr_dt.setVisible(false);
        to_dt.setVisible(false);
        Update.setVisible(false);
        Delete.setVisible(false);
        ser_cb.setVisible(false);
        ser_lb.setVisible(false);
        ser_tf.setVisible(true);
        reg_cb.setSelectedIndex(2);
        url="select * from registration where upper(cont_no)=?";
        con_lb.setForeground(Color.red);
        this.setTitle("Registration-Form");
        this.setLocationRelativeTo(null);
        dat.setDate(new java.sql.Date(System.currentTimeMillis()));
        dob.setDate(new java.sql.Date(System.currentTimeMillis()));
//        fr_dt.setDate(new java.sql.Date(System.currentTimeMillis()));
//        to_dt.setDate(new java.sql.Date(System.currentTimeMillis()));
        nam_tf.requestFocus();
        blo_cb.setSelectedIndex(2);
        sta_cb.setSelectedIndex(0);
        bg=new ButtonGroup();
        mal_rb.setSelected(true);
        bg.add(mal_rb);
        bg.add(fem_rb);
        bg.add(bin_rb);
        this.getRootPane().setDefaultButton(sub_bt);
        stadist("Bihar");
    }
    public void autogen(){
        boolean flag=true;
       if(reg_no<10)
           str="REPL/"+"BR01/"+year+"/R000"+reg_no;
       else if(reg_no<100)
           str="REPL/"+"BR01/"+year+"/R00"+reg_no;
       else if(reg_no<1000)
           str="REPL/"+"BR01/"+year+"/R0"+reg_no;
       else if(reg_no<10000)
           str="REPL/"+"BR01/"+year+"/R"+reg_no;
       else{
           JOptionPane.showMessageDialog(null,"More than 9999 student not allowed");
           flag=false;
       }
       if(flag){
             reg_tf.setText(str);
             reg_str=str;
         }  
       else{
           sub_bt.setVisible(false);
       }
    }
    public void reset(){
         ph.setBorder(new LineBorder(Color.BLACK));
        dob_lb.setText("");
        nam_tf.requestFocus();
        lb.setText("");
        con_lb.setText("");
        nam_tf.setText("");
        nam_tf.setForeground(Color.BLACK);
        fat_tf.setText("");
        fat_tf.setForeground(Color.BLACK);
        mot_tf.setText("");
        mot_tf.setForeground(Color.BLACK);
        dob.setDate(null);
        dob.setForeground(Color.BLACK);
        ema_tf.setText("");
        ema_tf.setForeground(Color.BLACK);
        con_tf.setText("");
        con_tf.setForeground(Color.BLACK);
        col_tf.setText("");
        col_tf.setForeground(Color.BLACK);
        per_ta.setText("");
        per_ta.setForeground(Color.BLACK);
        dis_tf.setSelectedIndex(0);
        dis_tf.setForeground(Color.BLACK);
        nam_tf.setBorder(new LineBorder(Color.black));
        fat_tf.setBorder(new LineBorder(Color.black));
        mot_tf.setBorder(new LineBorder(Color.black));
        dob.setBorder(new LineBorder(Color.black));
        ema_tf.setBorder(new LineBorder(Color.black));
        con_tf.setBorder(new LineBorder(Color.black));
        col_tf.setBorder(new LineBorder(Color.black));
        per_ta.setBorder(new LineBorder(Color.black));
        cor_ta.setBorder(new LineBorder(Color.BLACK));
        cor_ta.setText("");
        sta_cb.setSelectedIndex(0);
        blo_cb.setSelectedIndex(2);
        pro_cb.setText("");
        pro_cb.setBorder(new LineBorder(Color.black));
        mal_rb.setSelected(true);
        ph.setIcon(null);
        aad_ph.setIcon(null);
        add_rb.setSelected(false);
        dob.setDate(new java.sql.Date(System.currentTimeMillis()));
    }
    public void serDel(){
        ser_reg.setText("");
        ser_dor.setText("");
        ser_nam.setText("");
        ser_fat.setText("");
        ser_mot.setText("");
        ser_dob.setDate(new java.sql.Date(System.currentTimeMillis()));
//        ser_dob.setText("");
        ser_ema.setText("");
        ser_cont.setText("");
        ser_pro.setText("");
        ser_bg.setText("");
        ser_clg.setText("");
        ser_gen.setText("");
        ser_perta.setText("");
        ser_dis.setText("");
        ser_corta.setText("");
        ser_sta.setText("");
        ser_ph.setIcon(null);
        ser_adh.setIcon(null);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tab = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        reg_tf = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        ph = new javax.swing.JLabel();
        mot_tf = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        fat_tf = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        dob = new com.toedter.calendar.JDateChooser();
        ema_tf = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        con_tf = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        blo_cb = new javax.swing.JComboBox<>();
        pho_bt = new javax.swing.JButton();
        aad_bt = new javax.swing.JButton();
        bin_rb = new javax.swing.JRadioButton();
        fem_rb = new javax.swing.JRadioButton();
        mal_rb = new javax.swing.JRadioButton();
        gen_rb = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        col_tf = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        per_ta = new javax.swing.JTextArea();
        jLabel25 = new javax.swing.JLabel();
        add_rb = new javax.swing.JRadioButton();
        jLabel26 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        cor_ta = new javax.swing.JTextArea();
        aad_ph = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        sta_cb = new javax.swing.JComboBox<>();
        sub_bt = new javax.swing.JButton();
        res_bt = new javax.swing.JButton();
        lb = new javax.swing.JLabel();
        con_lb = new javax.swing.JLabel();
        nam_tf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        dob_lb = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        pro_cb = new javax.swing.JTextField();
        dis_tf = new javax.swing.JComboBox<>();
        dat = new com.toedter.calendar.JDateChooser();
        tab2 = new javax.swing.JPanel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        ser_bt = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        fr_lb = new javax.swing.JLabel();
        to_lb = new javax.swing.JLabel();
        ser_lb = new javax.swing.JPanel();
        ser_ph = new javax.swing.JLabel();
        ser_mot = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        ser_pro = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        ser_gen = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        gen_rb1 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        ser_adh = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        ser_sta = new javax.swing.JTextField();
        con_lb1 = new javax.swing.JLabel();
        ser_reg = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        ser_ema = new javax.swing.JTextField();
        ser_clg = new javax.swing.JTextField();
        ser_dor = new javax.swing.JTextField();
        ser_cont = new javax.swing.JTextField();
        ser_bg = new javax.swing.JTextField();
        ser_dis = new javax.swing.JTextField();
        Previous = new javax.swing.JButton();
        Next = new javax.swing.JButton();
        jLabel58 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        ser_nam = new javax.swing.JTextField();
        ser_fat = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        ser_addupd = new javax.swing.JButton();
        ser_phupd = new javax.swing.JButton();
        first = new javax.swing.JButton();
        last = new javax.swing.JButton();
        serlb = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ser_corta = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        ser_perta = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        ser_dob = new com.toedter.calendar.JDateChooser();
        cancel = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        ser_cb = new javax.swing.JComboBox<>();
        reg_cb = new javax.swing.JComboBox<>();
        ser_tf = new org.jdesktop.swingx.JXSearchField();
        jButton7 = new javax.swing.JButton();
        fr_dt = new com.toedter.calendar.JDateChooser();
        to_dt = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        tab.setBackground(new java.awt.Color(255, 255, 255));
        tab.setForeground(new java.awt.Color(255, 102, 102));
        tab.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tab.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        tab.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tabFocusGained(evt);
            }
        });
        tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabMouseClicked(evt);
            }
        });

        kGradientPanel1.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setkEndColor(new java.awt.Color(49, 183, 194));
        kGradientPanel1.setkStartColor(new java.awt.Color(123, 195, 147));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(56, 78, 120));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTRATION FORM");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 508, -1));

        jButton2.setBackground(new java.awt.Color(0, 51, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/home.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 70, 40));

        kGradientPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 980, 40));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("Date :");
        kGradientPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(609, 57, 92, 24));

        reg_tf.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        reg_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                reg_tfFocusLost(evt);
            }
        });
        kGradientPanel1.add(reg_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 58, 217, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Registration No.");
        kGradientPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 57, 107, 24));

        jPanel8.setBackground(new java.awt.Color(230, 230, 250));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ph.setBackground(new java.awt.Color(255, 51, 51));
        ph.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ph.setToolTipText("Attach Your Photo");
        ph.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel8.add(ph, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 20, 103, 100));

        mot_tf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mot_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                mot_tfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                mot_tfFocusLost(evt);
            }
        });
        mot_tf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mot_tfKeyTyped(evt);
            }
        });
        jPanel8.add(mot_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 52, 241, 24));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Name ");
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 24));

        fat_tf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fat_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fat_tfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fat_tfFocusLost(evt);
            }
        });
        fat_tf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fat_tfKeyTyped(evt);
            }
        });
        jPanel8.add(fat_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 197, 24));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Father's Name");
        jPanel8.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 90, 24));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Mother's Name");
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 90, 24));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("D.O.B");
        jPanel8.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, 106, 24));

        dob.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        dob.setDateFormatString("yyyy-MM-dd");
        dob.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dobFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                dobFocusLost(evt);
            }
        });
        jPanel8.add(dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 50, 198, 26));

        ema_tf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ema_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ema_tfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ema_tfFocusLost(evt);
            }
        });
        ema_tf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ema_tfKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ema_tfKeyTyped(evt);
            }
        });
        jPanel8.add(ema_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 241, 24));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setText("Email Id");
        jPanel8.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 50, 22));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setText("Mobile No.");
        jPanel8.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 90, 22));

        con_tf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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
        jPanel8.add(con_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, 198, 24));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setText("Program");
        jPanel8.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 180, 22));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setText("Blood Group");
        jPanel8.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 95, 22));

        blo_cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A","B","AB","O","A-","B-","AB-","O-"}));
        blo_cb.setNextFocusableComponent(col_tf);
        jPanel8.add(blo_cb, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 198, -1));

        pho_bt.setBackground(new java.awt.Color(0, 116, 226));
        pho_bt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pho_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/upload1.png"))); // NOI18N
        pho_bt.setText("UPLOAD");
        pho_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pho_bt.setNextFocusableComponent(aad_bt);
        pho_bt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pho_btFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                pho_btFocusLost(evt);
            }
        });
        pho_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pho_btActionPerformed(evt);
            }
        });
        jPanel8.add(pho_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 140, 103, -1));

        aad_bt.setBackground(new java.awt.Color(0, 116, 226));
        aad_bt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        aad_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/upload1.png"))); // NOI18N
        aad_bt.setText("UPLOAD");
        aad_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        aad_bt.setNextFocusableComponent(sub_bt);
        aad_bt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                aad_btFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                aad_btFocusLost(evt);
            }
        });
        aad_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aad_btActionPerformed(evt);
            }
        });
        jPanel8.add(aad_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 430, -1, -1));

        bin_rb.setBackground(new java.awt.Color(230, 230, 250));
        bin_rb.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bin_rb.setText("Binary");
        bin_rb.setNextFocusableComponent(per_ta);
        jPanel8.add(bin_rb, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 170, 73, -1));

        fem_rb.setBackground(new java.awt.Color(230, 230, 250));
        fem_rb.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        fem_rb.setText("Female");
        fem_rb.setNextFocusableComponent(bin_rb);
        jPanel8.add(fem_rb, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 170, 71, -1));

        mal_rb.setBackground(new java.awt.Color(230, 230, 250));
        mal_rb.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        mal_rb.setText("Male");
        mal_rb.setNextFocusableComponent(fem_rb);
        jPanel8.add(mal_rb, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, 60, -1));

        gen_rb.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        gen_rb.setText("Gender");
        jPanel8.add(gen_rb, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, 56, 22));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setText("College Name");
        jPanel8.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 137, 22));

        col_tf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        col_tf.setNextFocusableComponent(per_ta);
        col_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                col_tfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                col_tfFocusLost(evt);
            }
        });
        col_tf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                col_tfKeyTyped(evt);
            }
        });
        jPanel8.add(col_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 241, 24));

        per_ta.setColumns(20);
        per_ta.setLineWrap(true);
        per_ta.setRows(5);
        per_ta.setNextFocusableComponent(sta_cb);
        per_ta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                per_taFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                per_taFocusLost(evt);
            }
        });
        per_ta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                per_taKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(per_ta);

        jPanel8.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 241, -1));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setText("Permanent address");
        jPanel8.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 131, 22));

        add_rb.setBackground(new java.awt.Color(230, 230, 250));
        add_rb.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        add_rb.setText("click (if permanent address is same as corresponding address)");
        add_rb.setNextFocusableComponent(cor_ta);
        add_rb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_rbActionPerformed(evt);
            }
        });
        jPanel8.add(add_rb, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 388, -1));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel26.setText("Correspondance address");
        jPanel8.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        jButton3.setBackground(new java.awt.Color(0, 116, 226));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Submit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 692, 101, -1));

        jButton4.setBackground(new java.awt.Color(204, 0, 51));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Reset");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 692, 101, -1));

        cor_ta.setColumns(20);
        cor_ta.setLineWrap(true);
        cor_ta.setRows(5);
        cor_ta.setWrapStyleWord(true);
        cor_ta.setNextFocusableComponent(pho_bt);
        cor_ta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cor_taFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cor_taFocusLost(evt);
            }
        });
        cor_ta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cor_taKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(cor_ta);

        jPanel8.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 244, -1));

        aad_ph.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aad_ph.setToolTipText("Upload Aadhar Photo");
        aad_ph.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel8.add(aad_ph, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 260, 330, 151));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("District");
        jPanel8.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, 60, 25));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("State");
        jPanel8.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 78, 25));

        sta_cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Bihar","Andhra Pradesh","Arunachal Pradesh","Assam","Chhattisgarh","Delhi","Goa","Gujarat","Haryana","Himachal Pradesh","Jammu & Kashmir","Jharkhand","Karnataka","Kerala","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Odisha","Punjab","Rajasthan","Sikkim","Tamil Nadu","Tripura","Telangana","Uttar Pradesh","Uttarakhand","West Bengal","Andaman & Nicobar","Chandigarh","Dadra & Nagar Haveli","Daman & Diu","Lakshadweep","Puducherry"}));
        sta_cb.setNextFocusableComponent(dis_tf);
        sta_cb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sta_cbActionPerformed(evt);
            }
        });
        jPanel8.add(sta_cb, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 200, 198, -1));

        sub_bt.setBackground(new java.awt.Color(51, 51, 255));
        sub_bt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        sub_bt.setForeground(new java.awt.Color(255, 255, 255));
        sub_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/submit.png"))); // NOI18N
        sub_bt.setText("SUBMIT");
        sub_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sub_bt.setNextFocusableComponent(res_bt);
        sub_bt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sub_btFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                sub_btFocusLost(evt);
            }
        });
        sub_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sub_btActionPerformed(evt);
            }
        });
        jPanel8.add(sub_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 440, -1, -1));

        res_bt.setBackground(new java.awt.Color(255, 51, 0));
        res_bt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        res_bt.setForeground(new java.awt.Color(255, 255, 255));
        res_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/clear_1.png"))); // NOI18N
        res_bt.setText("CLEAR");
        res_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        res_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                res_btActionPerformed(evt);
            }
        });
        jPanel8.add(res_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 440, 90, -1));
        jPanel8.add(lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 116, 240, 10));
        jPanel8.add(con_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 200, -1));

        nam_tf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        nam_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nam_tfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nam_tfFocusLost(evt);
            }
        });
        nam_tf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nam_tfKeyTyped(evt);
            }
        });
        jPanel8.add(nam_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 22, 241, 24));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("*");
        jPanel8.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 40, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("*");
        jPanel8.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 20, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("*");
        jPanel8.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 40, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("*");
        jPanel8.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 40, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("*");
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 40, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("*");
        jPanel8.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 40, 20));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("*");
        jPanel8.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 40, 20));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("*");
        jPanel8.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 20, 20));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 0, 0));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("*");
        jPanel8.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, 20, 20));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 0, 0));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel28.setText("*");
        jPanel8.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 230, 20, 20));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 0, 0));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel29.setText("*");
        jPanel8.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 200, 20, 20));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Upload photo");
        jPanel8.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 120, 100, -1));

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 0, 0));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel31.setText("*");
        jPanel8.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 20, 20));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Upload Aadhar photo");
        jPanel8.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 410, 300, -1));

        dob_lb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel8.add(dob_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 200, 30));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 0, 0));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel33.setText("*");
        jPanel8.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 40, 20));

        pro_cb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pro_cb.setNextFocusableComponent(blo_cb);
        pro_cb.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pro_cbFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                pro_cbFocusLost(evt);
            }
        });
        pro_cb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pro_cbKeyTyped(evt);
            }
        });
        jPanel8.add(pro_cb, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 240, 30));

        dis_tf.setNextFocusableComponent(cor_ta);
        jPanel8.add(dis_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 230, 200, -1));

        kGradientPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 935, 500));

        dat.setDateFormatString("yyyy-MM-dd");
        dat.setEnabled(false);
        dat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                datFocusLost(evt);
            }
        });
        kGradientPanel1.add(dat, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 60, 198, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
        );

        tab.addTab("Registration Entry Form", jPanel1);

        kGradientPanel2.setkEndColor(new java.awt.Color(102, 255, 255));
        kGradientPanel2.setkStartColor(new java.awt.Color(53, 118, 164));
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ser_bt.setBackground(new java.awt.Color(0, 116, 226));
        ser_bt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ser_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search-icon-png-9964.png"))); // NOI18N
        ser_bt.setText("SEARCH");
        ser_bt.setAlignmentY(0.0F);
        ser_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ser_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ser_btActionPerformed(evt);
            }
        });
        kGradientPanel2.add(ser_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 110, 30));

        jPanel12.setBackground(new java.awt.Color(59, 113, 151));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("REGISTRATION SERVICE FORM");

        fr_lb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fr_lb.setForeground(new java.awt.Color(255, 255, 255));
        fr_lb.setText("From Date");

        to_lb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        to_lb.setForeground(new java.awt.Color(255, 255, 255));
        to_lb.setText("To Date");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(fr_lb)
                .addGap(108, 108, 108)
                .addComponent(to_lb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(328, 328, 328))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fr_lb)
                    .addComponent(to_lb)))
        );

        kGradientPanel2.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 7, 980, 50));

        ser_lb.setBackground(new java.awt.Color(230, 230, 250));
        ser_lb.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ser_ph.setBackground(new java.awt.Color(255, 51, 51));
        ser_ph.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ser_ph.setToolTipText("Attach Your Photo");
        ser_ph.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        ser_lb.add(ser_ph, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 20, 103, 100));

        ser_mot.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ser_mot.setNextFocusableComponent(ser_dob);
        ser_mot.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ser_motFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ser_motFocusLost(evt);
            }
        });
        ser_mot.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ser_motKeyTyped(evt);
            }
        });
        ser_lb.add(ser_mot, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 241, 24));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel34.setText("Name ");
        ser_lb.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 50, 24));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel35.setText("Father's Name");
        ser_lb.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 90, 24));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel36.setText("Mother's Name");
        ser_lb.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 150, 24));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel37.setText("D.O.B");
        ser_lb.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 70, 24));

        ser_pro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ser_pro.setNextFocusableComponent(ser_bg);
        ser_pro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ser_proFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ser_proFocusLost(evt);
            }
        });
        ser_pro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ser_proKeyTyped(evt);
            }
        });
        ser_lb.add(ser_pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 241, 24));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel38.setText("Email Id");
        ser_lb.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 50, 22));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel39.setText("Contact No.");
        ser_lb.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 100, 22));

        ser_gen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ser_gen.setNextFocusableComponent(ser_perta);
        ser_gen.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ser_genFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ser_genFocusLost(evt);
            }
        });
        ser_gen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ser_genKeyTyped(evt);
            }
        });
        ser_lb.add(ser_gen, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 200, 198, 24));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel40.setText("Program");
        ser_lb.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 100, 22));

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel41.setText("Blood Group");
        ser_lb.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 80, 22));

        gen_rb1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        gen_rb1.setText("Gender");
        ser_lb.add(gen_rb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 50, 22));

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel42.setText("College Name");
        ser_lb.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 100, 22));

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel43.setText("Permanent address");
        ser_lb.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 131, 22));

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel44.setText("Correspondance address");
        ser_lb.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        jButton5.setBackground(new java.awt.Color(0, 116, 226));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Submit");
        ser_lb.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 692, 101, -1));

        jButton6.setBackground(new java.awt.Color(204, 0, 51));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Reset");
        ser_lb.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 692, 101, -1));

        ser_adh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ser_adh.setToolTipText("Upload Aadhar Photo");
        ser_adh.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        ser_adh.setNextFocusableComponent(ser_gen);
        ser_lb.add(ser_adh, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 270, 330, 150));

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel45.setText("District");
        ser_lb.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 50, 25));

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel46.setText("State");
        ser_lb.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 240, 50, 20));

        ser_sta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ser_sta.setNextFocusableComponent(ser_dis);
        ser_sta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ser_staFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ser_staFocusLost(evt);
            }
        });
        ser_sta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ser_staKeyTyped(evt);
            }
        });
        ser_lb.add(ser_sta, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 240, 200, 24));
        ser_lb.add(con_lb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 200, -1));

        ser_reg.setEditable(false);
        ser_reg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ser_reg.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ser_regFocusLost(evt);
            }
        });
        ser_lb.add(ser_reg, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 241, 24));

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 0, 0));
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel48.setText("*");
        ser_lb.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, 20, 20));

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 0, 0));
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel49.setText("*");
        ser_lb.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 85, 40, 30));

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 0, 0));
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel50.setText("*");
        ser_lb.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 40, 20));

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 0, 0));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel51.setText("*");
        ser_lb.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 40, 20));

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 0, 0));
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel52.setText("*");
        ser_lb.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 40, 20));

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 0, 0));
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel53.setText("*");
        ser_lb.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, 30, 20));

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 0, 0));
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel54.setText("*");
        ser_lb.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 20, 20));

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 0, 0));
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel55.setText("*");
        ser_lb.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, 20, 20));

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 0, 0));
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel56.setText("*");
        ser_lb.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 240, 20, 20));

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 0, 0));
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel57.setText("*");
        ser_lb.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 20, 20));

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("Photo");
        ser_lb.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 120, 100, -1));

        jLabel60.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 0, 0));
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel60.setText("*");
        ser_lb.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, 20, 20));

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setText("AAdhar Card");
        ser_lb.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 420, 300, 20));

        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 0, 0));
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel62.setText("*");
        ser_lb.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 40, 20));

        ser_ema.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ser_ema.setNextFocusableComponent(ser_cont);
        ser_ema.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ser_emaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ser_emaFocusLost(evt);
            }
        });
        ser_ema.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ser_emaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ser_emaKeyTyped(evt);
            }
        });
        ser_lb.add(ser_ema, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 241, 24));

        ser_clg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ser_clg.setNextFocusableComponent(ser_gen);
        ser_clg.setOpaque(false);
        ser_clg.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ser_clgFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ser_clgFocusLost(evt);
            }
        });
        ser_clg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ser_clgKeyTyped(evt);
            }
        });
        ser_lb.add(ser_clg, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 241, 24));

        ser_dor.setEditable(false);
        ser_dor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ser_lb.add(ser_dor, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 200, 24));

        ser_cont.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ser_cont.setNextFocusableComponent(ser_pro);
        ser_cont.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ser_contFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ser_contFocusLost(evt);
            }
        });
        ser_cont.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ser_contKeyTyped(evt);
            }
        });
        ser_lb.add(ser_cont, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 198, 24));

        ser_bg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ser_bg.setNextFocusableComponent(ser_clg);
        ser_bg.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ser_bgFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ser_bgFocusLost(evt);
            }
        });
        ser_lb.add(ser_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 160, 198, 24));

        ser_dis.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ser_dis.setNextFocusableComponent(ser_corta);
        ser_dis.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ser_disFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ser_disFocusLost(evt);
            }
        });
        ser_dis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ser_disKeyTyped(evt);
            }
        });
        ser_lb.add(ser_dis, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, 198, 24));

        Previous.setBackground(new java.awt.Color(0, 116, 226));
        Previous.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Previous.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pre(1).png"))); // NOI18N
        Previous.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousActionPerformed(evt);
            }
        });
        ser_lb.add(Previous, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 460, 90, -1));

        Next.setBackground(new java.awt.Color(0, 116, 226));
        Next.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/next_1.png"))); // NOI18N
        Next.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextActionPerformed(evt);
            }
        });
        ser_lb.add(Next, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 460, 80, -1));

        jLabel58.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel58.setText("Registration No.");
        ser_lb.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 170, 24));

        jLabel63.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel63.setText("Registration Date ");
        ser_lb.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 110, 24));

        ser_nam.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ser_nam.setNextFocusableComponent(ser_fat);
        ser_nam.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ser_namFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ser_namFocusLost(evt);
            }
        });
        ser_nam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ser_namKeyTyped(evt);
            }
        });
        ser_lb.add(ser_nam, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 241, 24));

        ser_fat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ser_fat.setNextFocusableComponent(ser_mot);
        ser_fat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ser_fatFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ser_fatFocusLost(evt);
            }
        });
        ser_fat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ser_fatKeyTyped(evt);
            }
        });
        ser_lb.add(ser_fat, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 60, 200, 24));

        jLabel64.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 0, 0));
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel64.setText("*");
        ser_lb.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 10, -1));

        ser_addupd.setBackground(new java.awt.Color(0, 116, 226));
        ser_addupd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ser_addupd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/upload1.png"))); // NOI18N
        ser_addupd.setText("Upload");
        ser_addupd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ser_addupd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ser_addupdActionPerformed(evt);
            }
        });
        ser_lb.add(ser_addupd, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 440, 90, -1));

        ser_phupd.setBackground(new java.awt.Color(0, 116, 226));
        ser_phupd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ser_phupd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/upload1.png"))); // NOI18N
        ser_phupd.setText("Upload");
        ser_phupd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ser_phupd.setNextFocusableComponent(ser_addupd);
        ser_phupd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ser_phupdActionPerformed(evt);
            }
        });
        ser_lb.add(ser_phupd, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 140, -1, -1));

        first.setBackground(new java.awt.Color(0, 116, 226));
        first.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        first.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/first_1.png"))); // NOI18N
        first.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        first.setPreferredSize(new java.awt.Dimension(81, 25));
        first.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstActionPerformed(evt);
            }
        });
        ser_lb.add(first, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 460, -1, 40));

        last.setBackground(new java.awt.Color(0, 116, 226));
        last.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        last.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/last_1.png"))); // NOI18N
        last.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        last.setPreferredSize(new java.awt.Dimension(81, 25));
        last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastActionPerformed(evt);
            }
        });
        ser_lb.add(last, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 460, -1, 40));

        serlb.setBorder(new javax.swing.border.MatteBorder(null));
        ser_lb.add(serlb, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 144, 240, 10));

        jScrollPane4.setBorder(null);
        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane4.setEnabled(false);
        jScrollPane4.setOpaque(false);
        jScrollPane4.setRequestFocusEnabled(false);
        jScrollPane4.setWheelScrollingEnabled(false);

        ser_corta.setColumns(20);
        ser_corta.setLineWrap(true);
        ser_corta.setRows(5);
        ser_corta.setWrapStyleWord(true);
        ser_corta.setBorder(null);
        ser_corta.setNextFocusableComponent(ser_phupd);
        ser_corta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ser_cortaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ser_cortaFocusLost(evt);
            }
        });
        ser_corta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ser_cortaKeyTyped(evt);
            }
        });
        jScrollPane4.setViewportView(ser_corta);

        ser_lb.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 240, 50));

        jScrollPane5.setBorder(null);
        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane5.setEnabled(false);
        jScrollPane5.setOpaque(false);
        jScrollPane5.setRequestFocusEnabled(false);
        jScrollPane5.setWheelScrollingEnabled(false);

        ser_perta.setColumns(20);
        ser_perta.setLineWrap(true);
        ser_perta.setRows(5);
        ser_perta.setWrapStyleWord(true);
        ser_perta.setBorder(null);
        ser_perta.setNextFocusableComponent(ser_sta);
        ser_perta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ser_pertaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ser_pertaFocusLost(evt);
            }
        });
        ser_perta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ser_pertaKeyTyped(evt);
            }
        });
        jScrollPane5.setViewportView(ser_perta);

        ser_lb.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 240, 50));

        jButton1.setBackground(new java.awt.Color(0, 204, 204));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/print.png"))); // NOI18N
        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ser_lb.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 463, 80, 30));

        ser_dob.setDateFormatString("yyyy-MM-dd");
        ser_dob.setNextFocusableComponent(ser_ema);
        ser_lb.add(ser_dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, 200, 30));

        kGradientPanel2.add(ser_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 935, 510));

        cancel.setBackground(new java.awt.Color(255, 0, 51));
        cancel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        cancel.setText("REFRESH");
        cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        kGradientPanel2.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 60, 100, 31));

        Update.setBackground(new java.awt.Color(255, 85, 2));
        Update.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.png"))); // NOI18N
        Update.setText("Update");
        Update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Update.setMinimumSize(new java.awt.Dimension(77, 25));
        Update.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                UpdateFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                UpdateFocusLost(evt);
            }
        });
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });
        kGradientPanel2.add(Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 60, 100, 30));

        Delete.setBackground(new java.awt.Color(255, 22, 0));
        Delete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        Delete.setText("Delete");
        Delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Delete.setPreferredSize(new java.awt.Dimension(77, 25));
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        kGradientPanel2.add(Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 60, 90, 30));

        kGradientPanel2.add(ser_cb, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 190, 30));

        reg_cb.setBackground(new java.awt.Color(255, 248, 246));
        reg_cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Registration number","Student Name","Contact Number","Blood Group","Program","College" }));
        reg_cb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reg_cbActionPerformed(evt);
            }
        });
        kGradientPanel2.add(reg_cb, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 170, 31));

        ser_tf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ser_tfKeyTyped(evt);
            }
        });
        kGradientPanel2.add(ser_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 190, 30));

        jButton7.setBackground(new java.awt.Color(0, 116, 226));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/range.png"))); // NOI18N
        jButton7.setText("Range Search");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        kGradientPanel2.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, -1, 30));

        fr_dt.setDateFormatString("yyyy-MM-dd");
        kGradientPanel2.add(fr_dt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 170, 30));

        to_dt.setDateFormatString("yyyy-MM-dd");
        kGradientPanel2.add(to_dt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 190, 30));

        javax.swing.GroupLayout tab2Layout = new javax.swing.GroupLayout(tab2);
        tab2.setLayout(tab2Layout);
        tab2Layout.setHorizontalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tab2Layout.setVerticalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tab.addTab("Registration Service Form", tab2);

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

    private void mot_tfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mot_tfFocusGained
        
        regfg(mot_tf);
    }//GEN-LAST:event_mot_tfFocusGained

    private void mot_tfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mot_tfFocusLost
        if(mot_tf.getText().length()==0)
        regfl(mot_tf);
        else
         regKr(mot_tf);
    }//GEN-LAST:event_mot_tfFocusLost

    private void mot_tfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mot_tfKeyTyped
        

        regkt(evt,mot_tf);
    }//GEN-LAST:event_mot_tfKeyTyped

    private void fat_tfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fat_tfFocusGained
        regfg(fat_tf);
    }//GEN-LAST:event_fat_tfFocusGained

    private void fat_tfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fat_tfFocusLost
      if(fat_tf.getText().length()==0)
        regfl(fat_tf);
      else
         regKr(fat_tf);
    }//GEN-LAST:event_fat_tfFocusLost

    private void fat_tfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fat_tfKeyTyped
        regkt(evt,fat_tf);
    }//GEN-LAST:event_fat_tfKeyTyped

    private void ema_tfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ema_tfFocusGained
        ema_tf.setBorder(new LineBorder(Color.black));
        lb.setText("");
    }//GEN-LAST:event_ema_tfFocusGained

    private void ema_tfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ema_tfFocusLost
        
        String last[] = {".com", ".org",".in", ".net", ".edu", ".gov", ".mil", ".biz", ".info", ".pro", ".name", ".coop", ".aero", ".museum", ".asia", ".cat", ".jobs", ".mobi", ".tel", ".travel", ".xxx", ".arpa", ".int", ".post", ".root", ".test"};
        lb.setForeground(Color.red);
        String str = ema_tf.getText();
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
              lb.setText("*Please enter a valid email Id!");  
            if (emailchk)
            {
                if(str.contains("@"))
                {
                    byte index1=(byte) str.indexOf("@");
                    byte index2=(byte) str.indexOf(".");
                    if (index2==(index1+1))
                    {
                        ema_tf.setBorder(new LineBorder(Color.red));
                        Toolkit.getDefaultToolkit().beep();
                        lb.setText("*Please enter a valid email Id!");
                    }
                    else
                    lb.setText("");

                }
                else
                {
                    ema_tf.setBorder(new LineBorder(Color.red));
                    Toolkit.getDefaultToolkit().beep();
                    lb.setText("*Please enter a valid email Id!");
                }
            }
            else{
                ema_tf.setBorder(new LineBorder(Color.red));
                Toolkit.getDefaultToolkit().beep();
                lb.setText("*Please enter a valid email Id!");
            }
        }
        else
         lb.setText("");
    }//GEN-LAST:event_ema_tfFocusLost

    private void ema_tfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ema_tfKeyTyped
        
        char ch=evt.getKeyChar();
        if(((evt.getKeyChar()==' ')||evt.getKeyChar()=='.')&& ema_tf.getCaretPosition()==0)
        {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        else if(!(ch>=65&& ch<=90 || ch>=97 && ch<=122 ||ch>='0' && ch<='9'|| ch=='@'||ch=='.'))
        {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
         else if(ch=='8'||((ch>=65 && ch<=90)|| (ch>=97 && ch<=122||ch>='0' && ch<='9'|| ch=='@'))) 
             dot=0;
        else if((evt.getKeyChar()=='.' )&& dot==0)
            dot=1;
        else {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();}
    }//GEN-LAST:event_ema_tfKeyTyped

    private void con_tfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_con_tfFocusGained
        
        regfg(con_tf);
    }//GEN-LAST:event_con_tfFocusGained

    private void con_tfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_con_tfFocusLost
        regfl(con_tf);

    }//GEN-LAST:event_con_tfFocusLost

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

    private void pho_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pho_btActionPerformed
        
        JFileChooser ch=new JFileChooser();
        ch.showOpenDialog(this);
        f1 = ch.getSelectedFile();
        img=new ImageIcon(new ImageIcon(""+f1).getImage().getScaledInstance(ph.getWidth(), ph.getHeight(),Image.SCALE_SMOOTH));
        ph.setIcon(img);
    }//GEN-LAST:event_pho_btActionPerformed

    private void aad_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aad_btActionPerformed
        
        JFileChooser ch=new JFileChooser();
        ch.showOpenDialog(this);
        f2 = ch.getSelectedFile();
        img=new ImageIcon(new ImageIcon(""+f2).getImage().getScaledInstance(aad_ph.getWidth(), aad_ph.getHeight(),Image.SCALE_SMOOTH));
        aad_ph.setIcon(img);
    }//GEN-LAST:event_aad_btActionPerformed

    private void col_tfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_col_tfFocusGained
        regfg(col_tf);
    }//GEN-LAST:event_col_tfFocusGained

    private void col_tfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_col_tfFocusLost
        if(col_tf.getText().length()==0)
        regfl(col_tf);
        else
         regKr(col_tf);
    }//GEN-LAST:event_col_tfFocusLost

    private void col_tfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_col_tfKeyTyped
        regkt(evt,col_tf);
    }//GEN-LAST:event_col_tfKeyTyped

    private void per_taFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_per_taFocusGained
        
        tafg(per_ta);
    }//GEN-LAST:event_per_taFocusGained

    private void per_taFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_per_taFocusLost
        if(per_ta.getText().length()==0)
            tafl(per_ta); 
        else
            regflta(per_ta);
    }//GEN-LAST:event_per_taFocusLost

    private void per_taKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_per_taKeyTyped
                    
        char ch=evt.getKeyChar();
        if((evt.getKeyChar()==' '||evt.getKeyChar()=='.'||evt.getKeyChar()==9) && per_ta.getCaretPosition()==0)
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
    }//GEN-LAST:event_per_taKeyTyped

    private void add_rbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_rbActionPerformed

        if(add_rb.isSelected() ){
            cor_ta.setForeground(Color.BLACK);
            cor_ta.setBorder(new LineBorder(Color.black));
            cor_ta.setEditable(false);
            if( per_ta.getText().length()>0&& (!per_ta.getText().equals("*Field is mandatory!"))){

                cor_ta.setText(""+per_ta.getText().trim());
            }
        }
        else {
            cor_ta.setEditable(true);
            cor_ta.setText("");
        }

    }//GEN-LAST:event_add_rbActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cor_taKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cor_taKeyTyped
        
        char ch=evt.getKeyChar();
        if((evt.getKeyChar()==' '||evt.getKeyChar()=='.'||evt.getKeyChar()==9) && per_ta.getCaretPosition()==0)
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
        
    }//GEN-LAST:event_cor_taKeyTyped

    private void sub_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sub_btActionPerformed
     
        valchk();
     if(nam_tf.getText().equals("*Field is mandatory!")||fat_tf.getText().equals("*Field is mandatory!")||mot_tf.getText().equals("*Field is mandatory!")||con_tf.getText().equals("*Field is mandatory!")||col_tf.getText().equals("*Field is mandatory!")||cor_ta.getText().equals("*Field is mandatory!")||mot_tf.getText().equals("*Field is mandatory!")||con_tf.getText().equals("*Field is mandatory!")||col_tf.getText().equals("*Field is mandatory!")||per_ta.getText().equals("*Field is mandatory!")||pro_cb.getText().equals("*Field is mandatory!")||pro_cb.getText().isEmpty()||dob.getDate()==null)
         chk=false;
     else if(nam_tf.getText().isEmpty()||fat_tf.getText().isEmpty()||mot_tf.getText().isEmpty()||con_tf.getText().isEmpty()||col_tf.getText().isEmpty()||per_ta.getText().isEmpty()||cor_ta.getText().isEmpty()||con_tf.getText().length()<10){
         chk=false;   
     }
     else if(!(lb.getText()==null||lb.getText().isEmpty())){
         chk=false;
     }
     else
         chk=true;
     
    if(chk){
        if(con_tf.getText().length()==10){
         byte a=(byte) JOptionPane.showConfirmDialog(this, "Are you really want to Submit?");
            if(a==0)
           try {
            String gen;
            stmt=con.prepareStatement("insert into registration values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, reg_tf.getText());
            String sd=((JTextField)dat.getDateEditor().getUiComponent()).getText();
            DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
            java.sql.Date sql=null,sq=null;
            java.util.Date date=df.parse(sd);
            sql=new java.sql.Date(date.getTime());
            stmt.setDate(2, sql);
            stmt.setString(3, nam_tf.getText().trim());
            stmt.setString(4, fat_tf.getText().trim());
            stmt.setString(5, mot_tf.getText().trim());
            String dd=((JTextField)dob.getDateEditor().getUiComponent()).getText();
            java.util.Date dt=df.parse(dd);
            sq=new java.sql.Date(dt.getTime());
            stmt.setDate(6,sq);
            stmt.setString(7, ema_tf.getText().toLowerCase().trim());
            stmt.setString(8,con_tf.getText().trim());
            stmt.setString(9, ""+pro_cb.getText().trim());
            stmt.setString(10,""+ blo_cb.getSelectedItem());
            stmt.setString(11, col_tf.getText().trim());
            if(mal_rb.isSelected())
            gen="Male";
            else if(fem_rb.isSelected())
            gen="Female";
            else
            gen="Binary";
            stmt.setString(12,gen.toUpperCase());
            stmt.setString(13, per_ta.getText().trim());
            stmt.setString(14, dis_tf.getSelectedItem().toString());
            stmt.setString(15, sta_cb.getSelectedItem().toString());
            
            if(f1==null)
                stmt.setBinaryStream(16,null);
            else
            {
                 fin=new FileInputStream(f1);
                 stmt.setBinaryStream(16,fin,fin.available());
            }
            if(f2==null)
                stmt.setBinaryStream(17,null);
            else
            {
                fin=new FileInputStream(f2);
                stmt.setBinaryStream(17,fin,fin.available());
            }
            stmt.setString(18, cor_ta.getText().trim());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this,"Registration Completed Successfully!");
            reg_no++;
            backdata.backup("Registration");
            //update automatic table
            if(reg_tf.getText().length()==18&& reg_tf.getText().equalsIgnoreCase(reg_str)){
                stmt=con.prepareStatement("update automatic set reg_no=?");
                stmt.setInt(1, reg_no-1);
                stmt.executeUpdate();
            }
            else{
                reg_no=reg_no-1;
            }
            backdata.backup("Automatic");

            //to open registrationInvoice after record insersation on submit click
            byte bkl=(byte) JOptionPane.showConfirmDialog(this, "Do you really want to Print this record?");
            if(bkl==0){
                String data[]={reg_tf.getText().trim(),sql.toString(),nam_tf.getText().trim(),fat_tf.getText().trim(),mot_tf.getText().trim(),sq.toString(),ema_tf.getText().trim(),con_tf.getText().trim(),pro_cb.getText().trim(),blo_cb.getSelectedItem().toString(),col_tf.getText().trim(),gen,per_ta.getText().trim(),dis_tf.getSelectedItem().toString(),sta_cb.getSelectedItem().toString(),cor_ta.getText().trim()};
                reset();
                new RegistrationDetails(data).setVisible(true);
            }
            else{
                reset();
            }
            autogen();
           //===================
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }   catch (FileNotFoundException ex) {
                Logger.getLogger(regEntryForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(regEntryForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (WriteException ex) {
                Logger.getLogger(regEntryForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
             Logger.getLogger(regEntryForm.class.getName()).log(Level.SEVERE, null, ex);
         }
    }   
        else
           JOptionPane.showMessageDialog(this, "Contact Number must be 10 digits!!"); 
    }
    else
        JOptionPane.showMessageDialog(this, "Please fill all the mandatory fields!");
    
    }//GEN-LAST:event_sub_btActionPerformed

    private void res_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_res_btActionPerformed
//        autogen();
        reset();
//        sub_bt.setEnabled(true);
    }//GEN-LAST:event_res_btActionPerformed

    private void datFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_datFocusLost
        
        boolean dt=dat.getDateFormatString().equals("DD/MM/YYY");
        if(dt)
        dat.setBorder(BorderFactory.createBevelBorder(4));
    }//GEN-LAST:event_datFocusLost

    
    private void nam_tfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nam_tfFocusGained
        regfg(nam_tf);

    }//GEN-LAST:event_nam_tfFocusGained

    private void nam_tfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nam_tfFocusLost
        if(nam_tf.getText().length()==0 || nam_tf.getText().equalsIgnoreCase("*Field is mandatory!"))
            regfl(nam_tf);
        else
            regKr(nam_tf);
    }//GEN-LAST:event_nam_tfFocusLost

    private void nam_tfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nam_tfKeyTyped
        regkt(evt,nam_tf);


    }//GEN-LAST:event_nam_tfKeyTyped

    private void tabFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabFocusGained
        
    }//GEN-LAST:event_tabFocusGained

    private void tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabMouseClicked
       //
        if(tab.getSelectedIndex()==0){
            this.getRootPane().setDefaultButton(sub_bt);
            fr_lb.setVisible(false);
            to_lb.setVisible(false);
            fr_dt.setVisible(false);
            to_dt.setVisible(false);
            reg_cb.setVisible(true);
            ser_cb.setVisible(false);
            ser_tf.setVisible(true);
        }
        else{
            this.getRootPane().setDefaultButton(ser_bt);
            fr_lb.setVisible(false);
            to_lb.setVisible(false);
            fr_dt.setVisible(false);
            to_dt.setVisible(false);
            ser_cb.setVisible(false);
            reg_cb.setVisible(true);            
            ser_tf.setVisible(true);
        }
    }//GEN-LAST:event_tabMouseClicked

    private void reg_cbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reg_cbActionPerformed
        
        url="select * from registration where ";
        if(reg_cb.getSelectedIndex()==3)
        {
            ser_cb.removeAllItems();
            try {
                stmt=con.prepareStatement("select distinct BLOOD_GRP from registration");
                rs=stmt.executeQuery();
                while(rs.next())
                    ser_cb.addItem(rs.getString(1));
            } catch (SQLException ex) {
                Logger.getLogger(regEntryForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            ser_tf.setVisible(false);
            ser_cb.setVisible(true);
            ser_cb.requestFocus();
            url=url+"upper(BLOOD_GRP)=?";
        }   
        else if(reg_cb.getSelectedIndex()==4)
        {
            ser_cb.removeAllItems();
            try {
                stmt=con.prepareStatement("select distinct PROG from registration");
                rs=stmt.executeQuery();
                while(rs.next())
                ser_cb.addItem(rs.getString(1));
            } catch (SQLException ex) {
                Logger.getLogger(regEntryForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            ser_tf.setVisible(false);
            ser_cb.setVisible(true);
            ser_cb.requestFocus();
            url=url+"upper(PROG)=?";
        }
        else
        {
            ser_tf.requestFocus();
            ser_tf.setVisible(true);
            ser_cb.setVisible(false);
            if(reg_cb.getSelectedIndex()==0)
                 url=url+"upper(REG_NO)=?";
            else if(reg_cb.getSelectedIndex()==1){
                 url=url+"upper(SNAME)=?";
            }
            else if(reg_cb.getSelectedIndex()==2)
                 url=url+"upper(CONT_NO)=?";
            else if(reg_cb.getSelectedIndex()==5)
                 url=url+"upper(CLG_NAME)=?";
        }
    }//GEN-LAST:event_reg_cbActionPerformed

    private void pho_btFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pho_btFocusGained
        
        ph.setBorder(new LineBorder(Color.BLACK));
        pho_bt.setBackground(new java.awt.Color(42,180,118));
    }//GEN-LAST:event_pho_btFocusGained

    private void pho_btFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pho_btFocusLost
        
        if(f1==null)
            ph.setBorder(new LineBorder(Color.red));
        pho_bt.setBackground(new java.awt.Color(0,116,226));
    }//GEN-LAST:event_pho_btFocusLost

    private void aad_btFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_aad_btFocusLost
        
        aad_bt.setBackground(new java.awt.Color(0,116,226));
    }//GEN-LAST:event_aad_btFocusLost

    private void aad_btFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_aad_btFocusGained
        
         aad_bt.setBackground(new java.awt.Color(42,180,118));
    }//GEN-LAST:event_aad_btFocusGained

    private void sub_btFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sub_btFocusGained
        
         sub_bt.setBackground(new java.awt.Color(42,180,118));
    }//GEN-LAST:event_sub_btFocusGained

    private void sub_btFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sub_btFocusLost
        
        sub_bt.setBackground(new java.awt.Color(0,116,226));
    }//GEN-LAST:event_sub_btFocusLost

    private void cor_taFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cor_taFocusGained
        
         tafg(cor_ta);
    }//GEN-LAST:event_cor_taFocusGained

    private void cor_taFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cor_taFocusLost
       if(cor_ta.getText().length()==0)
             tafl(cor_ta);
        else
            regflta(cor_ta);
    }//GEN-LAST:event_cor_taFocusLost
    public void disp()
    {
        try
        {
                 ser_reg.setText(rs.getString(1));
                 ser_dor.setText(f.format(rs.getDate(2)));
                  ser_nam.setText(rs.getString(3));
                  ser_fat.setText(rs.getString(4));
                  ser_mot.setText(rs.getString(5));
                  ser_dob.setDate(rs.getDate(6));
                  ser_ema.setText(rs.getString(7));
                  ser_cont.setText(rs.getString(8));
                  ser_pro.setText(rs.getString(9));
                  ser_bg.setText(rs.getString(10));
                  ser_clg.setText(rs.getString(11));
                  ser_gen.setText(rs.getString(12));
                  ser_perta.setText(rs.getString(13));
                  ser_dis.setText(rs.getString(14));
                  ser_sta.setText(rs.getString(15));
                  b=rs.getBlob(16);
                  if(b!=null){
                   byte []pic=b.getBytes(1,(int)b.length());
                   img=new ImageIcon(new ImageIcon(pic).getImage().getScaledInstance(ser_ph.getWidth(),ser_ph.getHeight(),Image.SCALE_SMOOTH));
                   ser_ph.setIcon(img);
                  }
                  else
                      ser_ph.setIcon(null);
                  c=rs.getBlob(17);
                  if(c!=null){
                   byte []aad=c.getBytes(1,(int)c.length());
                   img2=new ImageIcon(new ImageIcon(aad).getImage().getScaledInstance(ser_adh.getWidth(),ser_adh.getHeight(),Image.SCALE_SMOOTH));
                   ser_adh.setIcon(img2);
                  }
                  else
                      ser_adh.setIcon(null);
                  ser_corta.setText(rs.getString(18)); 
        }
        catch(SQLException e){
            Logger.getLogger(regEntryForm.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    private void UpdateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UpdateFocusGained
        
    }//GEN-LAST:event_UpdateFocusGained

    private void UpdateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UpdateFocusLost
        
    }//GEN-LAST:event_UpdateFocusLost

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
     if(ser_nam.getText().equals("*Field is mandatory!")||ser_fat.getText().equals("*Field is mandatory!")||ser_mot.getText().equals("*Field is mandatory!")||ser_cont.getText().equals("*Field is mandatory!")||ser_clg.getText().equals("*Field is mandatory!")||ser_corta.getText().equals("*Field is mandatory!")||ser_mot.getText().equals("*Field is mandatory!")||ser_cont.getText().equals("*Field is mandatory!")||ser_clg.getText().equals("*Field is mandatory!")||ser_perta.getText().equals("*Field is mandatory!")||ser_dis.getText().equals("*Field is mandatory!")||ser_pro.getText().equals("*Field is mandatory!")||ser_dob.equals("*Field is mandatory!"))
         h=false;
     else if(ser_nam.getText().isEmpty()||ser_fat.getText().isEmpty()||ser_mot.getText().isEmpty()||ser_cont.getText().isEmpty()||ser_clg.getText().isEmpty()||ser_perta.getText().isEmpty()||ser_dis.getText().isEmpty()||ser_corta.getText().isEmpty()||ser_cont.getText().length()<10){
        h=false;   
     }
     if(h==true){
        byte a=(byte) JOptionPane.showConfirmDialog(this, "Do you really want to update this record?");
        if(a==0){
        try {
            stmt=con.prepareStatement("update registration set SNAME=?, FNAME=?, MNAME=?, SDOB=?, EMAIL=?,CONT_NO=?, PROG=?, BLOOD_GRP=?,CLG_NAME=?, GENDER=?, PRMT_ADD=?, DIS=?, STT=?, SPHOTO=?, AADHAR=?,COR_ADD=? where REG_NO=?");
            stmt.setString(1, ser_nam.getText().trim());
            stmt.setString(2, ser_fat.getText().trim());
            stmt.setString(3, ser_mot.getText().trim());
            String s=((JTextField)ser_dob.getDateEditor().getUiComponent()).getText();
            DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
            java.sql.Date sql=null;
            java.util.Date date=df.parse(s);
            sql=new java.sql.Date(date.getTime());
            stmt.setDate(4,sql);
            stmt.setString(5, ser_ema.getText().trim());
            stmt.setString(6, ser_cont.getText().trim());
            stmt.setString(7, ser_pro.getText().trim());
            stmt.setString(8, ser_bg.getText().trim());
            stmt.setString(9, ser_clg.getText().trim());
            stmt.setString(10, ser_gen.getText().trim());
            stmt.setString(11, ser_perta.getText().trim());
            stmt.setString(12, ser_dis.getText().trim());
            stmt.setString(13, ser_sta.getText().trim());
            stmt.setString(16, ser_corta.getText().trim());
            if(f1==null)
                stmt.setBlob(14,b);
            else
            {
                 fin=new FileInputStream(f1);
                 stmt.setBinaryStream(14,fin,fin.available());
            }
            if(f2==null)
                stmt.setBlob(15,c);
            else
            {
                fin=new FileInputStream(f2);
                stmt.setBinaryStream(15,fin,fin.available());
            }
            stmt.setString(17,ser_reg.getText().trim());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record updated successfully!");
            backdata.backup("Registration");
            backdata.backup("Automatic");
        } catch (SQLException ex) {
            Logger.getLogger(regEntryForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(regEntryForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(regEntryForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WriteException ex) {
            Logger.getLogger(regEntryForm.class.getName()).log(Level.SEVERE, null, ex);
        }   catch (ParseException ex) {
                Logger.getLogger(regEntryForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     }
     else
        JOptionPane.showMessageDialog(this, "Please fill all the mendatory fields!");
    }//GEN-LAST:event_UpdateActionPerformed

    private void NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextActionPerformed
        try {
            
            if(rs.isLast())
                JOptionPane.showMessageDialog(this,"You are already at last record");
            else
            {
                  rs.next();
                  disp();
            }
        } catch (SQLException ex) {
            Logger.getLogger(regEntryForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_NextActionPerformed

    private void ser_contKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ser_contKeyTyped
               char ch=evt.getKeyChar();
      if(evt.getKeyChar()=='0'&& ser_cont.getCaretPosition()==0) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
      }
       else if(ser_cont.getText().length()>=10)
        {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        else if(!(ch>='0'&& ch<='9'|| ch==8))
        {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
       
    }//GEN-LAST:event_ser_contKeyTyped

    private void ser_namFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ser_namFocusGained
        regfg(ser_nam);
    }//GEN-LAST:event_ser_namFocusGained

    private void ser_namFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ser_namFocusLost
        if(ser_nam.getText().length()==0 || ser_nam.getText().equalsIgnoreCase("*Field is mandatory!"))
            regfl(ser_nam);
        else
            regKr(ser_nam);
    }//GEN-LAST:event_ser_namFocusLost

    private void ser_fatFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ser_fatFocusGained
         regfg(ser_fat);
    }//GEN-LAST:event_ser_fatFocusGained

    private void ser_fatFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ser_fatFocusLost
         if(ser_fat.getText().length()==0)
        regfl(ser_fat);
      else
         regKr(ser_fat);
    }//GEN-LAST:event_ser_fatFocusLost

    private void ser_motFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ser_motFocusGained
         regfg(ser_mot);
    }//GEN-LAST:event_ser_motFocusGained

    private void ser_motFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ser_motFocusLost
         if(ser_mot.getText().length()==0)
        regfl(ser_mot);
      else
         regKr(ser_mot);
    }//GEN-LAST:event_ser_motFocusLost

    private void ser_emaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ser_emaFocusGained
        ser_ema.setBorder(new LineBorder(Color.black));
        serlb.setText("");
    }//GEN-LAST:event_ser_emaFocusGained

    private void ser_emaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ser_emaFocusLost
//         regfl(ser_ema);
        String last[] = {".com", ".org",".in", ".net", ".edu", ".gov", ".mil", ".biz", ".info", ".pro", ".name", ".coop", ".aero", ".museum", ".asia", ".cat", ".jobs", ".mobi", ".tel", ".travel", ".xxx", ".arpa", ".int", ".post", ".root", ".test"};
        serlb.setForeground(Color.red);
        String str = ser_ema.getText();
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
              serlb.setText("*Please enter a valid email Id!");  
            if (emailchk)
            {
                if(str.contains("@"))
                {
                    byte index1=(byte) str.indexOf("@");
                    byte index2=(byte) str.indexOf(".");
                    if (index2==(index1+1))
                    {
                        ser_ema.setBorder(new LineBorder(Color.red));
                        Toolkit.getDefaultToolkit().beep();
                        serlb.setText("*Please enter a valid email Id!");
                    }
                    else
                    serlb.setText("");

                }
                else
                {
                    ser_ema.setBorder(new LineBorder(Color.red));
                    Toolkit.getDefaultToolkit().beep();
                    serlb.setText("*Please enter a valid email Id!");
                }
            }
            else{
                ser_ema.setBorder(new LineBorder(Color.red));
                Toolkit.getDefaultToolkit().beep();
                serlb.setText("*Please enter a valid email Id!");
            }
        }
        else
         serlb.setText("");
    }//GEN-LAST:event_ser_emaFocusLost

    private void ser_contFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ser_contFocusLost
         regfl(ser_cont);
    }//GEN-LAST:event_ser_contFocusLost

    private void ser_contFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ser_contFocusGained
        regfg(ser_cont);
    }//GEN-LAST:event_ser_contFocusGained

    private void ser_proFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ser_proFocusGained
         regfg(ser_pro);
    }//GEN-LAST:event_ser_proFocusGained

    private void ser_proFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ser_proFocusLost
        if(ser_pro.getText().length()==0)
        regfl(ser_pro);
      else
         regKr(ser_pro);
    }//GEN-LAST:event_ser_proFocusLost

    private void ser_clgFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ser_clgFocusLost
        if(ser_clg.getText().length()==0)
        regfl(ser_clg);
        else
         regKr(ser_clg);
    }//GEN-LAST:event_ser_clgFocusLost

    private void ser_clgFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ser_clgFocusGained
        regfg(ser_clg);
    }//GEN-LAST:event_ser_clgFocusGained

    private void ser_genFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ser_genFocusGained
        regfg(ser_gen);
    }//GEN-LAST:event_ser_genFocusGained

    private void ser_genFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ser_genFocusLost
        regfl(ser_gen);
    }//GEN-LAST:event_ser_genFocusLost

    private void ser_disFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ser_disFocusLost
        regfl(ser_dis);
    }//GEN-LAST:event_ser_disFocusLost

    private void ser_disFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ser_disFocusGained
        regfg(ser_dis);
    }//GEN-LAST:event_ser_disFocusGained

    private void ser_staFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ser_staFocusGained
        regfg(ser_sta);
    }//GEN-LAST:event_ser_staFocusGained

    private void ser_staFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ser_staFocusLost
        regfl(ser_sta);
    }//GEN-LAST:event_ser_staFocusLost

    private void ser_tfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ser_tfKeyTyped
         char ch=evt.getKeyChar();
        if(reg_cb.getSelectedIndex()==2){
           
             if(ser_tf.getText().length()>=10)
            {
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
            }
            if(!(ch>='0'&& ch<='9'|| ch==8))
            {
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
            }
        }
        else if(reg_cb.getSelectedIndex()==0){ 
            if(ser_tf.getText().length()>=18)
            {
                 evt.consume();
                Toolkit.getDefaultToolkit().beep();
            }
            else if(!(ch>='0' && ch<='9' || ch>='A'&& ch<='Z'||ch>='a'&&ch<='z'|| ch=='/'||ch==8))
            {
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
            }
        }
        else if(reg_cb.getSelectedIndex()==1){
            regkt(evt,ser_tf);
        }
    }//GEN-LAST:event_ser_tfKeyTyped

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        
         byte a;
        if(ser_reg.getText().length()==18){
         a=(byte) JOptionPane.showConfirmDialog(this, "Do you really want to delete this record?");
        if(a==0){
            try {
            
            stmt=con.prepareStatement("delete from registration where REG_NO=?");
            stmt.setString(1, ser_reg.getText());
            stmt.executeUpdate();
            serDel();
            JOptionPane.showMessageDialog(this, "Record deleted!");
              backdata.backup("Registration");
              backdata.backup("Automatic");
        } catch (SQLException ex) {
            Logger.getLogger(regEntryForm.class.getName()).log(Level.SEVERE, null, ex);
        }    catch (WriteException ex) {
                 Logger.getLogger(regEntryForm.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
     }   
    }//GEN-LAST:event_DeleteActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        serDel();
        fr_lb.setVisible(false);
        to_lb.setVisible(false);
        fr_dt.setVisible(false);
        to_dt.setVisible(false);
        ser_cb.setVisible(true);
        reg_cb.setVisible(true);
        ser_tf.setVisible(true);
        Delete.setVisible(false);
        Update.setVisible(false);
        ser_lb.setVisible(false);
        reg_cb.setSelectedIndex(2);
        ser_tf.setText("");
    }//GEN-LAST:event_cancelActionPerformed

    private void PreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousActionPerformed
        try {
           
            if(rs.isFirst())
                JOptionPane.showMessageDialog(this,"You are already at first record");
            else
            {
                  rs.previous();
                  disp();
            }
        } catch (SQLException ex) {
            Logger.getLogger(regEntryForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_PreviousActionPerformed

    private void ser_addupdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ser_addupdActionPerformed
        
        JFileChooser ch=new JFileChooser();
        ch.showOpenDialog(this);
        f2 = ch.getSelectedFile();
        img=new ImageIcon(new ImageIcon(""+f2).getImage().getScaledInstance(ser_adh.getWidth(), ser_adh.getHeight(),Image.SCALE_SMOOTH));
        ser_adh.setIcon(img);
    }//GEN-LAST:event_ser_addupdActionPerformed

    private void ser_phupdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ser_phupdActionPerformed
        
         JFileChooser ch=new JFileChooser();
        ch.showOpenDialog(this);
        f1 = ch.getSelectedFile();
        img=new ImageIcon(new ImageIcon(""+f1).getImage().getScaledInstance(ser_ph.getWidth(), ser_ph.getHeight(),Image.SCALE_SMOOTH));
        ser_ph.setIcon(img);
    }//GEN-LAST:event_ser_phupdActionPerformed

    private void lastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastActionPerformed
    try {
            
            if(rs.isLast())
                JOptionPane.showMessageDialog(this,"You are already at last record");
            else
            {
                  rs.last();
                  disp();
            }
        } catch (SQLException ex) {
            Logger.getLogger(regEntryForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lastActionPerformed

    private void firstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstActionPerformed
        try {
           
            if(rs.isFirst())
                JOptionPane.showMessageDialog(this,"You are already at first record!");
            else
            {
                  rs.first();
                  disp();
            }
        } catch (SQLException ex) {
            Logger.getLogger(regEntryForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_firstActionPerformed

    private void ser_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ser_btActionPerformed
        if(fr_dt.isVisible()){
            Date dt=null,dt1=null;
//            if(dt.compareTo(dt1)>0){
//                JOptionPane.showMessageDialog(this,"From Date Must be Before To Date!");
//            }
//            else{
                try {
                    stmt=con.prepareStatement("select * from registration where reg_date >=? and reg_date<=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
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
                    if(rs.next()){
                        if(rol==1){
                            Delete.setVisible(false);}
                        else if(rol==0){
                            Delete.setVisible(true);}
                        Update.setVisible(true);
                        cancel.setVisible(true);
                        ser_lb.setVisible(true);
                        disp();
                    }
                    else
                        JOptionPane.showMessageDialog(this, "No Record found!");
                } catch (SQLException ex) {
                    Logger.getLogger(regEntryForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(regEntryForm.class.getName()).log(Level.SEVERE, null, ex);
                }
//            }
        }
        else{
            try {
                stmt=con.prepareStatement(url,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                if(ser_cb.isVisible())
                    stmt.setString(1,ser_cb.getSelectedItem().toString().trim().toUpperCase());
                else
                    stmt.setString(1,ser_tf.getText().toUpperCase().trim());
                rs=stmt.executeQuery();
                if(rs.next()){
                    if(rol==1){
                        Delete.setVisible(false);}
                    else if(rol==0){
                        Delete.setVisible(true);}
                    Update.setVisible(true);
                    cancel.setVisible(true);
                    ser_lb.setVisible(true);
                    disp();
                }
                else
                JOptionPane.showMessageDialog(this, "No Record found!");

            } catch (SQLException ex) {
                Logger.getLogger(regEntryForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_ser_btActionPerformed

    private void ser_namKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ser_namKeyTyped
         regkt(evt,ser_nam);
    }//GEN-LAST:event_ser_namKeyTyped

    private void ser_fatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ser_fatKeyTyped
        regkt(evt,ser_fat);
    }//GEN-LAST:event_ser_fatKeyTyped

    private void ser_motKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ser_motKeyTyped
        regkt(evt,ser_mot);
    }//GEN-LAST:event_ser_motKeyTyped

    private void ser_emaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ser_emaKeyTyped
        char ch=evt.getKeyChar();
        if(((evt.getKeyChar()==' ')||evt.getKeyChar()=='.')&& ser_ema.getCaretPosition()==0)
        {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        else if(!(ch>=65&& ch<=90 || ch>=97 && ch<=122 ||ch>='0' && ch<='9'|| ch=='@'||ch=='.'))
        {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
         else if(ch=='8'||((ch>=65 && ch<=90)|| (ch>=97 && ch<=122||ch>='0' && ch<='9'|| ch=='@'))) 
             dot=0;
        else if((evt.getKeyChar()=='.' )&& dot==0)
            dot=1;
        else {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();}
    }//GEN-LAST:event_ser_emaKeyTyped

    private void ema_tfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ema_tfKeyReleased
          String str=ema_tf.getText();
         if(str.length()>0)
         ema_tf.setText(str.toLowerCase());
    }//GEN-LAST:event_ema_tfKeyReleased

    private void pro_cbFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pro_cbFocusLost
        regfl(pro_cb);
    }//GEN-LAST:event_pro_cbFocusLost

    private void pro_cbFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pro_cbFocusGained
         regfg(pro_cb);
    }//GEN-LAST:event_pro_cbFocusGained

    private void ser_emaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ser_emaKeyReleased
        String str=ser_ema.getText();
         if(str.length()>0)
         ser_ema.setText(str.toLowerCase());
    }//GEN-LAST:event_ser_emaKeyReleased

    private void ser_bgFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ser_bgFocusLost
        regfl(ser_bg);
    }//GEN-LAST:event_ser_bgFocusLost

    private void ser_bgFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ser_bgFocusGained
        regfg(ser_bg);
    }//GEN-LAST:event_ser_bgFocusGained

    private void ser_cortaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ser_cortaFocusLost
    if(ser_corta.getText().length()==0)
            tafl(ser_corta); 
        else
            regflta(ser_corta);
    }//GEN-LAST:event_ser_cortaFocusLost

    private void ser_cortaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ser_cortaFocusGained
        tafg(ser_corta);
    }//GEN-LAST:event_ser_cortaFocusGained

    private void ser_pertaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ser_pertaFocusGained
        tafg(ser_perta);
    }//GEN-LAST:event_ser_pertaFocusGained

    private void ser_pertaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ser_pertaFocusLost
        if(ser_perta.getText().length()==0)
            tafl(ser_perta); 
        else
            regflta(ser_perta);
    }//GEN-LAST:event_ser_pertaFocusLost

    private void sta_cbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sta_cbActionPerformed
        String kk=(String) sta_cb.getSelectedItem();
        dis_tf.removeAllItems();
        stadist(kk);
    }//GEN-LAST:event_sta_cbActionPerformed

    private void reg_tfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_reg_tfFocusLost
        if(reg_tf.isEditable())
            try {
                stmt=con.prepareStatement("select * from registration where upper(reg_no)=?");
                stmt.setString(1, reg_tf.getText().toUpperCase().trim());
                rs=stmt.executeQuery();
                if(rs.next())
                    JOptionPane.showMessageDialog(this, "Registration Already Exists!");
            } catch (SQLException ex) {
                Logger.getLogger(regEntryForm.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_reg_tfFocusLost

    private void ser_regFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ser_regFocusLost
        try {
            stmt=con.prepareStatement("select * from registration where reg_no=?");
            stmt.setString(1, reg_tf.getText().trim());
            rs=stmt.executeQuery();
            if(rs.next())
                JOptionPane.showMessageDialog(this, "Registration Number Already Exits!");
        } catch (SQLException ex) {
            Logger.getLogger(regEntryForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ser_regFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            stmt=con.prepareStatement("select * from registration where upper(reg_no)=?");
            stmt.setString(1, ser_reg.getText().toUpperCase());
            rs1=stmt.executeQuery();
            if(rs1.next()){
                String data[]={rs1.getString(1),String.valueOf(rs1.getDate(2)),rs1.getString(3),rs1.getString(4),rs1.getString(5),String.valueOf(rs1.getDate(6)),rs1.getString(7),rs1.getString(8),rs1.getString(9),rs1.getString(10),rs1.getString(11),rs1.getString(12),rs1.getString(13),rs1.getString(14),rs1.getString(15),rs1.getString(18)};
                new RegistrationDetails(data).setVisible(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(regEntryForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        this.dispose();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void pro_cbKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pro_cbKeyTyped
        char ch=evt.getKeyChar();
        if(((ch==' '||ch=='.')&& pro_cb.getCaretPosition()==0))
        {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        
         if (!((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || ch == '(' || ch == ')' ||ch==' '||ch=='.')) {
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
    }//GEN-LAST:event_pro_cbKeyTyped

    private void ser_proKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ser_proKeyTyped
        char ch=evt.getKeyChar();
        if(((ch==' '||ch=='.')&& pro_cb.getCaretPosition()==0))
        {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        
         if (!((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || ch == '(' || ch == ')' ||ch==' '||ch=='.')) {
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
    }//GEN-LAST:event_ser_proKeyTyped

    private void ser_clgKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ser_clgKeyTyped
        regkt(evt,ser_clg);
    }//GEN-LAST:event_ser_clgKeyTyped

    private void ser_genKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ser_genKeyTyped
    regkt(evt,ser_gen);
    }//GEN-LAST:event_ser_genKeyTyped

    private void ser_disKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ser_disKeyTyped
        regkt(evt,ser_dis);
    }//GEN-LAST:event_ser_disKeyTyped

    private void ser_pertaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ser_pertaKeyTyped
char ch=evt.getKeyChar();
        if((evt.getKeyChar()==' '||evt.getKeyChar()=='.'||evt.getKeyChar()==9) && ser_perta.getCaretPosition()==0)
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
    }//GEN-LAST:event_ser_pertaKeyTyped

    private void ser_cortaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ser_cortaKeyTyped
        char ch=evt.getKeyChar();
        if((evt.getKeyChar()==' '||evt.getKeyChar()=='.'||evt.getKeyChar()==9) && ser_corta.getCaretPosition()==0)
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
    }//GEN-LAST:event_ser_cortaKeyTyped

    private void ser_staKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ser_staKeyTyped
        regkt(evt,ser_sta);
    }//GEN-LAST:event_ser_staKeyTyped

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        fr_lb.setVisible(true);
        to_lb.setVisible(true);
        fr_dt.setVisible(true);
        to_dt.setVisible(true);
        reg_cb.setVisible(false);
        ser_cb.setVisible(false);
        ser_tf.setVisible(false);
        fr_dt.setDate(new java.sql.Date(System.currentTimeMillis()));
        to_dt.setDate(new java.sql.Date(System.currentTimeMillis()));
    }//GEN-LAST:event_jButton7ActionPerformed

    private void dobFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dobFocusLost
        // TODO add your handling code here
        Date str=(Date) dob.getDate();
        if(str.equals(null)) {
            dob.setBorder(BorderFactory.createLineBorder(Color.red));
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_dobFocusLost

    private void dobFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dobFocusGained

        dob_lb.setText("");
    }//GEN-LAST:event_dobFocusGained
    public void regflta(JTextArea a){
         String str[]=a.getText().split(" ");
         String res="";
         for(String t:str)
             res=res+(t.substring(0,1).toUpperCase()+t.substring(1,t.length()).toLowerCase())+" ";
         a.setText(res);
    }
    
    public void regKr(JTextField d){
         String str[]=d.getText().split(" ");
         String res="";
         for(String t:str)
             res=res+(t.substring(0,1).toUpperCase()+t.substring(1,t.length()).toLowerCase())+" ";
         d.setText(res);
    }
     
    public void regkt(KeyEvent e,JTextField c)
    {
        char ch=e.getKeyChar();
        if(((e.getKeyChar()==' '||e.getKeyChar()=='.')&& c.getCaretPosition()==0))
        {
            e.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        
        else if(!(ch>=65&& ch<=90 || ch>=97 && ch<=122 || ch==' '||ch=='.'||ch==8))
        {
            e.consume();
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
        else if(((e.getKeyChar()==' ')&& ctr==0))
            ctr=1;
         else if(e.getKeyChar()=='.'&&dot==0)
            dot=1;
        else {
            e.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }
    public void valchk(){
        regfl(nam_tf);
        regfl(fat_tf);
        regfl(mot_tf);
        regfl(col_tf);
        regfl(con_tf);
        tafl(cor_ta);
        tafl(per_ta);
        regfl(pro_cb);
    }
    public void regfg(JTextField fg){
          String str=fg.getText();
        if(str.equalsIgnoreCase("*Field is mandatory!")||str.isEmpty())
        {
            fg.setForeground(Color.black);
            fg.setText("");
            fg.setBorder(new LineBorder(Color.black));
        }
        else if(fg.equals(con_tf)){
             fg.setForeground(Color.black);
            fg.setBorder(new LineBorder(Color.black));
            con_lb.setText("");
          }
    }
    public void regfl(JTextField fl){
        
        if(fl.getText().length()==0)
        {
            fl.setForeground(Color.red);
            fl.setText("*Field is mandatory!");
            fl.setBorder(new LineBorder(Color.red));
            Toolkit.getDefaultToolkit().beep();
        }
        else if(fl.equals(con_tf)){
            if(fl.getText().length()<10){
             con_lb.setText("*contact no. must be 10 digits!");
             con_tf.setBorder(new LineBorder(Color.red));
            }   
          }
    }
    
    public void tafg(JTextArea tfg){
         String str=tfg.getText();
        if(str.equals("*Field is mandatory!")||str.isEmpty())
        {
            tfg.setForeground(Color.black);
            tfg.setText("");
            tfg.setBorder(new LineBorder(Color.black));
        } 
       
    }
    public void tafl(JTextArea tfl){
        String str=tfl.getText();
        if(str.trim().length()==0)
        {
            tfl.setForeground(Color.red);
            tfl.setText("*Field is mandatory!");
            tfl.setBorder(new LineBorder(Color.red));
            Toolkit.getDefaultToolkit().beep();
        }
    }

    public void cbfg(JComboBox cbfg){
        cbfg.setBorder(new LineBorder(Color.black));
    }
    public void stadist(String kk){
        try {
            stmt=con.prepareStatement("select distr from state1 where stat=?");
            stmt.setString(1, kk);
            rs=stmt.executeQuery();
            if(rs.next()){
                String jk=rs.getString(1);
                for(String a:jk.split(","))
                        dis_tf.addItem(a);
            }
            if(kk=="Bihar"){
                dis_tf.setSelectedItem("Patna");
            }
        } catch (SQLException ex) {
            Logger.getLogger(regEntryForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
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
//            java.util.logging.Logger.getLogger(regEntryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(regEntryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(regEntryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(regEntryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() { 
//            public void run() {
//                try {
//                    new regEntryForm().setVisible(true);
//                } catch (SQLException ex) {
//                    Logger.getLogger(regEntryForm.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (ParseException ex) {
//                    Logger.getLogger(regEntryForm.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Delete;
    private javax.swing.JButton Next;
    private javax.swing.JButton Previous;
    private javax.swing.JButton Update;
    private javax.swing.JButton aad_bt;
    private javax.swing.JLabel aad_ph;
    private javax.swing.JRadioButton add_rb;
    private javax.swing.JRadioButton bin_rb;
    private javax.swing.JComboBox<String> blo_cb;
    private javax.swing.JButton cancel;
    private javax.swing.JTextField col_tf;
    private javax.swing.JLabel con_lb;
    private javax.swing.JLabel con_lb1;
    private javax.swing.JTextField con_tf;
    private javax.swing.JTextArea cor_ta;
    private com.toedter.calendar.JDateChooser dat;
    private javax.swing.JComboBox<String> dis_tf;
    private com.toedter.calendar.JDateChooser dob;
    private javax.swing.JLabel dob_lb;
    private javax.swing.JTextField ema_tf;
    private javax.swing.JTextField fat_tf;
    private javax.swing.JRadioButton fem_rb;
    private javax.swing.JButton first;
    private com.toedter.calendar.JDateChooser fr_dt;
    private javax.swing.JLabel fr_lb;
    private javax.swing.JLabel gen_rb;
    private javax.swing.JLabel gen_rb1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
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
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JButton last;
    private javax.swing.JLabel lb;
    private javax.swing.JRadioButton mal_rb;
    private javax.swing.JTextField mot_tf;
    private javax.swing.JTextField nam_tf;
    private javax.swing.JTextArea per_ta;
    private javax.swing.JLabel ph;
    private javax.swing.JButton pho_bt;
    private javax.swing.JTextField pro_cb;
    private javax.swing.JComboBox<String> reg_cb;
    private javax.swing.JTextField reg_tf;
    private javax.swing.JButton res_bt;
    private javax.swing.JButton ser_addupd;
    private javax.swing.JLabel ser_adh;
    private javax.swing.JTextField ser_bg;
    private javax.swing.JButton ser_bt;
    private javax.swing.JComboBox<String> ser_cb;
    private javax.swing.JTextField ser_clg;
    private javax.swing.JTextField ser_cont;
    private javax.swing.JTextArea ser_corta;
    private javax.swing.JTextField ser_dis;
    private com.toedter.calendar.JDateChooser ser_dob;
    private javax.swing.JTextField ser_dor;
    private javax.swing.JTextField ser_ema;
    private javax.swing.JTextField ser_fat;
    private javax.swing.JTextField ser_gen;
    private javax.swing.JPanel ser_lb;
    private javax.swing.JTextField ser_mot;
    private javax.swing.JTextField ser_nam;
    private javax.swing.JTextArea ser_perta;
    private javax.swing.JLabel ser_ph;
    private javax.swing.JButton ser_phupd;
    private javax.swing.JTextField ser_pro;
    private javax.swing.JTextField ser_reg;
    private javax.swing.JTextField ser_sta;
    private org.jdesktop.swingx.JXSearchField ser_tf;
    private javax.swing.JLabel serlb;
    private javax.swing.JComboBox<String> sta_cb;
    private javax.swing.JButton sub_bt;
    private javax.swing.JTabbedPane tab;
    private javax.swing.JPanel tab2;
    private com.toedter.calendar.JDateChooser to_dt;
    private javax.swing.JLabel to_lb;
    // End of variables declaration//GEN-END:variables
}
