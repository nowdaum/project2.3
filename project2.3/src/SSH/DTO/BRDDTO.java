package SSH.DTO;

import java.sql.Date;

public class BRDDTO {
	private int brd_num;
	private String mem_name;
	private String brd_title;
	private Date brd_date;
	private String brd_content;
	
	public BRDDTO(int brd_num, String mem_name, String brd_title, Date brd_date, String brd_content){
		this.brd_num = brd_num;
		this.mem_name = mem_name;
		this.brd_title = brd_title;
		this.brd_date = brd_date;
		this.brd_content = brd_content;
	}
	public BRDDTO(int brd_num, String brd_title, Date brd_date, String brd_content) {
		this.brd_num = brd_num;
		this.brd_title = brd_title;
		this.brd_date = brd_date;
		this.brd_content = brd_content;
	}
	public BRDDTO() {
	}
	
	public int getBrd_num() {
		return brd_num;
	}
	
	public void setBrd_num(int brd_num) {
		this.brd_num = brd_num;
	}
	
	public String getMem_name() {
		return mem_name;
	}
	
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	
	public String getBrd_title() {
		return brd_title;
	}
	
	public void setBrd_title(String brd_title) {
		this.brd_title = brd_title;
	}
	
	public Date getBrd_date() {
		return brd_date;
	}
	
	public void setBrd_date(Date brd_date) {
		this.brd_date = brd_date;
	}
	
	public String getBrd_content() {
		return brd_content;
	}
	
	public void setBrd_content(String brd_content) {
		this.brd_content = brd_content;
	}
}