package project_java;

import java.awt.Color;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class Login_page {
	static public String name;
	private JFrame frame;
	private JTextField textname;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_page window = new Login_page();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_page() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(143, 188, 143));
		frame.setBounds(100, 100,  800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.getContentPane().setLayout(null);
		
		JLabel user_name = new JLabel("User Name");
		user_name.setFont(new Font("Times New Roman", Font.BOLD, 23));
		user_name.setBounds(200, 145, 146, 30);
		frame.getContentPane().add(user_name);
		
		JLabel password = new JLabel("Password");
		password.setFont(new Font("Times New Roman", Font.BOLD, 23));
		password.setBounds(211, 232, 146, 30);
		frame.getContentPane().add(password);
		
		textname = new JTextField();
		textname.setBounds(432, 144, 187, 30);
		frame.getContentPane().add(textname);
		textname.setColumns(10);
		

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 19));
		passwordField.setBounds(432, 236, 192, 30);
		frame.getContentPane().add(passwordField);
		
		
		JButton login = new JButton("LOGIN");
		login.setFont(new Font("Times New Roman", Font.BOLD, 18));
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Lauraine-26");
				
				PreparedStatement pst=con.prepareStatement("select * from login where uname=? and upass=?");
				pst.setString(1, textname.getText());
				pst.setString(2, passwordField.getText());
			    ResultSet rs=pst.executeQuery();
			    name=textname.getText();
			    if(textname.getText().equalsIgnoreCase("admin"))
			    {
			    	if(rs.next())
					{
						JOptionPane.showMessageDialog(null, "login succesfully");
						admin_home_frame as=new admin_home_frame();
						as.setVisible(true);
						frame.dispose();
						
					}
		    		else
					{
						JOptionPane.showMessageDialog(null, "user name or password is invalid");
					}
			    }else
			    {
			    	if(rs.next())
					{
						JOptionPane.showMessageDialog(null, "login succesfully");
						add_details_frame us=new add_details_frame();
						us.setVisible(true);
						frame.dispose();
						
					}
		    		else
					{
						JOptionPane.showMessageDialog(null, "user name or password is invalid");
					}
			    }		
				
				}
				catch(Exception error)
				{
					System.out.println(error);
				}
			}
		});
		login.setBounds(355, 325, 122, 42);
		frame.getContentPane().add(login);
		
		JLabel lblNewLabel = new JLabel(" RAJAGIRI COLLEGE OF SOCIAL SCIENCE");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setLabelFor(frame);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setBounds(48, 35, 646, 60);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\morreira\\Downloads\\sharon-mccutcheon-NkQD-RHhbvY-unsplash.jpg"));
		lblNewLabel_1.setBounds(0, 0, 784, 561);
		frame.getContentPane().add(lblNewLabel_1);
		
	}
}
