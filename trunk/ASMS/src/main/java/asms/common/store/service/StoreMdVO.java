package asms.common.store.service;

import asms.common.paging.PagingVO;

/**
 * @PackageName asms.common.dept.service
 * @FileName DeptMdVO.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 26.
 */
public class StoreMdVO extends PagingVO{

	private String st_id;			//	제조사ID
	private String st_nm;			//	제조사명
	private String dept_nm;			//	부서명
	private String confirmor_nm;	//	담당자명
	private String addr;			//	주소
	private String addr_detail;		//	상세주소
	private String full_addr;		//	full주소
	private String homepage;		//	홈페이지   
	private String email;			//	이메일    
	private String tel_no;			//	전화번호   
	private String reg_id;			//	등록자ID  
	private String reg_nm;			//	등록자명   
	private String reg_dt;			//	등록일자   
	private String sys_id;			//	최종작업자ID
	private String sys_nm;			//	최종작업자명 
	private String sys_dt;			//	최종작업일시 
	private String targetForm;		//	전달할Form
	private String targetId;		//	전달할곳ID
	private String targetNm;		//	전달할곳Nm
	
	public String getSt_id() {
		return st_id;
	}
	public void setSt_id(String st_id) {
		this.st_id = st_id;
	}
	public String getSt_nm() {
		return st_nm;
	}
	public void setSt_nm(String st_nm) {
		this.st_nm = st_nm;
	}
	public String getDept_nm() {
		return dept_nm;
	}
	public void setDept_nm(String dept_nm) {
		this.dept_nm = dept_nm;
	}
	public String getConfirmor_nm() {
		return confirmor_nm;
	}
	public void setConfirmor_nm(String confirmor_nm) {
		this.confirmor_nm = confirmor_nm;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getAddr_detail() {
		return addr_detail;
	}
	public void setAddr_detail(String addr_detail) {
		this.addr_detail = addr_detail;
	}
	public String getFull_addr() {
		return full_addr;
	}
	public void setFull_addr(String full_addr) {
		this.full_addr = full_addr;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel_no() {
		return tel_no;
	}
	public void setTel_no(String tel_no) {
		this.tel_no = tel_no;
	}
	public String getReg_id() {
		return reg_id;
	}
	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}
	public String getReg_nm() {
		return reg_nm;
	}
	public void setReg_nm(String reg_nm) {
		this.reg_nm = reg_nm;
	}
	public String getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}
	public String getSys_id() {
		return sys_id;
	}
	public void setSys_id(String sys_id) {
		this.sys_id = sys_id;
	}
	public String getSys_nm() {
		return sys_nm;
	}
	public void setSys_nm(String sys_nm) {
		this.sys_nm = sys_nm;
	}
	public String getSys_dt() {
		return sys_dt;
	}
	public void setSys_dt(String sys_dt) {
		this.sys_dt = sys_dt;
	}
	public String getTargetForm() {
		return targetForm;
	}
	public void setTargetForm(String targetForm) {
		this.targetForm = targetForm;
	}
	public String getTargetId() {
		return targetId;
	}
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
	public String getTargetNm() {
		return targetNm;
	}
	public void setTargetNm(String targetNm) {
		this.targetNm = targetNm;
	}
	
}
