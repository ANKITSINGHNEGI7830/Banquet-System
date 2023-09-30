package Project;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class SearchBooking extends Frame implements ActionListener
{
Frame frm;
JLabel l1,l2;
Choice c1,c2,c3,c4,c5,c6;
JButton b1,b2;

Connection con;
Statement st;
ResultSet rec;
PreparedStatement pst;

String a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14;
 
public SearchBooking()
{
frm= new Frame("searching Booking");
l1=new JLabel("Start Date :");
l2=new JLabel("End Date :");
c1= new Choice();
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
for (int i=2019;i<=2100;i++)
{
c3.addItem(""+i);
}
c4=new Choice();
c4.addItem("dd");
for (int i=1;i<=31;i++)
{
c1.addItem(""+i);
}
c5=new Choice();
c5.addItem("mm");
for (int i=1;i<=12;i++)
{
c2.addItem(""+i);
}
c6=new Choice();
c6.addItem("yyyy");
for (int i=2019;i<=2100;i++)
{
c3.addItem(""+i);
}
b1=new JButton("Search");
b2=new JButton("Close");
addSearchBooking();
}
public void setupSearchBooking()
{
frm.setVisible(true);
frm.setSize(1000,1000);
frm.setLayout(null);
l1.setBounds(50,100,100,25);
c1.setBounds(200,100,50,25);
c2.setBounds(250,100,50,25);
c3.setBounds(300,100,50,25);
l2.setBounds(400,100,100,25);
c4.setBounds(550,100,50,25);
c5.setBounds(600,100,50,25);
c6.setBounds(650,100,50,25);
b1.setBounds(100,150,100,25);
b2.setBounds(250,150,100,25);

frm.add(l1);
frm.add(l2);
frm.add(c1);
frm.add(c2);
frm.add(c3);
frm.add(c4);
frm.add(c5);
frm.add(c6);
frm.add(b1);
frm.add(b2);
b1.addActionListener(this);
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

public void addSearchBooking()
{
try
{
conn();
st=con.createStatement();	
rec=st.executeQuery("select * from bookdetails");
while(rec.next())
{
c1.addItem(rec.getString(4));
c2.addItem(rec.getString(5));
c3.addItem(rec.getString(6));

}
}
catch (Exception ex)
{
System.out.println("add view booking exception"+ex);
}
}

public void delData()
{
try
{
pst=con.prepareStatement ("delete from searchbooking");
pst.executeUpdate();
}
catch(SQLException se)
{
System.out.println("del data error"+se);
}
}

public void addSearchBookData()
{
try
{
conn();
st=con.createStatement();	
String ad=c1.getSelectedItem();
String sd=c2.getSelectedItem();
String fd=c3.getSelectedItem();
rec=st.executeQuery("select * from bookdetails where dateoffun='"+ad+"' and monthoffun='"+sd+"' and yearoffun='"+fd+"'");
if(rec.next())
{

//JOptionPane.showMessageDialog((Component) null," Data Found","Record ",JOptionPane.ERROR_MESSAGE);




a1=rec.getString(1);
a2=rec.getString(2);
a3=rec.getString(3);
a4=rec.getString(4);
a5=rec.getString(5);
a6=rec.getString(6);
a7=rec.getString(7);
a8=rec.getString(8);
a9=rec.getString(9);
a10=rec.getString(10);
a11=rec.getString(11);
a12=rec.getString(12);
a13=rec.getString(13);
a14=rec.getString(14);
pst=con.prepareStatement ("insert into searchbooking values('"+a1+"',' "+a2+" ',' "+a3+" ',' "+a4+" ',' "+a5+" ','"+a6+"',' "+a7+" ',' "+a8+" ',' "+a9+" ',' "+a10+" ',' "+a11+" ',' "+a12+" ',' "+a13+" ',' "+a14+" ')");
pst.executeUpdate();

}
else
{
JOptionPane.showMessageDialog((Component) null,"No Data","Record",JOptionPane.ERROR_MESSAGE);
}
}
catch (Exception ex)
{
System.out.println("add search data error"+ex);
}
}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
conn();
delData();
addSearchBookData();
}
else if(ae.getSource()==b2)
{
frm.setVisible(false);
}
}
}


