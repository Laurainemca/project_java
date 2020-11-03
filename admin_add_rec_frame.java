package project_java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Font;

public class admin_add_rec_frame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_3;
	private JTextField textField_7;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_add_rec_frame frame = new admin_add_rec_frame();
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
	public admin_add_rec_frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		//contentPane.setBackground(new Color(143, 188, 143));
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 188, 143));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RECEPTIONIST DETAILS FORM");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(102, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(252, 11, 483, 31);
		contentPane.add(lblNewLabel);
		
		JLabel name= new JLabel("Name");
		name.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		name.setBounds(29, 102, 46, 14);
		contentPane.add(name);
		
		JLabel address = new JLabel("Address");
		address.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		address.setBounds(29, 160, 102, 14);
		contentPane.add(address);
		
		JLabel phon = new JLabel("Ph.no");
		phon.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		phon.setBounds(29, 217, 46, 17);
		contentPane.add(phon);
		
		textField = new JTextField();
		textField.setBounds(157, 99, 423, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(157, 157, 423, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(157, 217, 423, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Genter");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(24, 272, 72, 14);
		contentPane.add(lblNewLabel_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setBackground(new Color(143, 188, 143));
		rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		buttonGroup_1.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(157, 268, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Female");
		rdbtnNewRadioButton_1.setBackground(new Color(143, 188, 143));
		rdbtnNewRadioButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		buttonGroup_1.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(266, 268, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Other");
		rdbtnNewRadioButton_2.setBackground(new Color(143, 188, 143));
		rdbtnNewRadioButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		buttonGroup_1.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(396, 268, 109, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("User Name");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(29, 327, 102, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(29, 382, 102, 17);
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(164, 324, 423, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(164, 379, 423, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				try
				{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Lauraine-26");
				
				if(textField.getText().equals("")||textField_1.getText().equals("")||textField_2.getText().equals("")||textField_3.getText().equals("")||textField_7.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "please enter the details");
				}else				{
					PreparedStatement pst=con.prepareStatement("insert into reception values(?,?,?,?)");
					PreparedStatement pst1=con.prepareStatement("insert into login values(?,?)");
					pst.setString(1, textField.getText());
					pst.setString(2, textField_1.getText());
					pst.setString(3, textField_2.getText());
					if(rdbtnNewRadioButton.isSelected())
					{
						pst.setString(4, "male");
					}else if(rdbtnNewRadioButton_1.isSelected())
					{
						pst.setString(4, "female");
					}else if(rdbtnNewRadioButton_2.isSelected())
					{
						pst.setString(4, "other");
					}   
					
					pst1.setString(1, textField_3.getText());
					pst1.setString(2, textField_7.getText());
					pst.executeUpdate();
				    pst1.executeUpdate();
				    JOptionPane.showMessageDialog(null, "succesfully entered");
				}
				}
				catch(Exception error)
				{
					System.out.println(error);
				}
			}
		});
		btnNewButton.setBounds(346, 484, 89, 31);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("<");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin_home_frame us=new admin_home_frame();
				us.setVisible(true);
			}
		});
		btnNewButton_2.setBackground(new Color(143, 188, 143));
		btnNewButton_2.setForeground(new Color(102, 0, 51));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_2.setBounds(10, 11, 46, 31);
		contentPane.add(btnNewButton_2);
		
		
	}
}
