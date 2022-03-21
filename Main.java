public class Main {
 
    MainFrame mainFrame;
    
    public Main() {
     this.mainFrame = new MainFrame();
    }
    
    public void mainOpen() {
     
     this.mainFrame.setVisible(true);
     this.mainFrame.setLocationRelativeTo(null);
    }
    
    public static void main(String[] args) {
     Main main = new Main();
     
     main.mainOpen();
    }
   }