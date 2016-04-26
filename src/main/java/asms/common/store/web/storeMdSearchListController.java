package asms.common.store.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import asms.common.Constants;
import asms.common.login.service.LoginUserVO;
import asms.common.store.service.StoreMdService;
import asms.common.store.service.StoreMdVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;


/**
 * @PackageName asms.common.store.web
 * @FileName storeMdSearchListController.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 26.
 */
@Controller
public class storeMdSearchListController {
	
	@Resource(name = "StoreMdService")
    protected StoreMdService storeMdService;
	
	/** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
	@RequestMapping("/common/store/storeMdSearchList.do")
	public String storeMdSearchList(@ModelAttribute("StoreMdVO")StoreMdVO storeMdVO, ModelMap map, HttpSession session) throws Exception{
		
		// 사용자 권한
		LoginUserVO loginUserVO = (LoginUserVO)session.getAttribute(Constants.LoginUserVO);
		storeMdVO.setUser_auth_cd(loginUserVO.getUser_auth_cd());
		
		// 기본 orderBy 절을 정의함
		storeMdVO.setOrderColumn(!storeMdVO.getOrderColumn().equals("") ? storeMdVO.getOrderColumn() : "ST_ID");
		storeMdVO.setOrderType(!storeMdVO.getOrderType().equals("") ? storeMdVO.getOrderType() : "DESC");
	    
		// 최소페이징 목록 갯수는 context-properties.xml 에 정의된  개수이며, 사용자가 선택한 목록갯수가 0를 초과할 경우 사용자목록 갯수로 select한다.
		storeMdVO.setPageUnit(storeMdVO.getPageUnit() >= 0 ? storeMdVO.getPageUnit() : propertiesService.getInt("pageUnit") );
		storeMdVO.setPageSize(propertiesService.getInt("pageSize"));
		
		// pageing setting
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(storeMdVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(storeMdVO.getPageUnit());
		paginationInfo.setPageSize(storeMdVO.getPageSize());
		
		storeMdVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		storeMdVO.setLastIndex(paginationInfo.getLastRecordIndex());
		storeMdVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		List storeMdList = storeMdService.storeMdListSearch(storeMdVO);
		int totCnt = storeMdService.storeMdListTotCntSearch(storeMdVO);
		
		paginationInfo.setTotalRecordCount(totCnt);
		
		map.addAttribute("storeMdVO", storeMdVO);
		map.addAttribute("storeMdList", storeMdList);
		map.addAttribute("paginationInfo", paginationInfo);
		
		return "/common/store/storeMdSearchList";
	}
}
