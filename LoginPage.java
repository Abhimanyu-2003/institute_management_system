
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
public class LoginPage extends javax.swing.JFrame { 
    Connection con;
    PreparedStatement stmt;
    ResultSet rs;
    String s;
    Boolean flag=true;
    byte hjk=0,role;
    public LoginPage() throws SQLException {
        initComponents();
        Image icon=Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/icon/repl_logo_(1)-small.png"));
        this.setIconImage(icon);
           setTitle("LoginPage");
//           System.out.println(OTP.OTP());
           this.getRootPane().setDefaultButton(log_bt);
           user_tf.requestFocus();
           this.setLocationRelativeTo(null);
           this.show.setVisible(false);
           con=ConnDb.conLink();
           msg.setVisible(false);
    }   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        log_bt = new javax.swing.JButton();
        pas_fld = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        sin_lb = new javax.swing.JLabel();
        user_tf = new javax.swing.JTextField();
        login_pic = new javax.swing.JLabel();
        login_logo = new javax.swing.JLabel();
        for_lb = new javax.swing.JLabel();
        hide = new javax.swing.JLabel();
        show = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        msg = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("LOGIN ");
        jLabel3.setToolTipText("");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(517, 37, -1, 31));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Hello! Let's get started");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(493, 74, 138, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("User  Id");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 110, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Password");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, 110, 20));

        log_bt.setBackground(new java.awt.Color(0, 51, 255));
        log_bt.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        log_bt.setForeground(new java.awt.Color(255, 255, 255));
        log_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        log_bt.setText("LOGIN");
        log_bt.setBorder(null);
        log_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        log_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log_btActionPerformed(evt);
            }
        });
        jPanel2.add(log_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 260, 270, 36));

        pas_fld.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 51, 0)));
        pas_fld.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pas_fldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                pas_fldFocusLost(evt);
            }
        });
        pas_fld.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pas_fldKeyTyped(evt);
            }
        });
        jPanel2.add(pas_fld, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 270, 20));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("DON'T HAVE ACCOUNT ?");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 350, 130, 22));

        sin_lb.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        sin_lb.setForeground(new java.awt.Color(0, 51, 255));
        sin_lb.setText("Sign up");
        sin_lb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sin_lbMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sin_lbMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sin_lbMouseExited(evt);
            }
        });
        jPanel2.add(sin_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 350, 76, -1));

        user_tf.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        user_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                user_tfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                user_tfFocusLost(evt);
            }
        });
        user_tf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                user_tfKeyTyped(evt);
            }
        });
        jPanel2.add(user_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 267, 20));

        login_pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/loginpic2.png"))); // NOI18N
        jPanel2.add(login_pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 400, 290));

        login_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/login1.png"))); // NOI18N
        jPanel2.add(login_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 50, 40));

        for_lb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        for_lb.setForeground(new java.awt.Color(0, 51, 255));
        for_lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        for_lb.setText("Forget Password ?");
        for_lb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                for_lbMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                for_lbMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                for_lbMouseExited(evt);
            }
        });
        jPanel2.add(for_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 310, 130, 20));

        hide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hide1.png"))); // NOI18N
        hide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                hideMousePressed(evt);
            }
        });
        jPanel2.add(hide, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 210, 30, 30));

        show.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/open1.png"))); // NOI18N
        show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                showMousePressed(evt);
            }
        });
        jPanel2.add(show, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 210, 30, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/raysnewbg.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 130, 120));

        msg.setBackground(new java.awt.Color(255, 0, 0));
        msg.setFont(new java.awt.Font("Serif", 1, 16)); // NOI18N
        msg.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(msg, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 380, 390, 40));

        kGradientPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 760, 425));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void user_tfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_user_tfFocusGained
     String str=user_tf.getText();
        if(str.equalsIgnoreCase("*Field is mandatory!")||str.isEmpty()||str.length()==0||str==null){
            user_tf.setForeground(Color.BLACK);
            user_tf.setText("");
            user_tf.setBorder(BorderFactory.createMatteBorder(0, 0, 2,0, Color.black));
//            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_user_tfFocusGained

    private void user_tfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_user_tfFocusLost
        flchk(user_tf);
        try {
            stmt=con.prepareStatement("select role from signup where u_id=?");
            stmt.setString(1, user_tf.getText());
            rs=stmt.executeQuery();
            if(rs.next())
                role=(byte)rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_user_tfFocusLost

    private void user_tfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_user_tfKeyTyped
        // TODO add your handling code here:
         char ch=evt.getKeyChar();
         if(evt.getKeyChar()==' '&& user_tf.getCaretPosition()==0)
         {
             evt.consume();
//             Toolkit.getDefaultToolkit().beep();
         }
        if(!(ch>='a'&& ch<='z'|| ch==8||ch==' '||ch>='A'&& ch<='Z' ||ch>='0'&& ch<='9' ||ch=='@' ||ch=='_')){
            evt.consume();
//            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_user_tfKeyTyped

    private void pas_fldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pas_fldKeyTyped
        // TODO add your handling code here:\ char ch=evt.getKeyChar();
        char ch=evt.getKeyChar();
        if(evt.getKeyChar()==' '&& pas_fld.getCaretPosition()==0)
        {
             evt.consume();
//             Toolkit.getDefaultToolkit().beep();
        }
        if((ch==' '))
        {
            evt.consume();
//            Toolkit.getDefaultToolkit().beep();
        }       
    }//GEN-LAST:event_pas_fldKeyTyped

    private void pas_fldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pas_fldFocusLost
        flchk(pas_fld);
    }//GEN-LAST:event_pas_fldFocusLost

    private void pas_fldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pas_fldFocusGained
      //char ch[]=pas_fld.getPassword();
        String str=new String(pas_fld.getPassword());
            pas_fld.setEchoChar('*');
            pas_fld.setForeground(Color.BLACK);
        if(str.equalsIgnoreCase("*Field is mandatory!")){
//            pas_fld.setBorder(new LineBorder(Color.black));
            pas_fld.setText("");
            Toolkit.getDefaultToolkit().beep();
           pas_fld.setBorder(BorderFactory.createMatteBorder(0, 0, 2,0, Color.black));
        }
    }//GEN-LAST:event_pas_fldFocusGained

    private void for_lbMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_for_lbMouseEntered
        for_lb.setFont(new java.awt.Font("Segoe UI", 1, 14));

    }//GEN-LAST:event_for_lbMouseEntered

    private void for_lbMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_for_lbMouseExited
        for_lb.setFont(new java.awt.Font("Segoe UI", 1, 12));       

    }//GEN-LAST:event_for_lbMouseExited

    private void sin_lbMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sin_lbMouseEntered
        sin_lb.setFont(new java.awt.Font("Segoe UI", 1, 20));
    }//GEN-LAST:event_sin_lbMouseEntered

    private void sin_lbMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sin_lbMouseExited
        sin_lb.setFont(new java.awt.Font("Segoe UI", 1, 18));     

    }//GEN-LAST:event_sin_lbMouseExited

    private void showMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMousePressed
        // TODO add your handling code here:
        hide.setVisible(true);
        show.setVisible(false);
        pas_fld.setEchoChar('*');
    }//GEN-LAST:event_showMousePressed

    private void hideMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideMousePressed
        // TODO add your handling code here:
        show.setVisible(true);
        hide.setVisible(false);
        pas_fld.setEchoChar((char)0);
    }//GEN-LAST:event_hideMousePressed

    private void sin_lbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sin_lbMouseClicked
        try {
            new SignupPage().setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_sin_lbMouseClicked

    private void log_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log_btActionPerformed
        flag=true;
        flchk(user_tf);
        flchk(pas_fld);
        if(user_tf.getText().equalsIgnoreCase("*Field is mandatory!")){
            user_tf.setForeground(Color.BLACK);
            user_tf.setText("");
            user_tf.requestFocus();
            user_tf.setBorder(BorderFactory.createMatteBorder(0, 0, 2,0, Color.black));
        }
        if(flag){
            try {
                stmt=con.prepareStatement("select * from signup where u_id=?");
                stmt.setString(1,user_tf.getText());
                rs=stmt.executeQuery();
                String a=user_tf.getText();
                if(rs.next()){
                    String ghj=rs.getString(3);
                    if(rs.getString(8).equals("1")){
                        stmt=con.prepareStatement("select * from signup where u_id=? and pas=?");
                        stmt.setString(1,user_tf.getText());
                        stmt.setString(2,new String(pas_fld.getPassword()));
                        rs=stmt.executeQuery();
                        if(rs.next()){
                                DashBordForm d= new DashBordForm(rs.getString(2),a,ghj);
        //                        d.set(a);
                                d.setVisible(true);
                                this.dispose();
                        }
                        else{
                            hjk=(byte) (hjk+1);
                            if(hjk>=3){
                                msg.setText("Please Contact Super Admin for Login!");
                                msg.setFont(new Font("Courier", Font.PLAIN, 20));
                                msg.setVisible(true);
                                stmt=con.prepareStatement("update signup set stat='0' where u_id=?");
                                stmt.setString(1, user_tf.getText());
                                stmt.executeUpdate();
                            }
                            else{
                                    msg.setText("Wrong User ID OR Password, You have left "+String.valueOf(3-hjk)+" Attempt!");
                                    msg.setFont(new Font("Courier", Font.PLAIN, 14));
                                    msg.setVisible(true);
                            }
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "Please Wait For Approval!");
                        msg.setText("Please Contact Super Admin for Login!");
                        msg.setFont(new Font("Courier", Font.PLAIN, 20));
                        msg.setVisible(true);
                    }
                }
                else
                    JOptionPane.showMessageDialog(this, "Please Enter valid UserName Or Password!");
            } catch (SQLException ex) {
                Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_log_btActionPerformed
    
    private void for_lbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_for_lbMouseClicked
        try {
            new ForgotPassword().setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_for_lbMouseClicked
     public void cancel()
     {
         user_tf.requestFocus();
         user_tf.setText("");
         user_tf.setForeground(Color.BLACK);
         user_tf.setBorder(BorderFactory.createMatteBorder(0, 0,2,0, Color.BLACK));
         pas_fld.setText("");
         pas_fld.setForeground(Color.BLACK);
         pas_fld.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.BLACK));
     }
     public void flchk(JTextField j){
        if(j.equals(user_tf)){
            String str=j.getText();
            if(str.length()==0||str.isEmpty()||str==null||str.equalsIgnoreCase("*Field is mandatory!")){
                flag=false;
                j.setForeground(Color.red);
                j.setText("*Field is mandatory!");
//                j.setBorder(new LineBorder(Color.RED));
                j.setBorder(BorderFactory.createMatteBorder(0, 0, 2,0, Color.red));
                Toolkit.getDefaultToolkit().beep();
            }
        }
        else{
//            char ch[]=pas_fld.getPassword();
            String ch=new String(pas_fld.getPassword());
            if(ch.length()==0||ch.equals("*Field is mandatory!")||ch==null||ch.isEmpty()){
                flag=false;
               pas_fld.setForeground(Color.red);
               pas_fld.setEchoChar('\u0000');
               pas_fld.setText("*Field is mandatory!");
//               pas_fld.setBorder(new LineBorder(Color.RED));
               Toolkit.getDefaultToolkit().beep();
               pas_fld.setBorder(BorderFactory.createMatteBorder(0, 0, 2,0, Color.red));
          } 
        }
     }
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel for_lb;
    private javax.swing.JLabel hide;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JButton log_bt;
    private javax.swing.JLabel login_logo;
    private javax.swing.JLabel login_pic;
    private javax.swing.JButton msg;
    private javax.swing.JPasswordField pas_fld;
    private javax.swing.JLabel show;
    private javax.swing.JLabel sin_lb;
    private javax.swing.JTextField user_tf;
    // End of variables declaration//GEN-END:variables
}
