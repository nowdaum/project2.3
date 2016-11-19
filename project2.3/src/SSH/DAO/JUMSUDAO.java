package SSH.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import SSH.DB.DBconn;
import SSH.DTO.BRDDTO;
import SSH.DTO.JUMSUDTO;

public class JUMSUDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql = null;
	private int cal = 0;
	private ArrayList<JUMSUDTO> list = null;
	
	public JUMSUDAO() {
		DBconn db = new DBconn();
		try {
			conn = db.getConn();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public int insertJumsu(int mem_num,String mem_name,int jumsu_score1, int jumsu_score2, int jumsu_score3) throws Exception{
		
		int cal=0;
		String sql="insert into JUMSU (mem_num,mem_name,jumsu_score1,jumsu_score2,jumsu_score3) "
				+ "values (?,?,?,?,?)";
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, mem_num);
			pstmt.setString(2, mem_name);
			pstmt.setInt(3, jumsu_score1);
			pstmt.setInt(4, jumsu_score2);
			pstmt.setInt(5, jumsu_score3);
			cal=pstmt.executeUpdate();
		}finally{
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		return cal;
	}
	

	public int updateJumsu (JUMSUDTO dto) throws SQLException{
		int cal=0;
		String sql="update JUMSU set mem_name=?,jumsu_score1=?,jumsu_score2=?,jumsu_score3=? where mem_num=?";
		try{
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, dto.getMem_name());
		pstmt.setInt(2, dto.getJumsu_score1());
		pstmt.setInt(3, dto.getJumsu_score2());
		pstmt.setInt(4, dto.getJumsu_score3());
		pstmt.setInt(5, dto.getMem_num());
		cal=pstmt.executeUpdate();
		}finally{
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		return cal;
	}
		
	public int deleteJumsu(int mem_num) throws SQLException{
		int cal=0;
		String sql="update JUMSU set jumsu_score1=0,jumsu_score2=0,jumsu_score3=0 where mem_num=?";
		//String sql="delete from JUMSU  where mem_num=?";
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, mem_num);
			cal=pstmt.executeUpdate();
			}finally{
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}
		return cal;
	}

	
	public List<JUMSUDTO> allJumsufind(int ban_num) throws SQLException{
		List<JUMSUDTO> list=new ArrayList<JUMSUDTO>();
		String sql="select * from jumsu where ban_num=?";
		System.out.println(sql);
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, ban_num);
			rs=pstmt.executeQuery();
			while(rs.next()){
				JUMSUDTO dto=new JUMSUDTO(rs.getInt("ban_num")
						, rs.getInt("mem_num")
						, rs.getString("mem_name")
						, rs.getInt("jumsu_score1")
						, rs.getInt("jumsu_score2")
						, rs.getInt("jumsu_score3"));
				list.add(dto);
			}
		}finally{
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		return list;
	}
	
	public JUMSUDTO oneJumsuFind(int mem_num) throws SQLException{
		JUMSUDTO dto=new JUMSUDTO();
		String sql="select * from jumsu where mem_num=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, mem_num);
			rs=pstmt.executeQuery();
			if(rs.next()){
				dto.setBan_num(rs.getInt("ban_num"));
				dto.setMem_num(rs.getInt("mem_num"));
				dto.setMem_name(rs.getString("mem_name"));
				dto.setJumsu_score1(rs.getInt("jumsu_score1"));
				dto.setJumsu_score2(rs.getInt("jumsu_score2"));
				dto.setJumsu_score3(rs.getInt("jumsu_score3"));
			}
		} finally {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		return dto;
	}
		
	

	
	
	
	public JUMSUDTO detailJumsu(int mem_num) throws SQLException{
		JUMSUDTO dto=new JUMSUDTO();
		String sql="select * from jumsu where mem_num=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, mem_num);
			rs=pstmt.executeQuery();
			if(rs.next()){
				dto.setBan_num(rs.getInt("ban_num"));
				dto.setMem_num(rs.getInt("mem_num"));
				dto.setMem_name(rs.getString("mem_name"));
				dto.setJumsu_score1(rs.getInt("jumsu_score1"));
				dto.setJumsu_score2(rs.getInt("jumsu_score2"));
				dto.setJumsu_score3(rs.getInt("jumsu_score3"));
			}
		} finally {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		return dto;
	}
	
	
	
//	public int getTot() throws SQLException {  //BRD 테이블안에 몇개의 글이 들어잇는가?
//		int tot=0;
//		String sql="select count(*) as tot from JUMSU";//바꿈
//		try{
//			pstmt=conn.prepareStatement(sql);
//			rs=pstmt.executeQuery();
//			if(rs.next()){
//				tot=rs.getInt("tot");
//			}
//		}finally{
//			if(pstmt!=null)pstmt.close();
//		}
//		return tot;
//	}
	
}
	
	
	
	