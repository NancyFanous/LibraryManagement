package librarymanagment;

import java.awt.Window;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Admin {
	private String username;
	private String password;
	JPanel frame1 = new JPanel();
	JFrame frame2 = new JFrame();

	public Admin() {}

	public Admin(String username , String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getusername() {
		return username;
	}
	
	public String getpassword() {
		return password;
	}
	
	public void setusername(String username) {
		this.username = username;
	}
	
	public void setpassword(String password) {
		this.password = password;
	}
	
	public void showdata(JTable table) { // func for displaying database book tb 

		Connection con = DBconnection.getConnection();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("isbn");
		model.addColumn("name");
		model.addColumn("author");
		
		try {
			String query = "select * from books";
			Statement stat = con.createStatement();	
			ResultSet rs = stat.executeQuery(query);
			
			while (rs.next()) {
				model.addRow(new Object[] {
						rs.getString("isbn"),
						rs.getString("name"),
						rs.getString("author")
				});
			}
			rs.close();
			stat.close();
			con.close();
			table.setModel(model);			}
			
		 catch (SQLException e) {
			System.out.println("OPPPPPPS");
			e.printStackTrace();
		}
	}
	
	public void addbook(Book bk) { // func for adding books to database
		Connection con = DBconnection.getConnection();
		try {
			Statement stat = con.createStatement();
			String sql = "INSERT INTO books (isbn , name , author,borrowed) VALUES('" + bk.getisbn() +"' , '" + bk.getname() +"' , '" + bk.getauthor() +"' , NULL)";
			stat.execute(sql);
			JOptionPane.showMessageDialog(frame1,"Added book successfully");
			
			stat.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deletebook(JTable table) {//func for deleting books from database
		Connection con = DBconnection.getConnection();

		try {
			int row = table.getSelectedRow();
			String isbn = table.getValueAt(row, 0).toString();
			String sql = "DELETE FROM books where isbn = '"+isbn+"'";
			PreparedStatement st = con.prepareStatement(sql);
			st.executeUpdate();
			
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addadmin(Admin admin) { // func for adding new admin
		Connection con = DBconnection.getConnection();
		try {
			Statement stat = con.createStatement();
			String test = "SELECT * FROM admins WHERE username = '" + admin.getusername() +"'";
			String sql = "INSERT INTO admins (pass , username) VALUES ('"+ admin.getpassword() +"' , '"+ admin.getusername()+"')";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(test);
			
			if(rs.next())
			{
				JOptionPane.showMessageDialog(frame1,"username already exist");
			}else {
				stat.execute(sql);
				JOptionPane.showMessageDialog(frame1,"new admin added successfully");

			}
			
			stat.close();
			st.close();
			rs.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void changeframe(JFrame frame) {
		RegisterLoginFrame window = new RegisterLoginFrame();
		((Window) window.frame2).setVisible(true);
		frame.dispose();
	}

}
