package SSH.DTO;


import java.util.List;

public class BANDTO {
	private int ban_num;
	private String ban_name;
	private int ban_inone;
	private String ban_period;
	private String ban_teacher;
	private List<BANDTO> list;
	
	public BANDTO(){
	}
	
	public BANDTO(int ban_num, String ban_name, int ban_inone, String ban_period, String ban_teacher){
		super();
		this.ban_num = ban_num;
		this.ban_name = ban_name;
		this.ban_inone = ban_inone;
		this.ban_period = ban_period;
		this.ban_teacher = ban_teacher;
	}	

	
	public int getBan_num() {
		return ban_num;
	}

	public String getBan_name() {
		return ban_name;
	}

	public int getBan_inone() {
		return ban_inone;
	}

	public String getBan_period() {
		return ban_period;
	}

	public String getBan_teacher() {
		return ban_teacher;
	}

	public List<BANDTO> getList() {
		return list;
	}

	public void setBan_num(int ban_num) {
		this.ban_num = ban_num;
	}

	public void setBan_name(String ban_name) {
		this.ban_name = ban_name;
	}

	public void setBan_inone(int ban_inone) {
		this.ban_inone = ban_inone;
	}

	public void setBan_period(String ban_period) {
		this.ban_period = ban_period;
	}

	public void setBan_teacher(String ban_teacher) {
		this.ban_teacher = ban_teacher;
	}

	public void setList(List<BANDTO> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "BANDTO [ban_num=" + ban_num + ", ban_name=" + ban_name
				+ ", ban_inone=" + ban_inone + ", ban_period=" + ban_period
				+ ", ban_teacher=" + ban_teacher + "]";
	}
	

	
}