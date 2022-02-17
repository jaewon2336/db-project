package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// dept 테이블의 모든 내용을 출력하시오
// SELECT deptno, dname, loc FROM dept
public class DBEx05 {

	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			System.out.println("DB 연결완료");

			String sql = "SELECT deptno, dname, loc FROM dept";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(); // SELECT

			List<Dept> depts = new ArrayList<>();

			// 파싱
			while (rs.next()) {
				// while 돌면서 dept가 초기화 되니까 컬렉션에 담아놓자
				Dept dept = new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));

				depts.add(dept);
			}

			// for-each문 사용해서 출력
			for (Dept dept : depts) {
				System.out.println("deptno : " + dept.getDeptno()); // getInt("컬럼명")
				System.out.println("dname : " + dept.getDname());
				System.out.println("loc : " + dept.getLoc());
				System.out.println("====================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
