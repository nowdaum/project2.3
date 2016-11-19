package SSH.DTO;

public class FINDHEWONDTO {
	private int ban_num;
	private int mem_num;
	private String mem_name;
	private String mem_ph;
	
	public FINDHEWONDTO(int ban_num, int mem_num, String mem_name, String mem_ph){
		this.ban_num = ban_num;
		this.mem_num = mem_num;
		this.mem_name = mem_name;
		this.mem_ph = mem_ph;
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

	public String getMem_ph() {
		return mem_ph;
	}

	public void setMem_ph(String mem_ph) {
		this.mem_ph = mem_ph;
	}
}