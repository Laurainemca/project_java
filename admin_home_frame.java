package project_java;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class admin_home_frame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_home_frame frame = new admin_home_frame();
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
	public admin_home_frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 457);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 188, 143));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMIN HOME PAGE");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(176, 22, 346, 34);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add receptionst");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin_add_rec_frame as=new admin_add_rec_frame();
				as.setVisible(true);
				//frame.dispose();
			}
		});
		btnNewButton.setBounds(266, 123, 211, 44);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Edit receptionst details");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin_edit_rec_frame ar=new admin_edit_rec_frame();
				ar.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_1.setBounds(266, 212, 211, 44);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Visitors  report");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin_visitors_report us=new admin_visitors_report();
				us.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(262, 306, 215, 44);
		contentPane.add(btnNewButton_2);
	}

}
