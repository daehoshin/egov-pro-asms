package asms.sign.export.service;

import asms.common.paging.PagingVO;

public class ExportEquipmentVO extends PagingVO{
	private String app_id;         //신청서ID
	private String eqm_id;         //장비ID
	private String export_cd;      //반출상태
	private String export_rsn;     //반출상태 사유
	private String export_dt;      //반출일
	private String return_due_dt;  //반납예정일
	
	public String getApp_id() {
		return app_id;
	}
	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}
	public String getEqm_id() {
		return eqm_id;
	}
	public void setEqm_id(String eqm_id) {
		this.eqm_id = eqm_id;
	}
	public String getExport_cd() {
		return export_cd;
	}
	public void setExport_cd(String export_cd) {
		this.export_cd = export_cd;
	}
	public String getExport_rsn() {
		return export_rsn;
	}
	public void setExport_rsn(String export_rsn) {
		this.export_rsn = export_rsn;
	}
	public String getExport_dt() {
		return export_dt;
	}
	public void setExport_dt(String export_dt) {
		this.export_dt = export_dt;
	}
	public String getReturn_due_dt() {
		return return_due_dt;
	}
	public void setReturn_due_dt(String return_due_dt) {
		this.return_due_dt = return_due_dt;
	}
	

}
