package asms.sys.code.web;

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
import asms.sys.code.service.CodeService;
import asms.sys.code.service.CodeVO;

@Controller
public class SysCodeListController {
	
	@Resource(name = "CodeService")
    protected CodeService codeService;
    
	/** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    
	@RequestMapping("/sys/code/codeListSearch.do")
	public String SysCodeList(@ModelAttribute("CodeVO")CodeVO codeVO, HttpSession session, Model map) throws Exception{
		
		// 사용자 권한
		LoginUserVO loginUserVO = (LoginUserVO)session.getAttribute(Constants.LoginUserVO);
		codeVO.setUser_auth_cd(loginUserVO.getUser_auth_cd());
		
		// 기본 orderBy 절을 정의함
		codeVO.setOrderColumn(!codeVO.getOrderColumn().equals("") ? codeVO.getOrderColumn() : "DEPT_ID");
		codeVO.setOrderType(!codeVO.getOrderType().equals("") ? codeVO.getOrderType() : "DESC");
	    
		// 최소페이징 목록 갯수는 context-properties.xml 에 정의된  개수이며, 사용자가 선택한 목록갯수가 0를 초과할 경우 사용자목록 갯수로 select한다.
		codeVO.setPageUnit(codeVO.getPageUnit() >= 0 ? codeVO.getPageUnit() : propertiesService.getInt("pageUnit") );
		codeVO.setPageSize(propertiesService.getInt("pageSize"));
		
		// pageing setting
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(codeVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(codeVO.getPageUnit());
		paginationInfo.setPageSize(codeVO.getPageSize());
		
		codeVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		codeVO.setLastIndex(paginationInfo.getLastRecordIndex());
		codeVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		List SysCodeList = codeService.codeListSearch(codeVO);
		int totCnt = codeService.codeListTotCntSearch(codeVO);
		
		paginationInfo.setTotalRecordCount(totCnt);
		
		map.addAttribute("codeVO", codeVO);
		map.addAttribute("SysCodeList", SysCodeList);
		map.addAttribute("paginationInfo", paginationInfo);
				
		return "/sys/code/codeList";
	}
}
