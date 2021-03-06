package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBEx01 {

	public static void main(String[] args) {
		// 통신이니까 try-catch
		try {
			// 1. connection 연결(세션생성) port, ip, id, password, protocol★
			Connection conn = DriverManager.getConnection
					  ("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			System.out.println("DB 연결완료");
			
			// 2. 버퍼 달아서 통신(ALL:SELECT * FROM emp) 프로토콜에 맞게!
			// 라이브러리를 사용하면 ALL: 안붙여도 됨! 
			// 프로토콜이 적용된 버퍼 PrepareStatement
			String sql = "SELECT empno, ename FROM emp";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// flush 전송해서 rs로 응답받기
			ResultSet rs = pstmt.executeQuery();	// SELECT
			// pstmt.executeUpdate();	// INSERT, UPDATE, DELETE
			// System.out.println(rs.next()); // 커서 한 칸 내리기
		
			// 쿼리의 결과가 몇개가 나올지 모르기 때문에 while을 돌며 출력
			while(rs.next()) {
				System.out.println("empno : " + rs.getInt("empno")); // getInt("컬럼명")
				System.out.println("ename : " + rs.getString("ename"));
				System.out.println("================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}