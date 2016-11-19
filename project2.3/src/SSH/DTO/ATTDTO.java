package SSH.DTO;

import java.sql.Date;

public class ATTDTO {
	private int ban_num;
	private int mem_num;
	private String mem_name;
	private Date att_date;
	private Date att_log;
	private Date att_out;
	
	public ATTDTO(int ban_num, int mem_num, String mem_name, Date att_date, Date att_log, Date att_out){
		this.ban_num = ban_num;
		this.mem_num = mem_num;
		this.mem_name = mem_name;
		this.att_date = att_date;
		this.att_log = att_log;
		this.att_out = att_out;
	}
	
	public int getBan_num() {
		return ban_num;
	}
	
	public void setBan_num(int ban_num) {
		this.ban_num = ban_num;
	}
	
	public int getMem_num() {
		return mem_num;
	}
	
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	
	public String getMem_name() {
		return mem_name;
	}
	
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	
	public Date getAtt_date() {
		return att_date;
	}
	
	public void setAtt_date(Date att_date) {
		this.att_date = att_date;
	}
	
	public Date getAtt_log() {
		return att_log;
	}
	
	public void setAtt_log(Date att_log) {
		this.att_log = att_log;
	}
	
	public Date getAtt_out() {
		return att_out;
	}
	
	public void setAtt_out(Date att_out) {
		this.att_out = att_out;
	}
}