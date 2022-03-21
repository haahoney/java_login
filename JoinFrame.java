	
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
 
public class JoinFrame extends JFrame {
 
 private JButton btn_join;
 private JTextField txt_id, txt_name, txt_age;
    private JLabel label_id, label_pw, label_name, label_age;
 private JPasswordField txt_pw;
 
 public JoinFrame() {
  this.setSize(230, 250);
  
  JPanel panel_main = new JPanel();
  
  this.label_id = new JLabel("  ID    : ");
  panel_main.add(this.label_id);
  
  this.txt_id = new JTextField(12);
  panel_main.add(this.txt_id);
  
  this.label_pw = new JLabel("   PW   : ");
  panel_main.add(this.label_pw);
  
  this.txt_pw = new JPasswordField(12);
  panel_main.add(this.txt_pw);
  
  this.label_name = new JLabel("  이름    : ");
  panel_main.add(this.label_name);
  
  this.txt_name = new JTextField(12);
  panel_main.add(this.txt_name);
  
  this.label_age = new JLabel("  나이    : ");
  panel_main.add(this.label_age);
  
  this.txt_age = new JTextField(12);
  panel_main.add(this.txt_age);
  
  ActionHandler actionHandler = new ActionHandler();
  
  this.btn_join = new JButton("가입하기");
  this.btn_join.setSize(100, 20);
  this.btn_join.addActionListener(actionHandler);
  panel_main.add(this.btn_join);
  
  this.add(panel_main);
 }
 
 public void joinUser() {
  String id = txt_id.getText();
  String pw = txt_pw.getText();
  String name = txt_name.getText();
  String age = txt_age.getText();
  
  File file = new File("data/information");
  try {
   FileWriter fw = new FileWriter(file,true);
   fw.write(id + "  " + pw +  "  " + name +  "  " + age +"\n");
   fw.flush();
 
   JOptionPane.showMessageDialog(null, "회원가입에 성공하셨습니다. 메인 페이지로 돌아갑니다.");
  
   this.setVisible(false);
  } catch (IOException e) {
   // TODO Auto-generated catch block
   JOptionPane.showMessageDialog(null, "회원가입에 실패하셨습니다. 메인 페이지로 돌아갑니다.");
   
   e.printStackTrace();
  }
  }
 
 public class ActionHandler implements ActionListener{
 
  @Override
  public void actionPerformed(ActionEvent e) {
   joinUser();
  }
  
 }
}