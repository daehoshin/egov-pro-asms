package asms.common.paging;

/**
 * @PackageName asms.common.paging
 * @FileName PagingVO.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 3. 13.
 */
public class PagingVO {

    private String searchCondition = "";	// 검색조건
    private String searchKeyword = "";		// 검색Keyword
    private int pageIndex = 1;				// 현재페이지
    private int pageUnit = 10;				// 페이지갯수
    private int pageSize = 10;				// 페이지사이즈
    private int firstIndex = 1;				// firstIndex
    private int lastIndex = 1;				// lastIndex
    private int recordCountPerPage = 10;	// recordCountPerPage
    private String orderColumn = "";		// 정렬할 컬럼
    private String orderType = "";			// 정렬할 컬럼 차수(내림차수 or 오름차수)
    private String sessionUserId;			// 사용자ID
    private String sessionUserDiv;			// 사용자구분
    private String sessionOrgCd;			// 부서코드
    private String sessionViewLevel;		// 조회권한
    
	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
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
	public String getSessionUserId() {
		return sessionUserId;
	}
	public void setSessionUserId(String sessionUserId) {
		this.sessionUserId = sessionUserId;
	}
	public String getSessionUserDiv() {
		return sessionUserDiv;
	}
	public void setSessionUserDiv(String sessionUserDiv) {
		this.sessionUserDiv = sessionUserDiv;
	}
	public String getSessionOrgCd() {
		return sessionOrgCd;
	}
	public void setSessionOrgCd(String sessionOrgCd) {
		this.sessionOrgCd = sessionOrgCd;
	}
	public String getSessionViewLevel() {
		return sessionViewLevel;
	}
	public void setSessionViewLevel(String sessionViewLevel) {
		this.sessionViewLevel = sessionViewLevel;
	}
    
}
