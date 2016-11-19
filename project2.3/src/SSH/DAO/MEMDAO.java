package SSH.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import SSH.DB.DBconn;
import SSH.DTO.MEMDTO;

public class MEMDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql = null;
	private int cal = 0;
	private ArrayList<MEMDTO> list = null;
	private MEMDTO dto;
	JSONArray ja;
	JSONObject jo;
	
	public int insertMeminfo(String name, String id, String pass, String ph, int birth) throws Exception{
		sql = "insert into MEM (BAN_NUM,MEM_NUM,MEM_NAME,MEM_ID,MEM_PW,MEM_BIRTH,MEM_GRADE,MEM_PH) values (0,M_seq.nextval,?,?,?,?,0,?)";
		
		conn = new DBconn().getConn();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, id);
		pstmt.setString(3, pass);
		pstmt.setInt(4, birth);
		pstmt.setString(5, ph);
		
		cal = pstmt.executeUpdate();
		
		if(pstmt != null){pstmt.close();}
		if(conn != null){conn.close();}
		
		return cal;
	}
	
	public int updateMeminfo(MEMDTO dto) throws Exception{
		int cal=0;
		conn = new DBconn().getConn();
		String sql="update mem set ban_num=?"
				+ ",mem_name=?,mem_id=?,mem_pw=?,mem_birth=?"
				+ ",mem_grade=?,mem_ph=? where mem_num=?";
		try{
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, dto.getBan_num());
		pstmt.setString(2, dto.getMem_name());
		pstmt.setString(3, dto.getMem_id());
		pstmt.setString(4, dto.getMem_pass());
		pstmt.setInt(5, dto.getMem_birth());
		pstmt.setInt(6, dto.getMem_grade());
		pstmt.setString(7, dto.getMem_ph());
		pstmt.setInt(8, dto.getMem_num());
		cal=pstmt.executeUpdate();
		}finally{
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		return cal;
	}
	
	public int updateOnemem(MEMDTO dto) throws Exception{
		int cal=0;
		conn = new DBconn().getConn();
		String sql="update mem set ban_num=?"
				+ ",mem_name=?,mem_id=?,mem_pw=?,mem_birth=?"
				+ ",mem_grade=?,mem_ph=? where mem_num=?";
		try{
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, dto.getBan_num());
		pstmt.setString(2, dto.getMem_name());
		pstmt.setString(3, dto.getMem_id());
		pstmt.setString(4, dto.getMem_pass());
		pstmt.setInt(5, dto.getMem_birth());
		pstmt.setInt(6, dto.getMem_grade());
		pstmt.setString(7, dto.getMem_ph());
		pstmt.setInt(8, dto.getMem_num());
		cal=pstmt.executeUpdate();
		}finally{
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		return cal;
	}
	
	public int deleteMeminfo(int mem_num) throws Exception{
		conn = new DBconn().getConn();
		int cal=0;
		String sql="delete from mem where mem_num=?";
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
	
	public List<MEMDTO> allMeminfo(int p,int row) throws Exception{
		List<MEMDTO> list=new ArrayList<MEMDTO>();
		int start = (p-1)*row+1;
		int end = start+row-1;
		conn = new DBconn().getConn();
		String sql="select * from "
				+ "(select rownum as rn,A.* "
				+ "from (select * from mem "
				+ "order by mem_num desc)A) "
				+ "where rn between "+start+" and "+end;
		try{
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				MEMDTO dto = new MEMDTO(rs.getInt("mem_num")
						, rs.getInt("ban_num")
						, rs.getString("mem_name")
						, rs.getString("mem_id")
						, rs.getString("mem_pw")
						, rs.getInt("mem_birth")
						, rs.getInt("mem_grade")
						, rs.getString("mem_ph"));
				list.add(dto);
			}
		}finally{
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		
		return list;
	}
	
	public JSONObject login(String id, String pass) throws Exception{
		sql = "select * from MEM where MEM_ID = ? AND MEM_PW = ?";

		jo = new JSONObject();
		conn = new DBconn().getConn();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pass);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()){
			jo.put("mem_num", rs.getInt("mem_num")+"");
			jo.put("ban_num", rs.getInt("ban_num")+"");
			jo.put("mem_id", rs.getString("mem_id"));
			jo.put("mem_pw", rs.getString("mem_pw"));
			jo.put("mem_name", rs.getString("mem_name"));
			jo.put("mem_birth", rs.getInt("mem_birth")+"");
			jo.put("mem_grade", rs.getInt("mem_grade")+"");
			jo.put("mem_ph", rs.getString("mem_ph"));
		}
		
		if(rs != null){rs.close();}
		if(pstmt != null){pstmt.close();}
		if(conn != null){conn.close();}
		
		return jo;
	}
	
	public String idfind(String name, int birth) throws Exception{
		String id = null;
		sql = "select mem_id from MEM where MEM_NAME = ? AND MEM_BIRTH = ?";
		
		dto = new MEMDTO();
		conn = new DBconn().getConn();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setInt(2, birth);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()){
			id = rs.getString("MEM_ID");
		}
		
		return id;
	}
	
	public String passfind(String name, int birth, String id) throws Exception{
		String pass = null;
		System.out.println(name);
		System.out.println(birth);
		System.out.println(id);
		sql = "select mem_pw from MEM where (MEM_NAME = ? AND MEM_BIRTH = ?) AND MEM_ID = ?";
		
		dto = new MEMDTO();
		conn = new DBconn().getConn();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setInt(2, birth);
		pstmt.setString(3, id);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()){
			pass = rs.getString("MEM_PW");
			System.out.println(pass);
		}
		return pass;
	}
	
	public MEMDTO oneMeminfo(int mem_num) throws Exception{
		MEMDTO dto=new MEMDTO();
		conn = new DBconn().getConn();
		String sql="select * from mem where mem_num=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, mem_num);
			rs=pstmt.executeQuery();
			if(rs.next()){
				dto.setMem_num(rs.getInt("mem_num"));
				dto.setBan_num(rs.getInt("ban_num"));
				dto.setMem_name(rs.getString("mem_name"));
				dto.setMem_id(rs.getString("mem_id"));
				dto.setMem_pass(rs.getString("mem_pw"));
				dto.setMem_birth(rs.getInt("mem_birth"));
				dto.setMem_grade(rs.getInt("mem_grade"));
				dto.setMem_ph(rs.getString("mem_ph"));
			}
		} finally {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		return dto;
	}
	
	public MEMDTO oneMem(int mem_num) throws Exception{
		MEMDTO dto=new MEMDTO();
		conn = new DBconn().getConn();
		String sql="select * from mem where mem_num=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, mem_num);
			rs=pstmt.executeQuery();
			if(rs.next()){
				dto.setMem_num(rs.getInt("mem_num"));
				dto.setBan_num(rs.getInt("ban_num"));
				dto.setMem_name(rs.getString("mem_name"));
				dto.setMem_id(rs.getString("mem_id"));
				dto.setMem_pass(rs.getString("mem_pw"));
				dto.setMem_birth(rs.getInt("mem_birth"));
				dto.setMem_grade(rs.getInt("mem_grade"));
				dto.setMem_ph(rs.getString("mem_ph"));
			}
		} finally {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		return dto;
	}
	
	public int getTot() throws Exception {  //테이블안에 몇개의 글이 들어잇는가?
		int tot=0;
		conn = new DBconn().getConn();
		String sql="select count(*) as tot from MEM";//바꿈
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
	
	public JSONObject idcheck(String id) throws Exception{
		JSONObject jObj = new JSONObject();
		sql = "select mem_id from MEM where mem_id = ?";
		
		conn = new DBconn().getConn();
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()){
			jObj.put("mem_id", rs.getString("mem_id"));
		}
		
		if(rs != null){rs.close();}
		if(pstmt != null){pstmt.close();}
		if(conn != null){conn.close();}
		
		return jObj;
	}
}