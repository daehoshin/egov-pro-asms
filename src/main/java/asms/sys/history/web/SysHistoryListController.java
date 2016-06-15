package asms.sys.history.web;

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
import asms.sys.history.service.HistoryService;
import asms.sys.history.service.HistoryVO;

@Controller
public class SysHistoryListController {
	
	@Resource(name = "HistoryService")
    protected HistoryService historyService;
    
	/** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    
	@RequestMapping("/sys/history/historyListSearch.do")
	public String SysHistoryList(@ModelAttribute("HistoryVO")HistoryVO historyVO, HttpSession session, Model map) throws Exception{
		
		// 사용자 권한
		LoginUserVO loginUserVO = (LoginUserVO)session.getAttribute(Constants.LoginUserVO);
		historyVO.setUser_auth_cd(loginUserVO.getUser_auth_cd());
		
		// 기본 orderBy 절을 정의함
		historyVO.setOrderColumn(!historyVO.getOrderColumn().equals("") ? historyVO.getOrderColumn() : "DEPT_ID");
		historyVO.setOrderType(!historyVO.getOrderType().equals("") ? historyVO.getOrderType() : "DESC");
	    
		// 최소페이징 목록 갯수는 context-properties.xml 에 정의된  개수이며, 사용자가 선택한 목록갯수가 0를 초과할 경우 사용자목록 갯수로 select한다.
		historyVO.setPageUnit(historyVO.getPageUnit() >= 0 ? historyVO.getPageUnit() : propertiesService.getInt("pageUnit") );
		historyVO.setPageSize(propertiesService.getInt("pageSize"));
		
		// pageing setting
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(historyVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(historyVO.getPageUnit());
		paginationInfo.setPageSize(historyVO.getPageSize());
		
		historyVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		historyVO.setLastIndex(paginationInfo.getLastRecordIndex());
		historyVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		List SysHistoryList = historyService.historyListSearch(historyVO);
		int totCnt = historyService.historyListTotCntSearch(historyVO);
		
		paginationInfo.setTotalRecordCount(totCnt);
		
		map.addAttribute("historyVO", historyVO);
		map.addAttribute("SysHistoryList", SysHistoryList);
		map.addAttribute("paginationInfo", paginationInfo);
				
		return "/sys/history/historyList";
	}
}
