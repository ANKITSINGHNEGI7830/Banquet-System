package Project;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class ChangePswd extends Frame implements ActionListener
{
Frame frm;
JLabel l1,l2,l3,l4;
JTextField t1,t2,t3,t4;
JButton b1,b2;
String a1,a2,a3,a4;

Connection con;
PreparedStatement pst;
ResultSet rec;
Statement st;



public ChangePswd()
{
frm =new Frame("change password");
l1=new JLabel("Enter user id");
l2=new JLabel("Enter Current Password");
l3=new JLabel("New Password");
l4=new JLabel("Re-enter New Password");
t1=new JTextField();
t2=new JTextField();
t3=new JTextField();
t4=new JTextField();
b1=new JButton("Update");
b2=new JButton("close");

}
public void setupChangePswd()
{
frm.setLayout(null);
frm.setVisible(true);
frm.setSize(500,500);
l1.setBounds(50,50,100,25);
t1.setBounds(200,50,100,25);
l2.setBounds(50,100,150,25);
t2.setBounds(200,100,100,25);
l3.setBounds(50,150,100,25);
t3.setBounds(200,150,100,25);
l4.setBounds(50,200,150,25);
t4.setBounds(200,200,100,25);
b1.setBounds(100,250,100,25);
b2.setBounds(250,250,150,25);
frm.add(l1);
frm.add(l2);
frm.add(l3);
frm.add(l4);
frm.add(t1);
frm.add(t2);
frm.add(t3);
frm.add(t4);
frm.add(b1);
frm.add(b2);
b1.addActionListener(this);
b2.addActionListener(this);
}
public void conn()
{
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con=DriverManager.getConnection("jdbc:odbc:MYDSN");
}
catch (Exception ex)
{
System.out.println("connection exception"+ex);
}
}
public void getData()
{
try
{
a1=t1.getText();
a2=t2.getText();
a3=t3.getText();
a4=t4.getText();
}
catch (Exception ex)
{
System.out.println(ex);
}
}
public void updateData()
{
try
{
pst=con.prepareStatement ("update createacc set psw='"+a3+"',repsw='"+a4+"' where userid='"+a1+"' and psw='"+a2+"' ");
pst.executeUpdate();
}
catch(SQLException se)
{
System.out.println("UPDATE ERROR"+se);
}
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
conn();
getData();
updateData();
}
else if(ae.getSource()==b2)
{
frm.setVisible(false);
}
}
}
