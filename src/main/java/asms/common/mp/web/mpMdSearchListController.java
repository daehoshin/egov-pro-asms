package asms.common.mp.web;

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
import asms.common.mp.service.MpMdService;
import asms.common.mp.service.MpMdVO;
import asms.common.login.service.LoginUserVO;

/**
 * @PackageName asms.common.mp.web
 * @FileName mpMdSearchListController.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 26.
 */
@Controller
public class mpMdSearchListController {
	
	@Resource(name = "MpMdService")
    protected MpMdService mpMdService;
	
	/** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
	@RequestMapping("/common/mp/mpMdSearchList.do")
	public String mpMdSearchList(@ModelAttribute("MpMdVO")MpMdVO mpMdVO, ModelMap map, HttpSession session) throws Exception{
		
		// 사용자 권한
		LoginUserVO loginUserVO = (LoginUserVO)session.getAttribute(Constants.LoginUserVO);
		mpMdVO.setUser_auth_cd(loginUserVO.getUser_auth_cd());
		
		// 기본 orderBy 절을 정의함
		mpMdVO.setOrderColumn(!mpMdVO.getOrderColumn().equals("") ? mpMdVO.getOrderColumn() : "MP_ID");
		mpMdVO.setOrderType(!mpMdVO.getOrderType().equals("") ? mpMdVO.getOrderType() : "DESC");
	    
		// 최소페이징 목록 갯수는 context-properties.xml 에 정의된  개수이며, 사용자가 선택한 목록갯수가 0를 초과할 경우 사용자목록 갯수로 select한다.
		mpMdVO.setPageUnit(mpMdVO.getPageUnit() >= 0 ? mpMdVO.getPageUnit() : propertiesService.getInt("pageUnit") );
		mpMdVO.setPageSize(propertiesService.getInt("pageSize"));
		
		// pageing setting
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(mpMdVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(mpMdVO.getPageUnit());
		paginationInfo.setPageSize(mpMdVO.getPageSize());
		
		mpMdVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		mpMdVO.setLastIndex(paginationInfo.getLastRecordIndex());
		mpMdVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		List mpMdList = mpMdService.mpMdListSearch(mpMdVO);
		int totCnt = mpMdService.mpMdListTotCntSearch(mpMdVO);
		
		paginationInfo.setTotalRecordCount(totCnt);
		
		map.addAttribute("mpMdVO", mpMdVO);
		map.addAttribute("mpMdList", mpMdList);
		map.addAttribute("paginationInfo", paginationInfo);
		
		return "/common/mp/mpMdSearchList";
	}
}
