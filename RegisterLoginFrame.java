package librarymanagment;


import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class RegisterLoginFrame {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_4;
	JLayeredPane layeredPane = new JLayeredPane();
	JPanel frame1 = new JPanel();
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JPasswordField passwordField_3;
	public Window frame2;
	protected Object contentPane;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterLoginFrame window = new RegisterLoginFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	public void switchpanel(JPanel panel) { /*func to switch panels in layeredpanels */
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
		
	}

	/**
	 * Create the application.
	 */
	public RegisterLoginFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.PINK);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		layeredPane.setBounds(10, 11, 414, 169);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel loginpanel = new JPanel();
		loginpanel.setBackground(Color.PINK);
		layeredPane.add(loginpanel, "name_611911104367200");
		loginpanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(65, 47, 104, 19);
		loginpanel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblPassword.setBounds(65, 77, 104, 19);
		loginpanel.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(179, 47, 167, 19);
		loginpanel.add(textField);
		textField.setColumns(10);
		
		JButton loginuserbtn = new JButton("Login");
		loginuserbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterLogin login = new RegisterLogin();
				Users user = new Users();
				user.setusername(textField.getText().toString());
				user.setpassword(String.valueOf(passwordField.getPassword()));
				login.login(user,frame);/* func for user login*/
				
			}
		}); 
		loginuserbtn.setFont(new Font("Arial", Font.BOLD, 12));
		loginuserbtn.setBorderPainted(false);
		loginuserbtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		loginuserbtn.setBackground(Color.DARK_GRAY);
		loginuserbtn.setForeground(Color.WHITE);
		loginuserbtn.setBounds(153, 135, 89, 23);
		loginpanel.add(loginuserbtn);
		
		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel_1.setBounds(162, 11, 136, 25);
		loginpanel.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(179, 77, 167, 20);
		loginpanel.add(passwordField);
		
		JPanel adminlogin = new JPanel();
		adminlogin.setBackground(Color.PINK);
		layeredPane.add(adminlogin, "name_611914780748800");
		adminlogin.setLayout(null);
		
		JLabel lblAdminLogin = new JLabel("Admin Login");
		lblAdminLogin.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblAdminLogin.setBounds(127, 11, 136, 25);
		adminlogin.add(lblAdminLogin);
		
		JLabel lblAdmin = new JLabel("Admin:");
		lblAdmin.setForeground(Color.BLACK);
		lblAdmin.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblAdmin.setBounds(63, 47, 104, 19);
		adminlogin.add(lblAdmin);
		
		JLabel label_2 = new JLabel("Password:");
		label_2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		label_2.setBounds(63, 77, 104, 19);
		adminlogin.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(175, 47, 167, 19);
		adminlogin.add(textField_2);
		
		JButton loginadminbtn = new JButton("Login");
		loginadminbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterLogin adminacsses = new RegisterLogin();
				Admin admin1 = new Admin();
				admin1.setusername(textField_2.getText().toString());
				admin1.setpassword(String.valueOf(passwordField_3.getPassword()));
				adminacsses.adminaccess(admin1, frame); /*func for admin login*/
				
			}
		});
		loginadminbtn.setForeground(Color.WHITE);
		loginadminbtn.setFont(new Font("Arial", Font.BOLD, 12));
		loginadminbtn.setBorderPainted(false);
		loginadminbtn.setBackground(Color.DARK_GRAY);
		loginadminbtn.setAlignmentX(0.5f);
		loginadminbtn.setBounds(152, 135, 89, 23);
		adminlogin.add(loginadminbtn);
		
		passwordField_3 = new JPasswordField();
		passwordField_3.setBounds(177, 77, 167, 20);
		adminlogin.add(passwordField_3);
		
		JPanel registerpanel = new JPanel();
		registerpanel.setBackground(Color.PINK);
		layeredPane.add(registerpanel, "name_611917746245700");
		registerpanel.setLayout(null);
		
		JLabel Register = new JLabel("Register");
		Register.setFont(new Font("Arial Black", Font.BOLD, 20));
		Register.setBounds(155, 11, 136, 25);
		registerpanel.add(Register);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(199, 47, 167, 19);
		registerpanel.add(textField_4);
		
		JLabel lblUsername = new JLabel("username:");
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblUsername.setBounds(97, 47, 104, 19);
		registerpanel.add(lblUsername);
		
		JLabel lblPassword_1 = new JLabel("password:");
		lblPassword_1.setForeground(Color.BLACK);
		lblPassword_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblPassword_1.setBounds(97, 77, 104, 19);
		registerpanel.add(lblPassword_1);
		
		JLabel lblConfirm = new JLabel("confirm:");
		lblConfirm.setForeground(Color.BLACK);
		lblConfirm.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblConfirm.setBounds(97, 107, 104, 19);
		registerpanel.add(lblConfirm);
		
		JButton btnRegister = new JButton("OK");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterLogin register = new RegisterLogin();
				Users user = new Users();
				String username = textField_4.getText().toString();
				String password = String.valueOf(passwordField_1.getPassword());
				String confirm = String.valueOf(passwordField_2.getPassword());
				if(username.equals("")){JOptionPane.showMessageDialog(frame1,"there is no username input");} /*input validation*/
				if(password.equals("")){JOptionPane.showMessageDialog(frame1,"there is no password input");}
				if(confirm.equals("")){JOptionPane.showMessageDialog(frame1,"there is no confirm input");}
				user.setusername(textField_4.getText().toString());
				user.setpassword(String.valueOf(passwordField_1.getPassword()));
				if(user.getpassword().equals(String.valueOf(passwordField_2.getPassword())) && (!username.equals("")) && (!password.equals("")) && (!confirm.equals(""))) {
					register.registerform(user);} /*func for user register*/
				textField_4.setText("");
				passwordField_1.setText("");
				passwordField_2.setText("");
			}
			
		});
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setFont(new Font("Arial", Font.BOLD, 12));
		btnRegister.setBorderPainted(false);
		btnRegister.setBackground(Color.DARK_GRAY);
		btnRegister.setAlignmentX(0.5f);
		btnRegister.setBounds(155, 135, 89, 23);
		registerpanel.add(btnRegister);
		
		JButton backbtn = new JButton("Back");
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchpanel(loginpanel);
			}
		});
		backbtn.setForeground(Color.WHITE);
		backbtn.setFont(new Font("Arial", Font.BOLD, 12));
		backbtn.setBorderPainted(false);
		backbtn.setBackground(Color.DARK_GRAY);
		backbtn.setAlignmentX(0.5f);
		backbtn.setBounds(325, 0, 89, 23);
		registerpanel.add(backbtn);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(199, 77, 167, 20);
		registerpanel.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(199, 107, 167, 20);
		registerpanel.add(passwordField_2);
		
		JButton adminbtn = new JButton("Admin");
		adminbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchpanel(adminlogin);
			}
		});
		adminbtn.setFont(new Font("Arial", Font.BOLD, 12));
		adminbtn.setForeground(Color.WHITE);
		adminbtn.setBorderPainted(false);
		adminbtn.setBackground(Color.DARK_GRAY);
		adminbtn.setBounds(102, 210, 104, 23);
		frame.getContentPane().add(adminbtn);
		
		JButton registerbtn = new JButton("Register");
		registerbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchpanel(registerpanel);
			}
		});
		registerbtn.setForeground(Color.WHITE);
		registerbtn.setFont(new Font("Arial", Font.BOLD, 12));
		registerbtn.setBackground(Color.DARK_GRAY);
		registerbtn.setBorderPainted(false);
		registerbtn.setBounds(216, 210, 104, 23);
		frame.getContentPane().add(registerbtn);
	}
	
}
