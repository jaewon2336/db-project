package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

// DELETE
public class DBEx07 {

	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			System.out.println("DB 연결완료");

			String sql = "DELETE FROM userTbl WHERE id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 6); // 물음표 순서, 값

			int result = pstmt.executeUpdate(); // INSERT, UPDATE, DELETE

			if (result > 0) {
				System.out.println("성공"); // 1
			} else {
				System.out.println("실패"); // 0
			}

		} catch (Exception e) { // -1 실패하면 if를 타지않고 바로 catch를 탄다.
			e.printStackTrace();
		}

	}
}