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
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class edit_frame extends JFrame {
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField textname;
	private JTextField textphone;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTextField textaddress;
	private JPanel contentPane;
	private JTextField textpurpose;
	private JTextField textField_7;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					edit_frame frame = new edit_frame();
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
	public edit_frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,900, 795);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 188, 143));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("View User Details");
		lblNewLabel.setBounds(359, 11, 250, 44);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(102, 51, 0));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 810, 305);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel dtm=(DefaultTableModel)table.getModel();
				String tname=dtm.getValueAt(table.getSelectedRow(), 0).toString();
				String taddress=dtm.getValueAt(table.getSelectedRow(), 1).toString();
				String tphno=dtm.getValueAt(table.getSelectedRow(), 2).toString();
				String tpurpose=dtm.getValueAt(table.getSelectedRow(), 3).toString();
				String tTime=dtm.getValueAt(table.getSelectedRow(), 4).toString();
				String tdate=dtm.getValueAt(table.getSelectedRow(), 5).toString();
				
				textname.setText(tname);
				textaddress.setText(taddress);
				textphone.setText(tphno);
				textpurpose.setText(tpurpose);
				//texttime.setText(tTime);
				//textdate.setText(tdate);
				
				
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Address", "Phone num", "Purpose of Visit", "Time", "Date"
			}
		));
		
		lblNewLabel_1 = new JLabel("Edit the User Details");
		lblNewLabel_1.setBounds(320, 415, 350, 34);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1.setForeground(new Color(102, 0, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setBounds(10, 461, 46, 14);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setBounds(10, 494, 107, 14);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Phone num");
		lblNewLabel_4.setBounds(10, 529, 107, 14);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Purpose of Visit");
		lblNewLabel_5.setBounds(10, 564, 125, 17);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_5);
		
		textname = new JTextField();
		textname.setBounds(145, 458, 355, 20);
		contentPane.add(textname);
		textname.setColumns(10);
		
		textphone = new JTextField();
		textphone.setBounds(145, 529, 355, 20);
		contentPane.add(textphone);
		textphone.setColumns(10);
		
		btnNewButton = new JButton("Edit");
		btnNewButton.setBounds(216, 614, 89, 34);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nname=textname.getText();
				String naddress=textaddress.getText();
				String nphno= textphone.getText();
				String npurpose=textpurpose.getText();
				//int nTime=(int)texttime.getText();
				//String ndate=textdate.getText();
				//System.out.println(nTime +" "+ ndate);
				DefaultTableModel dtm=(DefaultTableModel)table.getModel();
				dtm.setValueAt(nname, table.getSelectedRow(), 0);
				dtm.setValueAt(naddress, table.getSelectedRow(), 1);
				dtm.setValueAt(nphno, table.getSelectedRow(), 2);
				dtm.setValueAt(npurpose, table.getSelectedRow(), 3);
				//dtm.setValueAt(nTime, table.getSelectedRow(), 4);
				//dtm.setValueAt(ndate, table.getSelectedRow(), 5);
				try
				{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Lauraine-26");
				Statement stmt=con.createStatement();
				String q="Update visitor set name='"+nname+"',address='"+naddress+"',phno='"+nphno+"',purpose='"+npurpose+"' where name='"+nname+"'";
				//System.out.
				stmt.executeUpdate(q);
				
				    JOptionPane.showMessageDialog(null, "succesfully entered");
				}
				catch(Exception error)
				{
					System.out.println(error);
				}	
			}
		});
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.setBounds(393, 614, 89, 34);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			try
			{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Lauraine-26");
			Statement stmt=con.createStatement();
			String nname=textname.getText();
			String qt="delete visitor  where name='"+nname+"'";
			stmt.executeUpdate(qt);
			JOptionPane.showMessageDialog(null, "succesfully deleted");
			}
			catch(Exception error)
			{
				System.out.println(error);
			}
			}
		});
		contentPane.add(btnNewButton_1);
		
		textaddress = new JTextField();
		textaddress.setBounds(145, 491, 355, 20);
		contentPane.add(textaddress);
		textaddress.setColumns(10);
		
		textpurpose = new JTextField();
		textpurpose.setBounds(145, 562, 355, 20);
		contentPane.add(textpurpose);
		textpurpose.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(145, 562, 355, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("<");
		btnNewButton_2.setBounds(10, 11, 51, 28);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_details_frame us=new add_details_frame();
				us.setVisible(true);
			}
		});
		btnNewButton_2.setBackground(new Color(143, 188, 143));
		btnNewButton_2.setForeground(new Color(102, 0, 0));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("View");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Lauraine-26");
				Statement stat=con.createStatement();
				ResultSet rs=stat.executeQuery("select name,address,phno,purpose,time,Vdate from visitor");
				table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception error)
				{
					System.out.println(error);
				}
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_3.setBounds(679, 382, 89, 34);
		contentPane.add(btnNewButton_3);
		table.getColumnModel().getColumn(0).setPreferredWidth(170);
		table.getColumnModel().getColumn(1).setPreferredWidth(318);
		table.getColumnModel().getColumn(2).setPreferredWidth(114);
		table.getColumnModel().getColumn(3).setPreferredWidth(266);
	}
}
