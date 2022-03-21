	
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
 
public class LoginFrame extends JFrame {
 private JButton btn_login, btn_new;
 private JTextField txt_id, txt_pw;
 private JLabel label_id, label_pw;
 
 public LoginFrame() {
  this.setSize(230, 150);
 
  JPanel panel_main = new JPanel();
 
  this.label_id = new JLabel("  ID    : ");
  panel_main.add(this.label_id);
 
  this.txt_id = new JTextField(12);
  panel_main.add(this.txt_id);
 
  this.label_pw = new JLabel("   PW   : ");
  panel_main.add(this.label_pw);
 
  this.txt_pw = new JTextField(12);
  panel_main.add(this.txt_pw);
 
  ActionHandler actionHandler = new ActionHandler();
  
  this.btn_login = new JButton("로그인");
  this.btn_login.addActionListener(actionHandler);
  this.btn_login.setSize(100, 20);
  panel_main.add(this.btn_login);
 
  this.add(panel_main);
 }
 
 public void validateUser() {
  String ID = txt_id.getText();
  String Password = txt_pw.getText();
 
  File file = new File("data/information");
  try {
   Scanner sc = new Scanner( file );
   while(sc.hasNext()) {
    String id_infor = sc.next();
    String pw_infor = sc.next();
    String name_infor = sc.next();
    int age_infor = sc.nextInt();
 
    if(ID.equals(id_infor) && Password.equals(pw_infor)) {
     JOptionPane.showMessageDialog(null, name_infor + "님 환영합니다.");
     
     System.exit(0);
    }
   }
  } catch (FileNotFoundException e) {
   e.printStackTrace();
  }
  
  JOptionPane.showMessageDialog(null, "로그인에 실패하셨습니다.");
 }
 
 class ActionHandler implements ActionListener{
 
  @Override
  public void actionPerformed(ActionEvent e) {
   validateUser();
  }
  
 }
}