package Project;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Login extends Frame implements ActionListener
{
Frame frm;
JLabel l1,l2;
JTextField t1,t2;
JButton b1,b2,b3,b4;



Connection con;
PreparedStatement pst;
ResultSet rec;
Statement st;


public Login()
{
frm=new Frame("Login frame");
l1=new JLabel("User id");
l2=new JLabel("Password");
b3=new JButton("Forgot Password");
t1=new JTextField();
t2=new JTextField();
b1=new JButton("Login");
b2=new JButton("Exit");
b4=new JButton("change password");
}
public void setupLogin()
{
frm.setLayout(null);
frm.setVisible(true);
frm.setSize(500,500);

l1.setBounds(50,50,100,25);
t1.setBounds(200,50,100,25);
b1.setBounds(350,50,100,25);
l2.setBounds(50,100,100,25);
t2.setBounds(200,100,100,25);
b2.setBounds(350,100,100,25);
b3.setBounds(100,150,100,25);
b4.setBounds(250,150,100,25);

frm.add(l1);
frm.add(l2);
frm.add(b3);
frm.add(t1);
frm.add(t2);
frm.add(b1);
frm.add(b2);
frm.add(b4);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);


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
public void addSearchData()
{
try
{
conn();
String id=t1.getText();
String ps=t2.getText();
st=con.createStatement();	
rec=st.executeQuery("select * from createacc where userid='"+id+"' and psw='"+ps+"'");
if (rec.next())
{

JOptionPane.showMessageDialog((Component) null,"Login Successfully ","Record",JOptionPane.INFORMATION_MESSAGE);
AfterLogin frm=new AfterLogin();
frm.setupAfterLogin();
}
else
{
JOptionPane.showMessageDialog((Component) null,"Invalid user id or password","Record",JOptionPane.ERROR_MESSAGE);
}
}

catch(Exception ex)
{
System.out.println("getDate Exception="+ex);
}
}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
conn();
addSearchData();
}
else if (ae.getSource()==b2)
{
System.exit(0);
}
else if(ae.getSource()==b3)
{
ForgetPswd frm=new ForgetPswd();
frm.setupForgetPswd();
}
else if(ae.getSource()==b4)
{
ChangePswd frm=new ChangePswd();
frm.setupChangePswd();
}


}
}
