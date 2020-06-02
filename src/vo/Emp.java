package vo;

import java.util.HashSet;
import java.util.Set;

public class Emp {
	private int eid;
	private String ename;
	private String sex;
	private String hire,hire2;
	private float sar;
	private int did;
	private Dept dept;
	
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getHire() {
		return hire;
	}
	public void setHire(String hire) {
		this.hire = hire;
	}
	public float getSar() {
		return sar;
	}
	public void setSar(float sar) {
		this.sar = sar;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getHire2() {
		return hire2;
	}
	public void setHire2(String hire2) {
		this.hire2 = hire2;
	}
	
	
}
