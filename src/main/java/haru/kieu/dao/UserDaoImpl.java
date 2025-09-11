package haru.kieu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import haru.kieu.model.User;
import haru.kieu.connectDB.ConnectDB;

public class UserDaoImpl implements UserDao {

	@Override
	public User findByUserName(String username) {
		String sql = "SELECT * FROM [DangNhap] WHERE username = ?";
		try (Connection conn = new ConnectDB().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, username);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					User user = new User();
					user.setId(rs.getInt("id"));
					user.setEmail(rs.getString("email"));
					user.setUserName(rs.getString("username"));
					user.setFullName(rs.getString("fullname"));
					user.setPassWord(rs.getString("password"));
					user.setAvatar(rs.getString("avatar"));
					user.setRoleid(rs.getInt("roleid"));
					user.setPhone(rs.getString("phone"));
					user.setCreatedDate(rs.getDate("createdDate"));
					return user;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updatePassword(int id, String newPassword) {
		String sql = "UPDATE [DangNhap] SET [password] = ? WHERE id = ?";
		try (Connection conn = new ConnectDB().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, newPassword);
			ps.setInt(2, id);
			int rowsAffected = ps.executeUpdate();
			return rowsAffected > 0;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
