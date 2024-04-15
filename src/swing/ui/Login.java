package swing.ui;

import swing.Start;

import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements Start {
    private JLabel username;
    private JLabel password;
    private JTextField txtusername;
    private JPasswordField txtpassword;
    private JButton jblogin;
    private JButton jbregister;

    public Login() {
        init();
    }

    private void init() {
        Container container=this.getContentPane();
        container.setLayout(null);
        username=new JLabel("用户名:");
        password=new JLabel("密码:");
        txtusername=new JTextField();
        txtpassword=new JPasswordField();
        jblogin=new JButton("登入");
        jbregister=new JButton("注册");

        username.setSize(70,40);
        username.setLocation(200,160);
        username.setFont(new Font("宋体",Font.PLAIN,20));

        password.setSize(70,40);
        password.setLocation(200,260);
        password.setFont(new Font("宋体",Font.PLAIN,20));

        txtusername.setSize(300,40);
        txtusername.setLocation(300,160);

        txtpassword.setSize(300,40);
        txtpassword.setLocation(300,260);

        jblogin.setSize(150,40);
        jblogin.setLocation(260,340);
        jblogin.setFont(new Font("宋体",Font.PLAIN,20));
        jblogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username=txtusername.getText();
                String password=new String(txtpassword.getPassword());
                //TODO
                if (false) {
                    JOptionPane.showMessageDialog(Login.this,"账号密码错误,请重试","登入失败",JOptionPane.WARNING_MESSAGE);
                }else {
                    Login.this.setVisible(false);
                    new UserUi().start();
                }
            }
        });



        jbregister.setSize(150,40);
        jbregister.setLocation(430,340);
        jbregister.setFont(new Font("宋体",Font.PLAIN,20));
        jbregister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Register register=new Register(Login.this,"注册");
            }
        });

        container.add(username);
        container.add(password);
        container.add(txtusername);
        container.add(txtpassword);
        container.add(jblogin);
        container.add(jbregister);

    }

    @Override
    public void start() {
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setTitle("通讯录");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }



    public JTextField getTxtusername() {
        return txtusername;
    }

    public JPasswordField getTxtpassword() {
        return txtpassword;
    }

    public JButton getJblogin() {
        return jblogin;
    }

    public JButton getJbregister() {
        return jbregister;
    }
}
