package raysproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import jxl.write.Label;

public class ForgotPassword extends javax.swing.JFrame {
    Connection con;
    PreparedStatement stmt;
    ResultSet rs;
    Label l;
    boolean flag1=true,flag2=true,flag3=true,create,chk=true;
    byte ctr=0,kk;
    String usid,answer,combo;
    public ForgotPassword() throws SQLException {
        initComponents();
        con=ConnDb.conLink();
        setTitle("Forgot Password");
        Image icon=Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/icon/repl_logo_(1)-small.png"));
        this.setIconImage(icon);
        use_tf.requestFocus();
        hide_pswd.setVisible(false);
        rep_tf.setEditable(false);
        this.setLocationRelativeTo(null);
        this.getRootPane().setDefaultButton(create_bt);
        msg.setVisible(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kg_p = new keeptoo.KGradientPanel();
        jPanel1 = new javax.swing.JPanel();
        pswd_tf = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        create_bt = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        use_tf = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        rep_tf = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        ans_tf = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        sec_box = new javax.swing.JComboBox<>();
        frg_lb = new javax.swing.JLabel();
        clear_bt = new javax.swing.JButton();
        pic = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        hint = new javax.swing.JLabel();
        show_pswd = new javax.swing.JLabel();
        hide_pswd = new javax.swing.JLabel();
        mismatch_lb = new javax.swing.JLabel();
        sec_lb = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pswd_lb = new javax.swing.JLabel();
        msg = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        kg_p.setkGradientFocus(1350);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 51), 0, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pswd_tf.setEditable(false);
        pswd_tf.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pswd_tf.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 102, 255)));
        pswd_tf.setNextFocusableComponent(rep_tf);
        pswd_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pswd_tfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                pswd_tfFocusLost(evt);
            }
        });
        pswd_tf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pswd_tfKeyTyped(evt);
            }
        });
        jPanel1.add(pswd_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 310, 26));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("NEW PASSWORD");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, -1, -1));

        create_bt.setBackground(new java.awt.Color(51, 51, 255));
        create_bt.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        create_bt.setForeground(new java.awt.Color(255, 255, 255));
        create_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        create_bt.setText("CREATE");
        create_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_btActionPerformed(evt);
            }
        });
        jPanel1.add(create_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 460, -1, 35));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("USER ID");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, -1, -1));

        use_tf.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        use_tf.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 102, 255)));
        use_tf.setNextFocusableComponent(sec_box);
        use_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                use_tfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                use_tfFocusLost(evt);
            }
        });
        use_tf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                use_tfKeyTyped(evt);
            }
        });
        jPanel1.add(use_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 310, 27));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("REPEAT PASSWORD");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 380, -1, -1));

        rep_tf.setEditable(false);
        rep_tf.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rep_tf.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 102, 255)));
        rep_tf.setNextFocusableComponent(create_bt);
        rep_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rep_tfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                rep_tfFocusLost(evt);
            }
        });
        rep_tf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rep_tfKeyTyped(evt);
            }
        });
        jPanel1.add(rep_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 410, 310, 26));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("SECURITY QUESTIONS");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, -1, -1));

        ans_tf.setEditable(false);
        ans_tf.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ans_tf.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 102, 255)));
        ans_tf.setNextFocusableComponent(pswd_tf);
        ans_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ans_tfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ans_tfFocusLost(evt);
            }
        });
        ans_tf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ans_tfKeyTyped(evt);
            }
        });
        jPanel1.add(ans_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 310, 27));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("ANSWER");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, -1, -1));

        sec_box.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sec_box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"What was Your favorite subject in high School?", "What is the Name of Your first Pet?", "What high school did you attend?", "What was your favorite food as a child?","Where did you go on your favorite vocation as a child?" }));
        sec_box.setName(""); // NOI18N
        sec_box.setNextFocusableComponent(ans_tf);
        sec_box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sec_boxActionPerformed(evt);
            }
        });
        jPanel1.add(sec_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 310, 30));

        frg_lb.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        frg_lb.setForeground(new java.awt.Color(153, 153, 153));
        frg_lb.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        frg_lb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/forgot.png"))); // NOI18N
        frg_lb.setText("FORGOT PASSWORD");
        jPanel1.add(frg_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 310, 60));

        clear_bt.setBackground(new java.awt.Color(255, 51, 51));
        clear_bt.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        clear_bt.setForeground(new java.awt.Color(255, 255, 255));
        clear_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/clear_1.png"))); // NOI18N
        clear_bt.setText("CLEAR");
        clear_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_btActionPerformed(evt);
            }
        });
        clear_bt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                clear_btKeyPressed(evt);
            }
        });
        jPanel1.add(clear_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 460, 110, 35));

        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pswd.jpeg"))); // NOI18N
        jPanel1.add(pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 290, 267));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/raysnewbg.png"))); // NOI18N
        jPanel1.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 130, 130));

        hint.setForeground(new java.awt.Color(153, 153, 153));
        hint.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        hint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hint.png"))); // NOI18N
        hint.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        hint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hintMouseClicked(evt);
            }
        });
        jPanel1.add(hint, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 300, 30, -1));

        show_pswd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/open1.png"))); // NOI18N
        show_pswd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                show_pswdMouseClicked(evt);
            }
        });
        jPanel1.add(show_pswd, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 330, 30, 30));

        hide_pswd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hide1.png"))); // NOI18N
        hide_pswd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hide_pswdMouseClicked(evt);
            }
        });
        jPanel1.add(hide_pswd, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 330, 30, 30));

        mismatch_lb.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        mismatch_lb.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(mismatch_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 440, 240, 10));

        sec_lb.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(sec_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, 140, 20));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("*");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, 10, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("*");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 10, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("*");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 150, 20, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("*");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, 20, -1));

        pswd_lb.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pswd_lb.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(pswd_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 360, 240, 20));

        msg.setBackground(new java.awt.Color(255, 0, 0));
        msg.setFont(new java.awt.Font("Serif", 1, 16)); // NOI18N
        msg.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(msg, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 463, 390, 40));

        javax.swing.GroupLayout kg_pLayout = new javax.swing.GroupLayout(kg_p);
        kg_p.setLayout(kg_pLayout);
        kg_pLayout.setHorizontalGroup(
            kg_pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kg_pLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        kg_pLayout.setVerticalGroup(
            kg_pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kg_pLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kg_p, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kg_p, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void clear_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_btActionPerformed
        refresh();
    }//GEN-LAST:event_clear_btActionPerformed
    private void ans_tfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ans_tfFocusLost
            flcheck(ans_tf);
            if(ans_tf.getText().equalsIgnoreCase(answer)&&sec_box.getSelectedItem().toString().equalsIgnoreCase(combo)){
                pswd_tf.setEditable(true);
                create=true;
            }
            else{
                create=false;
                kk=(byte) (kk+1);
                    if(kk<3){
                        msg.setText("Wrong Question or Answer, You have left "+String.valueOf(3-kk)+" Attempt!");
                        msg.setFont(new Font("Courier", Font.PLAIN, 14));
                        msg.setVisible(true);
                    }
                    else{
                       if(kk==3){
                            pswd_tf.setEditable(false);
                            use_tf.setEditable(false);
                            sec_box.setEnabled(false);
                            create_bt.setEnabled(false);
                            clear_bt.setEnabled(false);
                            ans_tf.setEditable(false);
                            pswd_tf.setText("");
                            rep_tf.setText("");
                           try {
                                stmt=con.prepareStatement("update signup set stat='0' where u_id=?");
                                stmt.setString(1, usid);
                                stmt.executeUpdate();
                           } catch (SQLException ex) {
                               Logger.getLogger(ForgotPassword.class.getName()).log(Level.SEVERE, null, ex);
                           }
                            msg.setText("Please Contact Super Admin for Change Password!");
                            msg.setFont(new Font("Courier", Font.PLAIN, 14));
                            msg.setVisible(true);
                        } 
                    }
            }  
    }//GEN-LAST:event_ans_tfFocusLost
    private void ans_tfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ans_tfFocusGained
        ans_tf.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLUE));
        fgcheck(ans_tf);
    }//GEN-LAST:event_ans_tfFocusGained
    private void use_tfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_use_tfFocusLost
        flcheck(use_tf);
        usid=use_tf.getText().trim();
        if(!(usid.isEmpty()||usid==null||usid.equalsIgnoreCase("*Field is mandatory"))){
            try {
                stmt=con.prepareStatement("select * from signup where u_id=?");
                stmt.setString(1, usid);
                rs=stmt.executeQuery();
                if(rs.next()){
                    stmt=con.prepareStatement("select * from signup where u_id=? and stat='1'");
                    stmt.setString(1, usid);
                    rs=stmt.executeQuery();
                    if(rs.next()){
                        ans_tf.setEditable(true);
                        answer=rs.getString(6);
                        combo=rs.getString(5);
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "Please wait for Approval!");
                        msg.setText("Please Contact Super Admin for Change Password!");
                        msg.setFont(new Font("Courier", Font.PLAIN, 14));
                        msg.setVisible(true);
                    }
                }
                else
                    JOptionPane.showMessageDialog(this, "User ID Doesn`t Exist!");
        } catch (SQLException ex) {
            Logger.getLogger(ForgotPassword.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_use_tfFocusLost
    private void use_tfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_use_tfFocusGained
        use_tf.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLUE));
        fgcheck(use_tf);
    }//GEN-LAST:event_use_tfFocusGained
    private void pswd_tfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pswd_tfFocusLost
        flcheck(pswd_tf);
        pswd_tf.setEchoChar('*');
        String str=new String(pswd_tf.getPassword());
        String str2=new String(rep_tf.getPassword());
        if(!(str.equalsIgnoreCase("*Field is Mandatory")))
            rep_tf.setEditable(true);
    }//GEN-LAST:event_pswd_tfFocusLost
    private void pswd_tfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pswd_tfFocusGained
        pswd_tf.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLUE));
        pswd_lb.setText("");
        pswd_tf.setEchoChar('*');
        fgcheck(pswd_tf);
    }//GEN-LAST:event_pswd_tfFocusGained
    private void rep_tfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rep_tfFocusLost
        flcheck(rep_tf);
        String str1=new String(pswd_tf.getPassword());
        String str2=new String(rep_tf.getPassword());
        if(!(str1.equals(str2)))
            mismatch_lb.setText("*Password doesn't match!");
    }//GEN-LAST:event_rep_tfFocusLost
    private void rep_tfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rep_tfFocusGained
        rep_tf.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLUE));
        fgcheck(rep_tf);
        rep_tf.setEchoChar('*');
        mismatch_lb.setText("");
    }//GEN-LAST:event_rep_tfFocusGained
    private void use_tfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_use_tfKeyTyped
        char ch=evt.getKeyChar();
        if(ch==' ')
        {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        else if(evt.getKeyChar()==8 && use_tf.getCaretPosition()==0)
        {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_use_tfKeyTyped
    private void clear_btKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_clear_btKeyPressed
        char ch=evt.getKeyChar();
        if(ch==10)
            refresh();
    }//GEN-LAST:event_clear_btKeyPressed
    private void show_pswdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_show_pswdMouseClicked
        show_pswd.setVisible(false);
        hide_pswd.setVisible(true);
        pswd_tf.setEchoChar((char)0);
        rep_tf.setEchoChar((char)0);
    }//GEN-LAST:event_show_pswdMouseClicked
    private void hide_pswdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hide_pswdMouseClicked
        show_pswd.setVisible(true);
        hide_pswd.setVisible(false);
        pswd_tf.setEchoChar('*');
        rep_tf.setEchoChar('*');
    }//GEN-LAST:event_hide_pswdMouseClicked
    private void ans_tfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ans_tfKeyTyped
        char ch=evt.getKeyChar();
        if(evt.getKeyChar()==' ' && ans_tf.getCaretPosition()==0||evt.getKeyChar()==8 && ans_tf.getCaretPosition()==0)
        {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        else if(!(ch>=65 && ch<=90||ch>=97 && ch<=122||ch==' '||ch==8))
        {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_ans_tfKeyTyped
    private void pswd_tfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pswd_tfKeyTyped
        char ch=evt.getKeyChar();
        if(ch==' ')
        {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        else if(evt.getKeyChar()==8 && pswd_tf.getCaretPosition()==0)
        {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
         if(flag1 &&((ch>=65 && ch<=90)|| (ch>=97 && ch<=122))){
            ctr++;
            flag1=false;
        }
        else if(flag2 && ((ch>=48 && ch<=57))){
            ctr++;
            flag2=false;
        }
        else if(flag3 && !((ch>=65 && ch<=90)|| (ch>=97 && ch<=122)||(ch>=48 && ch<=57)))
        {
            ctr++;
            flag3=false;
        }
        if(ctr==1){
            pswd_lb.setForeground(Color.red);
            pswd_lb.setText("*Weak");
        }
        else if(ctr==2){
            pswd_lb.setForeground(Color.orange);
            pswd_lb.setText("*Medium");
        }
        else if(ctr==3){
            pswd_lb.setForeground(Color.GREEN);
            pswd_lb.setText("*Strong");
        }
        if(ch==8){
            flag1=flag2=flag3=true;
            ctr=0;
            char hc[]=pswd_tf.getPassword();
            if(hc.length==0){
                pswd_lb.setText("");
            }
           else
            {
                for (byte i = 0; i<hc.length; i++) {
                    if (flag1 && ((hc[i]>=65 && hc[i]<=90)||(hc[i]>=97 && hc[i]<=122) )) {
                        ctr++;
                        flag1=false;
                    }
                    else if (flag2 && ((hc[i]>=48)&& (hc[i]<=57))) {
                        ctr++;
                        flag2=false;
                    }
                    else if(flag1 && !((hc[i]>=65 && hc[i]<=90)||(hc[i]>=97 && hc[i]<=122))||((hc[i]>=48)&& (hc[i]<=57))){
                        ctr++;
                        flag3=false;
                    }
        
                    if(ctr==1){                       
                        pswd_lb.setForeground(Color.red);
                        pswd_lb.setText("*Weak");
                    }
                    else  if(ctr==2){                       
                        pswd_lb.setForeground(Color.orange);
                        pswd_lb.setText("*Medium");
                    }
                    else if(ctr==3)  {                      
                        pswd_lb.setForeground(Color.green);
                        pswd_lb.setText("*Strong");
                    }
                    } 
                }
        }
    }//GEN-LAST:event_pswd_tfKeyTyped
    private void rep_tfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rep_tfKeyTyped
        char ch=evt.getKeyChar();
        if(ch==' ')
        {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        else if(evt.getKeyChar()==8 && rep_tf.getCaretPosition()==0)
        {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_rep_tfKeyTyped
    private void create_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_btActionPerformed
        chk=true;
        Check();
        if(use_tf.getText().equalsIgnoreCase("*Field is Mandatory")){
            fgcheck(use_tf);
        }      
        if(chk && create){
            try{
                    if(!(sec_box.getSelectedItem().toString().equalsIgnoreCase(combo))){
                        sec_box.setBorder(new LineBorder(Color.RED));
                        chk=false;
                    }
                    if(!(ans_tf.getText().equalsIgnoreCase(answer))){
                        ans_tf.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.RED));
                        chk=false;
                    }
                    if(!(new String(pswd_tf.getPassword()).equals(new String(rep_tf.getPassword())))){
                        pswd_tf.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.RED));
                        rep_tf.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.RED));
                        chk=false;
                    }
                    if(chk){
                        stmt=con.prepareStatement("update signup set pas=? where upper(u_id)=?");
                        stmt.setString(1, new String(pswd_tf.getPassword()));
                        stmt.setString(2, use_tf.getText().toUpperCase());
                        stmt.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Password Updated successfully!");
                        new LoginPage().setVisible(true);
                        this.dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "Please Try Again!");
                    }
            } catch (SQLException ex) {
                Logger.getLogger(ForgotPassword.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }//GEN-LAST:event_create_btActionPerformed

    private void sec_boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sec_boxActionPerformed
//        sec_box.setBorder(new LineBorder(Color.BLACK));
//        sec_lb.setText("");
//        if(sec_box.getSelectedIndex()==0){
//            sec_lb.setText("*Please select any one");
//            sec_lb.setForeground(Color.red);
//            sec_box.setBorder(new LineBorder(Color.RED));
//        }
        
    }//GEN-LAST:event_sec_boxActionPerformed

    private void hintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hintMouseClicked
        JOptionPane.showMessageDialog(this,"- Contains at least 8 characters!\n- Contains both lower case(a-z) and upper case(A-Z) letters\n- Contains at least one number(0-9) or a symbol\n- Doesn't contain UserID\n- Is not Commonly used");
    }//GEN-LAST:event_hintMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            this.dispose();
            new LoginPage().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(ForgotPassword.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing
    public void flcheck(JTextField c){
        String str=c.getText();
        if(str.length()==0||str.equalsIgnoreCase("*Field is Mandatory")||str==null||str.isEmpty())
        {
            chk=false;
            c.setText("*Field is Mandatory");
            pswd_tf.setEchoChar((char)0);
            c.setForeground(Color.red);
            c.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.RED));
        }
        else if(c.equals(pswd_tf)){
            String str1=new String(pswd_tf.getPassword());
            if(!(str1==null||str1.equalsIgnoreCase("*Field is Mandatory")||str1.isEmpty())){
                if(str1.length()<8){
                    pswd_lb.setText("*Contains at least 8 charcters!");
                    chk=false;
                }
                else
                    pswd_lb.setText("");
            }
            else{
                chk=false;
            }
        }
        else if(c.equals(rep_tf)){
            String str1=new String(pswd_tf.getPassword());
            String str2=new String(rep_tf.getPassword());
            if(!(str1==null||str1.equalsIgnoreCase("*Field is Mandatory")||str1.isEmpty())){
                if(!(str1.equals(str2)))
                    mismatch_lb.setText("*Password doesn't match!");
            }
        }
    }
    public void fgcheck(JTextField c){
        String str=c.getText();
        if(str.equalsIgnoreCase("*Field is Mandatory")||str.isEmpty())
        {
            c.setText("");
            c.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLUE));
            c.setForeground(Color.black);
        }
    }
    public void refresh()
    {
       use_tf.setText("");
       ans_tf.setText("");
       pswd_tf.setText("");
       rep_tf.setText("");
       use_tf.requestFocus();
       use_tf.setForeground(Color.black);
       use_tf.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
       ans_tf.setForeground(Color.black);
       ans_tf.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
       pswd_tf.setForeground(Color.black);
       pswd_tf.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
       rep_tf.setForeground(Color.black);
       rep_tf.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
       sec_box.setSelectedIndex(0);
       show_pswd.setVisible(true);
       hide_pswd.setVisible(false);
//       pswd_tf.setEchoChar('*');
//       rep_tf.setEchoChar('*');
       mismatch_lb.setText("");
       sec_lb.setText("");
    }
    public void Check(){
        if(use_tf.getText().equalsIgnoreCase("*Field is Mandatory")||use_tf.getText().isEmpty())
            use_tf.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.RED));
//        if(sec_box.getSelectedIndex()==0)
//            sec_box.setBorder(new LineBorder(Color.RED));
        if(ans_tf.getText().equalsIgnoreCase("*Field is Mandatory")||ans_tf.getText().isEmpty())
            ans_tf.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.RED));
        if(new String(pswd_tf.getPassword()).equals("*Field is Mandatory")||new String(pswd_tf.getPassword()).length()==0)
            pswd_tf.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.RED));
        if(new String(rep_tf.getPassword()).equals("*Field is Mandatory")||new String(rep_tf.getPassword()).length()==0)
            rep_tf.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.RED));
        flcheck(use_tf);
        flcheck(ans_tf);
        flcheck(pswd_tf);
        flcheck(rep_tf);
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
//            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(() -> {
//            try {
//                new ForgotPassword().setVisible(true);
//            } catch (SQLException ex) {
//                Logger.getLogger(ForgotPassword.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ans_tf;
    private javax.swing.JButton clear_bt;
    private javax.swing.JButton create_bt;
    private javax.swing.JLabel frg_lb;
    private javax.swing.JLabel hide_pswd;
    private javax.swing.JLabel hint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private keeptoo.KGradientPanel kg_p;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel mismatch_lb;
    private javax.swing.JButton msg;
    private javax.swing.JLabel pic;
    private javax.swing.JLabel pswd_lb;
    private javax.swing.JPasswordField pswd_tf;
    private javax.swing.JPasswordField rep_tf;
    private javax.swing.JComboBox<String> sec_box;
    private javax.swing.JLabel sec_lb;
    private javax.swing.JLabel show_pswd;
    private javax.swing.JTextField use_tf;
    // End of variables declaration//GEN-END:variables
}
