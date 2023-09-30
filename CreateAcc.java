package Project;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
public class CreateAcc extends Frame implements ActionListener
{
Frame frm;
JLabel l1,l2,l3,l4,l5;
JTextField t1,t2,t3,t4;
JButton b1,b2;
Choice c1;
String a1,a2,a3,a4,a5;

Connection con;
PreparedStatement pst;
ResultSet rec;
Statement st;

public CreateAcc()
{
frm=new Frame("Login frame");
l1=new JLabel("User id");
l2=new JLabel("Enter Password");
l3=new JLabel("Re-enter Password");
l4=new JLabel("Security question");
l5=new JLabel("Answer");
t1=new JTextField();
t2=new JTextField();
t3=new JTextField();
t4=new JTextField();
b1=new JButton("Login");
b2=new JButton("Exit");
c1=new Choice();
c1.addItem("what is your favourite color");
c1.addItem("what is your date of birth");
c1.addItem("what is your height");
}
public void setupCreateAcc()
{
frm.setLayout(null);
frm.setVisible(true);
frm.setSize(700,700);
l1.setBounds(50,100,100,25);
t1.setBounds(200,100,100,25);
l2.setBounds(50,150,100,25);
t2.setBounds(200,150,100,25);
l3.setBounds(50,200,100,25);
t3.setBounds(200,200,100,25);
l4.setBounds(50,250,100,25);
c1.setBounds(200,250,200,25);
l5.setBounds(50,300,100,25);
t4.setBounds(200,300,100,25);
b1.setBounds(100,350,100,25);
b2.setBounds(250,350,100,25);

b1.addActionListener(this);
b2.addActionListener(this);


frm.add(l1);
frm.add(l2);
frm.add(l3);
frm.add(t1);
frm.add(t2);
frm.add(b1);
frm.add(b2);
frm.add(l4);
frm.add(l5);
frm.add(t3);
frm.add(t4);
frm.add(c1);
}
public void getData()
{
try
{
a1=t1.getText();
a2=t2.getText();
a3=t3.getText();
a4=c1.getSelectedItem();
a5=t4.getText();

}
catch(Exception ex)
{
System.out.println("getDataException="+ex);
}
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

public void putData()
{
try
{
pst=con.prepareStatement ("insert into createacc values('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"')");
pst.executeUpdate();
}
catch(SQLException se)
{
System.out.println("put data error"+se);
}
}



public void actionPerformed(ActionEvent ae)
{
getData();
if(a1.equals("")||a2.equals("")||a3.equals("")||a4.equals("")||a5.equals(""))
{
JOptionPane.showMessageDialog((Component) null,"Please fill all the details","Record",JOptionPane.ERROR_MESSAGE);
}
else
{
JOptionPane.showMessageDialog((Component) null,"Record Successfully entered","Record",JOptionPane.INFORMATION_MESSAGE);
conn();
putData();
}
if(ae.getSource()==b2)
{
System.exit(0);
}
}
}

