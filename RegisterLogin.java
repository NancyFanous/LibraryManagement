package librarymanagment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class RegisterLogin {
	
	JPanel frame1 = new JPanel();
	RegisterLoginFrame frame2 = new RegisterLoginFrame();
	


	public void registerform(Users user) { /*user register func*/
		Connection con = DBconnection.getConnection();
		try {
			Statement st =con.createStatement();
			Statement stat = con.createStatement();
			String test = "SELECT * FROM users WHERE username = '" + user.getusername() +"'";
			ResultSet rs = st.executeQuery(test);
			
			if(rs.next()) {
			JOptionPane.showMessageDialog(frame1,"username already exist");
			}else {
				String sql = "INSERT INTO users(username,pass) VALUES('" + user.getusername()+"' ,'" + user.getpassword() +"')";
				stat.execute(sql);
				JOptionPane.showMessageDialog(frame1,"registered successfully");
			}

			
			con.close();
			stat.close();
			st.close();
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void login(Users user, JFrame frame2 ) { /*user login func*/
		Connection con = DBconnection.getConnection();		
		try {
			Statement stat = con.createStatement();
			String sql = "SELECT username ,pass FROM users WHERE username = '"+user.getusername()+"' and pass ='"+user.getpassword()+"'";
			ResultSet rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				UserFrame frame = new UserFrame();
				frame.nameforlabel(user.getusername());
				frame.setVisible(true);
				frame2.dispose();
				
			}else {
				JOptionPane.showMessageDialog(frame1,"username or password are incorrect");
				}
			con.close();
			stat.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void adminaccess(Admin admin ,JFrame frame2) { /*admin login func*/


		Connection con = DBconnection.getConnection();		
		try {
			Statement st = con.createStatement();
			String sql = "SELECT username ,pass FROM admins WHERE username = '"+admin.getusername()+"' and pass ='"+admin.getpassword()+"'";
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				AdminFrame adminn = new AdminFrame();
				adminn.setVisible(true);
				frame2.dispose();
			}
			con.close();
			st.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

