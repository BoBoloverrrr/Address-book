package swing.ui;

import swing.Start;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserUi extends JFrame implements Start {
    JTree jTree;
    JTable jTable;
    JScrollPane jScrollPane;
    DefaultMutableTreeNode treeroot,treechlid,nextparent;
    JTextField txtname;
    TreePath treePath;


    JButton add,delete,update;
    public UserUi() {
        init();
    }

    private void init() {
        Container container=this.getContentPane();
        container.setLayout(null);

        treeroot=new DefaultMutableTreeNode("我的好友");
        jTree =new JTree(treeroot);
        jScrollPane=new JScrollPane(jTree);
        txtname=new JTextField();
        add=new JButton("新增");
        delete=new JButton("删除");
        update=new JButton("修改");

        jTree.setFont(new Font("宋体",Font.PLAIN,20));
        jTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        jTree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                treePath=e.getPath();
            }
        });

        jScrollPane.setSize(200,520);
        jScrollPane.setLocation(10,10);

        txtname.setSize(200,30);
        txtname.setLocation(250,500);
        txtname.setFont(new Font("宋体",Font.PLAIN,20));

        add.setSize(80,30);
        add.setLocation(490,500);
        add.setFont(new Font("宋体",Font.PLAIN,20));
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isok=true;
                treechlid=(DefaultMutableTreeNode) jTree.getLastSelectedPathComponent();
                if (treechlid!=null&&nextparent==null) {
                    nextparent=treechlid;
                }else if (treechlid==null) {
                    if (nextparent!=null) {
                        treechlid=nextparent;
                    }else {
                        isok=false;
                        JOptionPane.showMessageDialog(UserUi.this,"请选中添加到的分组","新增分组失败",JOptionPane.WARNING_MESSAGE);
                    }
                }
                if(isok) {
                    String name=txtname.getText();
                    if("".equals(name)||name==null) {
                        JOptionPane.showMessageDialog(UserUi.this,"请输入分组的名字","新增分组失败",JOptionPane.WARNING_MESSAGE);
                    }else {
                        treechlid.add(new DefaultMutableTreeNode(name));
                        txtname.setText("");
                        jTree.expandPath(treePath);
                        jTree.updateUI();
                    }

                }


            }
        });

        update.setSize(80,30);
        update.setLocation(580,500);
        update.setFont(new Font("宋体",Font.PLAIN,20));

        delete.setSize(80,30);
        delete.setLocation(670,500);
        delete.setFont(new Font("宋体",Font.PLAIN,20));

        container.add(jScrollPane);
        container.add(txtname);
        container.add(add);
        container.add(update);
        container.add(delete);

    }

    @Override
    public void start() {
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setTitle("通讯录");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
