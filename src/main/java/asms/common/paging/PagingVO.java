package asms.common.paging;

/**
 * @PackageName asms.common.paging
 * @FileName PagingVO.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 3. 13.
 */
public class PagingVO {

    private int pageIndex = 1;				// 현재페이지
    private int pageUnit = 10;				// 페이지갯수
    private int pageSize = 10;				// 페이지사이즈
    private int firstIndex = 1;			// firstIndex
    private int lastIndex = 1;				// lastIndex
    private int recordCountPerPage = 10;	// recordCountPerPage
    private String orderColumn = "";		// 정렬할 컬럼
    private String orderType = "";			// 정렬할 컬럼 차수(내림차수 or 오름차수)
    private String user_auth_cd;			// 사용자권한
    
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageUnit() {
		return pageUnit;
	}
	public void setPageUnit(int pageUnit) {
		this.pageUnit = pageUnit;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getFirstIndex() {
		return firstIndex;
	}
	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}
	public int getLastIndex() {
		return lastIndex;
	}
	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}
	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}
	public void setRecordCountPerPage(int recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
	}
	public String getOrderColumn() {
		return orderColumn;
	}
	public void setOrderColumn(String orderColumn) {
		this.orderColumn = orderColumn;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getUser_auth_cd() {
		return user_auth_cd;
	}
	public void setUser_auth_cd(String user_auth_cd) {
		this.user_auth_cd = user_auth_cd;
	}
	
}
