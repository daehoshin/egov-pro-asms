package asms.test.cjh.service;

import asms.common.paging.PagingVO;

/**
 * @PackageName asms.reg.plc.service
 * @FileName PlaceVO.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 3. 26.
 */
public class TestVO extends PagingVO{
	
	private String code_cd;			// 장소ID
	private String code_nm;	// 장소ID 배열
	
	public String getCode_cd() {
		return code_cd;
	}
	public void setCode_cd(String code_cd) {
		this.code_cd = code_cd;
	}
	public String getCode_nm() {
		return code_nm;
	}
	public void setCode_nm(String code_nm) {
		this.code_nm = code_nm;
	}
	
	
}
