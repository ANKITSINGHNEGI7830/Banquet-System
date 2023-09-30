package Project;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
public class  ViewBooking extends Frame implements ItemListener,ActionListener
{
Frame frm;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
JTextField t1,t2,t6,t7,t8,t9,t10,t11,t12,t13;
Choice c1,c2,c3,c4;
JButton b1;

String a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14;
Connection con;
Statement st;
ResultSet rec;
PreparedStatement pst;

public ViewBooking()
{
frm=new Frame("Sales Details");
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
t1=new JTextField("");
t2=new JTextField("");
c2=new Choice();
c3=new Choice();
c4=new Choice();
t6=new JTextField("");
t7=new JTextField("");

t8=new JTextField();
t9=new JTextField();
t10=new JTextField();
t11=new JTextField(); 
t12=new JTextField();
t13=new JTextField();

c1=new Choice();
b1=new JButton("Close");
addViewBooking();

}
public void setupViewBooking()
{
frm.setSize(1000,1000);
frm.setVisible(true);
frm.setLayout(null);
l1.setBounds(50,100,100,25);
c1.setBounds(200,100,100,25);
l2.setBounds(50,150,100,25);
t1.setBounds(200,150,100,25);
l3.setBounds(50,200,100,25);
t2.setBounds(200,200,100,25);
l4.setBounds(350,100,100,25);
c2.setBounds(500,100,50,25);
c3.setBounds(550,100,50,25);
c4.setBounds(600,100,50,25);
l5.setBounds(50,250,100,25);
t6.setBounds(200,250,100,25);
l6.setBounds(50,300,100,25);
t7.setBounds(200,300,100,25);
l7.setBounds(50,350,100,25);
t8.setBounds(200,350,100,25);
l8.setBounds(50,400,100,25);
t9.setBounds(200,400,100,25);
l9.setBounds(50,450,100,25);
t10.setBounds(200,450,100,25);
l10.setBounds(50,500,100,25);
t11.setBounds(200,500,100,25);
l11.setBounds(50,550,100,25);
t12.setBounds(200,550,100,25);
l12.setBounds(50,600,100,25);
t13.setBounds(200,600,100,25);
b1.setBounds(100,650,100,25);
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
frm.add(t1);
frm.add(c2);
frm.add(c3);
frm.add(c4);
frm.add(t2);
frm.add(t6);
frm.add(t7);
frm.add(t8);
frm.add(t9);
frm.add(t10);
frm.add(t11);
frm.add(t12);
frm.add(t13);
frm.add(c1);
frm.add(b1);

c1.addItemListener(this);
c2.addItemListener(this);
c3.addItemListener(this);
c4.addItemListener(this);
b1.addActionListener(this);




}

public void getData()
{
try
{
a1=c1.getSelectedItem();
a2=t1.getText();
a3=t2.getText();
a4=c2.getSelectedItem();
a5=c3.getSelectedItem();
a6=c4.getSelectedItem();
a7=t6.getText();
a8=t7.getText();
a9=t8.getText();
a10=t9.getText();
a11=t10.getText();
a12=t11.getText();
a13=t12.getText();
a14=t13.getText();
}
catch (Exception ex)
{
System.out.println(" get data exception"+ex);
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

public void addViewBooking()
{
try
{
conn();
st=con.createStatement();	
rec=st.executeQuery("select * from bookdetails");
while(rec.next())
{
c1.addItem(rec.getString(1));
c2.addItem(rec.getString(4));
c3.addItem(rec.getString(5));
c4.addItem(rec.getString(6));
}
}
catch (Exception ex)
{
System.out.println("add view booking exception"+ex);
}
}


public void addSearchBookData()
{
try
{
conn();
st=con.createStatement();
String cd=c1.getSelectedItem();	
rec=st.executeQuery("select * from bookdetails where bookingid='"+cd+"'");
if(rec.next())
{
t1.setText(rec.getString(2));
t2.setText(rec.getString(3));
t6.setText(rec.getString(7));
t7.setText(rec.getString(8));
t8.setText(rec.getString(9));
t9.setText(rec.getString(10));
t10.setText(rec.getString(11));
t11.setText(rec.getString(12));
t12.setText(rec.getString(13));
t13.setText(rec.getString(14));

}
else
{
JOptionPane.showMessageDialog((Component) null,"No Data","Record",JOptionPane.ERROR_MESSAGE);
}
}
catch (Exception ex)
{
System.out.println(ex);
}
}

public void addSearchBookData2()
{
try
{
conn();
st=con.createStatement();	
String ad=c2.getSelectedItem();
String sd=c3.getSelectedItem();
String fd=c4.getSelectedItem();
rec=st.executeQuery("select * from bookdetails where dateoffun='"+ad+"' and monthoffun='"+sd+"' and yearoffun='"+fd+"'");
if(rec.next())
{
t1.setText(rec.getString(2));
t2.setText(rec.getString(3));
t6.setText(rec.getString(7));
t7.setText(rec.getString(8));
t8.setText(rec.getString(9));
t9.setText(rec.getString(10));
t10.setText(rec.getString(11));
t11.setText(rec.getString(12));
t12.setText(rec.getString(13));
t13.setText(rec.getString(14));

}
else
{
JOptionPane.showMessageDialog((Component) null,"No Data","Record",JOptionPane.ERROR_MESSAGE);
}
}
catch (Exception ex)
{
System.out.println(ex);
}
}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
frm.setVisible(false);
}
}

public void itemStateChanged(ItemEvent ie)
{
if(ie.getSource()==c1)
{
conn();
addSearchBookData();
}
else if(ie.getSource()==c2)
{
conn();
addSearchBookData2();
}
else if(ie.getSource()==c3)
{
conn();
addSearchBookData2();
}
else if(ie.getSource()==c4)
{
conn();
addSearchBookData2();
}
}
}
