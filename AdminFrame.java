package librarymanagment;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class AdminFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	JLayeredPane layeredPane = new JLayeredPane();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	JFrame frame = new JFrame();
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminFrame frame = new AdminFrame();
					frame.setVisible(true);
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
	 * Create the frame.
	 */
	public AdminFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPane.setBounds(10, 11, 414, 239);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel openpanel = new JPanel();
		openpanel.setBackground(Color.PINK);
		layeredPane.add(openpanel, "name_704833866729600");
		openpanel.setLayout(null);
		
		
		JPanel booklistpanel = new JPanel();
		booklistpanel.setBackground(Color.PINK);
		layeredPane.add(booklistpanel, "name_704837397504600");
		booklistpanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.PINK);
		scrollPane.setBounds(0, 36, 414, 203);
		booklistpanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Back\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchpanel(openpanel);
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBounds(325, 0, 89, 23);
		booklistpanel.add(btnNewButton_1);
		
		JPanel addbookpanel = new JPanel();
		addbookpanel.setBackground(Color.PINK);
		layeredPane.add(addbookpanel, "name_704840406439400");
		addbookpanel.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchpanel(openpanel);
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.setBounds(325, 0, 89, 23);
		addbookpanel.add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(182, 71, 167, 19);
		addbookpanel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(182, 103, 167, 19);
		addbookpanel.add(textField_1);
		
		JLabel lblBookName = new JLabel("Book Name:");
		lblBookName.setForeground(Color.BLACK);
		lblBookName.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblBookName.setBounds(68, 71, 104, 19);
		addbookpanel.add(lblBookName);
		
		JLabel lblAuthorName = new JLabel("Author Name:");
		lblAuthorName.setForeground(Color.BLACK);
		lblAuthorName.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblAuthorName.setBounds(68, 103, 104, 19);
		addbookpanel.add(lblAuthorName);
		
		JLabel lblIsbn = new JLabel("ISBN:");
		lblIsbn.setForeground(Color.BLACK);
		lblIsbn.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblIsbn.setBounds(68, 133, 104, 19);
		addbookpanel.add(lblIsbn);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(182, 133, 167, 19);
		addbookpanel.add(textField_2);
		
		JButton btnAdd_1 = new JButton("ADD");
		btnAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin func = new Admin();
				Book bk = new Book();
				bk.setname(textField.getText().toString());
				bk.setauthor(textField_1.getText().toString());
				bk.setisbn(textField_2.getText().toString());
				func.addbook(bk);
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");

				
			}
		});
		btnAdd_1.setForeground(Color.WHITE);
		btnAdd_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnAdd_1.setBorderPainted(false);
		btnAdd_1.setBackground(Color.DARK_GRAY);
		btnAdd_1.setBounds(151, 187, 89, 23);
		addbookpanel.add(btnAdd_1);
		
		JPanel addnewadmin = new JPanel();
		addnewadmin.setBackground(Color.PINK);
		layeredPane.add(addnewadmin, "name_705290966529300");
		addnewadmin.setLayout(null);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(180, 63, 167, 19);
		addnewadmin.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(180, 93, 167, 19);
		addnewadmin.add(textField_4);
		
		JButton button = new JButton("ADD");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin admin = new Admin();
				admin.setusername(textField_3.getText().toString());
				admin.setpassword(textField_4.getText().toString());
				if(!(textField_3.getText().toString().equals("")) && !(textField_4.getText().toString().equals(""))) {
					admin.addadmin(admin);
				}
				textField_3.setText("");
				textField_4.setText("");
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Arial", Font.BOLD, 12));
		button.setBorderPainted(false);
		button.setBackground(Color.DARK_GRAY);
		button.setBounds(148, 167, 89, 23);
		addnewadmin.add(button);
		
		JLabel lblAdminUsername = new JLabel("Admin Username:");
		lblAdminUsername.setForeground(Color.BLACK);
		lblAdminUsername.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblAdminUsername.setBounds(45, 63, 134, 19);
		addnewadmin.add(lblAdminUsername);
		
		JLabel lblAdminPassword = new JLabel("Admin password:");
		lblAdminPassword.setForeground(Color.BLACK);
		lblAdminPassword.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblAdminPassword.setBounds(45, 96, 134, 19);
		addnewadmin.add(lblAdminPassword);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchpanel(openpanel);
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Arial", Font.BOLD, 12));
		btnBack.setBorderPainted(false);
		btnBack.setBackground(Color.DARK_GRAY);
		btnBack.setBounds(325, 0, 89, 23);
		addnewadmin.add(btnBack);
		
		JButton btnNewButton = new JButton("Book List");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin func = new Admin();
				switchpanel(booklistpanel);
				func.showdata(table);
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(93, 27, 214, 35);
		openpanel.add(btnNewButton);
		
		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchpanel(addbookpanel);
			}
		});
		btnAddBook.setForeground(Color.WHITE);
		btnAddBook.setFont(new Font("Arial", Font.BOLD, 12));
		btnAddBook.setBorderPainted(false);
		btnAddBook.setBackground(Color.DARK_GRAY);
		btnAddBook.setBounds(93, 73, 214, 35);
		openpanel.add(btnAddBook);
		
		JButton btnAdd = new JButton("Add New Admin");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchpanel(addnewadmin);
			}
		});
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Arial", Font.BOLD, 12));
		btnAdd.setBorderPainted(false);
		btnAdd.setBackground(Color.DARK_GRAY);
		btnAdd.setBounds(93, 165, 214, 35);
		openpanel.add(btnAdd);
		
		JPanel deletepanel = new JPanel();
		deletepanel.setBackground(Color.PINK);
		layeredPane.add(deletepanel, "name_723457916727000");
		deletepanel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 25, 414, 181);
		deletepanel.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JButton button_1 = new JButton("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchpanel(openpanel);
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Arial", Font.BOLD, 12));
		button_1.setBorderPainted(false);
		button_1.setBackground(Color.DARK_GRAY);
		button_1.setBounds(325, 0, 89, 23);
		deletepanel.add(button_1);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin func = new Admin();
				func.deletebook(table_1);
				func.showdata(table_1);
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Arial", Font.BOLD, 12));
		btnDelete.setBorderPainted(false);
		btnDelete.setBackground(Color.DARK_GRAY);
		btnDelete.setBounds(160, 217, 89, 23);
		deletepanel.add(btnDelete);
		
		JButton btnDeleteBook = new JButton("Delete Book");
		btnDeleteBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchpanel(deletepanel);
				Admin func = new Admin();
				func.showdata(table_1);
			}
		});
		btnDeleteBook.setForeground(Color.WHITE);
		btnDeleteBook.setFont(new Font("Arial", Font.BOLD, 12));
		btnDeleteBook.setBorderPainted(false);
		btnDeleteBook.setBackground(Color.DARK_GRAY);
		btnDeleteBook.setBounds(93, 119, 214, 35);
		openpanel.add(btnDeleteBook);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterLoginFrame frame = new RegisterLoginFrame();//logout btn - back to login frame
				frame.frame.setVisible(true);
				dispose(); // dispose of current frame
			}
		});
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Arial", Font.BOLD, 12));
		btnLogout.setBorderPainted(false);
		btnLogout.setBackground(Color.DARK_GRAY);
		btnLogout.setBounds(325, 0, 89, 23);
		openpanel.add(btnLogout);
	}
}
