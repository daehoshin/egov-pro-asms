package asms.sign.export.web;

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
import asms.sign.export.service.ExportEquipmentVO;
import asms.sign.export.service.ExportSearchVO;
import asms.sign.export.service.ExportService;
import asms.sign.export.service.ExportVO;

/**
 * @PackageName asms.sign.export.web
 * @FileName ExportDetailController.java
 * @Author Jinho Jung
 * @Since 2016. 4. 10.
 */
@Controller
public class ExportDetailController {
	
	@Resource(name = "ExportService")
    protected ExportService exportService;
	
	/** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
	@RequestMapping("/sign/export/exportDetail.do")
	public String exportDetail(@ModelAttribute("ExportVO")ExportVO exportVO, HttpSession session, Model map) throws Exception{
		exportVO = exportService.exportInfoSearch(exportVO);
		
		map.addAttribute("exportVO", exportVO);
		return "/sign/export/exportDetail";
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("/sign/export/exportEquipmentListSearch.do")
	public String exportEquipmentListSearch(@ModelAttribute("ExportEquipmentVO")ExportEquipmentVO exportEquipmentVO, HttpSession session, Model map) throws Exception{
		
		// 기본 orderBy 절을 정의함
		exportEquipmentVO.setOrderColumn(!exportEquipmentVO.getOrderColumn().equals("") ? exportEquipmentVO.getOrderColumn() : "APP_ID");
		exportEquipmentVO.setOrderType(!exportEquipmentVO.getOrderType().equals("") ? exportEquipmentVO.getOrderType() : "DESC");
	    
		// 최소페이징 목록 갯수는 context-properties.xml 에 정의된  개수이며, 사용자가 선택한 목록갯수가 0를 초과할 경우 사용자목록 갯수로 select한다.
		exportEquipmentVO.setPageUnit(exportEquipmentVO.getPageUnit() >= 0 ? exportEquipmentVO.getPageUnit() : propertiesService.getInt("pageUnit") );
		exportEquipmentVO.setPageSize(propertiesService.getInt("pageSize"));
		
		// pageing setting
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(exportEquipmentVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(exportEquipmentVO.getPageUnit());
		paginationInfo.setPageSize(exportEquipmentVO.getPageSize());
		
		exportEquipmentVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		exportEquipmentVO.setLastIndex(paginationInfo.getLastRecordIndex());
		exportEquipmentVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		List exportEquimpentList = exportService.exportEquipmentListSearch(exportEquipmentVO);
		int totCnt = exportService.exportEquipmentListTotCntSearch(exportEquipmentVO);

		paginationInfo.setTotalRecordCount(totCnt);
		
		map.addAttribute("exportEquipmentVO", exportEquipmentVO);
		map.addAttribute("exportEquipmentList", exportEquimpentList);
		map.addAttribute("paginationInfo", paginationInfo);
		
		return "/sign/export/exportEquipmentList";
	}
}
