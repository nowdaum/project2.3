package SSH.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import SSH.DB.DBconn;
import SSH.DTO.BANDTO;

public class BANDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql = null;
	private int cal = 0;

	private static String url;
	private static String user;
	private static String password;

	public BANDAO() throws Exception {
		url = "jdbc:oracle:thin:@localhost:1521:xe";
		user = "scott";
		password = "TIGER";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, user, password);
	}

	public BANDAO(String driver, String url, String user, String password)
			throws Exception {
		this.url = url;
		this.user = user;
		this.password = password;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(this.url, this.user, this.password);
	}

//	public List<BANDTO> SelectEducationInfo(int ban_num) throws SQLException {
		public List<BANDTO> SelectEducationInfo() throws SQLException {
		List<BANDTO> list = new ArrayList<BANDTO>();
		BANDTO dto = new BANDTO();
//		String sql = "select * from BAN where ban_num=?";
		String sql = "select * from BAN";
		pstmt = conn.prepareStatement(sql);
//		pstmt.setInt(1, ban_num);
		rs = pstmt.executeQuery();
		try {
			System.out.println("test try");
			while (rs.next()) {
//				dto = new BANDTO(rs.getInt("ban_num"),
						list.add( new BANDTO(rs.getInt("ban_num"),
						rs.getString("ban_name"), rs.getInt("ban_inone"),
						rs.getString("ban_period"), rs.getString("ban_teacher")));
				System.out.println("test while");
			}

		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		System.out.println("test return before");
		return list;
	}

	public BANDTO selectOne(int ban_num) throws SQLException {
		BANDTO dto = new BANDTO();
		String sql = "select * from BAN where ban_num=?";
		System.out.println("test try1");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ban_num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setBan_num(rs.getInt("Ban_num"));
				dto.setBan_name(rs.getString("Ban_name"));
				dto.setBan_inone(rs.getInt("Ban_inone"));
				dto.setBan_period(rs.getString("Ban_period"));
				dto.setBan_teacher(rs.getString("Ban_teacher"));
				System.out.println("test while1");
			}
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return dto;
	}

	
	public int insertBaninfo(String ban_name, int ban_inone, String ban_period,
			String ban_teacher) throws SQLException {
		int cnt = 0;
		String sql = "";
		
		if(ban_name.equals("응용SW")){
			sql = "insert into ban (ban_num,ban_name,ban_inone,ban_period,ban_teacher) "
				+ "values (sw_seq.nextval,?,?,?,?)";
		}else if (ban_name.equals("프로그래밍")){
			sql = "insert into ban (ban_num,ban_name,ban_inone,ban_period,ban_teacher) "
					+ "values (pr_seq.nextval,?,?,?,?)";
		}else{
			sql = "insert into ban (ban_num,ban_name,ban_inone,ban_period,ban_teacher) "
					+ "values (pa_seq.nextval,?,?,?,?)";
		}
		System.out.println(sql);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ban_name);
			pstmt.setInt(2, ban_inone);
			pstmt.setString(3, ban_period);
			pstmt.setString(4, ban_teacher);
			cnt = pstmt.executeUpdate();
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return cnt;
	}

	public int updateBaninfo(BANDTO dto) throws SQLException {
		int cal = 0;
		String sql = "UPDATE BAN SET BAN_INONE=?, BAN_PERIOD=?, BAN_TEACHER=? WHERE BAN_NUM=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getBan_inone());
			pstmt.setString(2, dto.getBan_period());
			pstmt.setString(3, dto.getBan_teacher());
			pstmt.setInt(4, dto.getBan_num());
			cal = pstmt.executeUpdate();
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return cal;
	}

	public int deleteBaninfo(int ban_num) throws SQLException {
		int cal = 0;
		String sql = "delete from ban where ban_num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ban_num);
			cal = pstmt.executeUpdate();
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return cal;
	}
}