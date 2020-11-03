package project_java;

import java.awt.BorderLayout;
import java.awt.EventQueue;
//import net.proteanit.sql.DbUnits;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.*;
import java.awt.event.ActionEvent;

public class admin_visitors_report extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_visitors_report frame = new admin_visitors_report();
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
	public admin_visitors_report() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1012, 536);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 188, 143));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 64, 976, 379);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Address", "Phone num", "Purpose of Visit", "Time", "Date", "Receptionist Name"
			}
		));
		
		JLabel lblNewLabel = new JLabel("Visitors Report");
		lblNewLabel.setBounds(376, 15, 251, 38);
		lblNewLabel.setForeground(new Color(102, 0, 51));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("<");
		btnNewButton.setBounds(10, 11, 47, 28);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin_home_frame us=new admin_home_frame();
				us.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(143, 188, 143));
		btnNewButton.setForeground(new Color(102, 0, 51));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Lauraine-26");
				Statement stat=con.createStatement();
				ResultSet rs=stat.executeQuery("select * from visitor");
				
				table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception error)
				{
					System.out.println(error);
				}
			}
		});
		btnNewButton_1.setBounds(487, 454, 89, 23);
		contentPane.add(btnNewButton_1);
		table.getColumnModel().getColumn(0).setPreferredWidth(196);
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		table.getColumnModel().getColumn(2).setPreferredWidth(114);
		table.getColumnModel().getColumn(3).setPreferredWidth(307);
		table.getColumnModel().getColumn(4).setPreferredWidth(83);
		table.getColumnModel().getColumn(5).setPreferredWidth(107);
		table.getColumnModel().getColumn(6).setPreferredWidth(179);
	}
}
