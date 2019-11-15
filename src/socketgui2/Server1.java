/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketgui2;
import java.net.*;  
import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.*;
import static socketgui2.Client1.din;
public class Server1 extends javax.swing.JFrame {
static ServerSocket ss;  
	static Socket s;  
	static DataInputStream din;  
	static DataOutputStream dout;  
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public Server1() {
        initComponents();
    }
    
    public static String cal(String mrk){
        String grade="";
        Integer val = Integer.parseInt(mrk);
        if(val>100)
            grade="Invalid";
        else if(val<0)
            grade="Invalid";
        else if(val>79)
            grade="A+ | 4.00";
        else if(val>74)
            grade="A  | 3.75";
        else if(val>69)
            grade="A- | 3.50";
        else if(val>64)
            grade="B+ | 3.25";
        else if(val>59)
            grade="B  | 3.00";
        else if(val>54)
            grade="B- | 2.75";
        else if(val>49)
            grade="C+ | 2.50";
        else if(val>44)
            grade="C  | 2.25";
        else if(val>39)
            grade="D  | 2.00";
        else if(val>=0 && val<40)
            grade="F  | 0.00";
        else
            grade="Invalid";
        
        return grade;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Server1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server1().setVisible(true);
            }
        });
        try{	
	ss=new ServerSocket(3333);  
	s=ss.accept();  
	din=new DataInputStream(s.getInputStream());  
	dout=new DataOutputStream(s.getOutputStream());  
	br=new BufferedReader(new InputStreamReader(System.in));  
	  
	String s1="",s2="",s3="",s4="",s5="",s6="";  
        while(!s1.equals("00")){ 
                s1=din.readUTF();
                s2=din.readUTF();
                s3=din.readUTF();
                s4=din.readUTF();
                s5=din.readUTF();
                s6=din.readUTF();
		//System.out.println("point "+s1);
                s1=cal(s1);
                s2=cal(s2);
                s3=cal(s3);
                s4=cal(s4);
                s5=cal(s5);
                s6=cal(s6);
                
                
                System.out.println("point "+s1);
                
                dout.writeUTF(s1); 
                dout.writeUTF(s2); 
                dout.writeUTF(s3); 
                dout.writeUTF(s4); 
                dout.writeUTF(s5); 
                dout.writeUTF(s6); 
                
                dout.flush();
                System.out.println("data sent");
	}  
	din.close();  
	s.close();  
	ss.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
