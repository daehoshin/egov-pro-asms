package asms.sys.code.service;

import asms.common.paging.PagingVO;

public class CodeVO extends PagingVO{
	
	private String code_id;				//	부서ID
	private String code_upper_id;		//	상위부서ID
	private String code_nm;				//	부서명
	private String code_cd;				//	부서코드
	private String code_level;			//	레벨
	private String code_sno;			//	순번
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
	
	public String getCode_id() {
		return code_id;
	}
	public void setCode_id(String code_id) {
		this.code_id = code_id;
	}
	public String getCode_upper_id() {
		return code_upper_id;
	}
	public void setCode_upper_id(String code_upper_id) {
		this.code_upper_id = code_upper_id;
	}
	public String getCode_nm() {
		return code_nm;
	}
	public void setCode_nm(String code_nm) {
		this.code_nm = code_nm;
	}
	public String getCode_cd() {
		return code_cd;
	}
	public void setCode_cd(String code_cd) {
		this.code_cd = code_cd;
	}
	public String getCode_level() {
		return code_level;
	}
	public void setCode_level(String code_level) {
		this.code_level = code_level;
	}
	public String getCode_sno() {
		return code_sno;
	}
	public void setCode_sno(String code_sno) {
		this.code_sno = code_sno;
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
	
}
