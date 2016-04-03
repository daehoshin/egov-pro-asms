package asms.reg.plc.web;

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
import asms.reg.plc.service.PlaceService;
import asms.reg.plc.service.PlaceVO;

/**
 * @PackageName asms.reg.plc.web
 * @FileName RegPlaceListController.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 3. 26.
 */
@Controller
public class PlaceListController {
	
    @Resource(name = "PlaceService")
    protected PlaceService placeService;
    
	/** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    
	@RequestMapping("/rgst/place/placeListSearch.do")
	public String PlaceList(@ModelAttribute("PlaceVO")PlaceVO placeVO, HttpSession session, Model map) throws Exception{
		
		// 사용자 권한
		LoginUserVO loginUserVO = (LoginUserVO)session.getAttribute(Constants.LoginUserVO);
		placeVO.setUser_auth_cd(loginUserVO.getUser_auth_cd());
		
		// 기본 orderBy 절을 정의함
		placeVO.setOrderColumn(!placeVO.getOrderColumn().equals("") ? placeVO.getOrderColumn() : "PLC_ID");
		placeVO.setOrderType(!placeVO.getOrderType().equals("") ? placeVO.getOrderType() : "DESC");
	    
		// 최소페이징 목록 갯수는 context-properties.xml 에 정의된  개수이며, 사용자가 선택한 목록갯수가 0를 초과할 경우 사용자목록 갯수로 select한다.
		placeVO.setPageUnit(placeVO.getPageUnit() >= 0 ? placeVO.getPageUnit() : propertiesService.getInt("pageUnit") );
		placeVO.setPageSize(propertiesService.getInt("pageSize"));
		
		// pageing setting
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(placeVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(placeVO.getPageUnit());
		paginationInfo.setPageSize(placeVO.getPageSize());
		
		placeVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		placeVO.setLastIndex(paginationInfo.getLastRecordIndex());
		placeVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		List RegPlaceList = placeService.placeListSearch(placeVO);
		int totCnt = placeService.placeListTotCntSearch(placeVO);
		
		paginationInfo.setTotalRecordCount(totCnt);
		
		map.addAttribute("placeVO", placeVO);
		map.addAttribute("RegPlaceList", RegPlaceList);
		map.addAttribute("paginationInfo", paginationInfo);
		
		return "/reg/place/PlaceList";
	}
}
