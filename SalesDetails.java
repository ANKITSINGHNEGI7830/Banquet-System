package Project;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class SalesDetails extends Frame implements ActionListener
{
Frame frm;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
JTextField t1,t2,t3,t4,t5,t6,t7;
Choice c1,c2,c3,c4,c5,c6,c7,c8;
JButton b1,b2,b3;
Random rd;

String a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15;
Connection con;
Statement st;
ResultSet rec;
PreparedStatement pst;

public SalesDetails()
{
frm=new Frame("Sales Details");
rd=new Random();
l1=new JLabel("Booking id :");
l2=new JLabel("Customer Name :");
l3=new JLabel("Contact Number :");
l4=new JLabel("Date of Function :");
l5=new JLabel("Gathering :");
l6= new JLabel("Shift of Fuction :");
l7=new JLabel("Menu :");
l8=new JLabel("Hall :");
l9=new JLabel("Total Amount :");
l10=new JLabel("Paid Amount :");
l11=new JLabel("Pay Method:");
l12=new JLabel("Description :");
l13=new JLabel("Statement :");
t1=new JTextField("");
t2=new JTextField("");
t3=new JTextField("");
t4=new JTextField("");
t5=new JTextField("");
t6=new JTextField("");
t7=new JTextField("");
c1=new Choice();
c1.addItem("dd");
for (int i=1;i<=31;i++)
{
c1.addItem(""+i);
}
c2=new Choice();
c2.addItem("mm");
for (int i=1;i<=12;i++)
{
c2.addItem(""+i);
}
c3=new Choice();
c3.addItem("yyyy");
for(int i=2019;i<=2100;i++)
{
c3.addItem(""+i);
}
c4=new Choice();
c4.addItem("select");
c4.addItem("Day Shift");
c4.addItem("Night Shift");
c5=new Choice(); 
c5.addItem("select");
c5.addItem("Gold Menu");
c5.addItem("Daimond Menu");
c6=new Choice();  
c6.addItem("select");
c6.addItem("Ground Hall");
c6.addItem("First Hall");
c6.addItem("Second Hall");
c7=new Choice();
c7.addItem("select");
c7.addItem("No paid yet");
c7.addItem("Cheque");
c7.addItem("Cash");
c8=new Choice();
c8.addItem("select");
c8.addItem("Booked");
c8.addItem("Not Confrimed");
b1=new JButton("Submit");
b2=new JButton("Close");
b3=new JButton("New Booking id");
t1.setEditable(false);
}
public void setupSalesDetails()
{
frm.setSize(1000,1000);
frm.setVisible(true);
frm.setLayout(null);
l1.setBounds(50,100,100,25);
t1.setBounds(200,100,100,25);
l2.setBounds(50,150,100,25);
t2.setBounds(200,150,100,25);
l3.setBounds(50,200,100,25);
t3.setBounds(200,200,100,25);
l4.setBounds(50,250,100,25);
c1.setBounds(200,250,50,25);
c2.setBounds(250,250,50,25);
c3.setBounds(300,250,50,25);
l5.setBounds(50,300,100,25);
t4.setBounds(200,300,100,25);
l6.setBounds(50,350,100,25);
c4.setBounds(200,350,100,25);
l7.setBounds(50,400,100,25);
c5.setBounds(200,400,100,25);
l8.setBounds(500,100,100,25);
c6.setBounds(650,100,100,25);
l9.setBounds(500,150,100,25);
t5.setBounds(650,150,100,25);
l10.setBounds(500,200,100,25);
t6.setBounds(650,200,100,25);
l11.setBounds(500,250,100,25);
c7.setBounds(650,250,100,25);
l12.setBounds(500,300,100,25);
t7.setBounds(650,300,100,25);
l13.setBounds(500,350,100,25);
c8.setBounds(650,350,100,25);
b1.setBounds(500,400,100,25);
b2.setBounds(650,400,100,25);
b3.setBounds(350,100,100,25);
frm.add(l1);
frm.add(l2);
frm.add(l3);
frm.add(l4);
frm.add(l5);
frm.add(l6);
frm.add(l7);
frm.add(l8);
frm.add(l9);
frm.add(l10);
frm.add(l11);
frm.add(l12);
frm.add(l13);
frm.add(t1);
frm.add(t2);
frm.add(t3);
frm.add(t4);
frm.add(t5);
frm.add(t6);
frm.add(c1);
frm.add(c2);
frm.add(c3);
frm.add(c4);
frm.add(c5);
frm.add(c6);
frm.add(c7);
frm.add(c8);
frm.add(t7);
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
public void getData()
{
try
{
a1=t1.getText();
a2=t2.getText();
a3=t3.getText();
a4=c1.getSelectedItem();
a5=c2.getSelectedItem();
a6=c3.getSelectedItem();
a7=t4.getText();
a8=c4.getSelectedItem();
a9=c5.getSelectedItem();
a10=c6.getSelectedItem();
a11=t5.getText();
a12=t6.getText();
a13=c7.getSelectedItem();
a14=t7.getText();
a15=c8.getSelectedItem();
}
catch(Exception ex)
{
System.out.println("getData Exception="+ex);
}
}
public void putData()
{
try
{
pst=con.prepareStatement ("insert into bookdetails values('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"','"+a7+"','"+a8+"','"+a9+"','"+a10+"','"+a11+"','"+a12+"','"+a13+"','"+a14+"','"+a15+"')");
pst.executeUpdate();
}
catch(SQLException se)
{
System.out.println("put data error"+se);
}
}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
getData();
if(a1.equals("")||a2.equals("")||a3.equals("")||a4.equals("")||a5.equals("")||a6.equals("")||a7.equals("")||a8.equals("")||a9.equals("")||a10.equals("")||a11.equals("")||a12.equals("")||a13.equals("")||a14.equals("")||a10.equals(""))
{
JOptionPane.showMessageDialog((Component) null,"Please fill all the details","Record",JOptionPane.ERROR_MESSAGE);
}
else
{
JOptionPane.showMessageDialog((Component) null,"Record Successfully entered","Record",JOptionPane.INFORMATION_MESSAGE);
conn();
putData();

}
}
if(ae.getSource()==b2)
{
frm.setVisible(false);
}
else if(ae.getSource()==b3)
{
String rdd=rd.nextInt(10)+""+rd.nextInt(10)+""+rd.nextInt(10)+""+rd.nextInt(10);
t1.setText(rdd);

}
}
}
