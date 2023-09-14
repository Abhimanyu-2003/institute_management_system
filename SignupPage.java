
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
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import jxl.write.Label;
import jxl.write.WriteException;

public class SignupPage extends javax.swing.JFrame{
        int ctr = 0,dot=0;
        boolean flag=true,flag1 = false,flag2= false,flag3= false;
        Connection con;
        PreparedStatement stmt;
        ResultSet rs,rs1;
        String str;
        ButtonGroup bg;
        Label l;
       
        public SignupPage() throws SQLException {
        initComponents();
        con=ConnDb.conLink();   
        user_tf.requestFocus();
        us_lb.setVisible(false);
        Image icon=Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/icon/repl_logo_(1)-small.png"));
        this.setIconImage(icon);
        setTitle("SignupPage");
        this.getRootPane().setDefaultButton(sub);
        this.setLocationRelativeTo(null); 
        adm.setVisible(false);
         
    }                 
     public void login(){
            try {
                new LoginPage().setVisible(true);
                this.dispose();;
            } catch (SQLException ex) {
                Logger.getLogger(SignupPage.class.getName()).log(Level.SEVERE, null, ex);
            }
     }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        user_tf = new javax.swing.JTextField();
        pas_fld = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        sec_cb = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        uid_tf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ans_tf = new javax.swing.JTextField();
        sub = new javax.swing.JButton();
        sin_pic = new javax.swing.JLabel();
        rays_log = new javax.swing.JLabel();
        sin_log = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        con_fld = new javax.swing.JPasswordField();
        label = new javax.swing.JLabel();
        hint = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        pas_ans = new javax.swing.JLabel();
        can = new javax.swing.JButton();
        chec = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        adm = new javax.swing.JLabel();
        us_lb = new javax.swing.JLabel();

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

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 102, 51));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Signup");
        jLabel3.setToolTipText("");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 80, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Confirm Password");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 400, 140, 20));

        user_tf.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 0)));
        user_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                user_tfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                user_tfFocusLost(evt);
            }
        });
        user_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_tfActionPerformed(evt);
            }
        });
        user_tf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                user_tfKeyTyped(evt);
            }
        });
        jPanel2.add(user_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, 263, 20));

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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pas_fldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pas_fldKeyTyped(evt);
            }
        });
        jPanel2.add(pas_fld, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 360, 260, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel1.setText("Security Question");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, 186, -1));

        sec_cb.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        sec_cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"What was Your favorite subject in high School?", "What is the Name of Your first Pet?", "What high school did you attend?", "What was your favorite food as a child?","Where did you go on your favorite vocation as a child?" }));
        sec_cb.setBorder(null);
        jPanel2.add(sec_cb, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 261, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("User id");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 50, 21));

        uid_tf.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 0)));
        uid_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                uid_tfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                uid_tfFocusLost(evt);
            }
        });
        uid_tf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                uid_tfKeyTyped(evt);
            }
        });
        jPanel2.add(uid_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, 263, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel2.setText("Answer");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 60, -1));

        ans_tf.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 0)));
        ans_tf.setNextFocusableComponent(pas_fld);
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
        jPanel2.add(ans_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 310, 263, -1));

        sub.setBackground(new java.awt.Color(0, 102, 102));
        sub.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        sub.setForeground(new java.awt.Color(255, 255, 255));
        sub.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/signup_2.png"))); // NOI18N
        sub.setText("SIGNUP");
        sub.setBorder(null);
        sub.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sub.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                subFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                subFocusLost(evt);
            }
        });
        sub.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subMouseClicked(evt);
            }
        });
        sub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subActionPerformed(evt);
            }
        });
        jPanel2.add(sub, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 460, 110, 30));

        sin_pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/signup_1.png"))); // NOI18N
        jPanel2.add(sin_pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 370, 320));

        rays_log.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/raysnewbg.png"))); // NOI18N
        jPanel2.add(rays_log, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 140, 110));

        sin_log.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/signuplogo.png"))); // NOI18N
        jPanel2.add(sin_log, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 40, 50));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Password");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, 70, 20));

        con_fld.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        con_fld.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                con_fldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                con_fldFocusLost(evt);
            }
        });
        jPanel2.add(con_fld, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 420, 260, -1));
        jPanel2.add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 440, 260, 10));

        hint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hint.png"))); // NOI18N
        hint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hintMouseClicked(evt);
            }
        });
        jPanel2.add(hint, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 340, 30, 20));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("User Name");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 80, 21));

        pas_ans.setForeground(new java.awt.Color(153, 0, 0));
        jPanel2.add(pas_ans, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 380, 260, 20));

        can.setBackground(new java.awt.Color(204, 0, 51));
        can.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        can.setForeground(new java.awt.Color(255, 255, 255));
        can.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        can.setText("REFRESH");
        can.setBorder(null);
        can.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        can.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canActionPerformed(evt);
            }
        });
        jPanel2.add(can, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 460, 100, 30));

        chec.setText("show");
        chec.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checActionPerformed(evt);
            }
        });
        jPanel2.add(chec, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 350, 60, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 0));
        jLabel4.setText("*");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 400, 20, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 0, 0));
        jLabel8.setText("*");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 123, 20, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 0, 0));
        jLabel10.setText("*");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, 20, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 0, 0));
        jLabel11.setText("*");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, 20, 20));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 0, 0));
        jLabel12.setText("*");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 20, 20));

        adm.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        adm.setForeground(new java.awt.Color(102, 102, 255));
        adm.setText("Welcome Super Admin, Now you can create Sign Up!");
        jPanel2.add(adm, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 310, -1));

        us_lb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        us_lb.setForeground(new java.awt.Color(255, 0, 0));
        us_lb.setText("*Already Exists!");
        jPanel2.add(us_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 230, 90, -1));

        kGradientPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 730, 520));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void user_tfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_user_tfFocusLost
        if(user_tf.getText().length()==0 || user_tf.getText().equalsIgnoreCase("*Field is mandatory!"))
            flsignup(user_tf);
        else
            regKr(user_tf);
        user_tf.setText(user_tf.getText().toUpperCase());
    }//GEN-LAST:event_user_tfFocusLost

    private void user_tfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_user_tfFocusGained

        fgsignup(user_tf);

    }//GEN-LAST:event_user_tfFocusGained

    private void uid_tfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_uid_tfFocusGained

        fgsignup(uid_tf);

    }//GEN-LAST:event_uid_tfFocusGained

    private void uid_tfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_uid_tfFocusLost
            flsignup(uid_tf);
            if(!(uid_tf.getText().equalsIgnoreCase("*Field is mandatory!")||uid_tf.getText()==null||uid_tf.getText().isEmpty())){
                try {
                    stmt=con.prepareStatement("select * from signup where u_id=?");
                    stmt.setString(1, uid_tf.getText().trim());
                    rs=stmt.executeQuery();
                    if(rs.next()){
                        JOptionPane.showMessageDialog(this, "User Id Already Exists!");
                        us_lb.setVisible(true);}
                    else
                        us_lb.setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(SignupPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }        

    }//GEN-LAST:event_uid_tfFocusLost

    private void user_tfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_user_tfKeyTyped
 
        char ch=evt.getKeyChar();       
        if(((evt.getKeyChar()==' '||evt.getKeyChar()=='.')&& user_tf.getCaretPosition()==0))
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
    }//GEN-LAST:event_user_tfKeyTyped

    private void uid_tfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_uid_tfKeyTyped
        // TODO add your handling code here:
         char ch=evt.getKeyChar();
          if(ch==' '){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
         if(evt.getKeyChar()==8 && uid_tf.getCaretPosition()==0)
         {
             evt.consume();
             Toolkit.getDefaultToolkit().beep();
         }
       
    }//GEN-LAST:event_uid_tfKeyTyped

    private void pas_fldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pas_fldFocusLost
        flcheck(pas_fld);
    }//GEN-LAST:event_pas_fldFocusLost

    private void pas_fldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pas_fldFocusGained
         //TODO add your handling code here:
         fgcheck(pas_fld);

    }//GEN-LAST:event_pas_fldFocusGained

    private void pas_fldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pas_fldKeyTyped
// //*******Password strength check*****************
        char ch=evt.getKeyChar();
        if(ch==' ')
        {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        else if(evt.getKeyChar()==8 && pas_fld.getCaretPosition()==0)
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
            pas_ans.setForeground(Color.red);
            pas_ans.setText("*Weak");
        }
        else if(ctr==2){
            pas_ans.setForeground(Color.orange);
            pas_ans.setText("*Medium");
        }
        else if(ctr==3){
            pas_ans.setForeground(Color.GREEN);
            pas_ans.setText("*Strong");
        }
        if(ch==8){
            flag1=flag2=flag3=true;
            ctr=0;
            char hc[]=pas_fld.getPassword();
            if(hc.length==0){
                pas_ans.setText("");
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
                        pas_ans.setForeground(Color.red);
                        pas_ans.setText("*Weak");
                    }
                    else  if(ctr==2){                       
                        pas_ans.setForeground(Color.orange);
                        pas_ans.setText("*Medium");
                    }
                    else if(ctr==3)  {                      
                        pas_ans.setForeground(Color.green);
                        pas_ans.setText("*Strong");
                    }
                } 
            }
        }
    }//GEN-LAST:event_pas_fldKeyTyped

    private void ans_tfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ans_tfFocusLost
        flsignup(ans_tf);
    }//GEN-LAST:event_ans_tfFocusLost

    private void ans_tfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ans_tfFocusGained
        String str=ans_tf.getText();
        if(str.equals("*Field is mandatory!")){
           ans_tf.setForeground(Color.BLACK);
//            ans_tf.setBorder(new LineBorder(Color.black));
            ans_tf.setText("");
             Toolkit.getDefaultToolkit().beep();
             ans_tf.setBorder(BorderFactory.createMatteBorder(0, 0, 2,0, Color.black));            
        }     
    }//GEN-LAST:event_ans_tfFocusGained

    private void ans_tfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ans_tfKeyTyped
       
         char ch=evt.getKeyChar();
      if(evt.getKeyChar()==' '&& ans_tf.getCaretPosition()==0||evt.getKeyChar()=='0'&& ans_tf.getCaretPosition()==0)
      {
          evt.consume();
          Toolkit.getDefaultToolkit().beep();
      }
//      else if(!(ch>=65 && ch<=90 || ch>=97 && ch<=122 ||ch==' ' ||ch==8))
//      {
//          evt.consume();
//          Toolkit.getDefaultToolkit().beep();
//      }
//      else if(ch==8||((ch>='a' && ch<='z' )|| (ch>='A'&& ch<='Z' )))
//        ctr=0;
//        else if(evt.getKeyChar()==' ' && ctr==0)
//            ctr=1;
//        else{
//            evt.consume();
//            Toolkit.getDefaultToolkit().beep();
//        }
    }//GEN-LAST:event_ans_tfKeyTyped

    private void con_fldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_con_fldFocusGained
      fgcheck(con_fld);

    }//GEN-LAST:event_con_fldFocusGained

    private void con_fldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_con_fldFocusLost
        flcheck(con_fld);
    }//GEN-LAST:event_con_fldFocusLost

    private void subActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subActionPerformed
        flag=true;
        RedBorder();
         if(us_lb.isVisible())
             flag=false;
         if(flag){
            try {
                String rol,stat="0",sn="0";
                if(adm.isVisible()){
                    rol="0";
                    stat="1";
                    sn="1";
                }
                else{
                    rol="2";
                    stmt=con.prepareStatement("select sn from signup order by sn desc");
                    rs=stmt.executeQuery();
                    if(rs.next())
                        sn=(String.valueOf(Integer.parseInt(rs.getString(1))+1));
                }
                stmt=con.prepareStatement("insert into signup values(?,?,?,?,?,?,?,?)");
                stmt.setString(1, sn);                
                stmt.setString(2,rol);
                stmt.setString(3,user_tf.getText().trim());
                stmt.setString(4,uid_tf.getText());
                stmt.setString(5,sec_cb.getSelectedItem().toString());
                stmt.setString(6,ans_tf.getText());
                stmt.setString(7,new String(pas_fld.getPassword()));
                stmt.setString(8,stat);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(this,"User Created Successfully!");
                 stmt=con.prepareStatement("select count(sn) from signup");
                 rs1=stmt.executeQuery();
                 rs1.next();
                 if(rs1.getInt(1)!=1)
                    backdata.backup("SignUp");
                login();
             } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this,"Something went Wrong!");
            
            } catch (WriteException ex) {
                Logger.getLogger(SignupPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_subActionPerformed

    private void canActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canActionPerformed
        // TODO add your handling code here:
        cancel();
    }//GEN-LAST:event_canActionPerformed

    private void checActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checActionPerformed
        // TODO add your handling code here:
        if(chec.isSelected())
        {
            pas_fld.setEchoChar((char)0);
            con_fld.setEchoChar((char)0);
        }
        else
        {
            pas_fld.setEchoChar('*');
            con_fld.setEchoChar('*');
        }
    }//GEN-LAST:event_checActionPerformed

    private void a7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a7MouseClicked
        
    }//GEN-LAST:event_a7MouseClicked

    private void hintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hintMouseClicked
       
        JOptionPane.showMessageDialog(this,"Create a password that:  \n- Contains at least 8 characters\n- Is not commonaly used");
    }//GEN-LAST:event_hintMouseClicked

    private void subFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_subFocusGained
        
        sub.setBackground(new java.awt.Color(204,0,51));
    }//GEN-LAST:event_subFocusGained

    private void subFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_subFocusLost
       
        sub.setBackground(new java.awt.Color(0, 102, 102));
    }//GEN-LAST:event_subFocusLost

    private void subMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_subMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
            try {
                stmt=con.prepareStatement("select * from signup");
                rs=stmt.executeQuery();
                if(rs.next())
                    adm.setVisible(false);
                else
                    adm.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(SignupPage.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_formWindowOpened

    private void user_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_user_tfActionPerformed

    private void pas_fldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pas_fldKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_pas_fldKeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            this.dispose();
            new LoginPage().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(SignupPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    public void fgcheck(JPasswordField fg){
         String pass1=new String(fg.getPassword());
        if(pass1.equalsIgnoreCase("*Field is mandatory!")){
            fg.setEchoChar('*');
            fg.setForeground(Color.black);
            fg.setText("");
            fg.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
           label.setText("");
        }
         else if(fg.equals(pas_fld)){
             if(pass1.length()<8){
                 pas_ans.setText("");
                 pas_fld.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
                 Toolkit.getDefaultToolkit().beep();
             }
         }
         else if(fg.equals(con_fld)){
             label.setText("");
         }
    }
    

    public void flcheck(JPasswordField fl)
    {   
        String str=new String(fl.getPassword());
        char ch[]=fl.getPassword();
        
         if(str.length()==0||str.equalsIgnoreCase("*Field is mandatory!")||str.isEmpty()||str==null){
            flag=false;
            fl.setForeground(Color.red);
            fl.setEchoChar((char)0);
            fl.setText("*Field is mandatory!");
            fl.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.red));
            Toolkit.getDefaultToolkit().beep();
        }
         else if(fl.equals(pas_fld)){
             if(str.length()<8){
                 flag=false;
                 label.setForeground(Color.red);
                 pas_ans.setText("Must be at least 8 characters!");
                 pas_fld.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.red));
                 Toolkit.getDefaultToolkit().beep();
             }
             
            
         }
        else if(fl.equals(con_fld))
        {
            String newpass=new String(pas_fld.getPassword());
            String conpass=new String(con_fld.getPassword());
            if(!(newpass.equals(conpass))){
                flag=false;
                label.setForeground(Color.red);
                label.setText("*Password doesn't match!");
                Toolkit.getDefaultToolkit().beep();
            }
            else
                label.setText("");
        }
    }
    
    public void fgsignup(JTextField fg)
    {
         String str=fg.getText();
         fg.setForeground(Color.BLACK);
         fg.setBorder(BorderFactory.createMatteBorder(0, 0, 2,0, Color.black));
        if(str.equals("*Field is mandatory!")){
            fg.setText("");
            Toolkit.getDefaultToolkit().beep();
        }
    }
     public void flsignup(JTextField fl)
      {
           String str=fl.getText();
        if(str.length()==0||str.equalsIgnoreCase("*Field is mandatory!")||str.isEmpty()||str==null){
            flag=false;
           fl.setForeground(Color.red);
           fl.setText("*Field is mandatory!");
//            fl.setBorder(new LineBorder(Color.RED));
           fl.setBorder(BorderFactory.createMatteBorder(0, 0, 2,0, Color.red));
            Toolkit.getDefaultToolkit().beep();
        }
    }

        
     public void cancel(){
        user_tf.requestFocus();
        user_tf.setText("");
        user_tf.setForeground(Color.BLACK);
        user_tf.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        uid_tf.setText("");
        uid_tf.setForeground(Color.BLACK);
        uid_tf.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        ans_tf.setText("");
        ans_tf.setForeground(Color.BLACK);
        ans_tf.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        pas_fld.setText("");
        pas_fld.setForeground(Color.BLACK);
        pas_fld.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        con_fld.setText("");
        con_fld.setForeground(Color.BLACK);
        con_fld.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        label.setText("");
        pas_ans.setText("");
        chec.setSelected(false);

     }
     public void regKr(JTextField d){
         String str[]=d.getText().split(" ");
         String res="";
         for(String t:str)
             res=res+(t.substring(0,1).toUpperCase()+t.substring(1,t.length()).toLowerCase())+" ";
         d.setText(res);
    }
     public void RedBorder(){
            flsignup(user_tf);
            flsignup(uid_tf);
            flsignup(ans_tf);
            flcheck(pas_fld);
            flcheck(con_fld);
        }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adm;
    private javax.swing.JTextField ans_tf;
    private javax.swing.JButton can;
    private javax.swing.JCheckBox chec;
    private javax.swing.JPasswordField con_fld;
    private javax.swing.JLabel hint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel label;
    private javax.swing.JLabel pas_ans;
    private javax.swing.JPasswordField pas_fld;
    private javax.swing.JLabel rays_log;
    private javax.swing.JComboBox<String> sec_cb;
    private javax.swing.JLabel sin_log;
    private javax.swing.JLabel sin_pic;
    private javax.swing.JButton sub;
    private javax.swing.JTextField uid_tf;
    private javax.swing.JLabel us_lb;
    private javax.swing.JTextField user_tf;
    // End of variables declaration//GEN-END:variables
}
