package librarymanagment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Users {
	
	private String username;
	private String password;

	
	public Users() {}

	public Users(String username , String password ) {
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
	
	public void borrowbook(JTable table, JLabel label) {  //user borrow book func 
		
		Connection con = DBconnection.getConnection();
		
		try {
			String name = label.getText().toString();
			int row = table.getSelectedRow();
			String isbn = table.getValueAt(row, 0).toString();
			String sql = "UPDATE books SET borrowed=? WHERE isbn="+isbn+"";
			PreparedStatement st;
			st = con.prepareStatement(sql);
			st.setString(1, name);
			st.executeUpdate();
			
			showdata(table);
			
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void showdata(JTable table) { // func for displaying database book tb 



		Connection con = DBconnection.getConnection();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("isbn");
		model.addColumn("name");
		model.addColumn("author");

		try {
			String query = "SELECT * FROM books WHERE borrowed is NULL";
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

	public void userborrowedbook(JTable table,JLabel label) {  // display the user books
		
		Connection con = DBconnection.getConnection();
		
		String name = label.getText().toString();
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("isbn");
		model.addColumn("name");
		model.addColumn("author");
		
		try {
			Statement st = con.createStatement();
			String sql = "SELECT * FROM books WHERE borrowed = '"+name+"'";
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				model.addRow(new Object[] {
						rs.getString("isbn"),
						rs.getString("name"),
						rs.getString("author")
				});
			}
			
			rs.close();
			st.close();
			con.close();
			table.setModel(model);		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void returnbook(JTable table) {
		Connection con = DBconnection.getConnection();
		int row = table.getSelectedRow();
		String isbn = table.getValueAt(row, 0).toString();
		String sql = "UPDATE books SET borrowed = NULL WHERE isbn="+isbn+"";
		
		
		
		try {
			Statement stat = con.createStatement();
			stat.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}



