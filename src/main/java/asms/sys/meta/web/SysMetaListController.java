package asms.sys.meta.web;

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
import asms.sys.meta.service.MetaService;
import asms.sys.meta.service.MetaVO;

@Controller
public class SysMetaListController {
	
	@Resource(name = "MetaService")
    protected MetaService metaService;
    
	/** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    
	@RequestMapping("/sys/meta/metaListSearch.do")
	public String SysMetaList(@ModelAttribute("MetaVO")MetaVO metaVO, HttpSession session, Model map) throws Exception{
		
		// 사용자 권한
		LoginUserVO loginUserVO = (LoginUserVO)session.getAttribute(Constants.LoginUserVO);
		metaVO.setUser_auth_cd(loginUserVO.getUser_auth_cd());
		
		// 기본 orderBy 절을 정의함
		metaVO.setOrderColumn(!metaVO.getOrderColumn().equals("") ? metaVO.getOrderColumn() : "DEPT_ID");
		metaVO.setOrderType(!metaVO.getOrderType().equals("") ? metaVO.getOrderType() : "DESC");
	    
		// 최소페이징 목록 갯수는 context-properties.xml 에 정의된  개수이며, 사용자가 선택한 목록갯수가 0를 초과할 경우 사용자목록 갯수로 select한다.
		metaVO.setPageUnit(metaVO.getPageUnit() >= 0 ? metaVO.getPageUnit() : propertiesService.getInt("pageUnit") );
		metaVO.setPageSize(propertiesService.getInt("pageSize"));
		
		// pageing setting
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(metaVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(metaVO.getPageUnit());
		paginationInfo.setPageSize(metaVO.getPageSize());
		
		metaVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		metaVO.setLastIndex(paginationInfo.getLastRecordIndex());
		metaVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		List SysMetaList = metaService.metaListSearch(metaVO);
		int totCnt = metaService.metaListTotCntSearch(metaVO);
		
		paginationInfo.setTotalRecordCount(totCnt);
		
		map.addAttribute("metaVO", metaVO);
		map.addAttribute("SysMetaList", SysMetaList);
		map.addAttribute("paginationInfo", paginationInfo);
				
		return "/sys/meta/metaList";
	}
}
