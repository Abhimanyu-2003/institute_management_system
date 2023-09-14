
package raysproject;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class autobackup {
      PreparedStatement stmt;
      Connection con;
      ResultSet rs;
      Label l;

     public void backup(){
//                       backup of certificate
                File f1=new File("RaysBackup");
                File f2=new File("RaysBackup\\"+"certificate.xls");
//                File f1=new File("d:\\BackUpRays");
//                File f2=new File("d:\\BackUpRays\\certificate.xls");
                f1.mkdirs();
                f2.setWritable(true);
                try {
                    WritableWorkbook myxl=Workbook.createWorkbook(f2);
                    WritableSheet mysheet=myxl.createSheet("mysheet", 0);
                    stmt=con.prepareStatement("select * from certificate");
                    rs=stmt.executeQuery();
                    byte i,j=0;
                    ResultSetMetaData rsmd=rs.getMetaData();
                    for(i=0;i<rsmd.getColumnCount();i++){
                        l=new Label(i,0,rsmd.getColumnName(i+1));
                        mysheet.addCell(l);
                    }
                    while(rs.next())
                    {
                        ++j;
                        for(i=0;i<rsmd.getColumnCount();i++){
                            l=new Label(i,j,rs.getString(i+1));
                            mysheet.addCell(l);
                        }
                    }
                    myxl.write();
                    myxl.close();
                    f2.setReadOnly();
                } catch (IOException ex) {
                    Logger.getLogger(CertificatePage.class.getName()).log(Level.SEVERE, null, ex);
                } catch (WriteException ex) {
                    Logger.getLogger(CertificatePage.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
            Logger.getLogger(CertificatePage.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    
    
}
