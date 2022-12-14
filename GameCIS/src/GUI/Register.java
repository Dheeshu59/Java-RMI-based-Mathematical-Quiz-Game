package GUI;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class Register extends JFrame {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldEmailadd;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 475);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(221, 160, 221));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCreateAccount = new JLabel("CREATE \r\nACCOUNT");
		lblCreateAccount.setForeground(new Color(255, 255, 255));
		lblCreateAccount.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 21));
		lblCreateAccount.setBounds(26, 11, 177, 40);
		contentPane.add(lblCreateAccount);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(180, 62, 293, 36);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(180, 36, 177, 28);
		contentPane.add(lblName);
		
		JLabel lblemailAddress = new JLabel("Email Address");
		lblemailAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblemailAddress.setBounds(180, 109, 177, 21);
		contentPane.add(lblemailAddress);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(180, 175, 177, 28);
		contentPane.add(lblPassword);
		
		JButton btnSignup = new JButton("SIGN UP");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/game","root","");
		            String sql="INSERT INTO `register`(`name`, `username`, `password`) VALUES (?,?,?)";
		            PreparedStatement p = con.prepareStatement(sql);
		          
		            String name=textFieldName.getText();
		            String username = textFieldEmailadd.getText();
		            String password = passwordField.getText();
		            
		            p.setString(1, textFieldName.getText());
		            p.setString(2,textFieldEmailadd.getText());
		            p.setString(3, passwordField.getText());
		             
		            p.executeUpdate();
		            if(name.isEmpty()|| username.isEmpty() || password.isEmpty()){
		            	JOptionPane.showMessageDialog(null,"Incorrect user");
		        }else{
		            JOptionPane.showMessageDialog(null,"Int user");
		            }
		            textFieldName.setText("");
		            textFieldEmailadd.setText("");
		            passwordField.setText("");
		            
		        }
		        catch(Exception w){
		            
		        }
				}
			});
		btnSignup.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSignup.setBounds(253, 263, 109, 23);
		contentPane.add(btnSignup);
		
		textFieldEmailadd = new JTextField();
		textFieldEmailadd.setColumns(10);
		textFieldEmailadd.setBounds(180, 127, 293, 37);
		contentPane.add(textFieldEmailadd);
		
		JLabel lblNewLabel = new JLabel("Already Have An Account?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(139, 348, 177, 21);
		contentPane.add(lblNewLabel);
		
		JButton btnSignin = new JButton("SIGN IN  HERE");
		btnSignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnSignin, "Please sign in Here");
				user User =new user();
				User.setVisible(true);
				dispose();
			}
		});
		btnSignin.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSignin.setBounds(324, 378, 149, 23);
		contentPane.add(btnSignin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(180, 200, 293, 40);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\dewanmini\\Downloads\\Hi6Pj8.png"));
		lblNewLabel_1.setBounds(0, 0, 590, 436);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(445, 327, 89, 23);
		contentPane.add(btnNewButton);
	}
}