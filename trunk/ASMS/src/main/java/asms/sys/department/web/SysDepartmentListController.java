package asms.sys.department.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import asms.common.Constants;
import asms.common.login.service.LoginUserVO;
import asms.sys.department.service.DeptService;
import asms.sys.department.service.DeptVO;

/**
 * @PackageName asms.sys.department.web
 * @FileName SysDepartmentListController.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 5.
 */
@Controller
public class SysDepartmentListController {
	
	@Resource(name = "DeptService")
    protected DeptService deptService;
    
	/** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    
	@RequestMapping("/sys/department/departmentListSearch.do")
	public String SysDepartmentList(@ModelAttribute("DeptVO")DeptVO deptVO, HttpSession session, Model map) throws Exception{
		
		// 사용자 권한
		LoginUserVO loginUserVO = (LoginUserVO)session.getAttribute(Constants.LoginUserVO);
		deptVO.setUser_auth_cd(loginUserVO.getUser_auth_cd());
		
		// 기본 orderBy 절을 정의함
		deptVO.setOrderColumn(!deptVO.getOrderColumn().equals("") ? deptVO.getOrderColumn() : "DEPT_ID");
		deptVO.setOrderType(!deptVO.getOrderType().equals("") ? deptVO.getOrderType() : "DESC");
	    
		// 최소페이징 목록 갯수는 context-properties.xml 에 정의된  개수이며, 사용자가 선택한 목록갯수가 0를 초과할 경우 사용자목록 갯수로 select한다.
		deptVO.setPageUnit(deptVO.getPageUnit() >= 0 ? deptVO.getPageUnit() : propertiesService.getInt("pageUnit") );
		deptVO.setPageSize(propertiesService.getInt("pageSize"));
		
		// pageing setting
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(deptVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(deptVO.getPageUnit());
		paginationInfo.setPageSize(deptVO.getPageSize());
		
		deptVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		deptVO.setLastIndex(paginationInfo.getLastRecordIndex());
		deptVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		List SysDeptList = deptService.deptListSearch(deptVO);
		int totCnt = deptService.deptListTotCntSearch(deptVO);
		
		paginationInfo.setTotalRecordCount(totCnt);
		
		map.addAttribute("deptVO", deptVO);
		map.addAttribute("SysDeptList", SysDeptList);
		map.addAttribute("paginationInfo", paginationInfo);
				
		return "/sys/department/departmentList";
	}
}
