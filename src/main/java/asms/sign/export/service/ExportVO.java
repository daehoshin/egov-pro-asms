package asms.sign.export.service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.commons.lang.StringUtils;

import asms.common.paging.PagingVO;

/**
 * @PackageName asms.sign.export.web
 * @FileName ExportVO.java
 * @Author Jinho Jung
 * @Since 2016. 4. 09.
 * 반출신청서 VO
 */
public class ExportVO extends PagingVO{
	private String app_id;       //신청서ID
	private String app_no;       //신청서관리NO
	private String app_nm;       //신청서명
	private String app_hm_id;    //신청인ID
	private String confirmor_id; //확인자ID
	private String app_cd;       //신청서상태
	private String app_cd_nm;       //신청서상태명
	private String app_dt;       //신청일자
	private String confirm_dt;   //처리일자
	private String reg_id;       //등록자ID
	private String reg_nm;       //등록자명
	private String reg_dt;       //등록일자
	private String sys_id;       //최종작업자ID
	private String sys_nm;       //최종작업자명
	private String sys_dt;       //최종작업일시
	
	public String getApp_id() {
		return app_id;
	}
	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}
	public String getApp_no() {
		return app_no;
	}
	public void setApp_no(String app_no) {
		this.app_no = app_no;
	}
	public String getApp_nm() {
		return app_nm;
	}
	public void setApp_nm(String app_nm) {
		this.app_nm = app_nm;
	}
	public String getApp_hm_id() {
		return app_hm_id;
	}
	public void setApp_hm_id(String app_hm_id) {
		this.app_hm_id = app_hm_id;
	}
	public String getConfirmor_id() {
		return confirmor_id;
	}
	public void setConfirmor_id(String confirmor_id) {
		this.confirmor_id = confirmor_id;
	}
	public String getApp_cd() {
		return app_cd;
	}
	public void setApp_cd(String app_cd) {
		this.app_cd = app_cd;
	}
	public String getApp_cd_nm() {
		return app_cd_nm;
	}
	public void setApp_cd_nm(String app_cd_nm) {
		this.app_cd_nm = app_cd_nm;
	}
	public String getApp_dt() {
		return app_dt;
	}
	public void setApp_dt(String app_dt) {
		this.app_dt = app_dt;
	}
	public String getConfirm_dt() {
		return confirm_dt;
	}
	public void setConfirm_dt(String confirm_dt) {
		this.confirm_dt = confirm_dt;
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
