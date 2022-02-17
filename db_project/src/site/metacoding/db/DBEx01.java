package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBEx01 {

	public static void main(String[] args) {
		// ����̴ϱ� try-catch
		try {
			// 1. connection ����(���ǻ���) port, ip, id, password, protocol��
			Connection conn = DriverManager.getConnection
					  ("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			System.out.println("DB ����Ϸ�");
			
			// 2. ���� �޾Ƽ� ���(ALL:SELECT * FROM emp) �������ݿ� �°�!
			// ���̺귯���� ����ϸ� ALL: �Ⱥٿ��� ��! 
			// ���������� ����� ���� PrepareStatement
			String sql = "SELECT empno, ename FROM emp";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// flush �����ؼ� rs�� ����ޱ�
			ResultSet rs = pstmt.executeQuery();	// SELECT
			// pstmt.executeUpdate();	// INSERT, UPDATE, DELETE
			// System.out.println(rs.next()); // Ŀ�� �� ĭ ������
		
			// ������ ����� ��� ������ �𸣱� ������ while�� ���� ���
			while(rs.next()) {
				System.out.println("empno : " + rs.getInt("empno")); // getInt("�÷���")
				System.out.println("ename : " + rs.getString("ename"));
				System.out.println("================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}