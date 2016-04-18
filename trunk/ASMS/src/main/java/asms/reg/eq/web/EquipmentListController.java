package asms.reg.eq.web;

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
import asms.reg.eq.service.EquipmentService;
import asms.reg.eq.service.EquipmentVO;

/**
 * @PackageName asms.reg.eq.web
 * @FileName EquipmentListController.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 18.
 */
@Controller
public class EquipmentListController {
	
    @Resource(name = "EquipmentService")
    protected EquipmentService equipmentService;
    
	/** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    
	@RequestMapping("/rgst/equipment/equipmentListSearch.do")
	public String EquipmentList(@ModelAttribute("EquipmentVO")EquipmentVO equipmentVO, HttpSession session, Model map) throws Exception{
		
		// 사용자 권한
		LoginUserVO loginUserVO = (LoginUserVO)session.getAttribute(Constants.LoginUserVO);
		equipmentVO.setUser_auth_cd(loginUserVO.getUser_auth_cd());
		
		// 기본 orderBy 절을 정의함
		equipmentVO.setOrderColumn(!equipmentVO.getOrderColumn().equals("") ? equipmentVO.getOrderColumn() : "EQM_ID");
		equipmentVO.setOrderType(!equipmentVO.getOrderType().equals("") ? equipmentVO.getOrderType() : "DESC");
	    
		// 최소페이징 목록 갯수는 context-properties.xml 에 정의된  개수이며, 사용자가 선택한 목록갯수가 0를 초과할 경우 사용자목록 갯수로 select한다.
		equipmentVO.setPageUnit(equipmentVO.getPageUnit() >= 0 ? equipmentVO.getPageUnit() : propertiesService.getInt("pageUnit") );
		equipmentVO.setPageSize(propertiesService.getInt("pageSize"));
		
		// pageing setting
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(equipmentVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(equipmentVO.getPageUnit());
		paginationInfo.setPageSize(equipmentVO.getPageSize());
		
		equipmentVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		equipmentVO.setLastIndex(paginationInfo.getLastRecordIndex());
		equipmentVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		List RegEquipmentList = equipmentService.equipmentListSearch(equipmentVO);
		int totCnt = equipmentService.equipmentListTotCntSearch(equipmentVO);
		
		paginationInfo.setTotalRecordCount(totCnt);
		
		map.addAttribute("equipmentVO", equipmentVO);
		map.addAttribute("RegEquipmentList", RegEquipmentList);
		map.addAttribute("paginationInfo", paginationInfo);
		
		return "/reg/equipment/EquipmentList";
	}
}
