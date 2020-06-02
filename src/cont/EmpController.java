package cont;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import vo.Emp;
import vo.History;
import dao.EmpDao;

public class EmpController extends AbstractController {
	private EmpDao dao;
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req,HttpServletResponse res) throws Exception {
		ModelAndView mav=null;
		String cmd=req.getParameter("cmd");
		if(cmd.equals("allEmp"))mav=allEmp(req,res);
		else if(cmd.equals("beforeAddEmp"))mav=beforeAddEmp(req,res);
		else if(cmd.equals("findEmp"))mav=findEmp(req,res);
		else if(cmd.equals("beforeUpdate"))mav=beforeUpdate(req,res);
		else if(cmd.equals("addEmp"))addEmp(req,res);
		else if(cmd.equals("delEmp"))delEmp(req,res);
		else if(cmd.equals("updateEmp"))updateEmp(req,res);
		return mav;
	}
	//�޸�Ա��
	protected void updateEmp(HttpServletRequest req,HttpServletResponse res) throws Exception {
		int eid=Integer.parseInt(req.getParameter("eid"));//ȡ��ҳ�����ص�Ա������
		String ename=req.getParameter("ename");
		String sex=req.getParameter("sex");
		String hire=req.getParameter("hire");
		float sar=Float.parseFloat(req.getParameter("sar"));
		int did=Integer.parseInt(req.getParameter("did"));
		Emp emp=new Emp();
		emp.setEid(eid);
		emp.setEname(ename);
		emp.setSex(sex);
		emp.setHire(hire);
		emp.setSar(sar);
		emp.setDid(did);
		dao.update("ve.updateemp",emp);
		
//		dao.delete("ve.delhistbyeid", eid);//ɾ����Ա�������й�������
//		String[] a=req.getParameterValues("a");
//		String[] b=req.getParameterValues("b");
//		String[] c=req.getParameterValues("c");
//		String[] d=req.getParameterValues("d");
//		for(int i=1;i<a.length;i++){
//			History his=new History();
//			his.setStartdate(a[i]);
//			his.setEnddate(b[i]);
//			his.setPlace(c[i]);
//			his.setJob(d[i]);
//			his.setEid(eid);
//			dao.save("ve.addhistory",his);
//		}
		
		
		
		List<History> hists=dao.all("ve.findhistbyeid",eid);//���ݿ��и�Ա�������й�������
		
		String[] hid=req.getParameterValues("hid");//ȡ��ҳ�������صĹ�����������
		String[] a=req.getParameterValues("a");
		String[] b=req.getParameterValues("b");
		String[] c=req.getParameterValues("c");
		String[] d=req.getParameterValues("d");
		for(int i=1;i<a.length;i++){
			History his=new History();
			his.setHid(Integer.parseInt(hid[i]));
			his.setStartdate(a[i]);
			his.setEnddate(b[i]);
			his.setPlace(c[i]);
			his.setJob(d[i]);
			his.setEid(eid);
			
			for(History h:hists){
				if(his.getHid()==h.getHid()){
					dao.update("ve.updatehist", his);
					break;
				} else if(his.getHid()==0){
					dao.save("ve.addhistory",his);
					break;
				}
			}
		}
		
		for(History h:hists){
			int sign=0;
			for(int i=0;i<hid.length;i++){
				if(h.getHid()==Integer.parseInt(hid[i])){
					sign=1;
					break;
				}
			}
			if(sign==0)dao.delete("ve.delhistbyhid",h.getHid());
		}
		
		res.sendRedirect("emp.sw?cmd=allEmp");
	}
	//�޸�ǰ�Ĳ�ѯ
	protected ModelAndView beforeUpdate(HttpServletRequest req,HttpServletResponse res) throws Exception {
		int eid=Integer.parseInt(req.getParameter("eid"));
		Emp emp=(Emp)dao.findById("ve.findempbyeid",eid);//���޸ĵ�Ա������
		req.setAttribute("emp", emp);
		List hists=dao.all("ve.findhistbyeid",eid);//Ա�������й�������
		req.setAttribute("hists",hists);
		List depts=dao.all("vd.alldept",null);//��ѯ���в��ţ������޸�Ա��ʱ������
		req.setAttribute("depts", depts);
		
		return new ModelAndView("updateemp");
	}
	//�������������ģ����ѯ
	protected ModelAndView findEmp(HttpServletRequest req,HttpServletResponse res) throws Exception {
		String ename=req.getParameter("ename");
		String sex=req.getParameter("sex");
		String hire=req.getParameter("hire");
		String hire2=req.getParameter("hire2");
		int did=Integer.parseInt(req.getParameter("did"));
		Emp emp=new Emp();
		emp.setEname(ename);
		emp.setSex(sex);
		emp.setHire(hire);
		emp.setHire2(hire2);
		emp.setDid(did);
		
		List emps=dao.all("ve.findemp",emp);
		List depts=dao.all("vd.alldept",null);
		req.setAttribute("emps",emps);
		req.setAttribute("depts", depts);
		return new ModelAndView("allemp");
	}
	//ɾ��Ա��
	protected void delEmp(HttpServletRequest req,HttpServletResponse res) throws Exception {
		int eid=Integer.parseInt(req.getParameter("eid"));
		dao.delete("ve.delhistbyeid",eid);//��ɾ����������
		dao.delete("ve.delemp",eid);
		res.sendRedirect("emp.sw?cmd=allEmp");
	}
	//���Ա��
	protected void addEmp(HttpServletRequest req,HttpServletResponse res) throws Exception {
		String ename=req.getParameter("ename");
		String sex=req.getParameter("sex");
		String hire=req.getParameter("hire");
		float sar=Float.parseFloat(req.getParameter("sar"));
		int did=Integer.parseInt(req.getParameter("did"));
		Emp emp=new Emp();
		emp.setEname(ename);
		emp.setSex(sex);
		emp.setHire(hire);
		emp.setSar(sar);
		emp.setDid(did);
		dao.save("ve.addemp",emp);
		System.out.println("��Ա����ID��"+emp.getEid());
		String[] a=req.getParameterValues("a");
		String[] b=req.getParameterValues("b");
		String[] c=req.getParameterValues("c");
		String[] d=req.getParameterValues("d");
		for(int i=1;i<a.length;i++){
			History his=new History();
			his.setStartdate(a[i]);
			his.setEnddate(b[i]);
			his.setPlace(c[i]);
			his.setJob(d[i]);
			his.setEid(emp.getEid());
			dao.save("ve.addhistory",his);
		}
		res.sendRedirect("emp.sw?cmd=allEmp");
	}
	//���ǰ
	protected ModelAndView beforeAddEmp(HttpServletRequest req,HttpServletResponse res) throws Exception {
		List depts=dao.all("vd.alldept",null);
		req.setAttribute("depts", depts);
		return new ModelAndView("addemp");
	}
	//Ա���б�
	protected ModelAndView allEmp(HttpServletRequest req,HttpServletResponse res) throws Exception {
		List emps=dao.all("ve.allemp",null);
		List depts=dao.all("vd.alldept",null);
		req.setAttribute("emps",emps);
		req.setAttribute("depts", depts);
		return new ModelAndView("allemp");
	}
	//===========================================
	public EmpDao getDao() {
		return dao;
	}
	public void setDao(EmpDao dao) {
		this.dao = dao;
	}

}
