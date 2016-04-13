package asms.sys.menu.service;

import asms.common.paging.PagingVO;

/**
 * @PackageName asms.sys.menu.service
 * @FileName MenuVO.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 13.
 */
public class MenuVO extends PagingVO{
	
	private String menu_id;			// 메뉴 ID
	private String menu_nm;			// 메뉴 이름
	private String menu_upper_id;	// 상위메뉴 ID
	private String menu_div_cd;		// 메뉴구분코드
	private String menu_sno;		// 메뉴정렬순서
	private String use_flag;		// 사용여부
	private String use_flag_cm;		// 사용여부 코드명
	private String menu_icon;		// 메뉴 ICON
	private String menu_conn_url;	// 메뉴접속URL
	private String menu_grp_id;		// 메뉴권한ID
	private String menu_grp_nm;		// 메뉴권한이름

	public String getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}
	public String getMenu_nm() {
		return menu_nm;
	}
	public void setMenu_nm(String menu_nm) {
		this.menu_nm = menu_nm;
	}
	public String getMenu_upper_id() {
		return menu_upper_id;
	}
	public void setMenu_upper_id(String menu_upper_id) {
		this.menu_upper_id = menu_upper_id;
	}
	public String getMenu_div_cd() {
		return menu_div_cd;
	}
	public void setMenu_div_cd(String menu_div_cd) {
		this.menu_div_cd = menu_div_cd;
	}
	public String getMenu_sno() {
		return menu_sno;
	}
	public void setMenu_sno(String menu_sno) {
		this.menu_sno = menu_sno;
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
	public String getMenu_icon() {
		return menu_icon;
	}
	public void setMenu_icon(String menu_icon) {
		this.menu_icon = menu_icon;
	}
	public String getMenu_conn_url() {
		return menu_conn_url;
	}
	public void setMenu_conn_url(String menu_conn_url) {
		this.menu_conn_url = menu_conn_url;
	}
	public String getMenu_grp_id() {
		return menu_grp_id;
	}
	public void setMenu_grp_id(String menu_grp_id) {
		this.menu_grp_id = menu_grp_id;
	}
	public String getMenu_grp_nm() {
		return menu_grp_nm;
	}
	public void setMenu_grp_nm(String menu_grp_nm) {
		this.menu_grp_nm = menu_grp_nm;
	}
	
}
