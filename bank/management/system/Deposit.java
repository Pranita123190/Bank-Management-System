package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Deposit extends JFrame implements ActionListener{
	JTextField amount;
	JButton deposit,back;    //globally defind
	String pinnumber;
	
	Deposit(String pinnumber){
		this.pinnumber=pinnumber;
		setLayout(null);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text=new JLabel("Enter the amount you want to deposite");
		text.setForeground(Color.white);
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setBounds(170,300,400,20);
		image.add(text);
		
		 amount=new JTextField();
		amount.setFont(new Font("Raleway",Font.BOLD,22));
		amount.setBounds(170,350,320,25);
		image.add(amount);
		
		 deposit=new JButton("Deposite");
		deposit.setBounds(355,485,150,30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		 back =new JButton("Back");
		back.setBounds(355,520,150,30);
		back.addActionListener(this);
		image.add(back);
		
		
		setSize(900,900);
		setLocation(300,0);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		  if(ae.getSource()==deposit) {
			  String number=amount.getText();
			  Date date=new Date();
			  if(number.equals("")) {
				  JOptionPane.showMessageDialog(null,"please enter the amount you want to deposit");
				  
			  } else {
				  try {
				  Conn conn=new Conn();
				  String query="insert into bank values('"+pinnumber+"','"+date+"','Deposit', '"+number+"')";
				  conn.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs "+number+" Deposited Successfully");
					setVisible(false);
					new Transcations(pinnumber).setVisible(true);
				  }catch(Exception e) {
					System.out.print(e);
				}
			  }
			  
		  }else if(ae.getSource()==back) {
			  setVisible(false);
			  new Transcations(pinnumber).setVisible(true);
			  
		  }
	}

	public static void main(String[] args) {
		new Deposit(" ");
		

	}
	

	
	}

