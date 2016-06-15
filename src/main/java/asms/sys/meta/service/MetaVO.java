package asms.sys.meta.service;

import asms.common.paging.PagingVO;

public class MetaVO extends PagingVO{
	
	private String meta_id;				//	부서ID
	private String meta_upper_id;		//	상위부서ID
	private String meta_nm;				//	부서명
	private String meta_cd;				//	부서코드
	private String meta_level;			//	레벨
	private String meta_sno;			//	순번
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
	
	public String getMeta_id() {
		return meta_id;
	}
	public void setMeta_id(String meta_id) {
		this.meta_id = meta_id;
	}
	public String getMeta_upper_id() {
		return meta_upper_id;
	}
	public void setMeta_upper_id(String meta_upper_id) {
		this.meta_upper_id = meta_upper_id;
	}
	public String getMeta_nm() {
		return meta_nm;
	}
	public void setMeta_nm(String meta_nm) {
		this.meta_nm = meta_nm;
	}
	public String getMeta_cd() {
		return meta_cd;
	}
	public void setMeta_cd(String meta_cd) {
		this.meta_cd = meta_cd;
	}
	public String getMeta_level() {
		return meta_level;
	}
	public void setMeta_level(String meta_level) {
		this.meta_level = meta_level;
	}
	public String getMeta_sno() {
		return meta_sno;
	}
	public void setMeta_sno(String meta_sno) {
		this.meta_sno = meta_sno;
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
