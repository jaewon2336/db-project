package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

// UPDATE
public class DBEx08 {

	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			System.out.println("DB ����Ϸ�");

			// id 1�� username�� coding���� ����
			String sql = "UPDATE userTbl SET username = ? WHERE id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "coding"); // ����ǥ ����, ��
			pstmt.setInt(2, 1);

//			executeUpdate�� ���ο� COMMIT�� �����Ѵ�.
			int result = pstmt.executeUpdate(); // INSERT, UPDATE, DELETE

			if (result > 0) {
				System.out.println("����"); // 1
			} else {
				System.out.println("����"); // 0
			}

		} catch (Exception e) { // -1 �����ϸ� if�� Ÿ���ʰ� �ٷ� catch�� ź��.
			e.printStackTrace();
		}

	}
}