package swing.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JDialog {
    private JLabel JLusername;
    private JLabel JLpassword;
    private JTextField txtusername;
    private JPasswordField txtpassword;
    private JButton jbok;
    private JButton jbreturn;
    private String username;
    private String password;

    public Register(Frame frame,String title) {
        super(frame,title);
        init();
    }

    private void init() {
        Container container=this.getContentPane();
        container.setLayout(null);
        JLusername =new JLabel("用户名:");
        JLpassword =new JLabel("密码:");
        txtusername=new JTextField();
        txtpassword=new JPasswordField();
        jbok =new JButton("完成");
        jbreturn =new JButton("返回");

        JLusername.setSize(70,40);
        JLusername.setLocation(100,60);
        JLusername.setFont(new Font("宋体",Font.PLAIN,20));

        JLpassword.setSize(70,40);
        JLpassword.setLocation(100,160);
        JLpassword.setFont(new Font("宋体",Font.PLAIN,20));

        txtusername.setSize(300,40);
        txtusername.setLocation(200,60);

        txtpassword.setSize(300,40);
        txtpassword.setLocation(200,160);

        jbok.setSize(150,40);
        jbok.setLocation(130,240);
        jbok.setFont(new Font("宋体",Font.PLAIN,20));
        jbok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                username=txtusername.getText();
                password=new String(txtpassword.getPassword());
                if((username == null) || (password == null))
                    JOptionPane.showMessageDialog(Register.this,"账号密码错误,请重试","登入失败",JOptionPane.WARNING_MESSAGE);

                else{
                    JOptionPane.showMessageDialog(Register.this,"注册成功");

                Register.this.dispose();}
            }
        });

        jbreturn.setSize(150,40);
        jbreturn.setLocation(320,240);
        jbreturn.setFont(new Font("宋体",Font.PLAIN,20));
        jbreturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Register.this.dispose();
            }
        });


        container.add(JLusername);
        container.add(JLpassword);
        container.add(txtusername);
        container.add(txtpassword);
        container.add(jbok);
        container.add(jbreturn);

        this.setSize(600,400);
        this.setLocationRelativeTo(null);
        this.setModal(true);

        this.setVisible(true);

    }


}
