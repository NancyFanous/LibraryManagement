package librarymanagment;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Color;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.Font;


import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class UserFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel_1 = new JLabel("");
	JLayeredPane layeredPane = new JLayeredPane();



	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserFrame frame = new UserFrame();
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
	
	public void nameforlabel(String name) {
		lblNewLabel_1.setText(name);
	}

	/**
	 * Create the frame.
	 */
	public UserFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPane.setBounds(10, 11, 414, 239);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel openpanel = new JPanel();
		openpanel.setBackground(Color.PINK);
		layeredPane.add(openpanel, "name_794697852000700");
		openpanel.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Hello");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(0, 0, 37, 14);
		openpanel.add(lblNewLabel);
		
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setBounds(43, 0, 120, 14);
		openpanel.add(lblNewLabel_1);
		
		JButton button_4 = new JButton("LOGOUT");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterLoginFrame frame = new RegisterLoginFrame();//logout btn - back to login frame
				frame.frame.setVisible(true);
				dispose(); // dispose of current frame
			}
		});
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Arial", Font.BOLD, 12));
		button_4.setBorderPainted(false);
		button_4.setBackground(Color.DARK_GRAY);
		button_4.setBounds(325, -3, 89, 23);
		openpanel.add(button_4);
		
		JPanel borrowpanel = new JPanel();
		borrowpanel.setBackground(Color.PINK);
		layeredPane.add(borrowpanel, "name_794702487383900");
		borrowpanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 25, 394, 163);
		borrowpanel.add(scrollPane);
		
		table = new JTable();

		scrollPane.setViewportView(table);
		
		JButton btnBack = new JButton("BACK");
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
		borrowpanel.add(btnBack);
		
		JButton borrowbtn = new JButton("BORROW");
		borrowbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Users func = new Users();
				func.borrowbook(table, lblNewLabel_1);
			}
		});
		borrowbtn.setForeground(Color.WHITE);
		borrowbtn.setFont(new Font("Arial", Font.BOLD, 12));
		borrowbtn.setBorderPainted(false);
		borrowbtn.setBackground(Color.DARK_GRAY);
		borrowbtn.setBounds(161, 205, 89, 23);
		borrowpanel.add(borrowbtn);
		
		JPanel mybookspanel = new JPanel();
		mybookspanel.setBackground(Color.PINK);
		layeredPane.add(mybookspanel, "name_794705047695600");
		mybookspanel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 25, 394, 176);
		mybookspanel.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JButton button = new JButton("BACK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchpanel(openpanel);
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Arial", Font.BOLD, 12));
		button.setBorderPainted(false);
		button.setBackground(Color.DARK_GRAY);
		button.setBounds(325, 0, 89, 23);
		mybookspanel.add(button);
		
		JButton btnReturnBook = new JButton("Return Book");
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Users func= new Users();
				func.returnbook(table_1);
				func.userborrowedbook(table_1, lblNewLabel_1);
			}
		});
		btnReturnBook.setForeground(Color.WHITE);
		btnReturnBook.setFont(new Font("Arial", Font.BOLD, 12));
		btnReturnBook.setBorderPainted(false);
		btnReturnBook.setBackground(Color.DARK_GRAY);
		btnReturnBook.setBounds(144, 212, 111, 23);
		mybookspanel.add(btnReturnBook);
		
		JButton btnBorrowBook = new JButton("Borrow Book");
		btnBorrowBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Users func = new Users();
				func.showdata(table);
				switchpanel(borrowpanel);
			}
		});
		btnBorrowBook.setForeground(Color.WHITE);
		btnBorrowBook.setFont(new Font("Arial", Font.BOLD, 12));
		btnBorrowBook.setBorderPainted(false);
		btnBorrowBook.setBackground(Color.DARK_GRAY);
		btnBorrowBook.setBounds(88, 76, 214, 35);
		openpanel.add(btnBorrowBook);
		
		
		JButton btnMyBooks = new JButton("My Books");
		btnMyBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchpanel(mybookspanel);
				Users func = new Users();
				func.userborrowedbook(table_1, lblNewLabel_1);
			}
		});
		btnMyBooks.setForeground(Color.WHITE);
		btnMyBooks.setFont(new Font("Arial", Font.BOLD, 12));
		btnMyBooks.setBorderPainted(false);
		btnMyBooks.setBackground(Color.DARK_GRAY);
		btnMyBooks.setBounds(88, 122, 214, 35);
		openpanel.add(btnMyBooks);
	}
}
