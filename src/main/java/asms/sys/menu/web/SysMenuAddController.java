package asms.sys.menu.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import asms.common.Constants;
import asms.common.login.service.LoginUserVO;
import asms.common.util.DateUtils;
import asms.sys.department.service.DeptService;
import asms.sys.menu.service.MenuService;
import asms.sys.menu.service.MenuVO;

/**
 * @PackageName asms.sys.menu.web
 * @FileName SysMenuAddController.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 13.
 */
@Controller
public class SysMenuAddController {
	
	@Resource(name = "MenuService")
    protected MenuService menuService;
	
	@RequestMapping("/sys/menu/menuAddForm.do")
	public String SysMenuAddForm() throws Exception {
		
		return "/sys/menu/menuAdd";
	}

	@RequestMapping("/sys/menu/menuAddAction.do")
	public String SysMenuAddAction(@ModelAttribute("MenuVO")MenuVO menuVO, ModelMap map) throws Exception {
		
		String resultMsg = "";

		int result = menuService.menuAddAction(menuVO);
		
		if(result==1){
			resultMsg = "success";
		} else {
			resultMsg = "fail";
		}
		
		map.addAttribute("resultMsg", resultMsg);
		map.addAttribute("resultId", menuVO.getMenu_id());
		
		return "jsonView";
	}
}
