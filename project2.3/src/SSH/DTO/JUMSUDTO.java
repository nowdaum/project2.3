package SSH.DTO;

import java.util.List;

public class JUMSUDTO {
	private int ban_num;
	private int mem_num;
	private String mem_name;
	private int jumsu_score1;
	private int jumsu_score2;
	private int jumsu_score3;
	
	public JUMSUDTO(){
		
	}
	
	public JUMSUDTO(int ban_num,int mem_num,String mem_name,int jumsu_score1,int jumsu_score2,int jumsu_score3){
		this.ban_num = ban_num;
		this.mem_num = mem_num;
		this.mem_name = mem_name;
		this.jumsu_score1 = jumsu_score1;
		this.jumsu_score2 = jumsu_score2;
		this.jumsu_score3 = jumsu_score3;
	}
	
	
	
	public JUMSUDTO(int mem_num,String mem_name,int jumsu_score1,int jumsu_score2,int jumsu_score3){
		this.mem_num = mem_num;
		this.mem_name = mem_name;
		this.jumsu_score1 = jumsu_score1;
		this.jumsu_score2 = jumsu_score2;
		this.jumsu_score3 = jumsu_score3;
		
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

	public int getJumsu_score1() {
		return jumsu_score1;
	}

	public void setJumsu_score1(int jumsu_score1) {
		this.jumsu_score1 = jumsu_score1;
	}
	
	public int getJumsu_score2() {
		return jumsu_score2;
	}

	public void setJumsu_score2(int jumsu_score2) {
		this.jumsu_score2 = jumsu_score2;
	}

	public int getJumsu_score3() {
		return jumsu_score3;
	}

	public void setJumsu_score3(int jumsu_score3) {
		this.jumsu_score3 = jumsu_score3;
	}
	
	
/*
 	@Override
	public String toString() {
		return "JUMSUDTO [ban_num=" + ban_num + ", mem_num=" + mem_num
				+ ", mem_name=" + mem_name + ", jumsu_score1=" + jumsu_score1
				+ ", jumsu_score1=" + jumsu_score1+ ", jumsu_score2=" + jumsu_score2
				+ ", jumsu_score3=" + jumsu_score3+"]";
	}
*/
}