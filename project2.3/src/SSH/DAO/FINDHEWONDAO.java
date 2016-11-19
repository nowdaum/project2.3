package SSH.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import SSH.DB.DBconn;
import SSH.DTO.FINDHEWONDTO;
import SSH.DTO.MEMDTO;

public class FINDHEWONDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql = null;
	private int cal = 0;
	private ArrayList<FINDHEWONDTO> list = null;
	
	public FINDHEWONDAO() {
		DBconn db = new DBconn();
		try {
			conn = db.getConn();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void insertFindhewoninfo(int ban_num, int mem_num, String mem_name, String mem_ph) throws SQLException{
		cal = 0;
		sql = "insert into FINDHEWON values (?,?,?,?)";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, ban_num);
		pstmt.setInt(2, mem_num);
		pstmt.setString(3, mem_name);
		pstmt.setString(4, mem_ph);
		
		cal = pstmt.executeUpdate();
		
		if(pstmt != null){pstmt.close();}
		if(conn != null){conn.close();}
	}
	
	public List<FINDHEWONDTO> allFindhewoninfo(int p,int row) throws SQLException{
			List<FINDHEWONDTO> list=new ArrayList<FINDHEWONDTO>();
			int start = (p-1)*row+1;
			int end = start+row-1;
			String sql="select * from "
					+ "(select rownum as rn,A.* "
					+ "from (select * from findhewon "
					+ "order by ban_num,mem_num desc)A) "
					+ "where rn between "+start+" and "+end;
			try{
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while(rs.next()){
					FINDHEWONDTO dto=new FINDHEWONDTO(rs.getInt("ban_num")
							, rs.getInt("mem_num")
							, rs.getString("mem_name")
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
		
	
	public int getTot() throws SQLException {  //테이블안에 몇개의 글이 들어잇는가?
		int tot=0;
		String sql="select count(*) as tot from findhewon";
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