package asms.common.dept.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import asms.common.Constants;
import asms.common.dept.service.DeptMdService;
import asms.common.dept.service.DeptMdVO;
import asms.common.login.service.LoginUserVO;

/**
 * @PackageName asms.common.dept.web
 * @FileName deptMdSearchListController.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 5.
 */
@Controller
public class deptMdSearchListController {
	
	@Resource(name = "DeptMdService")
    protected DeptMdService deptMdService;
	
	/** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
	@RequestMapping("/common/dept/deptMdSearchList.do")
	public String deptMdSearchList(@ModelAttribute("DeptMdVO")DeptMdVO deptMdVO, ModelMap map, HttpSession session) throws Exception{
		
		// 사용자 권한
		LoginUserVO loginUserVO = (LoginUserVO)session.getAttribute(Constants.LoginUserVO);
		deptMdVO.setUser_auth_cd(loginUserVO.getUser_auth_cd());
		
		// 기본 orderBy 절을 정의함
		deptMdVO.setOrderColumn(!deptMdVO.getOrderColumn().equals("") ? deptMdVO.getOrderColumn() : "DEPT_ID");
		deptMdVO.setOrderType(!deptMdVO.getOrderType().equals("") ? deptMdVO.getOrderType() : "DESC");
	    
		// 최소페이징 목록 갯수는 context-properties.xml 에 정의된  개수이며, 사용자가 선택한 목록갯수가 0를 초과할 경우 사용자목록 갯수로 select한다.
		deptMdVO.setPageUnit(deptMdVO.getPageUnit() >= 0 ? deptMdVO.getPageUnit() : propertiesService.getInt("pageUnit") );
		deptMdVO.setPageSize(propertiesService.getInt("pageSize"));
		
		// pageing setting
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(deptMdVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(deptMdVO.getPageUnit());
		paginationInfo.setPageSize(deptMdVO.getPageSize());
		
		deptMdVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		deptMdVO.setLastIndex(paginationInfo.getLastRecordIndex());
		deptMdVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		List deptMdList = deptMdService.deptMdListSearch(deptMdVO);
		int totCnt = deptMdService.deptMdListTotCntSearch(deptMdVO);
		
		paginationInfo.setTotalRecordCount(totCnt);
		
		map.addAttribute("deptMdVO", deptMdVO);
		map.addAttribute("deptMdList", deptMdList);
		map.addAttribute("paginationInfo", paginationInfo);
		
		return "/common/dept/deptMdSearchList";
	}
}
