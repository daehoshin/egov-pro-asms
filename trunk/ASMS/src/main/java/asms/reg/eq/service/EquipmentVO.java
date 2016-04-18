package asms.reg.eq.service;

import asms.common.paging.PagingVO;

/**
 * @PackageName asms.reg.eq.service
 * @FileName EquipmentVO.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 18.
 */
public class EquipmentVO extends PagingVO{
	
	private String eqm_id;				// 장비id
	private String eqm_id_array[];		// 장비id배열
	private String eqm_mng_no;			// 장비관리no
	private String plc_id;				// 장소id
	private String cate_id;				// 카테고리id
	private String dept_id;				// 관리부서id
	private String confirmor_m_id;		// 책임자(정) ID
	private String confirmor_s_id;		// 책임자(부) ID
	private String reg_status;			// 등록구분
	private String reg_status_cm;		// 등록구분코드명
	private String del_rsn;				// 삭제사유
	private String reg_id;				// 등록자id
	private String reg_nm;				// 등록자명
	private String reg_dt;				// 등록일자
	private String sys_id;				// 최종작업자id
	private String sys_nm;				// 최종작업자명
	private String sys_dt;				// 최종작업자일시
	private String st_id;				// 제조사id
	private String eqm_nm;				// 장비명
	private String use_flag;			// 사용여부
	private String use_flag_cm;			// 사용여부코드명
	private String eqm_state_cd;		// 장비상태
	private String eqm_state_cd_cm;		// 장비상태코드명
	private String eqm_sn;				// s/n
	private String buy_dt;				// 구입년월일
	private String guarantee_cd;		// 보증서유무
	private String guarantee_cd_cm;		// 보증서유무코드명
	private String guarantee_dt;		// 보증기간
	private String eqm_size;			// 크기
	private String eqm_size_cm;			// 크기코드명
	private String eqm_weight;			// 무게
	private String eqm_weight_cm;		// 무게코드명
	private String quality;				// 재질
	private String quality_cm;			// 재질코드명
	private String hnd_type;			// 취급유형
	private String hnd_type_cm;			// 취급유형코드명
	
	public String getEqm_id() {
		return eqm_id;
	}
	public void setEqm_id(String eqm_id) {
		this.eqm_id = eqm_id;
	}
	public String[] getEqm_id_array() {
		return eqm_id_array;
	}
	public void setEqm_id_array(String[] eqm_id_array) {
		this.eqm_id_array = eqm_id_array;
	}
	public String getEqm_mng_no() {
		return eqm_mng_no;
	}
	public void setEqm_mng_no(String eqm_mng_no) {
		this.eqm_mng_no = eqm_mng_no;
	}
	public String getPlc_id() {
		return plc_id;
	}
	public void setPlc_id(String plc_id) {
		this.plc_id = plc_id;
	}
	public String getCate_id() {
		return cate_id;
	}
	public void setCate_id(String cate_id) {
		this.cate_id = cate_id;
	}
	public String getDept_id() {
		return dept_id;
	}
	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}
	public String getConfirmor_m_id() {
		return confirmor_m_id;
	}
	public void setConfirmor_m_id(String confirmor_m_id) {
		this.confirmor_m_id = confirmor_m_id;
	}
	public String getConfirmor_s_id() {
		return confirmor_s_id;
	}
	public void setConfirmor_s_id(String confirmor_s_id) {
		this.confirmor_s_id = confirmor_s_id;
	}
	public String getReg_status() {
		return reg_status;
	}
	public void setReg_status(String reg_status) {
		this.reg_status = reg_status;
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
	public String getSt_id() {
		return st_id;
	}
	public void setSt_id(String st_id) {
		this.st_id = st_id;
	}
	public String getEqm_nm() {
		return eqm_nm;
	}
	public void setEqm_nm(String eqm_nm) {
		this.eqm_nm = eqm_nm;
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
	public String getEqm_state_cd() {
		return eqm_state_cd;
	}
	public void setEqm_state_cd(String eqm_state_cd) {
		this.eqm_state_cd = eqm_state_cd;
	}
	public String getEqm_state_cd_cm() {
		return eqm_state_cd_cm;
	}
	public void setEqm_state_cd_cm(String eqm_state_cd_cm) {
		this.eqm_state_cd_cm = eqm_state_cd_cm;
	}
	public String getEqm_sn() {
		return eqm_sn;
	}
	public void setEqm_sn(String eqm_sn) {
		this.eqm_sn = eqm_sn;
	}
	public String getBuy_dt() {
		return buy_dt;
	}
	public void setBuy_dt(String buy_dt) {
		this.buy_dt = buy_dt;
	}
	public String getGuarantee_cd() {
		return guarantee_cd;
	}
	public void setGuarantee_cd(String guarantee_cd) {
		this.guarantee_cd = guarantee_cd;
	}
	public String getGuarantee_cd_cm() {
		return guarantee_cd_cm;
	}
	public void setGuarantee_cd_cm(String guarantee_cd_cm) {
		this.guarantee_cd_cm = guarantee_cd_cm;
	}
	public String getGuarantee_dt() {
		return guarantee_dt;
	}
	public void setGuarantee_dt(String guarantee_dt) {
		this.guarantee_dt = guarantee_dt;
	}
	public String getEqm_size() {
		return eqm_size;
	}
	public void setEqm_size(String eqm_size) {
		this.eqm_size = eqm_size;
	}
	public String getEqm_size_cm() {
		return eqm_size_cm;
	}
	public void setEqm_size_cm(String eqm_size_cm) {
		this.eqm_size_cm = eqm_size_cm;
	}
	public String getEqm_weight() {
		return eqm_weight;
	}
	public void setEqm_weight(String eqm_weight) {
		this.eqm_weight = eqm_weight;
	}
	public String getEqm_weight_cm() {
		return eqm_weight_cm;
	}
	public void setEqm_weight_cm(String eqm_weight_cm) {
		this.eqm_weight_cm = eqm_weight_cm;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public String getQuality_cm() {
		return quality_cm;
	}
	public void setQuality_cm(String quality_cm) {
		this.quality_cm = quality_cm;
	}
	public String getHnd_type() {
		return hnd_type;
	}
	public void setHnd_type(String hnd_type) {
		this.hnd_type = hnd_type;
	}
	public String getHnd_type_cm() {
		return hnd_type_cm;
	}
	public void setHnd_type_cm(String hnd_type_cm) {
		this.hnd_type_cm = hnd_type_cm;
	}
	
}
