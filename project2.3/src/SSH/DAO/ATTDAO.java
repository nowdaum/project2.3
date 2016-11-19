package SSH.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import SSH.DB.DBconn;
import SSH.DTO.ATTDTO;

public class ATTDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql = null;
	private ArrayList<ATTDTO> list = null;
	
	public ATTDAO() {
		DBconn db = new DBconn();
		try {
			conn = db.getConn();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void autoAttinsert(int ban_num, int mem_num, String mem_name) throws SQLException{
		int cal = 0;
		
		sql = "insert into ATT values(ban_num,mem_num,mem_name,sysdate,sysdate,null)";
		
		pstmt = conn.prepareStatement(sql);
		
		cal = pstmt.executeUpdate();
		
		if(pstmt != null){pstmt.close();}
		if(conn != null){conn.close();}
	}
	
	public void logoutAtt(int mem_num) throws SQLException{
		int cal = 0;
		
		String sql = "UPDATE ATT SET ATT_OUT = sysdate WHERE MEM_NUM = ?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, mem_num);
		cal = pstmt.executeUpdate();
		
		if(pstmt != null){pstmt.close();}
		if(conn != null){conn.close();}
	}
	
	public List<ATTDTO> OneAttinfo(int p,int row) throws SQLException{
		List<ATTDTO> list=new ArrayList<ATTDTO>();
		int start = (p-1)*row+1;
		int end = start+row-1;
		String sql="select * from "
				+ "(select rownum as rn,A.* "
				+ "from (select * from att "
				+ "order by mem_num desc)A) "
				+ "where rn between "+start+" and "+end;// + "; //and mem_num=4";
		
		System.out.println(sql);
		try{
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				ATTDTO dto=new ATTDTO(rs.getInt("ban_num")
						, rs.getInt("mem_num")
						, rs.getString("mem_name")
						, rs.getDate("att_date")
						, rs.getDate("att_log")
						, rs.getDate("att_out"));
				list.add(dto);
			}
		}finally{
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		return list;
	}
	
			public List<ATTDTO> allAttinfo(int p,int row) throws SQLException{
			List<ATTDTO> list=new ArrayList<ATTDTO>();
			int start = (p-1)*row+1;
			int end = start+row-1;
			String sql="select * from "
					+ "(select rownum as rn,A.* "
					+ "from (select * from att "
					+ "order by mem_num desc)A) "
					+ "where rn between "+start+" and "+end;
			try{
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while(rs.next()){
					ATTDTO dto=new ATTDTO(rs.getInt("ban_num")
							, rs.getInt("mem_num")
							, rs.getString("mem_name")
							, rs.getDate("att_date")
							, rs.getDate("att_log")
							, rs.getDate("att_out"));
					list.add(dto);
				}
			}finally{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}
			return list;
		}
		
	
	public int getTot() throws SQLException {  //테이블안에 몇개의 글이 들어잇는가?
		int tot=0;
		String sql="select count(*) as tot from mem";//바꿈
		try{
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()){
				tot=rs.getInt("tot");
			}
		}finally{
			if(pstmt!=null)pstmt.close();
		}
		return tot;
	}
}