package asms.sys.menu.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import asms.common.Constants;
import asms.common.login.service.LoginUserVO;
import asms.sys.menu.service.MenuService;
import asms.sys.menu.service.MenuVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * @PackageName asms.sys.menu.web
 * @FileName SysMenuListController.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 13.
 */
@Controller
public class SysMenuListController {
	@Resource(name = "MenuService")
    protected MenuService menuService;
    
	/** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    
	@RequestMapping("/sys/menu/menuListSearch.do")
	public String SysMenuList(@ModelAttribute("MenuVO")MenuVO menuVO, HttpSession session, Model map) throws Exception{
		
		// 사용자 권한
		LoginUserVO loginUserVO = (LoginUserVO)session.getAttribute(Constants.LoginUserVO);
		menuVO.setUser_auth_cd(loginUserVO.getUser_auth_cd());
		
		// 기본 orderBy 절을 정의함
		menuVO.setOrderColumn(!menuVO.getOrderColumn().equals("") ? menuVO.getOrderColumn() : "MENU_GRP_ID");
		menuVO.setOrderType(!menuVO.getOrderType().equals("") ? menuVO.getOrderType() : "DESC");
	    
		// 최소페이징 목록 갯수는 context-properties.xml 에 정의된  개수이며, 사용자가 선택한 목록갯수가 0를 초과할 경우 사용자목록 갯수로 select한다.
		menuVO.setPageUnit(menuVO.getPageUnit() >= 0 ? menuVO.getPageUnit() : propertiesService.getInt("pageUnit") );
		menuVO.setPageSize(propertiesService.getInt("pageSize"));
		
		// pageing setting
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(menuVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(menuVO.getPageUnit());
		paginationInfo.setPageSize(menuVO.getPageSize());
		
		menuVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		menuVO.setLastIndex(paginationInfo.getLastRecordIndex());
		menuVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		List SysMenuList = menuService.menuListSearch(menuVO);
		int totCnt = menuService.menuListTotCntSearch(menuVO);
		
		paginationInfo.setTotalRecordCount(totCnt);
		
		map.addAttribute("menuVO", menuVO);
		map.addAttribute("SysMenuList", SysMenuList);
		map.addAttribute("paginationInfo", paginationInfo);
				
		return "/sys/menu/menuList";
	}
}
