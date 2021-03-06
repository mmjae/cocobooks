package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Member;
import common.JdbcUtill;

public class AuthorChangeInsertDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public AuthorChangeInsertDao() {
		con=JdbcUtill.getConnection();
	}
	public void close() {
		JdbcUtill.close(rs, pstmt, con);
	}
	public boolean upDate(String id) {
		String sql= "UPDATE MEMBER SET MB_APPLY = '신청' WHERE MB_ID=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setNString(1, id);
			int result=pstmt.executeUpdate();
			if(result!=0) {
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	public Member check(String id) {
		Member mb=null;
		String sql="SELECT MB_APPLY FROM MEMBER WHERE MB_ID=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setNString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				mb= new Member();
				mb.setApply(rs.getNString("MB_APPLY"));
			}
			return mb;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mb;
	}
	
	
}
