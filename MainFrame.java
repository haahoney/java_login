	
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class MainFrame extends JFrame {
 
 JPanel panel;
 
 JoinFrame joinFrame;
 LoginFrame loginFrame;
 
 public MainFrame() {
  this.setSize(500,500);
  
  this.panel = new JPanel();
  
  ActionHandler actionHandler = new ActionHandler();
   
  JButton login = new JButton("로그인");
  login.addActionListener(actionHandler);
  
  JButton join = new JButton ("회원가입");
  join.addActionListener(actionHandler);
  
  this.panel.add(login);
  this.panel.add(join);
  
  this.add(panel);
 }
 
 public void login() {
  loginFrame = new LoginFrame();
  loginFrame.setVisible(true);
  loginFrame.setLocationRelativeTo(null);
 }
 
 public void join() {
  joinFrame = new JoinFrame();
  joinFrame.setVisible( true );
  joinFrame.setLocationRelativeTo(null);
  
 }
 
 public class ActionHandler implements ActionListener {
 
  @Override
  public void actionPerformed(ActionEvent e) {
   String sign = e.getActionCommand();
   
   if ( sign.equals("회원가입")) {
    join();
   }
   else if ( sign.equals("로그인")) {
    login();
   }
  }
 
 }
}