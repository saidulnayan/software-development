
package login_view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import login_controller.controllerMain;
import login_model.loginModel;

public class loginView extends JFrame implements ActionListener
{ 
    public JLabel loginLabel=new JLabel();
    
    public Font font=new Font("Colabery", Font.BOLD,20);
    public Font font1=new Font("Colabery", Font.PLAIN,20);
    public Font font2=new Font("SansSerif", Font.BOLD,20);
    
    JTextField userText = new JTextField();
    JTextField passText = new JPasswordField();
    
    //public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    controllerMain conobj=new controllerMain();
    public infoView infoObj = new infoView();
    loginModel modelObj = new loginModel();
    
    
    public void loginButton()
    {
        JButton submitButton = new JButton();
        
        submitButton.setText("Login");
        submitButton.setBounds(620,320,105,35);
        submitButton.setFont(font2);
        submitButton.setBackground(Color.BLUE);
        submitButton.setForeground(Color.WHITE);
        submitButton.addActionListener(this);
        
        loginLabel.add(submitButton);
        
    }
    
    
    
    public void loginText()
    {
       
        
        userText.setBounds(500,163,350,30);
        userText.setFont(font);
        loginLabel.add(userText);
        
        passText.setBounds(500,257, 350, 30);
        passText.setFont(font);
        loginLabel.add(passText);
        
        
    }
    
    
    
    public void loginLabel()
    {
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/images/user.png"));
        JLabel label = new JLabel(imageIcon);
        label.setBounds(500,117,35,35);
        loginLabel.add(label);
        
        JLabel user_name=new JLabel("User Name");
        user_name.setBounds(542,115,250,50);
        user_name.setFont(font);
        loginLabel.add(user_name);
        
        ImageIcon imageIcon2 = new ImageIcon(getClass().getResource("/images/lock.png"));
        JLabel label2 = new JLabel(imageIcon2);
        label2.setBounds(500,211,35,35);
        loginLabel.add(label2);
        
        JLabel password=new JLabel("Password");
        password.setBounds(542,210,250,50);
        password.setFont(font);
        loginLabel.add(password);
        
        JLabel pic = new JLabel();
        pic.setBounds(0,0,950,511);
        pic.setIcon(new ImageIcon(getClass().getResource("/images/12.jpg")));
        loginLabel.add(pic);
        
        
    }
      
    public void loginFrame()
    {
       
        loginLabel();
        loginText();
        loginButton();
        loginLabel.setSize(950,550);
      
        add(loginLabel);
        
        setSize(950,550);
        
        //setSize(screenSize.width, screenSize.height);
        //setState(NORMAL);
        //setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Canteen Management System");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/logo.png")));
       
    }
    

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand()== "Login")
        {
          String user =  userText.getText();
          String pass = passText.getText();
          
          if(conobj.loginCheck(user, pass)==true)
            {
                loginLabel.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                // time delay
                try 
                {
                    TimeUnit.SECONDS.sleep(1);
                }   
                catch (InterruptedException ex)
                {
                    Logger.getLogger(infoView.class.getName()).log(Level.SEVERE, null, ex);
                }
                loginLabel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                
                //System.out.println("Welcome");
                loginLabel.removeAll();
                loginLabel.revalidate();
                loginLabel.repaint();
                loginLabel.remove(this);
              
                infoObj.showInfo(modelObj.getInfo(),modelObj.getInfoIncome());
             
          }    
          else 
          {
              //System.out.println("Invalid User");
              
              JOptionPane.showMessageDialog(null,"Invalid user name or password","warning",2);
              
          }
         
        }
    }

}
