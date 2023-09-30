package Project;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class ForgetPswd extends Frame implements ActionListener
{
Frame frm;
JLabel l1,l2,l3,l4,l5,l6;
JTextField t1,t2;
JButton b1,b2,b3;

Connection con;
PreparedStatement pst;
ResultSet rec;
Statement st;

public ForgetPswd()
{
frm =new Frame("forget password");
l1=new JLabel("Enter user id");
l2=new JLabel("Your sequrity question");
l3=new JLabel("jhsfjhshfs");
l4=new JLabel("Give answer");
l5=new JLabel("Your password is");
l6=new JLabel("kjdsfjdfjsjd");
t1=new JTextField();
t2=new JTextField();
b1=new JButton("search");
b2=new JButton("Retrive");
b3=new JButton("close");
}
public void setupForgetPswd()
{
frm.setLayout(null);
frm.setVisible(true);
frm.setSize(500,500);
l1.setBounds(50,50,100,25);
t1.setBounds(200,50,100,25);
b1.setBounds(350,50,100,25);
l2.setBounds(50,100,150,25);
l3.setBounds(200,100,150,25);
l4.setBounds(50,150,100,25);
t2.setBounds(200,150,100,25);
b2.setBounds(350,150,100,25);
l5.setBounds(50,200,100,25);
l6.setBounds(200,200,100,25);
b3.setBounds(350,200,100,25);
frm.add(l1);
frm.add(l2);
frm.add(l3);
frm.add(l4);
frm.add(l5);
frm.add(l6);
frm.add(t1);
frm.add(t2);
frm.add(b1);
frm.add(b2);
frm.add(b3);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
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
public void getsq()
{
try
{
conn();
st=con.createStatement();
String id=t1.getText();	
rec=st.executeQuery("select * from createacc where userid='"+id+"'");
if(rec.next())
{
l3.setText(rec.getString(4));
}
else
{
l3.setText("invalid ID");
}
}
catch (Exception ex)
{
System.out.println(ex);
}
}
public void getre()
{
try
{
conn();
st=con.createStatement();
String id=t1.getText();
String ans=t2.getText();	
rec=st.executeQuery("select * from createacc where userid='"+id+"' and answer='"+ans+"'" );
if(rec.next())
{
l6.setText(rec.getString(2));
}
else
{
l6.setText("invalid answer");
}
}
catch (Exception ex)
{
System.out.println(ex);
}
}

public void actionPerformed(ActionEvent ae)
{
if (ae.getSource()==b1)
{
getsq();
}
else if(ae.getSource()==b2)
{
getre();
}
else if(ae.getSource()==b3)
{
frm.setVisible(false);
}
}
}