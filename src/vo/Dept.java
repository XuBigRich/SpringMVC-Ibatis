package vo;

import java.util.HashSet;
import java.util.Set;

public class Dept {
	private int did;
	private String dname;
	private int man;
	private String tel;
	private int updept;
	private Set emps=new HashSet(0);
	
	public Set getEmps() {
		return emps;
	}
	public void setEmps(Set emps) {
		this.emps = emps;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public int getMan() {
		return man;
	}
	public void setMan(int man) {
		this.man = man;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getUpdept() {
		return updept;
	}
	public void setUpdept(int updept) {
		this.updept = updept;
	}
}
