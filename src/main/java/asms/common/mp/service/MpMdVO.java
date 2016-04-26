package asms.common.mp.service;

import asms.common.paging.PagingVO;

/**
 * @PackageName asms.common.dept.service
 * @FileName DeptMdVO.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 26.
 */
public class MpMdVO extends PagingVO{

		private String mp_id;			// 인력ID
		private String mp_mng_no;		// 인련관리NO
		private String user_auth_cd;	// 사용자권한
		private String menu_grp_id;		// 메뉴그룹ID
		private String use_flag;			// 사용여부
		private String use_flag_cm;		// 사용여부코드명
		private String enabled;			// 접속허가
		private String authority;		// 접속권한
		private String reg_id;			// 등록자ID
		private String reg_nm;			// 등록자명
		private String reg_dt;			// 등록일자
		private String sys_id;			// 최종작업자ID
		private String sys_nm;			// 최종작업자명
		private String sys_dt;			// 최종작업일자
		private String mp_nm;			// 인력명
		private String mp_cd;			// 인력CD
		private String mp_cd_cm;		// 인력CD코드명
		private String login_user_id;	// 로그인아이디
		private String user_pwd;		// 비밀번호
		private String join_dt;			// 입사일
		private String retire_dt;		// 퇴사일
		private String dept_nm;			// 부서명
		private String position;		// 직급
		private String emp_cd;			// 근무유형
		private String emp_cd_cm;		// 근무유형코드명
		private String join_cd;			// 재직유무
		private String join_cd_cm;		// 재직유무코드명
		private String birth_dt;		// 생년월일
		private String addr;			// 주소
		private String addr_detail;		// 상세주소
		private String full_addr;		// full 주소
		private String email;			// 이메일
		private String tel_no;			// 전화번호
		private String targetForm;		//	전달할Form
		private String targetId;		//	전달할곳ID
		private String targetNm;		//	전달할곳Nm
		
		public String getMp_id() {
			return mp_id;
		}
		public void setMp_id(String mp_id) {
			this.mp_id = mp_id;
		}
		public String getMp_mng_no() {
			return mp_mng_no;
		}
		public void setMp_mng_no(String mp_mng_no) {
			this.mp_mng_no = mp_mng_no;
		}
		public String getUser_auth_cd() {
			return user_auth_cd;
		}
		public void setUser_auth_cd(String user_auth_cd) {
			this.user_auth_cd = user_auth_cd;
		}
		public String getMenu_grp_id() {
			return menu_grp_id;
		}
		public void setMenu_grp_id(String menu_grp_id) {
			this.menu_grp_id = menu_grp_id;
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
		public String getEnabled() {
			return enabled;
		}
		public void setEnabled(String enabled) {
			this.enabled = enabled;
		}
		public String getAuthority() {
			return authority;
		}
		public void setAuthority(String authority) {
			this.authority = authority;
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
		public String getMp_nm() {
			return mp_nm;
		}
		public void setMp_nm(String mp_nm) {
			this.mp_nm = mp_nm;
		}
		public String getMp_cd() {
			return mp_cd;
		}
		public void setMp_cd(String mp_cd) {
			this.mp_cd = mp_cd;
		}
		public String getMp_cd_cm() {
			return mp_cd_cm;
		}
		public void setMp_cd_cm(String mp_cd_cm) {
			this.mp_cd_cm = mp_cd_cm;
		}
		public String getLogin_user_id() {
			return login_user_id;
		}
		public void setLogin_user_id(String login_user_id) {
			this.login_user_id = login_user_id;
		}
		public String getUser_pwd() {
			return user_pwd;
		}
		public void setUser_pwd(String user_pwd) {
			this.user_pwd = user_pwd;
		}
		public String getJoin_dt() {
			return join_dt;
		}
		public void setJoin_dt(String join_dt) {
			this.join_dt = join_dt;
		}
		public String getRetire_dt() {
			return retire_dt;
		}
		public void setRetire_dt(String retire_dt) {
			this.retire_dt = retire_dt;
		}
		public String getDept_nm() {
			return dept_nm;
		}
		public void setDept_nm(String dept_nm) {
			this.dept_nm = dept_nm;
		}
		public String getPosition() {
			return position;
		}
		public void setPosition(String position) {
			this.position = position;
		}
		public String getEmp_cd() {
			return emp_cd;
		}
		public void setEmp_cd(String emp_cd) {
			this.emp_cd = emp_cd;
		}
		public String getEmp_cd_cm() {
			return emp_cd_cm;
		}
		public void setEmp_cd_cm(String emp_cd_cm) {
			this.emp_cd_cm = emp_cd_cm;
		}
		public String getJoin_cd() {
			return join_cd;
		}
		public void setJoin_cd(String join_cd) {
			this.join_cd = join_cd;
		}
		public String getJoin_cd_cm() {
			return join_cd_cm;
		}
		public void setJoin_cd_cm(String join_cd_cm) {
			this.join_cd_cm = join_cd_cm;
		}
		public String getBirth_dt() {
			return birth_dt;
		}
		public void setBirth_dt(String birth_dt) {
			this.birth_dt = birth_dt;
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
