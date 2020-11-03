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

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class admin_edit_rec_frame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField textname;
	private JTextField textphno;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTextField textaddress;
	private JTextField textgender;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_edit_rec_frame frame = new admin_edit_rec_frame();
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
	public admin_edit_rec_frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1032, 750);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 188, 143));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VIEW RECEPTIONIST DETAILS");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(102, 0, 0));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(276, 11, 458, 25);
		contentPane.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 996, 311);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DefaultTableModel dtm=(DefaultTableModel)table.getModel();
				String tname=dtm.getValueAt(table.getSelectedRow(), 0).toString();
				String taddress=dtm.getValueAt(table.getSelectedRow(), 1).toString();
				String tphno=dtm.getValueAt(table.getSelectedRow(), 2).toString();
				String tgender=dtm.getValueAt(table.getSelectedRow(), 3).toString();
				
				textname.setText(tname);
				textaddress.setText(taddress);
				textphno.setText(tphno);
				textgender.setText(tgender);
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Address", "Phone num", "Genter", "User Name", "Password"
			}
		));
		
		lblNewLabel_1 = new JLabel("Edit the User Details");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1.setForeground(new Color(102, 0, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(351, 413, 350, 34);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 461, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(10, 494, 107, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Phone num");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(10, 529, 107, 14);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Gender");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(10, 564, 107, 17);
		contentPane.add(lblNewLabel_5);
		
		textname = new JTextField();
		textname.setBounds(145, 458, 355, 20);
		contentPane.add(textname);
		textname.setColumns(10);
		
		textphno = new JTextField();
		textphno.setBounds(145, 529, 355, 20);
		contentPane.add(textphno);
		textphno.setColumns(10);
		
		btnNewButton = new JButton("Edit");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nname=textname.getText();
				String naddress=textaddress.getText();
				String nphno= textphno.getText();
				String ngender=textgender.getText();
				DefaultTableModel dtm=(DefaultTableModel)table.getModel();
				dtm.setValueAt(nname, table.getSelectedRow(), 0);
				dtm.setValueAt(naddress, table.getSelectedRow(), 1);
				dtm.setValueAt(nphno, table.getSelectedRow(), 2);
				dtm.setValueAt(ngender, table.getSelectedRow(), 3);
				try
				{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Lauraine-26");
				Statement stmt=con.createStatement();
				String q="Update reception set name='"+nname+"',address='"+naddress+"',phnum='"+nphno+"',genter='"+ngender+"' where name='"+nname+"'";
				stmt.executeUpdate(q);
				
				    JOptionPane.showMessageDialog(null, "succesfully entered");
				}
				catch(Exception error)
				{
					System.out.println(error);
				}
			}
		});
		btnNewButton.setBounds(129, 614, 89, 32);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			try
			{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Lauraine-26");
			Statement stmt=con.createStatement();
			String nname=textname.getText();
			String qt="delete reception  where name='"+nname+"'";
			stmt.executeUpdate(qt);
			String qt1="delete login  where uname='"+nname+"'";
			stmt.executeUpdate(qt1);
			JOptionPane.showMessageDialog(null, "succesfully deleted");
			}
			catch(Exception error)
			{
				System.out.println(error);
			}
			}
		});
		btnNewButton_1.setBounds(351, 614, 89, 32);
		contentPane.add(btnNewButton_1);
		
		textaddress = new JTextField();
		textaddress.setBounds(145, 491, 355, 20);
		contentPane.add(textaddress);
		textaddress.setColumns(10);
		
		textgender = new JTextField();
		textgender.setBounds(145, 562, 355, 20);
		contentPane.add(textgender);
		textgender.setColumns(10);
		
		btnNewButton_2 = new JButton("<");
		btnNewButton_2.setForeground(new Color(102, 0, 51));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin_home_frame us=new admin_home_frame();
				us.setVisible(true);
				//frame.dispose();
			}
		});
		btnNewButton_2.setBackground(new Color(143, 188, 143));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_2.setBounds(10, 11, 46, 23);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("View");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Lauraine-26");
				Statement stat=con.createStatement();
				ResultSet rs=stat.executeQuery("select name,address,phnum,genter from reception");
				table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception error)
				{
					System.out.println(error);
				}
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_3.setBounds(820, 389, 89, 23);
		contentPane.add(btnNewButton_3);
		table.getColumnModel().getColumn(0).setPreferredWidth(170);
		table.getColumnModel().getColumn(1).setPreferredWidth(318);
		table.getColumnModel().getColumn(2).setPreferredWidth(114);
		table.getColumnModel().getColumn(3).setPreferredWidth(266);
	}

}
