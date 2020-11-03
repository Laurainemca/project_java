package project_java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JEditorPane;
import java.awt.Font;

public class add_details_frame extends JFrame {
	

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_details_frame frame = new add_details_frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public add_details_frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,  900, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 188, 143));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VISITORS DETAILS FORM");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(102, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(284, 11, 411, 31);
		contentPane.add(lblNewLabel);
		
		JLabel name= new JLabel("Name");
		name.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		name.setBounds(23, 95, 89, 20);
		contentPane.add(name);
		
		JLabel address = new JLabel("Address");
		address.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		address.setBounds(29, 154, 102, 17);
		contentPane.add(address);
		
		JLabel phon = new JLabel("Ph.no");
		phon.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		phon.setBounds(29, 213, 102, 17);
		contentPane.add(phon);
		
		textField = new JTextField();
		textField.setBounds(164, 95, 423, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(164, 154, 423, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(164, 213, 423, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel visiter = new JLabel("Purpose of Visit");
		visiter.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		visiter.setBounds(29, 269, 125, 17);
		contentPane.add(visiter);
		
		JLabel time = new JLabel("Time");
		time.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		time.setBounds(29, 323, 46, 14);
		contentPane.add(time);
		
		textField_4 = new JTextField();
		textField_4.setBounds(164, 322, 423, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel date = new JLabel("Date");
		date.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		date.setBounds(29, 386, 46, 14);
		contentPane.add(date);
		
		textField_5 = new JTextField();
		textField_5.setBounds(164, 383, 423, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				try
				{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Lauraine-26");
				if(textField.getText().equals("")||textField_1.getText().equals("")||textField_2.getText().equals("")||textField_3.getText().equals("")||textField_4.getText().equals("")||textField_5.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "please enter the details");
				}else
				{
					Login_page lp=new Login_page();
					PreparedStatement pst=con.prepareStatement("insert into visitor values(?,?,?,?,?,?,?)");
					pst.setString(1, textField.getText());
					pst.setString(2, textField_1.getText());
					pst.setString(3, textField_2.getText());
					pst.setString(4, textField_3.getText());
					pst.setString(5, textField_4.getText());
					pst.setString(6, textField_5.getText());
					pst.setString(7, lp.name);
				    pst.executeUpdate();
				    JOptionPane.showMessageDialog(null, "succesfully entered");
				}
				
			    
				}
				catch(Exception error)
				{
					System.out.println(error);
				}
			}
		});
		btnNewButton.setBounds(216, 479, 114, 31);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edit_frame us=new edit_frame();
				us.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(460, 479, 107, 31);
		contentPane.add(btnNewButton_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(164, 269, 423, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		
	}
}
 
