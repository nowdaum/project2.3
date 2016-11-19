package SSH.DTO;

import java.sql.Date;

public class MEMDTO {
	private int mem_num;
	private int ban_num;
	private String mem_name;
	private String mem_id;
	private String mem_pass;
	private int mem_grade;
	private String mem_ph;
	private int mem_birth;
	
	public MEMDTO(){
		this.mem_num = 0;
		this.ban_num = 0;
		this.mem_name = null;
		this.mem_id = null;
		this.mem_pass = null;
		this.mem_grade = 0;
		this.mem_ph = null;
		this.mem_birth = 0;
	}
	
	public MEMDTO(int mem_num, int ban_num, String mem_name, String mem_id, String mem_pw, int mem_birth,  int mem_grade,String mem_ph){
		this.mem_num = mem_num;
		this.ban_num = ban_num;
		this.mem_name = mem_name;
		this.mem_id = mem_id;
		this.mem_pass = mem_pw;
		this.mem_birth = mem_birth;
		this.mem_grade = mem_grade;
		this.mem_ph = mem_ph;
	}
	
	public int getMem_num() {
		return mem_num;
	}
	
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	
	public int getBan_num() {
		return ban_num;
	}
	
	public void setBan_num(int ban_num) {
		this.ban_num = ban_num;
	}
	
	public String getMem_name() {
		return mem_name;
	}
	
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	
	public String getMem_id() {
		return mem_id;
	}
	
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
	public String getMem_pass() {
		return mem_pass;
	}
	
	public void setMem_pass(String mem_pass) {
		this.mem_pass = mem_pass;
	}
	
	public int getMem_grade() {
		return mem_grade;
	}
	
	public void setMem_grade(int mem_grade) {
		this.mem_grade = mem_grade;
	}
	
	public String getMem_ph() {
		return mem_ph;
	}
	
	public void setMem_ph(String mem_ph) {
		this.mem_ph = mem_ph;
	}
	
	public int getMem_birth() {
		return mem_birth;
	}
	
	public void setMem_birth(int mem_birth) {
		this.mem_birth = mem_birth;
	}
}