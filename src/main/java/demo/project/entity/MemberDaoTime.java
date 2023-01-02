package demo.project.entity;

import java.sql.*;

public class MemberDaoTime {
	private static int next=1;
	private int timeid;
	public Connection getConnection() { // 連線資料庫
		Connection cn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mydemo?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Taipei",
					"root", "1234");
		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("SQL Error " + ex.getMessage());
		}
		return cn;
	}

	public int Insertmember(MemberTime me) // 新增會員資料
			throws SQLException {
		this.timeid=next++;
		Connection con = null;
		PreparedStatement insert = null;
		String insertStatement = "insert into mydemo.newadd(timeid,name,timename)" + " values (?,?,?)";
			try {
				con = this.getConnection();
				con.setAutoCommit(false);
				insert = con.prepareStatement(insertStatement);

				insert.setInt(1, timeid);
				insert.setString(2, me.getName());
				insert.setString(3, me.getTimename());
				int r = insert.executeUpdate();
				con.commit();
				return r;

			} catch (Exception e) {
				System.out.println("SQL Error:" + e.getMessage());
				if (con != null) {
					try {
						System.err.print("Transaction is being rolled back ");
						con.rollback();
					} catch (SQLException ex) {
						System.out.println(ex.getMessage());
					}
				}
			} finally {
				con.setAutoCommit(true);
				if (insert != null) {
					insert.close();
				}
				if (insert != null) {
					insert.close();
				}

			}
			return 0;
	}
}
