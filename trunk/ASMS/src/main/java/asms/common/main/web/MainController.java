package asms.common.main.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import asms.common.main.service.MainService;
import asms.common.login.service.LoginUserVO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"menuList1","menuList2","menuList3","menu_div_cd","topmenuid","menuid"})
public class MainController {
	
	@Resource(name="MainService")
	private MainService MainService;
	
	@RequestMapping("/main.do")
	public String main(LoginUserVO loginUserVO, HttpSession session, HttpServletResponse response, ModelMap model) throws Exception {
		
		loginUserVO = (LoginUserVO)session.getAttribute("LoginUser");
		
		List menuList1 = MainService.selectMenuList_lv1(loginUserVO);
		List menuList2 = MainService.selectMenuList_lv2(loginUserVO);
		List menuList3 = MainService.selectMenuList_lv3(loginUserVO);
		
		model.addAttribute("menuList1", menuList1);
		model.addAttribute("menuList2", menuList2);
		model.addAttribute("menuList3", menuList3);
		
		return "/common/mainConts";
	}
}
