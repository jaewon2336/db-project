package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// dept ���̺��� ��� ������ ����Ͻÿ�
// SELECT deptno, dname, loc FROM dept
public class DBEx05 {

	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			System.out.println("DB ����Ϸ�");

			String sql = "SELECT deptno, dname, loc FROM dept";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(); // SELECT

			List<Dept> depts = new ArrayList<>();

			// �Ľ�
			while (rs.next()) {
				// while ���鼭 dept�� �ʱ�ȭ �Ǵϱ� �÷��ǿ� ��Ƴ���
				Dept dept = new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));

				depts.add(dept);
			}

			// for-each�� ����ؼ� ���
			for (Dept dept : depts) {
				System.out.println("deptno : " + dept.getDeptno()); // getInt("�÷���")
				System.out.println("dname : " + dept.getDname());
				System.out.println("loc : " + dept.getLoc());
				System.out.println("====================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
