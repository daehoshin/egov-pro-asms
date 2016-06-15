package asms.sys.history.service;

import asms.common.paging.PagingVO;

public class HistoryVO extends PagingVO{
	
	private String history_id;				//	부서ID
	private String history_upper_id;		//	상위부서ID
	private String history_nm;				//	부서명
	private String history_cd;				//	부서코드
	private String history_level;			//	레벨
	private String history_sno;			//	순번
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
	
	public String getHistory_id() {
		return history_id;
	}
	public void setHistory_id(String history_id) {
		this.history_id = history_id;
	}
	public String getHistory_upper_id() {
		return history_upper_id;
	}
	public void setHistory_upper_id(String history_upper_id) {
		this.history_upper_id = history_upper_id;
	}
	public String getHistory_nm() {
		return history_nm;
	}
	public void setHistory_nm(String history_nm) {
		this.history_nm = history_nm;
	}
	public String getHistory_cd() {
		return history_cd;
	}
	public void setHistory_cd(String history_cd) {
		this.history_cd = history_cd;
	}
	public String getHistory_level() {
		return history_level;
	}
	public void setHistory_level(String history_level) {
		this.history_level = history_level;
	}
	public String getHistory_sno() {
		return history_sno;
	}
	public void setHistory_sno(String history_sno) {
		this.history_sno = history_sno;
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
