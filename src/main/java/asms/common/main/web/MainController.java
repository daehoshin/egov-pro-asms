package asms.common.main.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import asms.common.Constants;
import asms.common.main.service.MainService;
import asms.common.main.service.MenuVO;
import asms.common.login.service.LoginUserVO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @PackageName asms.common.main.web
 * @FileName MainController.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 3. 25.
 */
@Controller
@SessionAttributes({"menuList1","menuList2","menuList3"})
public class MainController {
	
	@Resource(name="MainService")
	private MainService mainService;
	
	@RequestMapping("/main.do")
	public String main(LoginUserVO loginUserVO, HttpSession session, ModelMap model) throws Exception {
		
		loginUserVO = (LoginUserVO)session.getAttribute(Constants.LoginUserVO);
		
		List menuList1 = mainService.selectMenuList_lv1(loginUserVO);
		List menuList2 = mainService.selectMenuList_lv2(loginUserVO);
		List menuList3 = mainService.selectMenuList_lv3(loginUserVO);
		
		model.addAttribute("menuList1", menuList1);
		model.addAttribute("menuList2", menuList2);
		model.addAttribute("menuList3", menuList3);
		
		return "/common/main";
	}
	
	@RequestMapping("/menuLoading.do")
	public String menuLoading(@ModelAttribute("MenuVO") MenuVO menuVO, HttpSession session, ModelMap model) throws Exception {
		
		List menuList2 = (List)session.getAttribute("menuList2");
		List menuList3 = (List)session.getAttribute("menuList3");
		
		String menu_conn_url = "";
		String menu_id = menuVO.getMenu_id();
		String menu_div_cd = menuVO.getMenu_div_cd();
		
		if("2".equals(menu_div_cd)){
			for (int i = 0; i < menuList2.size(); i++) {
				MenuVO menuMidleVO = (MenuVO) menuList2.get(i);
				if (menuMidleVO.getMenu_id().equals(menu_id)){
					menu_conn_url = menuMidleVO.getMenu_conn_url();
				}
			}
		} else if("3".equals(menu_div_cd)){
			for (int i = 0; i < menuList3.size(); i++) {
				MenuVO menuLastVO = (MenuVO) menuList3.get(i);
				if (menuLastVO.getMenu_id().equals(menu_id)){
					menu_conn_url = menuLastVO.getMenu_conn_url();
				}
			}
		}

		return  "forward:"+menu_conn_url;
	}
}
