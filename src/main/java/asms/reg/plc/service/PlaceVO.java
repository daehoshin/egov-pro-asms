package asms.reg.plc.service;

import asms.common.paging.PagingVO;

/**
 * @PackageName asms.reg.plc.service
 * @FileName PlaceVO.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 3. 26.
 */
public class PlaceVO extends PagingVO{
	
	private String plc_id;			// 장소ID
	private String plc_mng_no;		// 장소관리NO
	private String reg_status;		// 등록구분
	private String reg_status_cm;	// 등록구분코드값
	private String reg_id;			// 등록자ID
	private String reg_nm;			// 등록자명
	private String reg_dt;			// 등록일자
	private String sys_id;			// 최종작업자ID
	private String sys_nm;			// 최종작업자명
	private String sys_dt;			// 최종작업일시
	private String plc_nm;			// 장소명
	private String addr;			// 주소
	private String addr_detail;		// 상세주소
	private String full_addr;		// 주소+상세주소
	private String del_rsn;			// 삭제사유
	
	public String getPlc_id() {
		return plc_id;
	}
	public void setPlc_id(String plc_id) {
		this.plc_id = plc_id;
	}
	public String getPlc_mng_no() {
		return plc_mng_no;
	}
	public void setPlc_mng_no(String plc_mng_no) {
		this.plc_mng_no = plc_mng_no;
	}
	public String getReg_status() {
		return reg_status;
	}
	public void setReg_status(String reg_status) {
		this.reg_status = reg_status;
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
	public String getPlc_nm() {
		return plc_nm;
	}
	public void setPlc_nm(String plc_nm) {
		this.plc_nm = plc_nm;
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
	public String getReg_status_cm() {
		return reg_status_cm;
	}
	public void setReg_status_cm(String reg_status_cm) {
		this.reg_status_cm = reg_status_cm;
	}
	public String getDel_rsn() {
		return del_rsn;
	}
	public void setDel_rsn(String del_rsn) {
		this.del_rsn = del_rsn;
	}
	
}
