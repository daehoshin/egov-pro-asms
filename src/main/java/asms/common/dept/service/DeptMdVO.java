package asms.common.dept.service;

import asms.common.paging.PagingVO;

/**
 * @PackageName asms.common.dept.service
 * @FileName DeptMdVO.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 5.
 */
public class DeptMdVO extends PagingVO{

	private String dept_id;				//	부서ID
	private String dept_upper_id;		//	상위부서ID
	private String dept_nm;				//	부서명
	private String dept_cd;				//	부서코드
	private String dept_level;			//	레벨
	private String dept_sno;			//	순번
	private String start_dt;			//	시작일자
	private String endt_dt;				//	종료일자
	private String use_flag;			//	사용여부
	private String use_flag_cm;			//	사용여부코드명
	private String reg_id;				//	등록자ID
	private String reg_nm;				//	등록자명
	private String reg_dt;				//	등록일자
	private String sys_id;				//	최종작업자ID
	private String sys_nm;				//	최종작업자명
	private String sys_dt;				//	최종작업일시
	private String targetForm;			//	전달할Form
	private String targetId;			//	전달할곳ID
	private String targetNm;			//	전달할곳Nm
	
	public String getDept_id() {
		return dept_id;
	}
	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}
	public String getDept_upper_id() {
		return dept_upper_id;
	}
	public void setDept_upper_id(String dept_upper_id) {
		this.dept_upper_id = dept_upper_id;
	}
	public String getDept_nm() {
		return dept_nm;
	}
	public void setDept_nm(String dept_nm) {
		this.dept_nm = dept_nm;
	}
	public String getDept_cd() {
		return dept_cd;
	}
	public void setDept_cd(String dept_cd) {
		this.dept_cd = dept_cd;
	}
	public String getDept_level() {
		return dept_level;
	}
	public void setDept_level(String dept_level) {
		this.dept_level = dept_level;
	}
	public String getDept_sno() {
		return dept_sno;
	}
	public void setDept_sno(String dept_sno) {
		this.dept_sno = dept_sno;
	}
	public String getStart_dt() {
		return start_dt;
	}
	public void setStart_dt(String start_dt) {
		this.start_dt = start_dt;
	}
	public String getEndt_dt() {
		return endt_dt;
	}
	public void setEndt_dt(String endt_dt) {
		this.endt_dt = endt_dt;
	}
	public String getUse_flag() {
		return use_flag;
	}
	public void setUse_flag(String use_flag) {
		this.use_flag = use_flag;
	}
	public String getUse_flag_cm() {
		return use_flag_cm;
	}
	public void setUse_flag_cm(String use_flag_cm) {
		this.use_flag_cm = use_flag_cm;
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
