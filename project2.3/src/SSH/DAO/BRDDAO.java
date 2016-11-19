package SSH.DAO;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import SSH.DB.DBconn;
import SSH.DTO.BRDDTO;

public class BRDDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql = null;
	private int cal = 0;
	private ArrayList<BRDDTO> list = null;
	
	public BRDDAO() {
		DBconn db = new DBconn();
		try {
			conn = db.getConn();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int insertBrdinfo(String brd_title, String brd_content) throws SQLException{
		
		int cnt=0;
		String sql="insert into brd (brd_num,brd_title,brd_content,brd_date) "
				+ "values (BRD_seq.nextval,?,?,sysdate)";
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, brd_title);
			pstmt.setString(2, brd_content);
			cnt=pstmt.executeUpdate();
		}finally{
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		return cnt;
	}
	
	public int updateBrdinfo(BRDDTO dto) throws SQLException{
		int cal=0;
		String sql="update brd set brd_title=?"
				+ ",brd_date=sysdate,brd_content=? where brd_num=?";
		try{
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, dto.getBrd_title());
		pstmt.setString(2, dto.getBrd_content());
		pstmt.setInt(3, dto.getBrd_num());
		cal=pstmt.executeUpdate();
		}finally{
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		return cal;
	}
	
	public int deleteBrdinfo(int brd_num) throws SQLException{
		int cal=0;
		String sql="delete from brd where brd_num=?";
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, brd_num);
			cal=pstmt.executeUpdate();
			}finally{
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}
		return cal;
	}
		
	
	
	public List<BRDDTO> allBrdinfo(int p,int row) throws SQLException{
			List<BRDDTO> list=new ArrayList<BRDDTO>();
			int start = (p-1)*row+1;
			int end = start+row-1;
			String sql="select * from "
					+ "(select rownum as rn,A.* "
					+ "from (select * from brd "
					+ "order by brd_num desc)A) "
					+ "where rn between "+start+" and "+end;
			try{
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while(rs.next()){
					BRDDTO dto=new BRDDTO(rs.getInt("brd_num")
							, rs.getString("mem_name")
							, rs.getString("brd_title")
							, rs.getDate("brd_date")
							, rs.getString("brd_content"));
					list.add(dto);
				}
			}finally{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}
			return list;
		}
		
	
	public JSONArray namefind(String mem_name){
		//List<BRDDTO> list = new ArrayList<BRDDTO>();
		JSONArray list = new JSONArray();
		
		String sql="select * from brd "+ "where mem_name like '%"+mem_name+"%' " +"order by mem_name";
		
		System.out.println("sql="+sql);
		try {
			pstmt= conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				/*BRDDTO dto=new BRDDTO(rs.getInt("brd_num")
						, rs.getString("mem_name")
						, rs.getString("brd_title")
						, rs.getDate("brd_date")
						, rs.getString("brd_content"));
				list.add(dto);*/
				JSONObject dto = new JSONObject();
				
				dto.put("num", rs.getInt("brd_num")+"");
				dto.put("name",rs.getString("mem_name"));
				dto.put("title",rs.getString("brd_title"));
				
				DateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date nowDate = new Date();
				String tempDate = sdFormat.format(rs.getDate("brd_date"));
				
				System.out.println("tempdate="+tempDate);
				//dto.put("date",rs.getDate("brd_date"));
				dto.put("date",tempDate);
				//dto.put("content", rs.getString("brd_content"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public BRDDTO titlefind(int brd_num) throws SQLException{
			BRDDTO dto=new BRDDTO();
			String sql="select * from brd where brd_num=?";
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, brd_num);
				rs=pstmt.executeQuery();
				if(rs.next()){
					dto.setBrd_num(rs.getInt("brd_num"));
					dto.setMem_name(rs.getString("mem_name"));
					dto.setBrd_title(rs.getString("brd_title"));
					dto.setBrd_date(rs.getDate("brd_date"));
					dto.setBrd_content(rs.getString("brd_content"));
				}
			} finally {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}
			return dto;
		}
		

	public int getTot() throws SQLException {  //테이블안에 몇개의 글이 들어잇는가?
		int tot=0;
		String sql="select count(*) as tot from brd";//바꿈
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