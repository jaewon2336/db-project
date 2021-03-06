package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

// INSERT
public class DBEx06 {

	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			System.out.println("DB 연결완료");

			String sql = "INSERT INTO userTbl(id, username, password, gender) VALUES(?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 7); // 물음표 순서, 값
			pstmt.setString(2, "there");
			pstmt.setString(3, "1234");
			pstmt.setString(4, "남");
// 			ResultSet rs = pstmt.executeQuery(); // SELECT
//			에러 -1, 성공 row 개수, 아무 변화없으면 0
//			ex) DELETE -> 7번 ID 없는 값 삭제 : 0
//			ex) DELETE -> 6번 ID 1행 삭제 : 1
//			ex) DELETE -> 조건 없이 전체 행 삭제 : 6
//			결국 0보다 크지 않으면 실패
//			executeUpdate는 내부에 COMMIT이 존재한다.
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