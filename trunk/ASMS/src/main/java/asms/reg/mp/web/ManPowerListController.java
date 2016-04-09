package asms.reg.mp.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import asms.common.Constants;
import asms.common.login.service.LoginUserVO;
import asms.reg.mp.service.ManPowerService;
import asms.reg.mp.service.ManPowerVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * @PackageName asms.reg.mp.web
 * @FileName RegManPowerListController.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 9.
 */
@Controller
public class ManPowerListController {
	@Resource(name = "ManPowerService")
    protected ManPowerService manPowerService;
    
	/** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    
	@RequestMapping("/reg/manpower/manPowerListSearch.do")
	public String ManPowerList(@ModelAttribute("ManPowerVO")ManPowerVO manPowerVO, HttpSession session, Model map) throws Exception{
		
		// 사용자 권한
		LoginUserVO loginUserVO = (LoginUserVO)session.getAttribute(Constants.LoginUserVO);
		manPowerVO.setUser_auth_cd(loginUserVO.getUser_auth_cd());
		
		// 기본 orderBy 절을 정의함
		manPowerVO.setOrderColumn(!manPowerVO.getOrderColumn().equals("") ? manPowerVO.getOrderColumn() : "MP_ID");
		manPowerVO.setOrderType(!manPowerVO.getOrderType().equals("") ? manPowerVO.getOrderType() : "DESC");
	    
		// 최소페이징 목록 갯수는 context-properties.xml 에 정의된  개수이며, 사용자가 선택한 목록갯수가 0를 초과할 경우 사용자목록 갯수로 select한다.
		manPowerVO.setPageUnit(manPowerVO.getPageUnit() >= 0 ? manPowerVO.getPageUnit() : propertiesService.getInt("pageUnit") );
		manPowerVO.setPageSize(propertiesService.getInt("pageSize"));
		
		// pageing setting
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(manPowerVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(manPowerVO.getPageUnit());
		paginationInfo.setPageSize(manPowerVO.getPageSize());
		
		manPowerVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		manPowerVO.setLastIndex(paginationInfo.getLastRecordIndex());
		manPowerVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		List RegManPowerList = manPowerService.manPowerListSearch(manPowerVO);
		int totCnt = manPowerService.manPowerListTotCntSearch(manPowerVO);
		
		paginationInfo.setTotalRecordCount(totCnt);
		
		map.addAttribute("manPowerVO", manPowerVO);
		map.addAttribute("RegManPowerList", RegManPowerList);
		map.addAttribute("paginationInfo", paginationInfo);
		
		return "/reg/manpower/ManPowerList";
	}
}
