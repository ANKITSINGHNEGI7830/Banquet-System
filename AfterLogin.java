package Project;
import java.awt.*;
import java.awt.event.*;
public class AfterLogin extends Frame implements ActionListener
{
Frame frm;
MenuBar mb;
Menu mnurec,mnusal,mnuupd,mnuview,mnusearch,mnucancel,mnuhelp;
MenuItem m1,m2,m3,m4,m5,m6,m7;

public AfterLogin()
{

frm=new Frame("After login");
mb=new MenuBar();
mnurec=new Menu("Venue");
m1=new MenuItem("Venues Details");
mnusal=new Menu("Sales");
m2=new MenuItem("Sales Details");
mnuupd=new Menu("Update ");
m3=new MenuItem("Update Booking");
mnuview=new Menu("View");
m4=new MenuItem("View Booking");
mnusearch=new Menu("Search");
m5=new MenuItem("Search Booking");
mnucancel=new Menu("Cancel");
m6=new MenuItem("Cancel Booking");
mnuhelp=new Menu("Help");
m7=new MenuItem("About us");
}
public void setupAfterLogin()
{
frm.setVisible(true);
mnurec.add(m1);
mnusal.add(m2);
mnuupd.add(m3);
mnuview.add(m4);
mnusearch.add(m5);
mnucancel.add(m6);
mnuhelp.add(m7);
mb.add(mnurec);
mb.add(mnusal);
mb.add(mnuupd);
mb.add(mnuview);
mb.add(mnusearch);
mb.add(mnucancel);
mb.add(mnuhelp);

frm.setMenuBar(mb);
m1.addActionListener(this);
m2.addActionListener(this);
m3.addActionListener(this);
m4.addActionListener(this);
m5.addActionListener(this);
m6.addActionListener(this);
m7.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==m1)
{
VenueDetails frm=new VenueDetails();
frm.setupVenueDetails();
}
else if(ae.getSource()==m2)
{
SalesDetails frm=new SalesDetails();
frm.setupSalesDetails();
}
else if(ae.getSource()==m3)
{
UpdateTransaction frm=new UpdateTransaction();
frm.setupUpdateTransaction();
}
else if(ae.getSource()==m4)
{
ViewBooking frm=new ViewBooking();
frm.setupViewBooking();
}
else if(ae.getSource()==m5)
{
SearchBooking frm=new SearchBooking();
frm.setupSearchBooking();
}
else if(ae.getSource()==m6)
{
CancelBooking frm=new CancelBooking();
frm.setupCancelBooking();
}


}
}
