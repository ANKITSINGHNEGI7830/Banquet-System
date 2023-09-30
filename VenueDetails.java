package Project;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class VenueDetails extends Frame implements ActionListener
{
Frame frm;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
JTextField t1,t2,t3,t4,t5,t6;
Choice c1,c2,c3,c4;
JButton b1,b2;

String a1,a2,a3,a4,a5,a6,a7,a8,a9,a10;
Statement st;
Connection con;
ResultSet rec;
PreparedStatement pst;
public VenueDetails()
{
frm=new Frame("Venue Details");
l9=new JLabel("Booking id :");
l1=new JLabel("Venue Details");
l2=new JLabel("Customer Name :");
l3=new JLabel("Contact Number :");
l4=new JLabel("Customer Address");
l5=new JLabel("Date of Function :");
l6=new JLabel("Time of Function  :");
l7=new JLabel("Offered Amount :");
l8=new JLabel("Description :");
t1=new JTextField("");
t2=new JTextField("");
t3=new JTextField("");
t4=new JTextField("");
t5=new JTextField("");
t6=new JTextField("");
c1=new Choice();
c1.addItem("dd"); 
for (int i=0;i<=31;i++)
{
c1.addItem(""+i);
}
c2=new Choice();
c2.addItem("mm");
for(int i=1;i<=12;i++)
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
c4.addItem("Day Time");
c4.addItem("Night Time");
b1=new JButton("Submit");
b2=new JButton("Close");
}
public void setupVenueDetails()
{
frm.setSize(700,700);
frm.setVisible(true);
frm.setLayout(null);
l1.setBounds(50,50,100,50);
l9.setBounds(50,100,100,25);
t6.setBounds(200,100,150,25);
l2.setBounds(50,150,100,25);
t1.setBounds(200,150,150,25);
l3.setBounds(50,200,100,25);
t2.setBounds(200,200,150,25);
l4.setBounds(50,250,100,25);
t3.setBounds(200,250,150,25);
l5.setBounds(50,300,100,25);
c1.setBounds(200,300,50,25);
c2.setBounds(250,300,50,25);
c3.setBounds(300,300,50,25);
l6.setBounds(50,350,100,25);
c4.setBounds(200,350,150,25);
l7.setBounds(50,400,100,25);
t4.setBounds(200,400,150,25);
l8.setBounds(50,450,100,25);
t5.setBounds(200,450,150,25);


b1.setBounds(100,500,100,25);
b2.setBounds(250,500,100,25);
frm.add(l1);
frm.add(l2);
frm.add(l3);
frm.add(l4);
frm.add(l5);
frm.add(l6);
frm.add(l7);
frm.add(l8);
frm.add(l9);
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
frm.add(b1);
frm.add(b2);
b1.addActionListener(this);
b2.addActionListener(this);
}

public void getData()
{
try
{
a1=t1.getText();
a2=t2.getText();
a3=t3.getText();
a4=t4.getText();
a5=c1.getSelectedItem();
a6=c2.getSelectedItem();
a7=c3.getSelectedItem();
a8=c4.getSelectedItem();
a9=t5.getText();
a10=t6.getText();
}
catch(Exception ex)
{
System.out.println("getData Exception="+ex);
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
pst=con.prepareStatement ("insert into venuedetails values('"+a1+"',' "+a2+" ',' "+a3+" ',' "+a4+" ',' "+a5+" ','"+a6+"',' "+a7+" ',' "+a8+" ',' "+a9+" ',' "+a10+" ')");
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
if(a1.equals("")||a2.equals("")||a3.equals("")||a4.equals("")||a5.equals("")||a6.equals("")||a7.equals("")||a8.equals("")||a9.equals("")||a10.equals(""))
{
JOptionPane.showMessageDialog((Component) null,"Please fill all the details","Record",JOptionPane.ERROR_MESSAGE);
}
}
else
{
JOptionPane.showMessageDialog((Component) null,"Record Successfully entered","Record",JOptionPane.INFORMATION_MESSAGE);
conn();
putData();
}

if(ae.getSource()==b2)
{
frm.setVisible(false);
}
}
}
