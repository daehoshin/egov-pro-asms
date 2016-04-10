package asms.sign.export.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import asms.common.Constants;
import asms.common.login.service.LoginUserVO;
import asms.sign.export.service.ExportSearchVO;
import asms.sign.export.service.ExportService;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * @PackageName asms.sign.export.web
 * @FileName ExportListController.java
 * @Author Jinho Jung
 * @Since 2016. 4. 09.
 */
@Controller
public class ExportListController {
	
    @Resource(name = "ExportService")
    protected ExportService exportService;
    
	/** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    
	@SuppressWarnings("rawtypes")
	@RequestMapping("/sign/export/exportListSearch.do")
	public String exportListSearch(@ModelAttribute("ExportSearchVO")ExportSearchVO exportSearchVO, HttpSession session, Model map) throws Exception{
		// 사용자 권한
		LoginUserVO loginUserVO = (LoginUserVO)session.getAttribute(Constants.LoginUserVO);
		exportSearchVO.setUser_auth_cd(loginUserVO.getUser_auth_cd());
		exportSearchVO.setReg_id(loginUserVO.getMp_id());
		
		// 기본 orderBy 절을 정의함
		exportSearchVO.setOrderColumn(!exportSearchVO.getOrderColumn().equals("") ? exportSearchVO.getOrderColumn() : "APP_ID");
		exportSearchVO.setOrderType(!exportSearchVO.getOrderType().equals("") ? exportSearchVO.getOrderType() : "DESC");
	    
		// 최소페이징 목록 갯수는 context-properties.xml 에 정의된  개수이며, 사용자가 선택한 목록갯수가 0를 초과할 경우 사용자목록 갯수로 select한다.
		exportSearchVO.setPageUnit(exportSearchVO.getPageUnit() >= 0 ? exportSearchVO.getPageUnit() : propertiesService.getInt("pageUnit") );
		exportSearchVO.setPageSize(propertiesService.getInt("pageSize"));
		
		// pageing setting
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(exportSearchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(exportSearchVO.getPageUnit());
		paginationInfo.setPageSize(exportSearchVO.getPageSize());
		
		exportSearchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		exportSearchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		exportSearchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		List exportList = exportService.exportListSearch(exportSearchVO);
		int totCnt = exportService.exportListTotCntSearch(exportSearchVO);
		System.out.println("exportList length : " + exportList.size());
		paginationInfo.setTotalRecordCount(totCnt);
		
		map.addAttribute("exportVO", exportSearchVO);
		map.addAttribute("exportList", exportList);
		map.addAttribute("paginationInfo", paginationInfo);
		
		return "/sign/export/exportList";
	}
}
