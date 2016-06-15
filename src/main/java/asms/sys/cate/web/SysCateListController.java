package asms.sys.cate.web;

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
import asms.sys.cate.service.CateService;
import asms.sys.cate.service.CateVO;

@Controller
public class SysCateListController {
	
	@Resource(name = "CateService")
    protected CateService cateService;
    
	/** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    
	@RequestMapping("/sys/cate/cateListSearch.do")
	public String SysCateList(@ModelAttribute("CateVO")CateVO cateVO, HttpSession session, Model map) throws Exception{
		
		// 사용자 권한
		LoginUserVO loginUserVO = (LoginUserVO)session.getAttribute(Constants.LoginUserVO);
		cateVO.setUser_auth_cd(loginUserVO.getUser_auth_cd());
		
		// 기본 orderBy 절을 정의함
		cateVO.setOrderColumn(!cateVO.getOrderColumn().equals("") ? cateVO.getOrderColumn() : "DEPT_ID");
		cateVO.setOrderType(!cateVO.getOrderType().equals("") ? cateVO.getOrderType() : "DESC");
	    
		// 최소페이징 목록 갯수는 context-properties.xml 에 정의된  개수이며, 사용자가 선택한 목록갯수가 0를 초과할 경우 사용자목록 갯수로 select한다.
		cateVO.setPageUnit(cateVO.getPageUnit() >= 0 ? cateVO.getPageUnit() : propertiesService.getInt("pageUnit") );
		cateVO.setPageSize(propertiesService.getInt("pageSize"));
		
		// pageing setting
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(cateVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(cateVO.getPageUnit());
		paginationInfo.setPageSize(cateVO.getPageSize());
		
		cateVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		cateVO.setLastIndex(paginationInfo.getLastRecordIndex());
		cateVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		List SysCateList = cateService.cateListSearch(cateVO);
		int totCnt = cateService.cateListTotCntSearch(cateVO);
		
		paginationInfo.setTotalRecordCount(totCnt);
		
		map.addAttribute("cateVO", cateVO);
		map.addAttribute("SysCateList", SysCateList);
		map.addAttribute("paginationInfo", paginationInfo);
				
		return "/sys/cate/cateList";
	}
}
