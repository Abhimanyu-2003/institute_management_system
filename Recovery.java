package raysproject;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Recovery {
    public static void recmethod(String str) throws IOException, BiffException, SQLException, ParseException{
        Connection con=ConnDb.conLink();
        ResultSet rs;
        PreparedStatement stmt=null;
        int a;
        boolean flag=true;
        if(str.equalsIgnoreCase("Registration")){
            stmt=con.prepareStatement("select * from registration");
             rs=stmt.executeQuery();
            if(rs.next()){
                 JOptionPane.showMessageDialog(null,"Record is Available!");
                 flag=false;
            }
            else
              stmt=con.prepareStatement("insert into registration values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
         }
        
        else if(str.equalsIgnoreCase("Certificate")){
              stmt=con.prepareStatement("select * from certificate");
              rs=stmt.executeQuery();
            if(rs.next()){
                 JOptionPane.showMessageDialog(null,"Record is Available!");
                 flag=false;
            }
            else
                 stmt=con.prepareStatement("insert into certificate values(?,?,?,?,?,?,?,?)");
         }
         
        else if(str.equalsIgnoreCase("Admission")){
               stmt=con.prepareStatement("select * from admission");
               rs=stmt.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null,"Record is Available!");
                flag=false;
            }
            else
                stmt=con.prepareStatement("insert into admission values(?,?,?,?,?,?)");
         }
         
        else if(str.equalsIgnoreCase("Book_details")){
              stmt=con.prepareStatement("select * from book_details");
             rs=stmt.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null,"Record is Available!");
                flag=false;
            }  
            else
                 stmt=con.prepareStatement("insert into book_details values(?,?,?,?,?,?,?,?)");
         }
         
        else if(str.equalsIgnoreCase("Branch_details")){
                stmt=con.prepareStatement("select * from branch_details");
             rs=stmt.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null,"Record is Available!");
                flag=false;
            }
            else
                stmt=con.prepareStatement("insert into branch_details values(?,?,?,?,?,?,?,?)");
          }
          
        else if(str.equalsIgnoreCase("Course")){
              stmt=con.prepareStatement("select * from course");
             rs=stmt.executeQuery();
            if(rs.next()){
                 JOptionPane.showMessageDialog(null,"Record is Available!");
                 flag=false;
            }
            else
               stmt=con.prepareStatement("insert into course values(?,?,?,?,?)");
         }
           else if(str.equalsIgnoreCase("Money_receipt")){
        stmt=con.prepareStatement("select * from money_receipt");
             rs=stmt.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null,"Record is Available!");
                flag=false;
            }
            else
           stmt=con.prepareStatement("insert into money_receipt values(?,?,?,?,?,?,?,?,?,?,?)");
         }
        
        else if(str.equalsIgnoreCase("SignUp")){
            stmt=con.prepareStatement("select count(sn) from signup");
             rs=stmt.executeQuery();
            if(rs.next()){
                a=rs.getInt(1);
                if(a==1){
                    stmt=con.prepareStatement("insert into signup values(?,?,?,?,?,?,?,?)");
                }
                else{
                   JOptionPane.showMessageDialog(null,"Record is Available!"); 
                   flag=false;
                }    
            }
        }   
        else if(str.equalsIgnoreCase("Automatic")){
            stmt=con.prepareStatement("update  automatic set  REG_NO=?,ADM_NO=?, CID=?,RECPT_NO=?,CH=?");
         }
        else if(str.equalsIgnoreCase("Branch Code")){
            stmt=con.prepareStatement("update  state set  ad=?,ar=?,am=?,br=?,cg=?,dl=?,ga=?,gj=?,hr=?,hp=?,jk=?,jh=?,ka=?,kl=?,ld=?,mp=?,mh=?,mn=?,ml=?,mz=?,nl=?,od=?,py=?,pb=?,rj=?,sk=?,tn=?,ts=?,tr=?,up=?,uk=?,wb=?,an=?,ch=?,dn=?,la=?");
         }
         
        if(flag){
            try {
                FileInputStream fs=new FileInputStream("RaysBackup\\"+str+".xls");
                Workbook wb=Workbook.getWorkbook(fs);
                Sheet sh=wb.getSheet(0);
                if(str.equalsIgnoreCase("signup")){
                    for(byte i=2;i<sh.getRows();i++){
                    for(byte j=0;j<sh.getColumns();j++){
                            stmt.setString(j+1,sh.getCell(j, i).getContents());
                    }
                    stmt.executeUpdate();
                }
                    JOptionPane.showMessageDialog(null,"Data Recovery Sucessfull");
                }
                else{
                    for(byte i=1;i<sh.getRows();i++){
                    for(byte j=0;j<sh.getColumns();j++){
                        if(str.equalsIgnoreCase("Registration") && (j==15 || j==16))
                            stmt.setBlob(j+1,new ByteArrayInputStream(sh.getCell(j, i).getContents().getBytes()));
                        else if((str.equalsIgnoreCase("Registration") && (j==1 || j==5))||(str.equalsIgnoreCase("Admission") &&j==1)||(str.equalsIgnoreCase("certificate") && (j==1||j==7))||(str.equalsIgnoreCase("money_receipt")&& (j==1||j==8))||(str.equalsIgnoreCase("book_details")&&(j==5||j==6))){
                            String s = sh.getCell(j, i).getContents();
                            DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
                            Date sql=null;
                            java.util.Date date=df.parse(s);
                            sql=new Date(date.getTime());
                            stmt.setDate(j+1,sql);
                        }
                        else
                            stmt.setString(j+1,sh.getCell(j, i).getContents());
                    }
                    stmt.executeUpdate();
                }
                    JOptionPane.showMessageDialog(null,"Data Recovery Sucessfull");
                }
                 } catch (FileNotFoundException ex) {
                     JOptionPane.showMessageDialog(null,"Something Went Wrong!");
            }
        }
        else
            flag=true;
    }
    
}
